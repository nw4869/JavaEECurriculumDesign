package com.nightwind.bbs.dao;

import com.nightwind.bbs.domain.Forum;

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
 * DAO to manage Forum entities.
 * 
 * @ModelCoreReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/ForumDAO/.properties.datastore]
 * @generated
 */
@Repository("ForumDAO")
@Transactional
public class ForumDAOImpl extends AbstractJpaDao<Forum> implements ForumDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 * @generated
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { Forum.class }));

	/**
	 * EntityManager injected by Spring for persistence unit MySql_bbs
	 *
	 * @generated
	 */
	@PersistenceContext(unitName = "MySql_bbs")
	private EntityManager entityManager;

	/**
	 * Instantiates a new ForumDAOImpl
	 *
	 * @generated
	 */
	public ForumDAOImpl() {
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
	 * JPQL Query - findForumByDescription
	 *
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/ForumDAO/findForumByDescription.query]JPASelect
	 */
	@Transactional
	public Set<Forum> findForumByDescription(String description) throws DataAccessException {

		return findForumByDescription(description, -1, -1);
	}

	/**
	 * JPQL Query - findForumByDescription
	 *
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/ForumDAO/findForumByDescription.query]JPASelectWithPagination
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Forum> findForumByDescription(String description, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findForumByDescription", startResult, maxRows, description);
		return new LinkedHashSet<Forum>(query.getResultList());
	}

	/**
	 * JPQL Query - findForumByTitle
	 *
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/ForumDAO/findForumByTitle.query]JPASelect
	 */
	@Transactional
	public Set<Forum> findForumByTitle(String title) throws DataAccessException {

		return findForumByTitle(title, -1, -1);
	}

	/**
	 * JPQL Query - findForumByTitle
	 *
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/ForumDAO/findForumByTitle.query]JPASelectWithPagination
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Forum> findForumByTitle(String title, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findForumByTitle", startResult, maxRows, title);
		return new LinkedHashSet<Forum>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllForums
	 *
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/ForumDAO/findAllForums.query]JPASelect
	 */
	@Transactional
	public Set<Forum> findAllForums() throws DataAccessException {

		return findAllForums(-1, -1);
	}

	/**
	 * JPQL Query - findAllForums
	 *
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/ForumDAO/findAllForums.query]JPASelectWithPagination
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Forum> findAllForums(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllForums", startResult, maxRows);
		return new LinkedHashSet<Forum>(query.getResultList());
	}

	/**
	 * JPQL Query - findForumByDescriptionContaining
	 *
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/ForumDAO/findForumByDescriptionContaining.query]JPASelect
	 */
	@Transactional
	public Set<Forum> findForumByDescriptionContaining(String description) throws DataAccessException {

		return findForumByDescriptionContaining(description, -1, -1);
	}

	/**
	 * JPQL Query - findForumByDescriptionContaining
	 *
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/ForumDAO/findForumByDescriptionContaining.query]JPASelectWithPagination
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Forum> findForumByDescriptionContaining(String description, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findForumByDescriptionContaining", startResult, maxRows, description);
		return new LinkedHashSet<Forum>(query.getResultList());
	}

	/**
	 * JPQL Query - findForumById
	 *
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/ForumDAO/findForumById.query]JPASelect
	 */
	@Transactional
	public Forum findForumById(Integer id) throws DataAccessException {

		return findForumById(id, -1, -1);
	}

	/**
	 * JPQL Query - findForumById
	 *
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/ForumDAO/findForumById.query]JPASelectWithPagination
	 */

	@Transactional
	public Forum findForumById(Integer id, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findForumById", startResult, maxRows, id);
			return (com.nightwind.bbs.domain.Forum) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findForumByTitleContaining
	 *
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/ForumDAO/findForumByTitleContaining.query]JPASelect
	 */
	@Transactional
	public Set<Forum> findForumByTitleContaining(String title) throws DataAccessException {

		return findForumByTitleContaining(title, -1, -1);
	}

	/**
	 * JPQL Query - findForumByTitleContaining
	 *
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/ForumDAO/findForumByTitleContaining.query]JPASelectWithPagination
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Forum> findForumByTitleContaining(String title, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findForumByTitleContaining", startResult, maxRows, title);
		return new LinkedHashSet<Forum>(query.getResultList());
	}

	/**
	 * JPQL Query - findForumByPrimaryKey
	 *
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/ForumDAO/findForumByPrimaryKey.query]JPASelect
	 */
	@Transactional
	public Forum findForumByPrimaryKey(Integer id) throws DataAccessException {

		return findForumByPrimaryKey(id, -1, -1);
	}

	/**
	 * JPQL Query - findForumByPrimaryKey
	 *
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/ForumDAO/findForumByPrimaryKey.query]JPASelectWithPagination
	 */

	@Transactional
	public Forum findForumByPrimaryKey(Integer id, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findForumByPrimaryKey", startResult, maxRows, id);
			return (com.nightwind.bbs.domain.Forum) query.getSingleResult();
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
	public boolean canBeMerged(Forum entity) {
		return true;
	}
}