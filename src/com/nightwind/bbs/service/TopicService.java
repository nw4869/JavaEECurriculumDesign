package com.nightwind.bbs.service;

import com.nightwind.bbs.domain.Reply;
import com.nightwind.bbs.domain.Topic;

public interface TopicService {

	Topic findTopicByPrimaryKey(Integer id);

	Topic newTopic(Topic topic);

//	Reply newTopicReply(Integer topicId, Integer userId, Reply reply);

}
