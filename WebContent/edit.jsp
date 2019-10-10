<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- This page is a form that shows a specific student's profile. Users can make changes and submit the update to the database -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>更新学生信息</title>
</head>
<body>
	<h3>更新学生页面</h3><br />
	
	<form method="post" action="UpdateServlet">
		
		<input type="hidden" name="sid" value="${student.sid}" >
		
		<table border="1" width="600">
			<tr>
				<td>姓名</td>
				<td><input type="text" name="sname" value="${student.sname}"></td>
			</tr>
			<tr>
				<td>性别</td>
				<td>
					<input type="radio" name="gender" value="M" <c:if test="${student.gender=='M'}">checked</c:if>>男
					<input type="radio" name="gender" value="F" <c:if test="${student.gender=='F'}">checked</c:if>>女
				</td>
			</tr>
			<tr>
				<td>电话</td>
				<td><input type="text" name="phone" value="${student.phone}"></td>
			</tr>
			<tr>
				<td>生日</td>
				<td><input type="text" name="birthday" value="${student.birthday}"></td>
			</tr>
			<tr>
				<td>爱好</td>
				<td>
					<input type="checkbox" name="hobby" value="swim" <c:if test="${fn:contains(student.hobby,'swim')}">checked</c:if>>游泳
					<input type="checkbox" name="hobby" value="basketball" <c:if test="${fn:contains(student.hobby,'basketball')}">checked</c:if>>篮球
					<input type="checkbox" name="hobby" value="soccer" <c:if test="${fn:contains(student.hobby,'soccer')}">checked</c:if>>足球
					<input type="checkbox" name="hobby" value="read" <c:if test="${fn:contains(student.hobby,'read')}">checked</c:if>>看书
					<input type="checkbox" name="hobby" value="write" <c:if test="${fn:contains(student.hobby,'write')}">checked</c:if>>写字
				</td>
			</tr>
			<tr>
				<td>简介</td>
				<td><textarea name="info" rows="10" cols="50">${student.sname}</textarea></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="更新"></td>
			</tr>
			
		</table>
	</form>

</body>
</html>