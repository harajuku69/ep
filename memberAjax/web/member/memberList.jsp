<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html lang="ko">
<head>
<meta charset="utf-8">
<title>jQuery UI Dialog -Modal confirmation</title>
<link rel="stylesheet" href="css/jquery-ui.min.css">
<link rel="stylesheet" href="css/style.css">
<script src="js/jquery-1.10.2.min.js"></script>
<script src="js/jquery-ui.min.js"></script>
<script src="js/member.js"></script>
</head>
<body>
<div id="dialog-form" title="신규 등록">
	<p class="validateTips">모든 필드가 입력되어야 합니다.</p>
	<form id="frm">
	<!-- <input type="hidden" name="command" value="MemberInsertAction"> --> 
	<fieldset>
		<label for="memnm">이름</label>
		<input type="text" name="memnm" id="memnm" value="정일대" class="text ui-widget-content ui-corner-all">
		<label for="mememail">이메일</label>
		<input type="text" name="mememail" id="mememail" value="ildae.jung@naver.com" class="text ui-widget-content ui-corner-all">
		<label for="mempwd">비밀번호</label>
		<input type="password" name="mempwd" id="mempwd" value="111111" class="text ui-widget-content ui-corner-all">
		<!--Allow form submission with keyboard without duplicating the dialog button -->
		<input type="submit" tabindex="-1" style="position:absolute; top:-1000px">  
	</fieldset>
	</form>
</div>
<div id="users-contain" class="ui-widget">
	<h1>회원 리스트:</h1>
	<table id="users" class="ui-widget ui-widget-content">
		<thead>
		<tr class="ui-widget-header ">
			<th>No.</th>
			<th>이름</th>
			<th>이메일</th>
			<th>비밀번호</th>
			<th>삭제</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach var="mem" items="${memberList}">
			<tr class="${mem.no}">
				<td>${mem.no}</td>
				<td>${mem.memnm}</td>
				<td>${mem.mememail}</td>
				<td>${mem.mempwd}</td>
				<td width="50px"><button id="delete-user" onclick='deleteUser(${mem.no});'>삭제</button></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</div>
<button id="create-user">회원 등록</button>
</body>
</html>