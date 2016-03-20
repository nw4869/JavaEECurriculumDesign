package com.nightwind.bbs.service;

import com.nightwind.bbs.domain.Comment;
import com.nightwind.bbs.domain.ForumThread;
import com.nightwind.bbs.domain.User;

import java.util.List;
import java.util.Set;

/**
 * Spring service that handles CRUD requests for Comment entities
 * 
 * 
 * @generated
 * @AuxiliaryModelComponent
 */
public interface CommentService {

	/**
	 * Return all Comment entity
	 * 
	 * 
	 */
	public List<Comment> findAllComments(Integer startResult, Integer maxRows);

	/**
	 * Delete an existing Comment entity
	 * 
	 * 
	 */
	public void deleteComment(Comment comment_1);

	/**
	 * Return a count of all Comment entity
	 * 
	 * 
	 */
	public Integer countComments();

	/**
	 * Delete an existing User entity
	 * 
	 * 
	 */
	public Comment deleteCommentUser(Integer comment_id, Integer related_user_id);

	/**
	 * Load an existing Comment entity
	 * 
	 * 
	 */
	public Set<Comment> loadComments();

	/**
	 * Save an existing Comment entity
	 * 
	 * 
	 */
	public void saveComment(Comment comment);

	/**
	 * Save an existing ForumThread entity
	 * 
	 * 
	 */
	public Comment saveCommentForumThread(Integer id_2, ForumThread related_forumthread);

	/**
	 * Save an existing User entity
	 * 
	 * 
	 */
	public Comment saveCommentUser(Integer id, User related_user);

	/**
	 * 
	 */
	public Comment findCommentByPrimaryKey(Integer id_1);

	/**
	 * Delete an existing ForumThread entity
	 * 
	 * 
	 */
	public Comment deleteCommentForumThread(Integer comment_id_1, Integer related_forumthread_id);
}