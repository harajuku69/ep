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
</head>
<body>
<div class="contents">
	<form action="noti.do?cmd=noti_update&notino=${reqNoti.notino}&pageNo=${pageNo}" method="post" name="frm">
	<table>
		<tr>
			<th>글 번호</th>
			<td>${reqNoti.notino}</td>
			<th>조회수</th>
			<td>${reqNoti.rdcnt}</td>
		</tr>
		<tr>
			<th>작성일</th>
			<%-- <td>${reqNoti.regdt}</td> --%>
			<td>
				<c:set var="regdt" value="${reqNoti.regdt}"/>
				<c:out value="${fn:substring(regdt,0,10)}"/>
			</td>
			<th>작성자</th>
			<%-- <td>${reqNoti.admnm}</td> --%>
			<td><input type="text" size="12" name="admnm" value="${reqNoti.admnm}" required>* 필수</td>
		</tr>
		<tr>
			<th>제목</th>
			<%-- <td colspan="3">${reqNoti.tit}</td> --%>
			<td colspan="3"><input type="text" size="70" name="tit" value="${reqNoti.tit}" required>* 필수</td>
		</tr>
		<tr>
			<th>내용</th>
			<%-- <td colspan="3"><pre>${reqNoti.ctt}</pre></td> --%>
			<td colspan="3"><textarea cols="70" rows="15" name="ctt" required>${reqNoti.ctt}</textarea></td>
		</tr>
	</table>
	<br><br>
	<%-- <input type="hidden" name="pageNo" value="${pageNo}"> --%>
	<input type ="submit" value="수정 완료">
	<input type="reset" value="되돌리기">
	<%-- <input type ="button" value="목록으로" 
		onclick="location.href='noti.do?cmd=admin_noti_list&pageNo=${pageNo}'"> --%>
	<!-- <input type ="button" value="목록으로" 
		onclick="location.href='noti.do?cmd=admin_noti_list'"> -->
	<input type ="button" value="돌아가기" 
		onclick="history.go(-1)">
	</form>
</div>
</body>
</html>