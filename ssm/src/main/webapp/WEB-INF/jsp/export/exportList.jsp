<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>


<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>出口报运列表</title>
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
	<script type="text/javascript">
	function formSubmit(url, sTarget) {
		document.subForm.target = sTarget;
		document.subForm.action = url;
		document.subForm.submit();
		return true;
	}
	
</script>
	
</head>

<body>
		  <h3>出口报运列表</h3>
		<form name="subForm" method="post">
		<a href="#"
			onclick="formSubmit('<%=basePath%>/export/updateExportUI.action','_self');return false;">修改</a>   

		<a href="#"
			onclick="formSubmit('<%=basePath%>/export/deleteExport.action','_self');return false;">删除</a>   

		<a href="#"
			onclick="formSubmit('<%=basePath%>/packingList/packingListAddUI.action','_self');return false;">装箱</a>   
		<table width="98%" >
			<thead>
			<tr>
				<td ><input type="checkbox" name="selid" onclick="checkAll('id',this)"></td>
				<td >序号</td>
				<td >报运号</td>
				<td >货物数/附件数</td>
				<td >L/C</td>
				<td >装运港</td>
				<td >收货人及地址</td>
				<td >运输方式</td>
				<td >价格条件</td>
				<td >录入日期</td>
				<td >状态</td>
			</tr>
			</thead>
			<tbody class="tableBody" >
			
			<c:forEach items="${exportList}" var="export" varStatus="status">
			<tr >
				<td><input type="checkbox" name="id" value="${export.id}"/></td>
				<td>${status.index+1}</td>
				<td>
					<a href="toview.action?id=${export.id}">
						${export.customerContract}
					</a>
				</td>
				
				<td>${export.pnum}/${export.extnum}</td>
				
				<td>${export.lcno}</td>
				<td>${export.shipmentPort}</td>
				<td>${export.consignee}</td>
				<td>${export.transportMode}</td>
				<td>${export.priceCondition}</td>
				<td><fmt:formatDate value="${export.inputDate}" pattern="yyyy-MM-dd"/></td>
				<!-- 0-草稿 1-已上报 2-装箱 3-委托 4-发票 5-财务 -->
				<td>
					<c:if test="${export.state==0}">草稿</c:if>
					<c:if test="${export.state==1}"><font color="green">已上报</font></c:if>
					<c:if test="${export.state==2}"><font color="green">装箱</font></c:if>
					<c:if test="${export.state==3}"><font color="green">委托</font></c:if>
					<c:if test="${export.state==4}"><font color="green">发票</font></c:if>
					<c:if test="${export.state==5}"><font color="green">财务</font></c:if>
				</td>
			</tr>
			</c:forEach>
			
			</tbody>
		</table>
		 
		</form>
</body>
</html>


