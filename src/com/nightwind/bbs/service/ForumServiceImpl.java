package com.nightwind.bbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nightwind.bbs.dao.ForumDAO;
import com.nightwind.bbs.domain.Forum;
import com.nightwind.bbs.exception.ForumNotFoundException;
import com.nightwind.bbs.service.ForumService;

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
}
