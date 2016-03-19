package com.nightwind.bbs.service;

import com.nightwind.bbs.domain.User;

/**
 * @ModelCoreReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/UserServiceEx/.properties.srv]
 * @generated
 * @AuxiliaryModelComponent
 */
public interface UserServiceEx {

	/**
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/UserServiceEx/login%7B58d4023a-6abb-4254-ad52-a672305dd482%7D/.properties.swoperation]
	 */
	public Boolean login(String username, String password);

	/**
	 * @ModelReference [platform:/resource/bbs/.springDSL/com/nightwind/bbs/service/UserServiceEx/register%7B54ec143f-58af-4b7e-a028-d418ae62a5d1%7D/.properties.swoperation]
	 */
	public User register(String username_1, String password_1);

}