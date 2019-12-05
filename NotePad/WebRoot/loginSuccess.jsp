<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
     <title>login Successfully</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
    	#main{
    		width:500px;
    		height:auto;
    	}
    	#main div{
    		width:200px;
    		height:auto;
    	}
    	ul{
    		padding-top:1px;
    		padding-left:1px;
    		list-style:none;
    	}
    </style>
  </head>
  
  <body>
   <%
   		if(session.getAttribute("userBean")==null) {
    %>
    <jsp:forward page="register.jsp"/>
    <%
    	return;
    	}
     %>
     <div id="main">
     	<div id="welcome">恭喜你，登录成功！</div>
     	<hr/>
     	<div>你的信息</div>
     	<div>
     		<ul>
     			<li>你的名字：${userBean.name}</li>
     			<li>你的邮箱：${userBean.email}</li>
     		</ul>
     	</div>
     </div>
  </body>
</html>
