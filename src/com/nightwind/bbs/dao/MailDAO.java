package com.nightwind.bbs.dao;

import com.nightwind.bbs.domain.Mail;

import java.util.Calendar;
import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

/**
 * DAO to manage Mail entities.
 * 
 */
public interface MailDAO extends JpaDao<Mail> {

	/**
	 * JPQL Query - findMailById
	 *
	 */
	public Mail findMailById(Integer id) throws DataAccessException;

	/**
	 * JPQL Query - findMailById
	 *
	 */
	public Mail findMailById(Integer id, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findMailByPrimaryKey
	 *
	 */
	public Mail findMailByPrimaryKey(Integer id_1) throws DataAccessException;

	/**
	 * JPQL Query - findMailByPrimaryKey
	 *
	 */
	public Mail findMailByPrimaryKey(Integer id_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findMailByTitle
	 *
	 */
	public Set<Mail> findMailByTitle(String title) throws DataAccessException;

	/**
	 * JPQL Query - findMailByTitle
	 *
	 */
	public Set<Mail> findMailByTitle(String title, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllMails
	 *
	 */
	public Set<Mail> findAllMails() throws DataAccessException;

	/**
	 * JPQL Query - findAllMails
	 *
	 */
	public Set<Mail> findAllMails(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findMailBySendTime
	 *
	 */
	public Set<Mail> findMailBySendTime(java.util.Calendar sendTime) throws DataAccessException;

	/**
	 * JPQL Query - findMailBySendTime
	 *
	 */
	public Set<Mail> findMailBySendTime(Calendar sendTime, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findMailByRead
	 *
	 */
	public Set<Mail> findMailByRead(Boolean read) throws DataAccessException;

	/**
	 * JPQL Query - findMailByRead
	 *
	 */
	public Set<Mail> findMailByRead(Boolean read, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findMailByTitleContaining
	 *
	 */
	public Set<Mail> findMailByTitleContaining(String title_1) throws DataAccessException;

	/**
	 * JPQL Query - findMailByTitleContaining
	 *
	 */
	public Set<Mail> findMailByTitleContaining(String title_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findMailByContent
	 *
	 */
	public Set<Mail> findMailByContent(String content) throws DataAccessException;

	/**
	 * JPQL Query - findMailByContent
	 *
	 */
	public Set<Mail> findMailByContent(String content, int startResult, int maxRows) throws DataAccessException;

}