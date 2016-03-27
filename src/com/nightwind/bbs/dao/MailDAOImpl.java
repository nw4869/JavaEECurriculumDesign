package com.nightwind.bbs.dao;

import com.nightwind.bbs.domain.Mail;

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
 * DAO to manage Mail entities.
 * 
 */
@Repository("MailDAO")
@Transactional
public class MailDAOImpl extends AbstractJpaDao<Mail> implements MailDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { Mail.class }));

	/**
	 * EntityManager injected by Spring for persistence unit MySql_bbs
	 *
	 */
	@PersistenceContext(unitName = "Mysql_bbs")
	private EntityManager entityManager;

	/**
	 * Instantiates a new MailDAOImpl
	 *
	 */
	public MailDAOImpl() {
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
	 * JPQL Query - findMailById
	 *
	 */
	@Transactional
	public Mail findMailById(Integer id) throws DataAccessException {

		return findMailById(id, -1, -1);
	}

	/**
	 * JPQL Query - findMailById
	 *
	 */

	@Transactional
	public Mail findMailById(Integer id, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findMailById", startResult, maxRows, id);
			return (com.nightwind.bbs.domain.Mail) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findMailByPrimaryKey
	 *
	 */
	@Transactional
	public Mail findMailByPrimaryKey(Integer id) throws DataAccessException {

		return findMailByPrimaryKey(id, -1, -1);
	}

	/**
	 * JPQL Query - findMailByPrimaryKey
	 *
	 */

	@Transactional
	public Mail findMailByPrimaryKey(Integer id, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findMailByPrimaryKey", startResult, maxRows, id);
			return (com.nightwind.bbs.domain.Mail) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findMailByTitle
	 *
	 */
	@Transactional
	public Set<Mail> findMailByTitle(String title) throws DataAccessException {

		return findMailByTitle(title, -1, -1);
	}

	/**
	 * JPQL Query - findMailByTitle
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Mail> findMailByTitle(String title, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findMailByTitle", startResult, maxRows, title);
		return new LinkedHashSet<Mail>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllMails
	 *
	 */
	@Transactional
	public Set<Mail> findAllMails() throws DataAccessException {

		return findAllMails(-1, -1);
	}

	/**
	 * JPQL Query - findAllMails
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Mail> findAllMails(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllMails", startResult, maxRows);
		return new LinkedHashSet<Mail>(query.getResultList());
	}

	/**
	 * JPQL Query - findMailBySendTime
	 *
	 */
	@Transactional
	public Set<Mail> findMailBySendTime(java.util.Calendar sendTime) throws DataAccessException {

		return findMailBySendTime(sendTime, -1, -1);
	}

	/**
	 * JPQL Query - findMailBySendTime
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Mail> findMailBySendTime(java.util.Calendar sendTime, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findMailBySendTime", startResult, maxRows, sendTime);
		return new LinkedHashSet<Mail>(query.getResultList());
	}

	/**
	 * JPQL Query - findMailByRead
	 *
	 */
	@Transactional
	public Set<Mail> findMailByRead(Boolean read) throws DataAccessException {

		return findMailByRead(read, -1, -1);
	}

	/**
	 * JPQL Query - findMailByRead
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Mail> findMailByRead(Boolean read, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findMailByRead", startResult, maxRows, read);
		return new LinkedHashSet<Mail>(query.getResultList());
	}

	/**
	 * JPQL Query - findMailByTitleContaining
	 *
	 */
	@Transactional
	public Set<Mail> findMailByTitleContaining(String title) throws DataAccessException {

		return findMailByTitleContaining(title, -1, -1);
	}

	/**
	 * JPQL Query - findMailByTitleContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Mail> findMailByTitleContaining(String title, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findMailByTitleContaining", startResult, maxRows, title);
		return new LinkedHashSet<Mail>(query.getResultList());
	}

	/**
	 * JPQL Query - findMailByContent
	 *
	 */
	@Transactional
	public Set<Mail> findMailByContent(String content) throws DataAccessException {

		return findMailByContent(content, -1, -1);
	}

	/**
	 * JPQL Query - findMailByContent
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Mail> findMailByContent(String content, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findMailByContent", startResult, maxRows, content);
		return new LinkedHashSet<Mail>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(Mail entity) {
		return true;
	}
}
