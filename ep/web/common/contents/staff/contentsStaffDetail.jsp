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
<div class="contents">
	<div id="logleft">
		<c:choose>
			<c:when test="${empty staffDetail.pic}">
				<img class="stpic" src="images/noimage.gif">
			</c:when>
			<c:otherwise>
				<img class="stpic" src="upload/${staffDetail.pic}">
			</c:otherwise>
		</c:choose>
		<!-- <input type="button" value="변경">
		<input type="button" value="삭제"> -->
		<!-- <ul>
			<li><a href="#tabedu">학력</a></li><hr/>
			<li><a href="#tabedu">경력</a></li><hr/>
			<li><a href="#tabedu">자격증</a></li><hr/>			
		</ul> -->
	</div>
	<div id="logright">
		<table style="font-size:20px;float:left">
			<tr><th colspan="2">개인 정보</th></tr>
			<tr>
				<td>이 름</td>
				<td>${loginStaff.empnm}</td>
			</tr>
			<tr>
				<td>주민번호</td>
				<td>${loginStaff.jumin}</td>
			</tr>
			<tr>
				<td>생년월일</td>
				<td>${loginStaff.empnm}</td>
			</tr>
			<tr>
				<td>성 별</td>
				<td>${loginStaff.empnm}</td>
			</tr>
			<tr>
				<td>연락처</td>
				<td>${loginStaff.phone}</td>
			</tr>
			<tr>
				<td>우편번호</td>
				<td>${loginStaff.zipcd}</td>
			</tr>
			<tr>
				<td>기본주소</td>
				<td>${loginStaff.addr}</td>
			</tr>
			<tr>
				<td>상세주소</td>
				<td>${loginStaff.addrdtl}</td>
			</tr>
		</table>
		<table style="font-size:20px;float:left">
			<tr><th colspan="2">사원 정보</th></tr>
			<tr>
				<td>사 번</td>
				<td>${loginStaff.empno}</td>
			</tr>
			<tr>
				<td>부 서</td>
				<td>${loginStaff.dpt}</td>
			</tr>
			<tr>
				<td>직 급</td>
				<td>${loginStaff.tit}</td>
			</tr>
			<tr>
				<td>입사일</td>
				<td>${loginStaff.startdt}</td>
			</tr>
			<tr>
				<td>퇴사일</td>
				<td>${loginStaff.enddt}</td>
			</tr>
				<td>급여</td>
				<td>${loginStaff.sal}</td>
			</tr>
			<tr>
				<td>등록일</td>
				<td>${loginStaff.regdt}</td>
			</tr>
		</table>
	</div>
</div>
</body>
</html>






























