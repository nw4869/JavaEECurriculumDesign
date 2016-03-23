package com.nightwind.bbs.dao;

import com.nightwind.bbs.domain.Authority;

import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

/**
 * DAO to manage Authority entities.
 * 
 */
public interface AuthorityDAO extends JpaDao<Authority> {

	/**
	 * JPQL Query - findAuthorityByAuthorityFieldContaining
	 *
	 */
	public Set<Authority> findAuthorityByAuthorityFieldContaining(String authorityField) throws DataAccessException;

	/**
	 * JPQL Query - findAuthorityByAuthorityFieldContaining
	 *
	 */
	public Set<Authority> findAuthorityByAuthorityFieldContaining(String authorityField, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAuthorityByAuthorityField
	 *
	 */
	public Set<Authority> findAuthorityByAuthorityField(String authorityField_1) throws DataAccessException;

	/**
	 * JPQL Query - findAuthorityByAuthorityField
	 *
	 */
	public Set<Authority> findAuthorityByAuthorityField(String authorityField_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAuthorityByPrimaryKey
	 *
	 */
	public Authority findAuthorityByPrimaryKey(Integer userId, String authorityField_2) throws DataAccessException;

	/**
	 * JPQL Query - findAuthorityByPrimaryKey
	 *
	 */
	public Authority findAuthorityByPrimaryKey(Integer userId, String authorityField_2, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllAuthoritys
	 *
	 */
	public Set<Authority> findAllAuthoritys() throws DataAccessException;

	/**
	 * JPQL Query - findAllAuthoritys
	 *
	 */
	public Set<Authority> findAllAuthoritys(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAuthorityByUserId
	 *
	 */
	public Set<Authority> findAuthorityByUserId(Integer userId_1) throws DataAccessException;

	/**
	 * JPQL Query - findAuthorityByUserId
	 *
	 */
	public Set<Authority> findAuthorityByUserId(Integer userId_1, int startResult, int maxRows) throws DataAccessException;

}