package com.sun.controller;



import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sun.baseController.BaseController;
import com.sun.serviceI.OutProductServiceI;
import com.sun.utils.DownloadUtil;
import com.sun.vo.OutProductVO;

@Controller
public class OutProductController extends BaseController{

	@Resource
	private OutProductServiceI outProductService;
	
	//转向输入年月的页面	
	@RequestMapping("/outProduct/toDate")
	public String toDate(){
		
		return "/outProduct/toDate.jsp";
	}
	
	
	@RequestMapping("/outProduct/toPrintTemplate.action")
	public void toPrintTemplate(String inputDate, HttpServletRequest request, HttpServletResponse response) throws IOException{
		List<OutProductVO> dataList = outProductService.find(inputDate);
		//打开模板文件
		String path = request.getSession().getServletContext().getRealPath("/");		//jdk1.8 bug 在linux下不带后面你写的路径
		String tempFile = path + "/make/print/outProduct.xlsx";
		//tempFile = "c:\\tOUTPRODUCT.xls";
		Workbook wb = new XSSFWorkbook(new FileInputStream(new File(tempFile)));
		
		//写入内容
		Sheet sheet = wb.getSheetAt(0);		//获得工作表sheet
		Row nRow = null;
		Cell nCell = null;
		int rowNo = 2;
		int colNo = 1;
		
		//获取样式
		nRow = sheet.getRow(2);									//获得行对象
		nCell = nRow.getCell(1);								//获取单元格对象
		CellStyle customNameStyle = nCell.getCellStyle();		//获取到样式
		
		nCell = nRow.getCell(2);
		CellStyle contractNoStyle = nCell.getCellStyle();
		
		nCell = nRow.getCell(3);
		CellStyle productNoStyle = nCell.getCellStyle();
		
		nCell = nRow.getCell(4);
		CellStyle cnumberStyle = nCell.getCellStyle();
		
		nCell = nRow.getCell(5);
		CellStyle factoryStyle = nCell.getCellStyle();
		
		nCell = nRow.getCell(6);
		CellStyle extStyle = nCell.getCellStyle();
		
		nCell = nRow.getCell(7);
		CellStyle dateStyle = nCell.getCellStyle();
		
		nCell = nRow.getCell(9);
		CellStyle tradeStyle = nCell.getCellStyle();
		
		//大标题
		nRow = sheet.getRow(0);
		nCell = nRow.getCell(1);
		nCell.setCellValue(inputDate.replaceFirst("-", "年") + "月份出货表");			//yyyy-MM

		//处理数据
		for(int j=0;j<dataList.size();j++){
			//System.out.println(rowNo);
			
			colNo = 1;								//列号初始化
			OutProductVO op = dataList.get(j);		//获取出货表对象
			
			nRow = sheet.createRow(rowNo++);
			nRow.setHeightInPoints(24);
			
			nCell = nRow.createCell(colNo++);
			nCell.setCellValue(op.getCustomName());
			nCell.setCellStyle(customNameStyle);	//设置样式
			
			nCell = nRow.createCell(colNo++);
			nCell.setCellValue(op.getContractNo());
			nCell.setCellStyle(contractNoStyle);
			
			nCell = nRow.createCell(colNo++);
			nCell.setCellValue(op.getProductNo());
			nCell.setCellStyle(productNoStyle);
			
			nCell = nRow.createCell(colNo++);
			nCell.setCellValue(op.getCnumber());
			nCell.setCellStyle(cnumberStyle);
			
			nCell = nRow.createCell(colNo++);
			nCell.setCellValue(op.getFactoryName());
			nCell.setCellStyle(factoryStyle);
			
			nCell = nRow.createCell(colNo++);
			nCell.setCellValue(op.getExts());
			nCell.setCellStyle(extStyle);
			
			nCell = nRow.createCell(colNo++);
			nCell.setCellValue(op.getDeliveryPeriod());
			nCell.setCellStyle(dateStyle);
			
			nCell = nRow.createCell(colNo++);
			nCell.setCellValue(op.getShipTime());
			nCell.setCellStyle(dateStyle);
			
			nCell = nRow.createCell(colNo++);
			nCell.setCellValue(op.getTradeTerns());
			nCell.setCellStyle(tradeStyle);
		}
		
		//下载
		DownloadUtil du = new DownloadUtil();
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		wb.write(os);
		du.download(os, response, "出货表.xlsx");
	}

	
	
	
	//转向打印
	@RequestMapping("/outProduct/toPrint")
	public void toPrint(String inputDate,HttpServletResponse response,HttpServletRequest request) throws IOException{
		if(inputDate.isEmpty()){
			try {
				response.sendRedirect("/ssm/outProduct/toDate.action");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		//System.out.println(">>>>>>>>>>>>>>>>"+inputDate);
		
		//出货信息
		List<OutProductVO> outProducts = outProductService.find(inputDate);
		
		Workbook wb = new HSSFWorkbook();
		Sheet sheet = wb.createSheet();
		
		Row row = null;
		Cell cell = null;
		
		int rowNum = 0;
		int cosNum = 1;
		
		sheet.setColumnWidth(0, 10*272);		//列宽
		sheet.setColumnWidth(1, 26*272);	//列宽 BUG，API底层设置不够精确 256；272近似
		sheet.setColumnWidth(2, 12*272);
		sheet.setColumnWidth(3, 29*272);
		sheet.setColumnWidth(4, 10*272);
		sheet.setColumnWidth(5, 12*272);
		sheet.setColumnWidth(6, 8*272);
		sheet.setColumnWidth(7, 10*272);
		sheet.setColumnWidth(8, 10*272);
		sheet.setColumnWidth(9, 8*272);
		
		sheet.addMergedRegion(new CellRangeAddress(0,0,1,9));
		
		row = sheet.createRow(rowNum++);
		row.setHeightInPoints((short)36);
		cell = row.createCell(cosNum);
		cell.setCellValue(inputDate.replace('-','年')+"月出货表");
		CellStyle cs = wb.createCellStyle();
		cs.setAlignment(CellStyle.ALIGN_CENTER);
		cs.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		cell.setCellStyle(cs);
		
		String[] headContent = new String[]{"客户","订单号","货号","数量","工厂","附件","工厂交期","船期","贸易条款"};
		
		row = sheet.createRow(rowNum++);
		row.setHeightInPoints((short)20);
		for(int i=0;i<headContent.length;i++){
			cell = row.createCell(cosNum++);
			cell.setCellValue(headContent[i]);
		}
		
		for(int i=0; i<outProducts.size();i++){
			row = sheet.createRow(rowNum++);
			row.setHeightInPoints((short)20);
			int n= 1;
			cell = row.createCell(n++);
			cell.setCellValue(outProducts.get(i).getCustomName());
			
			cell = row.createCell(n++);
			cell.setCellValue(outProducts.get(i).getContractNo());
			
			cell = row.createCell(n++);
			cell.setCellValue(outProducts.get(i).getProductNo());
			
			cell = row.createCell(n++);
			cell.setCellValue(outProducts.get(i).getCnumber());
			
			cell = row.createCell(n++);
			cell.setCellValue(outProducts.get(i).getFactoryName());
			
			cell = row.createCell(n++);
			cell.setCellValue(outProducts.get(i).getExts());
			
			cell = row.createCell(n++);
			cell.setCellValue(outProducts.get(i).getDeliveryPeriod());
			
			cell = row.createCell(n++);
			cell.setCellValue(outProducts.get(i).getShipTime());
			
			cell = row.createCell(n++);
			cell.setCellValue(outProducts.get(i).getTradeTerns());
			
		}
		
		
		
		
		
		
//		OutputStream os = new FileOutputStream(new File("c:\\ceshi.xls"));
//		wb.write(os);
//		os.flush();
//		os.close();
		
		DownloadUtil du = new DownloadUtil();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		wb.write(baos);
		du.download(baos, response, "出货表.xls");
		
		
	}
}
	