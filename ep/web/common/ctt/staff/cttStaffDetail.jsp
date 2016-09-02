<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<div class="contents">
	<!-- <form name="frm" style="clear:left;"> -->
	<div id="logleft" style="clear:left;">
		<c:choose>
			<c:when test="${empty reqStaff.pic}">
				<img class="stpic" src="images/noimage.gif">
			</c:when>
			<c:otherwise>
				<img class="stpic" src="upload/${reqStaff.pic}">
			</c:otherwise>
		</c:choose>
		<!-- <input type="button" value="변경">
		<input type="button" value="삭제"> -->
	</div>
	<div id="logright">
		<table style="font-size:20px;float:left">
			<tr><th colspan="2">개인 정보</th></tr>
			<tr>
				<td>이 름</td>
				<td>${reqStaff.empnm}</td>
			</tr>
			<tr>
				<td>주민번호</td>
				<td>${jmf}-${jmb}</td>
			</tr>
			<tr>
				<td>생년월일</td>
				<td>${yyyy}년 ${MM}월 ${dd}일</td>
			</tr>
			<tr>
				<td>성 별</td>
				<td>${gen}</td>
			</tr>
			<tr>
				<td>연락처</td>
				<td>${fmtphone}</td>
			</tr>
			<tr>
				<td>우편번호</td>
				<td>${reqStaff.zipcd}</td>
			</tr>
			<tr>
				<td>기본주소</td>
				<td>${reqStaff.addr}</td>
			</tr>
			<tr>
				<td>상세주소</td>
				<td>
					<div style="width:200px;">${reqStaff.addrdtl}</div>
					<%-- ${reqStaff.addrdtl} --%>
				</td>
			</tr>
		</table>
		<table style="font-size:20px;">
			<tr><th colspan="2">사원 정보</th></tr>
			<tr>
				<td>사 번</td>
				<td>${reqStaff.empno}</td>
			</tr>
			<tr>
				<td>사 원 아이디</td>
				<td>${reqStaff.empid}</td>
			</tr>
			<tr>
				<td>부 서</td>
				<td>${reqStaff.dptcd}</td>
			</tr>
			<tr>
				<td>직 급</td>
				<td>${reqStaff.titcd}</td>
			</tr>
			<tr>
				<td>입사일</td>
				<td>${reqStaff.startdt}</td>
			</tr>
			<tr>
				<td>퇴사일</td>
				<td>${reqStaff.enddt}</td>
			</tr>
				<td>급 여</td>
				<td>
					<fmt:formatNumber value="${reqStaff.sal}" type="currency"/>
				</td>
			</tr>
			<tr>
				<td>등록일</td>
				<td>${reqStaff.regdt}</td>
			</tr>
		</table>
		<br/><input type="button" value="수정하기" onclick="location.href='staff.do?cmd=staff_update_page'">
		<br/><a href="#" onClick="history.go(-1)"><input type="button" value="돌아가기"></a>
		<!-- </form> -->
	</div>
</div>
</body>
</html>






























