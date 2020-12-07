<%@ page language="java" import="java.util.*" pageEncoding="UTf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'regist.jsp' starting page</title>
    
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
  <h4>欢迎注册</h4>
   <form action="book?op=regist" method="post">
   		username:<input type="text" name="username"/>${not empty requestScope.msg2?requestScope.msg:""}
   		password:<input type="password" name="pwd"/>
   		makesurepassword:<input type="password" name="pwdsure"/>${not empty requestScope.msg?requestScope.msg:""}
		<input type="submit" value="立即注册">   		
   </form>
  </body>
</html>
