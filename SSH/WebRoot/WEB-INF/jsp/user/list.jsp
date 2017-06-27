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
    
    <title>post page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<%@ include file="/WEB-INF/jsp/public/common.jspf" %>
  </head>
  
  <body>
<div id="Title_bar">
    <div id="Title_bar_Head"> 
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/style/images/title_arrow.gif"/> 用户管理
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<div id="MainArea">
    <table cellspacing="0" cellpadding="0" class="TableStyle">
       
        <!-- 表头-->
        <thead>
            <tr align=center valign=middle id=TableTitle>
                <td width="100">登录名</td>
                <td width="100">姓名</td>
                <td width="100">所属部门</td>
                <td width="200">岗位</td>
                <td>备注</td>
                <td>相关操作</td>
            </tr>
        </thead>
        
        <!--显示数据列表-->
        <tbody id="TableData" class="dataContainer" datakey="userList">
        
        <s:iterator value="users"> 
            <tr class="TableDetail1 template">
                <td>${loginname}&nbsp;</td>
                <td>${name}&nbsp;</td>
                <td>${department.name}&nbsp;</td>
                <td>
                	<s:iterator value="roles">
                		${name}&nbsp;
                	</s:iterator>
                	&nbsp;
                </td>
                <td>${description}&nbsp;</td>
                <td>
                	<s:if test="#session.user.hasPrivilege('用户删除')">	
						<s:a href="userAction_delete.action?id=%{id }" onclick="return confirm('确定要删除么')">删除</s:a> 		
					</s:if>	
					<s:if test="#session.user.hasPrivilege('用户修改')">
						<s:a href="userAction_updateUI.action?id=%{id }" onclick="return confirm('确定要修改么')">修改</s:a>
					</s:if>
					<s:if test="#session.user.hasPrivilege('用户初始化密码')">
						<s:a action="userAction_initPassword?id=%{id}" onclick="return window.confirm('您确定要初始化密码为1234吗？')">初始化密码</s:a>
					</s:if>
                </td>
            </tr>
        </s:iterator> 
            
        </tbody>
    </table>
    
    <!-- 其他功能超链接 -->
    <div id="TableTail">
        <div id="TableTail_inside">
            <s:if test="#session.user.hasPrivilege('用户添加')">
	    		<s:a action="userAction_addUI" >添加</s:a>
			</s:if>    

        </div>
    </div>
</div>

</body>
</html>
