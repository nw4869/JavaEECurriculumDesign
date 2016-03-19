package com.nightwind.bbs.service;

import com.nightwind.bbs.dao.CommentDAO;
import com.nightwind.bbs.dao.ForumDAO;
import com.nightwind.bbs.dao.ForumThreadDAO;
import com.nightwind.bbs.dao.UserDAO;

import com.nightwind.bbs.domain.Comment;
import com.nightwind.bbs.domain.Forum;
import com.nightwind.bbs.domain.ForumThread;
import com.nightwind.bbs.domain.User;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

/**
 * Spring service that handles CRUD requests for ForumThread entities
 * 
 * @ModelCoreReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/ForumThreadService/.properties.srv]
 * @generated
 */

@Service("ForumThreadService")
@Transactional
public class ForumThreadServiceImpl implements ForumThreadService {

	/**
	 * DAO injected by Spring that manages Comment entities
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/ForumThreadService/.properties.srv#//@variables%5Bname='commentDAO'%5D]
	 */
	@Autowired
	private CommentDAO commentDAO;

	/**
	 * DAO injected by Spring that manages Forum entities
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/ForumThreadService/.properties.srv#//@variables%5Bname='forumDAO'%5D]
	 */
	@Autowired
	private ForumDAO forumDAO;

	/**
	 * DAO injected by Spring that manages ForumThread entities
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/ForumThreadService/.properties.srv#//@variables%5Bname='forumThreadDAO'%5D]
	 */
	@Autowired
	private ForumThreadDAO forumThreadDAO;

	/**
	 * DAO injected by Spring that manages User entities
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/ForumThreadService/.properties.srv#//@variables%5Bname='userDAO'%5D]
	 */
	@Autowired
	private UserDAO userDAO;

	/**
	 * Instantiates a new ForumThreadServiceImpl.
	 *
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/ForumThreadService/.properties.srv]
	 * @AuxiliaryModelComponent
	 */
	public ForumThreadServiceImpl() {
	}

	/**
	 * Save an existing Forum entity
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/ForumThreadService/saveForumThreadForum%7B72244b13-4c5a-45cb-8095-5569cf00a429%7D/.properties.swoperation]
	 */
	@Transactional
	public ForumThread saveForumThreadForum(Integer id, Forum related_forum) {
		ForumThread forumthread = forumThreadDAO.findForumThreadByPrimaryKey(id, -1, -1);
		Forum existingforum = forumDAO.findForumByPrimaryKey(related_forum.getId());

		// copy into the existing record to preserve existing relationships
		if (existingforum != null) {
			existingforum.setId(related_forum.getId());
			existingforum.setTitle(related_forum.getTitle());
			existingforum.setDescription(related_forum.getDescription());
			related_forum = existingforum;
		}

		forumthread.setForum(related_forum);
		related_forum.getForumThreads().add(forumthread);
		forumthread = forumThreadDAO.store(forumthread);
		forumThreadDAO.flush();

		related_forum = forumDAO.store(related_forum);
		forumDAO.flush();

		return forumthread;
	}

	/**
	 * Load an existing ForumThread entity
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/ForumThreadService/loadForumThreads%7B4aa1b1fb-0349-48ab-85af-7150eceeea77%7D/.properties.swoperation]
	 */
	@Transactional
	public Set<ForumThread> loadForumThreads() {
		return forumThreadDAO.findAllForumThreads();
	}

	/**
	 * Delete an existing User entity
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/ForumThreadService/deleteForumThreadUser%7Bf77c73dc-b85a-4765-815b-d3096b882724%7D/.properties.swoperation]
	 */
	@Transactional
	public ForumThread deleteForumThreadUser(Integer forumthread_id, Integer related_user_id) {
		ForumThread forumthread = forumThreadDAO.findForumThreadByPrimaryKey(forumthread_id, -1, -1);
		User related_user = userDAO.findUserByPrimaryKey(related_user_id, -1, -1);

		forumthread.setUser(null);
		related_user.getForumThreads().remove(forumthread);
		forumthread = forumThreadDAO.store(forumthread);
		forumThreadDAO.flush();

		related_user = userDAO.store(related_user);
		userDAO.flush();

		userDAO.remove(related_user);
		userDAO.flush();

		return forumthread;
	}

	/**
	 * Delete an existing ForumThread entity
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/ForumThreadService/deleteForumThread%7B6b457b8a-598d-457a-a018-ff42bd54cc5f%7D/.properties.swoperation]
	 */
	@Transactional
	public void deleteForumThread(ForumThread forumthread) {
		forumThreadDAO.remove(forumthread);
		forumThreadDAO.flush();
	}

	/**
	 * Delete an existing Comment entity
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/ForumThreadService/deleteForumThreadComments%7B60839500-d792-4f5f-ac25-37f8e40bc06e%7D/.properties.swoperation]
	 */
	@Transactional
	public ForumThread deleteForumThreadComments(Integer forumthread_id, Integer related_comments_id) {
		Comment related_comments = commentDAO.findCommentByPrimaryKey(related_comments_id, -1, -1);

		ForumThread forumthread = forumThreadDAO.findForumThreadByPrimaryKey(forumthread_id, -1, -1);

		related_comments.setForumThread(null);
		forumthread.getComments().remove(related_comments);

		commentDAO.remove(related_comments);
		commentDAO.flush();

		return forumthread;
	}

