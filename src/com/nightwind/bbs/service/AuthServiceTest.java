package com.nightwind.bbs.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({
		DependencyInjectionTestExecutionListener.class,
		DirtiesContextTestExecutionListener.class,
		TransactionalTestExecutionListener.class })
@ContextConfiguration(locations = {
		"file:./src/bbs-service-context.xml",
		"file:./src/bbs-dao-context.xml"})
@Transactional
public class AuthServiceTest {

	@Autowired
	private AuthService authService;
	
	@Test
	public void testIsAdmin() {
		Integer id = null;
		assertEquals(authService.isAdmin(id), false);
	}
	
	@Test
	public void testIsForumAdmin() {
		Integer id = null;
		assertEquals(authService.isForumAdmin(1, id), false);
	}

	@Test
	public void testIsForumAdmin1() {
		Integer fourmId = null;
		Integer id = null;
		assertEquals(authService.isForumAdmin(fourmId, id), false);
	}

	@Test
	public void testIsForumAdmin2() {
		Integer fourmId = 1;
		Integer id = 2;
		assertEquals(authService.isForumAdmin(fourmId, id), true);
	}

}
