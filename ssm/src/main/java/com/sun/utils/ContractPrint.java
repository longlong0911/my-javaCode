package com.sun.utils;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFSimpleShape;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.sun.vo.ContractProductVO;
import com.sun.vo.ContractVO;

public class ContractPrint {
	
	public void print(HttpServletRequest request,HttpServletResponse response,ContractVO contract) throws Exception{
		//准备数据
//		PoiUtil poiUtil = new PoiUtil();       //>>>封装图片方法、划线
//		UtilFuns utilFuns = new UtilFuns();     //>>>处理日期格式
		List<ContractProductVO> cpList = contract.getContractProducts();
		String path = request.getSession().getServletContext().getRealPath("/");
		
		Map pageMap = null;    //每页的数据
		List<Map> pageList = new ArrayList();  //所有页数据集合
		
		for(int i=0;i<cpList.size();i++){
			ContractProductVO cp = cpList.get(i);
			pageMap = new HashMap<String,String>();
			
			pageMap.put("factoryName", "生产工厂："+cp.getFactory().getFactoryName());
			pageMap.put("contacts","联 系 人："+UtilFuns.convertNull(cp.getFactory().getContacts()));
			pageMap.put("phone", "电    话："+UtilFuns.convertNull(cp.getFactory().getPhone()));
			
			
			pageMap.put("offeror", "收 购 方："+contract.getOfferor());
			pageMap.put("contractNo", "合 同 号："+contract.getContractNo());
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String s = sdf.format(contract.getSigningDate());
			pageMap.put("signingDate","签单日期："+s);
			
			pageList.add(pageMap);
		}
		//
		Workbook wb = new HSSFWorkbook(new FileInputStream(new File(path+"/make/print/contract.xls")));
		Sheet sheetStyle = wb.getSheetAt(1);
		
		Row nRow = null;
		Cell nCell = null;

		
		nRow = sheetStyle.getRow(0);
		CellStyle shaanxiStyle = nRow.getCell(1).getCellStyle();
		
		nRow = sheetStyle.getRow(1);
		CellStyle jkStyle = nRow.getCell(1).getCellStyle();
		
		nRow = sheetStyle.getRow(2);
		CellStyle addressStyle = nRow.getCell(1).getCellStyle();
		
		nRow = sheetStyle.getRow(3);
		CellStyle companyStyle = nRow.getCell(1).getCellStyle();
		
		nRow = sheetStyle.getRow(4);
		CellStyle titleStyle = nRow.getCell(1).getCellStyle();
		
		nRow = sheetStyle.getRow(5);
		CellStyle subTitleStyle = nRow.getCell(1).getCellStyle();

		Sheet sheet = wb.getSheetAt(0);
		
		int rowNo = 0;
		int colNo = 0;
		
		//循环每页
		for(int j=0;j<pageList.size();j++){
			if(j>0){
				sheet.setRowBreak(rowNo++);		//在第startRow行设置分页符
			}

			pageMap = pageList.get(j);			//获取每页数据
		
			BufferedImage image = ImageIO.read(new FileInputStream(new File(path+"/make/print/logo.jpg")));
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(image, "jpg",baos);
			HSSFPatriarch patriarch = (HSSFPatriarch) sheet.createDrawingPatriarch();		//add picture
			HSSFClientAnchor anchor = new HSSFClientAnchor(20, 1, 1018, 0,(short) 2, rowNo, (short) 2, rowNo+4);
			patriarch.createPicture(anchor,wb.addPicture(baos.toByteArray(),HSSFWorkbook.PICTURE_TYPE_JPEG));
			
			nRow = sheet.createRow(rowNo++);
			nRow.setHeightInPoints(21f);
			nCell = nRow.createCell(3);
			nCell.setCellValue(" SHAANXI");
			nCell.setCellStyle(shaanxiStyle);
			
			nRow = sheet.createRow(rowNo++);
			nRow.setHeightInPoints(41f);
			nCell = nRow.createCell(3);
			nCell.setCellValue("     JK INTERNATIONAL ");
			nCell.setCellStyle(jkStyle);
			
			nRow = sheet.createRow(rowNo++);
			nRow.setHeightInPoints(20f);
			nCell = nRow.createCell(3);
			nCell.setCellValue("    西经济技术开发区西城一路27号无迪大厦19楼");
			nCell.setCellStyle(addressStyle);		
			
			nCell = nRow.createCell(6);
			nCell.setCellValue(" CO., LTD.");
			nCell.setCellStyle(companyStyle);		
			
			nRow = sheet.createRow(rowNo++);
			nRow.setHeightInPoints(15f);
			
			nRow = sheet.createRow(rowNo++);
			nRow.setHeightInPoints(7f);
			
			
			HSSFClientAnchor anchor2 = new HSSFClientAnchor(0, 0, 350, 0, (short) 2, 4, (short)8, 4);
			HSSFSimpleShape lineShape = patriarch.createSimpleShape(anchor2);
			lineShape.setShapeType(HSSFSimpleShape.OBJECT_TYPE_LINE);
			
			
			
			nRow = sheet.createRow(rowNo++);
			nRow.setHeightInPoints(30f);
			
			nCell = nRow.createCell(4);
			nCell.setCellValue("    购   销   合   同");
			nCell.setCellStyle(titleStyle);	
			
			nRow = sheet.createRow(rowNo++);
			nRow.setHeightInPoints(20f);
 			
			nCell = nRow.createCell(1);
			nCell.setCellValue((String) pageMap.get("offeror"));
			nCell.setCellStyle(subTitleStyle);	
			
			nCell = nRow.createCell(5);
			nCell.setCellValue((String)pageMap.get("factoryName"));
			nCell.setCellStyle(subTitleStyle);	
			
			nRow = sheet.createRow(rowNo++);
			nRow.setHeightInPoints(20f);
			
			nCell = nRow.createCell(1);
			nCell.setCellValue((String)pageMap.get("contractNo"));
			nCell.setCellStyle(subTitleStyle);	
			
			nCell = nRow.createCell(5);
			nCell.setCellValue((String)pageMap.get("contacts"));
			nCell.setCellStyle(subTitleStyle);	
			
			nRow = sheet.createRow(rowNo++);
			nRow.setHeightInPoints(20f);
			
			nCell = nRow.createCell(1);
			nCell.setCellValue((String)pageMap.get("signingDate"));
			nCell.setCellStyle(subTitleStyle);	
			
			nCell = nRow.createCell(5);
			nCell.setCellValue((String)pageMap.get("phone"));
			nCell.setCellStyle(subTitleStyle);	
		
		}

		
		
		try {
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			wb.write(os);
			String returnName = response.encodeURL(new String("出货表.xls".getBytes(),
					"iso8859-1")); // 保存的文件名,必须和页面编码一致,否则乱码
			response.addHeader("Content-Disposition", "attachment;filename="
					+ returnName); // 指定默认文件名
			response.setContentType("application/octet-stream;charset=utf-8"); // 设置文件类型
																				// excel
			response.setContentLength(os.size());

			ServletOutputStream outputstream = response.getOutputStream(); // 取得输出流
			os.writeTo(outputstream); // 写到输出流
			os.close(); // 关闭
			outputstream.flush(); // 刷数据
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}		
