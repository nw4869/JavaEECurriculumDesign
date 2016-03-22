package com.nightwind.bbs.web;

import com.nightwind.bbs.dao.CommentDAO;
import com.nightwind.bbs.dao.ForumThreadDAO;
import com.nightwind.bbs.dao.UserDAO;

import com.nightwind.bbs.domain.Comment;
import com.nightwind.bbs.domain.ForumThread;
import com.nightwind.bbs.domain.User;

import com.nightwind.bbs.service.CommentService;

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
 * Spring MVC controller that handles CRUD requests for Comment entities
 * 
 * 
 * @generated
 */

@Controller("CommentController")
public class CommentController {

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
	 * Service injected by Spring that provides CRUD operations for Comment entities
	 * 
	 * 
	 */
	@Autowired
	private CommentService commentService;

	/**
	 * Show all User entities by Comment
	 * 
	 * 
	 */
	@RequestMapping("/listCommentUser")
	public ModelAndView listCommentUser(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("comment", commentDAO.findCommentByPrimaryKey(idKey));
		mav.setViewName("comment/user/listUser.jsp");

		return mav;
	}

	/**
	 * Select an existing Comment entity
	 * 
	 * 
	 */
	@RequestMapping("/selectComment")
	public ModelAndView selectComment(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("comment", commentDAO.findCommentByPrimaryKey(idKey));
		mav.setViewName("comment/viewComment.jsp");

		return mav;
	}

	/**
	 * Show all Comment entities
	 * 
	 * 
	 */
	@RequestMapping("/indexComment")
	public ModelAndView listComments() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("comments", commentService.loadComments());

		mav.setViewName("comment/listComments.jsp");

