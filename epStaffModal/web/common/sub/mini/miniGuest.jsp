<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
<link rel="stylesheet" type="text/css" href="../../../css/main.css">
</head>
<body>
	<div class="mini">
		<p>Member Login</p>
		<hr/>
		<form action="login.do" method="post" name="frm">
		<table id="logtab">
			<tr>
				<td><input type="text"  name="empid" class="idpw" placeholder="아이디" required></td>
				<td rowspan="2" id="logbtn"><input type="submit" class="login" value="LOGIN" onclick="return loginCheck()"></td>
			</tr>
			<tr>
				<td><input type="password"  name="pwd" class="idpw" placeholder="비밀번호" required></td>
			</tr>
			<tr>
				<td>
					<table>
						<tr>
							<td class="first">
								<p id="fst">처음 오셨나요?</p>
							</td>
						</tr>
					</table>
				</td>
				<td id="new">
					<input type="button" class="join" value="신규 등록" onclick="location.href='join.do'">
				</td>
			</tr>
			<tr>
				<td colspan="2" class="find">
					<p><a href="URL">ID/PW 찾기</a></p>
				</td>
			</tr>
		</table>
		</form>
	</div>
</body>
</html>