package com.nightwind.bbs.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nightwind.bbs.dao.TopicDAO;
import com.nightwind.bbs.domain.Topic;
import com.nightwind.bbs.exception.TopicNotFoundException;

@Service("TopicService")
public class TopicServiceImpl implements TopicService {
	
	@Autowired
	private TopicDAO topicDAO;
	
	
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
		topicDAO.flush();
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

	@Override
	public Topic deleteTopic(Integer topicId) throws TopicNotFoundException {
		Topic topic = findTopicByPrimaryKey(topicId);
		if (topic == null) {
			throw new TopicNotFoundException();
		}
		topicDAO.remove(topic);
		topicDAO.flush();
		return topic;
	}
	
	static boolean isNotBlank(String str) {
		return str != null && str.trim().length() > 0;
	}

	@Override
	public List<Topic> findTopicLike(Topic topic, int startResult,
			Integer maxRows) {
		String queryString = "select t from Topic t where str(t.id) like ?1 and t.title like ?2";
		String id = "%";
		String title = "%";
		
		if (topic.getId() != null) {
			id = String.valueOf(topic.getId());
		}
		
		if (isNotBlank( topic.getTitle())) {
			title = "%" + topic.getTitle() + "%";
		}
		
		return new ArrayList<Topic>(topicDAO.executeQuery(queryString, startResult, maxRows,
				id, title));		
	}

	@Override
	public Long countTopicLike(Topic topic) {
		String queryString = "select count(t) from Topic t where str(t.id) like ?1 and t.title like ?2";
		String id = "%";
		String title = "%";
		
		if (topic.getId() != null) {
			id = String.valueOf(topic.getId());
		}
		
		if (!isNotBlank( topic.getTitle())) {
			title = "%" + topic.getTitle() + "%";
		}
		Query query = topicDAO.createQuerySingleResult(queryString, id, title);
		return (Long)query.getSingleResult();
	}
}
