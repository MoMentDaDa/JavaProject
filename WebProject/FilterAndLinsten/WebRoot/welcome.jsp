<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录检查</title>
</head>
<body>
	${sessionScope.USER_IN_SESSION }
	<br>
	<%
		Object user = session.getAttribute("USER_IN_SESSION");
		if (user == null) {
			response.sendRedirect("/login.jsp");
		}
	%>
	<a href="/function1.jsp">功能1</a>
	<a href="/function2.jsp">功能2</a>
	<a href="/function3.jsp">功能3</a>
</body>
</html>