package com.nightwind.bbs.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping(value="/")
@Controller
public class MainController {

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
}
