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
	<div align="center">鼠标列表信息</div>
	</br>
	<br />
	<form action="/mouse" method="post">
		商品名称：<input type="text" name="name" value="${go.name }" /> 商品价格：<input
			type="text" name="minPrice" width="100px" value="${go.minPrice }" />
		到<input type="text" name="maxPrice" width="100px"
			value="${go.maxPrice }" /> 分类：<select name="dirId">
			<option value=-1>所有分类</option>
			<c:forEach items="${dirs }" var="dir">
				<option value="${ dir.id}" ${dir.id==go.dirId?"selected":"" }>
					${dir.dirName}</option>
			</c:forEach>
		</select> 
		关键字查询：<input type="text" name="keyword" value="${go.keyWord }" placeholder="商品名称或线材">
		<input type="submit" value="查询" style="background: orange;">
		
	</form>
	<br />
	<table border="1" width=80% cellpadding="0" cellspaing="0">
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

		</tr>
		<c:forEach items="${mouses}" var="m">
			<tr>
				<td>${m.id }</td>
				<td>${m.name }</td>
				<td>${m.price }</td>
				<td>${m.weight}</td>
				<td>${m.material}</td>
				<td>${m.engine}</td>
				<td>${m.wire}</td>
				<td>${m.footstick}</td>
				<td><c:forEach items="${dirs }" var="dir">
						<c:if test="${m.classiFication==dir.id}"> ${dir.dirName}</c:if>
					</c:forEach></td>

			</tr>
		</c:forEach>
	</table>

</body>
</html>