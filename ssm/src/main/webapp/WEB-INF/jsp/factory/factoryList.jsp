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
	<script type="text/javascript">
		function formSubmit(url,sTarget){
			document.subForm.target = sTarget;
		    document.subForm.action = url;
		    document.subForm.submit();
		    return true;
		}
		
	</script>
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
<form name="subForm" method="post">
	<a href="#" onclick="formSubmit('<%=basePath%>/factory/factoryAddUI.action','_self');return false;">添加</a>
	<a href="#" onclick="formSubmit('<%=basePath%>/factory/factoryDelete.action','_self');return false;">删除</a>
	<a href="#" onclick="formSubmit('<%=basePath%>/factory/factoryUpdateUI.action','_self');return false;">修改</a>
	<table>
		<thead>
			<tr>
				<td><input type="checkbox"/></td>
				<td>序号</td>
				<td>厂家全称</td>
				<td>厂家简称</td>
				<td>联系人</td>
				<td>电话</td>
				<td>手机</td>
				<td>传真</td>
				<td>验货员</td>
				<td>备注</td>
				<td>创建人</td>
				<td>创建部门</td>
				<td>状态</td>
			</tr>
		</thead>	
		<tbody>
			<c:forEach items="${factoryList }" var="factory" varStatus="s">
				<tr >
					<td><input type="checkbox" name="id" value="${factory.id }" /></td>
					<td>${s.count}</td>
					<td>
						<a href="<%=basePath%>/factory/factoryListOne.action?id=${factory.id}"> ${factory.fullName}</a>
					</td>
					<td>${factory.factoryName}</td>
					<td>${factory.contacts}</td>
					<td>${factory.phone}</td>
					<td>${factory.mobile}</td>
					<td>${factory.fox}</td>
					<td>${factory.inspector}</td>
					<td>${factory.cnote}</td>
					<td>${factory.createBy}</td>
					<td>${factory.createDept}</td>
					<td>
						<c:if test="${factory.state==1 }">
							<a href="<%=basePath%>/factory/factoryClose.action?id=${factory.id }"> 启用</a>
						</c:if>
						<c:if test="${factory.state==0 }">
							<a href="<%=basePath%>/factory/factoryOpen.action?id=${factory.id }"> 停用</a>
						</c:if>
					</td>

				</tr>
			</c:forEach>
		</tbody>
	</table>	
	
</form>		
  </body>
</html>
