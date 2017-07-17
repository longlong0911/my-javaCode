<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'factoryList.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/datepicker/WdatePicker.js"></script>
	<style type="text/css">
		table{
			border:1px solid red;
			border-collapse:collapse;
		}
		table td{
			border:1px solid red;
			width:100px;
			height:30px;
		}
	</style>
  </head>
  
  <body>
<form action="contract/contractUpdate.action" method="post">
		<input name="id" type="hidden" value="${contract.id}"/>
		客户名称:<input name="customName" value="${contract.customName }"><br/>
		收购方:<input name="offeror" value="${contract.offeror }"><br/>
		*签订日期:<input type="text" style="width:90px;" name="signingDate" value="<fmt:formatDate value="${contract.signingDate}" pattern="yyyy-MM-dd"/>" readonly
			             onclick="WdatePicker({el:this,isShowOthers:true,dateFmt:'yyyy-MM-dd'});"/><br/>
		*重要程度:
				<input id="importNum3" name="importNum" <c:if test="${contract.importNum==3}">checked</c:if> type="radio" value="3"><font><label for="importNum3">★★★</label></font>
				<input id="importNum2" name="importNum" <c:if test="${contract.importNum==2}">checked</c:if> type="radio" value="2"><font><label for="importNum2">★★</label></font>
				<input id="importNum1" name="importNum" <c:if test="${contract.importNum==1}">checked</c:if> type="radio" value="1"><font><label for="importNum1">★</label></font><br/>
				
		*船期:<input type="text" style="width:90px;" name="shipTime" value="<fmt:formatDate value="${contract.shipTime}" pattern="yyyy-MM-dd"/>" readonly
			             onclick="WdatePicker({el:this,isShowOthers:true,dateFmt:'yyyy-MM-dd'});"/><br/>
		要求:<textarea name="crequest" value="${contract.crequest}" rows="3" cols="15"></textarea><br/>
		打印样式:<input id="product2" name="printStyle" <c:if test="${contract.printStyle==2}">checked</c:if> type="radio" value="2"><font><label for="product2">两个货物</label></font>
			   <input id="product1" name="printStyle" <c:if test="${contract.printStyle==1}">checked</c:if> type="radio" value="1"><font><label for="product1">一个货物</label></font><br/>
		合同号:<input name="contractNo" value="${contract.contractNo}"><br/>
		*制单人:<input name="inputBy" value="${contract.inputBy}"><br/>
		*审单人:<input name="checkBy" value="${contract.checkBy}"><br/>
		*验货员:<input name="inspector" value="${contract.inspector}"><br/>     
		交货日期:<input type="text" style="width:90px;" name="deliveryPeriod" value="<fmt:formatDate value="${contract.deliveryPeriod}" pattern="yyyy-MM-dd"/>" readonly
			             onclick="WdatePicker({el:this,isShowOthers:true,dateFmt:'yyyy-MM-dd'});"/><br/>
		贸易条款:<input name="tradeTerns" value="${contract.tradeTerns}"><br/>
		说明:<textarea name="remark" value="${contract.remark}" rows="3" cols="15"></textarea><br/>
		
		<input type="submit" value="提交">
	</form>  </body>
</html>
