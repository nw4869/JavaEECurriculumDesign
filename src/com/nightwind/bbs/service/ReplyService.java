package com.nightwind.bbs.service;

import com.nightwind.bbs.domain.Reply;
import com.nightwind.bbs.exception.ReplyNotFoundException;

public interface ReplyService {

	Reply findReplyByPrimaryKey(Integer id);
	
	Reply newReply(Reply reply);

	Reply deleteReply(Integer id) throws ReplyNotFoundException;

}
