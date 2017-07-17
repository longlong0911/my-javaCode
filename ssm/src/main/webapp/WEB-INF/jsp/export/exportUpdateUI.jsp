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
    <script type="text/javascript" src="<%=basePath %>/js/jquery-1.2.6.js"></script>
    <script type="text/javascript" src="<%=basePath %>/js/tabledo.js"></script>
	<script type="text/javascript" src="<%=basePath %>/js/datepicker/WdatePicker.js"></script>
	
	<style type="text/css">
		#mRecordTable { 
			border: 1px solid red;
			border-collapse: collapse;
		}
		
		#td{
			border: 1px solid red;
			width: 100px;
			height: 30px;
		}
	</style>
	    	
<script language="JavaScript">
    $().ready(function(){
    	//alert("=====");
		${recordData}
    });
    

	/* 实现表格序号列自动调整 created by tony 20081219 */
	function sortnoTR(){
		sortno('mRecordTable', 2, 1);
	}
		
	function addTRRecord(exportId, id, productNo, cnumber, grossWeight, netWeight, sizeLength, sizeWidth, sizeHeight, exPrice, tax) {
		
		var _tmpSelect = "";
		var tableObj = document.getElementById(exportId);			//得到表格对象
		var rowLength = tableObj.rows.length;					//行数
		
		oTR = tableObj.insertRow();								//在行尾插入行
		
		oTD = oTR.insertCell(0);								//插入一个单元格
		oTD.style.whiteSpace="nowrap";
		//oTD.ondragover = function(){this.className="drag_over" };	//动态加事件, 改变样式类
		//oTD.ondragleave = function(){this.className="drag_leave" };
		//oTD.onmousedown = function(){ clearTRstyle("result"); this.parentNode.style.background = '#0099cc';};	
		//this.style.background="#0099cc url(../images/arroww.gif) 4px 9px no-repeat";
		oTD.innerHTML = "&nbsp;&nbsp;";	
		oTD = oTR.insertCell(1);
		oTD.innerHTML = "<input class=\"input\" type=\"checkbox\" name=\"del\" value=\""+id+"\"><input type=\"hidden\" name=\"mr_id\" value=\""+id+"\"><input class=\"input\" type=\"hidden\" id=\"mr_changed\" name=\"mr_changed\">";
		oTD = oTR.insertCell(2);
		oTD.innerHTML = "<input class=\"input\" type=\"text\" name=\"mr_orderNo\" readonly size=\"3\" value=\"\">";
		oTD = oTR.insertCell(3);
		oTD.innerHTML = "<b><font face='微软雅黑'><font color='blue'>"+productNo;+"</font></font></b> "
		oTD = oTR.insertCell(4);
		oTD.innerHTML = "<input type=\"text\" name=\"mr_cnumber\" maxLength=\"10\" value=\""+cnumber+"\" onBlur=\"setTRUpdateFlag(this);\" size=\"15\">";
		oTD = oTR.insertCell(5);
		oTD.innerHTML = "<input type=\"text\" name=\"mr_grossWeight\" maxLength=\"10\" value=\""+grossWeight+"\" onBlur=\"setTRUpdateFlag(this);\" size=\"15\">";
		oTD = oTR.insertCell(6);
		oTD.innerHTML = "<input type=\"text\" name=\"mr_netWeight\" maxLength=\"10\" value=\""+netWeight+"\" onBlur=\"setTRUpdateFlag(this);\" size=\"15\">";
		oTD = oTR.insertCell(7);
		oTD.innerHTML = "<input type=\"text\" name=\"mr_sizeLength\" maxLength=\"10\" value=\""+sizeLength+"\" onBlur=\"setTRUpdateFlag(this);\" size=\"15\">";
		oTD = oTR.insertCell(8);
		oTD.innerHTML = "<input type=\"text\" name=\"mr_sizeWidth\" maxLength=\"10\" value=\""+sizeWidth+"\" onBlur=\"setTRUpdateFlag(this);\" size=\"15\">";
		oTD = oTR.insertCell(9);
		oTD.innerHTML = "<input type=\"text\" name=\"mr_sizeHeight\" maxLength=\"10\" value=\""+sizeHeight+"\" onBlur=\"setTRUpdateFlag(this);\" size=\"15\">";
		oTD = oTR.insertCell(10);
		oTD.innerHTML = "<input type=\"text\" name=\"mr_exPrice\" maxLength=\"10\" value=\""+exPrice+"\" onBlur=\"setTRUpdateFlag(this);\" size=\"15\">";
		oTD = oTR.insertCell(11);
		oTD.innerHTML = "<input type=\"text\" name=\"mr_tax\" maxLength=\"10\" value=\""+tax+"\" onBlur=\"setTRUpdateFlag(this);\" size=\"15\">";

		dragtableinit();	//拖动表格行
		sortnoTR();			//排序号
		
	}    
	
	function formSubmit(url, sTarget) {
		document.subForm.target = sTarget;
		document.subForm.action = url;
		document.subForm.submit();
		return true;
	}

	
