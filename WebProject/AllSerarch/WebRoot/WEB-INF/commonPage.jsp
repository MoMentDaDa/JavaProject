<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 通用分頁jsp -->
	<script type="text/javascript">
		//提交表单
		function go(){
			document.forms[0].submit();
		}
		function page(pageNum){
			document.getElementById("currentPages").value=pageNum;
			document.forms[0].submit();
		}
	</script>
	
	
	<a href="javascript:page(${pageResult.firstPage});">首页</a>&nbsp;&nbsp;&nbsp;
					
	<a href="javascript:page(${pageResult. prevPage});">上一页</a>&nbsp;&nbsp;&nbsp;
	
	<c:forEach begin="${ pageResult.beginIndex}" end="${ pageResult.endIndex}" var="pageNumber">
			<c:if test="${pageNumber!=pageResult.currentPage }"><!-- 循环迭代每个页码 -->
				<a href="javascript:page(${pageNumber})">${pageNumber}</a>&nbsp;&nbsp;&nbsp;
			</c:if>
			<c:if test="${pageNumber==pageResult.currentPage }"><!-- 如果为当前页，背景为黑底白字 -->
				<span style="color:white;font: bold;background: black;">${pageNumber}</span>&nbsp;&nbsp;&nbsp;
			</c:if>
	</c:forEach>
	
	<a href="javascript:page(${pageResult. nextPage})">下一页</a>&nbsp;&nbsp;&nbsp;
	
	<a href="javascript:page(${pageResult. totalPage})">末页</a>&nbsp;&nbsp;&nbsp;
	
	当前第${pageResult. currentPage}/${pageResult.totalPage }页&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	
	跳转到第<input type="number" min="1" max="${pageResult.totalPage==0?"1":"pageResult.totalPage" }" style="width: 30px" name="currentPage" id="currentPages" value="${pageResult. currentPage}" />页&nbsp;&nbsp;&nbsp;
	<input type="button" value="go" onclick="go();"/>&nbsp;&nbsp;&nbsp; 
	
	每页<input type="number"  style="width: 30px" min="1"  name="User_pageSize" value="${pageResult. pageSize}"/>条数据&nbsp;&nbsp;&nbsp; 
	<input type="button" value="change" onclick="go();"/>&nbsp;&nbsp;&nbsp; 
	一共${pageResult.totalCount}条数据&nbsp;&nbsp;&nbsp; 
	
	共 ${pageResult.totalPage }页
				