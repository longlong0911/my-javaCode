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
		<h3>修改货物信息</h3><br/>
	<form action="contractProduct/contractProductUpdate.action" method="post">
		<input type="hidden" name="id" value="${contractProduct.id}">	
		<input type="hidden" name="contractId" value="${contractProduct.contractId}">	
		排序号:<input name="orderNo" value="${contractProduct.orderNo }"/><br/>
		生产厂家:
			<select name="factoryId"  onchange="setValue(this.options[this.selectedIndex].text)">
				<option value="">--请选择--</option>
				<c:forEach items="${factoryList}" var="factory">
					<option value="${factory.id}" <c:if test="${contractProduct.factoryId==factory.id}">selected</c:if>>
							${factory.factoryName}
					</option>
				</c:forEach>
			</select><br/>
		<input type="hidden" id="factoryName" name="factoryName" value="${contractProduct.factoryName}"/>	
		图片:<input name="productImage" value="${contractProduct.productImage}"/><br/>
		装率:<input name="loadingRate" value="${contractProduct.loadingRate}"/><br/>
		包装单位:
			<input id="packingUnit1" type="radio" name="packingUnit" <c:if test="${contractProduct.packingUnit==1}">checked</c:if> value="1"/><label for="packingUnit1">只</label>
			<input id="packingUnit2" type="radio" name="packingUnit" <c:if test="${contractProduct.packingUnit==2}">checked</c:if>  value="2"/><label for="packingUnit2">套</label><br/>
		货物描述:
		<textarea rows="3" cols="12" name="productDesc">${contractProduct.productDesc }</textarea>
		<br/>
		货号:<input name="productNo" value="${contractProduct.productNo }"/><br/>
		数量:<input name="cnumber" value="${contractProduct.cnumber }"/><br/>
		箱数:<input name="boxNum" value="${contractProduct.boxNum }"/><br/>
		单价:<input name="price" value="${contractProduct.price }"/><br/>
		附件:<textarea name="exts" rows="3" cols="12">${contractProduct.exts }</textarea><br/>
		<input type="submit" value="提交">
	</form>	
	
	
  </body>
</html>
