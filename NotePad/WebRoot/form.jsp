<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'form.jsp' starting page</title>
    
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
    <form action="UploadServlet" method="post" enctype="multipart/form-data">
    	<table width = "600px">
    		<tr>
    			<td>上传者</td>
    			<td><input type="text" name = "name"></td>
    		</tr>
    		<tr>
    			<td>上传文件</td>
    			<td><input type="file" name = "myfile"></td>
    		</tr>
    		<tr>
	    		<td colspan="2"><input type="submit" value="上传" /></td>	
	    	</tr>
    	</table>
    </form>
  </body>
</html>
