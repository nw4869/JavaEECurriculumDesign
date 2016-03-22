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
 * Unit test for the <code>ForumThreadController</code> controller.
 *
 * @see com.nightwind.bbs.web.ForumThreadController
 * @generated
 * @AuxiliaryModelComponent
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./src/bbs-security-context.xml",
		"file:./src/bbs-service-context.xml",
		"file:./src/bbs-dao-context.xml",
		"file:./src/bbs-web-context.xml" })
public class ForumThreadControllerTest {
	/**
	 * The Spring application context.
	 *
	 * @generated
	 */
	private ApplicationContext context;

	/**
	 * Test <code>editForumThreadUser()</code>.
	 * @generated
	 *
	 * TO AVOID LOSING MANUAL CHANGES, turn generation off for this file or method.
	 * Generation of the entire file can be disabled on the Code Generation tab of the Spring DSL editor.
	 * Alternately, you can add the NOT keyword after the @generated annotation above the class declaration.
	 * Add the NOT keyword after the @generated annotation on this method to preserve changes to this method only.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditForumThreadUser() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editForumThreadUser");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ForumThreadController controller = (ForumThreadController) context.getBean("ForumThreadController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newForumThreadUser()</code>.
	 * @generated
	 *
	 * TO AVOID LOSING MANUAL CHANGES, turn generation off for this file or method.
	 * Generation of the entire file can be disabled on the Code Generation tab of the Spring DSL editor.
	 * Alternately, you can add the NOT keyword after the @generated annotation above the class declaration.
	 * Add the NOT keyword after the @generated annotation on this method to preserve changes to this method only.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewForumThreadUser() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newForumThreadUser");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ForumThreadController controller = (ForumThreadController) context.getBean("ForumThreadController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveForumThreadUser()</code>.
	 * @generated
	 *
	 * TO AVOID LOSING MANUAL CHANGES, turn generation off for this file or method.
	 * Generation of the entire file can be disabled on the Code Generation tab of the Spring DSL editor.
	 * Alternately, you can add the NOT keyword after the @generated annotation above the class declaration.
	 * Add the NOT keyword after the @generated annotation on this method to preserve changes to this method only.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveForumThreadUser() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveForumThreadUser");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ForumThreadController controller = (ForumThreadController) context.getBean("ForumThreadController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteForumThreadUser()</code>.
	 * @generated
	 *
	 * TO AVOID LOSING MANUAL CHANGES, turn generation off for this file or method.
	 * Generation of the entire file can be disabled on the Code Generation tab of the Spring DSL editor.
	 * Alternately, you can add the NOT keyword after the @generated annotation above the class declaration.
	 * Add the NOT keyword after the @generated annotation on this method to preserve changes to this method only.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteForumThreadUser() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteForumThreadUser");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ForumThreadController controller = (ForumThreadController) context.getBean("ForumThreadController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteForumThreadUser()</code>.
	 * @generated
	 *
	 * TO AVOID LOSING MANUAL CHANGES, turn generation off for this file or method.
	 * Generation of the entire file can be disabled on the Code Generation tab of the Spring DSL editor.
	 * Alternately, you can add the NOT keyword after the @generated annotation above the class declaration.
	 * Add the NOT keyword after the @generated annotation on this method to preserve changes to this method only.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteForumThreadUser() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteForumThreadUser");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ForumThreadController controller = (ForumThreadController) context.getBean("ForumThreadController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectForumThreadUser()</code>.
	 * @generated
	 *
	 * TO AVOID LOSING MANUAL CHANGES, turn generation off for this file or method.
	 * Generation of the entire file can be disabled on the Code Generation tab of the Spring DSL editor.
	 * Alternately, you can add the NOT keyword after the @generated annotation above the class declaration.
	 * Add the NOT keyword after the @generated annotation on this method to preserve changes to this method only.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectForumThreadUser() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectForumThreadUser");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ForumThreadController controller = (ForumThreadController) context.getBean("ForumThreadController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listForumThreadUser()</code>.
	 * @generated
	 *
	 * TO AVOID LOSING MANUAL CHANGES, turn generation off for this file or method.
	 * Generation of the entire file can be disabled on the Code Generation tab of the Spring DSL editor.
	 * Alternately, you can add the NOT keyword after the @generated annotation above the class declaration.
	 * Add the NOT keyword after the @generated annotation on this method to preserve changes to this method only.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistForumThreadUser() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listForumThreadUser");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ForumThreadController controller = (ForumThreadController) context.getBean("ForumThreadController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editForumThreadForum()</code>.
	 * @generated
	 *
	 * TO AVOID LOSING MANUAL CHANGES, turn generation off for this file or method.
	 * Generation of the entire file can be disabled on the Code Generation tab of the Spring DSL editor.
	 * Alternately, you can add the NOT keyword after the @generated annotation above the class declaration.
	 * Add the NOT keyword after the @generated annotation on this method to preserve changes to this method only.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditForumThreadForum() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editForumThreadForum");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ForumThreadController controller = (ForumThreadController) context.getBean("ForumThreadController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newForumThreadForum()</code>.
	 * @generated
	 *
	 * TO AVOID LOSING MANUAL CHANGES, turn generation off for this file or method.
	 * Generation of the entire file can be disabled on the Code Generation tab of the Spring DSL editor.
	 * Alternately, you can add the NOT keyword after the @generated annotation above the class declaration.
	 * Add the NOT keyword after the @generated annotation on this method to preserve changes to this method only.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewForumThreadForum() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newForumThreadForum");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ForumThreadController controller = (ForumThreadController) context.getBean("ForumThreadController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveForumThreadForum()</code>.
	 * @generated
	 *
	 * TO AVOID LOSING MANUAL CHANGES, turn generation off for this file or method.
	 * Generation of the entire file can be disabled on the Code Generation tab of the Spring DSL editor.
	 * Alternately, you can add the NOT keyword after the @generated annotation above the class declaration.
	 * Add the NOT keyword after the @generated annotation on this method to preserve changes to this method only.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveForumThreadForum() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveForumThreadForum");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ForumThreadController controller = (ForumThreadController) context.getBean("ForumThreadController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteForumThreadForum()</code>.
	 * @generated
	 *
	 * TO AVOID LOSING MANUAL CHANGES, turn generation off for this file or method.
	 * Generation of the entire file can be disabled on the Code Generation tab of the Spring DSL editor.
	 * Alternately, you can add the NOT keyword after the @generated annotation above the class declaration.
	 * Add the NOT keyword after the @generated annotation on this method to preserve changes to this method only.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteForumThreadForum() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteForumThreadForum");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ForumThreadController controller = (ForumThreadController) context.getBean("ForumThreadController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteForumThreadForum()</code>.
	 * @generated
	 *
	 * TO AVOID LOSING MANUAL CHANGES, turn generation off for this file or method.
	 * Generation of the entire file can be disabled on the Code Generation tab of the Spring DSL editor.
	 * Alternately, you can add the NOT keyword after the @generated annotation above the class declaration.
	 * Add the NOT keyword after the @generated annotation on this method to preserve changes to this method only.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteForumThreadForum() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteForumThreadForum");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ForumThreadController controller = (ForumThreadController) context.getBean("ForumThreadController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectForumThreadForum()</code>.
	 * @generated
	 *
	 * TO AVOID LOSING MANUAL CHANGES, turn generation off for this file or method.
	 * Generation of the entire file can be disabled on the Code Generation tab of the Spring DSL editor.
	 * Alternately, you can add the NOT keyword after the @generated annotation above the class declaration.
	 * Add the NOT keyword after the @generated annotation on this method to preserve changes to this method only.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectForumThreadForum() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectForumThreadForum");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ForumThreadController controller = (ForumThreadController) context.getBean("ForumThreadController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listForumThreadForum()</code>.
	 * @generated
	 *
	 * TO AVOID LOSING MANUAL CHANGES, turn generation off for this file or method.
	 * Generation of the entire file can be disabled on the Code Generation tab of the Spring DSL editor.
	 * Alternately, you can add the NOT keyword after the @generated annotation above the class declaration.
	 * Add the NOT keyword after the @generated annotation on this method to preserve changes to this method only.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistForumThreadForum() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listForumThreadForum");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ForumThreadController controller = (ForumThreadController) context.getBean("ForumThreadController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editForumThreadComments()</code>.
	 * @generated
	 *
	 * TO AVOID LOSING MANUAL CHANGES, turn generation off for this file or method.
	 * Generation of the entire file can be disabled on the Code Generation tab of the Spring DSL editor.
	 * Alternately, you can add the NOT keyword after the @generated annotation above the class declaration.
	 * Add the NOT keyword after the @generated annotation on this method to preserve changes to this method only.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditForumThreadComments() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editForumThreadComments");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ForumThreadController controller = (ForumThreadController) context.getBean("ForumThreadController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newForumThreadComments()</code>.
	 * @generated
	 *
	 * TO AVOID LOSING MANUAL CHANGES, turn generation off for this file or method.
	 * Generation of the entire file can be disabled on the Code Generation tab of the Spring DSL editor.
	 * Alternately, you can add the NOT keyword after the @generated annotation above the class declaration.
	 * Add the NOT keyword after the @generated annotation on this method to preserve changes to this method only.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewForumThreadComments() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newForumThreadComments");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ForumThreadController controller = (ForumThreadController) context.getBean("ForumThreadController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveForumThreadComments()</code>.
	 * @generated
	 *
	 * TO AVOID LOSING MANUAL CHANGES, turn generation off for this file or method.
	 * Generation of the entire file can be disabled on the Code Generation tab of the Spring DSL editor.
	 * Alternately, you can add the NOT keyword after the @generated annotation above the class declaration.
	 * Add the NOT keyword after the @generated annotation on this method to preserve changes to this method only.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveForumThreadComments() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveForumThreadComments");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ForumThreadController controller = (ForumThreadController) context.getBean("ForumThreadController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteForumThreadComments()</code>.
	 * @generated
	 *
	 * TO AVOID LOSING MANUAL CHANGES, turn generation off for this file or method.
	 * Generation of the entire file can be disabled on the Code Generation tab of the Spring DSL editor.
	 * Alternately, you can add the NOT keyword after the @generated annotation above the class declaration.
	 * Add the NOT keyword after the @generated annotation on this method to preserve changes to this method only.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteForumThreadComments() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteForumThreadComments");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ForumThreadController controller = (ForumThreadController) context.getBean("ForumThreadController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteForumThreadComments()</code>.
	 * @generated
	 *
	 * TO AVOID LOSING MANUAL CHANGES, turn generation off for this file or method.
	 * Generation of the entire file can be disabled on the Code Generation tab of the Spring DSL editor.
	 * Alternately, you can add the NOT keyword after the @generated annotation above the class declaration.
	 * Add the NOT keyword after the @generated annotation on this method to preserve changes to this method only.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteForumThreadComments() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteForumThreadComments");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ForumThreadController controller = (ForumThreadController) context.getBean("ForumThreadController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectForumThreadComments()</code>.
	 * @generated
	 *
	 * TO AVOID LOSING MANUAL CHANGES, turn generation off for this file or method.
	 * Generation of the entire file can be disabled on the Code Generation tab of the Spring DSL editor.
	 * Alternately, you can add the NOT keyword after the @generated annotation above the class declaration.
	 * Add the NOT keyword after the @generated annotation on this method to preserve changes to this method only.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectForumThreadComments() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectForumThreadComments");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ForumThreadController controller = (ForumThreadController) context.getBean("ForumThreadController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listForumThreadComments()</code>.
	 * @generated
	 *
	 * TO AVOID LOSING MANUAL CHANGES, turn generation off for this file or method.
	 * Generation of the entire file can be disabled on the Code Generation tab of the Spring DSL editor.
	 * Alternately, you can add the NOT keyword after the @generated annotation above the class declaration.
	 * Add the NOT keyword after the @generated annotation on this method to preserve changes to this method only.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistForumThreadComments() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listForumThreadComments");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ForumThreadController controller = (ForumThreadController) context.getBean("ForumThreadController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>indexForumThread()</code>.
	 * @generated
	 *
	 * TO AVOID LOSING MANUAL CHANGES, turn generation off for this file or method.
	 * Generation of the entire file can be disabled on the Code Generation tab of the Spring DSL editor.
	 * Alternately, you can add the NOT keyword after the @generated annotation above the class declaration.
	 * Add the NOT keyword after the @generated annotation on this method to preserve changes to this method only.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetindexForumThread() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/indexForumThread");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ForumThreadController controller = (ForumThreadController) context.getBean("ForumThreadController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectForumThread()</code>.
	 * @generated
	 *
	 * TO AVOID LOSING MANUAL CHANGES, turn generation off for this file or method.
	 * Generation of the entire file can be disabled on the Code Generation tab of the Spring DSL editor.
	 * Alternately, you can add the NOT keyword after the @generated annotation above the class declaration.
	 * Add the NOT keyword after the @generated annotation on this method to preserve changes to this method only.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectForumThread() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectForumThread");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ForumThreadController controller = (ForumThreadController) context.getBean("ForumThreadController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editForumThread()</code>.
	 * @generated
	 *
	 * TO AVOID LOSING MANUAL CHANGES, turn generation off for this file or method.
	 * Generation of the entire file can be disabled on the Code Generation tab of the Spring DSL editor.
	 * Alternately, you can add the NOT keyword after the @generated annotation above the class declaration.
	 * Add the NOT keyword after the @generated annotation on this method to preserve changes to this method only.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditForumThread() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editForumThread");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ForumThreadController controller = (ForumThreadController) context.getBean("ForumThreadController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveForumThread()</code>.
	 * @generated
	 *
	 * TO AVOID LOSING MANUAL CHANGES, turn generation off for this file or method.
	 * Generation of the entire file can be disabled on the Code Generation tab of the Spring DSL editor.
	 * Alternately, you can add the NOT keyword after the @generated annotation above the class declaration.
	 * Add the NOT keyword after the @generated annotation on this method to preserve changes to this method only.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveForumThread() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveForumThread");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ForumThreadController controller = (ForumThreadController) context.getBean("ForumThreadController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newForumThread()</code>.
	 * @generated
	 *
	 * TO AVOID LOSING MANUAL CHANGES, turn generation off for this file or method.
	 * Generation of the entire file can be disabled on the Code Generation tab of the Spring DSL editor.
	 * Alternately, you can add the NOT keyword after the @generated annotation above the class declaration.
	 * Add the NOT keyword after the @generated annotation on this method to preserve changes to this method only.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewForumThread() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newForumThread");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ForumThreadController controller = (ForumThreadController) context.getBean("ForumThreadController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteForumThread()</code>.
	 * @generated
	 *
	 * TO AVOID LOSING MANUAL CHANGES, turn generation off for this file or method.
	 * Generation of the entire file can be disabled on the Code Generation tab of the Spring DSL editor.
	 * Alternately, you can add the NOT keyword after the @generated annotation above the class declaration.
	 * Add the NOT keyword after the @generated annotation on this method to preserve changes to this method only.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteForumThread() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteForumThread");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ForumThreadController controller = (ForumThreadController) context.getBean("ForumThreadController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteForumThread()</code>.
	 * @generated
	 *
	 * TO AVOID LOSING MANUAL CHANGES, turn generation off for this file or method.
	 * Generation of the entire file can be disabled on the Code Generation tab of the Spring DSL editor.
	 * Alternately, you can add the NOT keyword after the @generated annotation above the class declaration.
	 * Add the NOT keyword after the @generated annotation on this method to preserve changes to this method only.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteForumThread() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteForumThread");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ForumThreadController controller = (ForumThreadController) context.getBean("ForumThreadController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>forumthreadControllerbinaryaction()</code>.
	 * @generated
	 *
	 * TO AVOID LOSING MANUAL CHANGES, turn generation off for this file or method.
	 * Generation of the entire file can be disabled on the Code Generation tab of the Spring DSL editor.
	 * Alternately, you can add the NOT keyword after the @generated annotation above the class declaration.
	 * Add the NOT keyword after the @generated annotation on this method to preserve changes to this method only.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetforumthreadControllerbinaryaction() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/forumthreadController/binary.action");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ForumThreadController controller = (ForumThreadController) context.getBean("ForumThreadController");

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