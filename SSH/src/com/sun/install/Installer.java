package com.sun.install;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.sun.entity.Privilege;
import com.sun.entity.User;
@Component
public class Installer {
	@Resource
	private SessionFactory sessionFactory;
	@Transactional
	public void install(){
		Session session = sessionFactory.getCurrentSession();
		User user = new User();
		user.setName("超级管理员");
		user.setLoginname("admin");
		user.setPsw("admin");
		session.save(user);
		
		Privilege menu,menu1,menu2,menu3,menu4,menu5;
		menu = new Privilege("系统管理",null,null);
		menu1 = new Privilege("部门管理","departmentAction_list",menu);
		menu2 = new Privilege("岗位管理","postAction_list",menu);
		menu3 = new Privilege("用户管理","userAction_list",menu);
		session.save(menu);
		session.save(menu1);
		session.save(menu2);
		session.save(menu3);
		
		
		session.save(new Privilege("部门列表","departmentAction_list",menu1));
		session.save(new Privilege("部门添加","departmentAction_add",menu1));
		session.save(new Privilege("部门删除","departmentAction_delete",menu1));
		session.save(new Privilege("部门修改","departmentAction_update",menu1));
		
		session.save(new Privilege("岗位列表","postAction_list",menu2));
		session.save(new Privilege("岗位添加","postAction_add",menu2));
		session.save(new Privilege("岗位删除","postAction_delete",menu2));
		session.save(new Privilege("岗位修改","postAction_update",menu2));
		
		session.save(new Privilege("用户列表","userAction_list",menu3));
		session.save(new Privilege("用户添加","userAction_add",menu3));
		session.save(new Privilege("用户删除","userAction_delete",menu3));
		session.save(new Privilege("用户修改","userAction_update",menu3));
		session.save(new Privilege("用户初始化密码","userAction_initpsw",menu3));
		
		//=====================================
		menu = new Privilege("网上交流", null, null);
		menu1 = new Privilege("论坛管理", "forumManageAction_list", menu);
		menu2 = new Privilege("论坛", "forumAction_list",menu);

		session.save(menu);
		session.save(menu1);
		session.save(menu2);

		// -------------------------
//
//		menu = new Privilege("审批流转", null,null);
//		menu1 = new Privilege("审批流程管理", "processDefinitionAction_list",menu);
//		menu2 = new Privilege("申请模板管理", "applicationTemplateAction_list",menu);
//		menu3 = new Privilege("起草申请", "flowAction_applicationTemplateList",menu);
//		menu4 = new Privilege("待我审批", "flowAction_myTaskList",menu);
//		menu5 = new Privilege("我的申请查询", "flowAction_myApplicationList",menu);
//
//		session.save(menu);
//		session.save(menu1);
//		session.save(menu2);
//		session.save(menu3);
//		session.save(menu4);
//		session.save(menu5);
//
//		
//		
	}
	public static void main(String[] args){
		System.out.println("开时加载数据");
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		Installer installer = (Installer) ac.getBean("installer");
		installer.install();
		System.out.println("加载完成");
	}
}
