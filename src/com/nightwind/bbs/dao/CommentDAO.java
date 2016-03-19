package com.nightwind.bbs.dao;

import com.nightwind.bbs.domain.Comment;

import java.util.Calendar;
import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

/**
 * DAO to manage Comment entities.
 * 
 * @ModelCoreReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/CommentDAO/.properties.datastore]
 * @generated
 * @AuxiliaryModelComponent
 */
public interface CommentDAO extends JpaDao<Comment> {

	/**
	 * JPQL Query - findCommentById
	 *
	 * @ModelCoreReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/CommentDAO/findCommentById.query]JPASelect
	 */
	public Comment findCommentById(Integer id) throws DataAccessException;

	/**
	 * JPQL Query - findCommentById
	 *
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/CommentDAO/findCommentById.query]JPASelectWithPagination
	 */
	public Comment findCommentById(Integer id, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findCommentByPrimaryKey
	 *
	 * @ModelCoreReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/CommentDAO/findCommentByPrimaryKey.query]JPASelect
	 */
	public Comment findCommentByPrimaryKey(Integer id_1) throws DataAccessException;

	/**
	 * JPQL Query - findCommentByPrimaryKey
	 *
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/CommentDAO/findCommentByPrimaryKey.query]JPASelectWithPagination
	 */
	public Comment findCommentByPrimaryKey(Integer id_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllComments
	 *
	 * @ModelCoreReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/CommentDAO/findAllComments.query]JPASelect
	 */
	public Set<Comment> findAllComments() throws DataAccessException;

	/**
	 * JPQL Query - findAllComments
	 *
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/CommentDAO/findAllComments.query]JPASelectWithPagination
	 */
	public Set<Comment> findAllComments(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findCommentByTitle
	 *
	 * @ModelCoreReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/CommentDAO/findCommentByTitle.query]JPASelect
	 */
	public Set<Comment> findCommentByTitle(String title) throws DataAccessException;

	/**
	 * JPQL Query - findCommentByTitle
	 *
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/CommentDAO/findCommentByTitle.query]JPASelectWithPagination
	 */
	public Set<Comment> findCommentByTitle(String title, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findCommentByTitleContaining
	 *
	 * @ModelCoreReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/CommentDAO/findCommentByTitleContaining.query]JPASelect
	 */
	public Set<Comment> findCommentByTitleContaining(String title_1) throws DataAccessException;

	/**
	 * JPQL Query - findCommentByTitleContaining
	 *
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/CommentDAO/findCommentByTitleContaining.query]JPASelectWithPagination
	 */
	public Set<Comment> findCommentByTitleContaining(String title_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findCommentByContent
	 *
	 * @ModelCoreReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/CommentDAO/findCommentByContent.query]JPASelect
	 */
	public Set<Comment> findCommentByContent(String content1) throws DataAccessException;

	/**
	 * JPQL Query - findCommentByContent
	 *
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/CommentDAO/findCommentByContent.query]JPASelectWithPagination
	 */
	public Set<Comment> findCommentByContent(String content1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findCommentByCreateTime
	 *
	 * @ModelCoreReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/CommentDAO/findCommentByCreateTime.query]JPASelect
	 */
	public Set<Comment> findCommentByCreateTime(java.util.Calendar createTime) throws DataAccessException;

	/**
	 * JPQL Query - findCommentByCreateTime
	 *
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/dao/CommentDAO/findCommentByCreateTime.query]JPASelectWithPagination
	 */
	public Set<Comment> findCommentByCreateTime(Calendar createTime, int startResult, int maxRows) throws DataAccessException;

}