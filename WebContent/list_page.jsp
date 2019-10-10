<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- This page is used to show student profiles in separate pages (as specified in the Impl class). There are also hyperlinks for the prev /next page, as well as the top / last page, etc.  -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生列表页面</title>

<script type="text/javascript">
       		function doDelete(sid) {
   			var flag = confirm("是否确定删除?");
   			if(flag){
   				//window.location.href="DeleteServlet?sid="+sid;
   				location.href="DeleteServlet?sid="+sid;
   			}
   		}
   	</script>

</head>
<body>

<h3>欢迎使用学生管理系统</h3>
<a href="StudentListServlet">切换到单页模式</a><br /><br />

	<form action="SearchStudentServlet" method="post">
	
		<table border="1" width="900">
			<tr>
				<td colspan="8">
					按姓名查询：
					<input type="text" name="sname">
					
					&nbsp;&nbsp;&nbsp;  按性别查询：
					<select name="sgender">
						<option value="">请选择
						<option value="M">男
						<option value="F">女
					</select>
					&nbsp;&nbsp;&nbsp;
					<input type="submit" value="查询">
					&nbsp;&nbsp;&nbsp;
					<a href="add.jsp">添加</a>
				</td>			
			</tr>
			<tr align="center">
				<td>编号</td>
				<td>姓名</td>
				<td>性别</td>
				<td>电话</td>
				<td>生日</td>
				<td>爱好</td>
				<td>简介</td>
				<td>操作</td>
			</tr>
			
			
			<c:forEach items="${pageBean.list}" var="stu">
				<tr align="center">
					<td>${stu.sid}</td>
					<td>${stu.sname}</td>
					<td>${stu.gender}</td>
					<td>${stu.phone}</td>
					<td>${stu.birthday}</td>
					<td>${stu.hobby}</td>
					<td>${stu.info}</td>
					<td>
						<a href="EditServlet?sid=${stu.sid}">更新</a>
						<a href="#" onclick="doDelete(${stu.sid})">删除</a>
					</td>
				</tr>
			</c:forEach>
			
			<tr>
				<td colspan="8">
				
					页数	&nbsp;&nbsp;	${pageBean.currentPage} &nbsp;&nbsp; / &nbsp;&nbsp; ${pageBean.totalPage } &nbsp;&nbsp;
					每页显示${pageBean.pageSize }条 &nbsp;&nbsp; 共计${pageBean.totalSize }条 &nbsp;&nbsp;
					
					<c:if test="${pageBean.currentPage !=1 }">
						[<a href="StudentPagedListServlet?page=1">首页</a>]&nbsp;&nbsp;
						[<a href="StudentPagedListServlet?page=${pageBean.currentPage-1}">上一页</a>]&nbsp;&nbsp;
					</c:if>
					
					<c:forEach begin="1" end="${pageBean.totalPage}" var="i">
						&nbsp;&nbsp; 
						<c:if test="${i != pageBean.currentPage }">
							<a href="StudentPagedListServlet?page=${i }"> ${i } </a>
						</c:if>
						<c:if test="${i == pageBean.currentPage }">
							${i }
						</c:if>
					</c:forEach>
					
					<c:if test="${pageBean.currentPage != pageBean.totalPage }">
						[<a href="StudentPagedListServlet?page=${pageBean.currentPage+1}">下一页</a>]&nbsp;&nbsp;
						[<a href="StudentPagedListServlet?page=${pageBean.totalPage}">尾页</a>]&nbsp;&nbsp;
					</c:if>
					
				</td>
			</tr>
			
		</table>
	</form>
	
</body>

</html>