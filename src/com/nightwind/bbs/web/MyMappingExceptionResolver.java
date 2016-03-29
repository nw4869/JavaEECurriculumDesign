package com.nightwind.bbs.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

public class MyMappingExceptionResolver extends SimpleMappingExceptionResolver {
	
    @Override
    protected ModelAndView doResolveException(HttpServletRequest request,
            HttpServletResponse response, Object handler, Exception exception) {
        // Call super method to get the ModelAndView
        ModelAndView mav = super.doResolveException(request, response, handler, exception);
        
//        if (mav == null) {
//        	mav = new ModelAndView();
//        	if (exception instanceof NoLoginException) {
//        		mav.addObject("message", "请先登录");
//        		mav.setViewName("redirect:/auth/login");
//        	}
//        }
        
        // Make the full URL available to the view - note ModelAndView uses addObject()
        // but Model uses addAttribute(). They work the same.
        if (mav != null) {
            mav.addObject("referer",  request.getRequestURL());	
        }
        return mav;
    }
}
