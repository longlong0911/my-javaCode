<%@ page language="java" pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>


<head>
    <title></title>
	<script type="text/javascript" src="<%=basePath %>/js/datepicker/WdatePicker.js"></script>
	
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
<form name="subForm" method="post">
	<h3>新增装箱单</h3>
		
	<a href="#"
		onclick="formSubmit('<%=basePath%>/packingList/packingListAdd.action','_self');return false;">确定</a>   
	<a href="#"
		onclick="formSubmit('<%=basePath%>/export/ExportList.action','_self');return false;">返回</a>   




     
		<table class="commonTable" cellspacing="1">
	        <tr>
	            <td class="columnTitle_mustbe">发票号 ：</td>
	            <td class="tableContent"><input type="text" name="invoiceNo" value=""/></td>
	            <td class="columnTitle_mustbe">发票时间：</td>
	            <td class="tableContent">
	            	<input type="text" name="invoiceDate" style="width:90px;"
	            		onclick="WdatePicker({el:this,isShowOthers:true,dateFmt:'yyyy-MM-dd'});" readonly/>
	            </td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">卖家：</td>
	            <td class="tableContent">
	            	<textarea name="seller" style="height:80px;">
	            		INT'L CO.,LTD.
						8-C,JIATENG BUILDING.NO.108
						HEPING RO0001
					</textarea>
				</td>
	            <td class="columnTitle_mustbe">买家：</td>
	            <td class="tableContent">
		            <textarea name="buyer" style="height:80px;">LEE &CO.,LTD
						NOS.9-12,17/FL,TOWER 3,
						CHINA HONGKONG CITY,
						33CANTON ROOWLOON.HK
					</textarea>
				</td>
	        </tr>
	        <tr>
	            <td >唛头：</td>
	            <td ><textarea name="marks" style="height:80px;"></textarea></td>
	            <td >说明：</td>
	            <td >
	            	<textarea name="descriptions" style="height:80px;"></textarea>
	            </td>
	        </tr>
		</table>
		
		
		
		<h3>相关报运单</h3>
			${buf}
</form>
</body>
</html>


