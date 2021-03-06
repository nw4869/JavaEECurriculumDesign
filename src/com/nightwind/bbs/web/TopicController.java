package com.nightwind.bbs.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nightwind.bbs.domain.Forum;
import com.nightwind.bbs.domain.Reply;
import com.nightwind.bbs.domain.Topic;
import com.nightwind.bbs.domain.User;
import com.nightwind.bbs.exception.AuthorizeException;
import com.nightwind.bbs.exception.NoLoginException;
import com.nightwind.bbs.exception.TopicNotFoundException;
import com.nightwind.bbs.service.AuthService;
import com.nightwind.bbs.service.ForumService;
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
	
	@Autowired
	private ForumService forumService;
	
	@Autowired
	private AuthService authService;
	
	@RequestMapping("/{id:\\d+}")
	public ModelAndView show(@PathVariable("id") Integer id, ModelMap model) throws TopicNotFoundException {
//		System.out.println(model);
		ModelAndView mav = new ModelAndView("/topic/show.jsp");
		Topic topic = topicService.findTopicByPrimaryKey(id);
		topicService.increaseClick(id);
//		System.out.println("clicks: " + topic.getClicks());
		mav.addObject("topic", topic);
		
		// setup new reply form
		Reply replyForm = (Reply) model.get("replyForm");
		if (replyForm == null) {
			replyForm = new Reply();
		}
		replyForm.setTopic(topic);
		replyForm.setUser((User) model.get("crtUser"));
		mav.addObject("replyForm", replyForm);
		
		// authority
		mav.addObject("isAdmin", authService.isAdmin(Utils.getCrtUserId(model)));
		mav.addObject("isForumAdmin", authService.isForumAdmin(topic.getForum().getId(), Utils.getCrtUserId(model)));
		
		return mav;
	}
	
	@RequestMapping("/hot")
	public ModelAndView hot(
			@RequestParam(value="page", required=false) Integer page,
			@RequestParam(value="maxRows", required=false) Integer maxRows,
			ModelMap model) {
		ModelAndView mav = new ModelAndView("topic/hot.jsp");

		// setup page and page count
		if (page == null) {
			page = 1;
		}
		if (maxRows == null) {
			maxRows = 4;
		}		
		int startResult = (page - 1) * maxRows;

		mav.addObject("page", page);
		mav.addObject("maxRows", maxRows);
		mav.addObject("pageCount", topicService.countTopics(-1) / maxRows + 1);
		
		mav.addObject("topics", topicService.findHotTopicsByClicks(startResult, maxRows ));
		
		// setup new topic form
		Topic topic = (Topic) model.get("topicForm");
		if (topic == null) {
			topic = new Topic();	
		}
		topic.setForum(new Forum());
		mav.addObject("topicForm", topic);
		
		// setup select 
		List<Forum> forums = forumService.findAllForums(-1, -1);
		Map<Integer, String> forumMap = new HashMap<>();
		for(Forum forum: forums) {
			forumMap.put(forum.getId(), forum.getTitle());
		}
		mav.addObject("forumMap", forumMap);
		
		return mav;
	}

	@RequestMapping("/save")
	public String save(@Valid @ModelAttribute("topicForm") Topic topic, BindingResult bindingResult, 
			RedirectAttributes redirectAttributes, ModelMap model) throws NoLoginException {
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
			throw new NoLoginException();
		}
		
		topic.setUser(user);
		topic = topicService.newTopic(topic);
		return "redirect:/topic/" + topic.getId();
	}
	
	@RequestMapping( value = "/{id}/update", method=RequestMethod.GET)
	public ModelAndView displayUpdate(@PathVariable("id") Integer id,
			ModelMap model
			) throws TopicNotFoundException, NoLoginException, AuthorizeException {
		ModelAndView mav = new ModelAndView("topic/update.jsp");

		// validate authorize
		User user = (User) model.get("crtUser");
		if (user == null ) {
			throw new NoLoginException();
		}
		
		Topic existingTopic = topicService.findTopicByPrimaryKey(id);
		if (existingTopic == null) {
			throw new TopicNotFoundException();
		}
		
		if (!user.getId().equals(existingTopic.getUser().getId())) {
			throw new AuthorizeException();
		}
		
		mav.addObject("topicForm", existingTopic);
		
		return mav;
	}
	
	@RequestMapping( value = "/{id}/update", method=RequestMethod.POST)
	public String update(@PathVariable("id") Integer id, @Valid @ModelAttribute("topicForm") Topic topic, BindingResult bindingResult, 
			RedirectAttributes redirectAttributes, ModelMap model) throws NoLoginException, AuthorizeException, TopicNotFoundException {
//		System.out.println("try to save topic: " + topic);
		if (bindingResult.hasErrors()) {
			System.out.println(bindingResult);
			redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.topicForm", bindingResult);
			redirectAttributes.addFlashAttribute("topicForm", topic);
			return "redirect:/topic/" + topic.getForum().getId();
		}
		
		// validate authorize
		User user = (User) model.get("crtUser");
		if (user == null ) {
			throw new NoLoginException();
		}
		
		Topic existingTopic = topicService.findTopicByPrimaryKey(id);
		if (existingTopic == null) {
			throw new TopicNotFoundException();
		}
		
		if (!user.getId().equals(existingTopic.getUser().getId())) {
			throw new AuthorizeException();
		}
		
		existingTopic.setTitle(topic.getTitle());
		existingTopic.setContent(topic.getContent());
		
		topic = topicService.saveTopic(existingTopic);
		return "redirect:/topic/" + topic.getId();
	}

	@RequestMapping("/{id:\\d+}/reply")
	public ModelAndView reply(@PathVariable Integer id, @Valid @ModelAttribute("replyForm") Reply reply, BindingResult bingResult, 
			RedirectAttributes redirectAttributes, ModelMap model) throws NoLoginException {
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
			throw new NoLoginException();
		}
		
//		topicService.newTopicReply(id, user.getId(), reply);
		reply.setUser(user);
		reply = replyService.newReply(reply);
		return mav;
	}
	
	@RequestMapping(value = {"/{id:\\d+}/delete"})
	public String delete(@PathVariable Integer id, @RequestHeader(value = "referer") String referer,
			RedirectAttributes redirectAttributes, ModelMap model) throws TopicNotFoundException, NoLoginException, AuthorizeException {

		Topic topic = topicService.findTopicByPrimaryKey(id);
		if (topic == null) {
			throw new TopicNotFoundException();
		}

		// check login
		User crtUser = (User) model.get("crtUser");
		if (crtUser == null) {
			throw new NoLoginException();
		}
		
		// check owner
		if (topic.getUser() != null && crtUser.getId() != topic.getUser().getId()) {
			if (!authService.isForumAdmin(topic.getForum().getId(), crtUser.getId())) {
				throw new AuthorizeException();
			}
		}
		
		topicService.deleteTopic(id);
		
		redirectAttributes.addFlashAttribute("message", "delete topic suceess");
		return "redirect:" + referer;
	}
}
