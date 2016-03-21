package com.nightwind.bbs.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nightwind.bbs.domain.ForumThread;
import com.nightwind.bbs.service.ForumThreadService;

@RequestMapping("/topic")
@Controller
public class TopicController {

	@Autowired
	private ForumThreadService forumThreadService;
	
	@RequestMapping("/{id}")
	public ModelAndView show(@PathVariable Integer id) {
		ModelAndView mav = new ModelAndView("/topic/show.jsp");
		ForumThread topic = forumThreadService.findForumThreadByPrimaryKey(id);
		mav.addObject("topic", topic);
		System.out.println(topic.getComments());
		return mav;
	}
}
