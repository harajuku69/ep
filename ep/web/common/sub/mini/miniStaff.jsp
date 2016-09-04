<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${empty ssEmpid}">
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
	<p style="display:inline;">Staff </p>
	<c:if test="${ssAdmchk == 1}" >
		<span>|</span>
		<p style="display:inline;"><a href="staff.do?cmd=admin_home_page&toStat=1"> Admin</a></p>
	</c:if>
	<hr/>
	<div class="mstaff">
		<div class="pd">
			<div class="pic">
				<c:choose>
				<c:when test="${empty reqStaff.pic}">
					<img class="stpic" src="images/noimage.gif">
				</c:when>
				<c:otherwise>
					<img class="stpic" src="upload/${reqStaff.pic}">
				</c:otherwise>
				</c:choose>
				<!-- <img src="images/me.jpg" class="me" alt="사원사진"> -->
			</div>
			<p class="wel">${ssEmpnm}님.</p>
		</div>
		<div class="simple">
			<ul>
				<li>최종 로그인 : ${ssLastdt}</li>
				<li>소속 : <a href="#=?부서원 검색결과">${ssDptcd}</a></li>
				<li>직급 : ${ssTitcd}</li>
				<li>사번 : ${ssEmpno}</li>
				<!-- <li>프로젝트 : <a href="URL=?프로젝트 상세보기">수치예보 41기</a></li> -->
				<!-- <p><a href="staffdetail.do">개인 상세 정보</a></p> -->
			</ul>
				<p><a href="staff.do?cmd=staff_detail_page&empid=${ssEmpid}">개인 상세 정보</a></p>
		</div>
	</div>
</div>
</body>
</html>