<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="js/accordion.js"></script>
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
					<td><a href="staff.do?cmd=staff_home_page">${ssEmpnm}</a></td>
				</tr>
			</table>
		</div>
	</div>
	<div class="face">
		<div class="logo">
			<a href="staff.do?cmd=admin_home_page"><img src="../images/logo.png" alt="로고 이미지"></a>
		</div>
		<div id="accordion">
			<div>
				<table>
					<tr>
						<td style="width:200px; line-height:10px">사원 정보</td>
						<td style="width:200px; line-height:10px">공지사항</td>
						<td style="width:200px; line-height:10px">프로젝트</td>
					</tr>
				</table>
			</div>
			<div>
				<table>
					<tr>
						<td style="width:200px; line-height:10px">
							<p><a href="staff.do?cmd=staff_list">사원 정보 관리</a></p>
							<!-- <p><a href="staff.do?cmd=admin_update_page">사원 정보 수정</a></p> -->
						</td>
						<td style="width:200px; line-height:10px">
							<p><a href="noti.do?cmd=admin_noti_list">공지사항 관리</a></p>
						</td>
						<td style="width:200px; line-height:10px">
							<p><a href="pjt.do?cmd=admin_pjt_list">프로젝트 관리</a></p>
						</td>
					</tr>
				</table>
			</div>
		</div>
		<div class="search">
		<form action="URL" method="get" name="frm">
			<table>
				<tr>
					<td>
						<input type="text" name="qry" id="qry" placeholder="이름을 입력하세요" required>
					</td>
					<td>
						<input type="submit" id="btn" value="검색" onclick="return function()">		
					</td>
				</tr>
			</table>
		</form>
		</div>
	</div>
</div>
</body>
</html>















