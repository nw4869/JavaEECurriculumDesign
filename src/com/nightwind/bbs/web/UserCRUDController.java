package com.nightwind.bbs.web;

import com.nightwind.bbs.dao.AuthorityDAO;
import com.nightwind.bbs.dao.CommentDAO;
import com.nightwind.bbs.dao.ForumThreadDAO;
import com.nightwind.bbs.dao.UserDAO;

import com.nightwind.bbs.domain.Authority;
import com.nightwind.bbs.domain.Comment;
import com.nightwind.bbs.domain.ForumThread;
import com.nightwind.bbs.domain.User;

import com.nightwind.bbs.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.WebDataBinder;

import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.servlet.ModelAndView;

/**
 * Spring MVC controller that handles CRUD requests for User entities
 * 
 * 
 * @generated
 */

@Controller("UserCRUDController")
public class UserCRUDController {

	/**
	 * DAO injected by Spring that manages Authority entities
	 * 
	 * 
	 */
	@Autowired
	private AuthorityDAO authorityDAO;

	/**
	 * DAO injected by Spring that manages Comment entities
	 * 
	 * 
	 */
	@Autowired
	private CommentDAO commentDAO;

	/**
	 * DAO injected by Spring that manages ForumThread entities
	 * 
	 * 
	 */
	@Autowired
	private ForumThreadDAO forumThreadDAO;

	/**
	 * DAO injected by Spring that manages User entities
	 * 
	 * 
	 */
	@Autowired
	private UserDAO userDAO;

	/**
	 * Service injected by Spring that provides CRUD operations for User entities
	 * 
	 * 
	 */
	@Autowired
	private UserService userService;

	/**
	 * Entry point to show all User entities
	 * 
	 * 
	 */
	public String indexUser() {
		return "redirect:/indexUser";
	}

	/**
	 * Save an existing User entity
	 * 
	 * 
	 */
	@RequestMapping("/saveUser")
	public String saveUser(@ModelAttribute User user) {
		userService.saveUser(user);
		return "forward:/indexUser";
	}

	/**
	 * Delete an existing ForumThread entity
	 * 
	 * 
	 */
	@RequestMapping("/deleteUserForumThreads")
	public ModelAndView deleteUserForumThreads(@RequestParam Integer user_id, @RequestParam Integer related_forumthreads_id) {
		ModelAndView mav = new ModelAndView();

		User user = userService.deleteUserForumThreads(user_id, related_forumthreads_id);

		mav.addObject("user_id", user_id);
		mav.addObject("user", user);
		mav.setViewName("user/viewUser.jsp");

		return mav;
	}

	/**
	 * View an existing Authority entity
	 * 
	 * 
	 */
	@RequestMapping("/selectUserAuthorities")
	public ModelAndView selectUserAuthorities(@RequestParam Integer user_id, @RequestParam Integer authorities_userId, @RequestParam String authorities_authorityField) {
		Authority authority = authorityDAO.findAuthorityByPrimaryKey(authorities_userId, authorities_authorityField, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("user_id", user_id);
		mav.addObject("authority", authority);
		mav.setViewName("user/authorities/viewAuthorities.jsp");

		return mav;
	}

	/**
	 * Select the child Authority entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 * 
	 */
	@RequestMapping("/confirmDeleteUserAuthorities")
	public ModelAndView confirmDeleteUserAuthorities(@RequestParam Integer user_id, @RequestParam Integer related_authorities_userId, @RequestParam String related_authorities_authorityField) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("authority", authorityDAO.findAuthorityByPrimaryKey(related_authorities_userId, related_authorities_authorityField));
		mav.addObject("user_id", user_id);
		mav.setViewName("user/authorities/deleteAuthorities.jsp");

		return mav;
	}

