package com.nightwind.bbs.web;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nightwind.bbs.domain.User;
import com.nightwind.bbs.exception.AuthorizeException;
import com.nightwind.bbs.exception.NoLoginException;
import com.nightwind.bbs.exception.TopicNotFoundException;
import com.nightwind.bbs.exception.UserNotFoundException;
import com.nightwind.bbs.service.AuthService;
import com.nightwind.bbs.service.UserService;

@SessionAttributes("crtUser")
@Controller("UserController")
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private AuthService authService;
	
	@RequestMapping(value = {"", "/"}, method= RequestMethod.GET)
	public String index(ModelMap model) throws UserNotFoundException {
		User user = (User) model.get("crtUser");
		if (user != null && user.getId() != null) {
			return "redirect:/user/" + user.getId();
		} else {
			return "redirect:/auth/login";
		}
	}

	@RequestMapping(value = {"/{id}"}, method = RequestMethod.GET)
	public ModelAndView info(@PathVariable(value = "id")  Integer id, ModelMap model) throws UserNotFoundException {
		ModelAndView mav = new ModelAndView();
		
		// 直接已经登录且id是用户，直接跳到更新页面
		User user = (User) model.get("crtUser");
		if (user != null && user.getId().equals(id)) {
			mav.setViewName("redirect:/user/update");
			return mav;
		}
			
		mav.addObject("user", userService.findUserById(id));
		mav.setViewName("user/index.jsp");
		return mav;
	}
	

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public ModelAndView displayUpdateInfo(User user, ModelMap model) {
		ModelAndView mav = new ModelAndView("user/update.jsp");
		
		User crtUser = (User) model.get("crtUser");
//		System.out.println("crtUser: " + crtUser);
//		System.out.println("user: " + user);
		if (crtUser == null) {
			// not login
			mav.setViewName("redirect:/auth/login");
			return mav;
		}
		
		if (user.getMemberTitle() == null || user.getMemberTitle().length() != 0) {
			user.setMemberTitle(crtUser.getMemberTitle());
		}
		if (user.getEmail() == null || user.getEmail().length() == 0) {
			user.setEmail(crtUser.getEmail());
		}
		if (user.getSignature() == null || user.getEmail().length() == 0) {
			user.setSignature(crtUser.getSignature());
		}
		mav.addObject("userForm", user);
		return mav;
	}
	
	@RequestMapping(value = "/uploadAvatar", method=RequestMethod.POST)
	public String uploadAvatar(@RequestParam("uploadAvatar") MultipartFile file,
			   RedirectAttributes redirectAttributes, ModelMap model, HttpServletRequest request) throws AuthorizeException {
		
		User crtUser = (User) model.get("crtUser");
		if (crtUser == null) {
			throw new AuthorizeException("upload avatar");
		}
		
		if (!file.isEmpty()) {
			try {
				String basePath = request.getSession().getServletContext().getRealPath("");
				String avatarPath = crtUser.getId() + "/" + UUID.randomUUID().toString() + ".jpg";
				file.transferTo(new File(basePath + "/" + avatarPath));
				userService.updateAvatar(crtUser.getId(), avatarPath);
				redirectAttributes.addFlashAttribute("message",
						"You successfully uploaded avatar!");
			}
			catch (Exception e) {
				redirectAttributes.addFlashAttribute("message",
						"You failed to upload avatar => " + e.getMessage());
			}
			
		}
		else {
			redirectAttributes.addFlashAttribute("message",
					"You failed to upload avatar because the file was empty");
		}
		return "redirect:/user/update";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView updateInfo(@Valid @ModelAttribute("userForm") User user,
			BindingResult result, ModelMap model, RedirectAttributes redirectAttributes)  throws UserNotFoundException {
		ModelAndView mav = new ModelAndView("user/update.jsp");

		User crtUser = (User) model.get("crtUser");
		if (crtUser == null) {
			// not login
			mav.setViewName("redirect:/auth/login");
		}
		
		for (FieldError err: result.getFieldErrors()) {
			if (!err.getField().equals("username") && !err.getField().equals("password")) {
				redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userForm", result);
				return mav;
			}
		}
		
		// 上传图片

		user.setId(crtUser.getId());
		crtUser = userService.updateInfo(user);
		mav.addObject("crtUser", crtUser);
		mav.addObject("message", "update success");

		
		return mav;
	}
	
	@RequestMapping(value = {"/{id:\\d+}/delete"})
	public String delete(@PathVariable Integer id, @RequestHeader(value = "referer") String referer,
			RedirectAttributes redirectAttributes, ModelMap model) throws UserNotFoundException, AuthorizeException, NoLoginException {
		System.out.println("try to delete user: " + id);

		// check login
		User crtUser = (User) model.get("crtUser");
		if (crtUser == null) {
			throw new NoLoginException();
		}
		
		// check owner
		if (crtUser.getId() != id) {
			if (!authService.isAdmin(crtUser.getId())) {
				throw new AuthorizeException();
			}	
		}
		
		userService.deleteUser(id);
		
		System.out.println("redirect:" + referer);
		redirectAttributes.addFlashAttribute("message", "delete user suceess");
		return "redirect:" + referer;
	}
}
