package com.sun.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sun.baseController.BaseController;
import com.sun.entity.PackingList;
import com.sun.serviceI.PackingListServiceI;

@Controller
public class PackingListController extends BaseController{
	
	@Resource
	private PackingListServiceI plService;
	
	@RequestMapping("/packingList/packingListList.action")
	public String list(HttpServletRequest request){
		
		List<PackingList> plList = plService.findAll();
		
		request.setAttribute("plList",plList);
		return "/packingList/packingListList.jsp";
	}
	
	@RequestMapping("/packingList/packingListAddUI.action")
	public String addUI(HttpServletRequest request,@RequestParam("id")String[] ids){
		//这里的id是报运的id
		String buf = plService.findCustomerContract(ids);
		request.setAttribute("buf",buf);
		return "/packingList/packingListAddUI.jsp";
	}
	
	@RequestMapping("/packingList/packingListAdd.action")
	public String add(PackingList packingList){
		
		String[] tmpIds = packingList.getExportIds().split(",");	//exportId|exportNo
		StringBuffer ids = new StringBuffer();
		StringBuffer nos = new StringBuffer();
		
		for(int i=0;i<tmpIds.length;i++){
			
			String[] tmp = tmpIds[i].split("\\|");
			
			ids.append(tmp[0]).append("|");
			nos.append(tmp[1]).append("|");
		}
		ids.delete(ids.length()-1, ids.length());
		nos.delete(nos.length()-1, nos.length());
		
		packingList.setExportIds(ids.toString());
		packingList.setExportNos(nos.toString());

		plService.addPackingList(packingList);
		
		return "redirect:/packingList/packingListList.action";
	}
	
	@RequestMapping("/packingList/packingListDelete.action")
	public String delete(@RequestParam("id")String[] ids){
		
		for(String id : ids){
			plService.deleteById(id);
		}
		return "redirect:/packingList/packingListList.action";
	}

	@RequestMapping("/packingList/packingListUpdateUI.action")
	public String updateUI(String id){
		return "/packingList/packingListUpdateUI.jsp";
	}
	
	@RequestMapping("/packingList/packingListUpdate.action")
	public String update(String id){
		
		
		return "redirect:/packingList/packingListList.action";
	}
	
}
