package com.nightwind.bbs.web;

import com.nightwind.bbs.dao.AuthorityDAO;
import com.nightwind.bbs.dao.UserDAO;

import com.nightwind.bbs.domain.Authority;
import com.nightwind.bbs.domain.User;

import com.nightwind.bbs.service.AuthorityService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.WebDataBinder;

import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.servlet.ModelAndView;

/**
 * Spring MVC controller that handles CRUD requests for Authority entities
 * 
 * 
 * @generated
 */

@Controller("AuthorityController")
public class AuthorityController {

	/**
	 * DAO injected by Spring that manages Authority entities
	 * 
	 * 
	 */
	@Autowired
	private AuthorityDAO authorityDAO;

	/**
	 * DAO injected by Spring that manages User entities
	 * 
	 * 
	 */
	@Autowired
	private UserDAO userDAO;

	/**
	 * Service injected by Spring that provides CRUD operations for Authority entities
	 * 
	 * 
	 */
	@Autowired
	private AuthorityService authorityService;

	/**
	 * Save an existing User entity
	 * 
	 * 
	 */
	@RequestMapping("/saveAuthorityUser")
	public ModelAndView saveAuthorityUser(@RequestParam Integer authority_userId, @RequestParam String authority_authorityField, @ModelAttribute User user) {
		Authority parent_authority = authorityService.saveAuthorityUser(authority_userId, authority_authorityField, user);

		ModelAndView mav = new ModelAndView();
		mav.addObject("authority_userId", authority_userId);
		mav.addObject("authority_authorityField", authority_authorityField);
		mav.addObject("authority", parent_authority);
		mav.setViewName("authority/viewAuthority.jsp");

		return mav;
	}

	/**
	 * 
	 */
	@RequestMapping("/authorityController/binary.action")
	public ModelAndView streamBinary(@ModelAttribute HttpServletRequest request, @ModelAttribute HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("streamedBinaryContentView");
		return mav;

	}

	/**
	 * Select an existing Authority entity
	 * 
	 * 
	 */
	@RequestMapping("/selectAuthority")
	public ModelAndView selectAuthority(@RequestParam Integer userIdKey, @RequestParam String authorityFieldKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("authority", authorityDAO.findAuthorityByPrimaryKey(userIdKey, authorityFieldKey));
		mav.setViewName("authority/viewAuthority.jsp");

		return mav;
	}

	/**
	 * Show all Authority entities
	 * 
	 * 
	 */
	@RequestMapping("/indexAuthority")
	public ModelAndView listAuthoritys() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("authoritys", authorityService.loadAuthoritys());

		mav.setViewName("authority/listAuthoritys.jsp");

