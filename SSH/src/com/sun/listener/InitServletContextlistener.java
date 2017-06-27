package com.sun.listener;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.opensymphony.xwork2.ActionContext;
import com.sun.entity.Privilege;
import com.sun.serviceI.PrivilegeServiceI;

public class InitServletContextlistener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent sce) {
		ServletContext application = sce.getServletContext();
		//准备顶级权限列表
		ApplicationContext ac  = WebApplicationContextUtils.getWebApplicationContext(application);
		PrivilegeServiceI privilegeService = (PrivilegeServiceI) ac.getBean("privilegeServiceIpl");
		List<Privilege> topPrivilege = privilegeService.findTopList();
		application.setAttribute("topPrivilege", topPrivilege);
		System.out.println("-- 已准备好顶级权限的数据 --");
		//准备所有权限数据
		List<Privilege> allPrivilegeUrl = privilegeService.findAllPrivilegeUrl();
		application.setAttribute("allPrivilegeUrl", allPrivilegeUrl);
		
		
	}

	public void contextDestroyed(ServletContextEvent arg0) {
		
	}


}
