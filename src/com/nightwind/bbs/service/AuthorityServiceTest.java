package com.nightwind.bbs.service;

import com.nightwind.bbs.domain.Authority;
import com.nightwind.bbs.domain.User;

import java.util.List;
import java.util.Set;

import org.junit.Test;

import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;

import org.springframework.context.ApplicationContext;

import org.springframework.mock.web.MockHttpServletRequest;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;

import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.RequestScope;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.SessionScope;

/**
 * Class to run the service as a JUnit test. Each operation in the service is a separate test.
 *
 * @generated
 * @AuxiliaryModelComponent
 */

@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({
		DependencyInjectionTestExecutionListener.class,
		DirtiesContextTestExecutionListener.class,
		TransactionalTestExecutionListener.class })
@ContextConfiguration(locations = {
		"file:./src/bbs-security-context.xml",
		"file:./src/bbs-service-context.xml",
		"file:./src/bbs-dao-context.xml",
		"file:./src/bbs-web-context.xml" })
@Transactional
public class AuthorityServiceTest {

	/**
	 * The Spring application context.
	 *
	 * @generated
	 */
	@SuppressWarnings("unused")
	private ApplicationContext context;

	/**
	 * The service being tested, injected by Spring.
	 *
	 * @generated
	 */
	@Autowired
	protected AuthorityService service;

	/**
	 * Instantiates a new AuthorityServiceTest.
	 *
	 * @generated
	 */
	public AuthorityServiceTest() {
		setupRequestContext();
	}

	/**
	 * Operation Unit Test
	 * @generated
	 * TO AVOID LOSING MANUAL CHANGES, turn generation off for this file or method.
	 * Generation of the entire file can be disabled on the Code Generation tab of the Spring DSL editor.
	 * Alternately, you can add the NOT keyword after the @generated annotation above the class declaration.
	 * Add the NOT keyword after the @generated annotation on this method to preserve changes to this method only.
	 */
	@Test
	public void findAuthorityByPrimaryKey() {
		// TODO: JUnit - Populate test inputs for operation: findAuthorityByPrimaryKey 
		Integer userId = 0;
		String authorityField = null;
		Authority response = null;
		response = service.findAuthorityByPrimaryKey(userId, authorityField);
		// TODO: JUnit - Add assertions to test outputs of operation: findAuthorityByPrimaryKey
	}

	/**
	 * Operation Unit Test
	 * Save an existing Authority entity
	 * 
	 * @generated
	 * TO AVOID LOSING MANUAL CHANGES, turn generation off for this file or method.
	 * Generation of the entire file can be disabled on the Code Generation tab of the Spring DSL editor.
	 * Alternately, you can add the NOT keyword after the @generated annotation above the class declaration.
	 * Add the NOT keyword after the @generated annotation on this method to preserve changes to this method only.
	 */
	@Test
	public void saveAuthority() {
		// TODO: JUnit - Populate test inputs for operation: saveAuthority 
		Authority authority_1 = new com.nightwind.bbs.domain.Authority();
		service.saveAuthority(authority_1);
	}

	/**
	 * Operation Unit Test
	 * Load an existing Authority entity
	 * 
	 * @generated
	 * TO AVOID LOSING MANUAL CHANGES, turn generation off for this file or method.
	 * Generation of the entire file can be disabled on the Code Generation tab of the Spring DSL editor.
	 * Alternately, you can add the NOT keyword after the @generated annotation above the class declaration.
	 * Add the NOT keyword after the @generated annotation on this method to preserve changes to this method only.
	 */
	@Test
	public void loadAuthoritys() {
		Set<Authority> response = null;
		response = service.loadAuthoritys();
		// TODO: JUnit - Add assertions to test outputs of operation: loadAuthoritys
	}

