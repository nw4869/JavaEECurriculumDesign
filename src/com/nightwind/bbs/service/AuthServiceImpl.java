package com.nightwind.bbs.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.nightwind.bbs.dao.AuthorityDAO;
import com.nightwind.bbs.dao.UserDAO;
import com.nightwind.bbs.domain.Authority;
import com.nightwind.bbs.domain.Forum;
import com.nightwind.bbs.domain.User;

public class AuthServiceImpl implements AuthService {

	static public final String ROLE_ADMIN = "ROLE_ADMIN";
	
	static public final String ROLE_FORUM_ADMIN = "ROLE_FORUM_ADMIN";
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private AuthorityDAO authorityDAO;
	
	protected User getUser(Integer id) {
		return userDAO.findUserById(id);
	}
	
	protected User getUser(String username) {
		return userDAO.findUserByUsername(username).iterator().next();
	}
	
	protected Boolean containRole(User user, String role, Integer forumId) {
		try {
			for (Authority auth: user.getAuthorities()) {
				if (auth.getAuthorityField().equals(role) &&
						(forumId == null && auth.getForum() == null || forumId == auth.getForum().getId()) ) {
					return true;
				}
			}
		} catch (Exception ignored) {
		}
		return false;
	}
	
	@Override
	public Boolean isAdmin(Integer userId) {
		return containRole(getUser(userId), ROLE_ADMIN, null);
	}

	@Override
	public Boolean isAdmin(String username) {
		return containRole(getUser(username), ROLE_ADMIN, null);
	}

	@Override
	public Boolean isForumAdmin(Integer forumId, Integer userId) {
		return containRole(getUser(userId), ROLE_FORUM_ADMIN, forumId);
	}

	@Override
	public Boolean isForumAdmin(Integer forumId, String username) {
		return containRole(getUser(username), ROLE_FORUM_ADMIN, forumId);
	}
}
