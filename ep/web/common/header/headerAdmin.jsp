<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- <script src="js/accordion.js"></script> -->
<script src="js/header.js"></script>
</head>
<body>
<div class="header">
	<div class="hair">
		<div><a href="staff.do?cmd=admin_home_page">&nbsp;Mars EP</a></div>
		<div class="util">
			<table>
				<tr>
					<td><a href="staff.do?cmd=admin_home_page">Home</a></td>
					<td><a href="staff.do?cmd=logout">Logout</a></td>
					<td><a href="staff.do?cmd=staff_home_page&empid=${ssEmpid}">${ssEmpnm}</a></td>
				</tr>
			</table>
		</div>
	</div>
	<div class="face">
		<div class="logo">
			<a href="staff.do?cmd=admin_home_page"><img src="../images/logo.png" alt="로고 이미지"></a>
		</div>
		<div id="gnbarea">
			<ul class ="menu">
				<li><a href="#">사원 정보</a>
					<ul>
						<li><a href="staff.do?cmd=staff_list" class="documents">사원 정보 관리</a></li>
					</ul>
				</li>
				<li><a href="#">공지사항</a>
					<ul>
						<li><a href="noti.do?cmd=admin_noti_list" class="documents">공지사항 관리</a></li>
					</ul>
				</li>
				<li><a href="#">프로젝트</a>
					<ul>
						<li><a href="pjt.do?cmd=admin_pjt_list" class="documents">프로젝트 관리</a></li>
					</ul>
				</li>
			</ul>
		</div>
		<div class="search">
		<form action="staff.do?cmd=admin_select_member" method="post" name="frm">
			<table>
				<tr>
					<td>
						<input type="text" name="empnm" id="empnm" placeholder="이름을 입력하세요" required>
					</td>
					<td>
						<%-- <input type="button" id="btn" value="검색" onclick="location.href='staff.do?cmd=admin_select_member&empnm=${empnm}'"> --%>
						<input type="submit" id="btn" value="검색" >		
					</td>
				</tr>
			</table>
		</form>
		</div>
	</div>
</div>
</body>
</html>















