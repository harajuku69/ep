<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
<head>
<meta charset="utf-8">
<title>jQuery UI Dialog -Modal confirmation</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<link rel="stylesheet" href="../css/style.css">
<script src="../js/dialog.js"></script>
</head>
<body>
<div id="dialog-form" title="신규 등록">
	<p class="validateTips">모든 필드가 입력되어야 합니다.</p>
	<form>
	<fieldset>
		<label for="name">이름</label>
		<input type="text" name="name" id="name" value="홍길동" class="text ui-widget-content ui-corner-all">
		<label for="email">이메일</label>
		<input type="text" name="email" id="email" value="hong@naver.com" class="text ui-widget-content ui-corner-all">
		<label for="password">비밀번호</label>
		<input type="password" name="password" id="password" value="xxxxxx" class="text ui-widget-content ui-corner-all">
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
			<th>이름</th>
			<th>이메일</th>
			<th>비밀번호</th>
		</tr>
		</thead>
		<tbody>
			<tr>
				<td>정일대</td>
				<td>ildae.jung@example.com</td>
				<td>123456</td>
			</tr>
		</tbody>
	</table>
</div>
<button id="create-user">회원등록</button>
</body>
</html>