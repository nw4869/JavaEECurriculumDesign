package com.nightwind.bbs.domain;

import java.io.Serializable;

import javax.persistence.Id;

import javax.persistence.*;

/**
 * @ModelCoreReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/domain/Authority.datatype]
 * @generated
 * @AuxiliaryModelComponent
 */
public class AuthorityPK implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * @generated
	 */
	public AuthorityPK() {
	}

	/**
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/domain/Authority.datatype#//@fields%5Bname='userId'%5D]
	 */

	@Column(name = "user_id", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	public Integer userId;
	/**
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/domain/Authority.datatype#//@fields%5Bname='authorityField'%5D]
	 */

	@Column(name = "authority", length = 45, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	public String authorityField;

	/**
	 * @generated
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * @generated
	 */
	public Integer getUserId() {
		return this.userId;
	}

	/**
	 * @generated
	 */
	public void setAuthorityField(String authorityField) {
		this.authorityField = authorityField;
	}

	/**
	 * @generated
	 */
	public String getAuthorityField() {
		return this.authorityField;
	}

	/**
	 * @generated
	 * @AuxiliaryModelComponent
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
	 * @generated
	 * @AuxiliaryModelComponent
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
