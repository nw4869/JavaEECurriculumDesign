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
 * @ModelCoreReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/UserController/.properties.webcontroller]
 * @generated
 */

@Controller("UserController")
public class UserController {

	/**
	 * DAO injected by Spring that manages Authority entities
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/UserController/.properties.webcontroller#//@variables%5Bname='authorityDAO'%5D]
	 */
	@Autowired
	private AuthorityDAO authorityDAO;

	/**
	 * DAO injected by Spring that manages Comment entities
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/UserController/.properties.webcontroller#//@variables%5Bname='commentDAO'%5D]
	 */
	@Autowired
	private CommentDAO commentDAO;

	/**
	 * DAO injected by Spring that manages ForumThread entities
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/UserController/.properties.webcontroller#//@variables%5Bname='forumThreadDAO'%5D]
	 */
	@Autowired
	private ForumThreadDAO forumThreadDAO;

	/**
	 * DAO injected by Spring that manages User entities
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/UserController/.properties.webcontroller#//@variables%5Bname='userDAO'%5D]
	 */
	@Autowired
	private UserDAO userDAO;

	/**
	 * Service injected by Spring that provides CRUD operations for User entities
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/UserController/.properties.webcontroller#//@variables%5Bname='userService'%5D]
	 */
	@Autowired
	private UserService userService;

	/**
	 * Entry point to show all User entities
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/UserController/indexUser%7B86f14b7f-2ebf-484d-8086-d1461262b916%7D/.properties.swoperation]
	 */
	public String indexUser() {
		return "redirect:/indexUser";
	}

	/**
	 * Save an existing User entity
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/UserController/saveUser%7Bf36d90f8-95ab-4bc9-89ad-017ca6701ff8%7D/.properties.swoperation]
	 */
	@RequestMapping("/saveUser")
	public String saveUser(@ModelAttribute User user) {
		userService.saveUser(user);
		return "forward:/indexUser";
	}

	/**
	 * Delete an existing ForumThread entity
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/UserController/deleteUserForumThreads%7Bac2d4cf6-1931-4d63-8f30-35ad96337a82%7D/.properties.swoperation]
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
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/UserController/selectUserAuthorities%7Be2bb626c-5cc0-492e-8379-0c28b32e422a%7D/.properties.swoperation]
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
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/UserController/confirmDeleteUserAuthorities%7B6b09d1e5-6406-45d9-9d72-9be61d2ce57e%7D/.properties.swoperation]
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
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/UserController/saveUserComments%7Bfb747c6d-6915-4be7-89cb-d23c427c8b0b%7D/.properties.swoperation]
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
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/UserController/saveUserAuthorities%7B5c8bc15a-4c84-4794-9d58-4851ebb0982a%7D/.properties.swoperation]
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
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/UserController/newUserAuthorities%7B600e15a5-8f66-4292-a551-2f5d21b61bd4%7D/.properties.swoperation]
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
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/UserController/editUserComments%7Be9df38e2-431f-4c90-8d69-f8fd8bc33b2a%7D/.properties.swoperation]
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
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/UserController/confirmDeleteUserForumThreads%7Ba3bf38ca-c561-4ff7-9a87-7420eb98c867%7D/.properties.swoperation]
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
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/UserController/editUserForumThreads%7B4fc43895-7845-4af1-b706-e07ffaa10b8e%7D/.properties.swoperation]
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
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/UserController/selectUserComments%7Ba13406b7-4b51-4b4f-9e0f-62b92be67cad%7D/.properties.swoperation]
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
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/UserController/listUsers%7B01323d4a-eaf7-4970-95ae-1758017f9a4e%7D/.properties.swoperation]
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
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/UserController/initBinder%7B0ba6acdc-54a6-42c1-8fed-3fdf5bde1a3d%7D/.properties.swoperation]
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
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/UserController/newUserForumThreads%7B4a46e86a-4135-4205-9fd1-1691247e4ddb%7D/.properties.swoperation]
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
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/UserController/listUserComments%7B08e92a54-075d-40fe-b340-27b9da2046a0%7D/.properties.swoperation]
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
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/UserController/newUser%7B1b1e13f4-eff9-4ef6-a075-f86675f8bcc4%7D/.properties.swoperation]
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
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/UserController/selectUserForumThreads%7B709d1033-0f58-49d8-8288-69b935c7a5b0%7D/.properties.swoperation]
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
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/UserController/editUser%7Bcc455c6c-49dc-4c42-945e-54aa0ed7b57a%7D/.properties.swoperation]
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
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/UserController/confirmDeleteUser%7B63d252ea-f58a-4a26-9a63-b7214b0adb68%7D/.properties.swoperation]
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
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/UserController/deleteUser%7B8a0dab7a-b9bb-4b5c-8acb-5b6a12b4cd20%7D/.properties.swoperation]
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
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/UserController/confirmDeleteUserComments%7Bf8de326d-fda4-4a56-885d-90065ba41dee%7D/.properties.swoperation]
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
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/UserController/saveUserForumThreads%7Bc1207372-ec7b-4a65-aa44-958068698c40%7D/.properties.swoperation]
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
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/UserController/deleteUserAuthorities%7B5156beb3-015e-44c6-8d0e-fc05ef7f2097%7D/.properties.swoperation]
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
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/UserController/streamBinary%7Bcfdb41be-d9dd-4c8d-8f90-cc83d8187c6d%7D/.properties.swoperation]
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
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/UserController/editUserAuthorities%7B65e13dae-4283-4254-94f8-87e0f483d738%7D/.properties.swoperation]
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
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/UserController/newUserComments%7B3a739bb9-d46a-43ec-bd27-97065db851ea%7D/.properties.swoperation]
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
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/UserController/selectUser%7B06ec77bd-74fe-47ba-bb00-3466c48e5959%7D/.properties.swoperation]
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
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/UserController/listUserForumThreads%7B5ceca458-a64e-4344-b8a8-2a907650b6b8%7D/.properties.swoperation]
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
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/UserController/listUserAuthorities%7B0822c434-3f04-430c-b8eb-b83830d42e75%7D/.properties.swoperation]
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
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/UserController/deleteUserComments%7B638d4ee8-9c0a-4e6e-a222-6611290f4c15%7D/.properties.swoperation]
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