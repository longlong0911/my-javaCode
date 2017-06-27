package com.sun.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.opensymphony.xwork2.ActionContext;

public class User implements Serializable{
	private Long id;
	private String name;
	private String loginname;
	private String psw;
	private String sex;
	private String phone;
	private String email;
	private Department department;
	private Set<Post> posts = new HashSet<Post>();
	
	
	public boolean hasPrivilegeUrl(String url) {

		if(isAdmin()){
			return true;
		}
		List<Privilege> allPrivilegeUrl = (List<Privilege>) ActionContext.getContext().getApplication().get("allPrivilegeUrl");
		if(!allPrivilegeUrl.contains(url)){
			return true;
		}else{
			for(Post post : posts){
				for(Privilege privilege : post.getPrivileges()){
					if(url.equals(privilege.getUrl())){
						return true;
					}
				}
			}
			return false;
		}
	}
	public Boolean hasPrivilege(String pname){
		if(isAdmin()){
			return true;
		}
		for(Post post : posts){
			for(Privilege privilege : post.getPrivileges()){
				if(pname.equals(privilege.getName())){
					return true;
				}
			}
		}
		return false;
	}
	
	private boolean isAdmin() {
		if("admin".equals(loginname)){
			return true;
		}
		return false;
	}


	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getPsw() {
		return psw;
	}
	public void setPsw(String psw) {
		this.psw = psw;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public Set<Post> getPosts() {
		return posts;
	}
	public void setPosts(Set<Post> posts) {
		this.posts = posts;
	}

	
}
