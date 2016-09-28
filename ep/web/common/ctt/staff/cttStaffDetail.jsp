<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="js/checkpwd.js"></script>
</head>
<body>
<div class="contents">
	<div id="pwd-dialog" title="비밀번호 확인">
		<p class="validateTips">본인 확인이 필요합니다.</p>
		<fieldset>
			<form id="frm">
				<label for="pwd">비밀번호를 입력해주세요.</label><br>
				<input type="password" name="pwd" id="pwd" placeholder="비밀번호" class="text ui-widget-content ui-corner-all"  ><br>
			</form>
		</fieldset>
		<p id="pwdChkRs"></p>
	</div> 
	<div id="logleft" style="clear:left;">
		<c:choose>
			<c:when test="${empty reqStaff.pic}">
				<img class="stpic" src="images/noimage.gif">
			</c:when>
			<c:otherwise>
				<img class="stpic" src="upload/${reqStaff.pic}">
			</c:otherwise>
		</c:choose>
	</div>
	<div id="logright">
			<table id="ind">
				<tr><th colspan="2" class="infhd">개인 정보</th></tr>
				<tr>
					<th>이 름</th>
					<td>${reqStaff.empnm}</td>
				</tr>
				<tr>
					<th>주민번호</th>
					<td>${jmf}-${jmb}</td>
				</tr>
				<tr>
					<th>생년월일</th>
					<td>${yyyy}년 ${MM}월 ${dd}일</td>
				</tr>
				<tr>
					<th>성 별</th>
					<td>${gen}</td>
				</tr>
				<tr>
					<th>연락처</th>
					<td>${reqStaff.phone}</td>
				</tr>
				<tr>
					<th>우편번호</th>
					<td>${reqStaff.zipcd}</td>
				</tr>
				<tr>
					<th>기본주소</th>
					<td>${reqStaff.addr}</td>
				</tr>
				<tr>
					<th>상세주소</th>
					<td>
						<div style="width:200px;">${reqStaff.addrdtl}</div>
					</td>
				</tr>
			</table>
		<table id="emp">
			<tr><th colspan="2" class="infhd">사원 정보</th></tr>
			<tr>
				<th>사 번</th>
				<td>${reqStaff.empno}</td>
			</tr>
			<tr>
				<th>아이디</th>
				<td>${reqStaff.empid}</td>
			</tr>
			<tr>
				<th>부 서</th>
				<td>${reqStaff.dptcd}</td>
			</tr>
			<tr>
				<th>직 급</th>
				<td>${reqStaff.titcd}</td>
			</tr>
			<tr>
				<th>입사일</th>
				<td>
					<c:set var="startdt" value="${reqStaff.startdt}"/>
					<c:out value="${fn:substring(startdt,0,10)}"/>
				</td>
			</tr>
			<tr>
				<th>퇴사일</th>
				<td>
					<c:set var="enddt" value="${reqStaff.enddt}"/>
					<c:out value="${fn:substring(enddt,0,10)}"/>
				</td>
			</tr>
			<tr>
				<th>급 여</th>
				<td>
					<fmt:formatNumber value="${reqStaff.sal}" type="currency"/>
				</td>
			</tr>
			<tr>
				<th>등록일</th>
				<td>
					<c:set var="regdt" value="${reqStaff.regdt}"/>
					<c:out value="${fn:substring(regdt,0,10)}"/>
				</td>
			</tr>
		</table>
		<br/>
		<div style="padding-left:200px">
			<input type="button" value="수정하기" id="chk_pwd" >
			<input type="button" value="돌아가기" onclick="location.href='staff.do?cmd=staff_home_page&empid=${reqStaff.empid}'">
		</div>
	</div>
</div>
</body>
</html>






























