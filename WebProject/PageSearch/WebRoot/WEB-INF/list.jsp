<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>产品分页查询</title>
	<script type="text/javascript">
	//提交表单
	function go(){
		document.forms[0].submit();
	}
</script>
</head>
<body>
	<div align="center">鼠标列表信息</div>
	</br>
	<br />
	
	<form action="/page" method="post">
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
			</tr>
		</c:forEach>
		<tr>
		<td colspan="9" style="text-align: center;">
			<a href="/page?currentPage=1">首页</a>&nbsp;&nbsp;&nbsp;
			
			<a href="/page?currentPage=${pageResult. prevPage}">上一页</a>&nbsp;&nbsp;&nbsp;
			
			<c:forEach begin="${ pageResult.beginIndex}" end="${ pageResult.endIndex}" var="pageNumber">
					<c:if test="${pageNumber!=pageResult.currentPage }"><!-- 循环迭代每个页码 -->
						<a href="/page?currentPage=${pageNumber}">${pageNumber}</a>&nbsp;&nbsp;&nbsp;
					</c:if>
					<c:if test="${pageNumber==pageResult.currentPage }"><!-- 如果为当前页，背景为黑底白字 -->
						<span style="color:white;font: bold;background: black;">${pageNumber}</span>&nbsp;&nbsp;&nbsp;
					</c:if>
			</c:forEach>
			
			<a href="/page?currentPage=${pageResult. nextPage}">下一页</a>&nbsp;&nbsp;&nbsp;
			
			<a href="/page?currentPage=${pageResult. totalPage}">末页</a>&nbsp;&nbsp;&nbsp;
			
			当前第${pageResult. currentPage}/${pageResult.totalPage }页&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			
			跳转到第<input type="number" min="1" max="${pageResult.totalPage }" style="width: 30px" name="currentPage" value="${pageResult. currentPage}"/>页&nbsp;&nbsp;&nbsp;
			<input type="button" value="go" onclick="go();"/>&nbsp;&nbsp;&nbsp; 
			
			每页<input type="number"  style="width: 30px" min="1" max="${pageResult.totalPage }" name="User_pageSize" value="${pageResult. pageSize}"/>条数据&nbsp;&nbsp;&nbsp; 
			<input type="button" value="change" onclick="go();"/>&nbsp;&nbsp;&nbsp; 
			一共${pageResult.totalCount}条数据&nbsp;&nbsp;&nbsp; 
			
			共 ${pageResult.totalPage }页
		</tr>
		</form>
	</table>
</body>
</html>