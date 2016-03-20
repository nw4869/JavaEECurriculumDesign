package com.nightwind.bbs.dao;

import com.nightwind.bbs.domain.Comment;

import java.util.Calendar;
import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

/**
 * DAO to manage Comment entities.
 * 
 * 
 * @generated
 * @AuxiliaryModelComponent
 */
public interface CommentDAO extends JpaDao<Comment> {

	/**
	 * JPQL Query - findCommentById
	 *
	 * JPASelect
	 */
	public Comment findCommentById(Integer id) throws DataAccessException;

	/**
	 * JPQL Query - findCommentById
	 *
	 * JPASelectWithPagination
	 */
	public Comment findCommentById(Integer id, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findCommentByPrimaryKey
	 *
	 * JPASelect
	 */
	public Comment findCommentByPrimaryKey(Integer id_1) throws DataAccessException;

	/**
	 * JPQL Query - findCommentByPrimaryKey
	 *
	 * JPASelectWithPagination
	 */
	public Comment findCommentByPrimaryKey(Integer id_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllComments
	 *
	 * JPASelect
	 */
	public Set<Comment> findAllComments() throws DataAccessException;

	/**
	 * JPQL Query - findAllComments
	 *
	 * JPASelectWithPagination
	 */
	public Set<Comment> findAllComments(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findCommentByTitle
	 *
	 * JPASelect
	 */
	public Set<Comment> findCommentByTitle(String title_1) throws DataAccessException;

	/**
	 * JPQL Query - findCommentByTitle
	 *
	 * JPASelectWithPagination
	 */
	public Set<Comment> findCommentByTitle(String title_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findCommentByTitleContaining
	 *
	 * JPASelect
	 */
	public Set<Comment> findCommentByTitleContaining(String title) throws DataAccessException;

	/**
	 * JPQL Query - findCommentByTitleContaining
	 *
	 * JPASelectWithPagination
	 */
	public Set<Comment> findCommentByTitleContaining(String title, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findCommentByContent
	 *
	 * JPASelect
	 */
	public Set<Comment> findCommentByContent(String content1) throws DataAccessException;

	/**
	 * JPQL Query - findCommentByContent
	 *
	 * JPASelectWithPagination
	 */
	public Set<Comment> findCommentByContent(String content1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findCommentByCreateTime
	 *
	 * JPASelect
	 */
	public Set<Comment> findCommentByCreateTime(java.util.Calendar createTime) throws DataAccessException;

	/**
	 * JPQL Query - findCommentByCreateTime
	 *
	 * JPASelectWithPagination
	 */
	public Set<Comment> findCommentByCreateTime(Calendar createTime, int startResult, int maxRows) throws DataAccessException;

}