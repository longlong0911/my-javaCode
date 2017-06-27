package com.sun.action;

import java.util.HashSet;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.sun.base.BaseAction;
import com.sun.entity.Post;
import com.sun.entity.Privilege;

@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class PostAction extends BaseAction<Post>{
	
	private Long[] privilegeIds; 
	
	//查询全部列表
	public String list() throws Exception {
		List<Post> posts = postService.findAll();
		ActionContext.getContext().put("posts",posts);
		return "list";
	}
	//删除
	public String delete() throws Exception {
		postService.delete(model.getId());
		return "toList";
	}
	//修改页面 
	public String updateUI() throws Exception {
		Post post = postService.findById(model.getId());
		ActionContext.getContext().getValueStack().push(post);
		return "addUI";
	}
	//提交修改 转向列表
	public String update() throws Exception {
		Post post = postService.findById(model.getId());
		post.setName(model.getName());
		post.setDescription(model.getDescription());
		postService.update(post);
		return "toList";
	}
	//添加
	public String addUI() throws Exception {
		return "addUI";
	}
	//查询全部列表
	public String add() throws Exception {
		postService.save(model);
		return "toList";
	}
	
	public String setPrivilegeUI() throws Exception {

		//准备数据
		Post post = postService.findById(model.getId());
		ActionContext.getContext().put("post",post);
		
		List<Privilege> topPrivilege = privilegeService.findTopList(); 
		ActionContext.getContext().put("topPrivilege",topPrivilege);		
		//准备回显数据
		privilegeIds = new Long[post.getPrivileges().size()];
		int index = 0;
		for(Privilege privilege : post.getPrivileges()){
			privilegeIds[index++] = privilege.getId();
		}
		return "setPrivilegeUI";
	}
	//设置权限
	public String setPrivilege() throws Exception {
		Post post = postService.findById(model.getId());
		//设置要修改的权限
		List<Privilege> privileges = privilegeService.findByIds(privilegeIds);
		post.setPrivileges( new HashSet<Privilege>(privileges));
		postService.update(post);
		return "toList";
	}
	public Long[] getPrivilegeIds() {
		return privilegeIds;
	}
	public void setPrivilegeIds(Long[] privilegeIds) {
		this.privilegeIds = privilegeIds;
	}
	
	
	//=========================
	



	
}
