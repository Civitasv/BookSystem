<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
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
  ${not empty requestScope.msg3? requestScope.msg3:"" }
   	<form action="book?op=login">
   	用户名:<input type = "text" name="username"/>${not empty requestScope.msg?requestScope.msg:""}<br>
   	密码:<input type="password" name="pwd"/><br>
   	<input type = "submit"  value = "提交"/>
   	
   	</form>
   	<form action="regist.jsp" method="post">
   	<input type = "submit"  value ="立即注册"/>
   	</form>
  </body>
</html>
