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
	<div style="color: red">编辑添加信息</div>

<table border="1" width=60% cellpadding="0" cellspaing="0">
		<tr style="background-color:pink">
			<td>属性</td>
			<td>描述</td>
		</tr>
		<tr>
			<td>name</td>
			<td>${m.name }</td>
		</tr>
		<tr>
			<td>参考价格</td>
		<td>${m.price }</td>
		</tr>
		<tr>
			<td>重量</td>
			<td>${m.weight}</td>
		</tr>
		<tr>
			<td>材质</td>
			<td>${m.material}</td>
		</tr>
		<tr>
			<td>引擎</td>
			<td>${m.engineering}</td>		
</table>
	<form action="/mouse/shop?cmd=save&&id=${m.id }" method="post">
		数量：<input type="text" name="num" required>
		<input type="submit" value="加入购物车">
	</form>	
</body>
</html>