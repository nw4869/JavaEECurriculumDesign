package com.nightwind.bbs.web;

import java.util.Map;

import javax.ejb.FinderException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nightwind.bbs.domain.Forum;
import com.nightwind.bbs.domain.Topic;
import com.nightwind.bbs.domain.User;
import com.nightwind.bbs.exception.AuthorizeException;
import com.nightwind.bbs.exception.ForumNotFoundException;
import com.nightwind.bbs.exception.NoLoginException;
import com.nightwind.bbs.service.AuthService;
import com.nightwind.bbs.service.ForumService;
import com.nightwind.bbs.web.form.TopicsForm;

@SessionAttributes("crtUser")
@RequestMapping("/forum")
@Controller
public class ForumController {

	@Autowired
	private ForumService forumService;

	@Autowired
	private AuthService authService;
	
	
	@RequestMapping( value = {"/", ""})
	public ModelAndView list(ModelMap model) {
		ModelAndView mav = new ModelAndView("/forum/index.jsp");
		mav.addObject("forums", forumService.findAllForums(-1, -1));
		
		// setup forumForm for new Forum
		Forum forumForm = (Forum) model.get("forumForm");
		if (forumForm == null) {
			forumForm = new Forum();
		}
		mav.addObject("forumForm", forumForm);
		
		return mav;
	}

	/**
	 * 显示Forum{id}的拥有的Topic
	 * @param id
	 * @param model
	 * @return
	 * @throws AuthorizeException
	 */
	@RequestMapping( value = {"/{id}"})
	public ModelAndView show(@PathVariable Integer id, ModelMap model) throws AuthorizeException {
		ModelAndView mav = new ModelAndView("/forum/show.jsp");
		Forum forum = forumService.findForumByPrimaryKey(id);
		mav.addObject("forum", forum);
		
		// setup new topic form
		Topic topic = (Topic) model.get("topicForm");
		if (topic == null) {
			topic = new Topic();	
		}
		topic.setForum(forum);
		topic.setUser((User) model.get("crtUser"));
		mav.addObject("topicForm", topic);
		
		// setup admin multi delete toic form
		// TODO
		
		return mav;
	}
	
	@RequestMapping(value="/new", method=RequestMethod.POST)
	public ModelAndView newForum(@ModelAttribute("forumForm") Forum forumForm, BindingResult bindingResult,
			RedirectAttributes redirectAttributes, ModelMap model) throws NoLoginException, AuthorizeException {
		ModelAndView mav = new ModelAndView("redirect:/forum/");

		// check login
		User crtUser = (User) model.get("crtUser");
		if (crtUser == null) {
			throw new NoLoginException();
		}
		
		// check owner
		if (!authService.isAdmin(crtUser.getId())) {
			throw new AuthorizeException();
		}

		if (bindingResult.hasErrors()) {
			redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.forumForm", bindingResult);
			return mav;
		}
		
		User user = (User) model.get("crtUser");
		if (user == null) {
			throw new NoLoginException();
		}
		
		forumService.newForum(forumForm);
		
		mav.addObject("message", "new forum success");
		return mav;
	}
	
	@RequestMapping(value = {"/{id:\\d+}/delete"})
	public String delete(@PathVariable Integer id, @RequestHeader(value = "referer") String referer,
			RedirectAttributes redirectAttributes, ModelMap model) throws ForumNotFoundException, NoLoginException, AuthorizeException {
		System.out.println("try to delete forum: " + id);
		
		Forum forum = forumService.findForumByPrimaryKey(id);
		if (forum == null) {
			throw new ForumNotFoundException();
		}

		// check login
		User crtUser = (User) model.get("crtUser");
		if (crtUser == null) {
			throw new NoLoginException();
		}
		
		// check owner
		if (!authService.isForumAdmin(forum.getId(), crtUser.getId())) {
			throw new AuthorizeException();
		}
		
		forumService.deleteForum(id);
		
		System.out.println("redirect:" + referer);
		redirectAttributes.addFlashAttribute("message", "delete forum suceess");
		return "redirect:" + referer;
	}
}
