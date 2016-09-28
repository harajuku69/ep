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
<script src="js/checkUpdate.js"></script>
</head>
<body>
<div class="contents">
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
		<table id="ind">
			<tr><th colspan="2" class="infhd">개인 정보</th></tr>
			<tr>
				<th>이 름</th>
				<td>${reqStaff.empnm}</td>
			</tr>
			<tr>
				<th>주민번호</th>
				<td>
					<%-- <input type="text" name="jumin" id="jumin" value="${jmf}-${jmb}" readonly> --%>
					${jmf}-${jmb}
				</td>
			</tr>
			<tr>
				<th>생년월일</th>
				<td>
					<%-- <input type="text" name="bdt" id="bdt" value="${yyyy}년 ${MM}월 ${dd}일" readonly> --%>
					${yyyy}년 ${MM}월 ${dd}일
				</td>
			</tr>
			<tr>
				<th>성 별</th>
				<td>
					<%-- <input type="text" name="gen" id="gen" value="${gen}" readonly> --%>
					${gen}
				</td>
			</tr>
			<tr>
				<th>연락처</th>
				<td>
					<%-- <input type="text" name="phone" id="phone" value="${reqStaff.phone}" readonly> --%>
					${fmtphone}
				</td>
			</tr>
			<tr>
				<th>우편번호</th>
				<td>
					<%-- <input type="text" name="zipcd" id="zipcd" value="${reqStaff.zipcd}" readonly> --%>
					${reqStaff.zipcd}
				</td>
			</tr>
			<tr>
				<th>기본주소</th>
				<td>
					<%-- <input type="text" name="addr" id="addr" value="${reqStaff.addr}" readonly> --%>
					${reqStaff.addr}
				</td>
			</tr>
			<tr>
				<th>상세주소</th>
				<td>
					<div style="width:200px;">${reqStaff.addrdtl}</div>
					<%-- ${reqStaff.addrdtl} --%>
				</td>
			</tr>
		</table>
		<form action="staff.do?cmd=admin_update&empid=${reqStaff.empid}" method="post" name="frm" >
		<table id="emp">
			<tr><th colspan="2" class="infhd">사원 정보</th></tr>
			<tr>
				<th>사 번</th>
				<td>${reqStaff.empno}</td>
			</tr>
			<tr>
				<th>아이디</th>
				<td>
					<%-- <input type="text" name="empno" id="empno" value="${reqStaff.empid}" readonly> --%>
					${reqStaff.empid}
				</td>
			</tr>
			<tr>
				<th>부 서</th>
				<td>
					<select name="dptcd" id="dptbx">
						<c:forEach var="dpt" items="${reqDptList}">
							<c:choose>
							<c:when test="${dpt.dpt == reqStaff.dptcd}">
								<option value="${dpt.dptcd}" selected="selected" >${dpt.dpt}</option>
							</c:when>
							<c:otherwise>
								<option value="${dpt.dptcd}">${dpt.dpt}</option>
							</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<th>직 급</th>
				<td>
					<select name="titcd" id="titbx">
						<c:forEach var="tit" items="${reqTitList}">
							<c:choose>
							<c:when test="${tit.tit == reqStaff.titcd}">
								<option value="${tit.titcd}" selected="selected" >${tit.tit}</option>
							</c:when>
							<c:otherwise>
								<option value="${tit.titcd}">${tit.tit}</option>
							</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<th>입사일</th>
				<td><input type="text" name="startdt" id="startdt" value="${fn:substring(reqStaff.startdt, 0, 10)}"></td>
			</tr>
			<tr>
				<th>퇴사일</th>
				<td><input type="text" name="enddt" id="enddt" value="${fn:substring(reqStaff.enddt, 0, 10)}"></td>
			</tr>
			<tr>
				<th>급 여</th>
				<td>
					<%-- <fmt:formatNumber type="currency" value="${reqStaff.sal}"/> --%>
					<input type="text" name="sal" id="sal" maxlength="9" value="${reqStaff.sal}">
				</td>
			</tr>
			<tr>
				<th>등록일</th>
				<td>
					<%-- <input type="text" name="regdt" value="${reqStaff.regdt}" readonly> --%>
					${fn:substring(reqStaff.regdt, 0, 10)}
				</td>
			</tr>
			<tr>
				<th>권 한</th>
				<td>
					<!-- <input type="radio" name="admchk" value="0" checked="checked">일반
					<input type="radio" name="admchk" value="1" >관리자 -->
					<c:choose>
						<c:when test="${reqStaff.admchk == '0'}">
							<input type="radio" name="admchk" value="0" checked="checked">일 반
							<input type="radio" name="admchk" value="1" >관리자
						</c:when>
						<c:otherwise>
							<input type="radio" name="admchk" value="0" >일 반
							<input type="radio" name="admchk" value="1" checked="checked">관리자
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
		</table>
		<br>
		<div style="padding-left:200px">
			<input type="submit" value="수정 완료" onclick="return chkSal()">
			<input type="reset" value="되돌리기" >
			<input type="button" value="돌아가기" onclick="history.go(-1)">
		</div>
		</form>
	</div>
</div>
</body>
</html>






























