package com.nightwind.bbs.service;

import java.util.List;

import com.nightwind.bbs.domain.Forum;

public interface ForumService {

	Forum findForumByPrimaryKey(Integer id);

	List<Forum> findAllForums(Integer startResult, Integer maxRows);

	List<Forum> findAllForums(Integer startResult, Integer maxRows, String sort);

}
