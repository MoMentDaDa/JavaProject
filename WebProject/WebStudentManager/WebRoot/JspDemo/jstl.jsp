<%@page import="java.util.Date"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.ArrayList"%>
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
	<%
		pageContext.setAttribute("num", 3);
	%>

	如果num大于20,则输出内容，num>20
	<br>
	<c:if test="${ num>20}">num>20</c:if>
	<br> 比较大小，小为false
	<br>
	<c:if test="${num>20}" var="result" scope="page" />${result }<br>
	选择结构
	<br>
	<c:choose>
		<c:when test="${num>20}">num大于20</c:when>
		<c:when test="${num<20}">num小于20</c:when>
		<c:otherwise>num等于30</c:otherwise>
	</c:choose>
	<br> 使用foreach循环迭代，从1输出到10,每次迭代
	<br>
	<c:forEach var="num" begin="1" end="10" step="1">
		${num}
	</c:forEach>
	<br> 使用foreach循环迭代，实现数组的遍历
	<br>
	<%
		pageContext.setAttribute("list", Arrays.asList("A", "B", "C", "D"));
	%>
	<br>
	<c:forEach items="${list}" var="ele">
	${ele}<br>
	</c:forEach>
	<br>使用格式化输出时间，应该使用格式化标签 fmt
	<%
		pageContext.setAttribute("date", new Date());
	%>
	<br> ${date}
	<br>


</body>
</html>