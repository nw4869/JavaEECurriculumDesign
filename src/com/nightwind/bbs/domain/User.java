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
 * @ModelCoreReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/domain/User.datatype]
 * @generated
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
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/domain/User.datatype#//@fields%5Bname='id'%5D]
	 */

	@Column(name = "id", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	@XmlElement
	Integer id;
	/**
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/domain/User.datatype#//@fields%5Bname='username'%5D]
	 */

	@Column(name = "username", length = 16, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String username;
	/**
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/domain/User.datatype#//@fields%5Bname='password'%5D]
	 */

	@Column(name = "password", length = 32, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String password;
	/**
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/domain/User.datatype#//@fields%5Bname='email'%5D]
	 */

	@Column(name = "email")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String email;
	/**
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/domain/User.datatype#//@fields%5Bname='avatar'%5D]
	 */

	@Column(name = "avatar")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String avatar;
	/**
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/domain/User.datatype#//@fields%5Bname='memberTitle'%5D]
	 */

	@Column(name = "member_title", length = 16)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String memberTitle;
	/**
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/domain/User.datatype#//@fields%5Bname='signature'%5D]
	 */

	@Column(name = "signature")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String signature;
	/**
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/domain/User.datatype#//@fields%5Bname='enabled'%5D]
	 */

	@Column(name = "enabled")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Boolean enabled;
	/**
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/domain/User.datatype#//@fields%5Bname='createTime'%5D]
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_time")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar createTime;

	/**
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/domain/User.datatype#//@relationships%5Bname='authorities'%5D]
	 */
	@OneToMany(mappedBy = "user", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<com.nightwind.bbs.domain.Authority> authorities;
	/**
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/domain/User.datatype#//@relationships%5Bname='forumThreads'%5D]
	 */
	@OneToMany(mappedBy = "user", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<com.nightwind.bbs.domain.ForumThread> forumThreads;
	/**
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/domain/User.datatype#//@relationships%5Bname='comments'%5D]
	 */
	@OneToMany(mappedBy = "user", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
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
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @generated
	 */
	public String getUsername() {
		return this.username;
	}

	/**
	 * @generated
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @generated
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * @generated
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @generated
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 * @generated
	 */
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	/**
	 * @generated
	 */
	public String getAvatar() {
		return this.avatar;
	}

	/**
	 * @generated
	 */
	public void setMemberTitle(String memberTitle) {
		this.memberTitle = memberTitle;
	}

	/**
	 * @generated
	 */
	public String getMemberTitle() {
		return this.memberTitle;
	}

	/**
	 * @generated
	 */
	public void setSignature(String signature) {
		this.signature = signature;
	}

	/**
	 * @generated
	 */
	public String getSignature() {
		return this.signature;
	}

	/**
	 * @generated
	 */
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * @generated
	 */
	public Boolean getEnabled() {
		return this.enabled;
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
	public void setAuthorities(Set<Authority> authorities) {
		this.authorities = authorities;
	}

	/**
	 * @generated
	 */
	public Set<Authority> getAuthorities() {
		if (authorities == null) {
			authorities = new java.util.LinkedHashSet<com.nightwind.bbs.domain.Authority>();
		}
		return authorities;
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
	public User() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 * @generated
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
		setForumThreads(new java.util.LinkedHashSet<com.nightwind.bbs.domain.ForumThread>(that.getForumThreads()));
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
