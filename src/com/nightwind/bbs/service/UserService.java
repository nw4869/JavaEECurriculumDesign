package com.nightwind.bbs.service;

import com.nightwind.bbs.domain.Authority;
import com.nightwind.bbs.domain.Comment;
import com.nightwind.bbs.domain.ForumThread;
import com.nightwind.bbs.domain.User;

import java.util.List;
import java.util.Set;

/**
 * Spring service that handles CRUD requests for User entities
 * 
 * 
 * @generated
 * @AuxiliaryModelComponent
 */
public interface UserService {

	/**
	 * Delete an existing User entity
	 * 
	 * 
	 */
	public void deleteUser(User user);

	/**
	 * Return all User entity
	 * 
	 * 
	 */
	public List<User> findAllUsers(Integer startResult, Integer maxRows);

	/**
	 * Delete an existing ForumThread entity
	 * 
	 * 
	 */
	public User deleteUserForumThreads(Integer user_id_1, Integer related_forumthreads_id);

	/**
	 * Save an existing ForumThread entity
	 * 
	 * 
	 */
	public User saveUserForumThreads(Integer id_2, ForumThread related_forumthreads);

	/**
	 * Save an existing User entity
	 * 
	 * 
	 */
	public void saveUser(User user_1);

	/**
	 * Save an existing Authority entity
	 * 
	 * 
	 */
	public User saveUserAuthorities(Integer id, Authority related_authorities);

	/**
	 * Delete an existing Authority entity
	 * 
	 * 
	 */
	public User deleteUserAuthorities(Integer user_id_2, Integer related_authorities_userId, String related_authorities_authorityField);

	/**
	 * Return a count of all User entity
	 * 
	 * 
	 */
	public Integer countUsers();

	/**
	 * Load an existing User entity
	 * 
	 * 
	 */
	public Set<User> loadUsers();

	/**
	 * Save an existing Comment entity
	 * 
	 * 
	 */
	public User saveUserComments(Integer id_1, Comment related_comments);

	/**
	 * Delete an existing Comment entity
	 * 
	 * 
	 */
	public User deleteUserComments(Integer user_id, Integer related_comments_id);

	/**
	 * 
	 */
	public User findUserByPrimaryKey(Integer id_3);
}