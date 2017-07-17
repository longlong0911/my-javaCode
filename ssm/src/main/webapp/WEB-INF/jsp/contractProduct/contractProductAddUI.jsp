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
	<script type="text/javascript">
			function setValue(val){
				document.getElementById("factoryName").value=val;
			}	
	</script>
  </head>
  
  <body>
		<h3>新增货物信息</h3><br/>
		<a href="contract/contractList.action?contractId=${contractId}">返回</a>	
	<form action="contractProduct/contractProductAdd.action" method="post">
		<input type="hidden"  name="contractId" value="${contractId}" />
		排序号:<input name="orderNo"/><br/>
		生产厂家:
			<select name="factoryId" onchange="setValue(this.options[this.selectedIndex].text)">
				<option value="">--请选择--</option>
				<c:forEach items="${factoryList}" var="factory" varStatus="s">
					<option value="${factory.id}">${factory.factoryName}</option>
				</c:forEach>
			</select><br/>
		<input type="hidden" id="factoryName" name="factoryName" value=""/>	
		图片:<input name="productImage"/><br/>
		装率:<input name="loadingRate"/><br/>
		包装单位:
			<input id="packingUnit1" type="radio" name="packingUnit" value="1"/><label for="packingUnit1">只</label>
			<input id="packingUnit2" type="radio" name="packingUnit" value="2"/><label for="packingUnit2">套</label><br/>
		货物描述:<textarea name="productDesc" rows="3" cols="12"></textarea><br/>
		货号:<input name="productNo"/><br/>
		数量:<input name="cnumber"/><br/>
		箱数:<input name="boxNum"/><br/>
		单价:<input name="price"/><br/>
		附件:<textarea name="exts" rows="3" cols="12"></textarea><br/>
		
		<input type="submit" value="提交">
	</form>	
	
	<h3>货物信息列表</h3><br/>	
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
		<td>操作</td>
	</tr>
	</thead>
	<tbody>
	
	<c:forEach items="${contractProductList}" var="contractProduct" varStatus="status">
	<tr>
		<td>${status.index+1}</td>
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
		<td>
			<a href="contractProduct/contractProductUpdateUI.action?id=${contractProduct.id}">[修改]</a>
			<a href="contractProduct/contractProductDeleteById.action?id=${contractProduct.id}">[删除]</a>
			<a href="extCproduct/extCproductAddUI.action?contractProductId=${contractProduct.id}&contractId=${contractId}">[附件]</a>
		</td>
	</tr>
	</c:forEach>
	
	</tbody>
</table>
	
	
  </body>
</html>
