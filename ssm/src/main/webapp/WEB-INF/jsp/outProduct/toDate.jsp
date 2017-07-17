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
    
    <title>月出货打印</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/datepicker/WdatePicker.js"></script>
	<script type="text/javascript">
		function formSubmit(url,sTarget){
			document.ff.target=sTarget;
			document.ff.action=url;
			document.ff.submit();
			return true;
		}
	</script>
  </head>
  
  <body>
		
		<form name="ff"  method="post">
			<a href="#" onclick="formSubmit('<%=basePath%>/outProduct/toPrint.action','_self');return false;">打印</a>
			<a href="#" onclick="formSubmit('<%=basePath%>/outProduct/toPrintTemplate.action','_self');return false">模板打印</a>
			
			<br/>
			<br/>
			<br/>
			
			船期:<input type="text" style="width:90px;" name="inputDate" readonly
			             onclick="WdatePicker({el:this,isShowOthers:true,dateFmt:'yyyy-MM'});"/><br/>
		</form>	             
  </body>
</html>
