<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	学生列表信息
	</br>
	<a href="/crud?cmd=edit">添加学生</a>
	<table border="1" width=80% cellpadding="0" cellspaing="0">
		<tr style="background-color: pink">
			<td>ID</td>
			<td>Name</td>
			<td>Email</td>
			<td>Age</td>
			<td>操作</td>
		</tr>

		<c:forEach items="${student }" var="s" varStatus="vs">
			<tr>
				<td>${s.id }</td>
				<td>${s.name }</td>
				<td>${s.email }</td>
				<td>${s.age }</td>
				<%-- <td>
					<a href="/crud/delete?id=${s.id }">删除</a> 
					<a href="/crud/edit?id=${s.id }">编辑</a>
				</td> --%>
					<td><a href="/crud?cmd=delete&&id=${s.id }">删除</a> <a
					href="/crud?cmd=edit&&id=${s.id }">编辑</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>