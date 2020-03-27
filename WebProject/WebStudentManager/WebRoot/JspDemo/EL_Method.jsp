<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>通过内置对象，获取不同作用域中的数据，只找当前作用域的值</h4>
	${student }
	<br />${student.id }
	<br /> ${student.name }
	<br /> ${student.email }
	<br /> ${student.age}
	<br />

	<br />
	<br /> ${student.name }-->${student["name"] }-->${student.getName() }
	<br />
	<br />
	<br />
	<%
			pageContext.setAttribute("list",new ArrayList());
				%>
	<br /> 判断list是否为空：${empty list }//以集合是否有元素为标准
</html>