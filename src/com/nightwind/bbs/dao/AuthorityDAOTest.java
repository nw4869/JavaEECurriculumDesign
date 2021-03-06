package com.nightwind.bbs.dao;

import static org.junit.Assert.*;

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

import com.nightwind.bbs.domain.Authority;
import com.nightwind.bbs.domain.Forum;
import com.nightwind.bbs.domain.User;

/**
 * Class used to test the basic Data Store Functionality
 *
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
public class AuthorityDAOTest {
	/**
	 * The DAO being tested, injected by Spring
	 *
	 */
	private AuthorityDAO dataStore;

	/**
	 * Instantiates a new AuthorityDAOTest.
	 *
	 */
	public AuthorityDAOTest() {
	}

	/**
	 * Method to test Authority domain object.
	 *
	 */
	@Rollback(false)
	@Test
	public void Authority() {
		Authority instance = new Authority();

		// Test create				
		instance.setUser(new User(1));
		instance.setAuthorityField("ROLE_FORUM_ADMIN");

		// store the object
		instance = dataStore.store(instance);
		assertEquals(instance.getUser().getId() == 1, true);

		// Test update
		instance.setForum(new Forum(1));
		assertEquals(instance.getForum().getId() == 1, true);

		// update the object
		dataStore.store(instance);

		// Test delete
		dataStore.remove(instance);
	}
	
	@Test
	public void testAdmin() {
		Authority au = new Authority(); 
		au.setUser(new User(1));
		au.setAuthorityField("ROLE_ADMIN");
		
		au = dataStore.store(au);
		dataStore.flush();
		dataStore.refresh(au);
//		System.out.println(au);
//		System.out.println(au.getForum());
		assertEquals(au.getForum(), null);
	}
	
	@Test
	public void testUpdate() {
		dataStore.createQuerySingleResult("update Authority set forum.id=2 where id=1").executeUpdate();
	}
	
	/**
	 * Method to allow Spring to inject the DAO that will be tested
	 *
	 */
	@Autowired
	public void setDataStore(AuthorityDAO dataStore) {
		this.dataStore = dataStore;
	}
}
