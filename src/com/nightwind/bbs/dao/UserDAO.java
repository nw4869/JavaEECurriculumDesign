package com.nightwind.bbs.dao;

import com.nightwind.bbs.domain.User;

import java.util.Calendar;
import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

/**
 * DAO to manage User entities.
 * 
 * @ModelCoreReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/UserDAO/.properties.datastore]
 * @generated
 * @AuxiliaryModelComponent
 */
public interface UserDAO extends JpaDao<User> {

	/**
	 * JPQL Query - findUserByMemberTitleContaining
	 *
	 * @ModelCoreReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/UserDAO/findUserByMemberTitleContaining.query]JPASelect
	 */
	public Set<User> findUserByMemberTitleContaining(String memberTitle_1) throws DataAccessException;

	/**
	 * JPQL Query - findUserByMemberTitleContaining
	 *
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/UserDAO/findUserByMemberTitleContaining.query]JPASelectWithPagination
	 */
	public Set<User> findUserByMemberTitleContaining(String memberTitle_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserByUsernameContaining
	 *
	 * @ModelCoreReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/UserDAO/findUserByUsernameContaining.query]JPASelect
	 */
	public Set<User> findUserByUsernameContaining(String username_1) throws DataAccessException;

	/**
	 * JPQL Query - findUserByUsernameContaining
	 *
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/UserDAO/findUserByUsernameContaining.query]JPASelectWithPagination
	 */
	public Set<User> findUserByUsernameContaining(String username_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserByPassword
	 *
	 * @ModelCoreReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/UserDAO/findUserByPassword.query]JPASelect
	 */
	public Set<User> findUserByPassword(String password) throws DataAccessException;

	/**
	 * JPQL Query - findUserByPassword
	 *
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/UserDAO/findUserByPassword.query]JPASelectWithPagination
	 */
	public Set<User> findUserByPassword(String password, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserBySignatureContaining
	 *
	 * @ModelCoreReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/UserDAO/findUserBySignatureContaining.query]JPASelect
	 */
	public Set<User> findUserBySignatureContaining(String signature_1) throws DataAccessException;

	/**
	 * JPQL Query - findUserBySignatureContaining
	 *
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/UserDAO/findUserBySignatureContaining.query]JPASelectWithPagination
	 */
	public Set<User> findUserBySignatureContaining(String signature_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserByCreateTime
	 *
	 * @ModelCoreReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/UserDAO/findUserByCreateTime.query]JPASelect
	 */
	public Set<User> findUserByCreateTime(java.util.Calendar createTime) throws DataAccessException;

	/**
	 * JPQL Query - findUserByCreateTime
	 *
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/UserDAO/findUserByCreateTime.query]JPASelectWithPagination
	 */
	public Set<User> findUserByCreateTime(Calendar createTime, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserByAvatarContaining
	 *
	 * @ModelCoreReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/UserDAO/findUserByAvatarContaining.query]JPASelect
	 */
	public Set<User> findUserByAvatarContaining(String avatar_1) throws DataAccessException;

	/**
	 * JPQL Query - findUserByAvatarContaining
	 *
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/UserDAO/findUserByAvatarContaining.query]JPASelectWithPagination
	 */
	public Set<User> findUserByAvatarContaining(String avatar_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserByUsername
	 *
	 * @ModelCoreReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/UserDAO/findUserByUsername.query]JPASelect
	 */
	public Set<User> findUserByUsername(String username) throws DataAccessException;

	/**
	 * JPQL Query - findUserByUsername
	 *
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/UserDAO/findUserByUsername.query]JPASelectWithPagination
	 */
	public Set<User> findUserByUsername(String username, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserByPrimaryKey
	 *
	 * @ModelCoreReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/UserDAO/findUserByPrimaryKey.query]JPASelect
	 */
	public User findUserByPrimaryKey(Integer id_1) throws DataAccessException;

