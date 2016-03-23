package com.nightwind.bbs.dao;

import com.nightwind.bbs.domain.Forum;

import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

/**
 * DAO to manage Forum entities.
 * 
 */
public interface ForumDAO extends JpaDao<Forum> {

	/**
	 * JPQL Query - findForumById
	 *
	 */
	public Forum findForumById(Integer id) throws DataAccessException;

	/**
	 * JPQL Query - findForumById
	 *
	 */
	public Forum findForumById(Integer id, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findForumByDescription
	 *
	 */
	public Set<Forum> findForumByDescription(String description) throws DataAccessException;

	/**
	 * JPQL Query - findForumByDescription
	 *
	 */
	public Set<Forum> findForumByDescription(String description, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findForumByPrimaryKey
	 *
	 */
	public Forum findForumByPrimaryKey(Integer id_1) throws DataAccessException;

	/**
	 * JPQL Query - findForumByPrimaryKey
	 *
	 */
	public Forum findForumByPrimaryKey(Integer id_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findForumByDescriptionContaining
	 *
	 */
	public Set<Forum> findForumByDescriptionContaining(String description_1) throws DataAccessException;

	/**
	 * JPQL Query - findForumByDescriptionContaining
	 *
	 */
	public Set<Forum> findForumByDescriptionContaining(String description_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findForumByTitleContaining
	 *
	 */
	public Set<Forum> findForumByTitleContaining(String title) throws DataAccessException;

	/**
	 * JPQL Query - findForumByTitleContaining
	 *
	 */
	public Set<Forum> findForumByTitleContaining(String title, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findForumByTitle
	 *
	 */
	public Set<Forum> findForumByTitle(String title_1) throws DataAccessException;

	/**
	 * JPQL Query - findForumByTitle
	 *
	 */
	public Set<Forum> findForumByTitle(String title_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllForums
	 *
	 */
	public Set<Forum> findAllForums() throws DataAccessException;

	/**
	 * JPQL Query - findAllForums
	 *
	 */
	public Set<Forum> findAllForums(int startResult, int maxRows) throws DataAccessException;

}