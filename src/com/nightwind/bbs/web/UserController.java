package com.nightwind.bbs.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nightwind.bbs.domain.User;
import com.nightwind.bbs.service.UserService;
import com.nightwind.bbs.exception.UserNotFoundException;

@SessionAttributes("crtUser")
@Controller("UserController")
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = {"", "/"}, method= RequestMethod.GET)
	public String index(ModelMap model) throws UserNotFoundException {
		User user = (User) model.get("crtUser");
		if (user != null && user.getId() != null) {
			return "redirect:/user/" + user.getId();
		} else {
			throw new UserNotFoundException();
		}
	}

	@RequestMapping(value = {"/{id}"}, method = RequestMethod.GET)
	public ModelAndView info(@PathVariable(value = "id")  Integer id, ModelMap model) throws UserNotFoundException {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("user", userService.findUserById(id));
		
		mav.setViewName("user/info.jsp");
		return mav;
	}
	

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public ModelAndView displayUpdateInfo(User user, ModelMap model) {
		ModelAndView mav = new ModelAndView("user/update.jsp");
		
		User crtUser = (User) model.get("crtUser");
		System.out.println("crtUser: " + crtUser);
		System.out.println("user: " + user);
		if (crtUser == null) {
			// not login
			mav.setViewName("redirect:/auth/login");
			return mav;
		}
		if (user.getEmail() == null || user.getEmail().length() == 0) {
			user.setEmail(crtUser.getEmail());
		}
		if (user.getSignature() == null || user.getEmail().length() == 0) {
			user.setSignature(crtUser.getSignature());
		}
		mav.addObject("userForm", user);
		return mav;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView updateInfo(@Valid @ModelAttribute("userForm") User user,
			BindingResult result, ModelMap model, RedirectAttributes redirectAttributes) throws UserNotFoundException {
		ModelAndView mav = new ModelAndView("user/update.jsp");

		User crtUser = (User) model.get("crtUser");
		if (crtUser == null) {
			// not login
			mav.setViewName("redirect:/auth/login");
		}
		
		for (FieldError err: result.getFieldErrors()) {
			if (!err.getField().equals("username") || !err.getField().equals("password")) {
				redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userForm", result);
				return mav;
			}
		}

		user.setId(crtUser.getId());
		crtUser = userService.updateInfo(user);
		mav.addObject("crtUser", crtUser);
		mav.addObject("message", "update success");

		
		return mav;
	}
}
