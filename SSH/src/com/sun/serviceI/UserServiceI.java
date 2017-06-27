package com.sun.serviceI;

import com.sun.base.BaseDaoI;
import com.sun.entity.User;

public interface UserServiceI extends BaseDaoI<User>{

	User findByNameAndPsw(String loginname, String psw);

	User findByName(String loignname);
}
