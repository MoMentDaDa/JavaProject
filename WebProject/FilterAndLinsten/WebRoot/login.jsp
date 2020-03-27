<%@page import="java.nio.channels.SeekableByteChannel"%>
<%@page import="java.util.UUID"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
<title>登录界面</title>
<script type="text/javascript">
	
</script>
</head>
<body>
	<form action="/day2/login" method="POST">
		账&emsp;户：<input type="text" name="username" required="required" /><br /> 
		密&emsp;码：<input type="password" name="password" required="required" /><br />
			 <input type="submit" value="朕要登录">
	</form>
</body>
</html>