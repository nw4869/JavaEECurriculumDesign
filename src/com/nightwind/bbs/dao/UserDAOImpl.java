package com.nightwind.bbs.dao;

import com.nightwind.bbs.domain.User;

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
 * DAO to manage User entities.
 * 
 */
@Repository("UserDAO")
@Transactional
public class UserDAOImpl extends AbstractJpaDao<User> implements UserDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { User.class }));

	/**
	 * EntityManager injected by Spring for persistence unit Mysql_bbs
	 *
	 */
	@PersistenceContext(unitName = "Mysql_bbs")
	private EntityManager entityManager;

	/**
	 * Instantiates a new UserDAOImpl
	 *
	 */
	public UserDAOImpl() {
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
	 * JPQL Query - findUserByAvatarContaining
	 *
	 */
	@Transactional
	public Set<User> findUserByAvatarContaining(String avatar) throws DataAccessException {

		return findUserByAvatarContaining(avatar, -1, -1);
	}

	/**
	 * JPQL Query - findUserByAvatarContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<User> findUserByAvatarContaining(String avatar, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUserByAvatarContaining", startResult, maxRows, avatar);
		return new LinkedHashSet<User>(query.getResultList());
	}

	/**
	 * JPQL Query - findUserById
	 *
	 */
	@Transactional
	public User findUserById(Integer id) throws DataAccessException {

		return findUserById(id, -1, -1);
	}

	/**
	 * JPQL Query - findUserById
	 *
	 */

	@Transactional
	public User findUserById(Integer id, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findUserById", startResult, maxRows, id);
			return (com.nightwind.bbs.domain.User) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findUserByPrimaryKey
	 *
	 */
	@Transactional
	public User findUserByPrimaryKey(Integer id) throws DataAccessException {

		return findUserByPrimaryKey(id, -1, -1);
	}

	/**
	 * JPQL Query - findUserByPrimaryKey
	 *
	 */

	@Transactional
	public User findUserByPrimaryKey(Integer id, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findUserByPrimaryKey", startResult, maxRows, id);
			return (com.nightwind.bbs.domain.User) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findUserByEnabled
	 *
	 */
	@Transactional
	public Set<User> findUserByEnabled(Boolean enabled) throws DataAccessException {

		return findUserByEnabled(enabled, -1, -1);
	}

	/**
	 * JPQL Query - findUserByEnabled
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<User> findUserByEnabled(Boolean enabled, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUserByEnabled", startResult, maxRows, enabled);
		return new LinkedHashSet<User>(query.getResultList());
	}

	/**
	 * JPQL Query - findUserByAvatar
	 *
	 */
	@Transactional
	public Set<User> findUserByAvatar(String avatar) throws DataAccessException {

		return findUserByAvatar(avatar, -1, -1);
	}

	/**
	 * JPQL Query - findUserByAvatar
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<User> findUserByAvatar(String avatar, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUserByAvatar", startResult, maxRows, avatar);
		return new LinkedHashSet<User>(query.getResultList());
	}

	/**
	 * JPQL Query - findUserBySignature
	 *
	 */
	@Transactional
	public Set<User> findUserBySignature(String signature) throws DataAccessException {

		return findUserBySignature(signature, -1, -1);
	}

	/**
	 * JPQL Query - findUserBySignature
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<User> findUserBySignature(String signature, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUserBySignature", startResult, maxRows, signature);
		return new LinkedHashSet<User>(query.getResultList());
	}

	/**
	 * JPQL Query - findUserByUsername
	 *
	 */
	@Transactional
	public Set<User> findUserByUsername(String username) throws DataAccessException {

		return findUserByUsername(username, -1, -1);
	}

	/**
	 * JPQL Query - findUserByUsername
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<User> findUserByUsername(String username, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUserByUsername", startResult, maxRows, username);
		return new LinkedHashSet<User>(query.getResultList());
	}

	/**
	 * JPQL Query - findUserByCreateTime
	 *
	 */
	@Transactional
	public Set<User> findUserByCreateTime(java.util.Calendar createTime) throws DataAccessException {

		return findUserByCreateTime(createTime, -1, -1);
	}

	/**
	 * JPQL Query - findUserByCreateTime
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<User> findUserByCreateTime(java.util.Calendar createTime, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUserByCreateTime", startResult, maxRows, createTime);
		return new LinkedHashSet<User>(query.getResultList());
	}

	/**
	 * JPQL Query - findUserByPassword
	 *
	 */
	@Transactional
	public Set<User> findUserByPassword(String password) throws DataAccessException {

		return findUserByPassword(password, -1, -1);
	}

	/**
	 * JPQL Query - findUserByPassword
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<User> findUserByPassword(String password, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUserByPassword", startResult, maxRows, password);
		return new LinkedHashSet<User>(query.getResultList());
	}

	/**
	 * JPQL Query - findUserByEmailContaining
	 *
	 */
	@Transactional
	public Set<User> findUserByEmailContaining(String email) throws DataAccessException {

		return findUserByEmailContaining(email, -1, -1);
	}

	/**
	 * JPQL Query - findUserByEmailContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<User> findUserByEmailContaining(String email, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUserByEmailContaining", startResult, maxRows, email);
		return new LinkedHashSet<User>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllUsers
	 *
	 */
	@Transactional
	public Set<User> findAllUsers() throws DataAccessException {

		return findAllUsers(-1, -1);
	}

	/**
	 * JPQL Query - findAllUsers
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<User> findAllUsers(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllUsers", startResult, maxRows);
		return new LinkedHashSet<User>(query.getResultList());
	}

	/**
	 * JPQL Query - findUserByEmail
	 *
	 */
	@Transactional
	public Set<User> findUserByEmail(String email) throws DataAccessException {

		return findUserByEmail(email, -1, -1);
	}

	/**
	 * JPQL Query - findUserByEmail
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<User> findUserByEmail(String email, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUserByEmail", startResult, maxRows, email);
		return new LinkedHashSet<User>(query.getResultList());
	}

	/**
	 * JPQL Query - findUserByMemberTitleContaining
	 *
	 */
	@Transactional
	public Set<User> findUserByMemberTitleContaining(String memberTitle) throws DataAccessException {

		return findUserByMemberTitleContaining(memberTitle, -1, -1);
	}

	/**
	 * JPQL Query - findUserByMemberTitleContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<User> findUserByMemberTitleContaining(String memberTitle, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUserByMemberTitleContaining", startResult, maxRows, memberTitle);
		return new LinkedHashSet<User>(query.getResultList());
	}

	/**
	 * JPQL Query - findUserByMemberTitle
	 *
	 */
	@Transactional
	public Set<User> findUserByMemberTitle(String memberTitle) throws DataAccessException {

		return findUserByMemberTitle(memberTitle, -1, -1);
	}

	/**
	 * JPQL Query - findUserByMemberTitle
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<User> findUserByMemberTitle(String memberTitle, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUserByMemberTitle", startResult, maxRows, memberTitle);
		return new LinkedHashSet<User>(query.getResultList());
	}

	/**
	 * JPQL Query - findUserByPasswordContaining
	 *
	 */
	@Transactional
	public Set<User> findUserByPasswordContaining(String password) throws DataAccessException {

		return findUserByPasswordContaining(password, -1, -1);
	}

	/**
	 * JPQL Query - findUserByPasswordContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<User> findUserByPasswordContaining(String password, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUserByPasswordContaining", startResult, maxRows, password);
		return new LinkedHashSet<User>(query.getResultList());
	}

	/**
	 * JPQL Query - findUserBySignatureContaining
	 *
	 */
	@Transactional
	public Set<User> findUserBySignatureContaining(String signature) throws DataAccessException {

		return findUserBySignatureContaining(signature, -1, -1);
	}

	/**
	 * JPQL Query - findUserBySignatureContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<User> findUserBySignatureContaining(String signature, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUserBySignatureContaining", startResult, maxRows, signature);
		return new LinkedHashSet<User>(query.getResultList());
	}

	/**
	 * JPQL Query - findUserByUsernameContaining
	 *
	 */
	@Transactional
	public Set<User> findUserByUsernameContaining(String username) throws DataAccessException {

		return findUserByUsernameContaining(username, -1, -1);
	}

	/**
	 * JPQL Query - findUserByUsernameContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<User> findUserByUsernameContaining(String username, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUserByUsernameContaining", startResult, maxRows, username);
		return new LinkedHashSet<User>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(User entity) {
		return true;
	}
}
