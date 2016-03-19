package com.nightwind.bbs.service;

import com.nightwind.bbs.dao.AuthorityDAO;
import com.nightwind.bbs.dao.UserDAO;

import com.nightwind.bbs.domain.Authority;
import com.nightwind.bbs.domain.User;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

/**
 * Spring service that handles CRUD requests for Authority entities
 * 
 * @ModelCoreReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/AuthorityService/.properties.srv]
 * @generated
 */

@Service("AuthorityService")
@Transactional
public class AuthorityServiceImpl implements AuthorityService {

	/**
	 * DAO injected by Spring that manages Authority entities
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/AuthorityService/.properties.srv#//@variables%5Bname='authorityDAO'%5D]
	 */
	@Autowired
	private AuthorityDAO authorityDAO;

	/**
	 * DAO injected by Spring that manages User entities
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/AuthorityService/.properties.srv#//@variables%5Bname='userDAO'%5D]
	 */
	@Autowired
	private UserDAO userDAO;

	/**
	 * Instantiates a new AuthorityServiceImpl.
	 *
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/AuthorityService/.properties.srv]
	 * @AuxiliaryModelComponent
	 */
	public AuthorityServiceImpl() {
	}

	/**
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/AuthorityService/findAuthorityByPrimaryKey%7B3cdc7a3c-2ef7-41df-bdeb-dc1294e9b781%7D/.properties.swoperation]
	 */
	@Transactional
	public Authority findAuthorityByPrimaryKey(Integer userId, String authorityField) {
		return authorityDAO.findAuthorityByPrimaryKey(userId, authorityField);
	}

	/**
	 * Save an existing Authority entity
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/AuthorityService/saveAuthority%7Bbeac6dbc-4246-4f95-9420-a49ebafe9f7d%7D/.properties.swoperation]
	 */
	@Transactional
	public void saveAuthority(Authority authority) {
		Authority existingAuthority = authorityDAO.findAuthorityByPrimaryKey(authority.getUserId(), authority.getAuthorityField());

		if (existingAuthority != null) {
			if (existingAuthority != authority) {
				existingAuthority.setUserId(authority.getUserId());
				existingAuthority.setAuthorityField(authority.getAuthorityField());
			}
			authority = authorityDAO.store(existingAuthority);
		} else {
			authority = authorityDAO.store(authority);
		}
		authorityDAO.flush();
	}

	/**
	 * Load an existing Authority entity
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/AuthorityService/loadAuthoritys%7Bfbb24ded-ccfe-4b29-826a-8c67f30dfb8a%7D/.properties.swoperation]
	 */
	@Transactional
	public Set<Authority> loadAuthoritys() {
		return authorityDAO.findAllAuthoritys();
	}

	/**
	 * Delete an existing User entity
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/AuthorityService/deleteAuthorityUser%7B21c3c3d4-113a-43cb-8ab2-5ff074b9a40b%7D/.properties.swoperation]
	 */
	@Transactional
	public Authority deleteAuthorityUser(Integer authority_userId, String authority_authorityField, Integer related_user_id) {
		Authority authority = authorityDAO.findAuthorityByPrimaryKey(authority_userId, authority_authorityField, -1, -1);
		User related_user = userDAO.findUserByPrimaryKey(related_user_id, -1, -1);

		authority.setUser(null);
		related_user.getAuthorities().remove(authority);
		authority = authorityDAO.store(authority);
		authorityDAO.flush();

		related_user = userDAO.store(related_user);
		userDAO.flush();

		userDAO.remove(related_user);
		userDAO.flush();

		return authority;
	}

	/**
	 * Delete an existing Authority entity
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/AuthorityService/deleteAuthority%7B9768804b-882c-418e-aff4-01404bad0de5%7D/.properties.swoperation]
	 */
	@Transactional
	public void deleteAuthority(Authority authority) {
		authorityDAO.remove(authority);
		authorityDAO.flush();
	}

	/**
	 * Save an existing User entity
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/AuthorityService/saveAuthorityUser%7B7c422403-a0a2-4eb5-9461-e92afb3694ce%7D/.properties.swoperation]
	 */
	@Transactional
	public Authority saveAuthorityUser(Integer userId, String authorityField, User related_user) {
		Authority authority = authorityDAO.findAuthorityByPrimaryKey(userId, authorityField, -1, -1);
		User existinguser = userDAO.findUserByPrimaryKey(related_user.getId());

		// copy into the existing record to preserve existing relationships
		if (existinguser != null) {
			existinguser.setId(related_user.getId());
			existinguser.setUsername(related_user.getUsername());
			existinguser.setPassword(related_user.getPassword());
			existinguser.setEmail(related_user.getEmail());
			existinguser.setAvatar(related_user.getAvatar());
			existinguser.setMemberTitle(related_user.getMemberTitle());
			existinguser.setSignature(related_user.getSignature());
			existinguser.setEnabled(related_user.getEnabled());
			existinguser.setCreateTime(related_user.getCreateTime());
			related_user = existinguser;
		}

		authority.setUser(related_user);
		related_user.getAuthorities().add(authority);
		authority = authorityDAO.store(authority);
		authorityDAO.flush();

		related_user = userDAO.store(related_user);
		userDAO.flush();

		return authority;
	}

	/**
	 * Return a count of all Authority entity
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/AuthorityService/countAuthoritys%7B797a8836-80ad-43ba-ae1a-5ee68266edce%7D/.properties.swoperation]
	 */
	@Transactional
	public Integer countAuthoritys() {
		return ((Long) authorityDAO.createQuerySingleResult("select count(*) from Authority o").getSingleResult()).intValue();
	}

	/**
	 * Return all Authority entity
	 * 
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/AuthorityService/findAllAuthoritys%7B57877d24-68a2-4881-96d8-d4a253be9e68%7D/.properties.swoperation]
	 */
	@Transactional
	public List<Authority> findAllAuthoritys(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<Authority>(authorityDAO.findAllAuthoritys(startResult, maxRows));
	}
}
