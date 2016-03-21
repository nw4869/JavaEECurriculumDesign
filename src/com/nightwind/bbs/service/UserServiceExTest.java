package com.nightwind.bbs.service;

import com.nightwind.bbs.domain.User;
import com.nightwind.exception.AccountExistedException;
import com.nightwind.exception.UserNotFoundException;

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
public class UserServiceExTest {

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
	protected UserServiceEx service;

	/**
	 * Instantiates a new UserServiceExTest.
	 *
	 * @generated
	 */
	public UserServiceExTest() {
		setupRequestContext();
	}

	/**
	 * Operation Unit Test
	 * @throws AccountExistedException 
	 * @generated
	 * TO AVOID LOSING MANUAL CHANGES, turn generation off for this file or method.
	 * Generation of the entire file can be disabled on the Code Generation tab of the Spring DSL editor.
	 * Alternately, you can add the NOT keyword after the @generated annotation above the class declaration.
	 * Add the NOT keyword after the @generated annotation on this method to preserve changes to this method only.
	 */
	@Test
	public void register() throws AccountExistedException {
		// TODO: JUnit - Populate test inputs for operation: register 
		String username_2 = "nw";
		String password_2 = "4869";
		User response = null;
		response = service.register(username_2, password_2);
		// TODO: JUnit - Add assertions to test outputs of operation: register
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
	public void logout() {
		// TODO: JUnit - Populate test inputs for operation: logout 
		Integer id = 0;
		service.logout(id);
	}

	/**
	 * Operation Unit Test
	 * @throws UserNotFoundException
	 * 
	 * @generated
	 * TO AVOID LOSING MANUAL CHANGES, turn generation off for this file or method.
	 * Generation of the entire file can be disabled on the Code Generation tab of the Spring DSL editor.
	 * Alternately, you can add the NOT keyword after the @generated annotation above the class declaration.
	 * Add the NOT keyword after the @generated annotation on this method to preserve changes to this method only.
	 */
	@Test
	public void findUserById() throws com.nightwind.exception.UserNotFoundException {
		// TODO: JUnit - Populate test inputs for operation: findUserById 
		Integer id_1 = 0;
		User response = null;
		response = service.findUserById(id_1);
		// TODO: JUnit - Add assertions to test outputs of operation: findUserById
	}

	/**
	 * Operation Unit Test
	 * @throws UserNotFoundException
	 * 
	 * @generated
	 * TO AVOID LOSING MANUAL CHANGES, turn generation off for this file or method.
	 * Generation of the entire file can be disabled on the Code Generation tab of the Spring DSL editor.
	 * Alternately, you can add the NOT keyword after the @generated annotation above the class declaration.
	 * Add the NOT keyword after the @generated annotation on this method to preserve changes to this method only.
	 */
	@Test
	public void findUserByUsername() throws com.nightwind.exception.UserNotFoundException {
		// TODO: JUnit - Populate test inputs for operation: findUserByUsername 
		String username_1 = null;
		User response = null;
		response = service.findUserByUsername(username_1);
		// TODO: JUnit - Add assertions to test outputs of operation: findUserByUsername
	}

	/**
	 * Operation Unit Test
	 * @throws AuthorizeException
	 * @throws UserNotFoundException
	 * 
	 * @generated
	 * TO AVOID LOSING MANUAL CHANGES, turn generation off for this file or method.
	 * Generation of the entire file can be disabled on the Code Generation tab of the Spring DSL editor.
	 * Alternately, you can add the NOT keyword after the @generated annotation above the class declaration.
	 * Add the NOT keyword after the @generated annotation on this method to preserve changes to this method only.
	 */
	@Test
	public void login() throws com.nightwind.exception.AuthorizeException, com.nightwind.exception.UserNotFoundException {
		// TODO: JUnit - Populate test inputs for operation: login 
		String username = "nw";
		String password = "4869";
		User response = null;
		response = service.login(username, password);
		// TODO: JUnit - Add assertions to test outputs of operation: login
		System.out.println("response: " + response);
	}

	/**
	 * Operation Unit Test
	 * @throws UserNotFoundException
	 * 
	 * @generated
	 * TO AVOID LOSING MANUAL CHANGES, turn generation off for this file or method.
	 * Generation of the entire file can be disabled on the Code Generation tab of the Spring DSL editor.
	 * Alternately, you can add the NOT keyword after the @generated annotation above the class declaration.
	 * Add the NOT keyword after the @generated annotation on this method to preserve changes to this method only.
	 */
	@Test
	public void updateInfo() throws com.nightwind.exception.UserNotFoundException {
		// TODO: JUnit - Populate test inputs for operation: updateInfo 
		User user = new User();
		user.copy(service.findUserById(2));
//		user.setId(2);
		
		user.setUsername("asdfasdfasdf");
		user.setPassword("new password??");
		
		user.setEmail("test@test.com");
		user.setAvatar("/avatar/test.jpg");
		user.setSignature("my signature");
		
		User response = null;
		response = service.updateInfo(user);
		// TODO: JUnit - Add assertions to test outputs of operation: updateInfo
		System.out.println("update user: " + response);
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
	public void updatePassword() throws com.nightwind.exception.UserNotFoundException, com.nightwind.exception.AuthorizeException {
		// TODO: JUnit - Populate test inputs for operation: updatePassword 
		Integer id_2 = 0;
		String password_1 = null;
		String newPassword = null;
		service.updatePassword(id_2, password_1, newPassword);
	}
	
	@Test
	public void getAuthorize() throws UserNotFoundException {
		User user = service.findUserById(1);
		System.out.println(user.getAuthorities());
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
