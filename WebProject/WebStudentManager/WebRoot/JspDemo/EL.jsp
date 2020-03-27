<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		//JSP四大作用域
		pageContext.setAttribute("msg","pageContextValue");
		request.setAttribute("msg","requestValue");
		session.setAttribute("msg","sessionValue");
		application.setAttribute("msg","applicationtValue");
	%>

	<h3>取出每个作用域的值</h3>
		pageContext:<%=pageContext.getAttribute("msg")%><br>
		request:<%=request.getAttribute("msg")%><br>
		session:<%=session.getAttribute("msg") %><br>
		application:<%=	application.getAttribute("msg") %><br>
		<br><br><br><br><br>
		findContext_is:<%=pageContext.findAttribute("msg")%><br>
		findContext_is:<%=pageContext.findAttribute("msg")==null?" ":pageContext.findAttribute("msg")%><br>
		${msg};

</body>
</html>