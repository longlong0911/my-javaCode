package com.sun.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sun.baseController.BaseController;
import com.sun.entity.Code;
import com.sun.entity.ExtCproduct;
import com.sun.entity.Factory;
import com.sun.serviceI.CodeServiceI;
import com.sun.serviceI.ExtCproductServiceI;
import com.sun.serviceI.FactoryServiceI;

@Controller
public class ExtCproductController extends BaseController{
	@Resource
	private ExtCproductServiceI extCproductService;
	@Resource
	private FactoryServiceI factoryService;
	@Resource
	private CodeServiceI codeService;

	// 转到添加页面
	@RequestMapping("/extCproduct/extCproductAddUI")
	public String extCproductAddUI(HttpServletRequest request,String contractProductId,String contractId) {
		List<Factory> factoryList = factoryService.findAll();
		request.setAttribute("factoryList",factoryList);
		List<Code> codeList = codeService.findAll();
		request.setAttribute("codeList",codeList);
		request.setAttribute("contractProductId",contractProductId);
		request.setAttribute("contractId",contractId);
		
		List<ExtCproduct> extList = (List<ExtCproduct>) extCproductService.findByParam(contractProductId);
		request.setAttribute("extList",extList);
		
		return "/extCproduct/extCproductAddUI.jsp";
	}

	// 添加
	@RequestMapping("/extCproduct/extCproductAdd")
	public String extCproductAdd(ExtCproduct extCproduct,String contractId,Model model) {
		extCproductService.addExtCproduct(extCproduct);
		model.addAttribute("contractProductId",extCproduct.getContractProductId());
		model.addAttribute("contractId",contractId);
		
		return "redirect:/extCproduct/extCproductAddUI.action";
	}
//
	// 修改页面
	@RequestMapping("/extCproduct/extCproductUpdateUI")
	public String extCproductUpdateUI(String id,String contractId, HttpServletRequest request) {
		ExtCproduct ext = extCproductService.findById(id);
		
		request.setAttribute("ext",ext);
		request.setAttribute("contractId",contractId);
		
		List<Factory> factoryList = factoryService.findAll();
		request.setAttribute("factoryList",factoryList);
		List<Code> codeList = codeService.findAll();
		request.setAttribute("codeList",codeList);
		return "/extCproduct/extCproductUpdateUI.jsp";
	}
//
	// 修改
	@RequestMapping("/extCproduct/extCproductUpdate")
	public String extCproductUpdate(ExtCproduct extCproduct,String contractId,Model model) {
		extCproductService.updateExtCproduct(extCproduct);
		model.addAttribute("contractProductId",extCproduct.getContractProductId());
		model.addAttribute("contractId",contractId);
		return "redirect:/extCproduct/extCproductAddUI.action";
	}

	
	// 删除
	@RequestMapping("/extCproduct/extCproductDeleteById")
	public String extCproductDelete(String id,String contractId,Model model) {
		
		ExtCproduct extCproduct = extCproductService.findById(id);
		model.addAttribute("contractProductId",extCproduct.getContractProductId());
		model.addAttribute("contractId",contractId);
		extCproductService.deleteById(id);
		
		return "redirect:/extCproduct/extCproductAddUI.action";
	}

}
