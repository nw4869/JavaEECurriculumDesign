package com.nightwind.bbs.service;

import com.nightwind.bbs.domain.Comment;
import com.nightwind.bbs.domain.Forum;
import com.nightwind.bbs.domain.ForumThread;
import com.nightwind.bbs.domain.User;

import java.util.List;
import java.util.Set;

/**
 * Spring service that handles CRUD requests for ForumThread entities
 * 
 * @ModelCoreReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/ForumThreadService/.properties.srv]
 * @generated
 * @AuxiliaryModelComponent
 */
public interface ForumThreadService {

	/**
	 * Save an existing Forum entity
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/ForumThreadService/saveForumThreadForum%7B72244b13-4c5a-45cb-8095-5569cf00a429%7D/.properties.swoperation]
	 */
	public ForumThread saveForumThreadForum(Integer id_2, Forum related_forum);

	/**
	 * Load an existing ForumThread entity
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/ForumThreadService/loadForumThreads%7B4aa1b1fb-0349-48ab-85af-7150eceeea77%7D/.properties.swoperation]
	 */
	public Set<ForumThread> loadForumThreads();

	/**
	 * Delete an existing User entity
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/ForumThreadService/deleteForumThreadUser%7Bf77c73dc-b85a-4765-815b-d3096b882724%7D/.properties.swoperation]
	 */
	public ForumThread deleteForumThreadUser(Integer forumthread_id_2, Integer related_user_id);

	/**
	 * Delete an existing ForumThread entity
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/ForumThreadService/deleteForumThread%7B6b457b8a-598d-457a-a018-ff42bd54cc5f%7D/.properties.swoperation]
	 */
	public void deleteForumThread(ForumThread forumthread);

	/**
	 * Delete an existing Comment entity
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/ForumThreadService/deleteForumThreadComments%7B60839500-d792-4f5f-ac25-37f8e40bc06e%7D/.properties.swoperation]
	 */
	public ForumThread deleteForumThreadComments(Integer forumthread_id, Integer related_comments_id);

	/**
	 * Return a count of all ForumThread entity
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/ForumThreadService/countForumThreads%7Bb65826b0-d5a0-4a23-a89e-083f373a9cc4%7D/.properties.swoperation]
	 */
	public Integer countForumThreads();

	/**
	 * Return all ForumThread entity
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/ForumThreadService/findAllForumThreads%7B87e5a7cf-82c3-4d61-8fee-5c15949324ab%7D/.properties.swoperation]
	 */
	public List<ForumThread> findAllForumThreads(Integer startResult, Integer maxRows);

	/**
	 * Save an existing User entity
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/ForumThreadService/saveForumThreadUser%7B72444b2a-2d41-492e-8221-7b52c2ef2c61%7D/.properties.swoperation]
	 */
	public ForumThread saveForumThreadUser(Integer id_3, User related_user);

	/**
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/ForumThreadService/findForumThreadByPrimaryKey%7B197a790b-5e93-452f-9454-aea404affdaf%7D/.properties.swoperation]
	 */
	public ForumThread findForumThreadByPrimaryKey(Integer id);

	/**
	 * Delete an existing Forum entity
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/ForumThreadService/deleteForumThreadForum%7B34641b1d-a533-4016-90d2-28c8c1afcf04%7D/.properties.swoperation]
	 */
	public ForumThread deleteForumThreadForum(Integer forumthread_id_1, Integer related_forum_id);

	/**
	 * Save an existing ForumThread entity
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/ForumThreadService/saveForumThread%7B539ed205-d91e-4a7a-b602-65d9a4b04a35%7D/.properties.swoperation]
	 */
	public void saveForumThread(ForumThread forumthread_1);

	/**
	 * Save an existing Comment entity
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/ForumThreadService/saveForumThreadComments%7B8c5e623a-376a-46ab-81b2-03c86662a97d%7D/.properties.swoperation]
	 */
	public ForumThread saveForumThreadComments(Integer id_1, Comment related_comments);
}