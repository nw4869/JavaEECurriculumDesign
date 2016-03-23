package com.nightwind.bbs.dao;

import com.nightwind.bbs.domain.Authority;

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
 * DAO to manage Authority entities.
 * 
 */
@Repository("AuthorityDAO")
@Transactional
public class AuthorityDAOImpl extends AbstractJpaDao<Authority> implements
		AuthorityDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { Authority.class }));

	/**
	 * EntityManager injected by Spring for persistence unit Mysql_bbs
	 *
	 */
	@PersistenceContext(unitName = "Mysql_bbs")
	private EntityManager entityManager;

	/**
	 * Instantiates a new AuthorityDAOImpl
	 *
	 */
	public AuthorityDAOImpl() {
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
	 * JPQL Query - findAuthorityByAuthorityFieldContaining
	 *
	 */
	@Transactional
	public Set<Authority> findAuthorityByAuthorityFieldContaining(String authorityField) throws DataAccessException {

		return findAuthorityByAuthorityFieldContaining(authorityField, -1, -1);
	}

	/**
	 * JPQL Query - findAuthorityByAuthorityFieldContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Authority> findAuthorityByAuthorityFieldContaining(String authorityField, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAuthorityByAuthorityFieldContaining", startResult, maxRows, authorityField);
		return new LinkedHashSet<Authority>(query.getResultList());
	}

	/**
	 * JPQL Query - findAuthorityByAuthorityField
	 *
	 */
	@Transactional
	public Set<Authority> findAuthorityByAuthorityField(String authorityField) throws DataAccessException {

		return findAuthorityByAuthorityField(authorityField, -1, -1);
	}

	/**
	 * JPQL Query - findAuthorityByAuthorityField
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Authority> findAuthorityByAuthorityField(String authorityField, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAuthorityByAuthorityField", startResult, maxRows, authorityField);
		return new LinkedHashSet<Authority>(query.getResultList());
	}

	/**
	 * JPQL Query - findAuthorityByPrimaryKey
	 *
	 */
	@Transactional
	public Authority findAuthorityByPrimaryKey(Integer userId, String authorityField) throws DataAccessException {

		return findAuthorityByPrimaryKey(userId, authorityField, -1, -1);
	}

	/**
	 * JPQL Query - findAuthorityByPrimaryKey
	 *
	 */

	@Transactional
	public Authority findAuthorityByPrimaryKey(Integer userId, String authorityField, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findAuthorityByPrimaryKey", startResult, maxRows, userId, authorityField);
			return (com.nightwind.bbs.domain.Authority) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findAllAuthoritys
	 *
	 */
	@Transactional
	public Set<Authority> findAllAuthoritys() throws DataAccessException {

		return findAllAuthoritys(-1, -1);
	}

	/**
	 * JPQL Query - findAllAuthoritys
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Authority> findAllAuthoritys(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllAuthoritys", startResult, maxRows);
		return new LinkedHashSet<Authority>(query.getResultList());
	}

	/**
	 * JPQL Query - findAuthorityByUserId
	 *
	 */
	@Transactional
	public Set<Authority> findAuthorityByUserId(Integer userId) throws DataAccessException {

		return findAuthorityByUserId(userId, -1, -1);
	}

	/**
	 * JPQL Query - findAuthorityByUserId
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Authority> findAuthorityByUserId(Integer userId, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAuthorityByUserId", startResult, maxRows, userId);
		return new LinkedHashSet<Authority>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(Authority entity) {
		return true;
	}
}
