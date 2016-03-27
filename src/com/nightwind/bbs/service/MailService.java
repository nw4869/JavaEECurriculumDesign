package com.nightwind.bbs.service;

import java.util.List;

import com.nightwind.bbs.domain.Mail;

public interface MailService {
	
	List<Mail> findMailsForReciver(Integer userId, Integer startIndex, Integer maxCount);
	
}
