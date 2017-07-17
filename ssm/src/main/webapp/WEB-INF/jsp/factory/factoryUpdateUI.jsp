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
    
    <title>My JSP 'factoryList.jsp' starting page</title>
    
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
	<form  action="factory/factoryUpdate.action" method="post">
		
		<input type="hidden" name="id" value="${factory.id}"><br/>
		全称:<input name="fullName" value="${factory.fullName }"><br/>
		简称:<input name="factoryName" value="${factory.factoryName }"><br/>
		联系人:<input name="contacts" value="${factory.contacts }"><br/>
		电话:<input name="phone" value="${factory.phone }"><br/>
		手机:<input name="mobile" value="${factory.mobile }"><br/>
		传真:<input name="fox" value="${factory.fox }"><br/>
		验货员 :<input name="inspector" value="${factory.inspector }"><br/>
		备注:<textarea name="cnote" rows="5" cols="15" value="${factory.cnote }"></textarea><br/>
		创建人:<input name="createBy" value="${factory.createBy }"><br/>
		创建部门:<input name="createDept" value="${factory.createDept }"><br/>
		<input type="submit" value="提交">
	</form>	
  </body>
</html>
