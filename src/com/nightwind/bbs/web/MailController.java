package com.nightwind.bbs.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nightwind.bbs.domain.Mail;
import com.nightwind.bbs.domain.User;
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

		Mail mail = new Mail();
		User reciver = new User();
		reciver.setUsername(recvUsername);
		mail.setReciver(reciver);
		mav.addObject("mailForm", mail);
		
		return mav;
	}
	
	@RequestMapping(value = {"/send"}, method={RequestMethod.POST})
	public ModelAndView sender(@Valid @ModelAttribute("mailForm") Mail mailForm, BindingResult bindingResult, 
			RedirectAttributes redirectAttributes, ModelMap model) throws NoLoginException, UserNotFoundException {
		ModelAndView mav = new ModelAndView("redirect:/mail/send");

		// login need
		User crtUser = Utils.getCrtUser(model);
		if (crtUser == null) {
			throw new NoLoginException();
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
}
