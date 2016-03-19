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
 * @ModelCoreReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/AuthorityController/.properties.webcontroller]
 * @generated
 */

@Controller("AuthorityController")
public class AuthorityController {

	/**
	 * DAO injected by Spring that manages Authority entities
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/AuthorityController/.properties.webcontroller#//@variables%5Bname='authorityDAO'%5D]
	 */
	@Autowired
	private AuthorityDAO authorityDAO;

	/**
	 * DAO injected by Spring that manages User entities
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/AuthorityController/.properties.webcontroller#//@variables%5Bname='userDAO'%5D]
	 */
	@Autowired
	private UserDAO userDAO;

	/**
	 * Service injected by Spring that provides CRUD operations for Authority entities
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/AuthorityController/.properties.webcontroller#//@variables%5Bname='authorityService'%5D]
	 */
	@Autowired
	private AuthorityService authorityService;

	/**
	 * Save an existing User entity
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/AuthorityController/saveAuthorityUser%7B681e5fd6-4986-4bb0-93d5-fb77741f3a16%7D/.properties.swoperation]
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
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/AuthorityController/streamBinary%7B444f4d1e-6406-49aa-b622-6e645006b122%7D/.properties.swoperation]
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
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/AuthorityController/selectAuthority%7Bf889e034-87d7-4291-809b-bf102227af70%7D/.properties.swoperation]
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
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/AuthorityController/listAuthoritys%7B8829c622-e7af-4fa2-a86e-bcbc01b1f987%7D/.properties.swoperation]
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
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/AuthorityController/editAuthority%7B241508e3-2a55-436f-b8c5-cfeb7db0be94%7D/.properties.swoperation]
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
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/AuthorityController/listAuthorityUser%7B7c34c9a3-833a-4f54-b782-ce8dd8792464%7D/.properties.swoperation]
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
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/AuthorityController/confirmDeleteAuthority%7B12d11bc9-927e-4fea-a995-3946a0ea2c56%7D/.properties.swoperation]
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
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/AuthorityController/confirmDeleteAuthorityUser%7B2afc9b0b-2416-4d50-ba52-2e335e088a6d%7D/.properties.swoperation]
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
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/AuthorityController/newAuthorityUser%7Bc3e2ceb2-128e-4aed-bed9-a5c83fbc181f%7D/.properties.swoperation]
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
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/AuthorityController/initBinder%7B9cf794ab-65f8-45a9-af29-ce0c0b68b372%7D/.properties.swoperation]
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
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/AuthorityController/editAuthorityUser%7B18d22d0c-4fb9-4da4-a094-dd47cbac5996%7D/.properties.swoperation]
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
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/AuthorityController/deleteAuthorityUser%7B23e0005f-1585-4403-835a-ec108d3b8ecd%7D/.properties.swoperation]
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
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/AuthorityController/indexAuthority%7Bd55bcbb8-e90e-4926-bb8b-7667615500f6%7D/.properties.swoperation]
	 */
	public String indexAuthority() {
		return "redirect:/indexAuthority";
	}

	/**
	 * Delete an existing Authority entity
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/AuthorityController/deleteAuthority%7Bfe923e17-ef5a-493b-9c38-87c18f6c8dc5%7D/.properties.swoperation]
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
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/AuthorityController/newAuthority%7B923a56ec-1c60-4cd3-aacf-743e1c8ba731%7D/.properties.swoperation]
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
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/AuthorityController/selectAuthorityUser%7B1eb89934-49ea-41e0-ac69-bc0e412968e5%7D/.properties.swoperation]
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
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/web/AuthorityController/saveAuthority%7B0caae76e-96e4-4373-b31e-70637a85a5cb%7D/.properties.swoperation]
	 */
	@RequestMapping("/saveAuthority")
	public String saveAuthority(@ModelAttribute Authority authority) {
		authorityService.saveAuthority(authority);
		return "forward:/indexAuthority";
	}
}