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
 * 
 * @generated
 */

@Service("AuthorityService")
@Transactional
public class AuthorityServiceImpl implements AuthorityService {

	/**
	 * DAO injected by Spring that manages Authority entities
	 * 
	 * 
	 */
	@Autowired
	private AuthorityDAO authorityDAO;

	/**
	 * DAO injected by Spring that manages User entities
	 * 
	 * 
	 */
	@Autowired
	private UserDAO userDAO;

	/**
	 * Instantiates a new AuthorityServiceImpl.
	 *
	 * 
	 * @AuxiliaryModelComponent
	 */
	public AuthorityServiceImpl() {
	}

	/**
	 * 
	 */
	@Transactional
	public Authority findAuthorityByPrimaryKey(Integer userId, String authorityField) {
		return authorityDAO.findAuthorityByPrimaryKey(userId, authorityField);
	}

	/**
	 * Save an existing Authority entity
	 * 
	 * 
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
	 * 
	 */
	@Transactional
	public Set<Authority> loadAuthoritys() {
		return authorityDAO.findAllAuthoritys();
	}

	/**
	 * Delete an existing User entity
	 * 
	 * 
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
	 * 
	 */
	@Transactional
	public void deleteAuthority(Authority authority) {
		authorityDAO.remove(authority);
		authorityDAO.flush();
	}

	/**
	 * Save an existing User entity
	 * 
	 * 
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
	 * 
	 */
	@Transactional
	public Integer countAuthoritys() {
		return ((Long) authorityDAO.createQuerySingleResult("select count(*) from Authority o").getSingleResult()).intValue();
	}

	/**
	 * Return all Authority entity
	 * 
	 * 
	 */
	@Transactional
	public List<Authority> findAllAuthoritys(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<Authority>(authorityDAO.findAllAuthoritys(startResult, maxRows));
	}
}
