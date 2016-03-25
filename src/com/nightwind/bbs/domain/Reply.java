package com.nightwind.bbs.domain;

import java.io.Serializable;
import java.lang.StringBuilder;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.*;
import javax.persistence.*;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 */

@Entity
@NamedQueries({
		@NamedQuery(name = "findAllReplys", query = "select myReply from Reply myReply"),
		@NamedQuery(name = "findReplyByContent", query = "select myReply from Reply myReply where myReply.content = ?1"),
		@NamedQuery(name = "findReplyByCreateTime", query = "select myReply from Reply myReply where myReply.createTime = ?1"),
		@NamedQuery(name = "findReplyById", query = "select myReply from Reply myReply where myReply.id = ?1"),
		@NamedQuery(name = "findReplyByPrimaryKey", query = "select myReply from Reply myReply where myReply.id = ?1"),
		@NamedQuery(name = "findReplyByTitle", query = "select myReply from Reply myReply where myReply.title = ?1"),
		@NamedQuery(name = "findReplyByTitleContaining", query = "select myReply from Reply myReply where myReply.title like ?1") })
@Table(catalog = "bbs", name = "reply")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "bbs/com/nightwind/bbs/domain", name = "Reply")
public class Reply implements Serializable {
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
	@Column(name = "title", length = 45)
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
	@Column(name = "create_time", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Date createTime;

	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "user_id", referencedColumnName = "id") })
	@XmlTransient
	User user;
	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "topic_id", referencedColumnName = "id", nullable = false) })
	@XmlTransient
	Topic topic;

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
	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	/**
	 */
	public Topic getTopic() {
		return topic;
	}

	/**
	 */
	public Reply() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Reply that) {
		setId(that.getId());
		setTitle(that.getTitle());
		setContent(that.getContent());
		setCreateTime(that.getCreateTime());
		setUser(that.getUser());
		setTopic(that.getTopic());
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
		if (!(obj instanceof Reply))
			return false;
		Reply equalCheck = (Reply) obj;
		if ((id == null && equalCheck.id != null) || (id != null && equalCheck.id == null))
			return false;
		if (id != null && !id.equals(equalCheck.id))
			return false;
		return true;
	}
}
