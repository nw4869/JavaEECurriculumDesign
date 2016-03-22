package com.nightwind.bbs.web;

import org.junit.Test;

import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;

import org.springframework.context.ApplicationContext;

import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import org.springframework.test.context.ContextConfiguration;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.RequestScope;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.SessionScope;

/**
 * Unit test for the <code>UserController</code> controller.
 *
 * @see com.nightwind.bbs.web.UserCRUDController
 * @generated
 * @AuxiliaryModelComponent
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./src/bbs-security-context.xml",
		"file:./src/bbs-service-context.xml",
		"file:./src/bbs-dao-context.xml",
		"file:./src/bbs-web-context.xml" })
public class UserCRUDControllerTest {
	/**
	 * The Spring application context.
	 *
	 * @generated
	 */
	private ApplicationContext context;

	/**
	 * Test <code>editUserAuthorities()</code>.
	 * @generated
	 *
	 * TO AVOID LOSING MANUAL CHANGES, turn generation off for this file or method.
	 * Generation of the entire file can be disabled on the Code Generation tab of the Spring DSL editor.
	 * Alternately, you can add the NOT keyword after the @generated annotation above the class declaration.
	 * Add the NOT keyword after the @generated annotation on this method to preserve changes to this method only.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditUserAuthorities() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editUserAuthorities");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		UserCRUDController controller = (UserCRUDController) context.getBean("UserController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newUserAuthorities()</code>.
	 * @generated
	 *
	 * TO AVOID LOSING MANUAL CHANGES, turn generation off for this file or method.
	 * Generation of the entire file can be disabled on the Code Generation tab of the Spring DSL editor.
	 * Alternately, you can add the NOT keyword after the @generated annotation above the class declaration.
	 * Add the NOT keyword after the @generated annotation on this method to preserve changes to this method only.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewUserAuthorities() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newUserAuthorities");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		UserCRUDController controller = (UserCRUDController) context.getBean("UserController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveUserAuthorities()</code>.
	 * @generated
	 *
	 * TO AVOID LOSING MANUAL CHANGES, turn generation off for this file or method.
	 * Generation of the entire file can be disabled on the Code Generation tab of the Spring DSL editor.
	 * Alternately, you can add the NOT keyword after the @generated annotation above the class declaration.
	 * Add the NOT keyword after the @generated annotation on this method to preserve changes to this method only.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveUserAuthorities() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveUserAuthorities");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		UserCRUDController controller = (UserCRUDController) context.getBean("UserController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteUserAuthorities()</code>.
	 * @generated
	 *
	 * TO AVOID LOSING MANUAL CHANGES, turn generation off for this file or method.
	 * Generation of the entire file can be disabled on the Code Generation tab of the Spring DSL editor.
	 * Alternately, you can add the NOT keyword after the @generated annotation above the class declaration.
	 * Add the NOT keyword after the @generated annotation on this method to preserve changes to this method only.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteUserAuthorities() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteUserAuthorities");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		UserCRUDController controller = (UserCRUDController) context.getBean("UserController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteUserAuthorities()</code>.
	 * @generated
	 *
	 * TO AVOID LOSING MANUAL CHANGES, turn generation off for this file or method.
	 * Generation of the entire file can be disabled on the Code Generation tab of the Spring DSL editor.
	 * Alternately, you can add the NOT keyword after the @generated annotation above the class declaration.
	 * Add the NOT keyword after the @generated annotation on this method to preserve changes to this method only.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteUserAuthorities() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteUserAuthorities");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		UserCRUDController controller = (UserCRUDController) context.getBean("UserController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectUserAuthorities()</code>.
	 * @generated
	 *
	 * TO AVOID LOSING MANUAL CHANGES, turn generation off for this file or method.
	 * Generation of the entire file can be disabled on the Code Generation tab of the Spring DSL editor.
	 * Alternately, you can add the NOT keyword after the @generated annotation above the class declaration.
	 * Add the NOT keyword after the @generated annotation on this method to preserve changes to this method only.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectUserAuthorities() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectUserAuthorities");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		UserCRUDController controller = (UserCRUDController) context.getBean("UserController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listUserAuthorities()</code>.
	 * @generated
	 *
	 * TO AVOID LOSING MANUAL CHANGES, turn generation off for this file or method.
	 * Generation of the entire file can be disabled on the Code Generation tab of the Spring DSL editor.
	 * Alternately, you can add the NOT keyword after the @generated annotation above the class declaration.
	 * Add the NOT keyword after the @generated annotation on this method to preserve changes to this method only.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistUserAuthorities() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listUserAuthorities");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		UserCRUDController controller = (UserCRUDController) context.getBean("UserController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editUserForumThreads()</code>.
	 * @generated
	 *
	 * TO AVOID LOSING MANUAL CHANGES, turn generation off for this file or method.
	 * Generation of the entire file can be disabled on the Code Generation tab of the Spring DSL editor.
	 * Alternately, you can add the NOT keyword after the @generated annotation above the class declaration.
	 * Add the NOT keyword after the @generated annotation on this method to preserve changes to this method only.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditUserForumThreads() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editUserForumThreads");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		UserCRUDController controller = (UserCRUDController) context.getBean("UserController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newUserForumThreads()</code>.
	 * @generated
	 *
	 * TO AVOID LOSING MANUAL CHANGES, turn generation off for this file or method.
	 * Generation of the entire file can be disabled on the Code Generation tab of the Spring DSL editor.
	 * Alternately, you can add the NOT keyword after the @generated annotation above the class declaration.
	 * Add the NOT keyword after the @generated annotation on this method to preserve changes to this method only.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewUserForumThreads() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newUserForumThreads");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		UserCRUDController controller = (UserCRUDController) context.getBean("UserController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveUserForumThreads()</code>.
	 * @generated
	 *
	 * TO AVOID LOSING MANUAL CHANGES, turn generation off for this file or method.
	 * Generation of the entire file can be disabled on the Code Generation tab of the Spring DSL editor.
	 * Alternately, you can add the NOT keyword after the @generated annotation above the class declaration.
	 * Add the NOT keyword after the @generated annotation on this method to preserve changes to this method only.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveUserForumThreads() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveUserForumThreads");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		UserCRUDController controller = (UserCRUDController) context.getBean("UserController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteUserForumThreads()</code>.
	 * @generated
	 *
	 * TO AVOID LOSING MANUAL CHANGES, turn generation off for this file or method.
	 * Generation of the entire file can be disabled on the Code Generation tab of the Spring DSL editor.
	 * Alternately, you can add the NOT keyword after the @generated annotation above the class declaration.
	 * Add the NOT keyword after the @generated annotation on this method to preserve changes to this method only.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteUserForumThreads() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteUserForumThreads");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		UserCRUDController controller = (UserCRUDController) context.getBean("UserController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteUserForumThreads()</code>.
	 * @generated
	 *
	 * TO AVOID LOSING MANUAL CHANGES, turn generation off for this file or method.
	 * Generation of the entire file can be disabled on the Code Generation tab of the Spring DSL editor.
	 * Alternately, you can add the NOT keyword after the @generated annotation above the class declaration.
	 * Add the NOT keyword after the @generated annotation on this method to preserve changes to this method only.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteUserForumThreads() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteUserForumThreads");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		UserCRUDController controller = (UserCRUDController) context.getBean("UserController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectUserForumThreads()</code>.
	 * @generated
	 *
	 * TO AVOID LOSING MANUAL CHANGES, turn generation off for this file or method.
	 * Generation of the entire file can be disabled on the Code Generation tab of the Spring DSL editor.
	 * Alternately, you can add the NOT keyword after the @generated annotation above the class declaration.
	 * Add the NOT keyword after the @generated annotation on this method to preserve changes to this method only.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectUserForumThreads() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectUserForumThreads");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		UserCRUDController controller = (UserCRUDController) context.getBean("UserController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listUserForumThreads()</code>.
	 * @generated
	 *
	 * TO AVOID LOSING MANUAL CHANGES, turn generation off for this file or method.
	 * Generation of the entire file can be disabled on the Code Generation tab of the Spring DSL editor.
	 * Alternately, you can add the NOT keyword after the @generated annotation above the class declaration.
	 * Add the NOT keyword after the @generated annotation on this method to preserve changes to this method only.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistUserForumThreads() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listUserForumThreads");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		UserCRUDController controller = (UserCRUDController) context.getBean("UserController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editUserComments()</code>.
	 * @generated
	 *
	 * TO AVOID LOSING MANUAL CHANGES, turn generation off for this file or method.
	 * Generation of the entire file can be disabled on the Code Generation tab of the Spring DSL editor.
	 * Alternately, you can add the NOT keyword after the @generated annotation above the class declaration.
	 * Add the NOT keyword after the @generated annotation on this method to preserve changes to this method only.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditUserComments() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editUserComments");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		UserCRUDController controller = (UserCRUDController) context.getBean("UserController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newUserComments()</code>.
	 * @generated
	 *
	 * TO AVOID LOSING MANUAL CHANGES, turn generation off for this file or method.
	 * Generation of the entire file can be disabled on the Code Generation tab of the Spring DSL editor.
	 * Alternately, you can add the NOT keyword after the @generated annotation above the class declaration.
	 * Add the NOT keyword after the @generated annotation on this method to preserve changes to this method only.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewUserComments() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newUserComments");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		UserCRUDController controller = (UserCRUDController) context.getBean("UserController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveUserComments()</code>.
	 * @generated
	 *
	 * TO AVOID LOSING MANUAL CHANGES, turn generation off for this file or method.
	 * Generation of the entire file can be disabled on the Code Generation tab of the Spring DSL editor.
	 * Alternately, you can add the NOT keyword after the @generated annotation above the class declaration.
	 * Add the NOT keyword after the @generated annotation on this method to preserve changes to this method only.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveUserComments() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveUserComments");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		UserCRUDController controller = (UserCRUDController) context.getBean("UserController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteUserComments()</code>.
	 * @generated
	 *
	 * TO AVOID LOSING MANUAL CHANGES, turn generation off for this file or method.
	 * Generation of the entire file can be disabled on the Code Generation tab of the Spring DSL editor.
	 * Alternately, you can add the NOT keyword after the @generated annotation above the class declaration.
	 * Add the NOT keyword after the @generated annotation on this method to preserve changes to this method only.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteUserComments() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteUserComments");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		UserCRUDController controller = (UserCRUDController) context.getBean("UserController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteUserComments()</code>.
	 * @generated
	 *
	 * TO AVOID LOSING MANUAL CHANGES, turn generation off for this file or method.
	 * Generation of the entire file can be disabled on the Code Generation tab of the Spring DSL editor.
	 * Alternately, you can add the NOT keyword after the @generated annotation above the class declaration.
	 * Add the NOT keyword after the @generated annotation on this method to preserve changes to this method only.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteUserComments() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteUserComments");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		UserCRUDController controller = (UserCRUDController) context.getBean("UserController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectUserComments()</code>.
	 * @generated
	 *
	 * TO AVOID LOSING MANUAL CHANGES, turn generation off for this file or method.
	 * Generation of the entire file can be disabled on the Code Generation tab of the Spring DSL editor.
	 * Alternately, you can add the NOT keyword after the @generated annotation above the class declaration.
	 * Add the NOT keyword after the @generated annotation on this method to preserve changes to this method only.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectUserComments() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectUserComments");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		UserCRUDController controller = (UserCRUDController) context.getBean("UserController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listUserComments()</code>.
	 * @generated
	 *
	 * TO AVOID LOSING MANUAL CHANGES, turn generation off for this file or method.
	 * Generation of the entire file can be disabled on the Code Generation tab of the Spring DSL editor.
	 * Alternately, you can add the NOT keyword after the @generated annotation above the class declaration.
	 * Add the NOT keyword after the @generated annotation on this method to preserve changes to this method only.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistUserComments() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listUserComments");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		UserCRUDController controller = (UserCRUDController) context.getBean("UserController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>indexUser()</code>.
	 * @generated
	 *
	 * TO AVOID LOSING MANUAL CHANGES, turn generation off for this file or method.
	 * Generation of the entire file can be disabled on the Code Generation tab of the Spring DSL editor.
	 * Alternately, you can add the NOT keyword after the @generated annotation above the class declaration.
	 * Add the NOT keyword after the @generated annotation on this method to preserve changes to this method only.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetindexUser() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/indexUser");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		UserCRUDController controller = (UserCRUDController) context.getBean("UserController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectUser()</code>.
	 * @generated
	 *
	 * TO AVOID LOSING MANUAL CHANGES, turn generation off for this file or method.
	 * Generation of the entire file can be disabled on the Code Generation tab of the Spring DSL editor.
	 * Alternately, you can add the NOT keyword after the @generated annotation above the class declaration.
	 * Add the NOT keyword after the @generated annotation on this method to preserve changes to this method only.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectUser() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectUser");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		UserCRUDController controller = (UserCRUDController) context.getBean("UserController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editUser()</code>.
	 * @generated
	 *
	 * TO AVOID LOSING MANUAL CHANGES, turn generation off for this file or method.
	 * Generation of the entire file can be disabled on the Code Generation tab of the Spring DSL editor.
	 * Alternately, you can add the NOT keyword after the @generated annotation above the class declaration.
	 * Add the NOT keyword after the @generated annotation on this method to preserve changes to this method only.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditUser() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editUser");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		UserCRUDController controller = (UserCRUDController) context.getBean("UserController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveUser()</code>.
	 * @generated
	 *
	 * TO AVOID LOSING MANUAL CHANGES, turn generation off for this file or method.
	 * Generation of the entire file can be disabled on the Code Generation tab of the Spring DSL editor.
	 * Alternately, you can add the NOT keyword after the @generated annotation above the class declaration.
	 * Add the NOT keyword after the @generated annotation on this method to preserve changes to this method only.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveUser() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveUser");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		UserCRUDController controller = (UserCRUDController) context.getBean("UserController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newUser()</code>.
	 * @generated
	 *
	 * TO AVOID LOSING MANUAL CHANGES, turn generation off for this file or method.
	 * Generation of the entire file can be disabled on the Code Generation tab of the Spring DSL editor.
	 * Alternately, you can add the NOT keyword after the @generated annotation above the class declaration.
	 * Add the NOT keyword after the @generated annotation on this method to preserve changes to this method only.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewUser() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newUser");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		UserCRUDController controller = (UserCRUDController) context.getBean("UserController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteUser()</code>.
	 * @generated
	 *
	 * TO AVOID LOSING MANUAL CHANGES, turn generation off for this file or method.
	 * Generation of the entire file can be disabled on the Code Generation tab of the Spring DSL editor.
	 * Alternately, you can add the NOT keyword after the @generated annotation above the class declaration.
	 * Add the NOT keyword after the @generated annotation on this method to preserve changes to this method only.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteUser() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteUser");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		UserCRUDController controller = (UserCRUDController) context.getBean("UserController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteUser()</code>.
	 * @generated
	 *
	 * TO AVOID LOSING MANUAL CHANGES, turn generation off for this file or method.
	 * Generation of the entire file can be disabled on the Code Generation tab of the Spring DSL editor.
	 * Alternately, you can add the NOT keyword after the @generated annotation above the class declaration.
	 * Add the NOT keyword after the @generated annotation on this method to preserve changes to this method only.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteUser() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteUser");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		UserCRUDController controller = (UserCRUDController) context.getBean("UserController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>userControllerbinaryaction()</code>.
	 * @generated
	 *
	 * TO AVOID LOSING MANUAL CHANGES, turn generation off for this file or method.
	 * Generation of the entire file can be disabled on the Code Generation tab of the Spring DSL editor.
	 * Alternately, you can add the NOT keyword after the @generated annotation above the class declaration.
	 * Add the NOT keyword after the @generated annotation on this method to preserve changes to this method only.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetuserControllerbinaryaction() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/userController/binary.action");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		UserCRUDController controller = (UserCRUDController) context.getBean("UserController");

		// TODO Invoke method and Assert return values

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
	 * Returns a mock HttpServletRequest object.
	 *
	 * @generated
	 */
	private MockHttpServletRequest getMockHttpServletRequest() {
		MockHttpServletRequest request = new MockHttpServletRequest();
		ServletRequestAttributes attributes = new ServletRequestAttributes(request);
		RequestContextHolder.setRequestAttributes(attributes);
		return request;
	}

	/**
	 * Returns a mock HttpServletResponse object.
	 *
	 * @generated
	 */
	private MockHttpServletResponse getMockHttpServletResponse() {
		return new MockHttpServletResponse();
	}
}