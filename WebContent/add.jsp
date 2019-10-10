<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- This page is a form that contains all relevant fields and a SUBMIT button. Upon click, a new student profile will be added to the database -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加学生信息</title>
</head>
<body>
	<h3>添加学生页面</h3>
	
	<form method="post" action="AddServlet">
	<table border="1" width="600">
		<tr>
			<td>姓名</td>
			<td><input type="text" name="sname"></td>
		</tr>
		<tr>
			<td>性别</td>
			<td>
				<input type="radio" name="gender" value="M">男
				<input type="radio" name="gender" value="F">女
			</td>
		</tr>
		<tr>
			<td>电话</td>
			<td><input type="text" name="phone"></td>
		</tr>
		<tr>
			<td>生日</td>
			<td><input type="text" name="birthday"></td>
		</tr>
		<tr>
			<td>爱好</td>
			<td>
				<input type="checkbox" name="hobby" value="swim">游泳
				<input type="checkbox" name="hobby" value="basketball">篮球
				<input type="checkbox" name="hobby" value="soccer">足球
				<input type="checkbox" name="hobby" value="read">看书
				<input type="checkbox" name="hobby" value="write">写字
			</td>
		</tr>
		<tr>
			<td>简介</td>
			<td><textarea name="info" rows="10" cols="50"></textarea></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="添加"></td>
		</tr>
		
	</table>
	</form>

</body>
</html>