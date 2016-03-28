package com.nightwind.bbs.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import com.nightwind.bbs.domain.Mail;
import com.nightwind.bbs.exception.MailReciverValidateException;
import com.nightwind.bbs.exception.UserNotFoundException;

@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({
		DependencyInjectionTestExecutionListener.class,
		DirtiesContextTestExecutionListener.class,
		TransactionalTestExecutionListener.class })
@Transactional
@ContextConfiguration(locations = {
		"file:./src/bbs-security-context.xml",
		"file:./src/bbs-service-context.xml",
		"file:./src/bbs-dao-context.xml",
		"file:./src/bbs-web-context.xml" })
public class MailServiceTest {

	@Autowired
	private MailService mailService;
	
	@Test
	public void testFindMailsForReciver() {
		List<Mail> mails = mailService.findMailsForReciver(1, -1, -1);
		System.out.println(mails);
		List<Mail> mails1 = mailService.findMailsForReciver(-1, -1, -1);
		System.out.println(mails1);
	}

	@Test
	public void testSendMail() throws UserNotFoundException, MailReciverValidateException {
		mailService.sendMail(1, "test", "tt", "cc");
	}
}
