<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>department</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
	  <frameset rows="100,*,30" border="1">
	  		<frame name="top" scrolling="no" src="<%=basePath%>/homeAction_top.action"/>
	  		<frameset cols="180,*">
	  			<frame name="left"  src="<%=basePath%>/homeAction_left.action"/>
	  			<frame name="right" src="<%=basePath%>/homeAction_right.action"/>
	  		</frameset>
	  		<frame name="bottom" scrolling="no" src="<%=basePath%>/homeAction_bottom.action"/>
	  </frameset>
  <body>
  </body>
</html>
