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
	<div id="pwd-dialog" title="비밀번호 확인">
		<p class="validateTips">본인 확인이 필요합니다.</p>
		<fieldset>
			<form id="frm">
				<label for="pwd">비밀번호를 입력해주세요.</label><br>
				<input type="password" name="pwd" id="pwd" placeholder="비밀번호" class="text ui-widget-content ui-corner-all"  ><br>
		</form>
		</fieldset>
		<p id="pwdChkRs"></p>
	</div> 
	<div id="list-contain" class="ui-widget">
		<div id="noti_dtl_area">
			<table class="list">
				<tr class="ui-widget-header">
					<th>글 번호</th><td>${reqNoti.notino}</td>
					<th>조회수</th><td>${reqNoti.rdcnt}</td>
				</tr>
				<tr class="ui-widget-header">
					<th>작성일</th>
					<td>
						<c:set var="regdt" value="${reqNoti.regdt}"/>
						<c:out value="${fn:substring(regdt,0,10)}"/>
					</td>
					<th>작성자</th><td>${reqNoti.admnm}</td>
				</tr>
				<tr class="ui-widget-header">
					<th>제목</th><td colspan="3">${reqNoti.tit}</td>
				</tr>
				<tr class="ui-widget-header">
					<th>내용</th><td colspan="3"><pre>${reqNoti.ctt}</pre></td>
				</tr>
			</table>
		</div>
		<br>
		<input type ="button" value="목록으로" 
			onclick="location.href='noti.do?cmd=staff_noti_list&pageNo=${pageNo}'">
		<hr>
		<div id="cmtarea">
			<div id="cmtinput" class="ui-widget">
				<table class="list">
					<tr class="ui-widget-header">
						<td>
							<label for="ctt" style="display:inline">댓글</label>
							<textarea cols="80" rows="1"  id="ctt" name="ctt" placeholder="댓글을 입력하세요." ></textarea>
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
			<div id="cmtlist" class="ui-widget">
				<table class="list">
					<tbody>
					<c:forEach var="cmt" items="${reqCmtList}">
						<tr class="${cmt.cmtno}" class="ui-widget-header">
							<td>${cmt.rpno}</td>
							<td>${cmt.admnm}</td>
							<td>${cmt.ctt}</td>
							<td>${cmt.regdt}</td>
							<c:if test="${cmt.regid == ssEmpid}">
							<%-- <td><a href="#" onClick="deleteItem('cmt', '${cmt.cmtno}')">삭 제</a></td> --%>
							<td><input type="button" id="chk_pwd" value="삭제"></td>
							</c:if>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
			<div id="paging" style="text-align:center; font-size:20px; padding:1em">
	    		<span>
	    			<c:if test="${blockNo > 1}">
	    				<span><a href="noti.do?cmd=staff_noti_detail_page&cmtPageNo=${prevPageNo}&notino=${reqNoti.notino}&pageNo=${pageNo}">&laquo;이전 페이지</a></span>
	    			</c:if>
	        		<c:choose>
	        		<c:when test="${blockNo < totBlock }">
		        		<c:forEach var="i" begin="${firstPageNoInBlock}" end="${lastPageNoInBlock}" step="1">
		            		<c:choose>
		                		<c:when test="${i eq cmtPageNo}"><span>${i}</span></c:when>
		                		<c:otherwise><a href="noti.do?cmd=staff_noti_detail_page&cmtPageNo=${i}&notino=${reqNoti.notino}&pageNo=${pageNo}">${i}</a></c:otherwise>
		            		</c:choose>
		        		</c:forEach>
		        	</c:when>
		        	<c:otherwise>
		        		<c:forEach var="i" begin="${firstPageNoInBlock}" end="${totPage}" step="1">
		            		<c:choose>
		                		<c:when test="${i eq cmtPageNo}"><span>${i}</span></c:when>
		                		<c:otherwise><a href="noti.do?cmd=staff_noti_detail_page&cmtPageNo=${i}&notino=${reqNoti.notino}&pageNo=${pageNo}">${i}</a></c:otherwise>
		            		</c:choose>
		        		</c:forEach>
		        	</c:otherwise>
	        		</c:choose>
	        		<c:if test="${blockNo < totBlock}">
	    				<span><a href="noti.do?cmd=staff_noti_detail_page&cmtPageNo=${nextPageNo}&notino=${reqNoti.notino}&pageNo=${pageNo}">다음 페이지&raquo;</a></span>
	    			</c:if>
	    		</span>
			</div>
		</div>
	</div>
</div>
</body>
</html>



































