<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="js/ajaxModal.js"></script>
</head>
<body>
<div class="contents">
	<h1> 프로젝트 목록 </h1>
	<div id="list-contain" class="ui-widget">
			<table class="list">
				<!-- <tr>
					<td colspan="6" style="border:white; text-align:right">
						<a href="pjt.do?cmd=pjt_insert_form">프로젝트 등록</a>
					</td>
				</tr> -->
				<thead>
				<tr class="ui-widget-header">
					<th>번호</th>
					<th>프로젝트명</th>
					<th>시작일</th>
					<th>종료일</th>
					<th>등록일</th>
					<th>작성자</th>
					<th>수정</th>
					<th>삭제</th>
				</tr>
				<thead>
				<tbody>
				</tbody>
				<c:forEach var="it" items="${pjtList}">
					<tr class="${it.pjtno}">
						<td>${it.pjtno}</td>
						<td>
							<a href="pjt.do?cmd=pjt_detail&no=${it.pjtno}">${it.pjtnm}</a>
						</td>
						<td>${it.startdt}</td>
						<td>${it.enddt}</td>
						<td>${it.regdt}</td>
						<td>${it.reguser}</td>
						<td><button id="update-list" onclick='deletelist(${it.pjtno});'>수정</button></td>
						<td><button id="delete-list" onclick='deletelist(${it.pjtno});'>삭제</button></td>
					</tr>
				</c:forEach>
			</table>
	</div>
	<br/>
	<button id="insert-list">프로젝트 등록</button>
</div>
</body>
</html>