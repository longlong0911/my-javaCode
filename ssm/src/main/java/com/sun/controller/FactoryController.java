package com.sun.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sun.entity.Factory;
import com.sun.serviceI.FactoryServiceI;

@Controller
public class FactoryController {
	@Resource
	private FactoryServiceI factoryService;

	// 单个列表页面
	@RequestMapping("/factory/factoryListOne")
	public String factoryListOne(HttpServletRequest request,String id) {
		Factory factory = factoryService.findById(id);
		request.setAttribute("factory", factory);
		return "/factory/factoryListOne.jsp";
	}

	// 列表页面
	@RequestMapping("/factory/factoryList")
	public String factoryList(HttpServletRequest request) {
		List<Factory> factoryList = factoryService.findAll();
		request.setAttribute("factoryList", factoryList);
		return "/factory/factoryList.jsp";
	}

	// 转到添加页面
	@RequestMapping("/factory/factoryAddUI")
	public String factoryAddUI(HttpServletRequest request) {
		return "/factory/factoryAddUI.jsp";
	}

	// 添加
	@RequestMapping("/factory/factoryAdd")
	public String factoryAdd(Factory factory) {
		factoryService.addFactory(factory);
		return "redirect:/factory/factoryList.action";
	}

	// 修改页面
	@RequestMapping("/factory/factoryUpdateUI")
	public String factoryUpdateUI(String id, HttpServletRequest request) {
		Factory factory = factoryService.findById(id);
		request.setAttribute("factory", factory);
		return "/factory/factoryUpdateUI.jsp";
	}

	// 修改
	@RequestMapping("/factory/factoryUpdate")
	public String factoryUpdate(Factory factory) {
		factoryService.updateFactory(factory);
		return "redirect:/factory/factoryList.action";
	}

	// 启用
	@RequestMapping("/factory/factoryOpen")
	public String factoryOpen(String id) {
		Factory factory = factoryService.findById(id);
		factoryService.openFactory(factory);
		return "redirect:/factory/factoryList.action";
	}

	// 停用
	@RequestMapping("/factory/factoryClose")
	public String factoryClose(String id) {
		Factory factory = factoryService.findById(id);
		factoryService.closeFactory(factory);
		return "redirect:/factory/factoryList.action";
	}

	// 删除
	@RequestMapping("/factory/factoryDelete")
	public String factoryDelete(@RequestParam("id")String[] ids) {
		System.out.println("================");
		System.out.println(ids);
		if (ids == null) {
			return "/factory/error.jsp";
		}
		factoryService.deleteByIds(ids);
		return "redirect:/factory/factoryList.action";
	}
//	@RequestMapping("/factory/factoryDelete")
//	public String factoryDelete() {
//		System.out.println("================");
//		//System.out.println();
//		return "redirect:/factory/factoryList.action";
//	}

}
