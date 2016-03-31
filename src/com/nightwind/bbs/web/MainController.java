package com.nightwind.bbs.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nightwind.bbs.domain.Topic;
import com.nightwind.bbs.service.ReplyService;
import com.nightwind.bbs.service.TopicService;

@RequestMapping(value="/")
@Controller
public class MainController {
	
	@Autowired
	private TopicService topicService;
	
	@Autowired
	private ReplyService replyService;

	@RequestMapping(value = {"/", "/index"}, method=RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("index.jsp");
		return mav;
	}	
	
	@RequestMapping("/test1")
	public ModelAndView test() {
		ModelAndView mav = new ModelAndView("test1.jsp");
		return mav;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/search") 
	public ModelAndView search(String search,
			@RequestParam(value="page", required=false) Integer page,
			@RequestParam(value="maxRows", required=false) Integer maxRows) {
		ModelAndView mav = new ModelAndView("search.jsp");
		
		if (!Utils.isNotBlank(search)) {
			mav.addObject("message", "不能为空");
			return mav;
		} 

		
		// setup page and page count
		if (page == null) {
			page = 1;
		}
		if (maxRows == null) {
			maxRows = 10;
		}
		int startResult = (page - 1) * maxRows;
		
		Object[] result = topicService.searchTopic(search, startResult, maxRows);
		List<Topic> topics = (List<Topic>) result[0];
		Long pageCount = (Long)result[1] / maxRows + 1;
		
		mav.addObject("topics", topics);
		mav.addObject("pageCount", pageCount);
		mav.addObject("page", page);
		mav.addObject("maxRows", maxRows);
		
		return mav;
	}
}
