package com.sun.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.sun.entity.User;

public class CheckPrivilegeInterceptor implements Interceptor{

	public void destroy() {
		
	}

	public void init() {
		
	}

	
	public String intercept(ActionInvocation invocation) throws Exception {
		User user = (User) ActionContext.getContext().getSession().get("user");
		
		String url = null;
		String namespace = invocation.getProxy().getNamespace();
		String name = invocation.getProxy().getActionName();
		
		if(namespace.endsWith("/")){
			url = (namespace+name).substring(1);
		}else{
			url=(namespace+"/"+name);
		}
		if(url.endsWith("UI")){
			url = url.substring(0,url.length()-2);
		}
		//如果是未登录用户 返回登录页面
		if(user==null){
			if(url.startsWith("userAction_login")){
				return invocation.invoke();
			}
			return "loginUI";
		}else{//如果是已登录用户
			//有权限就放行
			if(user.hasPrivilegeUrl(url)){
				return invocation.invoke();
			}else{
				//没有权限返回没权限的页面
				return "errorPrivilege";	
			}
		}
	}
}
