<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="js/contents.js"></script>
</head>
<body>
<div class="contents">
	<h1> 공지사항 목록 </h1>
	<div id="list-contain" class="ui-widget">
			<table class="list">
				<thead>
				<tr>
					<td class="addbtn" colspan="7" style="text-align:right; border:none;"><a href="pjt.do?cmd=pjt_insert_page"><button id="back">공지사항 등록</button></a></td>
				</tr>
				<tr class="ui-widget-header">
					<th>글 번호</th>
					<th>제 목</th>
					<th>등록일</th>
					<th>작성자</th>
					<th>조회수</th>
					<th>수정</th>
					<th>삭제</th>
				</tr>
				</thead>
				<tbody>
				</tbody>
				<c:forEach var="it" items="${notiList}">
					<tr class="${it.notino}">
						<td>${it.notino}</td>
						<td>
							<a href="notice.do?cmd=notice_detail&no=${it.notino}">${it.tit}</a>
						</td>
						<td>${it.regdt}</td>
						<td>${it.empid}</td>
						<td>${it.rdcnt}</td>
						<td><button id="update-list" onclick='updatelist(${it.notino});'>수정</button></td>
						<td><button id="delete-list" onclick='deletelist(${it.notino});'>삭제</button></td>
					</tr>
				</c:forEach>
			</table>
	</div>
	<br/>
	<!-- <button id="insert-list">공지사항 등록</button> -->
</div>
</body>
</html>