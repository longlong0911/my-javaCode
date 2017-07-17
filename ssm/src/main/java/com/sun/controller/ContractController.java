package com.sun.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sun.baseController.BaseController;
import com.sun.entity.Contract;
import com.sun.serviceI.ContractServiceI;
import com.sun.utils.ContractPrint;
import com.sun.vo.ContractVO;

@Controller
public class ContractController extends BaseController{
	@Resource
	private ContractServiceI contractService;

	// 单个列表页面
	@RequestMapping("/contract/contractListOne")
	public String contractListOne(HttpServletRequest request,String id) {
		ContractVO contract = contractService.findVO(id);
		request.setAttribute("contract",contract);
		return "/contract/contractListOne.jsp";
	}

	// 列表页面
	@RequestMapping("/contract/contractList")
	public String contractList(HttpServletRequest request) {
		List<Contract> contractList = contractService.findAll();
		request.setAttribute("contractList", contractList);
		return "/contract/contractList.jsp";
	}
	// 查看页面
	@RequestMapping("/contract/contractView")
	public String contractView(HttpServletRequest request) {
		List<Contract> contractList = contractService.findAll();
		request.setAttribute("contractList", contractList);
		return "/contract/contractView.jsp";
	}

	// 转到添加页面
	@RequestMapping("/contract/contractAddUI")
	public String contractAddUI(HttpServletRequest request) {
		return "/contract/contractAddUI.jsp";
	}

	// 添加
	@RequestMapping("/contract/contractAdd")
	public String contractAdd(Contract contract) {
		contractService.addContract(contract);
		return "redirect:/contract/contractList.action";
	}

	// 修改页面
	@RequestMapping("/contract/contractUpdateUI")
	public String contractUpdateUI(String id, HttpServletRequest request) {
		Contract contract = contractService.findById(id);
		request.setAttribute("contract", contract);
		return "/contract/contractUpdateUI.jsp";
	}

	// 修改
	@RequestMapping("/contract/contractUpdate")
	public String contractUpdate(Contract contract) {
		contractService.updateContract(contract);
		return "redirect:/contract/contractList.action";
	}

	// 修改状态
	@RequestMapping("/contract/contractStateOpen")
	public String contractStateOpen(@RequestParam("id")String[] ids) {
		contractService.contractStateOpen(ids);
		return "redirect:/contract/contractList.action";
	}

	// 修改状态
	@RequestMapping("/contract/contractStateClose")
	public String contractStateClose(@RequestParam("id")String[] ids) {
		contractService.contractStateClose(ids);
		return "redirect:/contract/contractList.action";
	}

	// 删除
	@RequestMapping("/contract/contractDelete")
	public String contractDelete(@RequestParam("id") String[] ids) {
		
		for(String id : ids){
			contractService.deleteByContractId(id);
		}
		return "redirect:/contract/contractList.action";
	}
	
	@RequestMapping("/contract/print")
	public void print(String id,HttpServletRequest request,HttpServletResponse response) throws Exception{
		
		ContractVO contract  = contractService.findVO(id);
		ContractPrint contractPrint = new ContractPrint();
		contractPrint.print(request, response, contract);
	}
	
	@RequestMapping("/contract/pigeonhole.action")
	public String pigeonhole(@RequestParam("id")String[] ids){
		contractService.intoHis(ids);
		return "redirect:/contract/hisContract.action";
	} 

	@RequestMapping("/contract/pigeonholeClose.action")
	public String pigeonholeClose(@RequestParam("id")String[] ids){
		contractService.intoFrom(ids);
		return "redirect:/contract/contractList.action";
	} 
	
	
	
	@RequestMapping("/contract/hisContract.action")
	public String hisContract(HttpServletRequest request){
		List<Contract> contractList = contractService.findHisContract();
		request.setAttribute("contractList", contractList);
		return "/contract/contractHisList.jsp";
	}
	
	@RequestMapping("/contract/input.action")
	public String input(HttpServletRequest request,HttpServletResponse response) throws IOException{
		ServletInputStream is = request.getInputStream();
		FileInputStream fis = new FileInputStream(new File("C:\\Users\\Administrator\\Desktop\\contract.xls")); 
		
		is.read();
		return "/contract/contractList.jsp";
	}
	
}
