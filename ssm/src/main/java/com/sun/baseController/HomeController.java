package com.sun.baseController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/main.action")
	public String main() throws Exception {
		return "/home/main.jsp";
	}
	
	@RequestMapping("top.action")
	public String top() throws Exception {
		return "/home/top.jsp";
	}
	
	
	@RequestMapping("left.action")
	public String left() throws Exception {
		return "/home/left.jsp";
	}
	
	@RequestMapping("right.action")
	public String right() throws Exception {
		return "/home/right.jsp";
	}

	
}
