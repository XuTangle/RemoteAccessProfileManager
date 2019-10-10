<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- This is the index page of the system, and it offers two main options to the user -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
</head>
<body>
	<h3><a href="StudentListServlet">显示所有学生列表</a></h3>
	<!--  shows all student information together -->
	<br/>
	<h3><a href="StudentPagedListServlet?page=1">分页显示学生列表</a></h3>
	<!--  shows student information in separate pages -->
</body> 
</html>