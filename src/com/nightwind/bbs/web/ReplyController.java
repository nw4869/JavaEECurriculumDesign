package com.nightwind.bbs.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nightwind.bbs.exception.ReplyNotFoundException;
import com.nightwind.bbs.service.ReplyService;

@SessionAttributes({"crtUser"})
@RequestMapping("/reply")
@Controller
public class ReplyController {

	@Autowired
	private ReplyService replyService;
	
	@RequestMapping(value = {"/{id:\\d+}/delete"})
	public String delete(@PathVariable Integer id, @RequestHeader(value = "referer") String referer,
			RedirectAttributes redirectAttributes) throws ReplyNotFoundException {
		System.out.println("try to delete reply: " + id);
		
		replyService.deleteReply(id);
		
		System.out.println("redirect:" + referer);
		redirectAttributes.addFlashAttribute("message", "delete reply suceess");
		return "redirect:" + referer;
	}
}
