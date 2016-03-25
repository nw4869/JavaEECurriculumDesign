package com.nightwind.bbs.dao;

import com.nightwind.bbs.domain.Reply;

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
 * DAO to manage Reply entities.
 * 
 */
@Repository("ReplyDAO")
@Transactional
public class ReplyDAOImpl extends AbstractJpaDao<Reply> implements ReplyDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { Reply.class }));

	/**
	 * EntityManager injected by Spring for persistence unit Mysql_bbs
	 *
	 */
	@PersistenceContext(unitName = "Mysql_bbs")
	private EntityManager entityManager;

	/**
	 * Instantiates a new ReplyDAOImpl
	 *
	 */
	public ReplyDAOImpl() {
		super();
	}

	/**
	 * Get the entity manager that manages persistence unit 
	 *
	 */
	public EntityManager getEntityManager() {
		return entityManager;
	}

	/**
	 * Returns the set of entity classes managed by this DAO.
	 *
	 */
	public Set<Class<?>> getTypes() {
		return dataTypes;
	}

	/**
	 * JPQL Query - findReplyByTitleContaining
	 *
	 */
	@Transactional
	public Set<Reply> findReplyByTitleContaining(String title) throws DataAccessException {

		return findReplyByTitleContaining(title, -1, -1);
	}

	/**
	 * JPQL Query - findReplyByTitleContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Reply> findReplyByTitleContaining(String title, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findReplyByTitleContaining", startResult, maxRows, title);
		return new LinkedHashSet<Reply>(query.getResultList());
	}

	/**
	 * JPQL Query - findReplyByContent
	 *
	 */
	@Transactional
	public Set<Reply> findReplyByContent(String content) throws DataAccessException {

		return findReplyByContent(content, -1, -1);
	}

	/**
	 * JPQL Query - findReplyByContent
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Reply> findReplyByContent(String content, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findReplyByContent", startResult, maxRows, content);
		return new LinkedHashSet<Reply>(query.getResultList());
	}

	/**
	 * JPQL Query - findReplyByTitle
	 *
	 */
	@Transactional
	public Set<Reply> findReplyByTitle(String title) throws DataAccessException {

		return findReplyByTitle(title, -1, -1);
	}

	/**
	 * JPQL Query - findReplyByTitle
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Reply> findReplyByTitle(String title, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findReplyByTitle", startResult, maxRows, title);
		return new LinkedHashSet<Reply>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllReplys
	 *
	 */
	@Transactional
	public Set<Reply> findAllReplys() throws DataAccessException {

		return findAllReplys(-1, -1);
	}

	/**
	 * JPQL Query - findAllReplys
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Reply> findAllReplys(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllReplys", startResult, maxRows);
		return new LinkedHashSet<Reply>(query.getResultList());
	}

	/**
	 * JPQL Query - findReplyByPrimaryKey
	 *
	 */
	@Transactional
	public Reply findReplyByPrimaryKey(Integer id) throws DataAccessException {

		return findReplyByPrimaryKey(id, -1, -1);
	}

	/**
	 * JPQL Query - findReplyByPrimaryKey
	 *
	 */

	@Transactional
	public Reply findReplyByPrimaryKey(Integer id, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findReplyByPrimaryKey", startResult, maxRows, id);
			return (com.nightwind.bbs.domain.Reply) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findReplyById
	 *
	 */
	@Transactional
	public Reply findReplyById(Integer id) throws DataAccessException {

		return findReplyById(id, -1, -1);
	}

	/**
	 * JPQL Query - findReplyById
	 *
	 */

	@Transactional
	public Reply findReplyById(Integer id, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findReplyById", startResult, maxRows, id);
			return (com.nightwind.bbs.domain.Reply) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findReplyByCreateTime
	 *
	 */
	@Transactional
	public Set<Reply> findReplyByCreateTime(java.util.Calendar createTime) throws DataAccessException {

		return findReplyByCreateTime(createTime, -1, -1);
	}

	/**
	 * JPQL Query - findReplyByCreateTime
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Reply> findReplyByCreateTime(java.util.Calendar createTime, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findReplyByCreateTime", startResult, maxRows, createTime);
		return new LinkedHashSet<Reply>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(Reply entity) {
		return true;
	}
}
