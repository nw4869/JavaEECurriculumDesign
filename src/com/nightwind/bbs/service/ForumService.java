package com.nightwind.bbs.service;

import com.nightwind.bbs.domain.Forum;
import com.nightwind.bbs.domain.ForumThread;

import java.util.List;
import java.util.Set;

/**
 * Spring service that handles CRUD requests for Forum entities
 * 
 * 
 * @generated
 * @AuxiliaryModelComponent
 */
public interface ForumService {

	/**
	 * Return a count of all Forum entity
	 * 
	 * 
	 */
	public Integer countForums();

	/**
	 * Save an existing ForumThread entity
	 * 
	 * 
	 */
	public Forum saveForumForumThreads(Integer id_1, ForumThread related_forumthreads);

	/**
	 * 
	 */
	public Forum findForumByPrimaryKey(Integer id);

	/**
	 * Load an existing Forum entity
	 * 
	 * 
	 */
	public Set<Forum> loadForums();

	/**
	 * Save an existing Forum entity
	 * 
	 * 
	 */
	public void saveForum(Forum forum);

	/**
	 * Return all Forum entity
	 * 
	 * 
	 */
	public List<Forum> findAllForums(Integer startResult, Integer maxRows);

	/**
	 * Delete an existing ForumThread entity
	 * 
	 * 
	 */
	public Forum deleteForumForumThreads(Integer forum_id, Integer related_forumthreads_id);

	/**
	 * Delete an existing Forum entity
	 * 
	 * 
	 */
	public void deleteForum(Forum forum_1);
}