package com.sun.base;

import java.lang.reflect.ParameterizedType;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sun.entity.User;
import com.sun.serviceI.DepartmentServiceI;
import com.sun.serviceI.ForumServiceI;
import com.sun.serviceI.PostServiceI;
import com.sun.serviceI.PrivilegeServiceI;
import com.sun.serviceI.ReplyServiceI;
import com.sun.serviceI.TopicServiceI;
import com.sun.serviceI.UserServiceI;

public class BaseAction<T> extends ActionSupport implements ModelDriven<T> {
	@Resource
	protected UserServiceI userService;
	@Resource
	protected PostServiceI postService;
	@Resource
	protected DepartmentServiceI departmentService;
	@Resource
	protected PrivilegeServiceI privilegeService;
	@Resource
	protected ForumServiceI forumService;
	@Resource
	protected TopicServiceI topicService;
	@Resource
	protected ReplyServiceI replyService;
	
	protected T model;
	
	public BaseAction(){
		ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
		Class<T> clazz = (Class<T>) pt.getActualTypeArguments()[0];
		try {
			model = clazz.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public T getModel() {
		return model;
	}	
	
	
	protected User getCurrentUser(){
		return (User) ActionContext.getContext().getSession().get("user");	
	}



	
}
