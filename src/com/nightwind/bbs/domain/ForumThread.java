package com.nightwind.bbs.domain;

import java.io.Serializable;
import java.lang.StringBuilder;
import java.util.Calendar;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.*;
import javax.persistence.*;

/**
 * 
 * @generated
 */

@Entity
@NamedQueries({
		@NamedQuery(name = "findAllForumThreads", query = "select myForumThread from ForumThread myForumThread"),
		@NamedQuery(name = "findForumThreadByContent", query = "select myForumThread from ForumThread myForumThread where myForumThread.content = ?1"),
		@NamedQuery(name = "findForumThreadByCreateTime", query = "select myForumThread from ForumThread myForumThread where myForumThread.createTime = ?1"),
		@NamedQuery(name = "findForumThreadById", query = "select myForumThread from ForumThread myForumThread where myForumThread.id = ?1"),
		@NamedQuery(name = "findForumThreadByLastModified", query = "select myForumThread from ForumThread myForumThread where myForumThread.lastModified = ?1"),
		@NamedQuery(name = "findForumThreadByPrimaryKey", query = "select myForumThread from ForumThread myForumThread where myForumThread.id = ?1"),
		@NamedQuery(name = "findForumThreadByTitle", query = "select myForumThread from ForumThread myForumThread where myForumThread.title = ?1"),
		@NamedQuery(name = "findForumThreadByTitleContaining", query = "select myForumThread from ForumThread myForumThread where myForumThread.title like ?1") })
@Table(catalog = "bbs", name = "thread")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "bbs/com/nightwind/bbs/domain", name = "ForumThread")
@XmlRootElement(namespace = "bbs/com/nightwind/bbs/domain")
public class ForumThread implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */

	@Column(name = "id", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@XmlElement
	Integer id;
	/**
	 * 
	 */

	@Column(name = "title", length = 45, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String title;
	/**
	 * 
	 */

	@Column(name = "content", nullable = false, columnDefinition = "MEDIUMTEXT")
	@Basic(fetch = FetchType.EAGER)
	@Lob
	@XmlElement
	String content;
	/**
	 * 
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_time", insertable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar createTime;
	/**
	 * 
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_modified", insertable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar lastModified;

	/**
	 * 
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "user_id", referencedColumnName = "id") })
	@XmlTransient
	User user;
	/**
	 * 
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "forum_id", referencedColumnName = "id", nullable = false) })
	@XmlTransient
	Forum forum;
	/**
	 * 
	 */
	@OneToMany(mappedBy = "forumThread", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<com.nightwind.bbs.domain.Comment> comments;

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
	public void setLastModified(Calendar lastModified) {
		this.lastModified = lastModified;
	}

	/**
	 * @generated
	 */
	public Calendar getLastModified() {
		return this.lastModified;
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
	public void setForum(Forum forum) {
		this.forum = forum;
	}

	/**
	 * @generated
	 */
	public Forum getForum() {
		return forum;
	}

	/**
	 * @generated
	 */
	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	/**
	 * @generated
	 */
	public Set<Comment> getComments() {
		if (comments == null) {
			comments = new java.util.LinkedHashSet<com.nightwind.bbs.domain.Comment>();
		}
		return comments;
	}

	/**
	 * @generated
	 */
	public ForumThread() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 * @generated
	 */
	public void copy(ForumThread that) {
		setId(that.getId());
		setTitle(that.getTitle());
		setContent(that.getContent());
		setCreateTime(that.getCreateTime());
		setLastModified(that.getLastModified());
		setUser(that.getUser());
		setForum(that.getForum());
		setComments(new java.util.LinkedHashSet<com.nightwind.bbs.domain.Comment>(that.getComments()));
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
		buffer.append("lastModified=[").append(lastModified).append("] ");

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
		if (!(obj instanceof ForumThread))
			return false;
		ForumThread equalCheck = (ForumThread) obj;
		if ((id == null && equalCheck.id != null) || (id != null && equalCheck.id == null))
			return false;
		if (id != null && !id.equals(equalCheck.id))
			return false;
		return true;
	}
}
