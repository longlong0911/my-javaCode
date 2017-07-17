package com.sun.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sun.utils.SqlDao;

@Controller
public class ChartController {
	@Resource
	SqlDao sqlDao;
	
	
	//饼状图
	@RequestMapping("/stat/factorySale.action")
	public String factorySale(HttpServletRequest request) throws IOException{
//		  开发步骤:
//		  1、获取数据，封装到List<String>
//		  2、拼接xml结构，生成对应目录下的data.xml文本文件
//		  3、返回对应目录index.xml，调用stat.jsp
		String path = request.getSession().getServletContext().getRealPath("/");
		String sql = "SELECT f.factory_name,cp.sumnum FROM (SELECT factory_id,factory_name FROM factory_c WHERE state=1) f LEFT JOIN (SELECT factory_id,SUM(cnumber) AS sumnum FROM contract_product_c GROUP BY factory_id ) cp ON f.factory_id=cp.factory_id WHERE cp.sumnum IS NOT NULL";
		List<String> oList = sqlDao.executeSQL(sql);
		
		StringBuffer sBuf = new StringBuffer();
		sBuf.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sBuf.append("<pie>");
		for(int i=0;i<oList.size();){
			sBuf.append("  <slice title=\"").append(oList.get(i++)).append("\" pull_out=\"true\">").append(oList.get(i++)).append("</slice>");
		}
		sBuf.append("</pie>");
		
		File f =  new File(path+"/stat/chart/factorysale/data.xml");
		if(f.exists()){
			f.createNewFile();
		}
		FileWriter fw = new FileWriter(path+"/stat/chart/factorysale/data.xml");
		
		fw.write(sBuf.toString());
		fw.close();

		return "/stat/stat.jsp?forward=chart/factorysale";
	}
	
	
	//柱状图
	@RequestMapping("stat/productSale.action")
	public String productSale(HttpServletRequest request) throws IOException{
		String sql = "SELECT product_no,SUM(cnumber) AS sumnum FROM contract_product_c GROUP BY product_no ORDER BY sumnum DESC ";
		String path = request.getSession().getServletContext().getRealPath("/");
		
		List<String> oList = sqlDao.executeSQL(sql);
		
		int xid = 0;
		StringBuffer sBuf = new StringBuffer();
		sBuf.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sBuf.append("<chart>");
		sBuf.append("	<series>");
		
		for(int i=0;i<oList.size();){
			sBuf.append("		<value xid=\"").append(xid++).append("\">").append(oList.get(i++)).append("</value>");
			i++;		//skip
		}
		
		sBuf.append("	</series>");
		sBuf.append("	<graphs>");
		sBuf.append("		<graph gid=\"1\">");
		
		xid = 0;
		for(int i=0;i<oList.size();){
			i++;		//skip
			sBuf.append("			<value xid=\"").append(xid++).append("\" color=\"#318DBD\">").append(oList.get(i++)).append("</value>");
		}
		
		sBuf.append("		</graph>");
		sBuf.append("	</graphs>");
		sBuf.append("</chart>");
		
		
		File f =  new File(path+"/stat/chart/productsale/data.xml");
		if(f.exists()){
			f.createNewFile();
		}
		FileWriter fw = new FileWriter(path+"/stat/chart/productsale/data.xml");
		
		fw.write(sBuf.toString());
		fw.close();

		return "/stat/stat.jsp?forward=chart/productsale";
	}

	//曲线图
	@RequestMapping("stat/onlineinfo.action")
	public String onlineinfo(HttpServletRequest request) throws IOException{
		String sql = "SELECT t.a1,nvl(p.countnum,0) AS countnum FROM (SELECT a1 FROM online_t)  t LEFT JOIN (SELECT  SUBSTR(login_time,11,2)AS A1,COUNT(login_time) AS countnum FROM login_log_p GROUP BY SUBSTR(login_time,11,2) ) p  ON t.a1=p.a1 order by A1 ";
		String path = request.getSession().getServletContext().getRealPath("/");
		
		List<String> oList = sqlDao.executeSQL(sql);
		
		System.out.println(">>>>>>>>>>>>>>"+oList.get(1));
		
		int xid = 0;
		StringBuffer sBuf = new StringBuffer();
		sBuf.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sBuf.append("<chart>");
		sBuf.append("	<series>");
		
		for(int i=0;i<oList.size();){
			sBuf.append("		<value xid=\"").append(xid++).append("\">").append(oList.get(i++)).append("</value>");
			i++;		//skip
		}
		
		sBuf.append("	</series>");
		sBuf.append("	<graphs>");
		sBuf.append("		<graph gid=\"1\">");
		
		xid = 0;
		for(int i=0;i<oList.size();){
			i++;		//skip
			sBuf.append("			<value xid=\"").append(xid++).append("\" color=\"#318DBD\">").append(oList.get(i++)).append("</value>");
		}
		
		sBuf.append("		</graph>");
		sBuf.append("	</graphs>");
		sBuf.append("</chart>");
		
		File f =  new File(path+"/stat/chart/productsale/data.xml");
		if(f.exists()){
			f.createNewFile();
		}
		FileWriter fw = new FileWriter(path+"/stat/chart/productsale/data.xml");
		
		fw.write(sBuf.toString());
		fw.close();
		
		return "/stat/stat.jsp?forward=chart/onlineinfo";
	}
	
}
