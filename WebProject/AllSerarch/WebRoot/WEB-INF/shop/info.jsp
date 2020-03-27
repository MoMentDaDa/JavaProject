<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物车提示</title>
</head>
<body>
	<c:choose>
		<c:when test="${kong=='0'}">
		购物车为是空的呢，快点去<a href="/mouse">购物</a>吧
		</c:when>
		<c:otherwise>
			亲，已成功加入购物车呢，查看<a href="/mouse/shop?cmd=see">购物车</a>，继续<a href="/mouse">购物</a>
		</c:otherwise>
	</c:choose>



</body>
</html>