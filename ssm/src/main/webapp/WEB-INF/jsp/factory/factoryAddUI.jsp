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
  </head>
  
  <body>
	<form  action="factory/factoryAdd.action" method="post">
		全称:<input name="fullName"><br/>
		简称:<input name="factoryName"><br/>
		联系人:<input name="contacts"><br/>
		电话:<input name="phone"><br/>
		手机:<input name="mobile"><br/>
		传真:<input name="fox"><br/>
		验货员 :<input name="inspector"><br/>
		备注:<textarea name="cnote" rows="5" cols="15"></textarea><br/>
		创建人:<input name="createBy"><br/>
		创建部门:<input name="createDept"><br/>
		<input type="submit" value="提交">
	</form>	
  </body>
</html>
