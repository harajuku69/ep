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
					<div style="width:200px;">${reqStaff.addrdtl}</div>
					<%-- ${reqStaff.addrdtl} --%>
				</td>
			</tr>
		</table>
		<form action="staff.do?cmd=admin_update&empid=${reqStaff.empid}" method="post" name="frm">
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
				<td>직 급</td>
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
				<td>입사일</td>
				<td><input type="text" name="startdt" id="startdt" value="${fn:substring(reqStaff.startdt, 0, 10)}"></td>
			</tr>
			<tr>
				<td>퇴사일</td>
				<td><input type="text" name="enddt" id="enddt" value="${fn:substring(reqStaff.enddt, 0, 10)}"></td>
			</tr>
			<tr>
				<td>급 여</td>
				<td>
					<%-- <fmt:formatNumber type="currency" value="${reqStaff.sal}"/> --%>
					<input type="text" name="sal" id="sal" value="${reqStaff.sal}">
				</td>
			</tr>
			<tr>
				<td>등록일</td>
				<td>
					<%-- <input type="text" name="regdt" value="${reqStaff.regdt}" readonly> --%>
					${fn:substring(reqStaff.regdt, 0, 10)}
				</td>
			</tr>
			<tr>
				<td>권 한</td>
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
		<input type="submit" value="수정 완료" >
		<input type="reset" value="되돌리기" >
		<input type="button" value="돌아가기" onclick="location.href='staff.do?cmd=admin_detail_page&empid=${reqStaff.empid}'">
		</form>
	</div>
</div>
</body>
</html>






























