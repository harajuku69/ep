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
<script src="js/zipcd.js"></script>
<script src="js/imgchange.js"></script>
<script src="js/checkUpdate.js"></script>
</head>
<body>
<div class="contents">
	<div id="zip-dialog" title="Zipcode Search" >
		<h2>주소 검색</h2>
		<p class="validateTips">한글과 숫자로 공백없이 입력하세요. ex)청천2동 or 압구정</p>
		<form>
			<input type="text" name="kwd" id="kwd" class="text ui-widget-content ui-corner-all" placeholder="동(읍/면) 이름을 입력하세요"><br>
			<!-- <input type="button" value="검 색" onclick="schzipcd()"> -->
			<input type="submit" tabindex="-1" style="position:absolute; left:-1000px">
		</form>
		<p> &nbsp;&nbsp;검색 결과</p>
		<div class="containzip" class="ui-widget">
		<table id="ZipcdSearchResult" class="ui-widget ui-widget-content">
			<thead>
				<tr class="ui-widget-header">
					<th>우편번호</th>
					<th>시/도</th>
					<th>구/군</th>
					<th>동(읍/면)</th>
					<th>번지</th>
					<th>선택</th>
				</tr>
			</thead>
			<tbody>
			</tbody>
		</table>
		</div>
	</div>
	<form action="staff.do?cmd=staff_update" method="post" enctype="multipart/form-data" ><!-- name="frm"지움 -->
	<div id="logleft">
	<input type="hidden" name="noChangePic" value="${reqStaff.pic}">
		<c:choose>
			<c:when test="${empty reqStaff.pic}">
				<img class="stpic" id="stpic" src="images/noimage.gif">
			</c:when>
			<c:otherwise>
				<img class="stpic" id="stpic" src="upload/${reqStaff.pic}">
			</c:otherwise>
		</c:choose>
		<input type="file" name="pic" id="pic">
		<!-- <input type="button" name="delbtn" value="삭제"> -->
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
					<input type="text" name="phone" id="phone" maxlength="11" value="${reqStaff.phone}" >
				</td>
			</tr>
			<tr>
				<td>우편번호</td>
				<td>
					<input type="text" name="zipcd" id="zipcd" value="${reqStaff.zipcd}" readonly>
					<!-- <input type="button" name="zipcdschbtn" value="검색" onclick="zipcdsch();"> -->
					<input type="button" name="zipcdschbtn" id="zipcdschbtn" value="검색" >
				</td>
			</tr>
			<tr>
				<td>기본주소</td>
				<td>
					<input type="text" name="addr" id="addr" value="${reqStaff.addr}" readonly>
				</td>
			</tr>
			<tr>
				<td>상세주소</td>
				<td>
					<%-- <input type="text" name="addrdtl" id="addrdtl" value="${reqStaff.addrdtl}" > --%>
					<textarea rows="3" cols="22" name="addrdtl" id="addrdtl" >${reqStaff.addrdtl}</textarea>
				</td>
			</tr>
		</table>
		<table style="font-size:20px;">
			<tr><th colspan="2">사원 정보</th></tr>
			<tr>
				<td>사 번</td>
				<td>
					<%-- <input type="text" name="empno" id="empno" value="${reqStaff.empno}" readonly> --%>
					${reqStaff.empno}
				</td>
			</tr>
			<tr>
				<td>사 원 아이디</td>
				<td>${reqStaff.empid}</td>
			</tr>
			<tr>
				<td>부 서</td>
				<td>
					<%-- <input type="text" name="dpt" id="dpt" value="${reqStaff.dptcd}" readonly> --%>
					${reqStaff.dptcd}
				</td>
			</tr>
			<tr>
				<td>직 급</td>
				<td>
					<%-- <input type="text" name="tit" id="tit" value="${reqStaff.titcd}" readonly> --%>
					${reqStaff.titcd}
				</td>
			</tr>
			<tr>
				<td>입사일</td>
				<td>
					<%-- <input type="text" name="startdt" value="${reqStaff.startdt}" readonly> --%>
					${reqStaff.startdt}
				</td>
			</tr>
			<tr>
				<td>퇴사일</td>
				<td>
					<%-- <input type="text" name="enddt" value="${reqStaff.enddt}" readonly> --%>
					${reqStaff.enddt}
				</td>
			</tr>
			<tr>
				<td>급 여</td>
				<td>
					<fmt:formatNumber value="${reqStaff.sal}" type="currency"/>
				</td>
			</tr>
			<tr>
				<td>등록일</td>
				<td>
					<%-- <input type="text" name="regdt" value="${reqStaff.regdt}" readonly> --%>
					${reqStaff.regdt}
				</td>
			</tr>
		</table>
		<br>
		<div style="clear:both">
			<p><input type="submit" value="수정 완료" onclick="return chkPhone()"></p>
			<p><input type="reset" value="되돌리기" ></p>
			<p><input type="button" value="돌아가기" onclick="location.href='staff.do?cmd=staff_detail_page&empid=${reqStaff.empid}'"></p>
		</div>
	</div>
	</form>
</div>
<!-- </script> -->
</body>
</html>






























