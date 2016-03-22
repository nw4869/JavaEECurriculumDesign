package com.nightwind.bbs.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nightwind.bbs.domain.Reply;
import com.nightwind.bbs.domain.Topic;
import com.nightwind.bbs.domain.User;
import com.nightwind.bbs.exception.AuthorizeException;
import com.nightwind.bbs.service.ReplyService;
import com.nightwind.bbs.service.TopicService;

@SessionAttributes({"crtUser"})
@RequestMapping("/topic")
@Controller
public class TopicController {

	@Autowired
	private TopicService topicService;
	
	@Autowired
	private ReplyService replyService;
	
	@RequestMapping("/{id}")
	public ModelAndView show(@PathVariable Integer id, ModelMap model) {
//		System.out.println(model);
		ModelAndView mav = new ModelAndView("/topic/show.jsp");
		Topic topic = topicService.findTopicByPrimaryKey(id);
		mav.addObject("topic", topic);
		
		// setup new reply form
		Reply replyForm = (Reply) model.get("replyForm");
		if (replyForm == null) {
			replyForm = new Reply();
		}
		replyForm.setTopic(topicService.findTopicByPrimaryKey(id));
		replyForm.setUser((User) model.get("crtUser"));
		mav.addObject("replyForm", replyForm);
		
		return mav;
	}

	@RequestMapping("/save")
	public String save(@Valid @ModelAttribute("topicForm") Topic topic, BindingResult bindingResult, 
			RedirectAttributes redirectAttributes, ModelMap model) throws AuthorizeException {
//		System.out.println("try to save topic: " + topic);
		if (bindingResult.hasErrors()) {
			System.out.println(bindingResult);
			redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.topicForm", bindingResult);
			redirectAttributes.addFlashAttribute("topicForm", topic);
			return "redirect:/forum/" + topic.getForum().getId();
		}
		
		// validate authorize
		User user = (User) model.get("crtUser");
		if (user == null) {
			throw new AuthorizeException();
		}
		
		topic = topicService.newTopic(topic);
		return "redirect:/topic/" + topic.getId();
	}

	@RequestMapping("/{id}/reply")
	public ModelAndView reply(@PathVariable Integer id, @Valid @ModelAttribute("replyForm") Reply reply, BindingResult bingResult, 
			RedirectAttributes redirectAttributes, ModelMap model) throws AuthorizeException {
		ModelAndView mav = new ModelAndView("redirect:/topic/" + id);
		if (bingResult.hasErrors()) {
//			System.out.println(bingResult);
			redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.replyForm", bingResult);
			redirectAttributes.addFlashAttribute("replyForm", reply);
			return mav;
		}

		// validate authorize
		User user = (User) model.get("crtUser");
		if (user == null) {
			throw new AuthorizeException();
		}
		
//		topicService.newTopicReply(id, user.getId(), reply);
		reply = replyService.newReply(reply);
		return mav;
	}
}
