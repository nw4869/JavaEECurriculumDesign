package com.nightwind.bbs.service;

import com.nightwind.bbs.domain.User;
import com.nightwind.bbs.exception.*;

/**
 * 
 * @generated
 * @AuxiliaryModelComponent
 */
public interface UserService {

	/**
	 * @throws AuthorizeException
	 * @throws UserNotFoundException
	 * 
	 * 
	 */
	public User login(String username, String password) throws AuthorizeException, UserNotFoundException;

	/**
	 * @throws AccountExistedException 
	 * 
	 */
	public User register(String username_2, String password_2) throws AccountExistedException;

	/**
	 * 
	 */
	public void logout(Integer id);

	/**
	 * @throws UserNotFoundException
	 * 
	 * 
	 */
	public User findUserByUsername(String username_1) throws UserNotFoundException;

	/**
	 * @throws UserNotFoundException
	 * 
	 * 
	 */
	public User findUserById(Integer id_1) throws UserNotFoundException;

	/**
	 * @throws UserNotFoundException
	 * 
	 * 
	 */
	public User updateInfo(User user) throws UserNotFoundException;

	/**
	 * 
	 */
	public void updatePassword(Integer id_2, String password_1, String newPassword) throws UserNotFoundException, AuthorizeException;

	String updateAvatar(Integer id, String avatar) throws UserNotFoundException;

}