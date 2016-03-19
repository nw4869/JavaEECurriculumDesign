package com.nightwind.bbs.dao;

import com.nightwind.bbs.domain.ForumThread;

import java.util.Calendar;
import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

/**
 * DAO to manage ForumThread entities.
 * 
 * @ModelCoreReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/ForumThreadDAO/.properties.datastore]
 * @generated
 * @AuxiliaryModelComponent
 */
public interface ForumThreadDAO extends JpaDao<ForumThread> {

	/**
	 * JPQL Query - findForumThreadById
	 *
	 * @ModelCoreReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/ForumThreadDAO/findForumThreadById.query]JPASelect
	 */
	public ForumThread findForumThreadById(Integer id) throws DataAccessException;

	/**
	 * JPQL Query - findForumThreadById
	 *
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/ForumThreadDAO/findForumThreadById.query]JPASelectWithPagination
	 */
	public ForumThread findForumThreadById(Integer id, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findForumThreadByContent
	 *
	 * @ModelCoreReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/ForumThreadDAO/findForumThreadByContent.query]JPASelect
	 */
	public Set<ForumThread> findForumThreadByContent(String content1) throws DataAccessException;

	/**
	 * JPQL Query - findForumThreadByContent
	 *
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/ForumThreadDAO/findForumThreadByContent.query]JPASelectWithPagination
	 */
	public Set<ForumThread> findForumThreadByContent(String content1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findForumThreadByTitle
	 *
	 * @ModelCoreReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/ForumThreadDAO/findForumThreadByTitle.query]JPASelect
	 */
	public Set<ForumThread> findForumThreadByTitle(String title) throws DataAccessException;

	/**
	 * JPQL Query - findForumThreadByTitle
	 *
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/ForumThreadDAO/findForumThreadByTitle.query]JPASelectWithPagination
	 */
	public Set<ForumThread> findForumThreadByTitle(String title, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findForumThreadByTitleContaining
	 *
	 * @ModelCoreReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/ForumThreadDAO/findForumThreadByTitleContaining.query]JPASelect
	 */
	public Set<ForumThread> findForumThreadByTitleContaining(String title_1) throws DataAccessException;

	/**
	 * JPQL Query - findForumThreadByTitleContaining
	 *
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/ForumThreadDAO/findForumThreadByTitleContaining.query]JPASelectWithPagination
	 */
	public Set<ForumThread> findForumThreadByTitleContaining(String title_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findForumThreadByCreateTime
	 *
	 * @ModelCoreReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/ForumThreadDAO/findForumThreadByCreateTime.query]JPASelect
	 */
	public Set<ForumThread> findForumThreadByCreateTime(java.util.Calendar createTime) throws DataAccessException;

	/**
	 * JPQL Query - findForumThreadByCreateTime
	 *
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/ForumThreadDAO/findForumThreadByCreateTime.query]JPASelectWithPagination
	 */
	public Set<ForumThread> findForumThreadByCreateTime(Calendar createTime, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findForumThreadByLastModified
	 *
	 * @ModelCoreReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/ForumThreadDAO/findForumThreadByLastModified.query]JPASelect
	 */
	public Set<ForumThread> findForumThreadByLastModified(java.util.Calendar lastModified) throws DataAccessException;

	/**
	 * JPQL Query - findForumThreadByLastModified
	 *
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/ForumThreadDAO/findForumThreadByLastModified.query]JPASelectWithPagination
	 */
	public Set<ForumThread> findForumThreadByLastModified(Calendar lastModified, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllForumThreads
	 *
	 * @ModelCoreReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/ForumThreadDAO/findAllForumThreads.query]JPASelect
	 */
	public Set<ForumThread> findAllForumThreads() throws DataAccessException;

	/**
	 * JPQL Query - findAllForumThreads
	 *
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/ForumThreadDAO/findAllForumThreads.query]JPASelectWithPagination
	 */
	public Set<ForumThread> findAllForumThreads(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findForumThreadByPrimaryKey
	 *
	 * @ModelCoreReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/ForumThreadDAO/findForumThreadByPrimaryKey.query]JPASelect
	 */
	public ForumThread findForumThreadByPrimaryKey(Integer id_1) throws DataAccessException;

	/**
	 * JPQL Query - findForumThreadByPrimaryKey
	 *
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/ForumThreadDAO/findForumThreadByPrimaryKey.query]JPASelectWithPagination
	 */
	public ForumThread findForumThreadByPrimaryKey(Integer id_1, int startResult, int maxRows) throws DataAccessException;

}