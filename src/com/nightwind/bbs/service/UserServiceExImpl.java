package com.nightwind.bbs.service;

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
import com.nightwind.exception.AccountExistedException;
import com.nightwind.exception.AuthorizeException;
import com.nightwind.exception.UserNotFoundException;

/**
 * 
 * @generated
 */

@Service("UserServiceEx")
@Transactional
public class UserServiceExImpl implements UserServiceEx {

	/**
	 * 
	 */
	@Autowired
	private UserDAO userDAO;

	/**
	 * 
	 */
	@Autowired
	private UserService userService;

	/**
	 * Instantiates a new UserServiceExImpl.
	 *
	 * 
	 * @AuxiliaryModelComponent
	 */
	public UserServiceExImpl() {
	}

	/**
	 * @throws UserNotFoundException
	 * 
	 * 
	 */
	@Override
	public User findUserById(Integer id) throws com.nightwind.exception.UserNotFoundException {
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
	public User findUserByUsername(String username) throws com.nightwind.exception.UserNotFoundException {
		Iterator<User> iterator = userDAO.findUserByUsername(username).iterator();
		if (iterator.hasNext()) {
			return iterator.next();
		} else {
			throw new UserNotFoundException();
		}
	}

	/**
	 * 
	 */
	protected String encriptPassword(String plainPwd) {
		return plainPwd;
	}

	/**
	 * @throws AuthorizeException
	 * @throws UserNotFoundException
	 * 
	 * 
	 */
	@Override
	public User login(String username, String password) throws com.nightwind.exception.AuthorizeException, com.nightwind.exception.UserNotFoundException {
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
			return userDAO.store(user);	
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
	public User updateInfo(User user) throws com.nightwind.exception.UserNotFoundException {
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
	public void updatePassword(Integer id, String password, String newPassword) throws com.nightwind.exception.UserNotFoundException, com.nightwind.exception.AuthorizeException {
		User user = findUserById(id);
		if (!user.getPassword().equals(password)) {
			throw new AuthorizeException();
		}
		user.setPassword(encriptPassword(newPassword));
		userDAO.flush();
	}
}
