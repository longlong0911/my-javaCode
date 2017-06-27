package com.sun.serviceI;

import java.util.List;

import com.sun.base.BaseDaoI;
import com.sun.entity.Department;

public interface DepartmentServiceI extends BaseDaoI<Department>{


	List<Department> findTopList();

	List<Department> findChildrenList(Long parentId);

	
}
