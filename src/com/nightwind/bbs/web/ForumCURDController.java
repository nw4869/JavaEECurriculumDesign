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
 * 
 * @generated
 */

@Controller("ForumController")
public class ForumCURDController {

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
	 * Service injected by Spring that provides CRUD operations for Forum entities
	 * 
	 * 
	 */
	@Autowired
	private ForumService forumService;

	/**
	 * Show all Forum entities
	 * 
	 * 
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
	 * 
	 */
	public String indexForum() {
		return "redirect:/indexForum";
	}

	/**
	 * Edit an existing ForumThread entity
	 * 
	 * 
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
	 * 
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
	 * 
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
	 * 
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
	 * 
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
	 * 
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
	 * 
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
	 * 
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
	 * 
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
	 * 
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
	 * 
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
	 * 
	 */
	@RequestMapping("/saveForum")
	public String saveForum(@ModelAttribute Forum forum) {
		forumService.saveForum(forum);
		return "forward:/indexForum";
	}

	/**
	 * Create a new Forum entity
	 * 
	 * 
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
	 * 
	 */
	@RequestMapping("/forumController/binary.action")
	public ModelAndView streamBinary(@ModelAttribute HttpServletRequest request, @ModelAttribute HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("streamedBinaryContentView");
		return mav;

	}
}