	/**
	 * JPQL Query - findUserByPrimaryKey
	 *
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/UserDAO/findUserByPrimaryKey.query]JPASelectWithPagination
	 */
	public User findUserByPrimaryKey(Integer id_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserById
	 *
	 * @ModelCoreReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/UserDAO/findUserById.query]JPASelect
	 */
	public User findUserById(Integer id) throws DataAccessException;

	/**
	 * JPQL Query - findUserById
	 *
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/UserDAO/findUserById.query]JPASelectWithPagination
	 */
	public User findUserById(Integer id, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserByEnabled
	 *
	 * @ModelCoreReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/UserDAO/findUserByEnabled.query]JPASelect
	 */
	public Set<User> findUserByEnabled(Boolean enabled) throws DataAccessException;

	/**
	 * JPQL Query - findUserByEnabled
	 *
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/UserDAO/findUserByEnabled.query]JPASelectWithPagination
	 */
	public Set<User> findUserByEnabled(Boolean enabled, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserByAvatar
	 *
	 * @ModelCoreReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/UserDAO/findUserByAvatar.query]JPASelect
	 */
	public Set<User> findUserByAvatar(String avatar) throws DataAccessException;

	/**
	 * JPQL Query - findUserByAvatar
	 *
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/UserDAO/findUserByAvatar.query]JPASelectWithPagination
	 */
	public Set<User> findUserByAvatar(String avatar, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllUsers
	 *
	 * @ModelCoreReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/UserDAO/findAllUsers.query]JPASelect
	 */
	public Set<User> findAllUsers() throws DataAccessException;

	/**
	 * JPQL Query - findAllUsers
	 *
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/UserDAO/findAllUsers.query]JPASelectWithPagination
	 */
	public Set<User> findAllUsers(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserByEmailContaining
	 *
	 * @ModelCoreReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/UserDAO/findUserByEmailContaining.query]JPASelect
	 */
	public Set<User> findUserByEmailContaining(String email_1) throws DataAccessException;

	/**
	 * JPQL Query - findUserByEmailContaining
	 *
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/UserDAO/findUserByEmailContaining.query]JPASelectWithPagination
	 */
	public Set<User> findUserByEmailContaining(String email_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserByEmail
	 *
	 * @ModelCoreReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/UserDAO/findUserByEmail.query]JPASelect
	 */
	public Set<User> findUserByEmail(String email) throws DataAccessException;

	/**
	 * JPQL Query - findUserByEmail
	 *
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/UserDAO/findUserByEmail.query]JPASelectWithPagination
	 */
	public Set<User> findUserByEmail(String email, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserByMemberTitle
	 *
	 * @ModelCoreReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/UserDAO/findUserByMemberTitle.query]JPASelect
	 */
	public Set<User> findUserByMemberTitle(String memberTitle) throws DataAccessException;

	/**
	 * JPQL Query - findUserByMemberTitle
	 *
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/UserDAO/findUserByMemberTitle.query]JPASelectWithPagination
	 */
	public Set<User> findUserByMemberTitle(String memberTitle, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserBySignature
	 *
	 * @ModelCoreReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/UserDAO/findUserBySignature.query]JPASelect
	 */
	public Set<User> findUserBySignature(String signature) throws DataAccessException;

	/**
	 * JPQL Query - findUserBySignature
	 *
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/UserDAO/findUserBySignature.query]JPASelectWithPagination
	 */
	public Set<User> findUserBySignature(String signature, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserByPasswordContaining
	 *
	 * @ModelCoreReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/UserDAO/findUserByPasswordContaining.query]JPASelect
	 */
	public Set<User> findUserByPasswordContaining(String password_1) throws DataAccessException;

	/**
	 * JPQL Query - findUserByPasswordContaining
	 *
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/UserDAO/findUserByPasswordContaining.query]JPASelectWithPagination
	 */
	public Set<User> findUserByPasswordContaining(String password_1, int startResult, int maxRows) throws DataAccessException;

}