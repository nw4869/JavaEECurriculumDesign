package com.nightwind.bbs.dao;

import com.nightwind.bbs.domain.Authority;

import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

/**
 * DAO to manage Authority entities.
 * 
 * 
 * @generated
 * @AuxiliaryModelComponent
 */
public interface AuthorityDAO extends JpaDao<Authority> {

	/**
	 * JPQL Query - findAuthorityByAuthorityFieldContaining
	 *
	 * JPASelect
	 */
	public Set<Authority> findAuthorityByAuthorityFieldContaining(String authorityField_2) throws DataAccessException;

	/**
	 * JPQL Query - findAuthorityByAuthorityFieldContaining
	 *
	 * JPASelectWithPagination
	 */
	public Set<Authority> findAuthorityByAuthorityFieldContaining(String authorityField_2, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAuthorityByPrimaryKey
	 *
	 * JPASelect
	 */
	public Authority findAuthorityByPrimaryKey(Integer userId, String authorityField_1) throws DataAccessException;

	/**
	 * JPQL Query - findAuthorityByPrimaryKey
	 *
	 * JPASelectWithPagination
	 */
	public Authority findAuthorityByPrimaryKey(Integer userId, String authorityField_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllAuthoritys
	 *
	 * JPASelect
	 */
	public Set<Authority> findAllAuthoritys() throws DataAccessException;

	/**
	 * JPQL Query - findAllAuthoritys
	 *
	 * JPASelectWithPagination
	 */
	public Set<Authority> findAllAuthoritys(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAuthorityByUserId
	 *
	 * JPASelect
	 */
	public Set<Authority> findAuthorityByUserId(Integer userId_1) throws DataAccessException;

	/**
	 * JPQL Query - findAuthorityByUserId
	 *
	 * JPASelectWithPagination
	 */
	public Set<Authority> findAuthorityByUserId(Integer userId_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAuthorityByAuthorityField
	 *
	 * JPASelect
	 */
	public Set<Authority> findAuthorityByAuthorityField(String authorityField) throws DataAccessException;

	/**
	 * JPQL Query - findAuthorityByAuthorityField
	 *
	 * JPASelectWithPagination
	 */
	public Set<Authority> findAuthorityByAuthorityField(String authorityField, int startResult, int maxRows) throws DataAccessException;

}