package com.nightwind.bbs.dao;

import java.util.List;

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

import com.nightwind.bbs.domain.Mail;
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
public class MailDAOTest {
	/**
	 * The DAO being tested, injected by Spring
	 *
	 */
	private MailDAO dataStore;

	/**
	 * Instantiates a new MailDAOTest.
	 *
	 */
	public MailDAOTest() {
	}

	/**
	 * Method to test Mail domain object.
	 *
	 */
	@Rollback(false)
	@Test
	public void Mail() {
		Mail instance = new Mail();

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
	
	@Test
	public void testSendMail() {
		Mail mail = new Mail();
		User recvUser = new User();
		recvUser.setId(1);
		User sendUser = new User();
		sendUser.setId(2);
		mail.setReciver(recvUser);
		mail.setSender(sendUser);
		mail.setTitle("t");
		mail.setContent("c");
		
		mail = dataStore.store(mail);
		dataStore.refresh(mail);
		System.out.println(mail);
	}
	
	@Test
	public void testSendMail1() {
		int result = dataStore.createQuery("update Mail set read=1 where id=1", -1, -1).executeUpdate();
		System.out.println(result);
	}

	/**
	 * Method to allow Spring to inject the DAO that will be tested
	 *
	 */
	@Autowired
	public void setDataStore(MailDAO dataStore) {
		this.dataStore = dataStore;
	}
}
