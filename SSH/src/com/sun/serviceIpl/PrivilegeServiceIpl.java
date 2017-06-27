package com.sun.serviceIpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.opensymphony.xwork2.ActionContext;
import com.sun.base.BaseDaoIpl;
import com.sun.entity.Privilege;
import com.sun.serviceI.PrivilegeServiceI;
@SuppressWarnings("unchecked")
@Service
public class PrivilegeServiceIpl extends BaseDaoIpl<Privilege> implements PrivilegeServiceI {

	public List<Privilege> findTopList() {
		return this.getSession()
			.createQuery("from Privilege p where p.parent.id is null ")
			.list();
	}

	public List<Privilege> findAllPrivilegeUrl() {
		
		return getSession()
				.createQuery("select distinct p.url from Privilege p where p.url is not null").list();
	}


}
