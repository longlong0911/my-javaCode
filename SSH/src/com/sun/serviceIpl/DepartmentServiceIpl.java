package com.sun.serviceIpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sun.base.BaseDaoIpl;
import com.sun.entity.Department;
import com.sun.serviceI.DepartmentServiceI;
@SuppressWarnings("unchecked")
@Service
public class DepartmentServiceIpl extends BaseDaoIpl<Department> implements DepartmentServiceI{

	public List<Department> findTopList() {
		return this.getSession().createQuery("from Department d where d.parent is null").list();
	}

	public List<Department> findChildrenList(Long parentId) {
		return (List<Department>) this.getSession()
				.createQuery("from Department d where d.parent.id=?")
				.setParameter(0,parentId).list();
	}
	
}
