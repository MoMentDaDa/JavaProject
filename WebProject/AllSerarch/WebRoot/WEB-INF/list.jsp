<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>产品分页查询</title>

</head>
<body>
	<div align="center">鼠标列表信息</div>
	<div align="center">
		当前登录用户：[${sessionScope.USER_IN_SEESSION.username}] 
			<a href="/login?cmd=login_Out">注销登录 </a> 
			<a href="/mouse/shop?cmd=see">查看购物车</a>
	</div><br><br>
	
	<a href="/mouse/manage?cmd=edit">添加鼠标</a><br><br>

	<form action="/mouse" method="post">
		商品名称：<input type="text" name="name" value="${go.name }" /> 
		商品价格：<input type="text" name="minPrice" width="100px" value="${go.minPrice }" />到&nbsp;<input type="text" name="maxPrice" width="100px"value="${go.maxPrice }" /> 
		分类：<select name="dirId">
				<option value=-1>所有分类</option>
					<c:forEach items="${dirs }" var="dir">
						<option value="${ dir.id}" ${dir.id==go.dirId?"selected":"" }>${dir.dirName}</option>
					</c:forEach>
			</select> 
		关键字查询：<input type="text" name="keyword" value="${go.keyWord }" placeholder="商品名称或线材">
					<input type="submit" value="查询" style="background: orange;"><br><br>
	
	<table border="1" style="width:80%;cellpadding:0; cellspaing:0;">
		<tr style="background-color: pink">
			<td>ID</td>
			<td>name</td>
			<td>参考价格</td>
			<td>重量</td>
			<td>材质</td>
			<td>引擎</td>
			<td>线材</td>
			<td>脚贴</td>
			<td>分类</td>
			<td>操作</td>
			<td>加入购物车</td>	
		</tr>
			<c:forEach items="${Mouse}" var="m">
			<tr>
				<td>${m.id }</td>
				<td>${m.name }</td>
				<td>${m.price }</td>
				<td>${m.weight}</td>
				<td>${m.material}</td>
				<td>${m.engine}</td>
				<td>${m.wire}</td>
				<td>${m.footstick}</td>
				<td>
					<c:forEach items="${dirs }" var="dir">
						<c:if test="${m.classiFication==dir.id}"> ${dir.dirName}</c:if>
					</c:forEach>
				</td>
				<td>
					<a href="/mouse/manage?cmd=delete&&id=${m.id }">删除</a> 
					<a href="/mouse/manage?cmd=edit&&id=${m.id }">编辑</a>
				</td>
				<td>
					<a href="/mouse/manage?cmd=shop&&id=${m.id }">加入购物车</a>
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="11" style="text-align: center;">
				<%@include file="\WEB-INF\commonPage.jsp" %>
			</td>
		</tr>
	</table>
	</form>
</body>
</html>