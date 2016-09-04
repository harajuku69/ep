<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<div class="mini">
	<p style="display:inline;">Notice</p>
	<c:if test="${ssAdmchk == 1}">
		<span>|</span>
		<p style="display:inline;"><a href="staff.do?cmd=admin_noti_list"> Edit</a></p>
	</c:if>
	<hr/>
	<ul>
		<li><a href="#">하계 기간 휴양소 신청</a><span>2016-08-15</span></li>
		<li><a href="#">MBA 과정 신청 접수</a><span>2016-08-15</span></li>
		<li><a href="#">경영기술개발원 수치예보41기</a><span>2016-08-15</span></li>
		<li><a href="#">[중요] 4번째 공지사항 작성</a><span>2016-08-15</span></li>
	</ul>
		<p><a href="noti.do?cmd=staff_noti_list">more</a></p>
</div>
</body>
</html>