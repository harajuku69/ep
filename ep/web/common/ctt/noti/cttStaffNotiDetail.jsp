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
<script src="js/comment.js"></script>
<script src="js/delete.js"></script>
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
	<input type ="button" value="목록으로" 
		onclick="location.href='noti.do?cmd=admin_noti_list&pageNo=${pageNo}'">
	<hr>
	<div id="cmtarea">
		<div id="cmtinput">
			<table>
				<tr>
					<td>
						<label for="ctt">댓글</label>
						<textarea cols="60" rows="1"  id="ctt" name="ctt" placeholder="댓글을 입력하세요." ></textarea>
						<input type="hidden" id="notino" name="notino" value="${reqNoti.notino}">
					</td>
					<td><input type="password" id="pwd" name="pwd" placeholder="비밀번호(숫자 4자리)"></td>
					<td>
						<input type="button" value="입 력" onclick="addCmt()">
					</td>
				</tr>
			</table>
		</div>
		<hr>
		<div id="cmtlist">
			<table>
				<tbody>
				<c:forEach var="cmt" items="${reqCmtList}">
					<tr class="${cmt.cmtno}">
						<td>${cmt.cmtno}</td>
						<td>${cmt.admnm}</td>
						<td>${cmt.ctt}</td>
						<td>${cmt.regdt}</td>
						<td><a href="#" onClick="deleteItem('cmt', '${cmt.cmtno}')">삭 제</a></td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
		<div id="paging" style="text-align:center; font-size:20px; padding:1em">
    		<span>
    			<c:if test="${blockNo > 1}">
    				<span><a href="noti.do?cmd=admin_noti_detail_page&cmtPageNo=${prevPageNo}&notino=${reqNoti.notino}&pageNo=${pageNo}">&laquo;이전 페이지</a></span>
    			</c:if>
        		<c:choose>
        		<c:when test="${blockNo < totBlock }">
	        		<c:forEach var="i" begin="${firstPageNoInBlock}" end="${lastPageNoInBlock}" step="1">
	            		<c:choose>
	                		<c:when test="${i eq cmtPageNo}"><span>${i}</span></c:when>
	                		<c:otherwise><a href="noti.do?cmd=admin_noti_detail_page&cmtPageNo=${i}&notino=${reqNoti.notino}&pageNo=${pageNo}">${i}</a></c:otherwise>
	            		</c:choose>
	        		</c:forEach>
	        	</c:when>
	        	<c:otherwise>
	        		<c:forEach var="i" begin="${firstPageNoInBlock}" end="${totPage}" step="1">
	            		<c:choose>
	                		<c:when test="${i eq cmtPageNo}"><span>${i}</span></c:when>
	                		<c:otherwise><a href="noti.do?cmd=admin_noti_detail_page&cmtPageNo=${i}&notino=${reqNoti.notino}&pageNo=${pageNo}">${i}</a></c:otherwise>
	            		</c:choose>
	        		</c:forEach>
	        	</c:otherwise>
        		</c:choose>
        		<c:if test="${blockNo < totBlock}">
    				<span><a href="noti.do?cmd=admin_noti_detail_page&cmtPageNo=${nextPageNo}&notino=${reqNoti.notino}&pageNo=${pageNo}">다음 페이지&raquo;</a></span>
    			</c:if>
    		</span>
		</div>
	</div>
</div>
</body>
</html>



































