package com.nightwind.bbs.dao;

import com.nightwind.bbs.domain.User;

import java.util.Calendar;
import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

/**
 * DAO to manage User entities.
 * 
 * 
 * @generated
 * @AuxiliaryModelComponent
 */
public interface UserDAO extends JpaDao<User> {

	/**
	 * JPQL Query - findUserByMemberTitleContaining
	 *
	 * JPASelect
	 */
	public Set<User> findUserByMemberTitleContaining(String memberTitle_1) throws DataAccessException;

	/**
	 * JPQL Query - findUserByMemberTitleContaining
	 *
	 * JPASelectWithPagination
	 */
	public Set<User> findUserByMemberTitleContaining(String memberTitle_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserByUsernameContaining
	 *
	 * JPASelect
	 */
	public Set<User> findUserByUsernameContaining(String username_1) throws DataAccessException;

	/**
	 * JPQL Query - findUserByUsernameContaining
	 *
	 * JPASelectWithPagination
	 */
	public Set<User> findUserByUsernameContaining(String username_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserByPassword
	 *
	 * JPASelect
	 */
	public Set<User> findUserByPassword(String password_1) throws DataAccessException;

	/**
	 * JPQL Query - findUserByPassword
	 *
	 * JPASelectWithPagination
	 */
	public Set<User> findUserByPassword(String password_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserBySignatureContaining
	 *
	 * JPASelect
	 */
	public Set<User> findUserBySignatureContaining(String signature_1) throws DataAccessException;

	/**
	 * JPQL Query - findUserBySignatureContaining
	 *
	 * JPASelectWithPagination
	 */
	public Set<User> findUserBySignatureContaining(String signature_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserByCreateTime
	 *
	 * JPASelect
	 */
	public Set<User> findUserByCreateTime(java.util.Calendar createTime) throws DataAccessException;

	/**
	 * JPQL Query - findUserByCreateTime
	 *
	 * JPASelectWithPagination
	 */
	public Set<User> findUserByCreateTime(Calendar createTime, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserByAvatarContaining
	 *
	 * JPASelect
	 */
	public Set<User> findUserByAvatarContaining(String avatar_1) throws DataAccessException;

	/**
	 * JPQL Query - findUserByAvatarContaining
	 *
	 * JPASelectWithPagination
	 */
	public Set<User> findUserByAvatarContaining(String avatar_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserByUsername
	 *
	 * JPASelect
	 */
	public Set<User> findUserByUsername(String username) throws DataAccessException;

	/**
	 * JPQL Query - findUserByUsername
	 *
	 * JPASelectWithPagination
	 */
	public Set<User> findUserByUsername(String username, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserByPrimaryKey
	 *
	 * JPASelect
	 */
	public User findUserByPrimaryKey(Integer id) throws DataAccessException;

	/**
	 * JPQL Query - findUserByPrimaryKey
	 *
	 * JPASelectWithPagination
	 */
	public User findUserByPrimaryKey(Integer id, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserById
	 *
	 * JPASelect
	 */
	public User findUserById(Integer id_1) throws DataAccessException;

	/**
	 * JPQL Query - findUserById
	 *
	 * JPASelectWithPagination
	 */
	public User findUserById(Integer id_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserByEnabled
	 *
	 * JPASelect
	 */
	public Set<User> findUserByEnabled(Boolean enabled) throws DataAccessException;

	/**
	 * JPQL Query - findUserByEnabled
	 *
	 * JPASelectWithPagination
	 */
	public Set<User> findUserByEnabled(Boolean enabled, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserByAvatar
	 *
	 * JPASelect
	 */
	public Set<User> findUserByAvatar(String avatar) throws DataAccessException;

	/**
	 * JPQL Query - findUserByAvatar
	 *
	 * JPASelectWithPagination
	 */
	public Set<User> findUserByAvatar(String avatar, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllUsers
	 *
	 * JPASelect
	 */
	public Set<User> findAllUsers() throws DataAccessException;

	/**
	 * JPQL Query - findAllUsers
	 *
	 * JPASelectWithPagination
	 */
	public Set<User> findAllUsers(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserByEmailContaining
	 *
	 * JPASelect
	 */
	public Set<User> findUserByEmailContaining(String email_1) throws DataAccessException;

	/**
	 * JPQL Query - findUserByEmailContaining
	 *
	 * JPASelectWithPagination
	 */
	public Set<User> findUserByEmailContaining(String email_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserByEmail
	 *
	 * JPASelect
	 */
	public Set<User> findUserByEmail(String email) throws DataAccessException;

	/**
	 * JPQL Query - findUserByEmail
	 *
	 * JPASelectWithPagination
	 */
	public Set<User> findUserByEmail(String email, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserByMemberTitle
	 *
	 * JPASelect
	 */
	public Set<User> findUserByMemberTitle(String memberTitle) throws DataAccessException;

	/**
	 * JPQL Query - findUserByMemberTitle
	 *
	 * JPASelectWithPagination
	 */
	public Set<User> findUserByMemberTitle(String memberTitle, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserBySignature
	 *
	 * JPASelect
	 */
	public Set<User> findUserBySignature(String signature) throws DataAccessException;

	/**
	 * JPQL Query - findUserBySignature
	 *
	 * JPASelectWithPagination
	 */
	public Set<User> findUserBySignature(String signature, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserByPasswordContaining
	 *
	 * JPASelect
	 */
	public Set<User> findUserByPasswordContaining(String password) throws DataAccessException;

	/**
	 * JPQL Query - findUserByPasswordContaining
	 *
	 * JPASelectWithPagination
	 */
	public Set<User> findUserByPasswordContaining(String password, int startResult, int maxRows) throws DataAccessException;

}