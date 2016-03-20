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
 * 
 * @generated
 * @AuxiliaryModelComponent
 */
public interface ForumThreadService {

	/**
	 * Save an existing Forum entity
	 * 
	 * 
	 */
	public ForumThread saveForumThreadForum(Integer id_3, Forum related_forum);

	/**
	 * Load an existing ForumThread entity
	 * 
	 * 
	 */
	public Set<ForumThread> loadForumThreads();

	/**
	 * Delete an existing User entity
	 * 
	 * 
	 */
	public ForumThread deleteForumThreadUser(Integer forumthread_id_2, Integer related_user_id);

	/**
	 * Delete an existing ForumThread entity
	 * 
	 * 
	 */
	public void deleteForumThread(ForumThread forumthread_1);

	/**
	 * Delete an existing Comment entity
	 * 
	 * 
	 */
	public ForumThread deleteForumThreadComments(Integer forumthread_id, Integer related_comments_id);

	/**
	 * Return a count of all ForumThread entity
	 * 
	 * 
	 */
	public Integer countForumThreads();

	/**
	 * Return all ForumThread entity
	 * 
	 * 
	 */
	public List<ForumThread> findAllForumThreads(Integer startResult, Integer maxRows);

	/**
	 * Save an existing User entity
	 * 
	 * 
	 */
	public ForumThread saveForumThreadUser(Integer id, User related_user);

	/**
	 * 
	 */
	public ForumThread findForumThreadByPrimaryKey(Integer id_1);

	/**
	 * Delete an existing Forum entity
	 * 
	 * 
	 */
	public ForumThread deleteForumThreadForum(Integer forumthread_id_1, Integer related_forum_id);

	/**
	 * Save an existing ForumThread entity
	 * 
	 * 
	 */
	public void saveForumThread(ForumThread forumthread);

	/**
	 * Save an existing Comment entity
	 * 
	 * 
	 */
	public ForumThread saveForumThreadComments(Integer id_2, Comment related_comments);
}