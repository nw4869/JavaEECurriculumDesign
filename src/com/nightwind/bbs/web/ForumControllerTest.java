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
 * Unit test for the <code>ForumController</code> controller.
 *
 * @see com.nightwind.bbs.web.ForumCURDController
 * @generated
 * @AuxiliaryModelComponent
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./src/bbs-security-context.xml",
		"file:./src/bbs-service-context.xml",
		"file:./src/bbs-dao-context.xml",
		"file:./src/bbs-web-context.xml" })
public class ForumControllerTest {
	/**
	 * The Spring application context.
	 *
	 * @generated
	 */
	private ApplicationContext context;

	/**
	 * Test <code>editForumForumThreads()</code>.
	 * @generated
	 *
	 * TO AVOID LOSING MANUAL CHANGES, turn generation off for this file or method.
	 * Generation of the entire file can be disabled on the Code Generation tab of the Spring DSL editor.
	 * Alternately, you can add the NOT keyword after the @generated annotation above the class declaration.
	 * Add the NOT keyword after the @generated annotation on this method to preserve changes to this method only.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditForumForumThreads() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editForumForumThreads");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ForumCURDController controller = (ForumCURDController) context.getBean("ForumController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newForumForumThreads()</code>.
	 * @generated
	 *
	 * TO AVOID LOSING MANUAL CHANGES, turn generation off for this file or method.
	 * Generation of the entire file can be disabled on the Code Generation tab of the Spring DSL editor.
	 * Alternately, you can add the NOT keyword after the @generated annotation above the class declaration.
	 * Add the NOT keyword after the @generated annotation on this method to preserve changes to this method only.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewForumForumThreads() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newForumForumThreads");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ForumCURDController controller = (ForumCURDController) context.getBean("ForumController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveForumForumThreads()</code>.
	 * @generated
	 *
	 * TO AVOID LOSING MANUAL CHANGES, turn generation off for this file or method.
	 * Generation of the entire file can be disabled on the Code Generation tab of the Spring DSL editor.
	 * Alternately, you can add the NOT keyword after the @generated annotation above the class declaration.
	 * Add the NOT keyword after the @generated annotation on this method to preserve changes to this method only.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveForumForumThreads() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveForumForumThreads");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ForumCURDController controller = (ForumCURDController) context.getBean("ForumController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteForumForumThreads()</code>.
	 * @generated
	 *
	 * TO AVOID LOSING MANUAL CHANGES, turn generation off for this file or method.
	 * Generation of the entire file can be disabled on the Code Generation tab of the Spring DSL editor.
	 * Alternately, you can add the NOT keyword after the @generated annotation above the class declaration.
	 * Add the NOT keyword after the @generated annotation on this method to preserve changes to this method only.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteForumForumThreads() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteForumForumThreads");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ForumCURDController controller = (ForumCURDController) context.getBean("ForumController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteForumForumThreads()</code>.
	 * @generated
	 *
	 * TO AVOID LOSING MANUAL CHANGES, turn generation off for this file or method.
	 * Generation of the entire file can be disabled on the Code Generation tab of the Spring DSL editor.
	 * Alternately, you can add the NOT keyword after the @generated annotation above the class declaration.
	 * Add the NOT keyword after the @generated annotation on this method to preserve changes to this method only.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteForumForumThreads() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteForumForumThreads");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ForumCURDController controller = (ForumCURDController) context.getBean("ForumController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectForumForumThreads()</code>.
	 * @generated
	 *
	 * TO AVOID LOSING MANUAL CHANGES, turn generation off for this file or method.
	 * Generation of the entire file can be disabled on the Code Generation tab of the Spring DSL editor.
	 * Alternately, you can add the NOT keyword after the @generated annotation above the class declaration.
	 * Add the NOT keyword after the @generated annotation on this method to preserve changes to this method only.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectForumForumThreads() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectForumForumThreads");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ForumCURDController controller = (ForumCURDController) context.getBean("ForumController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listForumForumThreads()</code>.
	 * @generated
	 *
	 * TO AVOID LOSING MANUAL CHANGES, turn generation off for this file or method.
	 * Generation of the entire file can be disabled on the Code Generation tab of the Spring DSL editor.
	 * Alternately, you can add the NOT keyword after the @generated annotation above the class declaration.
	 * Add the NOT keyword after the @generated annotation on this method to preserve changes to this method only.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistForumForumThreads() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listForumForumThreads");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ForumCURDController controller = (ForumCURDController) context.getBean("ForumController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>indexForum()</code>.
	 * @generated
	 *
	 * TO AVOID LOSING MANUAL CHANGES, turn generation off for this file or method.
	 * Generation of the entire file can be disabled on the Code Generation tab of the Spring DSL editor.
	 * Alternately, you can add the NOT keyword after the @generated annotation above the class declaration.
	 * Add the NOT keyword after the @generated annotation on this method to preserve changes to this method only.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetindexForum() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/indexForum");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ForumCURDController controller = (ForumCURDController) context.getBean("ForumController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectForum()</code>.
	 * @generated
	 *
	 * TO AVOID LOSING MANUAL CHANGES, turn generation off for this file or method.
	 * Generation of the entire file can be disabled on the Code Generation tab of the Spring DSL editor.
	 * Alternately, you can add the NOT keyword after the @generated annotation above the class declaration.
	 * Add the NOT keyword after the @generated annotation on this method to preserve changes to this method only.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectForum() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectForum");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ForumCURDController controller = (ForumCURDController) context.getBean("ForumController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editForum()</code>.
	 * @generated
	 *
	 * TO AVOID LOSING MANUAL CHANGES, turn generation off for this file or method.
	 * Generation of the entire file can be disabled on the Code Generation tab of the Spring DSL editor.
	 * Alternately, you can add the NOT keyword after the @generated annotation above the class declaration.
	 * Add the NOT keyword after the @generated annotation on this method to preserve changes to this method only.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditForum() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editForum");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ForumCURDController controller = (ForumCURDController) context.getBean("ForumController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveForum()</code>.
	 * @generated
	 *
	 * TO AVOID LOSING MANUAL CHANGES, turn generation off for this file or method.
	 * Generation of the entire file can be disabled on the Code Generation tab of the Spring DSL editor.
	 * Alternately, you can add the NOT keyword after the @generated annotation above the class declaration.
	 * Add the NOT keyword after the @generated annotation on this method to preserve changes to this method only.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveForum() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveForum");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ForumCURDController controller = (ForumCURDController) context.getBean("ForumController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newForum()</code>.
	 * @generated
	 *
	 * TO AVOID LOSING MANUAL CHANGES, turn generation off for this file or method.
	 * Generation of the entire file can be disabled on the Code Generation tab of the Spring DSL editor.
	 * Alternately, you can add the NOT keyword after the @generated annotation above the class declaration.
	 * Add the NOT keyword after the @generated annotation on this method to preserve changes to this method only.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewForum() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newForum");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ForumCURDController controller = (ForumCURDController) context.getBean("ForumController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteForum()</code>.
	 * @generated
	 *
	 * TO AVOID LOSING MANUAL CHANGES, turn generation off for this file or method.
	 * Generation of the entire file can be disabled on the Code Generation tab of the Spring DSL editor.
	 * Alternately, you can add the NOT keyword after the @generated annotation above the class declaration.
	 * Add the NOT keyword after the @generated annotation on this method to preserve changes to this method only.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteForum() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteForum");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ForumCURDController controller = (ForumCURDController) context.getBean("ForumController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteForum()</code>.
	 * @generated
	 *
	 * TO AVOID LOSING MANUAL CHANGES, turn generation off for this file or method.
	 * Generation of the entire file can be disabled on the Code Generation tab of the Spring DSL editor.
	 * Alternately, you can add the NOT keyword after the @generated annotation above the class declaration.
	 * Add the NOT keyword after the @generated annotation on this method to preserve changes to this method only.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteForum() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteForum");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ForumCURDController controller = (ForumCURDController) context.getBean("ForumController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>forumControllerbinaryaction()</code>.
	 * @generated
	 *
	 * TO AVOID LOSING MANUAL CHANGES, turn generation off for this file or method.
	 * Generation of the entire file can be disabled on the Code Generation tab of the Spring DSL editor.
	 * Alternately, you can add the NOT keyword after the @generated annotation above the class declaration.
	 * Add the NOT keyword after the @generated annotation on this method to preserve changes to this method only.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetforumControllerbinaryaction() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/forumController/binary.action");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ForumCURDController controller = (ForumCURDController) context.getBean("ForumController");

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