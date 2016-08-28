<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>상품 상세 페이지</title>
<link href="css/shopping.css" type="text/css" rel="stylesheet">
</head>
<body>
<div id="wrap" align="center">
<h1>상품 상세 페이지</h1>
<form method="get" name="frm" action="productList.do">
	<table>
	<tr>
		<td style="width:220px">
			<c:choose>
				<c:when test="${empty product.product_img}">
					<img src="upload/noimage.gif">
				</c:when>
				<c:otherwise>
					<img src="upload/${product.product_img}">
				</c:otherwise>
			</c:choose>
		</td>
		<td>
			<table>
				<tr>
					<th style="width:80px">상품명</th>
					<td>${product.name}</td>
				</tr>
				<tr>
					<th>가  격</th>
					<td>${product.price} 원</td>
				</tr>
				<tr>
					<th>설  명</th>
					<td><div style="width:80%; height:220px">${product.dsc}</div></td>
				</tr>
			</table>
		</td>
	</tr>	
	</table><br>
	<input type="submit" value="목록으로">
	<input type="button" value="수정하기" onclick="location.href='productUpdate.do?code=${product.code}'">
</form>
</div>
</body>
</html>