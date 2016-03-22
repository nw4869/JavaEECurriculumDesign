package com.nightwind.bbs.service;

import com.nightwind.bbs.domain.User;
import com.nightwind.exception.AccountExistedException;
import com.nightwind.exception.AuthorizeException;
import com.nightwind.exception.UserNotFoundException;

/**
 * 
 * @generated
 * @AuxiliaryModelComponent
 */
public interface UserServiceEx {

	/**
	 * @throws AuthorizeException
	 * @throws UserNotFoundException
	 * 
	 * 
	 */
	public User login(String username, String password) throws com.nightwind.exception.AuthorizeException, com.nightwind.exception.UserNotFoundException;

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
	public User findUserByUsername(String username_1) throws com.nightwind.exception.UserNotFoundException;

	/**
	 * @throws UserNotFoundException
	 * 
	 * 
	 */
	public User findUserById(Integer id_1) throws com.nightwind.exception.UserNotFoundException;

	/**
	 * @throws UserNotFoundException
	 * 
	 * 
	 */
	public User updateInfo(User user) throws com.nightwind.exception.UserNotFoundException;

	/**
	 * 
	 */
	public void updatePassword(Integer id_2, String password_1, String newPassword) throws com.nightwind.exception.UserNotFoundException, com.nightwind.exception.AuthorizeException;

}