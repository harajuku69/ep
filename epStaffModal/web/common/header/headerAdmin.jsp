<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="../../../css/jquery-ui.min.css">
<link rel="stylesheet" type="text/css" href="../../../css/main.css">
<script src="../../../js/jquery-1.10.2.min.js"></script>
<script src="../../../js/jquery-ui.min.js"></script>
<script src="../../../js/form.js"></script>
</head>
<body>
<div class="header">
	<div class="hair">
		<div><a href="default.jsp">&nbsp;Mars EP</a></div>
		<div class="util">
			<table>
				<tr>
					<td><a href="index.jsp">Home</a></td>
					<td><a href="login.jsp">Login</a></td>
					<td><a href="URL">Join</a></td>
				</tr>
			</table>
		</div>
	</div>
	<div class="face">
		<div class="logo">
			<a href="login.do"><img src="../images/logo.png" alt="로고 이미지"></a>
		</div>
		<div id="accordion">
			<div>
				<table>
					<tr>
						<td style="width:200px; line-height:10px">개인정보</td>
						<td style="width:200px; line-height:10px">공지사항</td>
						<td style="width:200px; line-height:10px">프로젝트</td>
					</tr>
				</table>
			</div>
			<div>
				<table>
					<tr>
						<td style="width:200px; line-height:10px">개인정보</td>
						<td style="width:200px; line-height:10px">공지사항</td>
						<td style="width:200px; line-height:10px">프로젝트</td>
					</tr>
				</table>
			</div>
		<!-- <div id="accordion">
			<p class="accomenu"><a href="#">개인 정보</a></p>
			<div>
		        <ul class="accoul">
	              <li><a href="URL">개인 정보 상세</a></li>
	              <li><a href="URL">개인 정보 등록/수정/삭제</a></li>
		    	</ul>
			</div>
			<p class="accomenu"><a href="#">공지사항</a></p>
			<div>
		        <ul class="accoul">
	              <li><a href="URL">공지사항 목록</a></li>
	              <li><a href="URL">공지사항 등록/수정/삭제</a></li>
		    	</ul>
			</div>
			<p class="accomenu"><a href="#">프로젝트</a></p>
			<div>
		        <ul class="accoul">
	              <li><a href="URL">프로젝트 목록</a></li>
	              <li><a href="URL">프로젝트 등록/수정/삭제</a></li>
		    	</ul>
			</div>
		</div> -->
		</div>
		<div class="search">
		<form action="URL" method="get" name="frm">
			<table>
				<tr>
					<td>
						<input type="text" name="qry" id="qry" placeholder="이름을 입력하세요" required>
					</td>
					<td>
						<input type="submit" id="btn" value="검색" onclick="return function()">		
					</td>
				</tr>
			</table>
		</form>
		</div>
	</div>
</div>
</body>
</html>















