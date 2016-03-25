package com.nightwind.bbs.service;

public interface AuthService {
	
	Boolean isAdmin(Integer userId);
	
	Boolean isAdmin(String username);
	
	Boolean isForumAdmin(Integer forumId, Integer userId);
	
	Boolean isForumAdmin(Integer forumId, String username);
}
