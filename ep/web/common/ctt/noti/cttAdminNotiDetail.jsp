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
</head>
<body>
<div class="contents">
	<table>
		<tr>
			<th>글 번호</th><td>${reqNoti.notino}</td>
			<th>조회수</th><td>${reqNoti.rdcnt}</td>
		</tr>
		<tr>
			<th>작성일</th>
			<td>
				<c:set var="regdt" value="${reqNoti.regdt}"/>
				<c:out value="${fn:substring(regdt,0,10)}"/>
			</td>
			<th>작성자</th><td>${reqNoti.admnm}</td>
		</tr>
		<tr>
			<th>제목</th><td colspan="3">${reqNoti.tit}</td>
		</tr>
		<tr>
			<th>내용</th><td colspan="3"><pre>${reqNoti.ctt}</pre></td>
		</tr>
	</table>
	<br>
	<%-- <input type="hidden" name="pageNo" value="${pageNo}"> --%>
	<input type ="button" value="수정하기" 
		onclick="location.href='noti.do?cmd=noti_update_page&notino=${reqNoti.notino}&pageNo=${pageNo}'">
	<input type ="button" value="목록으로" 
		onclick="location.href='noti.do?cmd=admin_noti_list&pageNo=${pageNo}'">
	<%-- <input type ="button" value="삭제하기" 
		onclick="noti.do?cmd=noti_delete&notino=${reqNoti.notino}&pageNo=${pageNo}"> --%>
	<hr>
	<div id="cmtarea">
		<div id="cmtinput">
			<form id="frm">
				<table>
					<tr>
						<td><p>댓 글</p></td>
						<td>
							<textarea cols="60" rows="1" name="" placeholder="댓글을 입력하세요." ></textarea>
						</td>
						<td><input type="password" placeholder="비밀번호(숫자 4자리)"></td>
						<td><input type="button" value="입 력" onclick="addcmt()"></td>
					</tr>
				</table>
			</form>
		</div>
		<hr>
		<div id="cmtlist">
			<table id="cmttab">
				<tbody>
				</tbody>
			</table>
		</div>
	</div>
</div>
</body>
</html>