<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${empty ssStaff}">
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
	<p style="display:inline;">Admin </p>|
	<p style="display:inline;"><a href="staff.do?cmd=login"> Staff</a></p>
	<hr/>
	<div class="mstaff">
		<div class="pd">
			<div class="pic">
				<%-- <c:choose>
				<c:when test="${empty ssStaff.pic}">
					<img class="stpic" src="images/noimage.gif">
				</c:when>
				<c:otherwise>
					<img class="stpic" src="upload/${ssStaff.pic}">
				</c:otherwise>
				</c:choose> --%>
				<img src="images/admin_01.png" class="me" alt="admin 사진">
			</div>
			<p class="wel">
				${ssStaff.admnm}님.
			</p>
		</div>
		<div class="simple">
			<ul>
				<li>최종 로그인 : ${ssStaff.lastdt}</li>
				<li>소속 : <a href="#=?부서원 검색결과">${ssStaff.dpt}</a></li>
				<li>직급 : ${ssStaff.tit}</li>
				<li>사번 : ${ssStaff.empno}</li>
				<!-- <li>프로젝트 : <a href="URL=?프로젝트 상세보기">수치예보 41기</a></li> -->
				<p><a href="staff.do?cmd=admin_detail&empid=${ssStaff.empid}">사원 상세 정보</a></p>
			</ul>
		</div>
	</div>
</div>
</body>
</html>