package com.nightwind.bbs.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nightwind.bbs.dao.MailDAO;
import com.nightwind.bbs.dao.UserDAO;
import com.nightwind.bbs.domain.Mail;
import com.nightwind.bbs.domain.User;
import com.nightwind.bbs.exception.MailNotFoundException;
import com.nightwind.bbs.exception.MailReciverValidateException;
import com.nightwind.bbs.exception.UserNotFoundException;

@Transactional
@Service("MailService")
public class MailServiceImpl implements MailService {
	
	@Autowired
	private MailDAO mailDAO;
	
	@Autowired
	private UserDAO userDAO;
	
	@Override
	public Mail findMailByPrimaryKey(Integer id) {
		return mailDAO.findMailByPrimaryKey(id);
	}

	@Override
	public List<Mail> findMailsForReciver(Integer userId, Integer startIndex,
			Integer maxCount) {
		return mailDAO.executeQuery("select m from Mail m where m.reciver.id = ?1", startIndex, maxCount, userId);
	}

	@Override
	public List<Mail> findMailsForSender(Integer userId, Integer startIndex,
			Integer maxCount) {
		return mailDAO.executeQuery("select m from Mail m where m.sender.id = ?1", startIndex, maxCount, userId);
	}

	@Override
	public Mail sendMail(Integer senderUserId, String reciverUsername, String title, String content) throws UserNotFoundException, MailReciverValidateException {
		User sender = userDAO.findUserById(senderUserId);
		Set<User> reciverSet = userDAO.findUserByUsername(reciverUsername);
		if (sender == null) {
			throw new UserNotFoundException();
		}
		if (reciverSet.isEmpty()) {
			throw new MailReciverValidateException();
		}
		User reciver = reciverSet.iterator().next();
		if (reciver.getId().equals(sender.getId())) {
			throw new MailReciverValidateException();
		}
		
		Mail mail = new Mail();
		mail.setReciver(reciver);
		mail.setSender(sender);
		mail.setTitle(title);
		mail.setContent(content);
		mail.setRead(false);
		
		mail = mailDAO.store(mail);
		mailDAO.flush();
		return mail;
	}
	
	@Override
	public Mail deleteMail(Integer id) throws MailNotFoundException{
		Mail mail = mailDAO.findMailById(id);
		if (mail == null) {
			throw new MailNotFoundException();
		}
		mailDAO.remove(mail);
		mailDAO.flush();
		return mail;
	}

	@Override
	public void setRead(Integer mailId, Boolean read) throws MailNotFoundException {
		Mail mail = mailDAO.findMailById(mailId);
		if (mail == null) {
			throw new MailNotFoundException();
		}
		mail.setRead(true);
		mailDAO.flush();
	}
	
}
