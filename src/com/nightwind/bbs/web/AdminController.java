package com.nightwind.bbs.web;

import java.io.OutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;










import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.util.JsonGeneratorDelegate;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.nightwind.bbs.domain.Authority;
import com.nightwind.bbs.domain.User;
import com.nightwind.bbs.exception.AuthorizeException;
import com.nightwind.bbs.exception.UserNotFoundException;
import com.nightwind.bbs.service.AuthService;
import com.nightwind.bbs.service.ForumService;
import com.nightwind.bbs.service.UserService;

@SessionAttributes("crtUser")
@Controller("AdminController")
@RequestMapping(value = "/admin")
public class AdminController {

	@Autowired
	private AuthService authService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ForumService forumService;
	
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
//		System.out.println(userForm);
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
		
		mav.addObject("forums", forumService.findAllForums(-1, -1));
		
		mav.addObject("pageCount", userService.countUsersLike(userForm) / maxRows + 1);
		mav.addObject("page", page);
		mav.addObject("maxRows", maxRows);
		mav.addObject("userForm", userForm);
		
		return mav;
	}

	
	@RequestMapping(value="/user/{id:\\d+}/setStatus")
	public ModelAndView setStatus(@RequestParam("enable") Boolean enable, ModelMap model, RedirectAttributes redirectAttributes, 
			@RequestHeader(value = "referer") String referer, @PathVariable("id")Integer id) throws AuthorizeException, UserNotFoundException {
		checkAuthority(model);

		User user = userService.findUserById(id);
		
		userService.setSataus(id, enable);
		
		ModelAndView mav = new ModelAndView("redirect:" + referer);
		redirectAttributes.addFlashAttribute("message", "update " + user.getUsername() + " status success");
		
		return mav;
	}
	
	@RequestMapping(value="/user/{id:\\d+}/role")
	public @ResponseBody String setAuthority(@PathVariable("id")Integer userId, String role, 
			@RequestParam(value="forumIds[]", required=false)Integer[] forumIds) throws JsonProcessingException {
		boolean success = true; 
		try {
			userService.findUserById(userId);
			
			if (role.equals("ROLE_ADMIN")) {
				authService.setAdmin(userId, true);
			} else if (role.equals("ROLE_USER")) {
				authService.setAdmin(userId, false);
			} else if (role.equals("ROLE_FORUM_ADMIN")) {
				if (forumIds == null) {
					success = false;
				} else {
					authService.setForumsAdmin(forumIds, userId);	
				}
			}
		} catch (Exception e) {
			success = false;
		}

		return success ? "success" : "failed";
	}
	
	@RequestMapping(value="/topic", method=RequestMethod.POST)
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
