package com.nightwind.bbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nightwind.bbs.dao.UserDAO;
import com.nightwind.bbs.domain.User;

/**
 * @ModelCoreReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/UserServiceEx/.properties.srv]
 * @generated
 */

@Service("UserServiceEx")
@Transactional
public class UserServiceExImpl implements UserServiceEx {

	/**
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/UserServiceEx/.properties.srv#//@variables%5Bname='userDAO'%5D]
	 */
	@Autowired
	private UserDAO userDAO;

	/**
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/UserServiceEx/.properties.srv#//@variables%5Bname='userService'%5D]
	 */
	@Autowired
	private UserService userService;

	/**
	 * Instantiates a new UserServiceExImpl.
	 *
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/UserServiceEx/.properties.srv]
	 * @AuxiliaryModelComponent
	 */
	public UserServiceExImpl() {
	}

	/**
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/UserServiceEx/findUserByUsername%7Be4868c1f-8895-4f51-a1bc-8e788875ad06%7D/.properties.swoperation]
	 */
	private User findUserByUsername(String username) {
		return userDAO.findUserByUsername(username).iterator().next();
	}

	/**
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/UserServiceEx/encriptPassword%7B4600b759-a2ab-424c-a680-a6f2ba8381ed%7D/.properties.swoperation]
	 */
	protected String encriptPassword(String plainPwd) {
		return plainPwd;
	}

	/**
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/UserServiceEx/login%7B58d4023a-6abb-4254-ad52-a672305dd482%7D/.properties.swoperation]
	 */
	@Override
	public Boolean login(String username, String password) {
		return findUserByUsername(username).getPassword().equals(encriptPassword(password));
	}

	/**
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/UserServiceEx/register%7B54ec143f-58af-4b7e-a028-d418ae62a5d1%7D/.properties.swoperation]
	 */
	@Transactional
	@Override
	public User register(String username, String password) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(encriptPassword(password));
		return userDAO.store(user);
	}
}
