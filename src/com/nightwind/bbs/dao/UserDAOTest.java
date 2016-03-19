package com.nightwind.bbs.dao;

import java.util.List;
import java.util.UUID;

import com.nightwind.bbs.domain.User;

import org.junit.Ignore;
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
public class UserDAOTest {
	/**
	 * The DAO being tested, injected by Spring
	 *
	 * @generated
	 */
	private UserDAO dataStore;

	/**
	 * Instantiates a new UserDAOTest.
	 *
	 * @generated
	 */
	public UserDAOTest() {
	}

	/**
	 * Method to test User domain object.
	 *
	 * @generated
	 */
//	@Ignore
	@Rollback(false)
	@Test
	public void User() {
		User instance = new User();

		// Test create				
		// TODO: Populate instance for create.  The store will fail if the primary key fields are blank.	
		instance.setUsername(UUID.randomUUID().toString().substring(0, 16));
		instance.setPassword("pwd");

		// store the object
		instance = dataStore.store(instance);

		// Test update
		// TODO: Modify non-key domain object values for update

		// update the object
//		dataStore.store(instance);

		// Test delete
		dataStore.remove(instance);

	}
	
	@Test
	public void executeFind() {
		System.out.println("executeFind()");
		List<com.nightwind.bbs.domain.User> result = dataStore.executeQuery("SELECT u from User u WHERE u.id > ?1", 3);
		for (User user: result) {
			System.out.println(user.getUsername());
		}
		User user = (com.nightwind.bbs.domain.User) dataStore.executeQuerySingleResult("select u from User u where u.id = 11");
		System.out.println("user  : " + user.getUsername());
	}
	
	@Test
	public void findUser() {
		User user = dataStore.findUserByUsername("nw").iterator().next();
		System.out.println("user " + user);
	}
	
	@Test
	public void insertUser() {
		User user = new User();
		user.setUsername(UUID.randomUUID().toString().substring(0, 16));
		user.setPassword("pwd");
		// !! store调用merge()，返回一个managed状态的新实体！！
		user = dataStore.store(user);
		System.out.println("user id = " + user.getId() + " enabled = " + user.getEnabled());
		dataStore.remove(user);
	}

	/**
	 * Method to allow Spring to inject the DAO that will be tested
	 *
	 * @generated
	 */
	@Autowired
	public void setDataStore(UserDAO dataStore) {
		this.dataStore = dataStore;
	}
}
