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
		<h3>修改附件信息</h3><br/>	
		
	<form action="extCproduct/extCproductUpdate.action" method="post">
		<input type="hidden" name="id" value="${ext.id }"/>
		<input type="hidden" name="contractProductId" value="${ext.contractProductId }"/>
		<input type="hidden" name="contractId" value="${contractId }"/>
		排序号:<input name="orderNo" value="${ext.orderNo }"/><br/>
		分类:
			<select name="ctype">
					<option value="">--请选择--</option>
					<c:forEach items="${codeList }" var="code" >
						<option value="${code.orderNo}" <c:if test="${ext.ctype==code.orderNo}">selected</c:if>>
							${code.name }
						</option>
					</c:forEach>			
			</select>
		<br/>
		生产厂家:
			<select name="factoryId" onchange="setValue(this.options[this.selectedIndex].text)">
					<option value="">--请选择--</option>
					<c:forEach items="${factoryList }" var="factory" >
						<option value="${factory.id}" <c:if test="${ext.factoryId==factory.id}">selected</c:if>>
							${factory.factoryName }
						</option>
					</c:forEach>			
			</select>
			<input type="hidden" id="factoryName" name="factoryName" value="${ext.factoryName }"/>
			<br/>
		货号:<input name="productNo" value="${ext.productNo }"/><br/>
		数量:<input name="cnumber" value="${ext.cnumber }" /><br/>
		单价:<input name="price" value="${ext.price }" /><br/>
		货物描述:
		<br/>	
			&nbsp&nbsp<textarea name="productDesc" rows="3" cols="12">${ext.productDesc }</textarea>
		<br/>
		要求:
		<br/>
			&nbsp&nbsp<textarea name="productRequest" rows="3" cols="12">${ext.productRequest }</textarea>
		<br/>
		<input type="submit" value="提交">
	</form>	
		
	
  </body>
</html>
