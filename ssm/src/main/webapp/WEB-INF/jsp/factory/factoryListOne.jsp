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
		全称:${factory.fullName }<br/>
		简称:${factory.factoryName }<br/>
		联系人:${factory.contacts }<br/>
		电话:${factory.phone }<br/>
		手机:${factory.mobile }<br/>
		传真:${factory.fox }<br/>
		验货员 :${factory.inspector }<br/>
		备注:${factory.cnote }<br/>
		创建人:${factory.createBy }<br/>
		创建部门:${factory.createDept }<br/>
  </body>
</html>
