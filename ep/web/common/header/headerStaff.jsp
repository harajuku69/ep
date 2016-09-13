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
		<div><a href="staff.do?cmd=staff_home_page">&nbsp;Mars EP</a></div>
		<div class="util">
			<table>
				<tr>
					<td><a href="staff.do?cmd=staff_home_page">Home</a></td>
					<td><a href="staff.do?cmd=logout">Logout</a></td>
					<c:choose>
						<c:when test="${ssAdmchk == 1}">
							<td><a href="staff.do?cmd=admin_home_page&empid=${ssEmpid}">${ssAdmnm}</a></td>
						</c:when>
						<c:otherwise>
							<td><a href="staff.do?cmd=staff_detail_page&empid=${ssEmpid}">${ssEmpnm}</a></td>
						</c:otherwise>
					</c:choose>
				</tr>
			</table>
		</div>
	</div>
	<div class="face">
		<div class="logo">
			<a href="staff.do?cmd=staff_home_page"><img src="images/logo.png" alt="로고 이미지"></a>
		</div>
		<div id="gnbarea">
			<div>
				<table>
					<tr id="gnb">
						<td style="width:200px; line-height:10px">
							<a href="#">개인 정보</a>
						</td>
						<td style="width:200px; line-height:10px">
							<a href="#">공지사항</a>
						</td>
						<td style="width:200px; line-height:10px">
							<a href="#">프로젝트</a>
						</td>
					</tr>
				</table>
			</div>
			<div id="gnbtab">
				<table>
					<tr>
						<td style="width:200px; line-height:10px">
							<p class="gnbmenu"><a href="staff.do?cmd=staff_detail_page&empid=${ssEmpid}">개인 정보 상세</a></p>
							<!-- <p class="gnbmenu"><a href="staff.do?cmd=staff_update_page">개인 정보 수정</a></p> -->
						</td>
						<td style="width:200px; line-height:10px">
							<p class="gnbmenu"><a href="noti.do?cmd=staff_noti_list">공지사항 목록</a></p>
						</td>
						<td style="width:200px; line-height:10px">
							<p class="gnbmenu"><a href="pjt.do?cmd=staff_pjt_list">프로젝트 목록</a></p>
						</td>
					</tr>
				</table>
			</div>
		</div>
		<div class="search">
		<form action="staff.do?cmd=staff_select_member" method="post" name="frm">
			<table>
				<tr>
					<td>
						<input type="text" name="empnm" id="empnm" placeholder="이름을 입력하세요" required>
					</td>
					<td>
						<%-- <input type="button" id="btn" value="검색" onclick="location.href='staff.do?cmd=staff_select_member&empnm=${}'"> --%>		
						<!-- <input type="submit" id="qrybtn" value="검색" > -->
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















