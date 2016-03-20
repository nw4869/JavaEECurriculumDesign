package com.nightwind.bbs.web;

import com.nightwind.bbs.dao.CommentDAO;
import com.nightwind.bbs.dao.ForumDAO;
import com.nightwind.bbs.dao.ForumThreadDAO;
import com.nightwind.bbs.dao.UserDAO;

import com.nightwind.bbs.domain.Comment;
import com.nightwind.bbs.domain.Forum;
import com.nightwind.bbs.domain.ForumThread;
import com.nightwind.bbs.domain.User;

import com.nightwind.bbs.service.ForumThreadService;

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
 * Spring MVC controller that handles CRUD requests for ForumThread entities
 * 
 * 
 * @generated
 */

@Controller("ForumThreadController")
public class ForumThreadController {

	/**
	 * DAO injected by Spring that manages Comment entities
	 * 
	 * 
	 */
	@Autowired
	private CommentDAO commentDAO;

	/**
	 * DAO injected by Spring that manages Forum entities
	 * 
	 * 
	 */
	@Autowired
	private ForumDAO forumDAO;

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
	 * Service injected by Spring that provides CRUD operations for ForumThread entities
	 * 
	 * 
	 */
	@Autowired
	private ForumThreadService forumThreadService;

	/**
	 * Edit an existing Forum entity
	 * 
	 * 
	 */
	@RequestMapping("/editForumThreadForum")
	public ModelAndView editForumThreadForum(@RequestParam Integer forumthread_id, @RequestParam Integer forum_id) {
		Forum forum = forumDAO.findForumByPrimaryKey(forum_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("forumthread_id", forumthread_id);
		mav.addObject("forum", forum);
		mav.setViewName("forumthread/forum/editForum.jsp");

		return mav;
	}

	/**
	 * Select the child Comment entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 * 
	 */
	@RequestMapping("/confirmDeleteForumThreadComments")
	public ModelAndView confirmDeleteForumThreadComments(@RequestParam Integer forumthread_id, @RequestParam Integer related_comments_id) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("comment", commentDAO.findCommentByPrimaryKey(related_comments_id));
		mav.addObject("forumthread_id", forumthread_id);
		mav.setViewName("forumthread/comments/deleteComments.jsp");

		return mav;
	}

	/**
	 * Delete an existing Comment entity
	 * 
	 * 
	 */
	@RequestMapping("/deleteForumThreadComments")
	public ModelAndView deleteForumThreadComments(@RequestParam Integer forumthread_id, @RequestParam Integer related_comments_id) {
		ModelAndView mav = new ModelAndView();

		ForumThread forumthread = forumThreadService.deleteForumThreadComments(forumthread_id, related_comments_id);

		mav.addObject("forumthread_id", forumthread_id);
		mav.addObject("forumthread", forumthread);
		mav.setViewName("forumthread/viewForumThread.jsp");

		return mav;
	}

	/**
	 * Save an existing Forum entity
	 * 
	 * 
	 */
	@RequestMapping("/saveForumThreadForum")
	public ModelAndView saveForumThreadForum(@RequestParam Integer forumthread_id, @ModelAttribute Forum forum) {
		ForumThread parent_forumthread = forumThreadService.saveForumThreadForum(forumthread_id, forum);

		ModelAndView mav = new ModelAndView();
		mav.addObject("forumthread_id", forumthread_id);
		mav.addObject("forumthread", parent_forumthread);
		mav.setViewName("forumthread/viewForumThread.jsp");

		return mav;
	}

	/**
	 * Select the child Forum entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 * 
	 */
	@RequestMapping("/confirmDeleteForumThreadForum")
	public ModelAndView confirmDeleteForumThreadForum(@RequestParam Integer forumthread_id, @RequestParam Integer related_forum_id) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("forum", forumDAO.findForumByPrimaryKey(related_forum_id));
		mav.addObject("forumthread_id", forumthread_id);
		mav.setViewName("forumthread/forum/deleteForum.jsp");

