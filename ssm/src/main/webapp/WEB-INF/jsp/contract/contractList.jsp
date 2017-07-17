<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'contractList.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">
	function formSubmit(url, sTarget) {
		document.subForm.target = sTarget;
		document.subForm.action = url;
		document.subForm.submit();
		return true;
	}
	
</script>
	<style type="text/css">
		table {
			border: 1px solid red;
			border-collapse: collapse;
		}
		
		table td {
			border: 1px solid red;
			width: 100px;
			height: 30px;
		}
	</style>
</head>

<body>
	<h3>合同列表</h3>

	<form name="subForm" method="post">
	
		<a href="#"
			onclick="formSubmit('<%=basePath%>/contract/contractListOne.action','_self');return false;">查看</a>
		<a href="#"
			onclick="formSubmit('<%=basePath%>/contract/contractAddUI.action','_self');return false;">新增</a>
		<a href="#"
			onclick=" formSubmit('<%=basePath%>/contract/contractDelete.action','_self');return false;">删除</a>
		<a href="#"
			onclick="formSubmit('<%=basePath%>/contract/contractUpdateUI.action','_self');return false;">修改</a>
		<a href="#"
			onclick="formSubmit('<%=basePath%>/contract/contractStateOpen.action','_self');return false;">上报</a>
		<a href="#"
			onclick="formSubmit('<%=basePath%>/contract/contractStateClose.action','_self');return false;">取消上报</a>
		<a href="#"
			onclick="formSubmit('<%=basePath%>/contract/print.action','_self');return false;">打印</a>
		<a href="#"
			onclick="formSubmit('<%=basePath%>/contract/pigeonhole.action','_self');return false;">归档</a>
		
		<a href="#"
			onclick="formSubmit('<%=basePath%>/contract/input.action','_self');return false;">导入</a>

		

	
	
	
		<table>
			<thead>
				<tr>
					<td><input type="checkbox" />
					</td>
					<td>序号</td>
					<td>合同号</td>
					<td>客户名称</td>
					<td>签单日期</td>
					<td>交货日期</td>
					<td>船期</td>
					<td>贸易条款</td>
					<td>制单人</td>
					<td>审单人</td>
					<td>总金额</td>
					<td>状态</td>
					<td>产品数/附件数</td>
					<td>操作</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${contractList }" var="contract" varStatus="s">
					<tr>
						<td><input type="checkbox" name="id"
							value="${contract.id }" />
						</td>
						<td>${s.count}</td>
						<td><a href="contract/contractListOne.action?id=${contract.id}">${contract.contractNo}</a></td>
						<td>${contract.customName}
						</td>
						<td><fmt:formatDate value="${contract.signingDate}"
								pattern="yyyy-MM-dd" />
						</td>
						<td><fmt:formatDate value="${contract.deliveryPeriod}"
								pattern="yyyy-MM-dd" />
						</td>
						<td><fmt:formatDate value="${contract.shipTime}"
								pattern="yyyy-MM-dd" />
						</td>
						<td>${contract.tradeTerns}</td>
						<td>${contract.inputBy}</td>
						<td>${contract.checkBy}</td>
						<td>${contract.totalAmount}</td>
						<td><c:if test="${contract.state==0}">草稿</c:if> <c:if
								test="${contract.state==1}">
								<font color="orange">已上报</font>
							</c:if></td>
						
						<td align="center">${contract.cpCount}/${contract.extCount }</td>
						<td><a
							href="<%=basePath%>/contractProduct/contractProductAddUI.action?contractId=${contract.id}"
							title="新增货物">[货物]</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</form>
</body>
</html>
