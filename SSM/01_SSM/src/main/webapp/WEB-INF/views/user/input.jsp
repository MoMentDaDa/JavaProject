<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>编辑界面</title>
</head>
<body>
	<form action="/user/saveOrUpdate" method="post">
		<input type="hidden" name="id" value="${user.id}"> 
		名称: <input type="text" name="name" value="${user.name}"><br/>
		年龄: <input type="number" name="age" value="${user.age}"><br/>
		 <input type="submit" value="保存">
	</form>
</body>
</html>
