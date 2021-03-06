package com.nightwind.bbs.service;

import java.util.List;

import com.nightwind.bbs.domain.Mail;
import com.nightwind.bbs.exception.MailNotFoundException;
import com.nightwind.bbs.exception.MailReciverValidateException;
import com.nightwind.bbs.exception.UserNotFoundException;

public interface MailService {
	
	List<Mail> findMailsForReciver(Integer userId, Integer startIndex, Integer maxCount);

	List<Mail> findMailsForSender(Integer userId, Integer startIndex,
			Integer maxCount);

	Mail sendMail(Integer senderUserId, String reciverUsername, String title,
			String content) throws UserNotFoundException, MailReciverValidateException;

	Mail deleteMail(Integer id) throws MailNotFoundException;

	Mail findMailByPrimaryKey(Integer id);

	void setRead(Integer mailId, Boolean read) throws MailNotFoundException;
	
}
