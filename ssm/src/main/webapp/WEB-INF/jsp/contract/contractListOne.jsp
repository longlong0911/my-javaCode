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
    
    <title>添加页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
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
  		客户名称:${contract.customName}<br/>
		收购方:${contract.offeror}<br/>
		*签订日期:<fmt:formatDate value="${contract.signingDate}" pattern="yyyy-MM-dd"/><br/>
		*签单人:${contract.inputBy}<br/>
		*重要程度:
			<c:if test="${contract.importNum==3}">★★★</c:if>			
			<c:if test="${contract.importNum==2}">★★</c:if>			
			<c:if test="${contract.importNum==1}">★</c:if><br/>			
		*船期:<fmt:formatDate value="${contract.shipTime}" pattern="yyyy-MM-dd"/><br/>
		要求:${contract.crequest}<br/>
		打印样式:
			<c:if test="${contract.printStyle==2}">两个货物</c:if>			
			<c:if test="${contract.printStyle==1}">一个货物</c:if>	<br/>		
		合同号:${contract.contractNo}<br/>
		*制单人:${contract.inputBy}<br/>
		*验货员:${contract.checkBy}<br/>
		交货日期:<fmt:formatDate value="${contract.deliveryPeriod}" pattern="yyyy-MM-dd"/><br/>
		贸易条款:${contract.tradeTerns}<br/>
		说明:${contract.customName}<br/>
		  	
  		<table>
	<thead>
	<tr>
		<td>序号</td>
		<td>生产厂家</td>
		<td>货号</td>
		<td>数量</td>
		<td>装率</td>
		<td>箱数</td>
		<td>单价</td>
		<td>包装单位</td>
		<td>总金额</td>
	</tr>
	</thead>
	<tbody>
	<c:forEach items="${contract.contractProducts}" var="contractProduct" varStatus="status">
		<c:if test="${contractProduct==null}">
			
		</c:if>
		<c:if test="${contractProduct!=null}">
			<tr>
				<td>${status.count}</td>
				<td>${contractProduct.factoryName}</td>
				<td>${contractProduct.productNo}</td>
				<td>${contractProduct.cnumber}</td>
				<td>${contractProduct.loadingRate}</td>
				<td>${contractProduct.boxNum}</td>
				<td>${contractProduct.price}</td>
				<td>
					<c:if test="${contractProduct.packingUnit==1}">只</c:if>
					<c:if test="${contractProduct.packingUnit==2}">套</c:if>
				</td>
				<td>${contractProduct.amount}</td>
			</tr>
		</c:if>
		<c:forEach items="${contractProduct.extCproducts}" var="ext" varStatus="status">
			<tr>
				<td align="right">&nbsp 附件:${status.index+1}</td>
				<td>${ext.factoryName}</td>
				<td>${ext.productNo}</td>
				<td>${ext.cnumber}</td>
				<td></td>
				<td></td>
				<td>${ext.price}</td>
				<td>
					<c:if test="${ext.packingUnit==1}">只</c:if>
					<c:if test="${ext.packingUnit==2}">套</c:if>
				</td>
				<td>${contractProduct.amount}</td>
			</tr>
		</c:forEach>
	
	</c:forEach>
	
	</tbody>
</table>
  	
  
  </body>
</html>
