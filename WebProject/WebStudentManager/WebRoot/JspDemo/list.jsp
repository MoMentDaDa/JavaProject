<%@page import="java.util.List"%>
<%@page import="JDBC_Apart.daomain.Students"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	学生列表信息
	<%
		List<Students> stu = (List<Students>) request.getAttribute("student");
	%>
	<table border="1" width=80% cellpadding="0" cellspaing="0">
		<tr>
			<td>ID</td>
			<td>Name</td>
			<td>Email</td>
			<td>Age</td>
		</tr>
		<%
			for (Students s : stu) {
		%>
		<tr>
			<td><%=s.getId()%></td>
			<td><%=s.getName()%></td>
			<td><%=s.getEmail()%></td>
			<td><%=s.getAge()%></td>
		</tr>
		<%
			}
		%>
	</table>

</body>
</html>