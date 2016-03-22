package com.nightwind.bbs.dao;

import com.nightwind.bbs.domain.ForumThread;

import org.junit.Test;

import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.test.annotation.Rollback;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;

import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import org.springframework.transaction.annotation.Transactional;

/**
 * Class used to test the basic Data Store Functionality
 *
 * @generated
 * @AuxiliaryModelComponent
 */

@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({
		DependencyInjectionTestExecutionListener.class,
		DirtiesContextTestExecutionListener.class,
		TransactionalTestExecutionListener.class })
@Transactional
@ContextConfiguration(locations = {
		"file:./src/bbs-security-context.xml",
		"file:./src/bbs-service-context.xml",
		"file:./src/bbs-dao-context.xml",
		"file:./src/bbs-web-context.xml" })
public class ForumThreadDAOTest {
	/**
	 * The DAO being tested, injected by Spring
	 *
	 * @generated
	 */
	private ForumThreadDAO dataStore;

	/**
	 * Instantiates a new ForumThreadDAOTest.
	 *
	 * @generated
	 */
	public ForumThreadDAOTest() {
	}

	/**
	 * Method to test ForumThread domain object.
	 *
	 * @generated
	 */
	@Rollback(false)
	@Test
	public void ForumThread() {
		ForumThread instance = new ForumThread();

		// Test create				
		// TODO: Populate instance for create.  The store will fail if the primary key fields are blank.				

		// store the object
		dataStore.store(instance);

		// Test update
		// TODO: Modify non-key domain object values for update

		// update the object
		dataStore.store(instance);

		// Test delete
		dataStore.remove(instance);

	}

	/**
	 * Method to allow Spring to inject the DAO that will be tested
	 *
	 * @generated
	 */
	@Autowired
	public void setDataStore(ForumThreadDAO dataStore) {
		this.dataStore = dataStore;
	}
}
