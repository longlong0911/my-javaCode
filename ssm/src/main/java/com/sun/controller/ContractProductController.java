package com.sun.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sun.baseController.BaseController;
import com.sun.entity.ContractProduct;
import com.sun.entity.Factory;
import com.sun.serviceI.ContractProductServiceI;
import com.sun.serviceI.FactoryServiceI;

@Controller
public class ContractProductController extends BaseController{
	@Resource
	private ContractProductServiceI contractProductService;
	@Resource
	private FactoryServiceI factoryService;

	// 转到添加页面
	@RequestMapping("/contractProduct/contractProductAddUI")
	public String contractProductAddUI(HttpServletRequest request,String contractId) {
		//可选的工厂
		List<Factory> factoryList = factoryService.findAll();
		request.setAttribute("factoryList",factoryList);
		request.setAttribute("contractId", contractId);
		//货物信息
		List<ContractProduct> contractProductList =  contractProductService.findByContractId(contractId);
		request.setAttribute("contractProductList",contractProductList);
		return "/contractProduct/contractProductAddUI.jsp";
	}

	// 添加
	@RequestMapping("/contractProduct/contractProductAdd")
	public String contractProductAdd(ContractProduct contractProduct,Model model) {
			contractProductService.addContractProduct(contractProduct);
			model.addAttribute("contractId",contractProduct.getContractId());
			
		return "redirect:/contractProduct/contractProductAddUI.action";
	}
//
	// 修改页面
	@RequestMapping("/contractProduct/contractProductUpdateUI")
	public String contractProductUpdateUI(String id,HttpServletRequest request) {
		ContractProduct contractProduct = contractProductService.findById(id);
		request.setAttribute("contractProduct", contractProduct);
		List<Factory> factoryList = factoryService.findAll();
		request.setAttribute("factoryList",factoryList);
		
		return "/contractProduct/contractProductUpdateUI.jsp";
	}
//
	// 修改
	@RequestMapping("/contractProduct/contractProductUpdate")
	public String contractProductUpdate(ContractProduct contractProduct,Model model) {
		contractProductService.updateContractProduct(contractProduct);
		model.addAttribute("contractId",contractProduct.getContractId());
		return "redirect:/contractProduct/contractProductAddUI.action";
	}

	
	// 删除
	@RequestMapping("/contractProduct/contractProductDeleteById")
	public String contractProductDelete(String id,Model model) {
		
		ContractProduct contractProduct = contractProductService.findById(id);
		model.addAttribute("contractId",contractProduct.getContractId());
		contractProductService.deleteById(id);
		return "redirect:/contractProduct/contractProductAddUI.action";
	}

}
