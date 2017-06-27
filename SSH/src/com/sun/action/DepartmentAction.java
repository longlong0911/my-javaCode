package com.sun.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.sun.base.BaseAction;
import com.sun.entity.Department;
import com.treeUtil.DepartmentTree;
@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class DepartmentAction extends BaseAction<Department>{
		
	private Long parentId;
	
	//查询所有
	public String list() throws Exception {
		List<Department> departments = null;
		if(parentId==null){
			 departments = departmentService.findTopList();
		}else{
			 departments = departmentService.findChildrenList(parentId);
		}
		ActionContext.getContext().put("departments",departments);
		return "list";
	}
	//删除
	public String delete() throws Exception {
		departmentService.delete(model.getId());
		return "toList";
	}
	//修改页面
	public String updateUI() throws Exception {
		List<Department> topDepartment = departmentService.findTopList();
		
		List<Department> DepartmentTreeList = DepartmentTree.getAllDepartment(topDepartment);
		ActionContext.getContext().put("DepartmentTreeList",DepartmentTreeList);
		
		Department department  = departmentService.findById(model.getId());
		ActionContext.getContext().getValueStack().push(department);
		if(department.getParent()!=null){
			parentId = department.getParent().getId();
		}
		return "addUI";  
	} 
	//修改
	public String update() throws Exception {
		Department department  = departmentService.findById(model.getId());
		department.setName(model.getName());
		department.setDescription(model.getDescription());
		departmentService.update(department);
		return "toList";
	}
	//添加了页面
	public String addUI() throws Exception {
		List<Department> topDepartment = departmentService.findTopList();
		List<Department> DepartmentTreeList = DepartmentTree.getAllDepartment(topDepartment);
		ActionContext.getContext().put("DepartmentTreeList",DepartmentTreeList);
		return "addUI";
	}
	//保存
	public String add() throws Exception {
		model.setParent(departmentService.findById(parentId));
		departmentService.save(model);
		return "toList";
	}
	
	
	//=================================
	
	public Long getParentId() {
		return parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
}
