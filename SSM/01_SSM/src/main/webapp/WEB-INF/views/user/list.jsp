<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>用户列表</title>
</head>
<body>

	<a href="/user/input">添加</a>
	<table border="1" width="400">
		<thead>
			<tr>
				<th>ID</th>
				<th>NAME</th>
				<th>AGE</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${users}" var="u">
				<tr align="center">
					<td>${u.id}</td>
					<td>${u.name}</td>
					<td>${u.age}</td>
					<td><a href="/user/delete?id=${u.id}">删除</a> <a
						href="/user/input?id=${u.id}">编辑</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
