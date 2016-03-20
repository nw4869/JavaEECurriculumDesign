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
 * 
 * @generated
 */
@Repository("UserDAO")
@Transactional
public class UserDAOImpl extends AbstractJpaDao<User> implements UserDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 * @generated
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { User.class }));

	/**
	 * EntityManager injected by Spring for persistence unit MySql_bbs
	 *
	 * @generated
	 */
	@PersistenceContext(unitName = "MySql_bbs")
	private EntityManager entityManager;

	/**
	 * Instantiates a new UserDAOImpl
	 *
	 * @generated
	 */
	public UserDAOImpl() {
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
	 * JPQL Query - findUserByMemberTitleContaining
	 *
	 * JPASelect
	 */
	@Transactional
	public Set<User> findUserByMemberTitleContaining(String memberTitle) throws DataAccessException {

		return findUserByMemberTitleContaining(memberTitle, -1, -1);
	}

	/**
	 * JPQL Query - findUserByMemberTitleContaining
	 *
	 * JPASelectWithPagination
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<User> findUserByMemberTitleContaining(String memberTitle, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUserByMemberTitleContaining", startResult, maxRows, memberTitle);
		return new LinkedHashSet<User>(query.getResultList());
	}

	/**
	 * JPQL Query - findUserByUsernameContaining
	 *
	 * JPASelect
	 */
	@Transactional
	public Set<User> findUserByUsernameContaining(String username) throws DataAccessException {

		return findUserByUsernameContaining(username, -1, -1);
	}

	/**
	 * JPQL Query - findUserByUsernameContaining
	 *
	 * JPASelectWithPagination
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<User> findUserByUsernameContaining(String username, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUserByUsernameContaining", startResult, maxRows, username);
		return new LinkedHashSet<User>(query.getResultList());
	}

	/**
	 * JPQL Query - findUserByPassword
	 *
	 * JPASelect
	 */
	@Transactional
	public Set<User> findUserByPassword(String password) throws DataAccessException {

		return findUserByPassword(password, -1, -1);
	}

	/**
	 * JPQL Query - findUserByPassword
	 *
	 * JPASelectWithPagination
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<User> findUserByPassword(String password, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUserByPassword", startResult, maxRows, password);
		return new LinkedHashSet<User>(query.getResultList());
	}

	/**
	 * JPQL Query - findUserBySignatureContaining
	 *
	 * JPASelect
	 */
	@Transactional
	public Set<User> findUserBySignatureContaining(String signature) throws DataAccessException {

		return findUserBySignatureContaining(signature, -1, -1);
	}

	/**
	 * JPQL Query - findUserBySignatureContaining
	 *
	 * JPASelectWithPagination
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<User> findUserBySignatureContaining(String signature, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUserBySignatureContaining", startResult, maxRows, signature);
		return new LinkedHashSet<User>(query.getResultList());
	}

	/**
	 * JPQL Query - findUserByCreateTime
	 *
	 * JPASelect
	 */
	@Transactional
	public Set<User> findUserByCreateTime(java.util.Calendar createTime) throws DataAccessException {

		return findUserByCreateTime(createTime, -1, -1);
	}

	/**
	 * JPQL Query - findUserByCreateTime
	 *
	 * JPASelectWithPagination
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<User> findUserByCreateTime(java.util.Calendar createTime, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUserByCreateTime", startResult, maxRows, createTime);
		return new LinkedHashSet<User>(query.getResultList());
	}

	/**
	 * JPQL Query - findUserByAvatarContaining
	 *
	 * JPASelect
	 */
	@Transactional
	public Set<User> findUserByAvatarContaining(String avatar) throws DataAccessException {

		return findUserByAvatarContaining(avatar, -1, -1);
	}

	/**
	 * JPQL Query - findUserByAvatarContaining
	 *
	 * JPASelectWithPagination
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<User> findUserByAvatarContaining(String avatar, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUserByAvatarContaining", startResult, maxRows, avatar);
		return new LinkedHashSet<User>(query.getResultList());
	}

	/**
	 * JPQL Query - findUserByUsername
	 *
	 * JPASelect
	 */
	@Transactional
	public Set<User> findUserByUsername(String username) throws DataAccessException {

		return findUserByUsername(username, -1, -1);
	}

	/**
	 * JPQL Query - findUserByUsername
	 *
	 * JPASelectWithPagination
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<User> findUserByUsername(String username, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUserByUsername", startResult, maxRows, username);
		return new LinkedHashSet<User>(query.getResultList());
	}

	/**
	 * JPQL Query - findUserByPrimaryKey
	 *
	 * JPASelect
	 */
	@Transactional
	public User findUserByPrimaryKey(Integer id) throws DataAccessException {

		return findUserByPrimaryKey(id, -1, -1);
	}

	/**
	 * JPQL Query - findUserByPrimaryKey
	 *
	 * JPASelectWithPagination
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
	 * JPQL Query - findUserById
	 *
	 * JPASelect
	 */
	@Transactional
	public User findUserById(Integer id) throws DataAccessException {

		return findUserById(id, -1, -1);
	}

	/**
	 * JPQL Query - findUserById
	 *
	 * JPASelectWithPagination
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
	 * JPQL Query - findUserByEnabled
	 *
	 * JPASelect
	 */
	@Transactional
	public Set<User> findUserByEnabled(Boolean enabled) throws DataAccessException {

		return findUserByEnabled(enabled, -1, -1);
	}

	/**
	 * JPQL Query - findUserByEnabled
	 *
	 * JPASelectWithPagination
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
	 * JPASelect
	 */
	@Transactional
	public Set<User> findUserByAvatar(String avatar) throws DataAccessException {

		return findUserByAvatar(avatar, -1, -1);
	}

	/**
	 * JPQL Query - findUserByAvatar
	 *
	 * JPASelectWithPagination
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<User> findUserByAvatar(String avatar, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUserByAvatar", startResult, maxRows, avatar);
		return new LinkedHashSet<User>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllUsers
	 *
	 * JPASelect
	 */
	@Transactional
	public Set<User> findAllUsers() throws DataAccessException {

		return findAllUsers(-1, -1);
	}

	/**
	 * JPQL Query - findAllUsers
	 *
	 * JPASelectWithPagination
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<User> findAllUsers(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllUsers", startResult, maxRows);
		return new LinkedHashSet<User>(query.getResultList());
	}

	/**
	 * JPQL Query - findUserByEmailContaining
	 *
	 * JPASelect
	 */
	@Transactional
	public Set<User> findUserByEmailContaining(String email) throws DataAccessException {

		return findUserByEmailContaining(email, -1, -1);
	}

	/**
	 * JPQL Query - findUserByEmailContaining
	 *
	 * JPASelectWithPagination
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<User> findUserByEmailContaining(String email, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUserByEmailContaining", startResult, maxRows, email);
		return new LinkedHashSet<User>(query.getResultList());
	}

	/**
	 * JPQL Query - findUserByEmail
	 *
	 * JPASelect
	 */
	@Transactional
	public Set<User> findUserByEmail(String email) throws DataAccessException {

		return findUserByEmail(email, -1, -1);
	}

	/**
	 * JPQL Query - findUserByEmail
	 *
	 * JPASelectWithPagination
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<User> findUserByEmail(String email, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUserByEmail", startResult, maxRows, email);
		return new LinkedHashSet<User>(query.getResultList());
	}

	/**
	 * JPQL Query - findUserByMemberTitle
	 *
	 * JPASelect
	 */
	@Transactional
	public Set<User> findUserByMemberTitle(String memberTitle) throws DataAccessException {

		return findUserByMemberTitle(memberTitle, -1, -1);
	}

	/**
	 * JPQL Query - findUserByMemberTitle
	 *
	 * JPASelectWithPagination
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<User> findUserByMemberTitle(String memberTitle, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUserByMemberTitle", startResult, maxRows, memberTitle);
		return new LinkedHashSet<User>(query.getResultList());
	}

	/**
	 * JPQL Query - findUserBySignature
	 *
	 * JPASelect
	 */
	@Transactional
	public Set<User> findUserBySignature(String signature) throws DataAccessException {

		return findUserBySignature(signature, -1, -1);
	}

	/**
	 * JPQL Query - findUserBySignature
	 *
	 * JPASelectWithPagination
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<User> findUserBySignature(String signature, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUserBySignature", startResult, maxRows, signature);
		return new LinkedHashSet<User>(query.getResultList());
	}

	/**
	 * JPQL Query - findUserByPasswordContaining
	 *
	 * JPASelect
	 */
	@Transactional
	public Set<User> findUserByPasswordContaining(String password) throws DataAccessException {

		return findUserByPasswordContaining(password, -1, -1);
	}

	/**
	 * JPQL Query - findUserByPasswordContaining
	 *
	 * JPASelectWithPagination
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<User> findUserByPasswordContaining(String password, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUserByPasswordContaining", startResult, maxRows, password);
		return new LinkedHashSet<User>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 * @generated
	 */
	public boolean canBeMerged(User entity) {
		return true;
	}
}
