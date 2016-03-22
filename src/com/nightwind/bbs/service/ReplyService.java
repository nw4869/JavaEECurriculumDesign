package com.nightwind.bbs.service;

import com.nightwind.bbs.domain.Reply;

public interface ReplyService {

	Reply findReplyByPrimaryKey(Integer id);
	
	Reply newReply(Reply reply);

}