	/**
	 * Operation Unit Test
	 * Delete an existing User entity
	 * 
	 * @generated
	 * TO AVOID LOSING MANUAL CHANGES, turn generation off for this file or method.
	 * Generation of the entire file can be disabled on the Code Generation tab of the Spring DSL editor.
	 * Alternately, you can add the NOT keyword after the @generated annotation above the class declaration.
	 * Add the NOT keyword after the @generated annotation on this method to preserve changes to this method only.
	 */
	@Test
	public void deleteAuthorityUser() {
		// TODO: JUnit - Populate test inputs for operation: deleteAuthorityUser 
		Integer authority_userId = 0;
		String authority_authorityField = null;
		Integer related_user_id = 0;
		Authority response = null;
		response = service.deleteAuthorityUser(authority_userId, authority_authorityField, related_user_id);
		// TODO: JUnit - Add assertions to test outputs of operation: deleteAuthorityUser
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Authority entity
	 * 
	 * @generated
	 * TO AVOID LOSING MANUAL CHANGES, turn generation off for this file or method.
	 * Generation of the entire file can be disabled on the Code Generation tab of the Spring DSL editor.
	 * Alternately, you can add the NOT keyword after the @generated annotation above the class declaration.
	 * Add the NOT keyword after the @generated annotation on this method to preserve changes to this method only.
	 */
	@Test
	public void deleteAuthority() {
		// TODO: JUnit - Populate test inputs for operation: deleteAuthority 
		Authority authority = new com.nightwind.bbs.domain.Authority();
		service.deleteAuthority(authority);
	}

	/**
	 * Operation Unit Test
	 * Save an existing User entity
	 * 
	 * @generated
	 * TO AVOID LOSING MANUAL CHANGES, turn generation off for this file or method.
	 * Generation of the entire file can be disabled on the Code Generation tab of the Spring DSL editor.
	 * Alternately, you can add the NOT keyword after the @generated annotation above the class declaration.
	 * Add the NOT keyword after the @generated annotation on this method to preserve changes to this method only.
	 */
	@Test
	public void saveAuthorityUser() {
		// TODO: JUnit - Populate test inputs for operation: saveAuthorityUser 
		Integer userId_1 = 0;
		String authorityField_1 = null;
		User related_user = new com.nightwind.bbs.domain.User();
		Authority response = null;
		response = service.saveAuthorityUser(userId_1, authorityField_1, related_user);
		// TODO: JUnit - Add assertions to test outputs of operation: saveAuthorityUser
	}

	/**
	 * Operation Unit Test
	 * Return a count of all Authority entity
	 * 
	 * @generated
	 * TO AVOID LOSING MANUAL CHANGES, turn generation off for this file or method.
	 * Generation of the entire file can be disabled on the Code Generation tab of the Spring DSL editor.
	 * Alternately, you can add the NOT keyword after the @generated annotation above the class declaration.
	 * Add the NOT keyword after the @generated annotation on this method to preserve changes to this method only.
	 */
	@Test
	public void countAuthoritys() {
		Integer response = null;
		response = service.countAuthoritys();
		// TODO: JUnit - Add assertions to test outputs of operation: countAuthoritys
	}

	/**
	 * Operation Unit Test
	 * Return all Authority entity
	 * 
	 * @generated
	 * TO AVOID LOSING MANUAL CHANGES, turn generation off for this file or method.
	 * Generation of the entire file can be disabled on the Code Generation tab of the Spring DSL editor.
	 * Alternately, you can add the NOT keyword after the @generated annotation above the class declaration.
	 * Add the NOT keyword after the @generated annotation on this method to preserve changes to this method only.
	 */
	@Test
	public void findAllAuthoritys() {
		// TODO: JUnit - Populate test inputs for operation: findAllAuthoritys 
		Integer startResult = 0;
		Integer maxRows = 0;
		List<Authority> response = null;
		response = service.findAllAuthoritys(startResult, maxRows);
		// TODO: JUnit - Add assertions to test outputs of operation: findAllAuthoritys
	}

	/**
	 * Autowired to set the Spring application context.
	 *
	 * @generated
	 */
	@Autowired
	public void setContext(ApplicationContext context) {
		this.context = context;
		((DefaultListableBeanFactory) context.getAutowireCapableBeanFactory()).registerScope("session", new SessionScope());
		((DefaultListableBeanFactory) context.getAutowireCapableBeanFactory()).registerScope("request", new RequestScope());
	}

	/**
	 * Sets Up the Request context
	 *
	 * @generated
	 */
	private void setupRequestContext() {
		MockHttpServletRequest request = new MockHttpServletRequest();
		ServletRequestAttributes attributes = new ServletRequestAttributes(request);
		RequestContextHolder.setRequestAttributes(attributes);
	}
}
