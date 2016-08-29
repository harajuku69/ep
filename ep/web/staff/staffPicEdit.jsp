<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Picture Change</title>
</head>
<body>
<h2>아이디 중복 확인</h2>
<form action="idCheck.do" method="get" name="frm">
	아이디<input type="text" name="userid" value="${userid}">
	<input type="submit" value="중복 검사">
	<br><br>
	<c:if test="${result == 1}">
		<script type="text/javascript">
			//회원가입의 ID중복체크 란을 공백으로 만드는것
			//아래에서 opener.document와 opener는 동일함.
			opener.document.frm.userid.value="";
		</script>
		${userid}는 이미 사용 중 입니다. 
	</c:if>
	<c:if test="${result == -1}">
		<!-- <script type="text/javascript">
			opener.document.frm.userid.value="${userid}";
		</script> -->
			${userid}는 사용 가능합니다.
		<input type="button" value="사용" class="cancel" onclick="idok()">
	</c:if>
</form>
</body>
</html>