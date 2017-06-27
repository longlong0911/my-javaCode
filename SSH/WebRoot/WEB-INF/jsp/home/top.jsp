<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>TopMenu</title>
	<%@ include file="/WEB-INF/jsp/public/common.jspf"%>
	<style type="text/css">
		#button{
			float:right;
			margin:50px 10px;
		}
	</style>
</head>
	  
  <body>
  	<div id="button">
            <a href="${pageContext.request.contextPath}/userAction_logOut.action" target="_parent">
                <img width="78" height="20" alt="退出系统" src="${pageContext.request.contextPath}/style/blue/images/top/logout.gif" />
            </a>
    </div>
  </body>
</html>
