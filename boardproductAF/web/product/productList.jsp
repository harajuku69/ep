<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/shopping.css">
</head>
<body>
<div id="wrap" align="center">
<h1>상품 리스트 - 관리자 페이지</h1>
<table class="list">
	<tr>
		<td colspan="6" style="border:white; text-align:right; font-size:14px;">
			<a href="productWrite.do">상품 등록</a>
		</td>
	</tr>
	<tr><th>번 호</th><th>이 름</th><th>가 격</th><th>간략 내용</th><th>수 정</th><th>삭 제</th></tr>
	
	<c:forEach var="product" items="${productList}">
	<tr class="record">
		<td style="text-align:center">${product.code}</td>
		<td style="text-align:center"><a href="productDetail.do?code=${product.code}">${product.name}</a></td>
		<td style="text-align:center">${product.price}원</td>
		<td style="text-align:center">${product.dsc}</td>
		<td style="text-align:center"><a href="productUpdate.do?code=${product.code}">상품 수정</a></td>
		<td style="text-align:center"><a href="productDelete.do?code=${product.code}">상품 삭제</a></td>
	</tr>
	</c:forEach>
</table>
</div>
</body>
</html>