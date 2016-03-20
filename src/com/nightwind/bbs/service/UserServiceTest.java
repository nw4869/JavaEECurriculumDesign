package com.nightwind.bbs.service;

import com.nightwind.bbs.domain.Authority;
import com.nightwind.bbs.domain.Comment;
import com.nightwind.bbs.domain.ForumThread;
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
public class UserServiceTest {

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
	protected UserService service;

	/**
	 * Instantiates a new UserServiceTest.
	 *
	 * @generated
	 */
	public UserServiceTest() {
		setupRequestContext();
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
	public void deleteUser() {
		// TODO: JUnit - Populate test inputs for operation: deleteUser 
		User user = new com.nightwind.bbs.domain.User();
		service.deleteUser(user);
	}

	/**
	 * Operation Unit Test
	 * Return all User entity
	 * 
	 * @generated
	 * TO AVOID LOSING MANUAL CHANGES, turn generation off for this file or method.
	 * Generation of the entire file can be disabled on the Code Generation tab of the Spring DSL editor.
	 * Alternately, you can add the NOT keyword after the @generated annotation above the class declaration.
	 * Add the NOT keyword after the @generated annotation on this method to preserve changes to this method only.
	 */
	@Test
	public void findAllUsers() {
		// TODO: JUnit - Populate test inputs for operation: findAllUsers 
		Integer startResult = 0;
		Integer maxRows = 0;
		List<User> response = null;
		response = service.findAllUsers(startResult, maxRows);
		// TODO: JUnit - Add assertions to test outputs of operation: findAllUsers
	}

	/**
	 * Operation Unit Test
	 * Delete an existing ForumThread entity
	 * 
	 * @generated
	 * TO AVOID LOSING MANUAL CHANGES, turn generation off for this file or method.
	 * Generation of the entire file can be disabled on the Code Generation tab of the Spring DSL editor.
	 * Alternately, you can add the NOT keyword after the @generated annotation above the class declaration.
	 * Add the NOT keyword after the @generated annotation on this method to preserve changes to this method only.
	 */
	@Test
	public void deleteUserForumThreads() {
		// TODO: JUnit - Populate test inputs for operation: deleteUserForumThreads 
		Integer user_id_1 = 0;
		Integer related_forumthreads_id = 0;
		User response = null;
		response = service.deleteUserForumThreads(user_id_1, related_forumthreads_id);
		// TODO: JUnit - Add assertions to test outputs of operation: deleteUserForumThreads
	}

	/**
	 * Operation Unit Test
	 * Save an existing ForumThread entity
	 * 
	 * @generated
	 * TO AVOID LOSING MANUAL CHANGES, turn generation off for this file or method.
	 * Generation of the entire file can be disabled on the Code Generation tab of the Spring DSL editor.
	 * Alternately, you can add the NOT keyword after the @generated annotation above the class declaration.
	 * Add the NOT keyword after the @generated annotation on this method to preserve changes to this method only.
	 */
	@Test
	public void saveUserForumThreads() {
		// TODO: JUnit - Populate test inputs for operation: saveUserForumThreads 
		Integer id_2 = 0;
		ForumThread related_forumthreads = new com.nightwind.bbs.domain.ForumThread();
		User response = null;
		response = service.saveUserForumThreads(id_2, related_forumthreads);
		// TODO: JUnit - Add assertions to test outputs of operation: saveUserForumThreads
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
	public void saveUser() {
		// TODO: JUnit - Populate test inputs for operation: saveUser 
		User user_1 = new com.nightwind.bbs.domain.User();
		service.saveUser(user_1);
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
	public void saveUserAuthorities() {
		// TODO: JUnit - Populate test inputs for operation: saveUserAuthorities 
		Integer id = 0;
		Authority related_authorities = new com.nightwind.bbs.domain.Authority();
		User response = null;
		response = service.saveUserAuthorities(id, related_authorities);
		// TODO: JUnit - Add assertions to test outputs of operation: saveUserAuthorities
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
	public void deleteUserAuthorities() {
		// TODO: JUnit - Populate test inputs for operation: deleteUserAuthorities 
		Integer user_id_2 = 0;
		Integer related_authorities_userId = 0;
		String related_authorities_authorityField = null;
		User response = null;
		response = service.deleteUserAuthorities(user_id_2, related_authorities_userId, related_authorities_authorityField);
		// TODO: JUnit - Add assertions to test outputs of operation: deleteUserAuthorities
	}

	/**
	 * Operation Unit Test
	 * Return a count of all User entity
	 * 
	 * @generated
	 * TO AVOID LOSING MANUAL CHANGES, turn generation off for this file or method.
	 * Generation of the entire file can be disabled on the Code Generation tab of the Spring DSL editor.
	 * Alternately, you can add the NOT keyword after the @generated annotation above the class declaration.
	 * Add the NOT keyword after the @generated annotation on this method to preserve changes to this method only.
	 */
	@Test
	public void countUsers() {
		Integer response = null;
		response = service.countUsers();
		// TODO: JUnit - Add assertions to test outputs of operation: countUsers
	}

	/**
	 * Operation Unit Test
	 * Load an existing User entity
	 * 
	 * @generated
	 * TO AVOID LOSING MANUAL CHANGES, turn generation off for this file or method.
	 * Generation of the entire file can be disabled on the Code Generation tab of the Spring DSL editor.
	 * Alternately, you can add the NOT keyword after the @generated annotation above the class declaration.
	 * Add the NOT keyword after the @generated annotation on this method to preserve changes to this method only.
	 */
	@Test
	public void loadUsers() {
		Set<User> response = null;
		response = service.loadUsers();
		// TODO: JUnit - Add assertions to test outputs of operation: loadUsers
	}

	/**
	 * Operation Unit Test
	 * Save an existing Comment entity
	 * 
	 * @generated
	 * TO AVOID LOSING MANUAL CHANGES, turn generation off for this file or method.
	 * Generation of the entire file can be disabled on the Code Generation tab of the Spring DSL editor.
	 * Alternately, you can add the NOT keyword after the @generated annotation above the class declaration.
	 * Add the NOT keyword after the @generated annotation on this method to preserve changes to this method only.
	 */
	@Test
	public void saveUserComments() {
		// TODO: JUnit - Populate test inputs for operation: saveUserComments 
		Integer id_1 = 0;
		Comment related_comments = new com.nightwind.bbs.domain.Comment();
		User response = null;
		response = service.saveUserComments(id_1, related_comments);
		// TODO: JUnit - Add assertions to test outputs of operation: saveUserComments
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Comment entity
	 * 
	 * @generated
	 * TO AVOID LOSING MANUAL CHANGES, turn generation off for this file or method.
	 * Generation of the entire file can be disabled on the Code Generation tab of the Spring DSL editor.
	 * Alternately, you can add the NOT keyword after the @generated annotation above the class declaration.
	 * Add the NOT keyword after the @generated annotation on this method to preserve changes to this method only.
	 */
	@Test
	public void deleteUserComments() {
		// TODO: JUnit - Populate test inputs for operation: deleteUserComments 
		Integer user_id = 0;
		Integer related_comments_id = 0;
		User response = null;
		response = service.deleteUserComments(user_id, related_comments_id);
		// TODO: JUnit - Add assertions to test outputs of operation: deleteUserComments
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
	public void findUserByPrimaryKey() {
		// TODO: JUnit - Populate test inputs for operation: findUserByPrimaryKey 
		Integer id_3 = 0;
		User response = null;
		response = service.findUserByPrimaryKey(id_3);
		// TODO: JUnit - Add assertions to test outputs of operation: findUserByPrimaryKey
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
