package com.nightwind.bbs.service;

import java.util.List;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nightwind.bbs.dao.ReplyDAO;
import com.nightwind.bbs.dao.TopicDAO;
import com.nightwind.bbs.domain.Reply;
import com.nightwind.bbs.domain.Topic;
import com.nightwind.bbs.exception.TopicNotFoundException;

@Service("TopicService")
public class TopicServiceImpl implements TopicService {

	@Autowired
	private TopicDAO topicDAO;
	
	@Autowired
	private ReplyDAO replyDAO;
	
	@Override
	public Topic findTopicByPrimaryKey(Integer id) {
		return topicDAO.findTopicByPrimaryKey(id);
	}

	@Override
	public Topic newTopic(Topic topic) {
		topic.setId(null);
		topic = topicDAO.store(topic);
		topicDAO.refresh(topic);		
		return topic;
	}
	
	@Override
	public Integer increaseClick(Integer id) throws TopicNotFoundException {
		Topic topic = findTopicByPrimaryKey(id);
		if (topic == null) {
			throw new TopicNotFoundException();
		}
		topic.setClicks(topic.getClicks() + 1);
		topic = topicDAO.store(topic);
//		topicDAO.flush();
//		topicDAO.refresh(topic);
		return topic.getClicks();
	}

	@Override
	public List<Topic> findHotTopicsByClicks(Integer startIndex,
			Integer maxCount) {
		return topicDAO.executeQuery("Select t From Topic t order by clicks desc", startIndex, maxCount);
	}
	
	@Override 
	public Long countTopics(Integer forumId) {
		if (forumId == 0) {
			return (long) 0;
		}
		if (forumId == -1) {
			return (Long) topicDAO.executeQuerySingleResult("select count(t) from Topic t");	
		}
		Query query = topicDAO.createQuerySingleResult("select count(t) from Topic t where id = ?1", forumId); 
		return (Long) query.getSingleResult();
	}

//	@Override
//	public Reply newTopicReply(Integer topicId, Integer userId, Reply reply) {
//		reply.setId(null);
//		Topic topic = topicDAO.findTopicByPrimaryKey(topicId);
//		topic.getReplies().add(reply);
//		
//		reply = replyDAO.store(reply);
//		replyDAO.refresh(reply);
////		topicDAO.refresh(topic);
//		
//		return reply;
//	}

}
