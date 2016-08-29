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
<script type="text/javascript" src="js/ajaxSelbox.js"></script>
</head>
<body>
<div class="contents">
	<form action="staff.do?cmd=staff_update" name="frm" style="clear:left;">
	<div id="logleft">
		<c:choose>
			<c:when test="${empty ssStaff.pic}">
				<img class="stpic" src="images/noimage.gif">
			</c:when>
			<c:otherwise>
				<img class="stpic" src="upload/${ssStaff.pic}">
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
				<td><input type="text" name="phone" id="phone" value="${ssStaff.phone}" readonly></td>
			</tr>
			<tr>
				<td>우편번호</td>
				<td>
					<input type="text" name="zipcd" id="zipcd" value="${ssStaff.zipcd}" readonly>
				</td>
			</tr>
			<tr>
				<td>기본주소</td>
				<td><input type="text" name="addr" id="addr" value="${ssStaff.addr}" readonly></td>
			</tr>
			<tr>
				<td>상세주소</td>
				<td><input type="text" name="addrdtl" id="addrdtl" value="${ssStaff.addrdtl}" readonly></td>
			</tr>
		</table>
		<table style="font-size:20px;">
			<tr><th colspan="2">사원 정보</th></tr>
			<tr>
				<td>사 번</td>
				<td><input type="text" name="empno" id="empno" value="${ssStaff.empno}" readonly></td>
			</tr>
			<tr>
				<td>사 원 아이디</td>
				<td><input type="text" name="empno" id="empno" value="${ssStaff.empid}" readonly></td>
			</tr>
			<tr>
				<td>부 서</td>
				<td>
					<select name="dptbx" id="dptbx">
						<option value="">부서 선택</option>
						<option value="00">관리부</option>
						<option value="10">개발부</option>
						<option value="20">구매부</option>
						<option value="30">생산부</option>
						<option value="40">영업부</option>
						<option value="50">인사부</option>
						<option value="60">총무부</option>
						<option value="70">품질부</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>직 급</td>
				<td>
					<select name="titbx" id="titbx">
						<option value="">직급 선택</option>
						<option value="00">대표</option>
						<option value="10">사원</option>
						<option value="20">대리</option>
						<option value="30">과장</option>
						<option value="40">차장</option>
						<option value="50">부장</option>
						<option value="60">이사</option>
						<option value="70">상무</option>
						<option value="80">전무</option>
						<option value="90">사장</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>입사일</td>
				<td><input type="text" name="startdt" id="startdt" ></td>
			</tr>
			<tr>
				<td>퇴사일</td>
				<td><input type="text" name="enddt" id="enddt" ></td>
			</tr>
				<td>급여</td>
				<td><input type="text" name="sal" id="sal" ></td>
			</tr>
			<tr>
				<td>등록일</td>
				<td><input type="text" name="regdt" readonly></td>
			</tr>
		</table>
		<input type="submit" value="수정 완료" >
		<input type="reset" value="다시 작성" >
		<input type="button" value="수정 취소" onclick="location.href='admin.do?cmd=admin_detail_page'">
		</form>
	</div>
</div>
</body>
</html>






























