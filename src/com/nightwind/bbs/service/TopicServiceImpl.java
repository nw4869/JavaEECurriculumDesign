package com.nightwind.bbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nightwind.bbs.dao.ReplyDAO;
import com.nightwind.bbs.dao.TopicDAO;
import com.nightwind.bbs.domain.Reply;
import com.nightwind.bbs.domain.Topic;

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
