package com.nightwind.bbs.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nightwind.bbs.dao.AuthorityDAO;
import com.nightwind.bbs.dao.ForumDAO;
import com.nightwind.bbs.dao.UserDAO;
import com.nightwind.bbs.domain.Authority;
import com.nightwind.bbs.domain.Forum;
import com.nightwind.bbs.domain.User;
import com.nightwind.bbs.exception.ForumNotFoundException;
import com.nightwind.bbs.exception.UserNotFoundException;

@Transactional
@Service("AuthService")
public class AuthServiceImpl implements AuthService {

	static public final String ROLE_ADMIN = "ROLE_ADMIN";
	
	static public final String ROLE_FORUM_ADMIN = "ROLE_FORUM_ADMIN";

	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private ForumDAO forumDAO;
	
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
	
	@Transactional
	@Override
	public void setAdmin(Integer userId, Boolean set) throws UserNotFoundException {
		User user = userDAO.findUserById(userId);
		if (user == null) {
			throw new UserNotFoundException();
		}
		clearAuthority(user.getId());

		if (set && !isAdmin(userId)) {
			Authority authority = new Authority();
			
			authority.setUser(user);
			authority.setAuthorityField(ROLE_ADMIN);
			authorityDAO.store(authority);
			authorityDAO.flush();
		} else {
			for (Authority authority: user.getAuthorities()) {
				if (authority.getAuthorityField().equals(ROLE_ADMIN)) {
					authorityDAO.remove(authority);
				}
			}
			authorityDAO.flush();
		}
	}

	@Transactional
	@Override
	public void setForumAdmin(Integer forumId, Integer userId, Boolean set) throws UserNotFoundException, ForumNotFoundException {
		User user = userDAO.findUserById(userId);
		if (user == null) {
			throw new UserNotFoundException();
		}
		Forum forum = forumDAO.findForumById(forumId);
		if (forum == null) {
			throw new ForumNotFoundException();
		}
		clearAuthority(user.getId());

		if (set && !isForumAdmin(forumId, userId)) {
			Authority authority = new Authority();
			
			authority.setForum(forum);
			authority.setUser(user);
			authority.setAuthorityField(ROLE_FORUM_ADMIN);
			authorityDAO.store(authority);
			authorityDAO.flush();
		} else {
			for (Authority authority: user.getAuthorities()) {
				if (authority.getAuthorityField().equals(ROLE_FORUM_ADMIN) && authority.getForum().getId() == forumId) {
					authorityDAO.remove(authority);
				}
			}
			authorityDAO.flush();
		}
	}
	
	@Transactional
	@Override
	public void setForumsAdmin(Integer[] forumIds, Integer userId) throws UserNotFoundException, ForumNotFoundException {
		User user = userDAO.findUserById(userId);
		if (user == null) {
			throw new UserNotFoundException();
		}
		clearAuthority(user.getId());
		for (Integer forumId: forumIds) {
			Forum forum = forumDAO.findForumById(forumId);
			if (forum == null) {
				throw new ForumNotFoundException();
			}
			
			Authority auth = new Authority();
			auth.setUser(user);
			auth.setAuthorityField(ROLE_FORUM_ADMIN);
			auth.setForum(forum);
			
			authorityDAO.store(auth);
		}
		authorityDAO.flush();
	}
	
	@Transactional
	@Override
	public void clearAuthority(Integer userId) throws UserNotFoundException {
		User user = userDAO.findUserById(userId);
		if (user == null) {
			throw new UserNotFoundException();
		}
		
		for (Authority auth: user.getAuthorities()) {
			authorityDAO.remove(auth);
		}
		authorityDAO.flush();
		
	}

	@Override
	public Boolean isForumAdmin(Integer forumId, Integer userId) {
		return isAdmin(userId) || containRole(getUser(userId), ROLE_FORUM_ADMIN, forumId);
	}

	@Override
	public Boolean isForumAdmin(Integer forumId, String username) {
		return isAdmin(username) ||containRole(getUser(username), ROLE_FORUM_ADMIN, forumId);
	}
	
	@Override
	public List<Forum> getAdminForums(Integer userId) {
		List<Forum> forumList = new ArrayList<>();
		User user = userDAO.findUserByPrimaryKey(userId);
		if (user == null) {
			return forumList;
		}
		if (isAdmin(userId)) {
			forumList.addAll(forumDAO.findAllForums());
			return forumList;
		} 
		
		for (Authority auth: user.getAuthorities()) {
			if (auth.getAuthorityField().equals(ROLE_FORUM_ADMIN)) {
				forumList.add(auth.getForum());
			}
		}
		return forumList;
	}
}
