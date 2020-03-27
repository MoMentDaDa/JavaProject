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
	<h3>文件上传</h3>
	<span>${errorMsg }</span>
	<form action="/file/receive2" method="post" enctype="multipart/form-data">
		帐号：<input type="text" name="username"/><br> 
		邮箱：<input type="text" name="email"/><br> 
		头像：<input type="file" name="headimg" accept="image/*"/><br>
		<input type="submit" value="点击注册"/><br>
	</form>
</body>
</html>