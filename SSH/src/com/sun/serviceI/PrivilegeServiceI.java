package com.sun.serviceI;

import java.util.List;

import com.sun.base.BaseDaoI;
import com.sun.entity.Privilege;

public interface PrivilegeServiceI extends BaseDaoI<Privilege>{

	List<Privilege> findTopList();


	List<Privilege> findAllPrivilegeUrl();
	
}
