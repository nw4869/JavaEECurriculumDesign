package com.nightwind.bbs.dao;

import com.nightwind.bbs.domain.Authority;

import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

/**
 * DAO to manage Authority entities.
 * 
 * @ModelCoreReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/AuthorityDAO/.properties.datastore]
 * @generated
 * @AuxiliaryModelComponent
 */
public interface AuthorityDAO extends JpaDao<Authority> {

	/**
	 * JPQL Query - findAuthorityByAuthorityFieldContaining
	 *
	 * @ModelCoreReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/AuthorityDAO/findAuthorityByAuthorityFieldContaining.query]JPASelect
	 */
	public Set<Authority> findAuthorityByAuthorityFieldContaining(String authorityField_1) throws DataAccessException;

	/**
	 * JPQL Query - findAuthorityByAuthorityFieldContaining
	 *
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/AuthorityDAO/findAuthorityByAuthorityFieldContaining.query]JPASelectWithPagination
	 */
	public Set<Authority> findAuthorityByAuthorityFieldContaining(String authorityField_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAuthorityByPrimaryKey
	 *
	 * @ModelCoreReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/AuthorityDAO/findAuthorityByPrimaryKey.query]JPASelect
	 */
	public Authority findAuthorityByPrimaryKey(Integer userId, String authorityField_2) throws DataAccessException;

	/**
	 * JPQL Query - findAuthorityByPrimaryKey
	 *
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/AuthorityDAO/findAuthorityByPrimaryKey.query]JPASelectWithPagination
	 */
	public Authority findAuthorityByPrimaryKey(Integer userId, String authorityField_2, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllAuthoritys
	 *
	 * @ModelCoreReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/AuthorityDAO/findAllAuthoritys.query]JPASelect
	 */
	public Set<Authority> findAllAuthoritys() throws DataAccessException;

	/**
	 * JPQL Query - findAllAuthoritys
	 *
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/AuthorityDAO/findAllAuthoritys.query]JPASelectWithPagination
	 */
	public Set<Authority> findAllAuthoritys(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAuthorityByUserId
	 *
	 * @ModelCoreReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/AuthorityDAO/findAuthorityByUserId.query]JPASelect
	 */
	public Set<Authority> findAuthorityByUserId(Integer userId_1) throws DataAccessException;

	/**
	 * JPQL Query - findAuthorityByUserId
	 *
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/AuthorityDAO/findAuthorityByUserId.query]JPASelectWithPagination
	 */
	public Set<Authority> findAuthorityByUserId(Integer userId_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAuthorityByAuthorityField
	 *
	 * @ModelCoreReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/AuthorityDAO/findAuthorityByAuthorityField.query]JPASelect
	 */
	public Set<Authority> findAuthorityByAuthorityField(String authorityField) throws DataAccessException;

	/**
	 * JPQL Query - findAuthorityByAuthorityField
	 *
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/AuthorityDAO/findAuthorityByAuthorityField.query]JPASelectWithPagination
	 */
	public Set<Authority> findAuthorityByAuthorityField(String authorityField, int startResult, int maxRows) throws DataAccessException;

}