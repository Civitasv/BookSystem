<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'add.jsp' starting page</title>

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
	<form action="book?op=add" method="post">
		<table width="80%">
			<tr>
				<td>添加书籍${requestScope.bookName }</td>
			</tr>
			<tr>

				<td>BookName</td>
				<td><input type="text" name="BookName" /></td>
			</tr>

			<tr>
				<td>author</td>
				<td><input type="text" name="author" " /></td>
			</tr>
			<tr>
				<td>pubdate</td>
				<td><input type="text" name="pubdate" " /></td>
			</tr>
			<tr>
				<td>category</td>
				<td><select name="categoryId">
						<c:forEach items="${clist }" var="cate">
							<option value="${cate.id }"}>${cate.category}</option>
						</c:forEach>
					
				</select></td>
			</tr>
			<tr>
				<td>price</td>
				<td><input type="text" name="price" " /></td>
			</tr>
			<tr>
				<td><input type="submit" value="添加" /></td>
			</tr>
		</table>
	</form>
</body>
</html>
