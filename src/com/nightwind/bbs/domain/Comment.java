package com.nightwind.bbs.domain;

import java.io.Serializable;

import java.lang.StringBuilder;

import java.util.Calendar;
import java.util.Set;

import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import javax.xml.bind.annotation.*;

import javax.persistence.*;

/**
 * @ModelCoreReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/domain/Comment.datatype]
 * @generated
 */

@Entity
@NamedQueries({
		@NamedQuery(name = "findAllComments", query = "select myComment from Comment myComment"),
		@NamedQuery(name = "findCommentByContent", query = "select myComment from Comment myComment where myComment.content = ?1"),
		@NamedQuery(name = "findCommentByCreateTime", query = "select myComment from Comment myComment where myComment.createTime = ?1"),
		@NamedQuery(name = "findCommentById", query = "select myComment from Comment myComment where myComment.id = ?1"),
		@NamedQuery(name = "findCommentByPrimaryKey", query = "select myComment from Comment myComment where myComment.id = ?1"),
		@NamedQuery(name = "findCommentByTitle", query = "select myComment from Comment myComment where myComment.title = ?1"),
		@NamedQuery(name = "findCommentByTitleContaining", query = "select myComment from Comment myComment where myComment.title like ?1") })
@Table(catalog = "bbs", name = "comment")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "bbs/com/nightwind/bbs/domain", name = "Comment")
public class Comment implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/domain/Comment.datatype#//@fields%5Bname='id'%5D]
	 */

	@Column(name = "id", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@XmlElement
	Integer id;
	/**
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/domain/Comment.datatype#//@fields%5Bname='title'%5D]
	 */

	@Column(name = "title", length = 45, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String title;
	/**
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/domain/Comment.datatype#//@fields%5Bname='content'%5D]
	 */

	@Column(name = "content", nullable = false, columnDefinition = "MEDIUMTEXT")
	@Basic(fetch = FetchType.EAGER)
	@Lob
	@XmlElement
	String content;
	/**
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/domain/Comment.datatype#//@fields%5Bname='createTime'%5D]
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_time", insertable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar createTime;

	/**
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/domain/Comment.datatype#//@relationships%5Bname='user'%5D]
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "user_id", referencedColumnName = "id") })
	@XmlTransient
	User user;
	/**
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/domain/Comment.datatype#//@relationships%5Bname='forumThread'%5D]
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "thread_id", referencedColumnName = "id", nullable = false) })
	@XmlTransient
	ForumThread forumThread;

	/**
	 * @generated
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @generated
	 */
	public Integer getId() {
		return this.id;
	}

	/**
	 * @generated
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @generated
	 */
	public String getTitle() {
		return this.title;
	}

	/**
	 * @generated
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @generated
	 */
	public String getContent() {
		return this.content;
	}

	/**
	 * @generated
	 */
	public void setCreateTime(Calendar createTime) {
		this.createTime = createTime;
	}

	/**
	 * @generated
	 */
	public Calendar getCreateTime() {
		return this.createTime;
	}

	/**
	 * @generated
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @generated
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @generated
	 */
	public void setForumThread(ForumThread forumThread) {
		this.forumThread = forumThread;
	}

	/**
	 * @generated
	 */
	public ForumThread getForumThread() {
		return forumThread;
	}

	/**
	 * @generated
	 */
	public Comment() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 * @generated
	 */
	public void copy(Comment that) {
		setId(that.getId());
		setTitle(that.getTitle());
		setContent(that.getContent());
		setCreateTime(that.getCreateTime());
		setUser(that.getUser());
		setForumThread(that.getForumThread());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 * @generated
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("id=[").append(id).append("] ");
		buffer.append("title=[").append(title).append("] ");
		buffer.append("content=[").append(content).append("] ");
		buffer.append("createTime=[").append(createTime).append("] ");

		return buffer.toString();
	}

	/**
	 * @generated
	 * @AuxiliaryModelComponent
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((id == null) ? 0 : id.hashCode()));
		return result;
	}

	/**
	 * @generated
	 * @AuxiliaryModelComponent
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Comment))
			return false;
		Comment equalCheck = (Comment) obj;
		if ((id == null && equalCheck.id != null) || (id != null && equalCheck.id == null))
			return false;
		if (id != null && !id.equals(equalCheck.id))
			return false;
		return true;
	}
}
