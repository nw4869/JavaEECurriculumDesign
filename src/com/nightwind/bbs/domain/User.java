package com.nightwind.bbs.domain;

import java.io.Serializable;
import java.lang.StringBuilder;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.*;
import javax.persistence.*;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 */

@Entity
@NamedQueries({
		@NamedQuery(name = "findAllUsers", query = "select myUser from User myUser"),
		@NamedQuery(name = "findUserByAvatar", query = "select myUser from User myUser where myUser.avatar = ?1"),
		@NamedQuery(name = "findUserByAvatarContaining", query = "select myUser from User myUser where myUser.avatar like ?1"),
		@NamedQuery(name = "findUserByCreateTime", query = "select myUser from User myUser where myUser.createTime = ?1"),
		@NamedQuery(name = "findUserByEmail", query = "select myUser from User myUser where myUser.email = ?1"),
		@NamedQuery(name = "findUserByEmailContaining", query = "select myUser from User myUser where myUser.email like ?1"),
		@NamedQuery(name = "findUserByEnabled", query = "select myUser from User myUser where myUser.enabled = ?1"),
		@NamedQuery(name = "findUserById", query = "select myUser from User myUser where myUser.id = ?1"),
		@NamedQuery(name = "findUserByMemberTitle", query = "select myUser from User myUser where myUser.memberTitle = ?1"),
		@NamedQuery(name = "findUserByMemberTitleContaining", query = "select myUser from User myUser where myUser.memberTitle like ?1"),
		@NamedQuery(name = "findUserByPassword", query = "select myUser from User myUser where myUser.password = ?1"),
		@NamedQuery(name = "findUserByPasswordContaining", query = "select myUser from User myUser where myUser.password like ?1"),
		@NamedQuery(name = "findUserByPrimaryKey", query = "select myUser from User myUser where myUser.id = ?1"),
		@NamedQuery(name = "findUserBySignature", query = "select myUser from User myUser where myUser.signature = ?1"),
		@NamedQuery(name = "findUserBySignatureContaining", query = "select myUser from User myUser where myUser.signature like ?1"),
		@NamedQuery(name = "findUserByUsername", query = "select myUser from User myUser where myUser.username = ?1"),
		@NamedQuery(name = "findUserByUsernameContaining", query = "select myUser from User myUser where myUser.username like ?1") })
@Table(catalog = "bbs", name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "bbs/com/nightwind/bbs/domain", name = "User")
@XmlRootElement(namespace = "bbs/com/nightwind/bbs/domain")
public class User implements Serializable {
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
	@Length(max=16)
	@Column(name = "username", length = 16, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String username;
	/**
	 */

	@NotBlank
	@Length(max=32)
	@Column(name = "password", length = 32, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String password;
	/**
	 */

	@Email
	@Column(name = "email")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String email;
	/**
	 */

	@Column(name = "avatar")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String avatar;
	/**
	 */

	@Length(max=16)
	@Column(name = "member_title", length = 16)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String memberTitle;
	/**
	 */

	@Length(max=255)
	@Column(name = "signature")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String signature;
	/**
	 */

	@Column(name = "enabled")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Boolean enabled;
	/**
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_time")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Date createTime;

	/**
	 */
	@OneToMany(mappedBy = "user", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<com.nightwind.bbs.domain.Authority> authorities;
	/**
	 */
	@OneToMany(mappedBy = "user", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<com.nightwind.bbs.domain.Topic> topics;
	/**
	 */
	@OneToMany(mappedBy = "user", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
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
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 */
	public String getUsername() {
		return this.username;
	}

	/**
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 */
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	/**
	 */
	public String getAvatar() {
		return this.avatar;
	}

	/**
	 */
	public void setMemberTitle(String memberTitle) {
		this.memberTitle = memberTitle;
	}

	/**
	 */
	public String getMemberTitle() {
		return this.memberTitle;
	}

	/**
	 */
	public void setSignature(String signature) {
		this.signature = signature;
	}

	/**
	 */
	public String getSignature() {
		return this.signature;
	}

	/**
	 */
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 */
	public Boolean getEnabled() {
		return this.enabled;
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
	public void setAuthorities(Set<Authority> authorities) {
		this.authorities = authorities;
	}

	/**
	 */
	public Set<Authority> getAuthorities() {
		if (authorities == null) {
			authorities = new java.util.LinkedHashSet<com.nightwind.bbs.domain.Authority>();
		}
		return authorities;
	}

	/**
	 */
	public void setTopics(Set<Topic> topics) {
		this.topics = topics;
	}

	/**
	 */
	public Set<Topic> getTopics() {
		if (topics == null) {
			topics = new java.util.LinkedHashSet<com.nightwind.bbs.domain.Topic>();
		}
		return topics;
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
	public User() {
	}

	public User(int userId) {
		id = userId;
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(User that) {
		setId(that.getId());
		setUsername(that.getUsername());
		setPassword(that.getPassword());
		setEmail(that.getEmail());
		setAvatar(that.getAvatar());
		setMemberTitle(that.getMemberTitle());
		setSignature(that.getSignature());
		setEnabled(that.getEnabled());
		setCreateTime(that.getCreateTime());
		setAuthorities(new java.util.LinkedHashSet<com.nightwind.bbs.domain.Authority>(that.getAuthorities()));
		setTopics(new java.util.LinkedHashSet<com.nightwind.bbs.domain.Topic>(that.getTopics()));
		setReplies(new java.util.LinkedHashSet<com.nightwind.bbs.domain.Reply>(that.getReplies()));
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("id=[").append(id).append("] ");
		buffer.append("username=[").append(username).append("] ");
		buffer.append("password=[").append(password).append("] ");
		buffer.append("email=[").append(email).append("] ");
		buffer.append("avatar=[").append(avatar).append("] ");
		buffer.append("memberTitle=[").append(memberTitle).append("] ");
		buffer.append("signature=[").append(signature).append("] ");
		buffer.append("enabled=[").append(enabled).append("] ");
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
		if (!(obj instanceof User))
			return false;
		User equalCheck = (User) obj;
		if ((id == null && equalCheck.id != null) || (id != null && equalCheck.id == null))
			return false;
		if (id != null && !id.equals(equalCheck.id))
			return false;
		return true;
	}
}
