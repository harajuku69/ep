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
</head>
<body>
<div class="contents">
	<table>
		<tr>
			<th>글 번호</th><td>${reqNoti.notino}</td>
			<th>조회수</th><td>${reqNoti.rdcnt}</td>
		</tr>
		<tr>
			<th>작성일</th><td><fmt:formatDate value="${reqNoti.regdt}"/></td>
			<th>작성자</th><td>${reqNoti.admnm}</td>
		</tr>
		<tr>
			<th>제목</th><td colspan="3">${reqNoti.tit}</td>
		</tr>
		<tr>
			<th>내용</th><td colspan="3"><pre>${reqNoti.ctt}</pre></td>
		</tr>
	</table>
	<br><br>
	<%-- <input type="hidden" name="pageNo" value="${pageNo}"> --%>
	<input type ="button" value="수정하기" 
		onclick="location.href='noti.do?cmd=noti_update_page&notino=${reqNoti.notino}&pageNo=${pageNo}'">
	<input type ="button" value="목록으로" 
		onclick="location.href='noti.do?cmd=admin_noti_list&pageNo=${pageNo}'">
	<%-- <input type ="button" value="삭제하기" 
		onclick="noti.do?cmd=noti_delete&notino=${reqNoti.notino}&pageNo=${pageNo}"> --%>
</div>
</body>
</html>