package com.nightwind.bbs.service;

import java.util.List;

import com.nightwind.bbs.domain.Forum;
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

	List<Forum> getAdminForums(Integer userId);

	void setForumsAdmin(Integer[] forumIds, Integer userId)
			throws UserNotFoundException, ForumNotFoundException;

	void clearAuthority(Integer userId) throws UserNotFoundException;
}
