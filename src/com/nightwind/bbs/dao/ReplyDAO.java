package com.nightwind.bbs.dao;

import com.nightwind.bbs.domain.Reply;

import java.util.Calendar;
import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

/**
 * DAO to manage Reply entities.
 * 
 */
public interface ReplyDAO extends JpaDao<Reply> {

	/**
	 * JPQL Query - findReplyByTitleContaining
	 *
	 */
	public Set<Reply> findReplyByTitleContaining(String title) throws DataAccessException;

	/**
	 * JPQL Query - findReplyByTitleContaining
	 *
	 */
	public Set<Reply> findReplyByTitleContaining(String title, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findReplyByContent
	 *
	 */
	public Set<Reply> findReplyByContent(String content) throws DataAccessException;

	/**
	 * JPQL Query - findReplyByContent
	 *
	 */
	public Set<Reply> findReplyByContent(String content, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findReplyByTitle
	 *
	 */
	public Set<Reply> findReplyByTitle(String title_1) throws DataAccessException;

	/**
	 * JPQL Query - findReplyByTitle
	 *
	 */
	public Set<Reply> findReplyByTitle(String title_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllReplys
	 *
	 */
	public Set<Reply> findAllReplys() throws DataAccessException;

	/**
	 * JPQL Query - findAllReplys
	 *
	 */
	public Set<Reply> findAllReplys(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findReplyByPrimaryKey
	 *
	 */
	public Reply findReplyByPrimaryKey(Integer id) throws DataAccessException;

	/**
	 * JPQL Query - findReplyByPrimaryKey
	 *
	 */
	public Reply findReplyByPrimaryKey(Integer id, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findReplyById
	 *
	 */
	public Reply findReplyById(Integer id_1) throws DataAccessException;

	/**
	 * JPQL Query - findReplyById
	 *
	 */
	public Reply findReplyById(Integer id_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findReplyByCreateTime
	 *
	 */
	public Set<Reply> findReplyByCreateTime(java.util.Calendar createTime) throws DataAccessException;

	/**
	 * JPQL Query - findReplyByCreateTime
	 *
	 */
	public Set<Reply> findReplyByCreateTime(Calendar createTime, int startResult, int maxRows) throws DataAccessException;

}