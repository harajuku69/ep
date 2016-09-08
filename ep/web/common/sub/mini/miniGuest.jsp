<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
	<div class="mini">
		<p style="display:inline;">Member Login</p>
		<hr/>
		<form action="staff.do?cmd=login" method="post" name="frm" id="frm">
		<table id="logtab">
			<tr>
				<td><input type="text"  name="empid" id="empid" placeholder="아이디" value="${empid}" required></td>
				<td rowspan="2" id="logbtn">
					<input type="submit" id="login" value="LOGIN" >
				</td>
			</tr>
			<tr>
				<td><input type="password"  name="pwd" id="pwd" placeholder="비밀번호" required></td>
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
					<input type="button" class="join" value="신규 등록" onclick="location.href='staff.do?cmd=join_page'">
				</td>
			</tr>
			<tr>
				<td colspan="2" class="find">
					<p><a href="location.href='staff.do?cmd=staff_find">ID/PW 찾기</a></p>
				</td>
			</tr>
		</table>
		</form>
	</div>
</body>
</html>