</script> 
		
</head>
<body>
     <h3>修改出口报运</h3>
<form name="subForm" method="post">
	<input type="hidden" name="id" value="${export.id}">

	<a href="#"
			onclick="formSubmit('<%=basePath%>/export/updateExport.action','_self');return false;">确定</a>
	
	<a href="#"
			onclick="formSubmit('<%=basePath%>/export/exportList.action','_self');return false;">返回</a>
		
<table>
	        <tr>
	            <td>客户号：</td>
	            <td><input type="text" name="customerContract" value="${export.customerContract}"/></td>
	            <td>制单日期：</td>
	            <td>
	            	<input type="text" name="inputDate" style="width:90px;" value="<fmt:formatDate value="${export.inputDate}" pattern="yyyy-MM-dd"/>"
	            		onclick="WdatePicker({el:this,isShowOthers:true,dateFmt:'yyyy-MM-dd'});" readonly/>
	            </td>
	        </tr>
	        <tr>
	            <td>收货人及地址：</td>
	            <td><input type="text" name="consignee" value="${export.consignee}"/></td>
	            <td>L/C No.：</td>
	            <td>
	            	<input type="radio" name="lcno" value="T/T" id="tt" <c:if test="${export.lcno=='T/T'}">checked</c:if>/>
	            		<label for="tt">T/T</label>
	            		
	            	<input type="radio" name="lcno" value="L/C" id="lc" <c:if test="${export.lcno=='L/C'}">checked</c:if>/>
	            		<label for="lc">L/C</label>
	            		
	            </td>	       
	        </tr>
	        <tr>
	            <td>装运港：</td>
	            <td><input type="text" name="shipmentPort" value="${export.shipmentPort}"/></td>
	            <td>运输方式：</td>
		            <td>
	            	<input type="radio" name="transportMode" value="SEA" id="sea" <c:if test="${export.transportMode=='SEA'}">checked</c:if>>
	            		<label for="sea">海运(SEA)</label>
	            		
	            	<input type="radio" name="transportMode" value="AIR" id="air" <c:if test="${export.transportMode=='AIR'}">checked</c:if>>
	            		<label for="air">空运(AIR)</label>
	            		
	            </td>	
	        <tr>
	            <td>价格条件：</td>
	            <td><input type="text" name="priceCondition" value="${export.priceCondition}"/></td>
	        </tr>
	        <tr>
	            <td>唛头：</td>
	            <td><textarea name="marks" style="height:130px;">${export.marks}</textarea></td>
	            <td>说明：</td>
	            <td><textarea name="remark" style="height:130px;">${export.remark}</textarea></td>
	        </tr>
		</table>
 
 
 
	<table id="mRecordTable">
		<tr id="td">
			<td></td>
			<td>
				<input class="input" type="checkbox" name="ck_del" onclick="checkGroupBox(this);" />
			</td>
			<td>序号</td>
			<td>货号</td>
			<td>数量</td>
			<td>毛重</td>
			<td>净重</td>
			<td>长</td>
			<td>宽</td>
			<td>高</td>
			<td>出口单价</td>
			<td>含税</td>
		</tr>
	</table>

	<input type="button" name="btnAdd" value="新增" onclick="addTRRecord('mRecordTable', '', '', '', '', '', '', '', '', '', '');"/>	
</form>
</body>
</html>

