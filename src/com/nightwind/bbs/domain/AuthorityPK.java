package com.nightwind.bbs.domain;

import java.io.Serializable;

import javax.persistence.Id;

import javax.persistence.*;

/**
 */
public class AuthorityPK implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */
	public AuthorityPK() {
	}

	/**
	 */

	@Column(name = "user_id", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	public Integer userId;
	/**
	 */

	@Column(name = "authority", length = 45, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	public String authorityField;

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
		if (!(obj instanceof AuthorityPK))
			return false;
		AuthorityPK equalCheck = (AuthorityPK) obj;
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

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("AuthorityPK");
		sb.append(" userId: ").append(getUserId());
		sb.append(" authorityField: ").append(getAuthorityField());
		return sb.toString();
	}
}
