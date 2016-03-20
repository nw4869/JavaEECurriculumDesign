package com.nightwind.bbs.service;

import com.nightwind.bbs.dao.CommentDAO;
import com.nightwind.bbs.dao.ForumThreadDAO;
import com.nightwind.bbs.dao.UserDAO;

import com.nightwind.bbs.domain.Comment;
import com.nightwind.bbs.domain.ForumThread;
import com.nightwind.bbs.domain.User;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

/**
 * Spring service that handles CRUD requests for Comment entities
 * 
 * 
 * @generated
 */

@Service("CommentService")
@Transactional
public class CommentServiceImpl implements CommentService {

	/**
	 * DAO injected by Spring that manages Comment entities
	 * 
	 * 
	 */
	@Autowired
	private CommentDAO commentDAO;

	/**
	 * DAO injected by Spring that manages ForumThread entities
	 * 
	 * 
	 */
	@Autowired
	private ForumThreadDAO forumThreadDAO;

	/**
	 * DAO injected by Spring that manages User entities
	 * 
	 * 
	 */
	@Autowired
	private UserDAO userDAO;

	/**
	 * Instantiates a new CommentServiceImpl.
	 *
	 * 
	 * @AuxiliaryModelComponent
	 */
	public CommentServiceImpl() {
	}

	/**
	 * Return all Comment entity
	 * 
	 * 
	 */
	@Transactional
	public List<Comment> findAllComments(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<Comment>(commentDAO.findAllComments(startResult, maxRows));
	}

	/**
	 * Delete an existing Comment entity
	 * 
	 * 
	 */
	@Transactional
	public void deleteComment(Comment comment) {
		commentDAO.remove(comment);
		commentDAO.flush();
	}

	/**
	 * Return a count of all Comment entity
	 * 
	 * 
	 */
	@Transactional
	public Integer countComments() {
		return ((Long) commentDAO.createQuerySingleResult("select count(o) from Comment o").getSingleResult()).intValue();
	}

	/**
	 * Delete an existing User entity
	 * 
	 * 
	 */
	@Transactional
	public Comment deleteCommentUser(Integer comment_id, Integer related_user_id) {
		Comment comment = commentDAO.findCommentByPrimaryKey(comment_id, -1, -1);
		User related_user = userDAO.findUserByPrimaryKey(related_user_id, -1, -1);

		comment.setUser(null);
		related_user.getComments().remove(comment);
		comment = commentDAO.store(comment);
		commentDAO.flush();

		related_user = userDAO.store(related_user);
		userDAO.flush();

		userDAO.remove(related_user);
		userDAO.flush();

		return comment;
	}

	/**
	 * Load an existing Comment entity
	 * 
	 * 
	 */
	@Transactional
	public Set<Comment> loadComments() {
		return commentDAO.findAllComments();
	}

	/**
	 * Save an existing Comment entity
	 * 
	 * 
	 */
	@Transactional
	public void saveComment(Comment comment) {
		Comment existingComment = commentDAO.findCommentByPrimaryKey(comment.getId());

		if (existingComment != null) {
			if (existingComment != comment) {
				existingComment.setId(comment.getId());
				existingComment.setTitle(comment.getTitle());
				existingComment.setContent(comment.getContent());
				existingComment.setCreateTime(comment.getCreateTime());
			}
			comment = commentDAO.store(existingComment);
		} else {
			comment = commentDAO.store(comment);
		}
		commentDAO.flush();
	}

	/**
	 * Save an existing ForumThread entity
	 * 
	 * 
	 */
	@Transactional
	public Comment saveCommentForumThread(Integer id, ForumThread related_forumthread) {
		Comment comment = commentDAO.findCommentByPrimaryKey(id, -1, -1);
		ForumThread existingforumThread = forumThreadDAO.findForumThreadByPrimaryKey(related_forumthread.getId());

		// copy into the existing record to preserve existing relationships
		if (existingforumThread != null) {
			existingforumThread.setId(related_forumthread.getId());
			existingforumThread.setTitle(related_forumthread.getTitle());
			existingforumThread.setContent(related_forumthread.getContent());
			existingforumThread.setCreateTime(related_forumthread.getCreateTime());
			existingforumThread.setLastModified(related_forumthread.getLastModified());
			related_forumthread = existingforumThread;
		}

		comment.setForumThread(related_forumthread);
		related_forumthread.getComments().add(comment);
		comment = commentDAO.store(comment);
		commentDAO.flush();

		related_forumthread = forumThreadDAO.store(related_forumthread);
		forumThreadDAO.flush();

		return comment;
	}

	/**
	 * Save an existing User entity
	 * 
	 * 
	 */
	@Transactional
	public Comment saveCommentUser(Integer id, User related_user) {
		Comment comment = commentDAO.findCommentByPrimaryKey(id, -1, -1);
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

		comment.setUser(related_user);
		related_user.getComments().add(comment);
		comment = commentDAO.store(comment);
		commentDAO.flush();

		related_user = userDAO.store(related_user);
		userDAO.flush();

		return comment;
	}

	/**
	 * 
	 */
	@Transactional
	public Comment findCommentByPrimaryKey(Integer id) {
		return commentDAO.findCommentByPrimaryKey(id);
	}

	/**
	 * Delete an existing ForumThread entity
	 * 
	 * 
	 */
	@Transactional
	public Comment deleteCommentForumThread(Integer comment_id, Integer related_forumthread_id) {
		Comment comment = commentDAO.findCommentByPrimaryKey(comment_id, -1, -1);
		ForumThread related_forumthread = forumThreadDAO.findForumThreadByPrimaryKey(related_forumthread_id, -1, -1);

		comment.setForumThread(null);
		related_forumthread.getComments().remove(comment);
		comment = commentDAO.store(comment);
		commentDAO.flush();

		related_forumthread = forumThreadDAO.store(related_forumthread);
		forumThreadDAO.flush();

		forumThreadDAO.remove(related_forumthread);
		forumThreadDAO.flush();

		return comment;
	}
}
