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

@Entity
@NamedQueries({
		@NamedQuery(name = "findAllAuthoritys", query = "select myAuthority from Authority myAuthority"),
		@NamedQuery(name = "findAuthorityByAuthorityField", query = "select myAuthority from Authority myAuthority where myAuthority.authorityField = ?1"),
		@NamedQuery(name = "findAuthorityByAuthorityFieldContaining", query = "select myAuthority from Authority myAuthority where myAuthority.authorityField like ?1"),
		@NamedQuery(name = "findAuthorityById", query = "select myAuthority from Authority myAuthority where myAuthority.id = ?1"),
		@NamedQuery(name = "findAuthorityByPrimaryKey", query = "select myAuthority from Authority myAuthority where myAuthority.id = ?1") })
@Table(catalog = "bbs", name = "authority")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "temp/com/nightwind/bbs/domain", name = "Authority")
public class Authority implements Serializable {
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

	@Column(name = "authority", length = 45, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String authorityField;

	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false) })
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
		setId(that.getId());
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

		buffer.append("id=[").append(id).append("] ");
		buffer.append("authorityField=[").append(authorityField).append("] ");

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
		if (!(obj instanceof Authority))
			return false;
		Authority equalCheck = (Authority) obj;
		if ((id == null && equalCheck.id != null) || (id != null && equalCheck.id == null))
			return false;
		if (id != null && !id.equals(equalCheck.id))
			return false;
		return true;
	}
}
