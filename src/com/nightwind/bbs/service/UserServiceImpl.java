package com.nightwind.bbs.service;

import com.nightwind.bbs.dao.AuthorityDAO;
import com.nightwind.bbs.dao.CommentDAO;
import com.nightwind.bbs.dao.ForumThreadDAO;
import com.nightwind.bbs.dao.UserDAO;

import com.nightwind.bbs.domain.Authority;
import com.nightwind.bbs.domain.Comment;
import com.nightwind.bbs.domain.ForumThread;
import com.nightwind.bbs.domain.User;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

/**
 * Spring service that handles CRUD requests for User entities
 * 
 * 
 * @generated
 */

@Service("UserService")
@Transactional
public class UserServiceImpl implements UserService {

	/**
	 * DAO injected by Spring that manages Authority entities
	 * 
	 * 
	 */
	@Autowired
	private AuthorityDAO authorityDAO;

	/**
	 * DAO injected by Spring that manages Comment entities
	 * 
	 * 
	 */
	@Autowired
	private CommentDAO commentDAO;

	/**
	 * DAO injected by Spring that manages ForumThread entities
	 * 
	 * 
	 */
	@Autowired
	private ForumThreadDAO forumThreadDAO;

	/**
	 * DAO injected by Spring that manages User entities
	 * 
	 * 
	 */
	@Autowired
	private UserDAO userDAO;

	/**
	 * Instantiates a new UserServiceImpl.
	 *
	 * 
	 * @AuxiliaryModelComponent
	 */
	public UserServiceImpl() {
	}

	/**
	 * Delete an existing User entity
	 * 
	 * 
	 */
	@Transactional
	public void deleteUser(User user) {
		userDAO.remove(user);
		userDAO.flush();
	}

	/**
	 * Return all User entity
	 * 
	 * 
	 */
	@Transactional
	public List<User> findAllUsers(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<User>(userDAO.findAllUsers(startResult, maxRows));
	}

	/**
	 * Delete an existing ForumThread entity
	 * 
	 * 
	 */
	@Transactional
	public User deleteUserForumThreads(Integer user_id, Integer related_forumthreads_id) {
		ForumThread related_forumthreads = forumThreadDAO.findForumThreadByPrimaryKey(related_forumthreads_id, -1, -1);

		User user = userDAO.findUserByPrimaryKey(user_id, -1, -1);

		related_forumthreads.setUser(null);
		user.getForumThreads().remove(related_forumthreads);

		forumThreadDAO.remove(related_forumthreads);
		forumThreadDAO.flush();

		return user;
	}

	/**
	 * Save an existing ForumThread entity
	 * 
	 * 
	 */
	@Transactional
	public User saveUserForumThreads(Integer id, ForumThread related_forumthreads) {
		User user = userDAO.findUserByPrimaryKey(id, -1, -1);
		ForumThread existingforumThreads = forumThreadDAO.findForumThreadByPrimaryKey(related_forumthreads.getId());

		// copy into the existing record to preserve existing relationships
		if (existingforumThreads != null) {
			existingforumThreads.setId(related_forumthreads.getId());
			existingforumThreads.setTitle(related_forumthreads.getTitle());
			existingforumThreads.setContent(related_forumthreads.getContent());
			existingforumThreads.setCreateTime(related_forumthreads.getCreateTime());
			existingforumThreads.setLastModified(related_forumthreads.getLastModified());
			related_forumthreads = existingforumThreads;
		} else {
			related_forumthreads = forumThreadDAO.store(related_forumthreads);
			forumThreadDAO.flush();
		}

		related_forumthreads.setUser(user);
		user.getForumThreads().add(related_forumthreads);
		related_forumthreads = forumThreadDAO.store(related_forumthreads);
		forumThreadDAO.flush();

		user = userDAO.store(user);
		userDAO.flush();

		return user;
	}

