package com.nightwind.bbs.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.nightwind.bbs.domain.Forum;
import com.nightwind.bbs.domain.Topic;
import com.nightwind.bbs.domain.User;
import com.nightwind.bbs.exception.AuthorizeException;
import com.nightwind.bbs.service.ForumService;

@SessionAttributes("crtUser")
@RequestMapping("/forum")
@Controller
public class ForumController {

	@Autowired
	private ForumService forumService;
	
	
	@RequestMapping( value = {"/", ""})
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView("/forum/index.jsp");
		mav.addObject("forums", forumService.findAllForums(-1, -1));
		return mav;
	}

	@RequestMapping( value = {"/{id}"})
	public ModelAndView show(@PathVariable Integer id, ModelMap model) throws AuthorizeException {
		ModelAndView mav = new ModelAndView("/forum/show.jsp");
		mav.addObject("forum", forumService.findForumByPrimaryKey(id));
		
		// setup new topic form
		Topic topic = (Topic) model.get("topicForm");
		if (topic == null) {
			topic = new Topic();	
		}
		
		topic.setForum(forumService.findForumByPrimaryKey(id));
		topic.setUser((User) model.get("crtUser"));
		mav.addObject("topicForm", topic);
		
		return mav;
	}
	
	@RequestMapping("/new")
	public ModelAndView newForum() {
		ModelAndView mav = new ModelAndView("/forum/new.jsp");
		
		// TODO 
		
		return mav;
	}
}