		return mav;
	}

	/**
	 * Delete an existing User entity
	 * 
	 * 
	 */
	@RequestMapping("/deleteCommentUser")
	public ModelAndView deleteCommentUser(@RequestParam Integer comment_id, @RequestParam Integer related_user_id) {
		ModelAndView mav = new ModelAndView();

		Comment comment = commentService.deleteCommentUser(comment_id, related_user_id);

		mav.addObject("comment_id", comment_id);
		mav.addObject("comment", comment);
		mav.setViewName("comment/viewComment.jsp");

		return mav;
	}

	/**
	 * Save an existing Comment entity
	 * 
	 * 
	 */
	@RequestMapping("/saveComment")
	public String saveComment(@ModelAttribute Comment comment) {
		commentService.saveComment(comment);
		return "forward:/indexComment";
	}

	/**
	 * Edit an existing Comment entity
	 * 
	 * 
	 */
	@RequestMapping("/editComment")
	public ModelAndView editComment(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("comment", commentDAO.findCommentByPrimaryKey(idKey));
		mav.setViewName("comment/editComment.jsp");

		return mav;
	}

	/**
	 * View an existing User entity
	 * 
	 * 
	 */
	@RequestMapping("/selectCommentUser")
	public ModelAndView selectCommentUser(@RequestParam Integer comment_id, @RequestParam Integer user_id) {
		User user = userDAO.findUserByPrimaryKey(user_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("comment_id", comment_id);
		mav.addObject("user", user);
		mav.setViewName("comment/user/viewUser.jsp");

		return mav;
	}

	/**
	 * 
	 */
	@RequestMapping("/commentController/binary.action")
	public ModelAndView streamBinary(@ModelAttribute HttpServletRequest request, @ModelAttribute HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("streamedBinaryContentView");
		return mav;

	}

	/**
	 * Delete an existing Comment entity
	 * 
	 * 
	 */
	@RequestMapping("/deleteComment")
	public String deleteComment(@RequestParam Integer idKey) {
		Comment comment = commentDAO.findCommentByPrimaryKey(idKey);
		commentService.deleteComment(comment);
		return "forward:/indexComment";
	}

	/**
	 * Select the child ForumThread entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 * 
	 */
	@RequestMapping("/confirmDeleteCommentForumThread")
	public ModelAndView confirmDeleteCommentForumThread(@RequestParam Integer comment_id, @RequestParam Integer related_forumthread_id) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("forumthread", forumThreadDAO.findForumThreadByPrimaryKey(related_forumthread_id));
		mav.addObject("comment_id", comment_id);
		mav.setViewName("comment/forumthread/deleteForumThread.jsp");

		return mav;
	}

	/**
	 * View an existing ForumThread entity
	 * 
	 * 
	 */
	@RequestMapping("/selectCommentForumThread")
	public ModelAndView selectCommentForumThread(@RequestParam Integer comment_id, @RequestParam Integer forumthread_id) {
		ForumThread forumthread = forumThreadDAO.findForumThreadByPrimaryKey(forumthread_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("comment_id", comment_id);
		mav.addObject("forumthread", forumthread);
		mav.setViewName("comment/forumthread/viewForumThread.jsp");

		return mav;
	}

	/**
	 * Create a new Comment entity
	 * 
	 * 
	 */
	@RequestMapping("/newComment")
	public ModelAndView newComment() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("comment", new Comment());
		mav.addObject("newFlag", true);
		mav.setViewName("comment/editComment.jsp");

		return mav;
	}

	/**
	 * Create a new User entity
	 * 
	 * 
	 */
	@RequestMapping("/newCommentUser")
	public ModelAndView newCommentUser(@RequestParam Integer comment_id) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("comment_id", comment_id);
		mav.addObject("user", new User());
		mav.addObject("newFlag", true);
		mav.setViewName("comment/user/editUser.jsp");

		return mav;
	}

	/**
	 * Edit an existing User entity
	 * 
	 * 
	 */
	@RequestMapping("/editCommentUser")
	public ModelAndView editCommentUser(@RequestParam Integer comment_id, @RequestParam Integer user_id) {
		User user = userDAO.findUserByPrimaryKey(user_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("comment_id", comment_id);
		mav.addObject("user", user);
		mav.setViewName("comment/user/editUser.jsp");

		return mav;
	}

	/**
	 * Select the child User entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 * 
	 */
	@RequestMapping("/confirmDeleteCommentUser")
	public ModelAndView confirmDeleteCommentUser(@RequestParam Integer comment_id, @RequestParam Integer related_user_id) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("user", userDAO.findUserByPrimaryKey(related_user_id));
		mav.addObject("comment_id", comment_id);
		mav.setViewName("comment/user/deleteUser.jsp");

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
	 * Show all ForumThread entities by Comment
	 * 
	 * 
	 */
	@RequestMapping("/listCommentForumThread")
	public ModelAndView listCommentForumThread(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("comment", commentDAO.findCommentByPrimaryKey(idKey));
		mav.setViewName("comment/forumthread/listForumThread.jsp");

		return mav;
	}

	/**
	 * Entry point to show all Comment entities
	 * 
	 * 
	 */
	public String indexComment() {
		return "redirect:/indexComment";
	}

	/**
	 * Save an existing ForumThread entity
	 * 
	 * 
	 */
	@RequestMapping("/saveCommentForumThread")
	public ModelAndView saveCommentForumThread(@RequestParam Integer comment_id, @ModelAttribute ForumThread forumthread) {
		Comment parent_comment = commentService.saveCommentForumThread(comment_id, forumthread);

		ModelAndView mav = new ModelAndView();
		mav.addObject("comment_id", comment_id);
		mav.addObject("comment", parent_comment);
		mav.setViewName("comment/viewComment.jsp");

		return mav;
	}

	/**
	 * Edit an existing ForumThread entity
	 * 
	 * 
	 */
	@RequestMapping("/editCommentForumThread")
	public ModelAndView editCommentForumThread(@RequestParam Integer comment_id, @RequestParam Integer forumthread_id) {
		ForumThread forumthread = forumThreadDAO.findForumThreadByPrimaryKey(forumthread_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("comment_id", comment_id);
		mav.addObject("forumthread", forumthread);
		mav.setViewName("comment/forumthread/editForumThread.jsp");

		return mav;
	}

	/**
	 * Save an existing User entity
	 * 
	 * 
	 */
	@RequestMapping("/saveCommentUser")
	public ModelAndView saveCommentUser(@RequestParam Integer comment_id, @ModelAttribute User user) {
		Comment parent_comment = commentService.saveCommentUser(comment_id, user);

		ModelAndView mav = new ModelAndView();
		mav.addObject("comment_id", comment_id);
		mav.addObject("comment", parent_comment);
		mav.setViewName("comment/viewComment.jsp");

		return mav;
	}

	/**
	 * Create a new ForumThread entity
	 * 
	 * 
	 */
	@RequestMapping("/newCommentForumThread")
	public ModelAndView newCommentForumThread(@RequestParam Integer comment_id) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("comment_id", comment_id);
		mav.addObject("forumthread", new ForumThread());
		mav.addObject("newFlag", true);
		mav.setViewName("comment/forumthread/editForumThread.jsp");

		return mav;
	}

	/**
	 * Delete an existing ForumThread entity
	 * 
	 * 
	 */
	@RequestMapping("/deleteCommentForumThread")
	public ModelAndView deleteCommentForumThread(@RequestParam Integer comment_id, @RequestParam Integer related_forumthread_id) {
		ModelAndView mav = new ModelAndView();

		Comment comment = commentService.deleteCommentForumThread(comment_id, related_forumthread_id);

		mav.addObject("comment_id", comment_id);
		mav.addObject("comment", comment);
		mav.setViewName("comment/viewComment.jsp");

		return mav;
	}

	/**
	 * Select the Comment entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 * 
	 */
	@RequestMapping("/confirmDeleteComment")
	public ModelAndView confirmDeleteComment(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("comment", commentDAO.findCommentByPrimaryKey(idKey));
		mav.setViewName("comment/deleteComment.jsp");

		return mav;
	}
}