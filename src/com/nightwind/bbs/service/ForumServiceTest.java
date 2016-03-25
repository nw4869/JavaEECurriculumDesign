package com.nightwind.bbs.service;

import java.util.Date;

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

import com.nightwind.bbs.exception.ForumNotFoundException;

@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({
		DependencyInjectionTestExecutionListener.class,
		DirtiesContextTestExecutionListener.class,
		TransactionalTestExecutionListener.class })
@ContextConfiguration(locations = {
		"file:./src/bbs-service-context.xml",
		"file:./src/bbs-dao-context.xml"})
@Transactional
public class ForumServiceTest {
	
	@Autowired
	private ForumService forumService;

	@Test
	public void testLastActiveTime() throws ForumNotFoundException {
		Date date = forumService.getLastActiveTime(2);
		System.out.println(date);
	}

	@Test 
	public void testCountReplies() throws ForumNotFoundException {
		Long count = forumService.getTotalReplyCount(2);
		System.out.println(count);
	}
}
