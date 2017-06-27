package com.sun.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
@Controller
@Scope("prototype")
public class HomeAction extends ActionSupport{
	
	public String allUI() throws Exception {
		return "allUI";
	}
	public String top() throws Exception {
		return "top";
	}
	public String bottom() throws Exception {
		return "bottom";
	}
	public String left() throws Exception {
		return "left";
	}
	public String right() throws Exception {
		return "right";
	}
	
}