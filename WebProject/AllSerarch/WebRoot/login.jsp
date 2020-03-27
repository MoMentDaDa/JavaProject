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
	function change(){
		//重新设置验证码
		document.getElementById("randomCodeImg").src="/mouse/randm?"+new Date().getTime();
	}
</script>
</head>
<body>
<%-- <%
//第三种方式：销毁session
session.invalidate();
%> --%>
<%
//在JSP界面设置令牌
	String token=UUID.randomUUID().toString();
	session.setAttribute("TOKEN_IN_SESSION", token);
%>
	<span style="color: red;">${errorMsg }</span>
	<form action="/login?cmd=login" method="POST">
		账&emsp;户：<input type="text" name="usename" required="required" /><br /> 
		密&emsp;码：<input type="password" name="password" required="required" /><br />
		验证码：<input type="text" name="random" required="required" size="5" maxlength="5"/>
		<input type="hidden" name="token" value="<%=token %>" />
		<img src="/mouse/randm" id="randomCodeImg" title="看不清，换一张" style="cursor: pointer;" onclick="change()"/><br />
			 <input type="submit" value="朕要登录">
	</form>
</body>
</html>