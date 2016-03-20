package com.nightwind.bbs.dao;

import com.nightwind.bbs.domain.Forum;

import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

/**
 * DAO to manage Forum entities.
 * 
 * 
 * @generated
 * @AuxiliaryModelComponent
 */
public interface ForumDAO extends JpaDao<Forum> {

	/**
	 * JPQL Query - findForumByDescription
	 *
	 * JPASelect
	 */
	public Set<Forum> findForumByDescription(String description_1) throws DataAccessException;

	/**
	 * JPQL Query - findForumByDescription
	 *
	 * JPASelectWithPagination
	 */
	public Set<Forum> findForumByDescription(String description_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findForumByTitle
	 *
	 * JPASelect
	 */
	public Set<Forum> findForumByTitle(String title) throws DataAccessException;

	/**
	 * JPQL Query - findForumByTitle
	 *
	 * JPASelectWithPagination
	 */
	public Set<Forum> findForumByTitle(String title, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllForums
	 *
	 * JPASelect
	 */
	public Set<Forum> findAllForums() throws DataAccessException;

	/**
	 * JPQL Query - findAllForums
	 *
	 * JPASelectWithPagination
	 */
	public Set<Forum> findAllForums(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findForumByDescriptionContaining
	 *
	 * JPASelect
	 */
	public Set<Forum> findForumByDescriptionContaining(String description) throws DataAccessException;

	/**
	 * JPQL Query - findForumByDescriptionContaining
	 *
	 * JPASelectWithPagination
	 */
	public Set<Forum> findForumByDescriptionContaining(String description, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findForumById
	 *
	 * JPASelect
	 */
	public Forum findForumById(Integer id) throws DataAccessException;

	/**
	 * JPQL Query - findForumById
	 *
	 * JPASelectWithPagination
	 */
	public Forum findForumById(Integer id, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findForumByTitleContaining
	 *
	 * JPASelect
	 */
	public Set<Forum> findForumByTitleContaining(String title_1) throws DataAccessException;

	/**
	 * JPQL Query - findForumByTitleContaining
	 *
	 * JPASelectWithPagination
	 */
	public Set<Forum> findForumByTitleContaining(String title_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findForumByPrimaryKey
	 *
	 * JPASelect
	 */
	public Forum findForumByPrimaryKey(Integer id_1) throws DataAccessException;

	/**
	 * JPQL Query - findForumByPrimaryKey
	 *
	 * JPASelectWithPagination
	 */
	public Forum findForumByPrimaryKey(Integer id_1, int startResult, int maxRows) throws DataAccessException;

}