package com.nightwind.bbs.service;

import java.util.Date;
import java.util.List;

import com.nightwind.bbs.domain.Forum;
import com.nightwind.bbs.exception.ForumNotFoundException;

public interface ForumService {

	Forum findForumByPrimaryKey(Integer id);

	List<Forum> findAllForums(Integer startResult, Integer maxRows);

	List<Forum> findAllForums(Integer startResult, Integer maxRows, String sort);

	Forum deleteForum(Integer id) throws ForumNotFoundException;

	Forum newForum(Forum forum);

	Date getLastActiveTime(Integer forumId) throws ForumNotFoundException;

	Long getTotalReplyCount(Integer forumId) throws ForumNotFoundException;

}
