<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>编辑添加信息</title>
</head>
<body>
	<div style="color: red">编辑购物车信息</div>
	<table border="1" width=60% cellpadding="0" cellspaing="0">
		<tr style="background-color: pink">
			<td>属性</td>
			<td>描述</td>
		</tr>
		<tr>
			<td>name</td>
			<td>${item.name }</td>
		</tr>
		<tr>
			<td>参考价格</td>
			<td>${item.price }</td>
		</tr>
	</table>
	<form action="/mouse/shop?cmd=update&&id=${id }" method="post">
		数量：<input type="number" name="num" min="1" value="${item.num}">
		<input type="submit" value="更新数量">
	</form>
</body>
</html>