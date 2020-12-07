<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
<% 
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'getById.jsp' starting page</title>

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
	<form action="book" method="get">
		<table width="80%">
			<tr>
				<td>修改书籍${requestScope.bookName }</td>
			</tr>
			<tr>
	
				<td>BookName <input type="hidden" name="op" value="change">
					<input type="hidden" name="id" value="${requestScope.id}"></td>
				<td><input type="text" name="BookName"
					value="${requestScope.book.name}" /></td>
			</tr>

			<tr>
				<td>author</td>
				<td><input type="text" name="author"
					value="${requestScope.book.author}" /></td>
			</tr>
			<tr>
				<td>pubdate</td>
				<td><input type="text" name="pubdate"
					value="${requestScope.book.pubdate}" /></td>
			</tr>
			<tr>
				<td>category</td>
				<td><select name="categoryId">
						<c:forEach items="${clist }" var="cate">
							<%-- <c:if test="${cate.id==book.category }">
								<option value="${cate.id }" selected>${cate.category}</option>
							</c:if>
						<option value="${cate.id }" >${cate.category}</option> --%>
							<option value="${cate.id }" ${cate.id==book.category?selected:"" }>${cate.category}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>price</td>
				<td><input type="text" name="price"
					value="${requestScope.book.price}" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="确认修改" /></td>
			</tr>
		</table>
	</form>
</body>
</html>
