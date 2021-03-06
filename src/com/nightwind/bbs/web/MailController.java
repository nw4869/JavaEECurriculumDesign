package com.nightwind.bbs.web;

import java.util.List;

import javax.security.sasl.AuthenticationException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nightwind.bbs.domain.Mail;
import com.nightwind.bbs.domain.User;
import com.nightwind.bbs.exception.AuthorizeException;
import com.nightwind.bbs.exception.MailNotFoundException;
import com.nightwind.bbs.exception.MailReciverValidateException;
import com.nightwind.bbs.exception.NoLoginException;
import com.nightwind.bbs.exception.UserNotFoundException;
import com.nightwind.bbs.service.MailService;

@SessionAttributes("crtUser")
@Controller("MailController")
@RequestMapping(value = "/mail")
public class MailController {
	
	@Autowired
	private MailService mailService;

	@RequestMapping(value = {"", "/"})
	public ModelAndView inbox(ModelMap model) throws NoLoginException {
		ModelAndView mav = new ModelAndView("mail/inbox.jsp");

		// login need
		User crtUser = Utils.getCrtUser(model);
		if (crtUser == null) {
			throw new NoLoginException();
		}

		List<Mail> mails = mailService.findMailsForReciver(crtUser.getId(), -1, -1);
		mav.addObject("mails", mails);
		
		return mav;
	}
	
	@RequestMapping(value = {"/sent"})
	public ModelAndView sentBox(ModelMap model) throws NoLoginException {
		ModelAndView mav = new ModelAndView("mail/sentBox.jsp");

		// login need
		User crtUser = Utils.getCrtUser(model);
		if (crtUser == null) {
			throw new NoLoginException();
		}

		List<Mail> mails = mailService.findMailsForSender(crtUser.getId(), -1, -1);
		mav.addObject("mails", mails);
		
		return mav;
	}

	
	@RequestMapping(value = {"/send"}, method={RequestMethod.GET})
	public ModelAndView displaySender(ModelMap model, @RequestParam(value="reciver", required=false) String recvUsername) throws NoLoginException {
		ModelAndView mav = new ModelAndView("mail/send_mail.jsp");

		// login need
		User crtUser = Utils.getCrtUser(model);
		if (crtUser == null) {
			throw new NoLoginException();
		}

		Mail mail = (Mail) model.get("mailForm");
		if (mail == null) {
			mail = new Mail();	
		}
		User reciver = new User();
		reciver.setUsername(recvUsername);
		mail.setReciver(reciver);
		mav.addObject("mailForm", mail);
		
		return mav;
	}
	
	@RequestMapping(value = {"/send"}, method={RequestMethod.POST})
	public ModelAndView sender(@Valid @ModelAttribute("mailForm") Mail mailForm, BindingResult bindingResult, 
			RedirectAttributes redirectAttributes, ModelMap model) throws NoLoginException, UserNotFoundException, MailReciverValidateException {
		ModelAndView mav = new ModelAndView("redirect:/mail/sent");

		// login need
		User crtUser = Utils.getCrtUser(model);
		if (crtUser == null) {
			throw new NoLoginException();
		}

		if (!Utils.isNotBlank(mailForm.getReciver().getUsername()) || 
				crtUser.getUsername().equals(mailForm.getReciver().getUsername())) {
			bindingResult.rejectValue("reciver.username", "reciver.username", "收件人错误");
		}
		
		if (bindingResult.hasErrors()) {
			redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.mailForm", bindingResult);
			redirectAttributes.addFlashAttribute("mailForm", mailForm);
			return mav;
		}
		
		mailService.sendMail(crtUser.getId(), mailForm.getReciver().getUsername(), mailForm.getTitle(), mailForm.getContent());
		
		redirectAttributes.addFlashAttribute("message", "mail sent");
		
		return mav;
	}
	
	@RequestMapping(value="/{id}")
	public ModelAndView readMail(ModelMap model, @PathVariable("id")Integer id) throws NoLoginException, AuthorizeException, MailNotFoundException {
		ModelAndView mav = new ModelAndView("mail/read_mail.jsp");

		// login need
		User crtUser = Utils.getCrtUser(model);
		if (crtUser == null) {
			throw new NoLoginException();
		}

		Mail mail = mailService.findMailByPrimaryKey(id);
		if (mail == null) {
			throw new MailNotFoundException();
		}
		
		if (!(mail.getReciver().getId().equals(crtUser.getId()) ||
				mail.getSender().getId().equals(crtUser.getId()))) {
			throw new AuthorizeException();
		}
		
		Mail mailForm = (Mail) model.get("mailForm");
		if (mailForm == null) {
			mailForm = new Mail();
			mailForm.setReciver(mail.getSender());
		}
		mav.addObject("mailForm", mailForm);
		
		mav.addObject("mail", mail);
		
		// 设置已读
		if (mail.getReciver().getId().equals(crtUser.getId())) {
			mailService.setRead(mail.getId(), true);
		}
		
		return mav;
	}
	
	@RequestMapping(value="/{id}/delete")
	public String delete(@PathVariable Integer id, @RequestHeader(value = "referer") String referer,
			RedirectAttributes redirectAttributes, ModelMap model) throws MailNotFoundException, NoLoginException, AuthorizeException {
		Mail mail = mailService.findMailByPrimaryKey(id);
		if (mail == null) {
			throw new MailNotFoundException();
		}
		
		// check login
		User crtUser = (User) model.get("crtUser");
		if (crtUser == null) {
			throw new NoLoginException();
		}
		
		if (!(crtUser.getId().equals(mail.getSender().getId()) || crtUser.getId().equals(mail.getReciver().getId()))) {
			throw new AuthorizeException();
		}
		
		mailService.deleteMail(id);

		redirectAttributes.addFlashAttribute("message", "delete topic suceess");
		return "redirect:/mail";
	}
}
