package com.nightwind.bbs.web;

import com.nightwind.bbs.dao.ForumDAO;
import com.nightwind.bbs.dao.ForumThreadDAO;

import com.nightwind.bbs.domain.Forum;
import com.nightwind.bbs.domain.ForumThread;

import com.nightwind.bbs.service.ForumService;

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
 * Spring MVC controller that handles CRUD requests for Forum entities
 * 
 * @ModelCoreReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/ForumController/.properties.webcontroller]
 * @generated
 */

@Controller("ForumController")
public class ForumController {

	/**
	 * DAO injected by Spring that manages Forum entities
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/ForumController/.properties.webcontroller#//@variables%5Bname='forumDAO'%5D]
	 */
	@Autowired
	private ForumDAO forumDAO;

	/**
	 * DAO injected by Spring that manages ForumThread entities
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/ForumController/.properties.webcontroller#//@variables%5Bname='forumThreadDAO'%5D]
	 */
	@Autowired
	private ForumThreadDAO forumThreadDAO;

	/**
	 * Service injected by Spring that provides CRUD operations for Forum entities
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/ForumController/.properties.webcontroller#//@variables%5Bname='forumService'%5D]
	 */
	@Autowired
	private ForumService forumService;

	/**
	 * Show all Forum entities
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/ForumController/listForums%7Bbe85fa12-701c-42ff-b8a7-509c8d09bbe0%7D/.properties.swoperation]
	 */
	@RequestMapping("/indexForum")
	public ModelAndView listForums() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("forums", forumService.loadForums());

		mav.setViewName("forum/listForums.jsp");

