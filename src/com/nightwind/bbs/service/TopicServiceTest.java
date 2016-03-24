package com.nightwind.bbs.service;

import static org.junit.Assert.fail;

import java.util.Date;
import java.util.List;

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

import com.nightwind.bbs.domain.Forum;
import com.nightwind.bbs.domain.Topic;
import com.nightwind.bbs.domain.User;
import com.nightwind.bbs.exception.TopicNotFoundException;


@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({
		DependencyInjectionTestExecutionListener.class,
		DirtiesContextTestExecutionListener.class,
		TransactionalTestExecutionListener.class })
@ContextConfiguration(locations = {
		"file:./src/bbs-service-context.xml",
		"file:./src/bbs-dao-context.xml"})
@Transactional
public class TopicServiceTest {
	
	@Autowired
	private TopicService topicService;

	@Test
	public void testFindTopicByPrimaryKey() {
		fail("Not yet implemented");
	}

	@Test
	public void testNewTopic() {
		Topic topic = new Topic();
		topic.setTitle("test1");
		topic.setContent("test");
		
		topic.setForum(new Forum(1));
		topic.setUser(new User(0));
		
		topicService.newTopic(topic);
	}
	
	@Test
	public void testFindHotTopic() {
		List<Topic> topics = topicService.findHotTopicsByClicks(-1, -1);
		System.out.println(topics);
	}
	
	@Test
	public void testGetLastActive() {
		Date time = topicService.findTopicByPrimaryKey(1).getLastActiveTime();
		System.out.println(time);
	}
	
	@Test
	public void testCount() {
		Long count = topicService.countTopics(1);
		System.out.println(count);
	}
	
	@Test
	public void testDelte() throws TopicNotFoundException {
		Topic topic = topicService.deleteTopic(6);
		System.out.println(topic);
	}

//	@Test
//	public void testNewTopicReply() {
//		int topicId = 1;
//		int userId = 1;
//		
//		Reply reply = new Reply();
//		reply.setTitle("t1");
//		reply.setContent("t2");
//		reply.setTopic(new Topic(topicId));
//		reply.setUser(new User(userId));
//		
//		reply = topicService.newTopicReply(topicId, userId, reply);
//		System.out.println(reply);
//		Topic topic = topicService.findTopicByPrimaryKey(topicId);
//		System.out.println(topic.getReplies().size());
//	}

}
