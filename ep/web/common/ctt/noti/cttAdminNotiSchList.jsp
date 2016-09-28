<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="js/delete.js"></script>
</head>
<body>
<div class="contents">
	<h1> 공지사항 검색 결과 </h1>
	<div id="list_contain" class="ui-widget">
		<table class="list" class="ui-widget ui-widget-content">
			<thead>
			<tr>
				<td class="addbtn" colspan="7" style="text-align:right; border:none;"><a href="noti.do?cmd=noti_write_page"><button id="write">공지사항 등록</button></a></td>
			</tr>
			<tr class="ui-widget-header">
				<th>글 번호</th>
				<th>제 목</th>
				<th>조회수</th>
				<!-- <th>댓글수</th> -->
				<th>등록일</th>
				<th>작성자</th>
				<th>수정</th>
				<th>삭제</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach var="item" items="${reqNotiList}">
				<tr class="${item.notino}">
					<td class="tit">${item.notino}</td>
					<td id="ltit">
						<c:choose>
							<c:when test="${item.cmtcnt > 0}">
								<a href="noti.do?cmd=admin_noti_detail_page&notino=${item.notino}">${item.tit} &nbsp;[${item.cmtcnt}]</a>
							</c:when>
							<c:otherwise>
								<a href="noti.do?cmd=admin_noti_detail_page&notino=${item.notino}">${item.tit}</a>
							</c:otherwise>
						</c:choose>
					</td>
					<td class="tit">${item.rdcnt}</td>
					<%-- <td>${item.cmtcnt}</td> --%>
					<td class="tit">
						<c:set var="regdt" value="${item.regdt}"/>
						<c:out value="${fn:substring(regdt,0,10)}"/>
					</td>
					<td class="tit">${item.admnm}</td>
					<td class="tit"><a href="noti.do?cmd=noti_update_page&notino=${item.notino}">수 정</a></td>
					<td class="tit"><a href="#" onClick="deleteItem('noti','${item.notino}')">삭 제</a></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
	<br/>
</div>
</body>
</html>






























