package com.nightwind.bbs.dao;

import com.nightwind.bbs.domain.User;

import java.util.Calendar;
import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

/**
 * DAO to manage User entities.
 * 
 */
public interface UserDAO extends JpaDao<User> {

	/**
	 * JPQL Query - findUserByAvatarContaining
	 *
	 */
	public Set<User> findUserByAvatarContaining(String avatar) throws DataAccessException;

	/**
	 * JPQL Query - findUserByAvatarContaining
	 *
	 */
	public Set<User> findUserByAvatarContaining(String avatar, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserById
	 *
	 */
	public User findUserById(Integer id) throws DataAccessException;

	/**
	 * JPQL Query - findUserById
	 *
	 */
	public User findUserById(Integer id, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserByPrimaryKey
	 *
	 */
	public User findUserByPrimaryKey(Integer id_1) throws DataAccessException;

	/**
	 * JPQL Query - findUserByPrimaryKey
	 *
	 */
	public User findUserByPrimaryKey(Integer id_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserByEnabled
	 *
	 */
	public Set<User> findUserByEnabled(Boolean enabled) throws DataAccessException;

	/**
	 * JPQL Query - findUserByEnabled
	 *
	 */
	public Set<User> findUserByEnabled(Boolean enabled, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserByAvatar
	 *
	 */
	public Set<User> findUserByAvatar(String avatar_1) throws DataAccessException;

	/**
	 * JPQL Query - findUserByAvatar
	 *
	 */
	public Set<User> findUserByAvatar(String avatar_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserBySignature
	 *
	 */
	public Set<User> findUserBySignature(String signature) throws DataAccessException;

	/**
	 * JPQL Query - findUserBySignature
	 *
	 */
	public Set<User> findUserBySignature(String signature, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserByUsername
	 *
	 */
	public Set<User> findUserByUsername(String username) throws DataAccessException;

	/**
	 * JPQL Query - findUserByUsername
	 *
	 */
	public Set<User> findUserByUsername(String username, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserByCreateTime
	 *
	 */
	public Set<User> findUserByCreateTime(java.util.Calendar createTime) throws DataAccessException;

	/**
	 * JPQL Query - findUserByCreateTime
	 *
	 */
	public Set<User> findUserByCreateTime(Calendar createTime, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserByPassword
	 *
	 */
	public Set<User> findUserByPassword(String password) throws DataAccessException;

	/**
	 * JPQL Query - findUserByPassword
	 *
	 */
	public Set<User> findUserByPassword(String password, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserByEmailContaining
	 *
	 */
	public Set<User> findUserByEmailContaining(String email) throws DataAccessException;

	/**
	 * JPQL Query - findUserByEmailContaining
	 *
	 */
	public Set<User> findUserByEmailContaining(String email, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllUsers
	 *
	 */
	public Set<User> findAllUsers() throws DataAccessException;

	/**
	 * JPQL Query - findAllUsers
	 *
	 */
	public Set<User> findAllUsers(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserByEmail
	 *
	 */
	public Set<User> findUserByEmail(String email_1) throws DataAccessException;

	/**
	 * JPQL Query - findUserByEmail
	 *
	 */
	public Set<User> findUserByEmail(String email_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserByMemberTitleContaining
	 *
	 */
	public Set<User> findUserByMemberTitleContaining(String memberTitle) throws DataAccessException;

	/**
	 * JPQL Query - findUserByMemberTitleContaining
	 *
	 */
	public Set<User> findUserByMemberTitleContaining(String memberTitle, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserByMemberTitle
	 *
	 */
	public Set<User> findUserByMemberTitle(String memberTitle_1) throws DataAccessException;

	/**
	 * JPQL Query - findUserByMemberTitle
	 *
	 */
	public Set<User> findUserByMemberTitle(String memberTitle_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserByPasswordContaining
	 *
	 */
	public Set<User> findUserByPasswordContaining(String password_1) throws DataAccessException;

	/**
	 * JPQL Query - findUserByPasswordContaining
	 *
	 */
	public Set<User> findUserByPasswordContaining(String password_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserBySignatureContaining
	 *
	 */
	public Set<User> findUserBySignatureContaining(String signature_1) throws DataAccessException;

	/**
	 * JPQL Query - findUserBySignatureContaining
	 *
	 */
	public Set<User> findUserBySignatureContaining(String signature_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserByUsernameContaining
	 *
	 */
	public Set<User> findUserByUsernameContaining(String username_1) throws DataAccessException;

	/**
	 * JPQL Query - findUserByUsernameContaining
	 *
	 */
	public Set<User> findUserByUsernameContaining(String username_1, int startResult, int maxRows) throws DataAccessException;

}