<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="js/join.js"></script>
<script src="js/checkdup.js"></script>
</head>
<body>
<div class="contents">
	<div id="id-dialog" title="아이디 중복 검사">
		<p class="validateTips">아이디 중복 검사가 필요합니다.</p>
		<fieldset>
			<form id="frm_id">
				<label for="id">아이디를 입력해주세요.</label><br>
				<input type="text" name="idchk" id="idchk" placeholder="아이디" class="text ui-widget-content ui-corner-all"  ><br>
			</form>
		</fieldset>
		<p id="idChkRs"></p>
	</div> 
	<form action="staff.do?cmd=join" method="post" name="frm">
	<div id="logleft">
		<ul>
			<li><p><img src="images/member.png" alt="member"></p><hr/></li>
			<li><a href="staff.do?cmd=login_page">로그인</a><hr></li>
			<li>신규 등록<hr></li>
			<li><a href="staff.do?cmd=idpw_find">아이디/비밀번호 찾기</a><hr></li>			
		</ul>
	</div>
	<div id="logright">
		<div id="logintro">
			<table id="introtable">
				<tr>
					<td id="desc" >
						<h1>회원 가입</h1>
						<h5>mars의 회원가입 페이지입니다.</h5>
						<p> 본인은 mars 사용 약관에 동의 합니다. (*필수) &nbsp;
							<input type="radio" name="agree" id="agree" value="1" style="display:inline" required><label for="agree" style="display:inline"> YES</label>
							<!-- <label for="no" style="display:inline">NO</label><input type="radio" name="confirm" id="no" value="01" > -->
						</p>					
					</td>
					<td id="lock">
						<p><img src="images/join_01.png" alt="join_img"></p>
					</td>
				</tr>
			</table>
		</div>
		<div id="logmain">
		<!-- <form action="staff.do?cmd=join" method="post" name="frm"> -->
			<table id="maintable">
				<!-- <tr>
					<td colspan="3" id="notify"><p></p></td>
				</tr> -->
				<tr>
					<td class="mainleft">이름</td>
					<td class="maincenter"><input type="text" name="name" id="name" maxlength="15" placeholder="이름"></td>
					<td id="alarm" class="checktd"></td>
				</tr>
				<tr>
					<td class="mainleft">주민번호</td>
					<td class="maincenter">
						<input type="text" name="juminf" id="juminf" maxlength="6" placeholder="생년월일  6자리.ex) 901225"  >
						<input type="password" name="juminb" id="juminb" maxlength="7" placeholder="뒷자리  7자리"  >
					</td>
					<td class="checktd"><input type="button" name="chkjumin" value="중복 체크" onclick="chkJumin()"></td>
				</tr>
				<tr>
					<td class="mainleft">아이디</td>
					<td class="maincenter">
						<input type="text" name="empid" placeholder="아이디" >
					</td>
					<td class="checktd"><input type="button" name="chkid" id="chkid" value="중복 체크" ></td>
				</tr>
				<tr>
					<td rowspan="2" class="mainleft">비밀번호</td>
					<td  class="maincenter"><input type="password" name="pwd" id="pwd" placeholder="비밀번호"></td>
					<td rowspan="2"  id="same" class="checktd"></td>
				</tr>
				<tr>
					<td class="maincenter"><input type="password" name="pwd_re" id="pwd_re" placeholder="재입력"></td>
				</tr>
				<tr>
					<td class="mainleft"><input type="submit" value="작성 완료" onclick="return chkJoin()"></td>
					<td class="maincenter"><input type="reset" value="다시 작성"></td>
					<td class="checktd"><input type="button" value="돌아가기" onclick="location.href='staff.do?cmd=login_page'"></td>
				</tr>
			</table>
		<p>${msg}</p>
		</div>
	</div>
	</form>
</div>
</body>
</html>