		return mav;
	}

	/**
	 * Entry point to show all Forum entities
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/ForumController/indexForum%7B5549a790-120a-4cbf-9cb0-3b21eb2d4678%7D/.properties.swoperation]
	 */
	public String indexForum() {
		return "redirect:/indexForum";
	}

	/**
	 * Edit an existing ForumThread entity
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/ForumController/editForumForumThreads%7B4d66ffd4-5eb2-4685-8bf0-92f797a99a89%7D/.properties.swoperation]
	 */
	@RequestMapping("/editForumForumThreads")
	public ModelAndView editForumForumThreads(@RequestParam Integer forum_id, @RequestParam Integer forumthreads_id) {
		ForumThread forumthread = forumThreadDAO.findForumThreadByPrimaryKey(forumthreads_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("forum_id", forum_id);
		mav.addObject("forumthread", forumthread);
		mav.setViewName("forum/forumthreads/editForumThreads.jsp");

		return mav;
	}

	/**
	 * Save an existing ForumThread entity
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/ForumController/saveForumForumThreads%7Bd3baa9d8-d1e6-48f6-9c7c-834ddb67053c%7D/.properties.swoperation]
	 */
	@RequestMapping("/saveForumForumThreads")
	public ModelAndView saveForumForumThreads(@RequestParam Integer forum_id, @ModelAttribute ForumThread forumthreads) {
		Forum parent_forum = forumService.saveForumForumThreads(forum_id, forumthreads);

		ModelAndView mav = new ModelAndView();
		mav.addObject("forum_id", forum_id);
		mav.addObject("forum", parent_forum);
		mav.setViewName("forum/viewForum.jsp");

		return mav;
	}

	/**
	 * Select the Forum entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/ForumController/confirmDeleteForum%7B2965951f-1248-4674-a361-bd4a575c6454%7D/.properties.swoperation]
	 */
	@RequestMapping("/confirmDeleteForum")
	public ModelAndView confirmDeleteForum(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("forum", forumDAO.findForumByPrimaryKey(idKey));
		mav.setViewName("forum/deleteForum.jsp");

		return mav;
	}

	/**
	 * Edit an existing Forum entity
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/ForumController/editForum%7B20cfd716-e414-469d-83a1-c8561b4a51c6%7D/.properties.swoperation]
	 */
	@RequestMapping("/editForum")
	public ModelAndView editForum(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("forum", forumDAO.findForumByPrimaryKey(idKey));
		mav.setViewName("forum/editForum.jsp");

		return mav;
	}

	/**
	 * Show all ForumThread entities by Forum
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/ForumController/listForumForumThreads%7B7c3b356b-8f2a-401a-ad99-ae3b181e1be9%7D/.properties.swoperation]
	 */
	@RequestMapping("/listForumForumThreads")
	public ModelAndView listForumForumThreads(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("forum", forumDAO.findForumByPrimaryKey(idKey));
		mav.setViewName("forum/forumthreads/listForumThreads.jsp");

		return mav;
	}

	/**
	 * Select an existing Forum entity
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/ForumController/selectForum%7B371c93f7-700c-413f-9ec7-2e19c59186ba%7D/.properties.swoperation]
	 */
	@RequestMapping("/selectForum")
	public ModelAndView selectForum(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("forum", forumDAO.findForumByPrimaryKey(idKey));
		mav.setViewName("forum/viewForum.jsp");

		return mav;
	}

	/**
	 * Create a new ForumThread entity
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/ForumController/newForumForumThreads%7Bd267b482-6d66-4991-972a-3a1aa7b67ea1%7D/.properties.swoperation]
	 */
	@RequestMapping("/newForumForumThreads")
	public ModelAndView newForumForumThreads(@RequestParam Integer forum_id) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("forum_id", forum_id);
		mav.addObject("forumthread", new ForumThread());
		mav.addObject("newFlag", true);
		mav.setViewName("forum/forumthreads/editForumThreads.jsp");

		return mav;
	}

	/**
	 * View an existing ForumThread entity
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/ForumController/selectForumForumThreads%7B796e78a8-e02d-485a-9f90-84bc36e2e89e%7D/.properties.swoperation]
	 */
	@RequestMapping("/selectForumForumThreads")
	public ModelAndView selectForumForumThreads(@RequestParam Integer forum_id, @RequestParam Integer forumthreads_id) {
		ForumThread forumthread = forumThreadDAO.findForumThreadByPrimaryKey(forumthreads_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("forum_id", forum_id);
		mav.addObject("forumthread", forumthread);
		mav.setViewName("forum/forumthreads/viewForumThreads.jsp");

		return mav;
	}

	/**
	 * Delete an existing ForumThread entity
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/ForumController/deleteForumForumThreads%7B17ba254e-18ce-43ad-b28a-963f821b2c6d%7D/.properties.swoperation]
	 */
	@RequestMapping("/deleteForumForumThreads")
	public ModelAndView deleteForumForumThreads(@RequestParam Integer forum_id, @RequestParam Integer related_forumthreads_id) {
		ModelAndView mav = new ModelAndView();

		Forum forum = forumService.deleteForumForumThreads(forum_id, related_forumthreads_id);

		mav.addObject("forum_id", forum_id);
		mav.addObject("forum", forum);
		mav.setViewName("forum/viewForum.jsp");

		return mav;
	}

	/**
	 * Delete an existing Forum entity
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/ForumController/deleteForum%7Ba3bd2f8a-3ed2-4c99-b341-fa746c0efa3f%7D/.properties.swoperation]
	 */
	@RequestMapping("/deleteForum")
	public String deleteForum(@RequestParam Integer idKey) {
		Forum forum = forumDAO.findForumByPrimaryKey(idKey);
		forumService.deleteForum(forum);
		return "forward:/indexForum";
	}

	/**
	 * Select the child ForumThread entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/ForumController/confirmDeleteForumForumThreads%7B09d58069-9706-4e8d-8628-ed8ba6f70ba1%7D/.properties.swoperation]
	 */
	@RequestMapping("/confirmDeleteForumForumThreads")
	public ModelAndView confirmDeleteForumForumThreads(@RequestParam Integer forum_id, @RequestParam Integer related_forumthreads_id) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("forumthread", forumThreadDAO.findForumThreadByPrimaryKey(related_forumthreads_id));
		mav.addObject("forum_id", forum_id);
		mav.setViewName("forum/forumthreads/deleteForumThreads.jsp");

		return mav;
	}

	/**
	 * Save an existing Forum entity
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/ForumController/saveForum%7B89db6194-d59a-4454-a22f-279397b38d4b%7D/.properties.swoperation]
	 */
	@RequestMapping("/saveForum")
	public String saveForum(@ModelAttribute Forum forum) {
		forumService.saveForum(forum);
		return "forward:/indexForum";
	}

	/**
	 * Create a new Forum entity
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/ForumController/newForum%7Bf797b376-622c-4c04-a9a0-7a1dd53b1f6f%7D/.properties.swoperation]
	 */
	@RequestMapping("/newForum")
	public ModelAndView newForum() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("forum", new Forum());
		mav.addObject("newFlag", true);
		mav.setViewName("forum/editForum.jsp");

		return mav;
	}

	/**
	 * Register custom, context-specific property editors
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/ForumController/initBinder%7B41d78d53-6c66-46d6-8aeb-041d413d2839%7D/.properties.swoperation]
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
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/ForumController/streamBinary%7B8a320a5a-6e9e-4764-bf1b-f0bf599ee21e%7D/.properties.swoperation]
	 */
	@RequestMapping("/forumController/binary.action")
	public ModelAndView streamBinary(@ModelAttribute HttpServletRequest request, @ModelAttribute HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("streamedBinaryContentView");
		return mav;

	}
}