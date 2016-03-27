package com.nightwind.bbs.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.nightwind.bbs.domain.Mail;
import com.nightwind.bbs.domain.User;
import com.nightwind.bbs.exception.NoLoginException;
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
		System.out.println(mails);
		mav.addObject("mails", mails);
		
		return mav;
	}
}
