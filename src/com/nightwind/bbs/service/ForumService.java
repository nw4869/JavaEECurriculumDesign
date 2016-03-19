package com.nightwind.bbs.service;

import com.nightwind.bbs.domain.Forum;
import com.nightwind.bbs.domain.ForumThread;

import java.util.List;
import java.util.Set;

/**
 * Spring service that handles CRUD requests for Forum entities
 * 
 * @ModelCoreReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/ForumService/.properties.srv]
 * @generated
 * @AuxiliaryModelComponent
 */
public interface ForumService {

	/**
	 * Return a count of all Forum entity
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/ForumService/countForums%7B62ea3a0f-573a-4bcf-af10-94e050b51c2b%7D/.properties.swoperation]
	 */
	public Integer countForums();

	/**
	 * Save an existing ForumThread entity
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/ForumService/saveForumForumThreads%7B5f9ef705-a36a-4a0e-aeae-6b72222f3409%7D/.properties.swoperation]
	 */
	public Forum saveForumForumThreads(Integer id_1, ForumThread related_forumthreads);

	/**
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/ForumService/findForumByPrimaryKey%7B99e0ae6b-b681-49a1-a902-0ecd5cad6607%7D/.properties.swoperation]
	 */
	public Forum findForumByPrimaryKey(Integer id);

	/**
	 * Load an existing Forum entity
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/ForumService/loadForums%7B8a03cf2d-ef50-477d-8cd2-59cc55ce235f%7D/.properties.swoperation]
	 */
	public Set<Forum> loadForums();

	/**
	 * Save an existing Forum entity
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/ForumService/saveForum%7B74ed46bb-67a8-4a20-8aab-d3d0c3042981%7D/.properties.swoperation]
	 */
	public void saveForum(Forum forum_1);

	/**
	 * Return all Forum entity
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/ForumService/findAllForums%7B995edb42-26ed-4778-9b15-e60c0b86975a%7D/.properties.swoperation]
	 */
	public List<Forum> findAllForums(Integer startResult, Integer maxRows);

	/**
	 * Delete an existing ForumThread entity
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/ForumService/deleteForumForumThreads%7Bae3a8a15-6a4c-46b7-8671-12c55dd926a6%7D/.properties.swoperation]
	 */
	public Forum deleteForumForumThreads(Integer forum_id, Integer related_forumthreads_id);

	/**
	 * Delete an existing Forum entity
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/ForumService/deleteForum%7Bae98df4d-d139-40a1-8020-2c45a4032a3f%7D/.properties.swoperation]
	 */
	public void deleteForum(Forum forum);
}