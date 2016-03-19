package com.nightwind.bbs.dao;

import com.nightwind.bbs.domain.Comment;

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
 * DAO to manage Comment entities.
 * 
 * @ModelCoreReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/CommentDAO/.properties.datastore]
 * @generated
 */
@Repository("CommentDAO")
@Transactional
public class CommentDAOImpl extends AbstractJpaDao<Comment> implements
		CommentDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 * @generated
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { Comment.class }));

	/**
	 * EntityManager injected by Spring for persistence unit MySql_bbs
	 *
	 * @generated
	 */
	@PersistenceContext(unitName = "MySql_bbs")
	private EntityManager entityManager;

	/**
	 * Instantiates a new CommentDAOImpl
	 *
	 * @generated
	 */
	public CommentDAOImpl() {
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
	 * JPQL Query - findCommentById
	 *
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/CommentDAO/findCommentById.query]JPASelect
	 */
	@Transactional
	public Comment findCommentById(Integer id) throws DataAccessException {

		return findCommentById(id, -1, -1);
	}

	/**
	 * JPQL Query - findCommentById
	 *
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/CommentDAO/findCommentById.query]JPASelectWithPagination
	 */

	@Transactional
	public Comment findCommentById(Integer id, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findCommentById", startResult, maxRows, id);
			return (com.nightwind.bbs.domain.Comment) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findCommentByPrimaryKey
	 *
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/CommentDAO/findCommentByPrimaryKey.query]JPASelect
	 */
	@Transactional
	public Comment findCommentByPrimaryKey(Integer id) throws DataAccessException {

		return findCommentByPrimaryKey(id, -1, -1);
	}

	/**
	 * JPQL Query - findCommentByPrimaryKey
	 *
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/CommentDAO/findCommentByPrimaryKey.query]JPASelectWithPagination
	 */

	@Transactional
	public Comment findCommentByPrimaryKey(Integer id, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findCommentByPrimaryKey", startResult, maxRows, id);
			return (com.nightwind.bbs.domain.Comment) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findAllComments
	 *
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/CommentDAO/findAllComments.query]JPASelect
	 */
	@Transactional
	public Set<Comment> findAllComments() throws DataAccessException {

		return findAllComments(-1, -1);
	}

	/**
	 * JPQL Query - findAllComments
	 *
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/CommentDAO/findAllComments.query]JPASelectWithPagination
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Comment> findAllComments(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllComments", startResult, maxRows);
		return new LinkedHashSet<Comment>(query.getResultList());
	}

	/**
	 * JPQL Query - findCommentByTitle
	 *
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/CommentDAO/findCommentByTitle.query]JPASelect
	 */
	@Transactional
	public Set<Comment> findCommentByTitle(String title) throws DataAccessException {

		return findCommentByTitle(title, -1, -1);
	}

	/**
	 * JPQL Query - findCommentByTitle
	 *
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/CommentDAO/findCommentByTitle.query]JPASelectWithPagination
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Comment> findCommentByTitle(String title, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findCommentByTitle", startResult, maxRows, title);
		return new LinkedHashSet<Comment>(query.getResultList());
	}

	/**
	 * JPQL Query - findCommentByTitleContaining
	 *
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/CommentDAO/findCommentByTitleContaining.query]JPASelect
	 */
	@Transactional
	public Set<Comment> findCommentByTitleContaining(String title) throws DataAccessException {

		return findCommentByTitleContaining(title, -1, -1);
	}

	/**
	 * JPQL Query - findCommentByTitleContaining
	 *
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/CommentDAO/findCommentByTitleContaining.query]JPASelectWithPagination
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Comment> findCommentByTitleContaining(String title, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findCommentByTitleContaining", startResult, maxRows, title);
		return new LinkedHashSet<Comment>(query.getResultList());
	}

	/**
	 * JPQL Query - findCommentByContent
	 *
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/CommentDAO/findCommentByContent.query]JPASelect
	 */
	@Transactional
	public Set<Comment> findCommentByContent(String content1) throws DataAccessException {

		return findCommentByContent(content1, -1, -1);
	}

	/**
	 * JPQL Query - findCommentByContent
	 *
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/CommentDAO/findCommentByContent.query]JPASelectWithPagination
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Comment> findCommentByContent(String content1, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findCommentByContent", startResult, maxRows, content1);
		return new LinkedHashSet<Comment>(query.getResultList());
	}

	/**
	 * JPQL Query - findCommentByCreateTime
	 *
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/CommentDAO/findCommentByCreateTime.query]JPASelect
	 */
	@Transactional
	public Set<Comment> findCommentByCreateTime(java.util.Calendar createTime) throws DataAccessException {

		return findCommentByCreateTime(createTime, -1, -1);
	}

	/**
	 * JPQL Query - findCommentByCreateTime
	 *
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/CommentDAO/findCommentByCreateTime.query]JPASelectWithPagination
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Comment> findCommentByCreateTime(java.util.Calendar createTime, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findCommentByCreateTime", startResult, maxRows, createTime);
		return new LinkedHashSet<Comment>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 * @generated
	 */
	public boolean canBeMerged(Comment entity) {
		return true;
	}
}