package com.nightwind.bbs.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.nightwind.bbs.domain.Comment;
import com.nightwind.bbs.domain.ForumThread;
import com.nightwind.bbs.domain.User;
import com.nightwind.bbs.service.ForumThreadService;

@SessionAttributes("crtUser")
@RequestMapping("/topic")
@Controller
public class TopicController {

	@Autowired
	private ForumThreadService forumThreadService;
	
	@RequestMapping("/{id}")
	public ModelAndView show(@PathVariable Integer id, ModelMap model) {
		ModelAndView mav = new ModelAndView("/topic/show.jsp");
		ForumThread topic = forumThreadService.findForumThreadByPrimaryKey(id);
		mav.addObject("topic", topic);
		
		// setup new reply form
		Comment reply = new Comment();
		reply.setForumThread(forumThreadService.findForumThreadByPrimaryKey(id));
		reply.setUser((User) model.get("crtUser"));
		mav.addObject("replyForm", reply);
		
		return mav;
	}

	@RequestMapping("/save")
	public String save(@ModelAttribute("topicForm") ForumThread topic) {
		System.out.println("try to save topic: " + topic);
		topic.setId(null);
		topic = forumThreadService.saveForumThread(topic);
		return "redirect:/topic/" + topic.getId();
	}

	@RequestMapping("/{id}/reply")
	public String reply(@PathVariable Integer id, @ModelAttribute("replyForm") Comment reply) {
		System.out.println("try to save reply: " + reply);
		reply.setId(null);
		forumThreadService.saveForumThreadComments(id, reply);
		return "redirect:/topic/" + id;
	}
}
