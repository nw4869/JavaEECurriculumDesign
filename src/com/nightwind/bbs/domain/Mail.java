package com.nightwind.bbs.domain;

import java.io.Serializable;
import java.lang.StringBuilder;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.*;
import javax.persistence.*;

import org.hibernate.validator.constraints.NotBlank;

/**
 */

@Entity
@NamedQueries({
		@NamedQuery(name = "findAllMails", query = "select myMail from Mail myMail"),
		@NamedQuery(name = "findMailByContent", query = "select myMail from Mail myMail where myMail.content = ?1"),
		@NamedQuery(name = "findMailById", query = "select myMail from Mail myMail where myMail.id = ?1"),
		@NamedQuery(name = "findMailByPrimaryKey", query = "select myMail from Mail myMail where myMail.id = ?1"),
		@NamedQuery(name = "findMailByRead", query = "select myMail from Mail myMail where myMail.read = ?1"),
		@NamedQuery(name = "findMailBySendTime", query = "select myMail from Mail myMail where myMail.sendTime = ?1"),
		@NamedQuery(name = "findMailByTitle", query = "select myMail from Mail myMail where myMail.title = ?1"),
		@NamedQuery(name = "findMailByTitleContaining", query = "select myMail from Mail myMail where myMail.title like ?1") })
@Table(catalog = "bbs", name = "mail")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "bbs/com/nightwind/bbs/domain", name = "Mail")
public class Mail implements Serializable {
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

	@NotBlank
	@Size(max=255)
	@Column(name = "title", nullable = false)
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
	@Column(name = "send_time", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Date sendTime;
	/**
	 */

	@Column(name = "`read`")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Boolean read;

	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "reciver_user_id", referencedColumnName = "id", nullable = false) })
	@XmlTransient
	User reciver;
	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "sender_user_id", referencedColumnName = "id", nullable = false) })
	@XmlTransient
	User sender;

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
	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	/**
	 */
	public Date getSendTime() {
		return this.sendTime;
	}

	/**
	 */
	public void setRead(Boolean read) {
		this.read = read;
	}

	/**
	 */
	public Boolean getRead() {
		return this.read;
	}

	/**
	 */
	public void setReciver(User reciver) {
		this.reciver = reciver;
	}

	/**
	 */
	public User getReciver() {
		return reciver;
	}

	/**
	 */
	public void setSender(User sender) {
		this.sender = sender;
	}

	/**
	 */
	public User getSender() {
		return sender;
	}

	/**
	 */
	public Mail() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Mail that) {
		setId(that.getId());
		setTitle(that.getTitle());
		setContent(that.getContent());
		setSendTime(that.getSendTime());
		setRead(that.getRead());
		setReciver(that.getReciver());
		setSender(that.getSender());
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
		buffer.append("sendTime=[").append(sendTime).append("] ");
		buffer.append("read=[").append(read).append("] ");

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
		if (!(obj instanceof Mail))
			return false;
		Mail equalCheck = (Mail) obj;
		if ((id == null && equalCheck.id != null) || (id != null && equalCheck.id == null))
			return false;
		if (id != null && !id.equals(equalCheck.id))
			return false;
		return true;
	}
}