	/**
	 * Save an existing Comment entity
	 * 
	 * 
	 */
	@RequestMapping("/saveUserComments")
	public ModelAndView saveUserComments(@RequestParam Integer user_id, @ModelAttribute Comment comments) {
		User parent_user = userService.saveUserComments(user_id, comments);

		ModelAndView mav = new ModelAndView();
		mav.addObject("user_id", user_id);
		mav.addObject("user", parent_user);
		mav.setViewName("user/viewUser.jsp");

		return mav;
	}

	/**
	 * Save an existing Authority entity
	 * 
	 * 
	 */
	@RequestMapping("/saveUserAuthorities")
	public ModelAndView saveUserAuthorities(@RequestParam Integer user_id, @ModelAttribute Authority authorities) {
		User parent_user = userService.saveUserAuthorities(user_id, authorities);

		ModelAndView mav = new ModelAndView();
		mav.addObject("user_id", user_id);
		mav.addObject("user", parent_user);
		mav.setViewName("user/viewUser.jsp");

		return mav;
	}

	/**
	 * Create a new Authority entity
	 * 
	 * 
	 */
	@RequestMapping("/newUserAuthorities")
	public ModelAndView newUserAuthorities(@RequestParam Integer user_id) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("user_id", user_id);
		mav.addObject("authority", new Authority());
		mav.addObject("newFlag", true);
		mav.setViewName("user/authorities/editAuthorities.jsp");

