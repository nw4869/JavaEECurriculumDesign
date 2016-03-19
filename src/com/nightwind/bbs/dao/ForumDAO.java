package com.nightwind.bbs.dao;

import com.nightwind.bbs.domain.Forum;

import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

/**
 * DAO to manage Forum entities.
 * 
 * @ModelCoreReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/ForumDAO/.properties.datastore]
 * @generated
 * @AuxiliaryModelComponent
 */
public interface ForumDAO extends JpaDao<Forum> {

	/**
	 * JPQL Query - findForumByDescription
	 *
	 * @ModelCoreReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/ForumDAO/findForumByDescription.query]JPASelect
	 */
	public Set<Forum> findForumByDescription(String description) throws DataAccessException;

	/**
	 * JPQL Query - findForumByDescription
	 *
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/ForumDAO/findForumByDescription.query]JPASelectWithPagination
	 */
	public Set<Forum> findForumByDescription(String description, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findForumByTitle
	 *
	 * @ModelCoreReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/ForumDAO/findForumByTitle.query]JPASelect
	 */
	public Set<Forum> findForumByTitle(String title) throws DataAccessException;

	/**
	 * JPQL Query - findForumByTitle
	 *
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/ForumDAO/findForumByTitle.query]JPASelectWithPagination
	 */
	public Set<Forum> findForumByTitle(String title, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllForums
	 *
	 * @ModelCoreReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/ForumDAO/findAllForums.query]JPASelect
	 */
	public Set<Forum> findAllForums() throws DataAccessException;

	/**
	 * JPQL Query - findAllForums
	 *
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/ForumDAO/findAllForums.query]JPASelectWithPagination
	 */
	public Set<Forum> findAllForums(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findForumByDescriptionContaining
	 *
	 * @ModelCoreReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/ForumDAO/findForumByDescriptionContaining.query]JPASelect
	 */
	public Set<Forum> findForumByDescriptionContaining(String description_1) throws DataAccessException;

	/**
	 * JPQL Query - findForumByDescriptionContaining
	 *
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/ForumDAO/findForumByDescriptionContaining.query]JPASelectWithPagination
	 */
	public Set<Forum> findForumByDescriptionContaining(String description_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findForumById
	 *
	 * @ModelCoreReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/ForumDAO/findForumById.query]JPASelect
	 */
	public Forum findForumById(Integer id) throws DataAccessException;

	/**
	 * JPQL Query - findForumById
	 *
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/ForumDAO/findForumById.query]JPASelectWithPagination
	 */
	public Forum findForumById(Integer id, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findForumByTitleContaining
	 *
	 * @ModelCoreReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/ForumDAO/findForumByTitleContaining.query]JPASelect
	 */
	public Set<Forum> findForumByTitleContaining(String title_1) throws DataAccessException;

	/**
	 * JPQL Query - findForumByTitleContaining
	 *
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/ForumDAO/findForumByTitleContaining.query]JPASelectWithPagination
	 */
	public Set<Forum> findForumByTitleContaining(String title_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findForumByPrimaryKey
	 *
	 * @ModelCoreReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/ForumDAO/findForumByPrimaryKey.query]JPASelect
	 */
	public Forum findForumByPrimaryKey(Integer id_1) throws DataAccessException;

	/**
	 * JPQL Query - findForumByPrimaryKey
	 *
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/ForumDAO/findForumByPrimaryKey.query]JPASelectWithPagination
	 */
	public Forum findForumByPrimaryKey(Integer id_1, int startResult, int maxRows) throws DataAccessException;

}