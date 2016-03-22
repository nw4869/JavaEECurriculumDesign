package com.nightwind.bbs.domain;

import java.io.Serializable;

import java.lang.StringBuilder;

import java.util.Set;

import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import javax.xml.bind.annotation.*;

import javax.persistence.*;

/**
 */
@IdClass(com.nightwind.bbs.domain.AuthorityPK.class)
@Entity
@NamedQueries({
		@NamedQuery(name = "findAllAuthoritys", query = "select myAuthority from Authority myAuthority"),
		@NamedQuery(name = "findAuthorityByAuthorityField", query = "select myAuthority from Authority myAuthority where myAuthority.authorityField = ?1"),
		@NamedQuery(name = "findAuthorityByAuthorityFieldContaining", query = "select myAuthority from Authority myAuthority where myAuthority.authorityField like ?1"),
		@NamedQuery(name = "findAuthorityByPrimaryKey", query = "select myAuthority from Authority myAuthority where myAuthority.userId = ?1 and myAuthority.authorityField = ?2"),
		@NamedQuery(name = "findAuthorityByUserId", query = "select myAuthority from Authority myAuthority where myAuthority.userId = ?1") })
@Table(catalog = "bbs", name = "authority")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "bbs/com/nightwind/bbs/domain", name = "Authority")
public class Authority implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "user_id", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	Integer userId;
	/**
	 */

	@Column(name = "authority", length = 45, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	String authorityField;

	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false) })
	@XmlTransient
	User user;
	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "forum_id", referencedColumnName = "id") })
	@XmlTransient
	Forum forum;

	/**
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 */
	public Integer getUserId() {
		return this.userId;
	}

	/**
	 */
	public void setAuthorityField(String authorityField) {
		this.authorityField = authorityField;
	}

	/**
	 */
	public String getAuthorityField() {
		return this.authorityField;
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

	/**
	 */
	public Authority() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Authority that) {
		setUserId(that.getUserId());
		setAuthorityField(that.getAuthorityField());
		setUser(that.getUser());
		setForum(that.getForum());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("userId=[").append(userId).append("] ");
		buffer.append("authorityField=[").append(authorityField).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((userId == null) ? 0 : userId.hashCode()));
		result = (int) (prime * result + ((authorityField == null) ? 0 : authorityField.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Authority))
			return false;
		Authority equalCheck = (Authority) obj;
		if ((userId == null && equalCheck.userId != null) || (userId != null && equalCheck.userId == null))
			return false;
		if (userId != null && !userId.equals(equalCheck.userId))
			return false;
		if ((authorityField == null && equalCheck.authorityField != null) || (authorityField != null && equalCheck.authorityField == null))
			return false;
		if (authorityField != null && !authorityField.equals(equalCheck.authorityField))
			return false;
		return true;
	}
}
