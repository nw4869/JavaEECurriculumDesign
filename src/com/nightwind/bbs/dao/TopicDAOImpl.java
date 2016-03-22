package com.nightwind.bbs.dao;

import com.nightwind.bbs.domain.Topic;

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
 * DAO to manage Topic entities.
 * 
 */
@Repository("TopicDAO")
@Transactional
public class TopicDAOImpl extends AbstractJpaDao<Topic> implements TopicDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { Topic.class }));

	/**
	 * EntityManager injected by Spring for persistence unit Mysql_bbs
	 *
	 */
	@PersistenceContext(unitName = "Mysql_bbs")
	private EntityManager entityManager;

	/**
	 * Instantiates a new TopicDAOImpl
	 *
	 */
	public TopicDAOImpl() {
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
	 * JPQL Query - findTopicByPin
	 *
	 */
	@Transactional
	public Set<Topic> findTopicByPin(Boolean pin) throws DataAccessException {

		return findTopicByPin(pin, -1, -1);
	}

	/**
	 * JPQL Query - findTopicByPin
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Topic> findTopicByPin(Boolean pin, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTopicByPin", startResult, maxRows, pin);
		return new LinkedHashSet<Topic>(query.getResultList());
	}

	/**
	 * JPQL Query - findTopicByTitleContaining
	 *
	 */
	@Transactional
	public Set<Topic> findTopicByTitleContaining(String title) throws DataAccessException {

		return findTopicByTitleContaining(title, -1, -1);
	}

	/**
	 * JPQL Query - findTopicByTitleContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Topic> findTopicByTitleContaining(String title, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTopicByTitleContaining", startResult, maxRows, title);
		return new LinkedHashSet<Topic>(query.getResultList());
	}

	/**
	 * JPQL Query - findTopicById
	 *
	 */
	@Transactional
	public Topic findTopicById(Integer id) throws DataAccessException {

		return findTopicById(id, -1, -1);
	}

	/**
	 * JPQL Query - findTopicById
	 *
	 */

	@Transactional
	public Topic findTopicById(Integer id, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findTopicById", startResult, maxRows, id);
			return (com.nightwind.bbs.domain.Topic) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findTopicByTitle
	 *
	 */
	@Transactional
	public Set<Topic> findTopicByTitle(String title) throws DataAccessException {

		return findTopicByTitle(title, -1, -1);
	}

	/**
	 * JPQL Query - findTopicByTitle
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Topic> findTopicByTitle(String title, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTopicByTitle", startResult, maxRows, title);
		return new LinkedHashSet<Topic>(query.getResultList());
	}

	/**
	 * JPQL Query - findTopicByLastModified
	 *
	 */
	@Transactional
	public Set<Topic> findTopicByLastModified(java.util.Calendar lastModified) throws DataAccessException {

		return findTopicByLastModified(lastModified, -1, -1);
	}

	/**
	 * JPQL Query - findTopicByLastModified
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Topic> findTopicByLastModified(java.util.Calendar lastModified, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTopicByLastModified", startResult, maxRows, lastModified);
		return new LinkedHashSet<Topic>(query.getResultList());
	}

	/**
	 * JPQL Query - findTopicByContent
	 *
	 */
	@Transactional
	public Set<Topic> findTopicByContent(String content) throws DataAccessException {

		return findTopicByContent(content, -1, -1);
	}

	/**
	 * JPQL Query - findTopicByContent
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Topic> findTopicByContent(String content, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTopicByContent", startResult, maxRows, content);
		return new LinkedHashSet<Topic>(query.getResultList());
	}

	/**
	 * JPQL Query - findTopicByPrimaryKey
	 *
	 */
	@Transactional
	public Topic findTopicByPrimaryKey(Integer id) throws DataAccessException {

		return findTopicByPrimaryKey(id, -1, -1);
	}

	/**
	 * JPQL Query - findTopicByPrimaryKey
	 *
	 */

	@Transactional
	public Topic findTopicByPrimaryKey(Integer id, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findTopicByPrimaryKey", startResult, maxRows, id);
			return (com.nightwind.bbs.domain.Topic) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findTopicByCreateTime
	 *
	 */
	@Transactional
	public Set<Topic> findTopicByCreateTime(java.util.Calendar createTime) throws DataAccessException {

		return findTopicByCreateTime(createTime, -1, -1);
	}

	/**
	 * JPQL Query - findTopicByCreateTime
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Topic> findTopicByCreateTime(java.util.Calendar createTime, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTopicByCreateTime", startResult, maxRows, createTime);
		return new LinkedHashSet<Topic>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllTopics
	 *
	 */
	@Transactional
	public Set<Topic> findAllTopics() throws DataAccessException {

		return findAllTopics(-1, -1);
	}

	/**
	 * JPQL Query - findAllTopics
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Topic> findAllTopics(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllTopics", startResult, maxRows);
		return new LinkedHashSet<Topic>(query.getResultList());
	}

	/**
	 * JPQL Query - findTopicByClicks
	 *
	 */
	@Transactional
	public Set<Topic> findTopicByClicks(Integer clicks) throws DataAccessException {

		return findTopicByClicks(clicks, -1, -1);
	}

	/**
	 * JPQL Query - findTopicByClicks
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Topic> findTopicByClicks(Integer clicks, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTopicByClicks", startResult, maxRows, clicks);
		return new LinkedHashSet<Topic>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(Topic entity) {
		return true;
	}
}
