<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 중복 확인</title>
<script src="js/join.js"></script>
</head>
<body>
<h2>아이디 중복 확인</h2>
<form action="staff.do?cmd=chk_id" name="frm">
	아이디<input type="text" name="empid" value="${empid}">
	<input type="submit" value="중복 검사">
	<br><br>
	<c:if test="${result == 1}">
		<script type="text/javascript">
			opener.document.frm.userid.value="";
		</script>
		${empid}는 이미 사용 중 입니다. 
	</c:if>
	<c:if test="${result == 0}">
		${empid}는 사용 가능합니다.
		<input type="button" value="사용" onclick="idok()">
	</c:if>
</form>
</body>
</html>