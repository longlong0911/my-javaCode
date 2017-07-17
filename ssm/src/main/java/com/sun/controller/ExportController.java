package com.sun.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sun.baseController.BaseController;
import com.sun.entity.Export;
import com.sun.entity.ExportProduct;
import com.sun.serviceI.ContractServiceI;
import com.sun.serviceI.ExportProductServiceI;
import com.sun.serviceI.ExportServiceI;
import com.sun.utils.UtilFuns;

@Controller
public class ExportController extends BaseController{
	@Resource
	private ExportServiceI exportService;
	@Resource
	private ExportProductServiceI exportProductService;
	@Resource
	private ContractServiceI contractService;
	
	
	@RequestMapping("export/exportList.action")
	public String list(HttpServletRequest request){
		
		List<Export> exportList =  exportService.findAll();
		request.setAttribute("exportList",exportList);

		return "/export/exportList.jsp";
	}
	

	@RequestMapping("export/add.action")
	public String add(@RequestParam("id")String[] ids){   //合同的id
		exportService.addExport(ids);
		return "redirect:/export/exportList.action";
	}

	@RequestMapping("export/updateExportUI.action")
	public String updateUI(String id,HttpServletRequest request){   //合同的id
		
		//准备数据
		//1.报运主信息
		Export export = exportService.findById(id);
		request.setAttribute("export",export);
		
		//2.货物信息	addTRRecord('mRecordTable', id, productNo, cnumber, grossWeight, netWeight, sizeLength, sizeWidth, sizeHeight, exPrice, tax)
		List<ExportProduct> epList = exportProductService.findByExportId(export.getId());	//某个报运下的货物信息
		
		StringBuffer buf = new StringBuffer();
		for(ExportProduct ep : epList){
			buf.append("addTRRecord('mRecordTable', '")
			   .append(ep.getId()).append("', '")
			   .append(ep.getProductNo()).append("', '")
			   .append(ep.getCnumber()).append("', '")
			   .append(UtilFuns.convertNull(ep.getGrossWeight())).append("', '")
			   .append(UtilFuns.convertNull(ep.getNetWeight())).append("', '")
			   .append(UtilFuns.convertNull(ep.getSizeLength())).append("', '")
			   .append(UtilFuns.convertNull(ep.getSizeWidth())).append("', '")
			   .append(UtilFuns.convertNull(ep.getSizeHeight())).append("', '")
			   .append(UtilFuns.convertNull(ep.getExPrice())).append("', '")
			   .append(UtilFuns.convertNull(ep.getTax())).append("');");
		}
		
		request.setAttribute("recordData", buf.toString());
		return "/export/exportUpdateUI.jsp";
	}
	
	@RequestMapping("export/updateExport.action")
	public String update(Export export,
			Integer[] mr_orderNo,
			String[] mr_id,
			Integer[] mr_changed,
			Integer[] mr_cnumber,
			Double[] mr_grossWeight,
			Double[] mr_netWeight,
			Double[] mr_sizeLength,
			Double[] mr_sizeWidth,
			Double[] mr_sizeHeight,
			Double[] mr_exPrice,
			Double[] mr_tax
		){
		exportService.updateExport(export,mr_orderNo,mr_id,mr_changed,mr_cnumber,
			mr_grossWeight,mr_netWeight,mr_sizeLength,mr_sizeWidth,mr_sizeHeight,mr_exPrice,mr_tax);
	
		return "redirect:/export/exportList.action";
	}
	
	
	@RequestMapping("export/deleteExport.action")
	public String delete(@RequestParam("id")String[] ids){
		exportService.deleteByIds(ids);
		return "redirect:/export/exportList.action";
	}
	
	
	
}
