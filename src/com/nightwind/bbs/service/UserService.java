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
 * @ModelCoreReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/UserService/.properties.srv]
 * @generated
 * @AuxiliaryModelComponent
 */
public interface UserService {

	/**
	 * Delete an existing User entity
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/UserService/deleteUser%7B25e47b79-bc9a-43ca-998e-8eeeaec1ee21%7D/.properties.swoperation]
	 */
	public void deleteUser(User user);

	/**
	 * Return all User entity
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/UserService/findAllUsers%7B7d20b3ac-2fa2-4aa7-a3b7-617f0a026b8d%7D/.properties.swoperation]
	 */
	public List<User> findAllUsers(Integer startResult, Integer maxRows);

	/**
	 * Delete an existing ForumThread entity
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/UserService/deleteUserForumThreads%7B1ff7ff81-08bd-46e3-8cb9-1502a5508024%7D/.properties.swoperation]
	 */
	public User deleteUserForumThreads(Integer user_id_2, Integer related_forumthreads_id);

	/**
	 * Save an existing ForumThread entity
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/UserService/saveUserForumThreads%7Bcfc86d8b-6f56-437e-8d54-2d12bc0c30ec%7D/.properties.swoperation]
	 */
	public User saveUserForumThreads(Integer id_3, ForumThread related_forumthreads);

	/**
	 * Save an existing User entity
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/UserService/saveUser%7Bb9649ed0-e1bd-478d-895b-f3f534d6de37%7D/.properties.swoperation]
	 */
	public void saveUser(User user_1);

	/**
	 * Save an existing Authority entity
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/UserService/saveUserAuthorities%7B90d73f82-ec6d-40e1-8cf9-a61ece72de8f%7D/.properties.swoperation]
	 */
	public User saveUserAuthorities(Integer id_1, Authority related_authorities);

	/**
	 * Delete an existing Authority entity
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/UserService/deleteUserAuthorities%7Bd210ebf7-fb77-4d9e-8374-af78a716a65d%7D/.properties.swoperation]
	 */
	public User deleteUserAuthorities(Integer user_id, Integer related_authorities_userId, String related_authorities_authorityField);

	/**
	 * Return a count of all User entity
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/UserService/countUsers%7B7debfc29-cb1f-4807-8755-ef0201ee18bf%7D/.properties.swoperation]
	 */
	public Integer countUsers();

	/**
	 * Load an existing User entity
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/UserService/loadUsers%7B5e2e722e-8848-4bf1-9081-11bde2b091bc%7D/.properties.swoperation]
	 */
	public Set<User> loadUsers();

	/**
	 * Save an existing Comment entity
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/UserService/saveUserComments%7B822731c9-cf65-4368-b44a-e659fa075915%7D/.properties.swoperation]
	 */
	public User saveUserComments(Integer id_2, Comment related_comments);

	/**
	 * Delete an existing Comment entity
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/UserService/deleteUserComments%7Bf5f559f8-a1c2-48f0-a68a-7f63f1b3213e%7D/.properties.swoperation]
	 */
	public User deleteUserComments(Integer user_id_1, Integer related_comments_id);

	/**
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/UserService/findUserByPrimaryKey%7Bb3be01ac-ba09-4e0b-a788-acc6186d3858%7D/.properties.swoperation]
	 */
	public User findUserByPrimaryKey(Integer id);
}