package com.nightwind.bbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nightwind.bbs.dao.MailDAO;
import com.nightwind.bbs.domain.Mail;

@Transactional
@Service("MailService")
public class MailServiceImpl implements MailService {
	
	@Autowired
	private MailDAO mailDAO;

	@Override
	public List<Mail> findMailsForReciver(Integer userId, Integer startIndex,
			Integer maxCount) {
		return mailDAO.executeQuery("select m from Mail m where m.reciver.id = ?1", startIndex, maxCount, userId);
	}

}
