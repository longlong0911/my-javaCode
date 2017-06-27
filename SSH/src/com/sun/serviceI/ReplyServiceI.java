package com.sun.serviceI;

import java.util.List;

import com.sun.base.BaseDaoI;
import com.sun.entity.PageBean;
import com.sun.entity.Reply;
import com.sun.entity.Topic;

public interface ReplyServiceI extends BaseDaoI<Reply>{
//	List<Reply> findByTopic(Topic topic);

	PageBean findPageBean(int currentPage, Topic topic);



}
