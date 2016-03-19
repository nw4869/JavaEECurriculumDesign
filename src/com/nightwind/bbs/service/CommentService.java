package com.nightwind.bbs.service;

import com.nightwind.bbs.domain.Comment;
import com.nightwind.bbs.domain.ForumThread;
import com.nightwind.bbs.domain.User;

import java.util.List;
import java.util.Set;

/**
 * Spring service that handles CRUD requests for Comment entities
 * 
 * @ModelCoreReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/CommentService/.properties.srv]
 * @generated
 * @AuxiliaryModelComponent
 */
public interface CommentService {

	/**
	 * Return all Comment entity
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/CommentService/findAllComments%7B8d3c845c-7dcc-4aa7-b028-8284ce96492b%7D/.properties.swoperation]
	 */
	public List<Comment> findAllComments(Integer startResult, Integer maxRows);

	/**
	 * Delete an existing Comment entity
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/CommentService/deleteComment%7B69edbc42-5574-48ae-b455-7cc4df243e7e%7D/.properties.swoperation]
	 */
	public void deleteComment(Comment comment);

	/**
	 * Return a count of all Comment entity
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/CommentService/countComments%7B6bfbe957-64dd-4da1-8325-7babb236cd87%7D/.properties.swoperation]
	 */
	public Integer countComments();

	/**
	 * Delete an existing User entity
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/CommentService/deleteCommentUser%7B4d2d3b7f-ad29-440b-bea6-faf105d0e817%7D/.properties.swoperation]
	 */
	public Comment deleteCommentUser(Integer comment_id_1, Integer related_user_id);

	/**
	 * Load an existing Comment entity
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/CommentService/loadComments%7Bce026f26-63c0-409a-bb33-cbb190338c2c%7D/.properties.swoperation]
	 */
	public Set<Comment> loadComments();

	/**
	 * Save an existing Comment entity
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/CommentService/saveComment%7Ba315805a-156f-45c2-a1bb-7e19310df6a9%7D/.properties.swoperation]
	 */
	public void saveComment(Comment comment_1);

	/**
	 * Save an existing ForumThread entity
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/CommentService/saveCommentForumThread%7B1a929f98-ea74-4eb6-81d0-fa387ce62cbf%7D/.properties.swoperation]
	 */
	public Comment saveCommentForumThread(Integer id_1, ForumThread related_forumthread);

	/**
	 * Save an existing User entity
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/CommentService/saveCommentUser%7Bb2beb2cf-5905-4908-9d13-3b59fe810103%7D/.properties.swoperation]
	 */
	public Comment saveCommentUser(Integer id_2, User related_user);

	/**
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/CommentService/findCommentByPrimaryKey%7B1a9d4b02-f2f1-45be-8b21-d2a4e7abfc2a%7D/.properties.swoperation]
	 */
	public Comment findCommentByPrimaryKey(Integer id);

	/**
	 * Delete an existing ForumThread entity
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/CommentService/deleteCommentForumThread%7B17cc35c1-066e-4495-993f-6bc3e7b8da9d%7D/.properties.swoperation]
	 */
	public Comment deleteCommentForumThread(Integer comment_id, Integer related_forumthread_id);
}