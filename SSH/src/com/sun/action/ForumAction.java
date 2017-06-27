package com.sun.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.sun.base.BaseAction;
import com.sun.entity.Forum;
import com.sun.entity.Topic;
@Controller
@Scope("prototype")
public class ForumAction extends BaseAction<Forum>{
	//显示板块列表
	public String list() throws Exception {
		List<Forum> forumList = forumService.findAll();
		ActionContext.getContext().put("forumList",forumList);
		return "list";
	}
	//显示单个板块
	public String show() throws Exception {
		
		Forum forum = forumService.findById(model.getId());
		ActionContext.getContext().put("forum",forum);
		
		List<Topic> topicList = topicService.findByForum(forum);
		ActionContext.getContext().put("topicList",topicList);
		
		return "show";//转到所属主题的显示页面
	}
}
