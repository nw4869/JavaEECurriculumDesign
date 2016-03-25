package com.nightwind.bbs.service;

import java.util.List;

import com.nightwind.bbs.domain.Topic;
import com.nightwind.bbs.exception.TopicNotFoundException;

public interface TopicService {

	Topic findTopicByPrimaryKey(Integer id);

	Topic newTopic(Topic topic);

	Integer increaseClick(Integer id) throws TopicNotFoundException;

//	Reply newTopicReply(Integer topicId, Integer userId, Reply reply);

	List<Topic> findHotTopicsByClicks(Integer startIndex, Integer maxCount);

	Long countTopics(Integer forumId);
	
	Topic deleteTopic(Integer topicId) throws TopicNotFoundException;
}
