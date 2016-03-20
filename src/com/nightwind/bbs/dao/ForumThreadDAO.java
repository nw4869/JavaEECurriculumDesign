package com.nightwind.bbs.dao;

import com.nightwind.bbs.domain.ForumThread;

import java.util.Calendar;
import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

/**
 * DAO to manage ForumThread entities.
 * 
 * 
 * @generated
 * @AuxiliaryModelComponent
 */
public interface ForumThreadDAO extends JpaDao<ForumThread> {

	/**
	 * JPQL Query - findForumThreadById
	 *
	 * JPASelect
	 */
	public ForumThread findForumThreadById(Integer id_1) throws DataAccessException;

	/**
	 * JPQL Query - findForumThreadById
	 *
	 * JPASelectWithPagination
	 */
	public ForumThread findForumThreadById(Integer id_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findForumThreadByContent
	 *
	 * JPASelect
	 */
	public Set<ForumThread> findForumThreadByContent(String content1) throws DataAccessException;

	/**
	 * JPQL Query - findForumThreadByContent
	 *
	 * JPASelectWithPagination
	 */
	public Set<ForumThread> findForumThreadByContent(String content1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findForumThreadByTitle
	 *
	 * JPASelect
	 */
	public Set<ForumThread> findForumThreadByTitle(String title_1) throws DataAccessException;

	/**
	 * JPQL Query - findForumThreadByTitle
	 *
	 * JPASelectWithPagination
	 */
	public Set<ForumThread> findForumThreadByTitle(String title_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findForumThreadByTitleContaining
	 *
	 * JPASelect
	 */
	public Set<ForumThread> findForumThreadByTitleContaining(String title) throws DataAccessException;

	/**
	 * JPQL Query - findForumThreadByTitleContaining
	 *
	 * JPASelectWithPagination
	 */
	public Set<ForumThread> findForumThreadByTitleContaining(String title, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findForumThreadByCreateTime
	 *
	 * JPASelect
	 */
	public Set<ForumThread> findForumThreadByCreateTime(java.util.Calendar createTime) throws DataAccessException;

	/**
	 * JPQL Query - findForumThreadByCreateTime
	 *
	 * JPASelectWithPagination
	 */
	public Set<ForumThread> findForumThreadByCreateTime(Calendar createTime, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findForumThreadByLastModified
	 *
	 * JPASelect
	 */
	public Set<ForumThread> findForumThreadByLastModified(java.util.Calendar lastModified) throws DataAccessException;

	/**
	 * JPQL Query - findForumThreadByLastModified
	 *
	 * JPASelectWithPagination
	 */
	public Set<ForumThread> findForumThreadByLastModified(Calendar lastModified, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllForumThreads
	 *
	 * JPASelect
	 */
	public Set<ForumThread> findAllForumThreads() throws DataAccessException;

	/**
	 * JPQL Query - findAllForumThreads
	 *
	 * JPASelectWithPagination
	 */
	public Set<ForumThread> findAllForumThreads(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findForumThreadByPrimaryKey
	 *
	 * JPASelect
	 */
	public ForumThread findForumThreadByPrimaryKey(Integer id) throws DataAccessException;

	/**
	 * JPQL Query - findForumThreadByPrimaryKey
	 *
	 * JPASelectWithPagination
	 */
	public ForumThread findForumThreadByPrimaryKey(Integer id, int startResult, int maxRows) throws DataAccessException;

}