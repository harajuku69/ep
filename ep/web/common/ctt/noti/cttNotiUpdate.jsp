<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<div class="contents">
	<div id="list-contain" class="ui-widget">
		<form action="noti.do?cmd=noti_update&notino=${reqNoti.notino}&pageNo=${pageNo}" method="post" name="frm">
		<table class="list">
			<tr>
				<th class="ntith">글 번호</th>	<td>${reqNoti.notino}</td>
				<th class="ntith">조회수</th><td>${reqNoti.rdcnt}</td>
			</tr>
			<tr>
				<th>수정일</th>
				<td>
					<jsp:useBean id="now" class="java.util.Date"/>
					<fmt:formatDate value="${now}" pattern="yyyy-MM-dd" var="today"/>
					<c:out value="${today}"/>
				</td>
				<th>작성자</th>
				<td><input type="text" size="12" name="admnm" value="${reqNoti.admnm}" required>* 필수</td>
			</tr>
			<tr>
				<th>제 목</th>
				<td colspan="3"><input type="text" size="112" name="tit" value="${reqNoti.tit}" required></td>
			</tr>
			<tr>
				<th>내 용</th>
				<td colspan="3"><textarea cols="114" rows="15" name="ctt" required>${reqNoti.ctt}</textarea></td>
			</tr>
		</table>
		<br>
		<div style="padding-left:400px">
			<input type ="submit" value="수정 완료">
			<input type="reset" value="되돌리기">
			<input type ="button" value="돌아가기" onclick="history.go(-1)">
		</div>
		</form>
	</div>
</div>
</body>
</html>