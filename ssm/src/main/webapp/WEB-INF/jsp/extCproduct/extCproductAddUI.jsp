<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>附件添加页面</title>
    
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
	<script type="text/javascript">
			function setValue(val){
				document.getElementById("factoryName").value=val;
			}	
	</script>
  </head>
  
  <body>
		<h3>新增附件信息</h3><br/>	
		<a href="contractProduct/contractProductAddUI.action?contractProductId=${contractProductId}&contractId=${contractId}">返回</a>
	<form action="extCproduct/extCproductAdd.action" method="post">
		<input name="contractProductId" type="hidden" value="${contractProductId}"/>
		<input name="contractId" type="hidden" value="${contractId}"/>
		排序号:<input name="orderNo" /><br/>
		分类:
			<select name="ctype">
					<option value="">--请选择--</option>
					<c:forEach items="${codeList }" var="code" >
						<option value="${code.orderNo}">${code.name }</option>
					</c:forEach>			
			</select>
		<br/>
		生产厂家:
			<select name="factoryId" onchange="setValue(this.options[this.selectedIndex].text)">
					<option value="">--请选择--</option>
					<c:forEach items="${factoryList }" var="factory" >
						<option value="${factory.id}">${factory.factoryName }</option>
					</c:forEach>			
			</select>
			<input type="hidden" id="factoryName" name="factoryName" value=""/>
			<br/>
		货号:<input name="productNo" /><br/>
		数量:<input name="cnumber" /><br/>
		单价:<input name="price" /><br/>
		包装单位:
			<input id="packingUnit1" type="radio" name="packingUnit" value="1"/><label for="packingUnit1">只</label>
			<input id="packingUnit2" type="radio" name="packingUnit" value="2"/><label for="packingUnit2">套</label><br/>
		货物描述:
		<br/>	
			&nbsp&nbsp<textarea name="productDesc" rows="3" cols="12"></textarea>
		<br/>
		要求:
		<br/>
			&nbsp&nbsp<textarea name="productRequ" rows="3" cols="12"></textarea>
		<br/>
		<input type="submit" value="提交">
	</form>	
	
	<h3>附件信息列表</h3><br/>	
	<table>
	<thead>
	<tr>
		<td >
		<input type="checkbox" name="selid" onclick="checkAll('id',this)"></td>
		<td >序号</td>
		<td >生产厂家</td>
		<td >货号</td>
		<td >数量</td>
		<td >单价</td>
		<td >总金额</td>
		<td >操作</td>
	</tr>
	</thead>
	<tbody>
	
<c:forEach items="${extList}" var="ext" varStatus="status">
	<tr>
		<td><input type="checkbox" name="id" value="${ext.id}"/></td>
		<td>${status.index+1}</td>
		<td>${ext.factoryName}</td>
		<td>${ext.productNo}</td>
		<td>${ext.cnumber}</td>
		<td>${ext.price}</td>
		<td>${ext.amount}</td>
		<td>
			<a href="extCproduct/extCproductUpdateUI.action?id=${ext.id}&contractId=${contractId}">[修改]</a>
			<a href="extCproduct/extCproductDeleteById.action?id=${ext.id}&contractProductId=${contractProductId}&contractId=${contractId}">[删除]</a>
		</td>
	</tr>
	</c:forEach>
		
	</tbody>
</table>
	
	
  </body>
</html>
