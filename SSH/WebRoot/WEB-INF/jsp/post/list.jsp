<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
<title>岗位列表</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script language="javascript" src="${pageContext.request.contextPath}/script/jquery.js"></script>
    <script language="javascript" src="${pageContext.request.contextPath}/script/pageCommon.js" charset="utf-8"></script>
    <script language="javascript" src="${pageContext.request.contextPath}/script/PageUtils.js" charset="utf-8"></script>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/style/blue/pageCommon.css" />
    <script type="text/javascript">
    </script>
  </head>
  
  <body>
 		
	
	
	<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/style/images/title_arrow.gif"/> 岗位管理
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<div id="MainArea">
    <table cellspacing="0" cellpadding="0" class="TableStyle">
       
        <!-- 表头-->
        <thead>
            <tr align="CENTER" valign="MIDDLE" id="TableTitle">
            	<td width="200px">岗位名称</td>
                <td width="300px">岗位说明</td>
                <td>相关操作</td>
            </tr>
        </thead>

		<!--显示数据列表-->
        <tbody id="TableData" class="dataContainer" datakey="roleList">
        
        <s:iterator value="#posts">
			<tr class="TableDetail1 template">
				<td>${name}&nbsp;</td>
				<td>${description}&nbsp;</td>
				<td>
					<s:if test="#session.user.hasPrivilege('岗位删除')">
						<s:a href="postAction_delete.action?id=%{id }" onclick="return confirm('确定要删除么')">删除</s:a> 		
					</s:if>
					<s:if test="#session.user.hasPrivilege('岗位修改')">
						<s:a href="postAction_updateUI.action?id=%{id }" onclick="return confirm('确定要修改么')">修改</s:a>
					</s:if>
					<s:if test="#session.user.getLoginname()=='admin'">
						<s:a href="postAction_setPrivilegeUI.action?id=%{id }">设置权限</s:a>
					</s:if><br/>
				</td>
			</tr>
		</s:iterator>	
			
        </tbody>
    </table>
    
    <!-- 其他功能超链接 -->
    <div id="TableTail">
        <div id="TableTail_inside">
            <s:if test="#session.user.hasPrivilege('岗位添加')">
		    	<a href="postAction_addUI.action">添加</a>
			</s:if>
        </div>
    </div>
</div>
	
	    
    
  </body>
</html>
