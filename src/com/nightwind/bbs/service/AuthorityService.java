package com.nightwind.bbs.service;

import com.nightwind.bbs.domain.Authority;
import com.nightwind.bbs.domain.User;

import java.util.List;
import java.util.Set;

/**
 * Spring service that handles CRUD requests for Authority entities
 * 
 * 
 * @generated
 * @AuxiliaryModelComponent
 */
public interface AuthorityService {

	/**
	 * 
	 */
	public Authority findAuthorityByPrimaryKey(Integer userId, String authorityField);

	/**
	 * Save an existing Authority entity
	 * 
	 * 
	 */
	public void saveAuthority(Authority authority);

	/**
	 * Load an existing Authority entity
	 * 
	 * 
	 */
	public Set<Authority> loadAuthoritys();

	/**
	 * Delete an existing User entity
	 * 
	 * 
	 */
	public Authority deleteAuthorityUser(Integer authority_userId, String authority_authorityField, Integer related_user_id);

	/**
	 * Delete an existing Authority entity
	 * 
	 * 
	 */
	public void deleteAuthority(Authority authority_1);

	/**
	 * Save an existing User entity
	 * 
	 * 
	 */
	public Authority saveAuthorityUser(Integer userId_1, String authorityField_1, User related_user);

	/**
	 * Return a count of all Authority entity
	 * 
	 * 
	 */
	public Integer countAuthoritys();

	/**
	 * Return all Authority entity
	 * 
	 * 
	 */
	public List<Authority> findAllAuthoritys(Integer startResult, Integer maxRows);
}