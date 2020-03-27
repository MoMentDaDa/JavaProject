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
	<div align="center">
		当前登录用户：[${sessionScope.USER_IN_SEESSION.username}] 
		<a href="/login.jsp">注销登录 </a> 
		<a href="/mouse/shop?cmd=see">查看购物车</a>
	</div><br>
	<div align="center">鼠标列表信息</div></br>
	
	<a href="/mouse?cmd=edit">添加鼠标</a>
	<table border="1" width=80% cellpadding="0" cellspaing="0">
		<tr style="background-color: pink">
			<td>ID</td>
			<td>name</td>
			<td>参考价格</td>
			<td>重量</td>
			<td>材质</td>
			<td>引擎</td>
			<td>操作</td>
			<td>是否加入购物车</td>
		</tr>

		<c:forEach items="${mouses}" var="m">
			<tr>
				<td>${m.id }</td>
				<td>${m.name }</td>
				<td>${m.price }</td>
				<td>${m.weight}</td>
				<td>${m.material}</td>
				<td>${m.engineering}</td>
				<%-- <td>
					<a href="/crud/delete?id=${s.id }">删除</a> 
					<a href="/crud/edit?id=${s.id }">编辑</a>
				</td> --%>
				<td><a href="/mouse?cmd=delete&&id=${m.id }">删除</a> 
				<a href="/mouse?cmd=edit&&id=${m.id }">编辑</a></td>
				<td><a href="/mouse?cmd=shop&&id=${m.id }">加入购物车</a></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>