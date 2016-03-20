package com.nightwind.bbs.service;

import com.nightwind.bbs.dao.ForumDAO;
import com.nightwind.bbs.dao.ForumThreadDAO;

import com.nightwind.bbs.domain.Forum;
import com.nightwind.bbs.domain.ForumThread;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

/**
 * Spring service that handles CRUD requests for Forum entities
 * 
 * 
 * @generated
 */

@Service("ForumService")
@Transactional
public class ForumServiceImpl implements ForumService {

	/**
	 * DAO injected by Spring that manages Forum entities
	 * 
	 * 
	 */
	@Autowired
	private ForumDAO forumDAO;

	/**
	 * DAO injected by Spring that manages ForumThread entities
	 * 
	 * 
	 */
	@Autowired
	private ForumThreadDAO forumThreadDAO;

	/**
	 * Instantiates a new ForumServiceImpl.
	 *
	 * 
	 * @AuxiliaryModelComponent
	 */
	public ForumServiceImpl() {
	}

	/**
	 * Return a count of all Forum entity
	 * 
	 * 
	 */
	@Transactional
	public Integer countForums() {
		return ((Long) forumDAO.createQuerySingleResult("select count(o) from Forum o").getSingleResult()).intValue();
	}

	/**
	 * Save an existing ForumThread entity
	 * 
	 * 
	 */
	@Transactional
	public Forum saveForumForumThreads(Integer id, ForumThread related_forumthreads) {
		Forum forum = forumDAO.findForumByPrimaryKey(id, -1, -1);
		ForumThread existingforumThreads = forumThreadDAO.findForumThreadByPrimaryKey(related_forumthreads.getId());

		// copy into the existing record to preserve existing relationships
		if (existingforumThreads != null) {
			existingforumThreads.setId(related_forumthreads.getId());
			existingforumThreads.setTitle(related_forumthreads.getTitle());
			existingforumThreads.setContent(related_forumthreads.getContent());
			existingforumThreads.setCreateTime(related_forumthreads.getCreateTime());
			existingforumThreads.setLastModified(related_forumthreads.getLastModified());
			related_forumthreads = existingforumThreads;
		}

		related_forumthreads.setForum(forum);
		forum.getForumThreads().add(related_forumthreads);
		related_forumthreads = forumThreadDAO.store(related_forumthreads);
		forumThreadDAO.flush();

		forum = forumDAO.store(forum);
		forumDAO.flush();

		return forum;
	}

	/**
	 * 
	 */
	@Transactional
	public Forum findForumByPrimaryKey(Integer id) {
		return forumDAO.findForumByPrimaryKey(id);
	}

	/**
	 * Load an existing Forum entity
	 * 
	 * 
	 */
	@Transactional
	public Set<Forum> loadForums() {
		return forumDAO.findAllForums();
	}

	/**
	 * Save an existing Forum entity
	 * 
	 * 
	 */
	@Transactional
	public void saveForum(Forum forum) {
		Forum existingForum = forumDAO.findForumByPrimaryKey(forum.getId());

		if (existingForum != null) {
			if (existingForum != forum) {
				existingForum.setId(forum.getId());
				existingForum.setTitle(forum.getTitle());
				existingForum.setDescription(forum.getDescription());
			}
			forum = forumDAO.store(existingForum);
		} else {
			forum = forumDAO.store(forum);
		}
		forumDAO.flush();
	}

	/**
	 * Return all Forum entity
	 * 
	 * 
	 */
	@Transactional
	public List<Forum> findAllForums(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<Forum>(forumDAO.findAllForums(startResult, maxRows));
	}

	/**
	 * Delete an existing ForumThread entity
	 * 
	 * 
	 */
	@Transactional
	public Forum deleteForumForumThreads(Integer forum_id, Integer related_forumthreads_id) {
		ForumThread related_forumthreads = forumThreadDAO.findForumThreadByPrimaryKey(related_forumthreads_id, -1, -1);

		Forum forum = forumDAO.findForumByPrimaryKey(forum_id, -1, -1);

		related_forumthreads.setForum(null);
		forum.getForumThreads().remove(related_forumthreads);

		forumThreadDAO.remove(related_forumthreads);
		forumThreadDAO.flush();

		return forum;
	}

	/**
	 * Delete an existing Forum entity
	 * 
	 * 
	 */
	@Transactional
	public void deleteForum(Forum forum) {
		forumDAO.remove(forum);
		forumDAO.flush();
	}
}
