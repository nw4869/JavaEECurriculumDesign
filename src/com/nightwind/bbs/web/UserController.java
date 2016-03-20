package com.nightwind.bbs.web;

import javax.validation.Valid;

import org.apache.velocity.exception.ResourceNotFoundException;
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

import com.nightwind.bbs.domain.User;
import com.nightwind.bbs.service.UserServiceEx;
import com.nightwind.exception.AccountExistedException;
import com.nightwind.exception.UserNotFoundException;

@SessionAttributes("crtUser")
@Controller("UserController")
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private UserServiceEx userServiceEx;

	@RequestMapping(value = "/info.do", method = RequestMethod.GET)
	public ModelAndView info(@RequestParam(required=false) Integer id, ModelMap model) {
		ModelAndView mav = new ModelAndView();
		
		User user = (User) model.get("crtUser");
		if (id == null) {
			if (user == null) {
				throw new ResourceNotFoundException("User not found");
			} else {
				id = user.getId();
			}
		} 
		
		try {
			mav.addObject("user", userServiceEx.findUserById(id));
		} catch (UserNotFoundException e) {
			throw new ResourceNotFoundException("User not found"); 
		}
		
		mav.setViewName("user/info.jsp");
		return mav;
	}
	

	@RequestMapping(value = "/update.do", method = RequestMethod.GET)
	public ModelAndView displayUpdateInfo(User user, ModelMap model) {
		ModelAndView mav = new ModelAndView("user/update.jsp");
		
		User crtUser = (User) model.get("crtUser");
		System.out.println("crtUser: " + crtUser);
		System.out.println("user: " + user);
		if (crtUser == null) {
			// not login
			mav.setViewName("redirect:/auth/login.do");
		}
		if (user.getEmail() == null || user.getEmail().length() == 0) {
			user.setEmail(crtUser.getEmail());
		}
		if (user.getSignature() == null || user.getEmail().length() == 0) {
			user.setEmail(crtUser.getSignature());
		}
		mav.addObject("userForm", user);
		return mav;
	}

	@RequestMapping(value = "/update.do", method = RequestMethod.POST)
	public ModelAndView updateInfo(@Valid @ModelAttribute("userForm") User user,
			BindingResult result, ModelMap model) throws AccountExistedException {
		ModelAndView mav = new ModelAndView("user/update.jsp");

		User crtUser = (User) model.get("crtUser");
		if (crtUser == null) {
			// not login
			mav.setViewName("redirect:/auth/login.do");
		}
		
		if (result.hasErrors()) {
			return mav;
		}

		try {
			user.setId(crtUser.getId());
			userServiceEx.updateInfo(user);
			mav.addObject("message", "update success");
		} catch (UserNotFoundException e) {
			throw new ResourceNotFoundException("User not found");
		}
		
		return mav;
	}
}
