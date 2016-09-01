<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="js/contents.js"></script>
</head>
<body>
<div class="contents">
	<h1> Mars 사원 목록 </h1>
	<div id="list-contain" class="ui-widget">
			<table class="list">
				<thead>
				<tr class="ui-widget-header">
					<th>이 름</th>
					<th>부 서</th>
					<th>직 급</th>
					<th>연락처</th>
					<th>이메일</th>
					<th>수 정</th>
					<th>삭 제</th>
				</tr>
				<thead>
				<tbody>
				</tbody>
				<c:forEach var="it" items="${staffList}">
					<tr class="${it.empid}">
						<td>
							<a href="staff.do?cmd=admin_detail_page&empid=${it.empid}">${it.empnm}</a>
						</td>
						<td>${it.dptcd}</td>
						<td>${it.titcd}</td>
						<td>${it.phone}</td>
						<td><a href="mailto:${it.empid}@mars.com">${it.empid}@mars.com</a></td>
						<td><button id="update-list" onclick='staff.do?cmd=admin_update_page&empid=${it.empid}'>수정</button></td>
						<td><button id="delete-list" onclick='staff.do?cmd=admin_delete_page&empid=${it.empid}'>삭제</button></td>
					</tr>
				</c:forEach>
			</table>
	</div>
	<br/>
</div>
</body>
</html>