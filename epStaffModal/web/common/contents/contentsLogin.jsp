<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="../css/main.css">
<script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</head>
<body>
<div class="contents">
	<div id="logleft">
		<ul>
			<li><p><img src="../images/member.png" alt="member"></p><hr/></li>
			<li><a href="URL">로그인</a></li><hr/>
			<li><a href="URL">신규 등록</a></li><hr/>
			<li><a href="URL">아이디/비밀번호 찾기</a></li><hr/>			
		</ul>
	</div>
	<div id="logright">
		<div id="logintro">
			<table id="introtable">
				<tr>
					<td id="desc" >
						<h1>로그인</h1>
						<h5>mars의 로그인 페이지입니다.</h5>
						<p>일반 : 사원 정보, 공지사항, 프로젝트 검색을 이용하실 수 있습니다.</p>
						<p>관리자 : 사원 정보, 공지사항, 프로젝트 등록/수정/삭제를 할 수 있습니다. </p>
					</td>
					<td id="lock">
						<p><img src="../images/lock_01.png" alt="locker img"></p>
					</td>
				</tr>
			</table>
		</div>
		<div id="logmain">
		<form action="URL" method="post" name="frm">
			<table id="maintable">
				<tr>
					<td rowspan="3" id="mainleft">LOGIN</td>
					<td id="maincenter"><input type="text"  name="empid" class="idpw" placeholder="아이디" required></td>
					<td rowspan="2" id="mainright"><input type="submit" value="LOGIN" class="login" onclick="return loginCheck()"></td>
				</tr>
				<tr>
					<td id="maincenter"><input type="password" name="pwd" class="idpw" placeholder="비밀번호" required></td>
				</tr>
				<tr>
					<td id="maincenter"><input type="button" value="아이디/비밀번호 찾기" class="find" onclick="location.href='URL'"></td>
					<td id="mainright"><input type="button" value="신규 등록" class="join" onclick="location.href='URL'"></td>
				</tr>
			</table>
		</form>
		</div>
	</div>
</div>
</body>
</html>