		return mav;
	}

	/**
	 * Edit an existing Comment entity
	 * 
	 * 
	 */
	@RequestMapping("/editUserComments")
	public ModelAndView editUserComments(@RequestParam Integer user_id, @RequestParam Integer comments_id) {
		Comment comment = commentDAO.findCommentByPrimaryKey(comments_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("user_id", user_id);
		mav.addObject("comment", comment);
		mav.setViewName("user/comments/editComments.jsp");

		return mav;
	}

	/**
	 * Select the child ForumThread entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 * 
	 */
	@RequestMapping("/confirmDeleteUserForumThreads")
	public ModelAndView confirmDeleteUserForumThreads(@RequestParam Integer user_id, @RequestParam Integer related_forumthreads_id) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("forumthread", forumThreadDAO.findForumThreadByPrimaryKey(related_forumthreads_id));
		mav.addObject("user_id", user_id);
		mav.setViewName("user/forumthreads/deleteForumThreads.jsp");

		return mav;
	}

	/**
	 * Edit an existing ForumThread entity
	 * 
	 * 
	 */
	@RequestMapping("/editUserForumThreads")
	public ModelAndView editUserForumThreads(@RequestParam Integer user_id, @RequestParam Integer forumthreads_id) {
		ForumThread forumthread = forumThreadDAO.findForumThreadByPrimaryKey(forumthreads_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("user_id", user_id);
		mav.addObject("forumthread", forumthread);
		mav.setViewName("user/forumthreads/editForumThreads.jsp");

		return mav;
	}

	/**
	 * View an existing Comment entity
	 * 
	 * 
	 */
	@RequestMapping("/selectUserComments")
	public ModelAndView selectUserComments(@RequestParam Integer user_id, @RequestParam Integer comments_id) {
		Comment comment = commentDAO.findCommentByPrimaryKey(comments_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("user_id", user_id);
		mav.addObject("comment", comment);
		mav.setViewName("user/comments/viewComments.jsp");

		return mav;
	}

	/**
	 * Show all User entities
	 * 
	 * 
	 */
	@RequestMapping("/indexUser")
	public ModelAndView listUsers() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("users", userService.loadUsers());

		mav.setViewName("user/listUsers.jsp");

		return mav;
	}

	/**
	 * Register custom, context-specific property editors
	 * 
	 * 
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder, HttpServletRequest request) { // Register static property editors.
		binder.registerCustomEditor(java.util.Calendar.class, new org.skyway.spring.util.databinding.CustomCalendarEditor());
		binder.registerCustomEditor(byte[].class, new org.springframework.web.multipart.support.ByteArrayMultipartFileEditor());
		binder.registerCustomEditor(boolean.class, new org.skyway.spring.util.databinding.EnhancedBooleanEditor(false));
		binder.registerCustomEditor(Boolean.class, new org.skyway.spring.util.databinding.EnhancedBooleanEditor(true));
		binder.registerCustomEditor(java.math.BigDecimal.class, new org.skyway.spring.util.databinding.NaNHandlingNumberEditor(java.math.BigDecimal.class, true));
		binder.registerCustomEditor(Integer.class, new org.skyway.spring.util.databinding.NaNHandlingNumberEditor(Integer.class, true));
		binder.registerCustomEditor(java.util.Date.class, new org.skyway.spring.util.databinding.CustomDateEditor());
		binder.registerCustomEditor(String.class, new org.skyway.spring.util.databinding.StringEditor());
		binder.registerCustomEditor(Long.class, new org.skyway.spring.util.databinding.NaNHandlingNumberEditor(Long.class, true));
		binder.registerCustomEditor(Double.class, new org.skyway.spring.util.databinding.NaNHandlingNumberEditor(Double.class, true));
	}

	/**
	 * Create a new ForumThread entity
	 * 
	 * 
	 */
	@RequestMapping("/newUserForumThreads")
	public ModelAndView newUserForumThreads(@RequestParam Integer user_id) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("user_id", user_id);
		mav.addObject("forumthread", new ForumThread());
		mav.addObject("newFlag", true);
		mav.setViewName("user/forumthreads/editForumThreads.jsp");

		return mav;
	}

	/**
	 * Show all Comment entities by User
	 * 
	 * 
	 */
	@RequestMapping("/listUserComments")
	public ModelAndView listUserComments(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("user", userDAO.findUserByPrimaryKey(idKey));
		mav.setViewName("user/comments/listComments.jsp");

		return mav;
	}

	/**
	 * Create a new User entity
	 * 
	 * 
	 */
	@RequestMapping("/newUser")
	public ModelAndView newUser() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("user", new User());
		mav.addObject("newFlag", true);
		mav.setViewName("user/editUser.jsp");

		return mav;
	}

	/**
	 * View an existing ForumThread entity
	 * 
	 * 
	 */
	@RequestMapping("/selectUserForumThreads")
	public ModelAndView selectUserForumThreads(@RequestParam Integer user_id, @RequestParam Integer forumthreads_id) {
		ForumThread forumthread = forumThreadDAO.findForumThreadByPrimaryKey(forumthreads_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("user_id", user_id);
		mav.addObject("forumthread", forumthread);
		mav.setViewName("user/forumthreads/viewForumThreads.jsp");

		return mav;
	}

	/**
	 * Edit an existing User entity
	 * 
	 * 
	 */
	@RequestMapping("/editUser")
	public ModelAndView editUser(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("user", userDAO.findUserByPrimaryKey(idKey));
		mav.setViewName("user/editUser.jsp");

		return mav;
	}

	/**
	 * Select the User entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 * 
	 */
	@RequestMapping("/confirmDeleteUser")
	public ModelAndView confirmDeleteUser(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("user", userDAO.findUserByPrimaryKey(idKey));
		mav.setViewName("user/deleteUser.jsp");

		return mav;
	}

	/**
	 * Delete an existing User entity
	 * 
	 * 
	 */
	@RequestMapping("/deleteUser")
	public String deleteUser(@RequestParam Integer idKey) {
		User user = userDAO.findUserByPrimaryKey(idKey);
		userService.deleteUser(user);
		return "forward:/indexUser";
	}

	/**
	 * Select the child Comment entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 * 
	 */
	@RequestMapping("/confirmDeleteUserComments")
	public ModelAndView confirmDeleteUserComments(@RequestParam Integer user_id, @RequestParam Integer related_comments_id) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("comment", commentDAO.findCommentByPrimaryKey(related_comments_id));
		mav.addObject("user_id", user_id);
		mav.setViewName("user/comments/deleteComments.jsp");

		return mav;
	}

	/**
	 * Save an existing ForumThread entity
	 * 
	 * 
	 */
	@RequestMapping("/saveUserForumThreads")
	public ModelAndView saveUserForumThreads(@RequestParam Integer user_id, @ModelAttribute ForumThread forumthreads) {
		User parent_user = userService.saveUserForumThreads(user_id, forumthreads);

		ModelAndView mav = new ModelAndView();
		mav.addObject("user_id", user_id);
		mav.addObject("user", parent_user);
		mav.setViewName("user/viewUser.jsp");

		return mav;
	}

	/**
	 * Delete an existing Authority entity
	 * 
	 * 
	 */
	@RequestMapping("/deleteUserAuthorities")
	public ModelAndView deleteUserAuthorities(@RequestParam Integer user_id, @RequestParam Integer related_authorities_userId, @RequestParam String related_authorities_authorityField) {
		ModelAndView mav = new ModelAndView();

		User user = userService.deleteUserAuthorities(user_id, related_authorities_userId, related_authorities_authorityField);

		mav.addObject("user_id", user_id);
		mav.addObject("user", user);
		mav.setViewName("user/viewUser.jsp");

		return mav;
	}

	/**
	 * 
	 */
	@RequestMapping("/userController/binary.action")
	public ModelAndView streamBinary(@ModelAttribute HttpServletRequest request, @ModelAttribute HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("streamedBinaryContentView");
		return mav;

	}

	/**
	 * Edit an existing Authority entity
	 * 
	 * 
	 */
	@RequestMapping("/editUserAuthorities")
	public ModelAndView editUserAuthorities(@RequestParam Integer user_id, @RequestParam Integer authorities_userId, @RequestParam String authorities_authorityField) {
		Authority authority = authorityDAO.findAuthorityByPrimaryKey(authorities_userId, authorities_authorityField, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("user_id", user_id);
		mav.addObject("authority", authority);
		mav.setViewName("user/authorities/editAuthorities.jsp");

		return mav;
	}

	/**
	 * Create a new Comment entity
	 * 
	 * 
	 */
	@RequestMapping("/newUserComments")
	public ModelAndView newUserComments(@RequestParam Integer user_id) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("user_id", user_id);
		mav.addObject("comment", new Comment());
		mav.addObject("newFlag", true);
		mav.setViewName("user/comments/editComments.jsp");

		return mav;
	}

	/**
	 * Select an existing User entity
	 * 
	 * 
	 */
	@RequestMapping("/selectUser")
	public ModelAndView selectUser(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("user", userDAO.findUserByPrimaryKey(idKey));
		mav.setViewName("user/viewUser.jsp");

		return mav;
	}

	/**
	 * Show all ForumThread entities by User
	 * 
	 * 
	 */
	@RequestMapping("/listUserForumThreads")
	public ModelAndView listUserForumThreads(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("user", userDAO.findUserByPrimaryKey(idKey));
		mav.setViewName("user/forumthreads/listForumThreads.jsp");

		return mav;
	}

	/**
	 * Show all Authority entities by User
	 * 
	 * 
	 */
	@RequestMapping("/listUserAuthorities")
	public ModelAndView listUserAuthorities(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("user", userDAO.findUserByPrimaryKey(idKey));
		mav.setViewName("user/authorities/listAuthorities.jsp");

		return mav;
	}

	/**
	 * Delete an existing Comment entity
	 * 
	 * 
	 */
	@RequestMapping("/deleteUserComments")
	public ModelAndView deleteUserComments(@RequestParam Integer user_id, @RequestParam Integer related_comments_id) {
		ModelAndView mav = new ModelAndView();

		User user = userService.deleteUserComments(user_id, related_comments_id);

		mav.addObject("user_id", user_id);
		mav.addObject("user", user);
		mav.setViewName("user/viewUser.jsp");

		return mav;
	}
}