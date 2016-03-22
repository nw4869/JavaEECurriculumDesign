package com.nightwind.bbs.domain;

import java.io.Serializable;
import java.lang.StringBuilder;
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
		@NamedQuery(name = "findAllForums", query = "select myForum from Forum myForum"),
		@NamedQuery(name = "findForumByDescription", query = "select myForum from Forum myForum where myForum.description = ?1"),
		@NamedQuery(name = "findForumByDescriptionContaining", query = "select myForum from Forum myForum where myForum.description like ?1"),
		@NamedQuery(name = "findForumById", query = "select myForum from Forum myForum where myForum.id = ?1"),
		@NamedQuery(name = "findForumByPrimaryKey", query = "select myForum from Forum myForum where myForum.id = ?1"),
		@NamedQuery(name = "findForumByTitle", query = "select myForum from Forum myForum where myForum.title = ?1"),
		@NamedQuery(name = "findForumByTitleContaining", query = "select myForum from Forum myForum where myForum.title like ?1") })
@Table(catalog = "bbs", name = "forum")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "bbs/com/nightwind/bbs/domain", name = "Forum")
@XmlRootElement(namespace = "bbs/com/nightwind/bbs/domain")
public class Forum implements Serializable {
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

	@Column(name = "description")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String description;

	/**
	 * 
	 */
	@OneToMany(mappedBy = "forum", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<com.nightwind.bbs.domain.ForumThread> forumThreads;

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
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @generated
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * @generated
	 */
	public void setForumThreads(Set<ForumThread> forumThreads) {
		this.forumThreads = forumThreads;
	}

	/**
	 * @generated
	 */
	public Set<ForumThread> getForumThreads() {
		if (forumThreads == null) {
			forumThreads = new java.util.LinkedHashSet<com.nightwind.bbs.domain.ForumThread>();
		}
		return forumThreads;
	}

	/**
	 * @generated
	 */
	public Forum() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 * @generated
	 */
	public void copy(Forum that) {
		setId(that.getId());
		setTitle(that.getTitle());
		setDescription(that.getDescription());
		setForumThreads(new java.util.LinkedHashSet<com.nightwind.bbs.domain.ForumThread>(that.getForumThreads()));
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
		buffer.append("description=[").append(description).append("] ");

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
		if (!(obj instanceof Forum))
			return false;
		Forum equalCheck = (Forum) obj;
		if ((id == null && equalCheck.id != null) || (id != null && equalCheck.id == null))
			return false;
		if (id != null && !id.equals(equalCheck.id))
			return false;
		return true;
	}
}
