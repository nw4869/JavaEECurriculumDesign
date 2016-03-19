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
 * @ModelCoreReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/UserService/.properties.srv]
 * @generated
 */

@Service("UserService")
@Transactional
public class UserServiceImpl implements UserService {

	/**
	 * DAO injected by Spring that manages Authority entities
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/UserService/.properties.srv#//@variables%5Bname='authorityDAO'%5D]
	 */
	@Autowired
	private AuthorityDAO authorityDAO;

	/**
	 * DAO injected by Spring that manages Comment entities
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/UserService/.properties.srv#//@variables%5Bname='commentDAO'%5D]
	 */
	@Autowired
	private CommentDAO commentDAO;

	/**
	 * DAO injected by Spring that manages ForumThread entities
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/UserService/.properties.srv#//@variables%5Bname='forumThreadDAO'%5D]
	 */
	@Autowired
	private ForumThreadDAO forumThreadDAO;

	/**
	 * DAO injected by Spring that manages User entities
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/UserService/.properties.srv#//@variables%5Bname='userDAO'%5D]
	 */
	@Autowired
	private UserDAO userDAO;

	/**
	 * Instantiates a new UserServiceImpl.
	 *
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/UserService/.properties.srv]
	 * @AuxiliaryModelComponent
	 */
	public UserServiceImpl() {
	}

	/**
	 * Delete an existing User entity
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/UserService/deleteUser%7B25e47b79-bc9a-43ca-998e-8eeeaec1ee21%7D/.properties.swoperation]
	 */
	@Transactional
	public void deleteUser(User user) {
		userDAO.remove(user);
		userDAO.flush();
	}

	/**
	 * Return all User entity
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/UserService/findAllUsers%7B7d20b3ac-2fa2-4aa7-a3b7-617f0a026b8d%7D/.properties.swoperation]
	 */
	@Transactional
	public List<User> findAllUsers(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<User>(userDAO.findAllUsers(startResult, maxRows));
	}

	/**
	 * Delete an existing ForumThread entity
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/UserService/deleteUserForumThreads%7B1ff7ff81-08bd-46e3-8cb9-1502a5508024%7D/.properties.swoperation]
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
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/UserService/saveUserForumThreads%7Bcfc86d8b-6f56-437e-8d54-2d12bc0c30ec%7D/.properties.swoperation]
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
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/UserService/saveUser%7Bb9649ed0-e1bd-478d-895b-f3f534d6de37%7D/.properties.swoperation]
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
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/UserService/saveUserAuthorities%7B90d73f82-ec6d-40e1-8cf9-a61ece72de8f%7D/.properties.swoperation]
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
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/UserService/deleteUserAuthorities%7Bd210ebf7-fb77-4d9e-8374-af78a716a65d%7D/.properties.swoperation]
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
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/UserService/countUsers%7B7debfc29-cb1f-4807-8755-ef0201ee18bf%7D/.properties.swoperation]
	 */
	@Transactional
	public Integer countUsers() {
		return ((Long) userDAO.createQuerySingleResult("select count(o) from User o").getSingleResult()).intValue();
	}

	/**
	 * Load an existing User entity
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/UserService/loadUsers%7B5e2e722e-8848-4bf1-9081-11bde2b091bc%7D/.properties.swoperation]
	 */
	@Transactional
	public Set<User> loadUsers() {
		return userDAO.findAllUsers();
	}

	/**
	 * Save an existing Comment entity
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/UserService/saveUserComments%7B822731c9-cf65-4368-b44a-e659fa075915%7D/.properties.swoperation]
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
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/UserService/deleteUserComments%7Bf5f559f8-a1c2-48f0-a68a-7f63f1b3213e%7D/.properties.swoperation]
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
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/UserService/findUserByPrimaryKey%7Bb3be01ac-ba09-4e0b-a788-acc6186d3858%7D/.properties.swoperation]
	 */
	@Transactional
	public User findUserByPrimaryKey(Integer id) {
		return userDAO.findUserByPrimaryKey(id);
	}
}
