package com.nightwind.bbs.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.nightwind.bbs.domain.User;
import com.nightwind.bbs.exception.AuthorizeException;
import com.nightwind.bbs.service.AuthService;
import com.nightwind.bbs.service.UserService;

@SessionAttributes("crtUser")
@Controller("AdminController")
@RequestMapping(value = "/admin")
public class AdminController {

	@Autowired
	private AuthService authService;
	
	@Autowired
	private UserService userService;
	
	protected void checkAuthority(ModelMap model) throws AuthorizeException {
		if (authService.isAdmin(Utils.getCrtUserId(model)) == false) {
			throw new AuthorizeException();
		}
	}
	
	@RequestMapping(value={"", "/"})
	public ModelAndView index(ModelMap model) throws AuthorizeException {
		ModelAndView mav = new ModelAndView("/admin/index.jsp");

		return mav;
	}
	
	@RequestMapping(value="/user")
	public ModelAndView userManager(ModelMap model, @ModelAttribute("userForm") User userForm,
			@RequestParam(value="page", required=false) Integer page,
			@RequestParam(value="maxRows", required=false) Integer maxRows) throws AuthorizeException {
		ModelAndView mav = new ModelAndView("/admin/user.jsp");
		System.out.println(userForm);
		checkAuthority(model);
		
		// setup page and page count
		if (page == null) {
			page = 1;
		}
		if (maxRows == null) {
			maxRows = 10;
		}

		int startResult = (page - 1) * maxRows;
		List<User> users = userService.findUsersLike(userForm, startResult, maxRows);
		mav.addObject("users", users);
		
		mav.addObject("pageCount", userService.countUsersLike(userForm) / maxRows + 1);
		mav.addObject("page", page);
		mav.addObject("maxRows", maxRows);
		mav.addObject("userForm", userForm);
		
		return mav;
	}
	
	@RequestMapping(value="/topic")
	public ModelAndView topicManager(ModelMap model) throws AuthorizeException {
		checkAuthority(model);
		
		ModelAndView mav = new ModelAndView("/admin/topic.jsp");

		// TODO
		
		return mav;
	}

	@RequestMapping(value="/forum")
	public ModelAndView forumManager(ModelMap model) throws AuthorizeException {
		checkAuthority(model);
		
		ModelAndView mav = new ModelAndView("/admin/forum.jsp");

		// TODO
		
		return mav;
	}

	@RequestMapping(value="/reply")
	public ModelAndView replyManager(ModelMap model) throws AuthorizeException {
		checkAuthority(model);
		
		ModelAndView mav = new ModelAndView("/admin/reply.jsp");

		// TODO
		
		return mav;
	}

	@RequestMapping(value="/mail")
	public ModelAndView mailManager(ModelMap model) throws AuthorizeException {
		checkAuthority(model);
		
		ModelAndView mav = new ModelAndView("/admin/mail.jsp");

		// TODO
		
		return mav;
	}
}
