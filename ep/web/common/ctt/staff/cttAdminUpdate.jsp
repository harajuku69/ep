<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<!-- <form name="frm" style="clear:left;"> -->
	<div id="logleft">
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
				<td>
					<%-- <input type="text" name="empnm" id="empnm" value="${reqStaff.empnm}" readonly> --%>
					${reqStaff.empnm}
				</td>
			</tr>
			<tr>
				<td>주민번호</td>
				<td>
					<%-- <input type="text" name="jumin" id="jumin" value="${jmf}-${jmb}" readonly> --%>
					${jmf}-${jmb}
				</td>
			</tr>
			<tr>
				<td>생년월일</td>
				<td>
					<%-- <input type="text" name="bdt" id="bdt" value="${yyyy}년 ${MM}월 ${dd}일" readonly> --%>
					${yyyy}년 ${MM}월 ${dd}일
				</td>
			</tr>
			<tr>
				<td>성 별</td>
				<td>
					<%-- <input type="text" name="gen" id="gen" value="${gen}" readonly> --%>
					${gen}
				</td>
			</tr>
			<tr>
				<td>연락처</td>
				<td>
					<%-- <input type="text" name="phone" id="phone" value="${reqStaff.phone}" readonly> --%>
					${fmtphone}
				</td>
			</tr>
			<tr>
				<td>우편번호</td>
				<td>
					<%-- <input type="text" name="zipcd" id="zipcd" value="${reqStaff.zipcd}" readonly> --%>
					${reqStaff.zipcd}
				</td>
			</tr>
			<tr>
				<td>기본주소</td>
				<td>
					<%-- <input type="text" name="addr" id="addr" value="${reqStaff.addr}" readonly> --%>
					${reqStaff.addr}
				</td>
			</tr>
			<tr>
				<td>상세주소</td>
				<td>
					<%-- <input type="text" name="addrdtl" id="addrdtl" value="${reqStaff.addrdtl}" readonly> --%>
					${reqStaff.addrdtl}
				</td>
			</tr>
		</table>
		<form action="staff.do?cmd=admin_update" method="post" name="frm">
		<table style="font-size:20px;">
			<tr><th colspan="2">사원 정보</th></tr>
			<tr>
				<td>사 번</td>
				<td>${reqStaff.empno}</td>
			</tr>
			<tr>
				<td>사 원 아이디</td>
				<td>
					<%-- <input type="text" name="empno" id="empno" value="${reqStaff.empid}" readonly> --%>
					${reqStaff.empid}
				</td>
			</tr>
			<tr>
				<td>부 서</td>
				<td>
					<select name="dptcd" id="dptbx">
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
					<select name="titcd" id="titbx">
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
				<td><input type="text" name="startdt" id="startdt" value="${reqStaff.startdt}"></td>
			</tr>
			<tr>
				<td>퇴사일</td>
				<td><input type="text" name="enddt" id="enddt" value="${reqStaff.enddt}"></td>
			</tr>
				<td>급 여</td>
				<td><input type="text" name="sal" id="sal" value="${reqStaff.sal}"></td>
			</tr>
			<tr>
				<td>등록일</td>
				<td>
					<%-- <input type="text" name="regdt" value="${reqStaff.regdt}" readonly> --%>
					${reqStaff.regdt}
				</td>
			</tr>
			<tr>
				<td>권 한</td>
				<td>
					<input type="radio" name="admchk" value="0" checked="checked">일반
					<input type="radio" name="admchk" value="1" >관리자
				</td>
			</tr>
		</table>
		<input type="submit" value="수정 완료" >
		<input type="reset" value="다시 작성" >
		<input type="button" value="수정 취소" onclick="location.href='staff.do?cmd=admin_detail_page'">
		</form>
	</div>
</div>
</body>
</html>






























