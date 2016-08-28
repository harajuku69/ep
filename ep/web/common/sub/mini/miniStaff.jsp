<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${empty loginStaff}">
	<jsp:forward page="common/login.jsp"/>
</c:if>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<div class="mini">
	<p>Staff</p>
	<hr/>
	<div class="mstaff">
		<div class="pd">
			<div class="pic">
				<img src="images/me.jpg" class="me" alt="사원사진">
			</div>
			<p class="wel">
				${loginStaff.empnm}님.
			</p>
		</div>
		<div class="simple">
			<ul>
				<li>최종 로그인 : ${loginStaff.lastdt}</li>
				<li>소속 : <a href="#=?부서원 검색결과">${loginStaff.dpt}</a></li>
				<li>직급 : ${loginStaff.tit}</li>
				<li>사번 : ${loginStaff.empno}</li>
				<!-- <li>프로젝트 : <a href="URL=?프로젝트 상세보기">수치예보 41기</a></li> -->
				<!-- <p><a href="staffdetail.do">개인 상세 정보</a></p> -->
				<p><a href="staff.do?cmd=staff_detail&empid=${loginStaff.empid}">개인 상세 정보</a></p>
			</ul>
		</div>
	</div>
</div>
</body>
</html>