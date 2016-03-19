package com.nightwind.bbs.dao;

import com.nightwind.bbs.domain.ForumThread;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.skyway.spring.util.dao.AbstractJpaDao;

import org.springframework.dao.DataAccessException;

import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;

/**
 * DAO to manage ForumThread entities.
 * 
 * @ModelCoreReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/ForumThreadDAO/.properties.datastore]
 * @generated
 */
@Repository("ForumThreadDAO")
@Transactional
public class ForumThreadDAOImpl extends AbstractJpaDao<ForumThread> implements
		ForumThreadDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 * @generated
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { ForumThread.class }));

	/**
	 * EntityManager injected by Spring for persistence unit MySql_bbs
	 *
	 * @generated
	 */
	@PersistenceContext(unitName = "MySql_bbs")
	private EntityManager entityManager;

	/**
	 * Instantiates a new ForumThreadDAOImpl
	 *
	 * @generated
	 */
	public ForumThreadDAOImpl() {
		super();
	}

	/**
	 * Get the entity manager that manages persistence unit 
	 *
	 * @generated
	 */
	public EntityManager getEntityManager() {
		return entityManager;
	}

	/**
	 * Returns the set of entity classes managed by this DAO.
	 *
	 * @generated
	 */
	public Set<Class<?>> getTypes() {
		return dataTypes;
	}

	/**
	 * JPQL Query - findForumThreadById
	 *
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/ForumThreadDAO/findForumThreadById.query]JPASelect
	 */
	@Transactional
	public ForumThread findForumThreadById(Integer id) throws DataAccessException {

		return findForumThreadById(id, -1, -1);
	}

	/**
	 * JPQL Query - findForumThreadById
	 *
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/ForumThreadDAO/findForumThreadById.query]JPASelectWithPagination
	 */

	@Transactional
	public ForumThread findForumThreadById(Integer id, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findForumThreadById", startResult, maxRows, id);
			return (com.nightwind.bbs.domain.ForumThread) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findForumThreadByContent
	 *
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/ForumThreadDAO/findForumThreadByContent.query]JPASelect
	 */
	@Transactional
	public Set<ForumThread> findForumThreadByContent(String content1) throws DataAccessException {

		return findForumThreadByContent(content1, -1, -1);
	}

	/**
	 * JPQL Query - findForumThreadByContent
	 *
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/ForumThreadDAO/findForumThreadByContent.query]JPASelectWithPagination
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<ForumThread> findForumThreadByContent(String content1, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findForumThreadByContent", startResult, maxRows, content1);
		return new LinkedHashSet<ForumThread>(query.getResultList());
	}

	/**
	 * JPQL Query - findForumThreadByTitle
	 *
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/ForumThreadDAO/findForumThreadByTitle.query]JPASelect
	 */
	@Transactional
	public Set<ForumThread> findForumThreadByTitle(String title) throws DataAccessException {

		return findForumThreadByTitle(title, -1, -1);
	}

	/**
	 * JPQL Query - findForumThreadByTitle
	 *
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/ForumThreadDAO/findForumThreadByTitle.query]JPASelectWithPagination
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<ForumThread> findForumThreadByTitle(String title, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findForumThreadByTitle", startResult, maxRows, title);
		return new LinkedHashSet<ForumThread>(query.getResultList());
	}

	/**
	 * JPQL Query - findForumThreadByTitleContaining
	 *
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/ForumThreadDAO/findForumThreadByTitleContaining.query]JPASelect
	 */
	@Transactional
	public Set<ForumThread> findForumThreadByTitleContaining(String title) throws DataAccessException {

		return findForumThreadByTitleContaining(title, -1, -1);
	}

	/**
	 * JPQL Query - findForumThreadByTitleContaining
	 *
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/ForumThreadDAO/findForumThreadByTitleContaining.query]JPASelectWithPagination
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<ForumThread> findForumThreadByTitleContaining(String title, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findForumThreadByTitleContaining", startResult, maxRows, title);
		return new LinkedHashSet<ForumThread>(query.getResultList());
	}

	/**
	 * JPQL Query - findForumThreadByCreateTime
	 *
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/ForumThreadDAO/findForumThreadByCreateTime.query]JPASelect
	 */
	@Transactional
	public Set<ForumThread> findForumThreadByCreateTime(java.util.Calendar createTime) throws DataAccessException {

		return findForumThreadByCreateTime(createTime, -1, -1);
	}

	/**
	 * JPQL Query - findForumThreadByCreateTime
	 *
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/ForumThreadDAO/findForumThreadByCreateTime.query]JPASelectWithPagination
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<ForumThread> findForumThreadByCreateTime(java.util.Calendar createTime, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findForumThreadByCreateTime", startResult, maxRows, createTime);
		return new LinkedHashSet<ForumThread>(query.getResultList());
	}

	/**
	 * JPQL Query - findForumThreadByLastModified
	 *
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/ForumThreadDAO/findForumThreadByLastModified.query]JPASelect
	 */
	@Transactional
	public Set<ForumThread> findForumThreadByLastModified(java.util.Calendar lastModified) throws DataAccessException {

		return findForumThreadByLastModified(lastModified, -1, -1);
	}

	/**
	 * JPQL Query - findForumThreadByLastModified
	 *
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/ForumThreadDAO/findForumThreadByLastModified.query]JPASelectWithPagination
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<ForumThread> findForumThreadByLastModified(java.util.Calendar lastModified, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findForumThreadByLastModified", startResult, maxRows, lastModified);
		return new LinkedHashSet<ForumThread>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllForumThreads
	 *
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/ForumThreadDAO/findAllForumThreads.query]JPASelect
	 */
	@Transactional
	public Set<ForumThread> findAllForumThreads() throws DataAccessException {

		return findAllForumThreads(-1, -1);
	}

	/**
	 * JPQL Query - findAllForumThreads
	 *
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/ForumThreadDAO/findAllForumThreads.query]JPASelectWithPagination
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<ForumThread> findAllForumThreads(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllForumThreads", startResult, maxRows);
		return new LinkedHashSet<ForumThread>(query.getResultList());
	}

	/**
	 * JPQL Query - findForumThreadByPrimaryKey
	 *
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/ForumThreadDAO/findForumThreadByPrimaryKey.query]JPASelect
	 */
	@Transactional
	public ForumThread findForumThreadByPrimaryKey(Integer id) throws DataAccessException {

		return findForumThreadByPrimaryKey(id, -1, -1);
	}

	/**
	 * JPQL Query - findForumThreadByPrimaryKey
	 *
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/ForumThreadDAO/findForumThreadByPrimaryKey.query]JPASelectWithPagination
	 */

	@Transactional
	public ForumThread findForumThreadByPrimaryKey(Integer id, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findForumThreadByPrimaryKey", startResult, maxRows, id);
			return (com.nightwind.bbs.domain.ForumThread) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 * @generated
	 */
	public boolean canBeMerged(ForumThread entity) {
		return true;
	}
}