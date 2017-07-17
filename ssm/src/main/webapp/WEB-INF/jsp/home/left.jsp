<%@ page language="java" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html xmlns="http://www.w3.org/1999/xhtml">


<head>
    <title></title>
    <link rel="stylesheet" rev="stylesheet" type="text/css" href="${ctx}/skin/default/css/default.css" media="all"/>
	<style type="text/css">
		body {
			background: #d8edfc;
			border: 3px solid #4891c6;
		}
	
	</style> 
</head>
 
<body>
	<ul>	
		<span>主要功能</span> 
		<li>合同管理
			<ul>
				<li>
					<a href="contract/contractList.action" target="rightFrame">合同列表</a>
				</li>
				<li>
					<a href="contract/contractView.action" target="rightFrame">合同查看</a>
				</li>
				<li>
					<a href="contract/hisContract.action" target="rightFrame">历史合同查看</a>
				</li>
				<li>
					<a href="outProduct/toDate.action" target="rightFrame">月出货打印</a>
				</li>
			</ul>
		</li>
		<li>货运管理
			<ul>
				<li>
					<a href="export/exportList.action"  target="rightFrame">报运列表</a>
				
				</li>
			</ul>
		</li>
		<li>报运管理
			<ul>
				<li>
					<a href="packingList/packingListList.action" target="rightFrame">装箱列表</a>
				
				</li>
			</ul>
		</li>
		<li>图形报表
			<ul>
				<li>
					<a href="stat/factorySale.action" target="rightFrame">厂家销售</a>
				
				</li>
				<li>
					<a href="stat/productSale.action" target="rightFrame">产品销售</a>
				
				</li>
				<li>
					<a href="stat/onlineinfo.action" target="rightFrame">登陆曲线</a>
				
				</li>
			</ul>
		</li>
		<li>厂家管理
			<ul>
				<li>
					<a href="factory/factoryList.action" target="rightFrame">厂家列表</a>
				
				</li>
			</ul>
		</li>
	</ul>
		
</body>
</html>