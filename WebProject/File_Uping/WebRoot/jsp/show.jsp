<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>注册信息</h4>
	名字：${info.name }<br>
	邮箱：${info.email }<br>
	原始头像名字：${info.nameIMG }<br>
	头像：<img src="${info.dirIMG }"/>
</body>
</html>