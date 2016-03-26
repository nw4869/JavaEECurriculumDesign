package com.nightwind.bbs.service;

import com.nightwind.bbs.exception.ForumNotFoundException;
import com.nightwind.bbs.exception.UserNotFoundException;

public interface AuthService {
	
	Boolean isAdmin(Integer userId);
	
	Boolean isAdmin(String username);
	
	Boolean isForumAdmin(Integer forumId, Integer userId);
	
	Boolean isForumAdmin(Integer forumId, String username);

	void setAdmin(Integer userId, Boolean set) throws UserNotFoundException;

	void setForumAdmin(Integer forumId, Integer userId, Boolean set)
			throws UserNotFoundException, ForumNotFoundException;
}
