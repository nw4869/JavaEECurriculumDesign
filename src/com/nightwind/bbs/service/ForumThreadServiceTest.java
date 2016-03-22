package com.nightwind.bbs.service;

import com.nightwind.bbs.domain.Comment;
import com.nightwind.bbs.domain.Forum;
import com.nightwind.bbs.domain.ForumThread;
import com.nightwind.bbs.domain.User;

import java.util.List;
import java.util.Random;
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
public class ForumThreadServiceTest {

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
	protected ForumThreadService service;

	/**
	 * Instantiates a new ForumThreadServiceTest.
	 *
	 * @generated
	 */
	public ForumThreadServiceTest() {
		setupRequestContext();
	}

	/**
	 * Operation Unit Test
	 * Save an existing Forum entity
	 * 
	 * @generated
	 * TO AVOID LOSING MANUAL CHANGES, turn generation off for this file or method.
	 * Generation of the entire file can be disabled on the Code Generation tab of the Spring DSL editor.
	 * Alternately, you can add the NOT keyword after the @generated annotation above the class declaration.
	 * Add the NOT keyword after the @generated annotation on this method to preserve changes to this method only.
	 */
	@Test
	public void saveForumThreadForum() {
		// TODO: JUnit - Populate test inputs for operation: saveForumThreadForum 
		Integer id_3 = 0;
		Forum related_forum = new com.nightwind.bbs.domain.Forum();
		ForumThread response = null;
		response = service.saveForumThreadForum(id_3, related_forum);
		// TODO: JUnit - Add assertions to test outputs of operation: saveForumThreadForum
	}

	/**
	 * Operation Unit Test
	 * Load an existing ForumThread entity
	 * 
	 * @generated
	 * TO AVOID LOSING MANUAL CHANGES, turn generation off for this file or method.
	 * Generation of the entire file can be disabled on the Code Generation tab of the Spring DSL editor.
	 * Alternately, you can add the NOT keyword after the @generated annotation above the class declaration.
	 * Add the NOT keyword after the @generated annotation on this method to preserve changes to this method only.
	 */
	@Test
	public void loadForumThreads() {
		Set<ForumThread> response = null;
		response = service.loadForumThreads();
		// TODO: JUnit - Add assertions to test outputs of operation: loadForumThreads
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
	public void deleteForumThreadUser() {
		// TODO: JUnit - Populate test inputs for operation: deleteForumThreadUser 
		Integer forumthread_id_2 = 0;
		Integer related_user_id = 0;
		ForumThread response = null;
		response = service.deleteForumThreadUser(forumthread_id_2, related_user_id);
		// TODO: JUnit - Add assertions to test outputs of operation: deleteForumThreadUser
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
	public void deleteForumThread() {
		// TODO: JUnit - Populate test inputs for operation: deleteForumThread 
		ForumThread forumthread_1 = new com.nightwind.bbs.domain.ForumThread();
		service.deleteForumThread(forumthread_1);
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
	public void deleteForumThreadComments() {
		// TODO: JUnit - Populate test inputs for operation: deleteForumThreadComments 
		Integer forumthread_id = 0;
		Integer related_comments_id = 0;
		ForumThread response = null;
		response = service.deleteForumThreadComments(forumthread_id, related_comments_id);
		// TODO: JUnit - Add assertions to test outputs of operation: deleteForumThreadComments
	}

	/**
	 * Operation Unit Test
	 * Return a count of all ForumThread entity
	 * 
	 * @generated
	 * TO AVOID LOSING MANUAL CHANGES, turn generation off for this file or method.
	 * Generation of the entire file can be disabled on the Code Generation tab of the Spring DSL editor.
	 * Alternately, you can add the NOT keyword after the @generated annotation above the class declaration.
	 * Add the NOT keyword after the @generated annotation on this method to preserve changes to this method only.
	 */
	@Test
	public void countForumThreads() {
		Integer response = null;
		response = service.countForumThreads();
		// TODO: JUnit - Add assertions to test outputs of operation: countForumThreads
	}

	/**
	 * Operation Unit Test
	 * Return all ForumThread entity
	 * 
	 * @generated
	 * TO AVOID LOSING MANUAL CHANGES, turn generation off for this file or method.
	 * Generation of the entire file can be disabled on the Code Generation tab of the Spring DSL editor.
	 * Alternately, you can add the NOT keyword after the @generated annotation above the class declaration.
	 * Add the NOT keyword after the @generated annotation on this method to preserve changes to this method only.
	 */
	@Test
	public void findAllForumThreads() {
		// TODO: JUnit - Populate test inputs for operation: findAllForumThreads 
		Integer startResult = 0;
		Integer maxRows = 0;
		List<ForumThread> response = null;
		response = service.findAllForumThreads(startResult, maxRows);
		// TODO: JUnit - Add assertions to test outputs of operation: findAllForumThreads
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
	public void saveForumThreadUser() {
		// TODO: JUnit - Populate test inputs for operation: saveForumThreadUser 
		Integer id = 0;
		User related_user = new com.nightwind.bbs.domain.User();
		ForumThread response = null;
		response = service.saveForumThreadUser(id, related_user);
		// TODO: JUnit - Add assertions to test outputs of operation: saveForumThreadUser
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
	public void findForumThreadByPrimaryKey() {
		// TODO: JUnit - Populate test inputs for operation: findForumThreadByPrimaryKey 
		Integer id_1 = 0;
		ForumThread response = null;
		response = service.findForumThreadByPrimaryKey(id_1);
		// TODO: JUnit - Add assertions to test outputs of operation: findForumThreadByPrimaryKey
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Forum entity
	 * 
	 * @generated
	 * TO AVOID LOSING MANUAL CHANGES, turn generation off for this file or method.
	 * Generation of the entire file can be disabled on the Code Generation tab of the Spring DSL editor.
	 * Alternately, you can add the NOT keyword after the @generated annotation above the class declaration.
	 * Add the NOT keyword after the @generated annotation on this method to preserve changes to this method only.
	 */
	@Test
	public void deleteForumThreadForum() {
		// TODO: JUnit - Populate test inputs for operation: deleteForumThreadForum 
		Integer forumthread_id_1 = 0;
		Integer related_forum_id = 0;
		ForumThread response = null;
		response = service.deleteForumThreadForum(forumthread_id_1, related_forum_id);
		// TODO: JUnit - Add assertions to test outputs of operation: deleteForumThreadForum
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
	public void saveForumThread() {
		ForumThread forumthread = new com.nightwind.bbs.domain.ForumThread();
		forumthread.setTitle("title_test");
		forumthread.setContent("content_test");
		User user = new User();
		user.setId(1);
		Forum forum = new Forum();
		forum.setId(1);
		forumthread.setForum(forum);
		forumthread.setUser(user);
		service.saveForumThread(forumthread);
	}
	
	@Test
	public void update() {
		ForumThread topic = service.findForumThreadByPrimaryKey(3);
		topic.setContent("content_new_test"+new Random().nextInt());
		service.saveForumThread(topic);
		System.out.println(topic.getLastModified().getTime());
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
	public void saveForumThreadComments() {
		// TODO: JUnit - Populate test inputs for operation: saveForumThreadComments 
		Integer id_2 = 0;
		Comment related_comments = new com.nightwind.bbs.domain.Comment();
		ForumThread response = null;
		response = service.saveForumThreadComments(id_2, related_comments);
		// TODO: JUnit - Add assertions to test outputs of operation: saveForumThreadComments
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
