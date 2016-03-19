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
 * @ModelCoreReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/ForumService/.properties.srv]
 * @generated
 */

@Service("ForumService")
@Transactional
public class ForumServiceImpl implements ForumService {

	/**
	 * DAO injected by Spring that manages Forum entities
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/ForumService/.properties.srv#//@variables%5Bname='forumDAO'%5D]
	 */
	@Autowired
	private ForumDAO forumDAO;

	/**
	 * DAO injected by Spring that manages ForumThread entities
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/ForumService/.properties.srv#//@variables%5Bname='forumThreadDAO'%5D]
	 */
	@Autowired
	private ForumThreadDAO forumThreadDAO;

	/**
	 * Instantiates a new ForumServiceImpl.
	 *
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/ForumService/.properties.srv]
	 * @AuxiliaryModelComponent
	 */
	public ForumServiceImpl() {
	}

	/**
	 * Return a count of all Forum entity
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/ForumService/countForums%7B62ea3a0f-573a-4bcf-af10-94e050b51c2b%7D/.properties.swoperation]
	 */
	@Transactional
	public Integer countForums() {
		return ((Long) forumDAO.createQuerySingleResult("select count(o) from Forum o").getSingleResult()).intValue();
	}

	/**
	 * Save an existing ForumThread entity
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/ForumService/saveForumForumThreads%7B5f9ef705-a36a-4a0e-aeae-6b72222f3409%7D/.properties.swoperation]
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
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/ForumService/findForumByPrimaryKey%7B99e0ae6b-b681-49a1-a902-0ecd5cad6607%7D/.properties.swoperation]
	 */
	@Transactional
	public Forum findForumByPrimaryKey(Integer id) {
		return forumDAO.findForumByPrimaryKey(id);
	}

	/**
	 * Load an existing Forum entity
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/ForumService/loadForums%7B8a03cf2d-ef50-477d-8cd2-59cc55ce235f%7D/.properties.swoperation]
	 */
	@Transactional
	public Set<Forum> loadForums() {
		return forumDAO.findAllForums();
	}

	/**
	 * Save an existing Forum entity
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/ForumService/saveForum%7B74ed46bb-67a8-4a20-8aab-d3d0c3042981%7D/.properties.swoperation]
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
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/ForumService/findAllForums%7B995edb42-26ed-4778-9b15-e60c0b86975a%7D/.properties.swoperation]
	 */
	@Transactional
	public List<Forum> findAllForums(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<Forum>(forumDAO.findAllForums(startResult, maxRows));
	}

	/**
	 * Delete an existing ForumThread entity
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/ForumService/deleteForumForumThreads%7Bae3a8a15-6a4c-46b7-8671-12c55dd926a6%7D/.properties.swoperation]
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
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/ForumService/deleteForum%7Bae98df4d-d139-40a1-8020-2c45a4032a3f%7D/.properties.swoperation]
	 */
	@Transactional
	public void deleteForum(Forum forum) {
		forumDAO.remove(forum);
		forumDAO.flush();
	}
}
