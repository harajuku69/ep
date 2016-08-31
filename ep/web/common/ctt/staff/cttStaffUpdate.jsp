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
</head>
<body>
<div class="contents">
	<div id="zip-dialog" title="Zipcode Search" >
		<p class="validateTips">동(읍/면) 이름을 입력하세요</p>
		<form id="frm">
			<input type="text" name="kwd" class="text ui-widget-content ui-corner-all" required><br>
			<!-- <input type="button" value="검 색" onclick="schzipcd()"> -->
			<input type="submit" tabindex="-1" style="position:absolute; left:-1000px">
		</form>
		<div id="zip-contain" class="ui-widget">
		<p>검색 결과</p>
		<table id="zipcdschRs" class="ui-widget ui-widget-content">
			<thead>
				<tr class="ui-widget-header">
					<th>우편번호</th>
					<th>시도</th>
					<th>구군</th>
					<th>동</th>
					<th>리</th>
					<th>빌딩</th>
					<th>번지</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="adrs" items="${addrList}">
				<tr>
					<td>"${adrs.no}"</td>
					<td>"${adrs.zipcd}"</td>
					<td>"${adrs.sido}"</td>
					<td>"${adrs.gugun}"</td>
					<td>"${adrs.dong}"</td>
					<td>"${adrs.ri}"</td>
					<td>"${adrs.bldg}"</td>
					<td>"${adrs.bunji}"</td>
					<td><button id="getaddr" onclick="getAddr(${adrs.no})">선 택</button></td>
				</tr> 
			</c:forEach>
			</tbody>
		</table>
		</div>
	</div>
	<div id="logleft">
	<form action="staff.do?cmd=staff_update" method="post" enctype="multipart/form-data" ><!-- name="frm"지움 -->
	<input type="hidden" name="noChangePic" value="${reqStaff.pic}">
		<c:choose>
			<c:when test="${empty reqStaff.pic}">
				<img class="stpic" src="images/noimage.gif">
			</c:when>
			<c:otherwise>
				<img class="stpic" src="upload/${reqStaff.pic}">
			</c:otherwise>
		</c:choose>
		<input type="file" name="pic" value="변경">
		<input type="button" name="delbtn" value="삭제">
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
					<input type="text" name="phone" id="phone" value="${reqStaff.phone}" >
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
					<input type="text" name="addrdtl" id="addrdtl" value="${reqStaff.addrdtl}" >
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
		<input type="submit" value="수정 완료" >
		<input type="reset" value="다시 작성" >
		<input type="button" value="수정 취소" onclick="location.href='staff.do?cmd=staff_detail_page'">
		</form>
	</div>
</div>
</script>
</body>
</html>






























