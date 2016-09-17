<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="js/header.js"></script>
</head>
<body>
<div class="header">
	<div class="hair">
		<div><a href="staff.do?cmd=login_page">&nbsp;Mars EP</a></div>
		<div class="util">
			<table>
				<tr>
					<td><a href="staff.do?cmd=index">Home</a></td>
					<td><a href="staff.do?cmd=login_page">Login</a></td>
					<td><a href="staff.do?cmd=join_page">Join</a></td>
				</tr>
			</table>
		</div>
	</div>
	<div class="face">
		<div class="logo">
			<a href="staff.do?cmd=index"><img src="images/logo.png" alt="로고 이미지"></a>
		</div>
		<div id="gnbarea">
			<ul class ="menu">
				<li><a href="#">개인 정보</a>
					<ul>
						<li><a href="staff.do?cmd=login_page" class="documents">개인 정보 상세</a></li>
					</ul>
				</li>
				<li><a href="#">공지사항</a>
					<ul>
						<li><a href="staff.do?cmd=login_page" class="documents">공지사항 목록</a></li>
					</ul>
				</li>
				<li><a href="#">프로젝트</a>
					<ul>
						<li><a href="staff.do?cmd=login_page" class="documents">프로젝트 목록</a></li>
					</ul>
				</li>
			</ul>
		</div>
		<div class="search">
		<!-- <form action="staff.do?cmd=login_page" method="get" name="frm"> -->
			<table>
				<tr>
					<td>
						<input type="text" name="empnm" id="empnm" placeholder="이름을 입력하세요">
					</td>
					<td>
						<input type="button" id="btn" value="검색" onclick="location.href='staff.do?cmd=login_page'">		
					</td>
				</tr>
			</table>
		<!-- </form> -->
		</div>
	</div>
</div>
</body>
</html>















