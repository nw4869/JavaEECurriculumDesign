package com.nightwind.bbs.service;

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
public class CommentServiceTest {

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
	protected CommentService service;

	/**
	 * Instantiates a new CommentServiceTest.
	 *
	 * @generated
	 */
	public CommentServiceTest() {
		setupRequestContext();
	}

	/**
	 * Operation Unit Test
	 * Return all Comment entity
	 * 
	 * @generated
	 * TO AVOID LOSING MANUAL CHANGES, turn generation off for this file or method.
	 * Generation of the entire file can be disabled on the Code Generation tab of the Spring DSL editor.
	 * Alternately, you can add the NOT keyword after the @generated annotation above the class declaration.
	 * Add the NOT keyword after the @generated annotation on this method to preserve changes to this method only.
	 */
	@Test
	public void findAllComments() {
		// TODO: JUnit - Populate test inputs for operation: findAllComments 
		Integer startResult = 0;
		Integer maxRows = 0;
		List<Comment> response = null;
		response = service.findAllComments(startResult, maxRows);
		// TODO: JUnit - Add assertions to test outputs of operation: findAllComments
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
	public void deleteComment() {
		// TODO: JUnit - Populate test inputs for operation: deleteComment 
		Comment comment_1 = new com.nightwind.bbs.domain.Comment();
		service.deleteComment(comment_1);
	}

	/**
	 * Operation Unit Test
	 * Return a count of all Comment entity
	 * 
	 * @generated
	 * TO AVOID LOSING MANUAL CHANGES, turn generation off for this file or method.
	 * Generation of the entire file can be disabled on the Code Generation tab of the Spring DSL editor.
	 * Alternately, you can add the NOT keyword after the @generated annotation above the class declaration.
	 * Add the NOT keyword after the @generated annotation on this method to preserve changes to this method only.
	 */
	@Test
	public void countComments() {
		Integer response = null;
		response = service.countComments();
		// TODO: JUnit - Add assertions to test outputs of operation: countComments
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
	public void deleteCommentUser() {
		// TODO: JUnit - Populate test inputs for operation: deleteCommentUser 
		Integer comment_id = 0;
		Integer related_user_id = 0;
		Comment response = null;
		response = service.deleteCommentUser(comment_id, related_user_id);
		// TODO: JUnit - Add assertions to test outputs of operation: deleteCommentUser
	}

	/**
	 * Operation Unit Test
	 * Load an existing Comment entity
	 * 
	 * @generated
	 * TO AVOID LOSING MANUAL CHANGES, turn generation off for this file or method.
	 * Generation of the entire file can be disabled on the Code Generation tab of the Spring DSL editor.
	 * Alternately, you can add the NOT keyword after the @generated annotation above the class declaration.
	 * Add the NOT keyword after the @generated annotation on this method to preserve changes to this method only.
	 */
	@Test
	public void loadComments() {
		Set<Comment> response = null;
		response = service.loadComments();
		// TODO: JUnit - Add assertions to test outputs of operation: loadComments
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
	public void saveComment() {
		// TODO: JUnit - Populate test inputs for operation: saveComment 
		Comment comment = new com.nightwind.bbs.domain.Comment();
		service.saveComment(comment);
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
	public void saveCommentForumThread() {
		// TODO: JUnit - Populate test inputs for operation: saveCommentForumThread 
		Integer id_2 = 0;
		ForumThread related_forumthread = new com.nightwind.bbs.domain.ForumThread();
		Comment response = null;
		response = service.saveCommentForumThread(id_2, related_forumthread);
		// TODO: JUnit - Add assertions to test outputs of operation: saveCommentForumThread
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
	public void saveCommentUser() {
		// TODO: JUnit - Populate test inputs for operation: saveCommentUser 
		Integer id = 0;
		User related_user = new com.nightwind.bbs.domain.User();
		Comment response = null;
		response = service.saveCommentUser(id, related_user);
		// TODO: JUnit - Add assertions to test outputs of operation: saveCommentUser
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
	public void findCommentByPrimaryKey() {
		// TODO: JUnit - Populate test inputs for operation: findCommentByPrimaryKey 
		Integer id_1 = 0;
		Comment response = null;
		response = service.findCommentByPrimaryKey(id_1);
		// TODO: JUnit - Add assertions to test outputs of operation: findCommentByPrimaryKey
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
	public void deleteCommentForumThread() {
		// TODO: JUnit - Populate test inputs for operation: deleteCommentForumThread 
		Integer comment_id_1 = 0;
		Integer related_forumthread_id = 0;
		Comment response = null;
		response = service.deleteCommentForumThread(comment_id_1, related_forumthread_id);
		// TODO: JUnit - Add assertions to test outputs of operation: deleteCommentForumThread
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
