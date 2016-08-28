<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Index Page</title>
<link rel="stylesheet" type="text/css" href="css/shopping.css">
</head>
<body>
<div id="wrap" align="center">
<p style="font-size:30px; color:#3f4f7f; font-weight:bold">홈페이지</p>
<table class="list">
	<tr>
		<td colspan="4" style="border:white; text-align:center; font-size:20px;">
			<a href="BoardServlet.do">상품 정보 페이지로 이동</a>
		</td>
	</tr>
	<tr><th class="index_th">번 호</th><th class="index_th">이 름</th><th class="index_th">가 격</th><th class="index_th">간략 내용</th>
	
	<c:forEach var="product" items="${productList}">
	<tr class="record">
		<td>상품 번호</td>
		<td>책 이름</td>
		<td>가 격</td>
		<td>설 명</td>
	</tr>
	</c:forEach>
</table>
</div>
</body>
</html>