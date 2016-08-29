<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript" src="js/join.js"></script>
</head>
<body>
<div class="contents">
	<div id="logleft">
		<ul>
			<li><p><img src="../images/member.png" alt="member"></p><hr/></li>
			<li><a href="staff.do?cmd=login_page">로그인</a></li><hr/>
			<li>신규 등록</li><hr/>
			<li><a href="staff.do?cmd=idpw_find">아이디/비밀번호 찾기</a></li><hr/>			
		</ul>
	</div>
	<div id="logright">
		<div id="logintro">
			<table id="introtable">
				<tr>
					<td id="desc" >
						<h1>회원 가입</h1>
						<h5>mars의 회원가입 페이지입니다.</h5>
						<p>본인은 mars 사용 약관에 동의 합니다.</p>
						<label for="yes" style="display:inline">YES</label><input type="radio" name="confirm" id="yes" value="00" required>
						<!-- <label for="no" style="display:inline">NO</label><input type="radio" name="confirm" id="no" value="01" > -->					
					</td>
					<td id="lock">
						<p><img src="images/join_01.png" alt="join img"></p>
					</td>
				</tr>
			</table>
		</div>
		<div id="logmain">
		<form action="staff.do?cmd=join" method="post" name="frm">
			<table id="maintable">
				<tr>
					<td colspan="3">모든 필드가 입력되어야 합니다.</td>
				</tr>
				<tr>
					<td id="maincenter">이름</td>
					<td><input type="text" name="empnm" required></td>
					<td></td>
				</tr>
				<tr>
					<td>주민번호</td>
					<td>
						<input type="text" name="juminf" placeholder="생년월일  6자리.ex) 901225" required>
						<input type="password" name="juminb" placeholder="뒷자리  7자리" required>
					</td>
					<td><input type="button" name="chkjumin" value="중복 체크" onclick="chkJumin()"></td>
				</tr>
				<tr>
					<td id="maincenter">아이디</td>
					<td>
						<input type="text" name="empid" required>
						<input type="hidden" name="reid">
					</td>
					<td><input type="button" name="chkid" value="중복 체크" onclick="chkId()"></td>
				</tr>
				<tr>
					<td id="maincenter" rowspan="2">비밀번호</td>
					<td ><input type="password" name="pwd" required></td>
					<td></td>
				</tr>
				<tr>
					<td><input type="password" placeholder="재입력" name="pwd_chk" required></td>
					<td>비밀번호가 일치합니다</td>
				</tr>
				<tr>
					<td><input type="submit" value="작성 완료" onclick="return chkJoin()"></td>
					<td><input type="reset" value="다시 작성"></td>
					<td><input type="button" value="취소" onclick="location.href='staff.do?cmd=login_page'"></td>
				</tr>
			</table>
		</form>
		<p>${msg}</p>
		</div>
	</div>
</div>
</body>
</html>