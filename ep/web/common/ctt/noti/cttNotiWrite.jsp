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
	<form action="noti.do?cmd=noti_write" method="post" name="frm">
	<table class="list">
		<tr>
			<th class="ntith">작성일</th>
			<td>
				<jsp:useBean id="now" class="java.util.Date"/>
				<fmt:formatDate value="${now}" pattern="yyyy-MM-dd" var="today"/>
				<c:out value="${today}"/>
			</td>
			<th class="ntith">작성자</th>
			<td><input type="text" size="12" name="admnm" value="${ssAdmnm}" required>* 필수</td>
		</tr>
		<tr>
			<th>제 목</th>
			<td colspan="3"><input type="text" size="112" name="tit" required></td>
		</tr>
		<tr>
			<th>내 용</th>
			<td colspan="3"><textarea cols="114" rows="15" name="ctt" required></textarea></td>
		</tr>
	</table>
	<br>
	<div style="padding-left:400px">
		<input type ="submit" value="작성 완료">
		<input type="reset" value="다시 작성">
		<input type ="button" value="목록으로"	onclick="location.href='noti.do?cmd=admin_noti_list&pageNo=${pageNo}'">
	</div>
	</form>
</div>
</body>
</html>