<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户注册</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
    <style type="text/css">
    		h3{
    			 margin-left:100px;
    		}
    		#outer{
    			width:750px;
    		}
    		spam{
    			color:#ff0000
    		}
    		div{
    			height:20px;
    			margin-bottom:10px; 
    		}
    		.ch{
    			width:80px;
    			text-align:right;
    			float:left;
    		}
    		.ip{
    			width:500px;
    			float:left;
    		}
    		.ip>input{
    			margin-ruight:20px;
    		}
    		#bt{
    			margin-left: 50px;
    		}
    		#bt>input{
    			margin-right: 30px;
    		}
    </style>
  </head>
  
  <body>
    <form action="ControllerServlet" method="post">
    		<h3>用户注册</h3>
    		<div id="outer">
    			<div>
    				<div class="ch">姓名：</div>
    				<div class="ip">
    					<input type="text" name="name" value="${formBean.name }"/>
    					<span>${formBean.errors.name}${DBMes }</span>
    				</div>
    			</div>
    			<div>
    				<div class="ch">密码：</div>
    				<div class="ip">
    					<input type="password" name="password"/>
    					<span>${formBean.errors.password }</span>
    				</div>
    			</div>
    			<div>
    				<div class="ch">确认密码：</div>
    				<div class="ip">
    					<input type="password" name="password2"/>
    					<span>${formBean.errors.password2 }</span>
    				</div>
    			</div>
    			<div>
    				<div class="ch">邮箱：</div>
    				<div class="ip">
    					<input type="text" name="email" value="${formBean.email }">
    					<span>${formBean.errors.email }</span>
    				</div>
    			</div>
    			<div id="bt">
    				<input type="reset" value="重置"/>
    				<input type="submit" value="注册"/>
    			</div>
    		</div>
    </form>
  </body>
</html>
