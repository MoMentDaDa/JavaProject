<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- 使用静态包含，在翻译阶段将多个JSP合并在一起--%>
	<%-- <%@include file="Top.jsp"%>
	<br /> Main代码
	<br />
	<%@include file="Foot.jsp"%> --%>
	<%-- 使用动态包含，在翻译阶段将不会多个JSP合并在一起，而是生成类文件，使用时合并在一起--%>
	<jsp:include page="Top.jsp"/>
	<br /> Main代码
	<br />
	<jsp:include page="Foot.jsp"/>
</body>
</html>