	/**
	 * Save an existing User entity
	 * 
	 * 
	 */
	@Transactional
	public void saveUser(User user) {
		User existingUser = userDAO.findUserByPrimaryKey(user.getId());

		if (existingUser != null) {
			if (existingUser != user) {
				existingUser.setId(user.getId());
				existingUser.setUsername(user.getUsername());
				existingUser.setPassword(user.getPassword());
				existingUser.setEmail(user.getEmail());
				existingUser.setAvatar(user.getAvatar());
				existingUser.setMemberTitle(user.getMemberTitle());
				existingUser.setSignature(user.getSignature());
				existingUser.setEnabled(user.getEnabled());
				existingUser.setCreateTime(user.getCreateTime());
			}
			user = userDAO.store(existingUser);
		} else {
			user = userDAO.store(user);
		}
		userDAO.flush();
	}

	/**
	 * Save an existing Authority entity
	 * 
	 * 
	 */
	@Transactional
	public User saveUserAuthorities(Integer id, Authority related_authorities) {
		User user = userDAO.findUserByPrimaryKey(id, -1, -1);
		Authority existingauthorities = authorityDAO.findAuthorityByPrimaryKey(related_authorities.getUserId(), related_authorities.getAuthorityField());

		// copy into the existing record to preserve existing relationships
		if (existingauthorities != null) {
			existingauthorities.setUserId(related_authorities.getUserId());
			existingauthorities.setAuthorityField(related_authorities.getAuthorityField());
			related_authorities = existingauthorities;
		}

		related_authorities.setUser(user);
		user.getAuthorities().add(related_authorities);
		related_authorities = authorityDAO.store(related_authorities);
		authorityDAO.flush();

		user = userDAO.store(user);
		userDAO.flush();

		return user;
	}

	/**
	 * Delete an existing Authority entity
	 * 
	 * 
	 */
	@Transactional
	public User deleteUserAuthorities(Integer user_id, Integer related_authorities_userId, String related_authorities_authorityField) {
		Authority related_authorities = authorityDAO.findAuthorityByPrimaryKey(related_authorities_userId, related_authorities_authorityField, -1, -1);

		User user = userDAO.findUserByPrimaryKey(user_id, -1, -1);

		related_authorities.setUser(null);
		user.getAuthorities().remove(related_authorities);

		authorityDAO.remove(related_authorities);
		authorityDAO.flush();

		return user;
	}

	/**
	 * Return a count of all User entity
	 * 
	 * 
	 */
	@Transactional
	public Integer countUsers() {
		return ((Long) userDAO.createQuerySingleResult("select count(o) from User o").getSingleResult()).intValue();
	}

	/**
	 * Load an existing User entity
	 * 
	 * 
	 */
	@Transactional
	public Set<User> loadUsers() {
		return userDAO.findAllUsers();
	}

	/**
	 * Save an existing Comment entity
	 * 
	 * 
	 */
	@Transactional
	public User saveUserComments(Integer id, Comment related_comments) {
		User user = userDAO.findUserByPrimaryKey(id, -1, -1);
		Comment existingcomments = commentDAO.findCommentByPrimaryKey(related_comments.getId());

		// copy into the existing record to preserve existing relationships
		if (existingcomments != null) {
			existingcomments.setId(related_comments.getId());
			existingcomments.setTitle(related_comments.getTitle());
			existingcomments.setContent(related_comments.getContent());
			existingcomments.setCreateTime(related_comments.getCreateTime());
			related_comments = existingcomments;
		} else {
			related_comments = commentDAO.store(related_comments);
			commentDAO.flush();
		}

		related_comments.setUser(user);
		user.getComments().add(related_comments);
		related_comments = commentDAO.store(related_comments);
		commentDAO.flush();

		user = userDAO.store(user);
		userDAO.flush();

		return user;
	}

	/**
	 * Delete an existing Comment entity
	 * 
	 * 
	 */
	@Transactional
	public User deleteUserComments(Integer user_id, Integer related_comments_id) {
		Comment related_comments = commentDAO.findCommentByPrimaryKey(related_comments_id, -1, -1);

		User user = userDAO.findUserByPrimaryKey(user_id, -1, -1);

		related_comments.setUser(null);
		user.getComments().remove(related_comments);

		commentDAO.remove(related_comments);
		commentDAO.flush();

		return user;
	}

	/**
	 * 
	 */
	@Transactional
	public User findUserByPrimaryKey(Integer id) {
		return userDAO.findUserByPrimaryKey(id);
	}
}