		return mav;
	}

	/**
	 * Edit an existing Authority entity
	 * 
	 * 
	 */
	@RequestMapping("/editAuthority")
	public ModelAndView editAuthority(@RequestParam Integer userIdKey, @RequestParam String authorityFieldKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("authority", authorityDAO.findAuthorityByPrimaryKey(userIdKey, authorityFieldKey));
		mav.setViewName("authority/editAuthority.jsp");

		return mav;
	}

	/**
	 * Show all User entities by Authority
	 * 
	 * 
	 */
	@RequestMapping("/listAuthorityUser")
	public ModelAndView listAuthorityUser(@RequestParam Integer userIdKey, @RequestParam String authorityFieldKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("authority", authorityDAO.findAuthorityByPrimaryKey(userIdKey, authorityFieldKey));
		mav.setViewName("authority/user/listUser.jsp");

		return mav;
	}

	/**
	 * Select the Authority entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 * 
	 */
	@RequestMapping("/confirmDeleteAuthority")
	public ModelAndView confirmDeleteAuthority(@RequestParam Integer userIdKey, @RequestParam String authorityFieldKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("authority", authorityDAO.findAuthorityByPrimaryKey(userIdKey, authorityFieldKey));
		mav.setViewName("authority/deleteAuthority.jsp");

		return mav;
	}

	/**
	 * Select the child User entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 * 
	 */
	@RequestMapping("/confirmDeleteAuthorityUser")
	public ModelAndView confirmDeleteAuthorityUser(@RequestParam Integer authority_userId, @RequestParam String authority_authorityField, @RequestParam Integer related_user_id) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("user", userDAO.findUserByPrimaryKey(related_user_id));
		mav.addObject("authority_userId", authority_userId);
		mav.addObject("authority_authorityField", authority_authorityField);
		mav.setViewName("authority/user/deleteUser.jsp");

		return mav;
	}

	/**
	 * Create a new User entity
	 * 
	 * 
	 */
	@RequestMapping("/newAuthorityUser")
	public ModelAndView newAuthorityUser(@RequestParam Integer authority_userId, @RequestParam String authority_authorityField) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("authority_userId", authority_userId);
		mav.addObject("authority_authorityField", authority_authorityField);
		mav.addObject("user", new User());
		mav.addObject("newFlag", true);
		mav.setViewName("authority/user/editUser.jsp");

		return mav;
	}

	/**
	 * Register custom, context-specific property editors
	 * 
	 * 
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder, HttpServletRequest request) { // Register static property editors.
		binder.registerCustomEditor(java.util.Calendar.class, new org.skyway.spring.util.databinding.CustomCalendarEditor());
		binder.registerCustomEditor(byte[].class, new org.springframework.web.multipart.support.ByteArrayMultipartFileEditor());
		binder.registerCustomEditor(boolean.class, new org.skyway.spring.util.databinding.EnhancedBooleanEditor(false));
		binder.registerCustomEditor(Boolean.class, new org.skyway.spring.util.databinding.EnhancedBooleanEditor(true));
		binder.registerCustomEditor(java.math.BigDecimal.class, new org.skyway.spring.util.databinding.NaNHandlingNumberEditor(java.math.BigDecimal.class, true));
		binder.registerCustomEditor(Integer.class, new org.skyway.spring.util.databinding.NaNHandlingNumberEditor(Integer.class, true));
		binder.registerCustomEditor(java.util.Date.class, new org.skyway.spring.util.databinding.CustomDateEditor());
		binder.registerCustomEditor(String.class, new org.skyway.spring.util.databinding.StringEditor());
		binder.registerCustomEditor(Long.class, new org.skyway.spring.util.databinding.NaNHandlingNumberEditor(Long.class, true));
		binder.registerCustomEditor(Double.class, new org.skyway.spring.util.databinding.NaNHandlingNumberEditor(Double.class, true));
	}

	/**
	 * Edit an existing User entity
	 * 
	 * 
	 */
	@RequestMapping("/editAuthorityUser")
	public ModelAndView editAuthorityUser(@RequestParam Integer authority_userId, @RequestParam String authority_authorityField, @RequestParam Integer user_id) {
		User user = userDAO.findUserByPrimaryKey(user_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("authority_userId", authority_userId);
		mav.addObject("authority_authorityField", authority_authorityField);
		mav.addObject("user", user);
		mav.setViewName("authority/user/editUser.jsp");

		return mav;
	}

	/**
	 * Delete an existing User entity
	 * 
	 * 
	 */
	@RequestMapping("/deleteAuthorityUser")
	public ModelAndView deleteAuthorityUser(@RequestParam Integer authority_userId, @RequestParam String authority_authorityField, @RequestParam Integer related_user_id) {
		ModelAndView mav = new ModelAndView();

		Authority authority = authorityService.deleteAuthorityUser(authority_userId, authority_authorityField, related_user_id);

		mav.addObject("authority_userId", authority_userId);
		mav.addObject("authority_authorityField", authority_authorityField);
		mav.addObject("authority", authority);
		mav.setViewName("authority/viewAuthority.jsp");

		return mav;
	}

	/**
	 * Entry point to show all Authority entities
	 * 
	 * 
	 */
	public String indexAuthority() {
		return "redirect:/indexAuthority";
	}

	/**
	 * Delete an existing Authority entity
	 * 
	 * 
	 */
	@RequestMapping("/deleteAuthority")
	public String deleteAuthority(@RequestParam Integer userIdKey, @RequestParam String authorityFieldKey) {
		Authority authority = authorityDAO.findAuthorityByPrimaryKey(userIdKey, authorityFieldKey);
		authorityService.deleteAuthority(authority);
		return "forward:/indexAuthority";
	}

	/**
	 * Create a new Authority entity
	 * 
	 * 
	 */
	@RequestMapping("/newAuthority")
	public ModelAndView newAuthority() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("authority", new Authority());
		mav.addObject("newFlag", true);
		mav.setViewName("authority/editAuthority.jsp");

		return mav;
	}

	/**
	 * View an existing User entity
	 * 
	 * 
	 */
	@RequestMapping("/selectAuthorityUser")
	public ModelAndView selectAuthorityUser(@RequestParam Integer authority_userId, @RequestParam String authority_authorityField, @RequestParam Integer user_id) {
		User user = userDAO.findUserByPrimaryKey(user_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("authority_userId", authority_userId);
		mav.addObject("authority_authorityField", authority_authorityField);
		mav.addObject("user", user);
		mav.setViewName("authority/user/viewUser.jsp");

		return mav;
	}

	/**
	 * Save an existing Authority entity
	 * 
	 * 
	 */
	@RequestMapping("/saveAuthority")
	public String saveAuthority(@ModelAttribute Authority authority) {
		authorityService.saveAuthority(authority);
		return "forward:/indexAuthority";
	}
}