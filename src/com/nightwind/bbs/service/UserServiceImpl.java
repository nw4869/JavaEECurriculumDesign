package com.nightwind.bbs.service;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import javax.persistence.PersistenceException;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.UnexpectedRollbackException;
import org.springframework.transaction.annotation.Transactional;

import com.nightwind.bbs.dao.UserDAO;
import com.nightwind.bbs.domain.User;
import com.nightwind.bbs.exception.*;

/**
 * 
 * @generated
 */

@Service("UserService")
@Transactional
public class UserServiceImpl implements UserService {

	/**
	 * 
	 */
	@Autowired
	private UserDAO userDAO;


	/**
	 * Instantiates a new UserServiceExImpl.
	 *
	 * 
	 * @AuxiliaryModelComponent
	 */
	public UserServiceImpl() {
	}

	/**
	 * @throws UserNotFoundException
	 * 
	 * 
	 */
	@Override
	public User findUserById(Integer id) throws UserNotFoundException {
		User user = userDAO.findUserById(id);
		if (user == null) {
			throw new UserNotFoundException();
		}
		return user;
	}

	/**
	 * @throws UserNotFoundException
	 * 
	 * 
	 */
	@Override
	public User findUserByUsername(String username) throws UserNotFoundException {
		Iterator<User> iterator = userDAO.findUserByUsername(username).iterator();
		if (iterator.hasNext()) {
			return iterator.next();
		} else {
			throw new UserNotFoundException();
		}
	}

	/**
	 * MD5
	 */
	protected String encriptPassword(String plainPwd) {
//		return plainPwd;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(plainPwd.getBytes("UTF-8"));
			return bytes2Hex(md.digest());
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			e.printStackTrace();
			return "";
		}
	}
	
	static protected String bytes2Hex(byte[] raw) {
		final char[] HEX = "0123456789ABCDEF".toCharArray();

		StringBuilder hex = new StringBuilder(2 * raw.length);
		for (byte b: raw) {
			hex.append(HEX[ (b & 0xF0) >> 4 ])
				.append(HEX[ (b & 0x0F) ]);
		}
		return hex.toString();
	}

	/**
	 * @throws AuthorizeException
	 * @throws UserNotFoundException
	 * 
	 * 
	 */
	@Override
	public User login(String username, String password) throws AuthorizeException, UserNotFoundException {
		User user = findUserByUsername(username);
		if (user.getPassword().equals(encriptPassword(password))) {
			return user;
		} else {
			throw new AuthorizeException();
		}
	}

	/**
	 * @throws AccountExistedException 
	 * 
	 */
	@Transactional
	@Override
	public User register(String username, String password) throws AccountExistedException {
		if (!userDAO.findUserByUsername(username).isEmpty()) {
			throw new AccountExistedException();
		}
		
		User user = new User();
		try {
			user.setUsername(username);
			user.setPassword(encriptPassword(password));
			user = userDAO.store(user);
//			userDAO.flush();
			userDAO.refresh(user);
			return user;
		} catch (PersistenceException | UnexpectedRollbackException e) {
			throw new AccountExistedException();
		}
	}

	/**
	 * 
	 */
	@Transactional
	@Override
	public void logout(Integer id) {
	}

	/**
	 * @throws UserNotFoundException
	 * 
	 * 
	 */
	@Transactional
	@Override
	public User updateInfo(User user) throws UserNotFoundException {
		User existingUser = null;
		if (user.getId() != null) {
			existingUser = findUserById(user.getId());
		} else if (user.getUsername() != null || user.getUsername().trim().length() > 0) {
			existingUser = findUserByUsername(user.getUsername());
		} else {
			throw new UserNotFoundException();
		}
		existingUser.setEmail(user.getEmail());
		existingUser.setAvatar(user.getAvatar());
		existingUser.setMemberTitle(user.getMemberTitle());
		existingUser.setSignature(user.getSignature());
		userDAO.store(existingUser);
		userDAO.flush();
		return existingUser;
	}

	/**
	 * 
	 */
	@Transactional
	@Override
	public void updatePassword(Integer id, String password, String newPassword) throws UserNotFoundException, AuthorizeException {
		User user = findUserById(id);
		if (!user.getPassword().equals(password)) {
			throw new AuthorizeException();
		}
		user.setPassword(encriptPassword(newPassword));
		userDAO.flush();
	}
	
	@Transactional
	@Override
	public String updateAvatar(Integer id, String avatar) throws UserNotFoundException {
		User user = findUserById(id);
		user.setAvatar(avatar);
		userDAO.store(user);
		userDAO.flush();
		return avatar;
	}

	@Override
	public User deleteUser(Integer id) throws UserNotFoundException {
		User user = findUserById(id);
		userDAO.remove(user);
		userDAO.flush();
		return user;
	}
}
