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
 * @ModelCoreReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/CommentController/.properties.webcontroller]
 * @generated
 */

@Controller("CommentController")
public class CommentController {

	/**
	 * DAO injected by Spring that manages Comment entities
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/CommentController/.properties.webcontroller#//@variables%5Bname='commentDAO'%5D]
	 */
	@Autowired
	private CommentDAO commentDAO;

	/**
	 * DAO injected by Spring that manages ForumThread entities
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/CommentController/.properties.webcontroller#//@variables%5Bname='forumThreadDAO'%5D]
	 */
	@Autowired
	private ForumThreadDAO forumThreadDAO;

	/**
	 * DAO injected by Spring that manages User entities
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/CommentController/.properties.webcontroller#//@variables%5Bname='userDAO'%5D]
	 */
	@Autowired
	private UserDAO userDAO;

	/**
	 * Service injected by Spring that provides CRUD operations for Comment entities
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/CommentController/.properties.webcontroller#//@variables%5Bname='commentService'%5D]
	 */
	@Autowired
	private CommentService commentService;

	/**
	 * Show all User entities by Comment
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/CommentController/listCommentUser%7Be84f1c76-7975-4489-bef7-25040ed280d0%7D/.properties.swoperation]
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
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/CommentController/selectComment%7Bdb98bb97-a47d-4c5a-a41f-f5c20e9e93b8%7D/.properties.swoperation]
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
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/CommentController/listComments%7Bdc789ecc-7642-4ecf-b3b0-525181794bb7%7D/.properties.swoperation]
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
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/CommentController/deleteCommentUser%7B8501ff11-c387-43f0-ab85-35279e93c329%7D/.properties.swoperation]
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
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/CommentController/saveComment%7B6fea4dcd-7505-4f4e-924d-98657d951fb6%7D/.properties.swoperation]
	 */
	@RequestMapping("/saveComment")
	public String saveComment(@ModelAttribute Comment comment) {
		commentService.saveComment(comment);
		return "forward:/indexComment";
	}

	/**
	 * Edit an existing Comment entity
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/CommentController/editComment%7B446cf1eb-6a96-4ce1-a162-4fbd0f2b11a9%7D/.properties.swoperation]
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
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/CommentController/selectCommentUser%7B09a26c2d-7b90-4ae1-902b-b62e5cba5fa6%7D/.properties.swoperation]
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
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/CommentController/streamBinary%7Bed6f3f8f-6c5e-41ef-b185-9b000030eb5b%7D/.properties.swoperation]
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
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/CommentController/deleteComment%7B00412848-ed64-483c-8948-9ea665686336%7D/.properties.swoperation]
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
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/CommentController/confirmDeleteCommentForumThread%7B1f1cfec5-c4f9-402b-8910-e9c83bfd5f64%7D/.properties.swoperation]
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
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/CommentController/selectCommentForumThread%7Bf93b2535-adf3-4ce5-a701-54fa08bfc35e%7D/.properties.swoperation]
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
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/CommentController/newComment%7Be6223d17-e555-423b-adec-7aa7fdaf2d2e%7D/.properties.swoperation]
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
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/CommentController/newCommentUser%7B582e6012-f06d-4f72-8817-1d6b14a755b4%7D/.properties.swoperation]
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
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/CommentController/editCommentUser%7B19e60f09-a3b5-4ad5-9dbb-c070054c3196%7D/.properties.swoperation]
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
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/CommentController/confirmDeleteCommentUser%7B879f0f94-4b44-42e6-a5ec-cc032c6be75e%7D/.properties.swoperation]
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
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/CommentController/initBinder%7B1780d259-c1cc-47ba-ac13-16f84a476b9f%7D/.properties.swoperation]
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
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/CommentController/listCommentForumThread%7B8a165b2a-c541-4444-b88f-74e555ef981b%7D/.properties.swoperation]
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
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/CommentController/indexComment%7B29693c02-fb00-4282-9c1d-f42ab8a0f67c%7D/.properties.swoperation]
	 */
	public String indexComment() {
		return "redirect:/indexComment";
	}

	/**
	 * Save an existing ForumThread entity
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/CommentController/saveCommentForumThread%7B78377813-c1a0-4562-a7d1-9fa2d209bd6f%7D/.properties.swoperation]
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
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/CommentController/editCommentForumThread%7B7fb14496-cc42-4764-819a-2a651a5fbec2%7D/.properties.swoperation]
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
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/CommentController/saveCommentUser%7Bc58cb468-078e-45da-9e1d-b36a5e3cd659%7D/.properties.swoperation]
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
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/CommentController/newCommentForumThread%7B18c86960-19ad-4ef1-973e-08101becb806%7D/.properties.swoperation]
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
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/CommentController/deleteCommentForumThread%7B8933cd34-108f-4717-94ef-63c312bcc6c8%7D/.properties.swoperation]
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
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/CommentController/confirmDeleteComment%7B35fa51ee-015f-47be-a35d-183894f5fe5e%7D/.properties.swoperation]
	 */
	@RequestMapping("/confirmDeleteComment")
	public ModelAndView confirmDeleteComment(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("comment", commentDAO.findCommentByPrimaryKey(idKey));
		mav.setViewName("comment/deleteComment.jsp");

		return mav;
	}
}