	/**
	 * Return a count of all ForumThread entity
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/ForumThreadService/countForumThreads%7Bb65826b0-d5a0-4a23-a89e-083f373a9cc4%7D/.properties.swoperation]
	 */
	@Transactional
	public Integer countForumThreads() {
		return ((Long) forumThreadDAO.createQuerySingleResult("select count(o) from ForumThread o").getSingleResult()).intValue();
	}

	/**
	 * Return all ForumThread entity
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/ForumThreadService/findAllForumThreads%7B87e5a7cf-82c3-4d61-8fee-5c15949324ab%7D/.properties.swoperation]
	 */
	@Transactional
	public List<ForumThread> findAllForumThreads(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<ForumThread>(forumThreadDAO.findAllForumThreads(startResult, maxRows));
	}

	/**
	 * Save an existing User entity
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/ForumThreadService/saveForumThreadUser%7B72444b2a-2d41-492e-8221-7b52c2ef2c61%7D/.properties.swoperation]
	 */
	@Transactional
	public ForumThread saveForumThreadUser(Integer id, User related_user) {
		ForumThread forumthread = forumThreadDAO.findForumThreadByPrimaryKey(id, -1, -1);
		User existinguser = userDAO.findUserByPrimaryKey(related_user.getId());

		// copy into the existing record to preserve existing relationships
		if (existinguser != null) {
			existinguser.setId(related_user.getId());
			existinguser.setUsername(related_user.getUsername());
			existinguser.setPassword(related_user.getPassword());
			existinguser.setEmail(related_user.getEmail());
			existinguser.setAvatar(related_user.getAvatar());
			existinguser.setMemberTitle(related_user.getMemberTitle());
			existinguser.setSignature(related_user.getSignature());
			existinguser.setEnabled(related_user.getEnabled());
			existinguser.setCreateTime(related_user.getCreateTime());
			related_user = existinguser;
		} else {
			related_user = userDAO.store(related_user);
			userDAO.flush();
		}

		forumthread.setUser(related_user);
		related_user.getForumThreads().add(forumthread);
		forumthread = forumThreadDAO.store(forumthread);
		forumThreadDAO.flush();

		related_user = userDAO.store(related_user);
		userDAO.flush();

		return forumthread;
	}

	/**
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/ForumThreadService/findForumThreadByPrimaryKey%7B197a790b-5e93-452f-9454-aea404affdaf%7D/.properties.swoperation]
	 */
	@Transactional
	public ForumThread findForumThreadByPrimaryKey(Integer id) {
		return forumThreadDAO.findForumThreadByPrimaryKey(id);
	}

	/**
	 * Delete an existing Forum entity
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/ForumThreadService/deleteForumThreadForum%7B34641b1d-a533-4016-90d2-28c8c1afcf04%7D/.properties.swoperation]
	 */
	@Transactional
	public ForumThread deleteForumThreadForum(Integer forumthread_id, Integer related_forum_id) {
		ForumThread forumthread = forumThreadDAO.findForumThreadByPrimaryKey(forumthread_id, -1, -1);
		Forum related_forum = forumDAO.findForumByPrimaryKey(related_forum_id, -1, -1);

		forumthread.setForum(null);
		related_forum.getForumThreads().remove(forumthread);
		forumthread = forumThreadDAO.store(forumthread);
		forumThreadDAO.flush();

		related_forum = forumDAO.store(related_forum);
		forumDAO.flush();

		forumDAO.remove(related_forum);
		forumDAO.flush();

		return forumthread;
	}

	/**
	 * Save an existing ForumThread entity
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/ForumThreadService/saveForumThread%7B539ed205-d91e-4a7a-b602-65d9a4b04a35%7D/.properties.swoperation]
	 */
	@Transactional
	public void saveForumThread(ForumThread forumthread) {
		ForumThread existingForumThread = forumThreadDAO.findForumThreadByPrimaryKey(forumthread.getId());

		if (existingForumThread != null) {
			if (existingForumThread != forumthread) {
				existingForumThread.setId(forumthread.getId());
				existingForumThread.setTitle(forumthread.getTitle());
				existingForumThread.setContent(forumthread.getContent());
				existingForumThread.setCreateTime(forumthread.getCreateTime());
				existingForumThread.setLastModified(forumthread.getLastModified());
			}
			forumthread = forumThreadDAO.store(existingForumThread);
		} else {
			forumthread = forumThreadDAO.store(forumthread);
		}
		forumThreadDAO.flush();
	}

	/**
	 * Save an existing Comment entity
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/ForumThreadService/saveForumThreadComments%7B8c5e623a-376a-46ab-81b2-03c86662a97d%7D/.properties.swoperation]
	 */
	@Transactional
	public ForumThread saveForumThreadComments(Integer id, Comment related_comments) {
		ForumThread forumthread = forumThreadDAO.findForumThreadByPrimaryKey(id, -1, -1);
		Comment existingcomments = commentDAO.findCommentByPrimaryKey(related_comments.getId());

		// copy into the existing record to preserve existing relationships
		if (existingcomments != null) {
			existingcomments.setId(related_comments.getId());
			existingcomments.setTitle(related_comments.getTitle());
			existingcomments.setContent(related_comments.getContent());
			existingcomments.setCreateTime(related_comments.getCreateTime());
			related_comments = existingcomments;
		}

		related_comments.setForumThread(forumthread);
		forumthread.getComments().add(related_comments);
		related_comments = commentDAO.store(related_comments);
		commentDAO.flush();

		forumthread = forumThreadDAO.store(forumthread);
		forumThreadDAO.flush();

		return forumthread;
	}
}
