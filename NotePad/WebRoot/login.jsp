<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title></title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <form action="#" method="post">
    		<h3>用户登录</h3>
    		<div>
    			<div>
    				<div>姓名：</div>
    				<div>
    					<input type="text" name="name" value="输入用户名"/>
    				</div>
    			</div>
    			<div>
    				<div>密码：</div>
    				<div>
    					<input type="password" name="password" value=""/>
    				</div>
    			</div>
    			<div >
    				<input type="submit" value="登录"/>
    				<input type="submit" value="注册"/>
    			</div>
    		</div>
    </form>
  </body>
</html>
