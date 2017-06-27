package com.sun.serviceI;

import java.util.List;

import com.sun.base.BaseDaoI;
import com.sun.entity.Forum;
import com.sun.entity.Topic;

public interface TopicServiceI extends BaseDaoI<Topic>{
	List<Topic> findByForum(Forum forum);



}
