package com.nightwind.bbs.web;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.nightwind.bbs.domain.User;
import com.nightwind.bbs.service.UserServiceEx;
import com.nightwind.exception.AccountExistedException;
import com.nightwind.exception.AuthorizeException;
import com.nightwind.exception.UserNotFoundException;

/**
 * 
 * @generated
 */
@SessionAttributes("crtUser")
@Controller("AuthController")
@RequestMapping(value = "/auth")
public class AuthController {

	@Autowired
	private UserServiceEx userServiceEx;

	@RequestMapping(value = "/login.do", method = { RequestMethod.GET })
	public ModelAndView displayLogin(User user, ModelMap model) {
		ModelAndView mav = new ModelAndView();
		if (model.get("crtUser") != null) {
			mav.setViewName("redirect:../index.jsp");
		} else {
			mav.setViewName("auth/login.jsp");
			mav.addObject("userForm", user);	
		}
		return mav;
	}

	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public ModelAndView login(@Valid @ModelAttribute("userForm") User user,
			BindingResult bindingResult, ModelMap model) {
		ModelAndView mav = new ModelAndView();
		
		System.out.println("result: " + bindingResult);
		
		if (bindingResult.hasErrors()) {
			mav.setViewName("auth/login.jsp");
			return mav;
		}

		try {
			user = userServiceEx.login(user.getUsername(), user.getPassword());
			mav.addObject("crtUser", user);
			mav.setViewName("auth/login-success.jsp");
		} catch (AuthorizeException e) {
			bindingResult.rejectValue("password","auth.wrongPassword", "wrong password!");
			mav.setViewName("auth/login.jsp");
		} catch (UserNotFoundException e) {
			bindingResult.rejectValue("username","auth.userNotFound", "user not found!");
			mav.setViewName("auth/login.jsp");
		}

		return mav;
	}

	@RequestMapping(value="logout.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView logout(@RequestHeader(value = "referer") String referer, SessionStatus sessionStatus) {
		ModelAndView mav = new ModelAndView("auth/logout-success.jsp");
		mav.addObject("referer", referer);
		mav.addObject("crtUser", null);
		sessionStatus.setComplete();
		return mav;
	}
	
	@RequestMapping(value="/register.do", method=RequestMethod.GET)
	public ModelAndView displayRegister(User user, ModelMap model)
	{
		ModelAndView mav = new ModelAndView();
		if (model.get("crtUser") != null) {
			mav.setViewName("redirect:../index.jsp");
		} else {
			mav.addObject("userForm", user);
			mav.setViewName("auth/register.jsp");
		}
		return mav;
	}

	@RequestMapping(value = "/register.do", method = RequestMethod.POST)
	public ModelAndView register(@Valid @ModelAttribute("userForm") User user,
			BindingResult result, Model model) {
		ModelAndView mav = new ModelAndView();
		
		try {
			user = userServiceEx.register(user.getUsername(), user.getPassword());
			mav.addObject("crtUser", user);
			mav.setViewName("auth/register-success.jsp");
		} catch (AccountExistedException e) {
			result.rejectValue("username", "userExisting", "user existing");
			mav.setViewName("auth/register.jsp");
		}
		
		return mav;
	}
	
}