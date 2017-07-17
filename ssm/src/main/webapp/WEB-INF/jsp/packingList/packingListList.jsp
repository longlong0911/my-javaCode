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
	<title></title>
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
		function formSubmit(url,sTarget){
			document.subForm.action=url;
			document.subForm.target=sTarget;
			document.subForm.submit();
			return true;
		}
	</script>

</head>

<body>
<h3>装箱单列表</h3>
   
<form name="subForm" method="post">

	<a href="#"
			onclick="formSubmit('<%=basePath%>/packingList/packingListOne.action','_self');return false;">查看</a>
	
	<a href="#"
			onclick="formSubmit('<%=basePath%>/packingList/packingListDelete.action','_self');return false;">删除</a>
  
<table id="ec_table" class="tableRegion" width="98%" >
	<thead>
	<tr>
		<td class="tableHeader"><input type="checkbox" name="selid" onclick="checkAll('id',this)"></td>
		<td class="tableHeader">序号</td>
		<td class="tableHeader">报运号</td>
		<td class="tableHeader">发票号</td>
		<td class="tableHeader">发票时间</td>
		<td class="tableHeader">唛头</td>
		<td class="tableHeader">备注</td>
	</tr>
	</thead>
	<tbody >
	
	<c:forEach items="${plList}" var="o" varStatus="status">
	<tr class="odd" onmouseover="this.className='highlight'" onmouseout="this.className='odd'" >
		<td><input type="checkbox" name="id" value="${o.id}"/></td>
		<td>${status.index+1}</td>
		<td>${o.exportNos}</td>
		<td>${o.invoiceNo}</td>
		<td><fmt:formatDate value="${o.invoiceDate}" pattern="yyyy-MM-dd"/></td>
		<td>${o.marks}</td>
		<td>${o.descriptions}</td>
	</tr>
	</c:forEach>
	
	</tbody>
</table>
 
</form>
</body>
</html>


