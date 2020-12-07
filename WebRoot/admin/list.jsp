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

<title>My JSP 'list.jsp' starting page</title>

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
	<table width="80%">
		<tr>
			<td>Id</td>
			<td>BookName</td>
			<td>author</td>
			<td>pubDate</td>
			<td>category</td>
			<td>price</td>
			<td>operation</td>
		</tr>
		<c:forEach items="${requestScope.list}" var="book" varStatus="status">
			<tr>
				
				<td>${book.id}</td>
				<td>${book.name}</td>
				<td>${book.author}</td>
				<td>${book.pubdate}</td>
				<c:set value="${requestScope.clist }" scope="session" var="clist"></c:set>
				<td><c:forEach items="${requestScope.clist }" var="cate">
						<c:if test="${cate.id==book.category}">
						${cate.category}
						</c:if>
					</c:forEach></td>
				<td>${book.price}</td>
				<td><a href="book?op=getById&id=${book.id }">修改</a> <a
					href="book?op=delete&id=${book.id}">删除</a></td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="7" align="right">
			<a	href="book?op=list&currentPage=${page.currentPage-1 }"
			<c:if test="${page.currentPage==1 }">
				style="color:#ccc;" onclick="javascript:return false"
			</c:if>
			>下一页</a> 
			<a	href="book?op=list&currentPage=${page.currentPage+1 }"
			<c:if test="${page.currentPage==1 }">
				style="color:#ccc;" onclick="javascript:return false"
			</c:if>>上一页</a> 
			<span>共${page.totalPage }页</span>
			到第<input id="cp" type="text" style="width:20px">页<input type="button" value="确定" onclick="search();">
			
			</td>
		</tr>
		<a href="admin/add.jsp">添加</a>
	</table>
	<script type="text/javascript">
		function search(){
			var cp = document.getElementById("cp");
			location.href = "book?op=list&currentPage="+cp;
		}
	</script>
</body>
</html>
