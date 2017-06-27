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
    
    <title>My JSP 'setPrivilegeUI.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	    <script language="javascript" src="${pageContext.request.contextPath}/script/jquery.js"></script>
    <script language="javascript" src="${pageContext.request.contextPath}/script/jquery_treeview/jquery.treeview.js"></script>
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/style/blue/file.css" /> <!-- 显示文件夹 -->
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/script/jquery_treeview/jquery.treeview.css" />

		<script type="text/javascript">
		$(function(){
			$("#root").treeview();
		});
		$(function(){
			$("[name='privilegeIds']").click(function(){
				$(this).siblings("ul").find("input").attr("checked",this.checked);
				if(this.checked){
					$(this).parents("li").children("input").attr("checked",true);
				}else{
					if($(this).parent().siblings().children("input:checked").size()==0){
						$(this).parent().parent().siblings("input").attr("checked",false);
						
						var start = $(this).parent().parent().siblings("input");
						if(start.parent().siblings().children("input:checked").size()==0){
							start.parent().parent().siblings("input").attr("checked",false);
						}
					}
				}	
			});
		});	
	</script>

  </head>
  
  <body>
	   <s:form action="postAction_setPrivilege.action">
    	<s:hidden name="id"></s:hidden>
        	正在为【${post.name}】配置权限  
		
		<ul id="root">
			<s:iterator value="#topPrivilege">
				<li>
					<input type="checkbox"  id="cb_${id}" name="privilegeIds" value="${id}" <s:property value="%{id in privilegeIds ? 'checked' : ''}"/>>
					<label for="cb_${id}"><span class="folder">${name}</span></label>
					<ul>
						<s:iterator value="children">
							<li>
			<input type="checkbox"  id="cb_${id}" name="privilegeIds" value="${id}" <s:property value="%{id in privilegeIds ? 'checked' : ''}"/>>
					<label for="cb_${id}"><span class="folder">${name}</span></label>
								 <ul>
								 	<s:iterator value="children">
								 		<li>
					<input type="checkbox"  id="cb_${id}" name="privilegeIds" value="${id}" <s:property value="%{id in privilegeIds ? 'checked' : ''}"/>>
					<label for="cb_${id}"><span class="folder">${name}</span></label>
								 	</s:iterator>
								 </ul>
							</li>
						</s:iterator>
					</ul>			
				</li>
			</s:iterator>
		</ul>
            <input type="submit" value="提交" />
            <a href="javascript:history.go(-1);">返回</a>
    </s:form>

  </body>
</html>
