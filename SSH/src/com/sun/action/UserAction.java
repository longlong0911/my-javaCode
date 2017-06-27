package com.sun.action;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.sun.base.BaseAction;
import com.sun.entity.Department;
import com.sun.entity.Post;
import com.sun.entity.User;
import com.treeUtil.DepartmentTree;
@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class UserAction extends BaseAction<User>{
	
	private Long departmentId;
	private Long[] postIds;
	private Map<String,Object> info = new HashMap<String,Object>();
	
	//用户列表
	public String list() throws Exception {
		List<User> users = userService.findAll();
		ActionContext.getContext().put("users",users);
		return "list";
	}
	//用户删除
	public String delete() throws Exception {
		userService.delete(model.getId());
		return "toList";
	}
	//用户添加
	public String add() throws Exception {
		model.setDepartment(departmentService.findById(departmentId));
		model.setPosts(new HashSet<Post>(postService.findByIds(postIds)));
		model.setPsw("1234");
		userService.save(model);
		return "toList";
	}
	
	//用户添加页面
	public String addUI() throws Exception {
		//准备部门树桩列表
		List<Department> topDepartment = departmentService.findTopList();
		List<Department> topDepartmentList = DepartmentTree.getAllDepartment(topDepartment);
		ActionContext.getContext().put("topDepartmentList", topDepartmentList);
		//准备岗位
		List<Post> posts = postService.findAll();
		ActionContext.getContext().put("posts", posts);
		
		return "addUI";
	}
	//用户修改
	public String update() throws Exception {
		User user = userService.findById(model.getId());
		user.setDepartment(departmentService.findById(departmentId));
		user.setPosts(new HashSet<Post>(postService.findByIds(postIds)));
		
		user.setLoginname(model.getLoginname());
		user.setName(model.getName());
		user.setSex(model.getSex());
		user.setPhone(model.getPhone());
		user.setEmail(model.getEmail());
		userService.update(user);
		return "toList";
	}
	
	//用户修改页面
	public String updateUI() throws Exception {
		//z准备部门树状数据
		List<Department> topDepartment = departmentService.findTopList();
		List<Department> topDepartmentList = DepartmentTree.getAllDepartment(topDepartment);
		ActionContext.getContext().put("topDepartmentList",topDepartmentList);
		//准备职位数据
		List<Post> posts = postService.findAll();	
		ActionContext.getContext().put("posts",posts);
		        
		User user = userService.findById(model.getId());
		ActionContext.getContext().getValueStack().push(user);
		
		if(user.getDepartment()!=null){
			departmentId = user.getDepartment().getId();
		}
		if(user.getPosts().size()>0){
			postIds = new Long[user.getPosts().size()];
			int index= 0;
			for(Post post : user.getPosts()){
				postIds[index++] =post.getId(); 	
			}
		}
		
		return "addUI";
	}
	
	//用户初始化密码
	public String initpsw() throws Exception {
		User user = userService.findById(model.getId());
		user.setPsw("1234");
		userService.update(user);
		return "toList";
	}
	//登录
	public String login() throws Exception {
		User user = (User) userService.findByNameAndPsw(model.getLoginname(),model.getPsw()); 
		if(user==null){
			this.addFieldError("msgError","用户名或密码错误");
			return "loginUI";
		}else{
			ActionContext.getContext().getSession().put("user",user);
			return "toAllUI";
		}
		
	}
	//登录页面
	public String loginUI() throws Exception {
		return "loginUI";
	}
	//注销页面
	public String logOut() throws Exception {
		ActionContext.getContext().getSession().remove("user");
		return "loginUI";
	}

	public String checkLoginname(){
		System.out.println("======================");
		
		User user = userService.findByName(model.getLoginname());
		
		if(user==null){
			info.put("repeat",true);
			info.put("msg","登录名可用");
		}else{
			info.put("repeat",false);
			info.put("msg","登录名重复");
		}
		
		return "check";
	}
	
	
	
	
	
	//==============================================




	
	public Long getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}
	public Long[] getPostIds() {
		return postIds;
	}
	public void setPostIds(Long[] postIds) {
		this.postIds = postIds;
	}
	public Map<String, Object> getInfo() {
		return info;
	}
	public void setInfo(Map<String, Object> info) {
		this.info = info;
	}
	
	
	
}

