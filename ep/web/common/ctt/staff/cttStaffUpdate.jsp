<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- <script type="text/javascript" src="js/ajaxSelbox.js"></script> -->
</head>
<body>
<div class="contents">
	<form action="staff.do?cmd=staff_update" name="frm">
	<div id="logleft">
		<c:choose>
			<c:when test="${empty ssStaff.pic}">
				<img class="stpic" src="images/noimage.gif">
			</c:when>
			<c:otherwise>
				<img class="stpic" src="upload/${ssStaff.pic}">
			</c:otherwise>
		</c:choose>
		<input type="button" value="변경">
		<input type="button" value="삭제">
	</div>
	<div id="logright">
		<table style="font-size:20px;float:left">
			<tr><th colspan="2">개인 정보</th></tr>
			<tr>
				<td>이 름</td>
				<td><input type="text" name="empnm" id="empnm" value="${ssStaff.empnm}" readonly></td>
			</tr>
			<tr>
				<td>주민번호</td>
				<td><input type="text" name="jumin" id="jumin" value="${jmf}-${jmb}" readonly></td>
			</tr>
			<tr>
				<td>생년월일</td>
				<td><input type="text" name="bdt" id="bdt" value="${yyyy}년 ${MM}월 ${dd}일" readonly></td>
			</tr>
			<tr>
				<td>성 별</td>
				<td><input type="text" name="gen" id="gen" value="${gen}" readonly></td>
			</tr>
			<tr>
				<td>연락처</td>
				<td><input type="text" name="phone" id="phone" placeholder="숫자만 입력하세요. '-' 입력 X" ></td>
			</tr>
			<tr>
				<td>우편번호</td>
				<td>${ssStaff.zipcd}</td>
			</tr>
			<tr>
				<td>기본주소</td>
				<td></td>
			</tr>
			<tr>
				<td>상세주소</td>
				<td><input type="text" name="addrdtl" id="addtdtl" placeholder="상세 주소를 입력하세요" ></td>
			</tr>
		</table>
		<table style="font-size:20px;">
			<tr><th colspan="2">사원 정보</th></tr>
			<tr>
				<td>사 원 아이디</td>
				<td>${ssStaff.empid}</td>
			</tr>
			<tr>
				<td>사 번</td>
				<td><input type="text" name="empno" id="empno" value="${ssStaff.empno}" readonly></td>
			</tr>
			<tr>
				<td>부 서</td>
				<td><input type="text" name="dpt" id="dpt" value="${ssStaff.dpt}" readonly></td>
			</tr>
			<tr>
				<td>직 급</td>
				<td><input type="text" name="tit" id="tit" value="${ssStaff.tit}" readonly></td>
			</tr>
			<tr>
				<td>입사일</td>
				<td><input type="text" name="startdt" value="${ssStaff.startdt}" readonly></td>
			</tr>
			<tr>
				<td>퇴사일</td>
				<td><input type="text" name="enddt" value="${ssStaff.enddt}" readonly></td>
			</tr>
				<td>급여</td>
				<td><fmt:formatNumber value="${ssStaff.sal}" type="currency" readonly /></td>
			</tr>
			<tr>
				<td>등록일</td>
				<td><input type="text" name="regdt" value="${ssStaff.regdt}" readonly></td>
			</tr>
		</table>
		<input type="submit" value="수정 완료" >
		</form>
	</div>
</div>
</body>
</html>






























