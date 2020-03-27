<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物车列表</title>
</head>
<body>
	<h4>你的购物车</h4>
	<table border="1" width=80% cellpadding="0" cellspaing="0">
		<tr>
			<td>ID</td>
			<td>name</td>
			<td>参考价格</td>
			<td>数量</td>	
			<td>操作</td>	
		</tr>
		<c:forEach items="${SHOPPINGCAR_IN_SESSION.items}" var="items">
			<tr>
				<td>${items.id }</td>
				<td>${items.name }</td>
				<td>${items.price }</td>
				<td>${items.num}</td>
				<td><a href="/mouse/shop?cmd=delete&&id=${items.id }">删除</a> <a
					href="/mouse/shop?cmd=edit&&id=${items.id }">编辑</a></td>
			</tr>
		</c:forEach>
		<tr align="right"><td colspan="5" >购物总价：${SHOPPINGCAR_IN_SESSION.totalPrice}</td>
			</table>
	<a href="/mouse">继续购物。</a>
	<span style="color: green">${null}</span>

</body>
</html>