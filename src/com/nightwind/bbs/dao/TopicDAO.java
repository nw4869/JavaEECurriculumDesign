package com.nightwind.bbs.dao;

import com.nightwind.bbs.domain.Topic;

import java.util.Calendar;
import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

/**
 * DAO to manage Topic entities.
 * 
 */
public interface TopicDAO extends JpaDao<Topic> {

	/**
	 * JPQL Query - findTopicByPin
	 *
	 */
	public Set<Topic> findTopicByPin(Boolean pin) throws DataAccessException;

	/**
	 * JPQL Query - findTopicByPin
	 *
	 */
	public Set<Topic> findTopicByPin(Boolean pin, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTopicByTitleContaining
	 *
	 */
	public Set<Topic> findTopicByTitleContaining(String title) throws DataAccessException;

	/**
	 * JPQL Query - findTopicByTitleContaining
	 *
	 */
	public Set<Topic> findTopicByTitleContaining(String title, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTopicById
	 *
	 */
	public Topic findTopicById(Integer id) throws DataAccessException;

	/**
	 * JPQL Query - findTopicById
	 *
	 */
	public Topic findTopicById(Integer id, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTopicByTitle
	 *
	 */
	public Set<Topic> findTopicByTitle(String title_1) throws DataAccessException;

	/**
	 * JPQL Query - findTopicByTitle
	 *
	 */
	public Set<Topic> findTopicByTitle(String title_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTopicByLastModified
	 *
	 */
	public Set<Topic> findTopicByLastModified(java.util.Calendar lastModified) throws DataAccessException;

	/**
	 * JPQL Query - findTopicByLastModified
	 *
	 */
	public Set<Topic> findTopicByLastModified(Calendar lastModified, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTopicByContent
	 *
	 */
	public Set<Topic> findTopicByContent(String content) throws DataAccessException;

	/**
	 * JPQL Query - findTopicByContent
	 *
	 */
	public Set<Topic> findTopicByContent(String content, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTopicByPrimaryKey
	 *
	 */
	public Topic findTopicByPrimaryKey(Integer id_1) throws DataAccessException;

	/**
	 * JPQL Query - findTopicByPrimaryKey
	 *
	 */
	public Topic findTopicByPrimaryKey(Integer id_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTopicByCreateTime
	 *
	 */
	public Set<Topic> findTopicByCreateTime(java.util.Calendar createTime) throws DataAccessException;

	/**
	 * JPQL Query - findTopicByCreateTime
	 *
	 */
	public Set<Topic> findTopicByCreateTime(Calendar createTime, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllTopics
	 *
	 */
	public Set<Topic> findAllTopics() throws DataAccessException;

	/**
	 * JPQL Query - findAllTopics
	 *
	 */
	public Set<Topic> findAllTopics(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTopicByClicks
	 *
	 */
	public Set<Topic> findTopicByClicks(Integer clicks) throws DataAccessException;

	/**
	 * JPQL Query - findTopicByClicks
	 *
	 */
	public Set<Topic> findTopicByClicks(Integer clicks, int startResult, int maxRows) throws DataAccessException;

}