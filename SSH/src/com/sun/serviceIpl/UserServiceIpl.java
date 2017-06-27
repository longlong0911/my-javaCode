package com.sun.serviceIpl;

import org.springframework.stereotype.Service;

import com.sun.base.BaseDaoIpl;
import com.sun.entity.User;
import com.sun.serviceI.UserServiceI;

@Service
public class UserServiceIpl extends BaseDaoIpl<User> implements UserServiceI{

	public User findByNameAndPsw(String loginname, String psw) {
		
		return (User) getSession().createQuery("from User u where u.loginname=? and u.psw=?")
				.setParameter(0, loginname).setParameter(1,psw).uniqueResult();
	}


	public User findByName(String loginname) {
		return (User) getSession().createQuery("from User u where u.loginname=?")
				.setParameter(0,loginname).uniqueResult();
	}
	
}
