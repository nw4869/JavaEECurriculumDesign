package com.nightwind.bbs.service;

import com.nightwind.bbs.domain.Authority;
import com.nightwind.bbs.domain.User;

import java.util.List;
import java.util.Set;

/**
 * Spring service that handles CRUD requests for Authority entities
 * 
 * @ModelCoreReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/AuthorityService/.properties.srv]
 * @generated
 * @AuxiliaryModelComponent
 */
public interface AuthorityService {

	/**
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/AuthorityService/findAuthorityByPrimaryKey%7B3cdc7a3c-2ef7-41df-bdeb-dc1294e9b781%7D/.properties.swoperation]
	 */
	public Authority findAuthorityByPrimaryKey(Integer userId, String authorityField);

	/**
	 * Save an existing Authority entity
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/AuthorityService/saveAuthority%7Bbeac6dbc-4246-4f95-9420-a49ebafe9f7d%7D/.properties.swoperation]
	 */
	public void saveAuthority(Authority authority_1);

	/**
	 * Load an existing Authority entity
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/AuthorityService/loadAuthoritys%7Bfbb24ded-ccfe-4b29-826a-8c67f30dfb8a%7D/.properties.swoperation]
	 */
	public Set<Authority> loadAuthoritys();

	/**
	 * Delete an existing User entity
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/AuthorityService/deleteAuthorityUser%7B21c3c3d4-113a-43cb-8ab2-5ff074b9a40b%7D/.properties.swoperation]
	 */
	public Authority deleteAuthorityUser(Integer authority_userId, String authority_authorityField, Integer related_user_id);

	/**
	 * Delete an existing Authority entity
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/AuthorityService/deleteAuthority%7B9768804b-882c-418e-aff4-01404bad0de5%7D/.properties.swoperation]
	 */
	public void deleteAuthority(Authority authority);

	/**
	 * Save an existing User entity
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/AuthorityService/saveAuthorityUser%7B7c422403-a0a2-4eb5-9461-e92afb3694ce%7D/.properties.swoperation]
	 */
	public Authority saveAuthorityUser(Integer userId_1, String authorityField_1, User related_user);

	/**
	 * Return a count of all Authority entity
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/AuthorityService/countAuthoritys%7B797a8836-80ad-43ba-ae1a-5ee68266edce%7D/.properties.swoperation]
	 */
	public Integer countAuthoritys();

	/**
	 * Return all Authority entity
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/AuthorityService/findAllAuthoritys%7B57877d24-68a2-4881-96d8-d4a253be9e68%7D/.properties.swoperation]
	 */
	public List<Authority> findAllAuthoritys(Integer startResult, Integer maxRows);
}