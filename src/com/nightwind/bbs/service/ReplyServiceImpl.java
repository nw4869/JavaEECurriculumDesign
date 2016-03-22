package com.nightwind.bbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nightwind.bbs.dao.ReplyDAO;
import com.nightwind.bbs.domain.Reply;


@Service("ReplyService")
public class ReplyServiceImpl implements ReplyService {

	@Autowired
	private ReplyDAO replyDAO;
	
	@Override
	public Reply findReplyByPrimaryKey(Integer id) {
		return replyDAO.findReplyByPrimaryKey(id);
	}
	
	@Override
	public Reply newReply(Reply reply) {
		reply.setId(null);
		reply = replyDAO.store(reply);
		replyDAO.refresh(reply);
		return reply;
	}
}
