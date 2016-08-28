<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="../../../css/main.css">
</head>
<body>
<div class="mini">
	<p>Staff</p>
	<hr/>
	<div class="mstaff">
		<div class="pd">
			<div class="pic">
				<img src="../../../images/me.jpg" class="me" alt="사원사진">
			</div>
			<p class="wel">
				${empnm}정일대님.
			</p>
		</div>
		<div class="simple">
			<ul>
				<li>2016년 08월19일(33째주)</li>
				<li>메일 : <a href="#=?메일 검색결과">ildae.jung@mars.com</a></li>
				<li>소속 : <a href="#=?부서원 검색결과">관리부</a></li>
				<li>프로젝트 : <a href="URL=?프로젝트 상세보기">수치예보 41기</a></li>
				<p><a href="URL=?개인정보 상세보기">개인 상세 정보</a></p>
			</ul>
		</div>
	</div>
</div>
</body>
</html>