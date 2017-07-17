<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="now" class="java.util.Date" />
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title></title>

    <!-- 调用样式表 -->
    <link rel="stylesheet" rev="stylesheet" type="text/css" href="${ctx}/skin/default/css/default.css" media="all"/>
    <link rel="stylesheet" rev="stylesheet" type="text/css" href="${ctx}/skin/default/css/title.css" media="all"/>

	<script type="text/javascript" src="${ctx}/components/jquery-ui/jquery-1.2.6.js"></script>    	
	<script language="javascript" src="${ctx}/js/pngfix_map.js"></script>
	<script language="javascript" src="${ctx}/js/common.js"></script>
    <!-- 调用外部 JavaScript 脚本语言 -->
		<style type="text/css">
			body {
				background: #d8edfc;
				border: 3px solid #4891c6;
			}
		
		</style> 
		
	
</head>

<body>
            <a href="#" target="_parent" style="float:right">
             	退出	
            </a>
	
</body>
</html>