		return mav;
	}

	/**
	 * Create a new ForumThread entity
	 * 
	 * 
	 */
	@RequestMapping("/newForumThread")
	public ModelAndView newForumThread() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("forumthread", new ForumThread());
		mav.addObject("newFlag", true);
		mav.setViewName("forumthread/editForumThread.jsp");

		return mav;
	}

	/**
	 * Select the child User entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 * 
	 */
	@RequestMapping("/confirmDeleteForumThreadUser")
	public ModelAndView confirmDeleteForumThreadUser(@RequestParam Integer forumthread_id, @RequestParam Integer related_user_id) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("user", userDAO.findUserByPrimaryKey(related_user_id));
		mav.addObject("forumthread_id", forumthread_id);
		mav.setViewName("forumthread/user/deleteUser.jsp");

		return mav;
	}

	/**
	 * View an existing Forum entity
	 * 
	 * 
	 */
	@RequestMapping("/selectForumThreadForum")
	public ModelAndView selectForumThreadForum(@RequestParam Integer forumthread_id, @RequestParam Integer forum_id) {
		Forum forum = forumDAO.findForumByPrimaryKey(forum_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("forumthread_id", forumthread_id);
		mav.addObject("forum", forum);
		mav.setViewName("forumthread/forum/viewForum.jsp");

		return mav;
	}

	/**
	 * Edit an existing User entity
	 * 
	 * 
	 */
	@RequestMapping("/editForumThreadUser")
	public ModelAndView editForumThreadUser(@RequestParam Integer forumthread_id, @RequestParam Integer user_id) {
		User user = userDAO.findUserByPrimaryKey(user_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("forumthread_id", forumthread_id);
		mav.addObject("user", user);
		mav.setViewName("forumthread/user/editUser.jsp");

		return mav;
	}

	/**
	 * Show all Forum entities by ForumThread
	 * 
	 * 
	 */
	@RequestMapping("/listForumThreadForum")
	public ModelAndView listForumThreadForum(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("forumthread", forumThreadDAO.findForumThreadByPrimaryKey(idKey));
		mav.setViewName("forumthread/forum/listForum.jsp");

		return mav;
	}

	/**
	 * 
	 */
	@RequestMapping("/forumthreadController/binary.action")
	public ModelAndView streamBinary(@ModelAttribute HttpServletRequest request, @ModelAttribute HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("streamedBinaryContentView");
		return mav;

	}

	/**
	 * Create a new Forum entity
	 * 
	 * 
	 */
	@RequestMapping("/newForumThreadForum")
	public ModelAndView newForumThreadForum(@RequestParam Integer forumthread_id) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("forumthread_id", forumthread_id);
		mav.addObject("forum", new Forum());
		mav.addObject("newFlag", true);
		mav.setViewName("forumthread/forum/editForum.jsp");

		return mav;
	}

	/**
	 * Select an existing ForumThread entity
	 * 
	 * 
	 */
	@RequestMapping("/selectForumThread")
	public ModelAndView selectForumThread(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("forumthread", forumThreadDAO.findForumThreadByPrimaryKey(idKey));
		mav.setViewName("forumthread/viewForumThread.jsp");

		return mav;
	}

	/**
	 * View an existing User entity
	 * 
	 * 
	 */
	@RequestMapping("/selectForumThreadUser")
	public ModelAndView selectForumThreadUser(@RequestParam Integer forumthread_id, @RequestParam Integer user_id) {
		User user = userDAO.findUserByPrimaryKey(user_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("forumthread_id", forumthread_id);
		mav.addObject("user", user);
		mav.setViewName("forumthread/user/viewUser.jsp");

		return mav;
	}

	/**
	 * Entry point to show all ForumThread entities
	 * 
	 * 
	 */
	public String indexForumThread() {
		return "redirect:/indexForumThread";
	}

	/**
	 * Delete an existing User entity
	 * 
	 * 
	 */
	@RequestMapping("/deleteForumThreadUser")
	public ModelAndView deleteForumThreadUser(@RequestParam Integer forumthread_id, @RequestParam Integer related_user_id) {
		ModelAndView mav = new ModelAndView();

		ForumThread forumthread = forumThreadService.deleteForumThreadUser(forumthread_id, related_user_id);

		mav.addObject("forumthread_id", forumthread_id);
		mav.addObject("forumthread", forumthread);
		mav.setViewName("forumthread/viewForumThread.jsp");

		return mav;
	}

	/**
	 * Edit an existing ForumThread entity
	 * 
	 * 
	 */
	@RequestMapping("/editForumThread")
	public ModelAndView editForumThread(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("forumthread", forumThreadDAO.findForumThreadByPrimaryKey(idKey));
		mav.setViewName("forumthread/editForumThread.jsp");

		return mav;
	}

	/**
	 * Save an existing ForumThread entity
	 * 
	 * 
	 */
	@RequestMapping("/saveForumThread")
	public String saveForumThread(@ModelAttribute ForumThread forumthread) {
		forumThreadService.saveForumThread(forumthread);
		return "forward:/indexForumThread";
	}

	/**
	 * Create a new User entity
	 * 
	 * 
	 */
	@RequestMapping("/newForumThreadUser")
	public ModelAndView newForumThreadUser(@RequestParam Integer forumthread_id) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("forumthread_id", forumthread_id);
		mav.addObject("user", new User());
		mav.addObject("newFlag", true);
		mav.setViewName("forumthread/user/editUser.jsp");

		return mav;
	}

	/**
	 * Create a new Comment entity
	 * 
	 * 
	 */
	@RequestMapping("/newForumThreadComments")
	public ModelAndView newForumThreadComments(@RequestParam Integer forumthread_id) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("forumthread_id", forumthread_id);
		mav.addObject("comment", new Comment());
		mav.addObject("newFlag", true);
		mav.setViewName("forumthread/comments/editComments.jsp");

		return mav;
	}

	/**
	 * View an existing Comment entity
	 * 
	 * 
	 */
	@RequestMapping("/selectForumThreadComments")
	public ModelAndView selectForumThreadComments(@RequestParam Integer forumthread_id, @RequestParam Integer comments_id) {
		Comment comment = commentDAO.findCommentByPrimaryKey(comments_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("forumthread_id", forumthread_id);
		mav.addObject("comment", comment);
		mav.setViewName("forumthread/comments/viewComments.jsp");

		return mav;
	}

	/**
	 * Edit an existing Comment entity
	 * 
	 * 
	 */
	@RequestMapping("/editForumThreadComments")
	public ModelAndView editForumThreadComments(@RequestParam Integer forumthread_id, @RequestParam Integer comments_id) {
		Comment comment = commentDAO.findCommentByPrimaryKey(comments_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("forumthread_id", forumthread_id);
		mav.addObject("comment", comment);
		mav.setViewName("forumthread/comments/editComments.jsp");

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
	 * Show all User entities by ForumThread
	 * 
	 * 
	 */
	@RequestMapping("/listForumThreadUser")
	public ModelAndView listForumThreadUser(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("forumthread", forumThreadDAO.findForumThreadByPrimaryKey(idKey));
		mav.setViewName("forumthread/user/listUser.jsp");

		return mav;
	}

	/**
	 * Select the ForumThread entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 * 
	 */
	@RequestMapping("/confirmDeleteForumThread")
	public ModelAndView confirmDeleteForumThread(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("forumthread", forumThreadDAO.findForumThreadByPrimaryKey(idKey));
		mav.setViewName("forumthread/deleteForumThread.jsp");

		return mav;
	}

	/**
	 * Show all Comment entities by ForumThread
	 * 
	 * 
	 */
	@RequestMapping("/listForumThreadComments")
	public ModelAndView listForumThreadComments(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("forumthread", forumThreadDAO.findForumThreadByPrimaryKey(idKey));
		mav.setViewName("forumthread/comments/listComments.jsp");

		return mav;
	}

	/**
	 * Show all ForumThread entities
	 * 
	 * 
	 */
	@RequestMapping("/indexForumThread")
	public ModelAndView listForumThreads() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("forumthreads", forumThreadService.loadForumThreads());

		mav.setViewName("forumthread/listForumThreads.jsp");

		return mav;
	}

	/**
	 * Delete an existing ForumThread entity
	 * 
	 * 
	 */
	@RequestMapping("/deleteForumThread")
	public String deleteForumThread(@RequestParam Integer idKey) {
		ForumThread forumthread = forumThreadDAO.findForumThreadByPrimaryKey(idKey);
		forumThreadService.deleteForumThread(forumthread);
		return "forward:/indexForumThread";
	}

	/**
	 * Save an existing User entity
	 * 
	 * 
	 */
	@RequestMapping("/saveForumThreadUser")
	public ModelAndView saveForumThreadUser(@RequestParam Integer forumthread_id, @ModelAttribute User user) {
		ForumThread parent_forumthread = forumThreadService.saveForumThreadUser(forumthread_id, user);

		ModelAndView mav = new ModelAndView();
		mav.addObject("forumthread_id", forumthread_id);
		mav.addObject("forumthread", parent_forumthread);
		mav.setViewName("forumthread/viewForumThread.jsp");

		return mav;
	}

	/**
	 * Delete an existing Forum entity
	 * 
	 * 
	 */
	@RequestMapping("/deleteForumThreadForum")
	public ModelAndView deleteForumThreadForum(@RequestParam Integer forumthread_id, @RequestParam Integer related_forum_id) {
		ModelAndView mav = new ModelAndView();

		ForumThread forumthread = forumThreadService.deleteForumThreadForum(forumthread_id, related_forum_id);

		mav.addObject("forumthread_id", forumthread_id);
		mav.addObject("forumthread", forumthread);
		mav.setViewName("forumthread/viewForumThread.jsp");

		return mav;
	}

	/**
	 * Save an existing Comment entity
	 * 
	 * 
	 */
	@RequestMapping("/saveForumThreadComments")
	public ModelAndView saveForumThreadComments(@RequestParam Integer forumthread_id, @ModelAttribute Comment comments) {
		ForumThread parent_forumthread = forumThreadService.saveForumThreadComments(forumthread_id, comments);

		ModelAndView mav = new ModelAndView();
		mav.addObject("forumthread_id", forumthread_id);
		mav.addObject("forumthread", parent_forumthread);
		mav.setViewName("forumthread/viewForumThread.jsp");

		return mav;
	}
}