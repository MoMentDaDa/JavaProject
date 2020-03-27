<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>加入购物车</title>
</head>
<body>
	<div align="center">
		当前登录用户：[${sessionScope.USER_IN_SEESSION.username}] 
			<a href="/login?cmd=login_Out">注销登录 </a> 
	</div></br></br>
	
	</br><div style="color: red">是否加入购物车</div></br>

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
			<td>${m.engine}</td>
		</tr>
		<tr>
			<td>线材</td>
			<td>${m.wire}</td>
		</tr>	
		<tr>
			<td>脚贴</td>
			<td>${m.footstick}</td>
		</tr>
		<tr>
			<td>分类</td>
			<td>
				<c:forEach items="${dirs }" var="dir">
					<c:if test="${m.classiFication==dir.id}"> ${dir.dirName}</c:if>
				</c:forEach>
			</td>
		</tr>
</table>
	<form action="/mouse/shop?cmd=save&&id=${m.id }" method="post">
		数量：<input type="number" name="num" min="1" required>
		<input type="submit" value="加入购物车">
	</form>	
</body>
</html>