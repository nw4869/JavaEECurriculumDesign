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
 * @ModelCoreReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/ForumThreadController/.properties.webcontroller]
 * @generated
 */

@Controller("ForumThreadController")
public class ForumThreadController {

	/**
	 * DAO injected by Spring that manages Comment entities
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/ForumThreadController/.properties.webcontroller#//@variables%5Bname='commentDAO'%5D]
	 */
	@Autowired
	private CommentDAO commentDAO;

	/**
	 * DAO injected by Spring that manages Forum entities
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/ForumThreadController/.properties.webcontroller#//@variables%5Bname='forumDAO'%5D]
	 */
	@Autowired
	private ForumDAO forumDAO;

	/**
	 * DAO injected by Spring that manages ForumThread entities
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/ForumThreadController/.properties.webcontroller#//@variables%5Bname='forumThreadDAO'%5D]
	 */
	@Autowired
	private ForumThreadDAO forumThreadDAO;

	/**
	 * DAO injected by Spring that manages User entities
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/ForumThreadController/.properties.webcontroller#//@variables%5Bname='userDAO'%5D]
	 */
	@Autowired
	private UserDAO userDAO;

	/**
	 * Service injected by Spring that provides CRUD operations for ForumThread entities
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/ForumThreadController/.properties.webcontroller#//@variables%5Bname='forumThreadService'%5D]
	 */
	@Autowired
	private ForumThreadService forumThreadService;

	/**
	 * Edit an existing Forum entity
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/ForumThreadController/editForumThreadForum%7B0cc1f8b4-9998-41e6-b415-f78dab362271%7D/.properties.swoperation]
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
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/ForumThreadController/confirmDeleteForumThreadComments%7B658eb6b7-efb9-43c9-b570-8045c85a5639%7D/.properties.swoperation]
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
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/ForumThreadController/deleteForumThreadComments%7Bf9967ef4-9d1c-48ce-ad9f-23976ea3c6d6%7D/.properties.swoperation]
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
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/ForumThreadController/saveForumThreadForum%7B4ab77f09-d2de-40a5-887c-4dac9fca6fe0%7D/.properties.swoperation]
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
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/ForumThreadController/confirmDeleteForumThreadForum%7B6822b009-cb5e-442a-8262-e4281e0289e8%7D/.properties.swoperation]
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
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/ForumThreadController/newForumThread%7B0d3262cf-774d-4736-a22b-8644df519382%7D/.properties.swoperation]
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
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/ForumThreadController/confirmDeleteForumThreadUser%7B279dbcec-0d2d-437c-a090-facc4267420d%7D/.properties.swoperation]
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
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/ForumThreadController/selectForumThreadForum%7Bb0b21593-12e6-42c5-92b9-fae409dc0b3c%7D/.properties.swoperation]
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
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/ForumThreadController/editForumThreadUser%7Bd077e124-6fc1-4958-bdff-e9b27dc74f35%7D/.properties.swoperation]
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
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/ForumThreadController/listForumThreadForum%7B09e09f1a-40b2-4544-a586-202f5579a67e%7D/.properties.swoperation]
	 */
	@RequestMapping("/listForumThreadForum")
	public ModelAndView listForumThreadForum(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("forumthread", forumThreadDAO.findForumThreadByPrimaryKey(idKey));
		mav.setViewName("forumthread/forum/listForum.jsp");

		return mav;
	}

	/**
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/ForumThreadController/streamBinary%7B93966dbf-efab-47e9-983d-553efd02ac31%7D/.properties.swoperation]
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
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/ForumThreadController/newForumThreadForum%7B9519fd98-6ac6-4097-94ac-74c5afbe545f%7D/.properties.swoperation]
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
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/ForumThreadController/selectForumThread%7Bb283d2ef-d014-4910-920d-93619c7789a2%7D/.properties.swoperation]
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
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/ForumThreadController/selectForumThreadUser%7B29ca3f3e-f1db-41e7-89b3-d9053222090c%7D/.properties.swoperation]
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
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/ForumThreadController/indexForumThread%7B8b5e1610-ec91-4fc6-8bbd-55fe26fb1b90%7D/.properties.swoperation]
	 */
	public String indexForumThread() {
		return "redirect:/indexForumThread";
	}

	/**
	 * Delete an existing User entity
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/ForumThreadController/deleteForumThreadUser%7Ba7d7b5d5-afd0-41c5-8768-dfb58c272cb7%7D/.properties.swoperation]
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
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/ForumThreadController/editForumThread%7B2b1479dd-a068-47c9-a0c7-570fd838584e%7D/.properties.swoperation]
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
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/ForumThreadController/saveForumThread%7B62b6cda0-fdfb-4fea-a1e9-5d5164fdd03e%7D/.properties.swoperation]
	 */
	@RequestMapping("/saveForumThread")
	public String saveForumThread(@ModelAttribute ForumThread forumthread) {
		forumThreadService.saveForumThread(forumthread);
		return "forward:/indexForumThread";
	}

	/**
	 * Create a new User entity
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/ForumThreadController/newForumThreadUser%7B6e1d1bdc-fb12-4d3d-988a-e0792066222d%7D/.properties.swoperation]
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
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/ForumThreadController/newForumThreadComments%7B39b841ba-ef24-4e3d-957e-eeb554fd9765%7D/.properties.swoperation]
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
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/ForumThreadController/selectForumThreadComments%7Ba300ec39-31ca-4633-b828-fef5228685af%7D/.properties.swoperation]
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
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/ForumThreadController/editForumThreadComments%7B25107c07-8a19-4a3f-b508-020039ea5915%7D/.properties.swoperation]
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
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/ForumThreadController/initBinder%7Ba0f1ddb8-d5f0-4de9-bd29-783834d998c1%7D/.properties.swoperation]
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
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/ForumThreadController/listForumThreadUser%7Bf19624d0-ba3a-48ad-898c-fc90ca54e1f0%7D/.properties.swoperation]
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
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/ForumThreadController/confirmDeleteForumThread%7Ba2dbd6ee-d639-4480-8f95-414ea6ce6ae3%7D/.properties.swoperation]
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
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/ForumThreadController/listForumThreadComments%7Bf2504197-bd8b-484c-bc8b-6363aadb7806%7D/.properties.swoperation]
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
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/ForumThreadController/listForumThreads%7B8d55324e-6446-468e-a947-e65016e85096%7D/.properties.swoperation]
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
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/ForumThreadController/deleteForumThread%7Bafceb440-83e3-46df-b91f-b37e3c1df8f3%7D/.properties.swoperation]
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
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/ForumThreadController/saveForumThreadUser%7B20dc6458-1706-4db1-9865-b1e3dc24eda8%7D/.properties.swoperation]
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
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/ForumThreadController/deleteForumThreadForum%7Be39898d7-814c-43cc-a1b1-38b731eab853%7D/.properties.swoperation]
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
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/ForumThreadController/saveForumThreadComments%7B03d978f4-2949-4c8d-b322-f66cc9468a35%7D/.properties.swoperation]
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