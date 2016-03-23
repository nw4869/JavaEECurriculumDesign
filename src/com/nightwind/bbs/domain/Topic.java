package com.nightwind.bbs.domain;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 */

@Entity
@NamedQueries({
		@NamedQuery(name = "findAllTopics", query = "select myTopic from Topic myTopic"),
		@NamedQuery(name = "findTopicByClicks", query = "select myTopic from Topic myTopic where myTopic.clicks = ?1"),
		@NamedQuery(name = "findTopicByContent", query = "select myTopic from Topic myTopic where myTopic.content = ?1"),
		@NamedQuery(name = "findTopicByCreateTime", query = "select myTopic from Topic myTopic where myTopic.createTime = ?1"),
		@NamedQuery(name = "findTopicById", query = "select myTopic from Topic myTopic where myTopic.id = ?1"),
		@NamedQuery(name = "findTopicByLastModified", query = "select myTopic from Topic myTopic where myTopic.lastModified = ?1"),
		@NamedQuery(name = "findTopicByPin", query = "select myTopic from Topic myTopic where myTopic.pin = ?1"),
		@NamedQuery(name = "findTopicByPrimaryKey", query = "select myTopic from Topic myTopic where myTopic.id = ?1"),
		@NamedQuery(name = "findTopicByTitle", query = "select myTopic from Topic myTopic where myTopic.title = ?1"),
		@NamedQuery(name = "findTopicByTitleContaining", query = "select myTopic from Topic myTopic where myTopic.title like ?1") })
@Table(catalog = "bbs", name = "topic")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "bbs/com/nightwind/bbs/domain", name = "Topic")
@XmlRootElement(namespace = "bbs/com/nightwind/bbs/domain")
public class Topic implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "id", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	@XmlElement
	Integer id;
	/**
	 */

	@Size(max=45)
	@Column(name = "title", length = 45, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String title;
	/**
	 */

	@NotBlank
	@Column(name = "content", nullable = false, columnDefinition = "MEDIUMTEXT")
	@Basic(fetch = FetchType.EAGER)
	@Lob
	@XmlElement
	String content;
	/**
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_time")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Date createTime;
	/**
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_modified")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Date lastModified;
	/**
	 */

	@Column(name = "clicks")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer clicks = 0;
	/**
	 */

	@Column(name = "pin")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer pin = 0;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_active_time", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Date lastActiveTime;
	
	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "last_active_user_id", referencedColumnName = "id") })
	@XmlTransient
	User lastActiveUser;

	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "user_id", referencedColumnName = "id") })
	@XmlTransient
	User user;
	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "forum_id", referencedColumnName = "id", nullable = false) })
	@XmlTransient
	Forum forum;
	/**
	 */
	@OneToMany(mappedBy = "topic", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@OrderBy("createTime desc")
	@XmlElement(name = "", namespace = "")
	java.util.Set<com.nightwind.bbs.domain.Reply> replies;

	/**
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 */
	public Integer getId() {
		return this.id;
	}

	/**
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 */
	public String getTitle() {
		return this.title;
	}

	/**
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 */
	public String getContent() {
		return this.content;
	}

	/**
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 */
	public Date getCreateTime() {
		return this.createTime;
	}

	/**
	 */
	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	/**
	 */
	public Date getLastModified() {
		return this.lastModified;
	}

	/**
	 */
	public void setClicks(Integer clicks) {
		this.clicks = clicks;
	}

	/**
	 */
	public Integer getClicks() {
		return this.clicks;
	}

	/**
	 */
	public void setPin(Integer pin) {
		this.pin = pin;
	}

	/**
	 */
	public Integer getPin() {
		return this.pin;
	}

	/**
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 */
	public User getUser() {
		return user;
	}

	/**
	 */
	public void setForum(Forum forum) {
		this.forum = forum;
	}

	/**
	 */
	public Forum getForum() {
		return forum;
	}
	

	public Date getLastActiveTime() {
		return lastActiveTime;
	}

	public void setLastActiveTime(Date lastActiveTime) {
		this.lastActiveTime = lastActiveTime;
	}

	public User getLastActiveUser() {
		return lastActiveUser;
	}

	public void setLastActiveUser(User lastActiveUser) {
		this.lastActiveUser = lastActiveUser;
	}

	/**
	 */
	public void setReplies(Set<Reply> replies) {
		this.replies = replies;
	}

	/**
	 */
	public Set<Reply> getReplies() {
		if (replies == null) {
			replies = new java.util.LinkedHashSet<com.nightwind.bbs.domain.Reply>();
		}
		return replies;
	}

	/**
	 */
	public Topic() {
	}

	public Topic(int topicId) {
		id = topicId;
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Topic that) {
		setId(that.getId());
		setTitle(that.getTitle());
		setContent(that.getContent());
		setCreateTime(that.getCreateTime());
		setLastModified(that.getLastModified());
		setClicks(that.getClicks());
		setPin(that.getPin());
		setUser(that.getUser());
		setForum(that.getForum());
		setLastActiveUser(that.getLastActiveUser());
		setLastActiveTime(that.getLastActiveTime());
		setReplies(new java.util.LinkedHashSet<com.nightwind.bbs.domain.Reply>(that.getReplies()));
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("id=[").append(id).append("] ");
		buffer.append("title=[").append(title).append("] ");
		buffer.append("content=[").append(content).append("] ");
		buffer.append("createTime=[").append(createTime).append("] ");
		buffer.append("lastModified=[").append(lastModified).append("] ");
		buffer.append("clicks=[").append(clicks).append("] ");
		buffer.append("pin=[").append(pin).append("] ");
		buffer.append("lastActiveTime=[").append(lastActiveTime).append("] ");
		buffer.append("lastActiveUser=[").append(lastActiveUser).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((id == null) ? 0 : id.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Topic))
			return false;
		Topic equalCheck = (Topic) obj;
		if ((id == null && equalCheck.id != null) || (id != null && equalCheck.id == null))
			return false;
		if (id != null && !id.equals(equalCheck.id))
			return false;
		return true;
	}
}
