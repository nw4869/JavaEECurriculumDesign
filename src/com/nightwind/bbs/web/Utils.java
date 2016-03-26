package com.nightwind.bbs.web;

import org.springframework.ui.ModelMap;

import com.nightwind.bbs.domain.User;

public class Utils {

	static User getCrtUser(ModelMap model) {
		return (User) model.get("crtUser");
	}
	
	static Integer getCrtUserId(ModelMap model) {
		return getCrtUser(model) != null ? getCrtUser(model).getId() : null;
	}
	
	static String getCrtUseranem(ModelMap model) {
		return getCrtUser(model) != null ? getCrtUser(model).getUsername() : null;
	}
	
	static boolean isNotBlank(String str) {
		return str != null && str.trim().length() > 0;
	}
}
