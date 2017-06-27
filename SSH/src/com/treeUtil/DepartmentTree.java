package com.treeUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.sun.entity.Department;

public class DepartmentTree {
	public static List<Department> getAllDepartment(List<Department> topDepartment){
		
		List<Department> list = new ArrayList<Department>();
		treeList(topDepartment,"┣",list);
		return list;
	} 
	public static void treeList(Collection<Department> topDepartment,String prefix,List<Department> list){
		for(Department department : topDepartment){
			Department copy = new Department();
			copy.setId(department.getId());
			copy.setName(prefix+department.getName());
			list.add(copy);
			treeList(department.getChildren(),"　"+prefix,list);
		}
	}
}
