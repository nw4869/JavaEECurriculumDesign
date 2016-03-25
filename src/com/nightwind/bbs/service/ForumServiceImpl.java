package com.nightwind.bbs.service;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nightwind.bbs.dao.ForumDAO;
import com.nightwind.bbs.domain.Forum;
import com.nightwind.bbs.exception.ForumNotFoundException;

@Service("ForumService")
public class ForumServiceImpl implements ForumService {

	@Autowired
	private ForumDAO forumDAO;
	
	@Override
	public Forum findForumByPrimaryKey(Integer id) {
		return forumDAO.findForumByPrimaryKey(id);
	}

	@Override
	public List<Forum> findAllForums(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<Forum>(forumDAO.findAllForums(startResult, maxRows));
	}

	@Override
	public List<Forum> findAllForums(Integer startResult, Integer maxRows,
			String sort) {
		// TODO SORT
		return new java.util.ArrayList<Forum>(forumDAO.findAllForums(startResult, maxRows));
	}

	@Override
	public Forum deleteForum(Integer id) throws ForumNotFoundException {
		Forum forum = findForumByPrimaryKey(id);
		if (forum == null) {
			throw new ForumNotFoundException();
		}
		forumDAO.remove(forum);
		forumDAO.flush();
		return forum;
	}

	@Override
	public Forum newForum(Forum forum) {
		forum.setId(null);
		forum = forumDAO.store(forum);
		forumDAO.refresh(forum);
		return forum;
	}
	
	/**
	 * 如果论坛没有主题，则返回null
	 */
	@Override
	public Date getLastActiveTime(Integer forumId) throws ForumNotFoundException{
		Forum forum = forumDAO.findForumById(forumId);
		if (forum == null) {
			throw new ForumNotFoundException();
		}
		if (forum.getTopics().size() == 0) {
			return null;
		}
		
		String queryString = "select t.lastActiveTime from Forum f, Topic t where f.id = t.forum.id and f.id = ?1 order by t.lastActiveTime desc";
		Query query = forumDAO.createQuerySingleResult(queryString, forumId);
		Date date = (Date) query.getSingleResult();
		return date;
	}
	
	@Override
	public Long getTotalReplyCount(Integer forumId) throws ForumNotFoundException{
		Forum forum = forumDAO.findForumById(forumId);
		if (forum == null) {
			throw new ForumNotFoundException();
		}
		String queryString = "select count(r) from Forum f, Topic t, Reply r where f = t.forum and t = r.topic and f.id = ?1";
		return (Long) forumDAO.createQuerySingleResult(queryString, forumId).getSingleResult();
	}
}
