<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">当前登录用户：[${sessionScope.USER_IN_SEESSION.username}]
	<a href="/mouse/logout">注销登录</a> 
	</div>
	<form action="/mouse?cmd=save" method="post">
			<input type="hidden" name="id" value="${m.id }"/> 
		name：<input type="text" name="name" required value="${m.name }"><br />
		price：<input type="text" name="price" required value="${m.price }"><br />
		weight：<input type="text" name="weight" required value="${m.weight}"><br /> 
		material：<input type="text" name="material" required value="${m.material}"><br /> 
		engineering：<input type="text" name="engineering" required value="${m.engineering}"><br /> 
		<input type="submit" value=${m==null?"保存鼠标信息":"更新鼠标信息" }>
	</form>
</body>
</html>