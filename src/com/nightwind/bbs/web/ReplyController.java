package com.nightwind.bbs.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nightwind.bbs.domain.Reply;
import com.nightwind.bbs.domain.User;
import com.nightwind.bbs.exception.AuthorizeException;
import com.nightwind.bbs.exception.NoLoginException;
import com.nightwind.bbs.exception.ReplyNotFoundException;
import com.nightwind.bbs.service.AuthService;
import com.nightwind.bbs.service.ReplyService;

@SessionAttributes({"crtUser"})
@RequestMapping("/reply")
@Controller
public class ReplyController {

	@Autowired
	private ReplyService replyService;
	
	@Autowired
	private AuthService authService;
	
	@RequestMapping(value = {"/{id:\\d+}/delete"})
	public String delete(@PathVariable Integer id, @RequestHeader(value = "referer") String referer,
			RedirectAttributes redirectAttributes, ModelMap model) throws ReplyNotFoundException, AuthorizeException, NoLoginException {
		System.out.println("try to delete reply: " + id);
		
		Reply reply = replyService.findReplyByPrimaryKey(id);
		if (reply == null) {
			throw new ReplyNotFoundException();
		}
		
		// check login
		User crtUser = (User) model.get("crtUser");
		if (crtUser == null) {
			throw new NoLoginException();
		}
		
		// check owner
		if (reply.getUser() != null && crtUser.getId() != reply.getUser().getId()) {
			if (!authService.isForumAdmin(reply.getTopic().getForum().getId(), crtUser.getId())) {
				throw new AuthorizeException();
			}
		}
		
		
		replyService.deleteReply(id);
		
		System.out.println("redirect:" + referer);
		redirectAttributes.addFlashAttribute("message", "delete reply suceess");
		return "redirect:" + referer;
	}
}
