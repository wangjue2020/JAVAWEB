<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>图书管理</title>
	<%--静态包含base标签、css样式、jQuery 文件--%>
	<%@ include file="/pages/common/header.jsp"%>
	<script type="text/javascript">
		function deleteBook() {
		    return confirm("Confirm delete this book's record?");
		}
	</script>
</head>
<body>
	
	<div id="header">
		<img class="logo_img" alt="" src="static/img/logo.gif" >
		<span class="wel_word">图书管理系统</span>

		<%@ include file="/pages/common/manager_menu.jsp"%>
	</div>
	
	<div id="main">
		<table>
			<tr>
				<td>名称</td>
				<td>价格</td>
				<td>作者</td>
				<td>销量</td>
				<td>库存</td>
				<td colspan="2">操作</td>
			</tr>
			<c:forEach items="${books}" var="row">
				<tr>
					<td>${row.name}</td>
					<td>${row.price}</td>
					<td>${row.author}</td>
					<td>${row.sales}</td>
					<td>${row.stock}</td>
					<td><a href="manager/bookServlet?action=selectOne&id=${row.id}">Edit</a></td>
					<td><a href="manager/bookServlet?deleteId=${row.id}&action=delete" onclick="return deleteBook();">Delete</a></td>
				</tr>
			</c:forEach>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><a href="pages/manager/book_edit.jsp">添加图书</a></td>
			</tr>
		</table>
	</div>

	<%--静态包含footer内容--%>
	<%@ include file="/pages/common/footer.jsp"%>
</body>
</html>