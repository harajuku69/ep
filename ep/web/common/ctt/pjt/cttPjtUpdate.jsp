<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="js/dtpicker.js"></script>
<script src="js/newmempicker.js"></script>
</head>
<body>
<div class="contents">
	<div id="list-contain" class="ui-widget">
	<div id="newmem-dialog" title="Project 멤버 등록">
		<h2>멤버 검색</h2>
		<p class="validateTips"></p>
		<form>
			<input type="text" name="newmemnm" id="newmemnm" class="text ui-widget-content ui-corner-all" placeholder="이름을 입력하세요"><br>
		</form>
		<p> &nbsp;&nbsp;검색 결과</p>
		<div class="containzip" class="ui-widget">
		<table id="newMemSchRs" class="ui-widget ui-widget-content">
			<thead>
				<tr class="ui-widget-header">
					<th>이 름</th>
					<th>부 서</th>
					<th>직 급</th>
					<!-- <th>연락처</th> -->
					<th>이메일</th>
					<th>수행 역할</th>
					<th>선 택</th>
				</tr>
			</thead>
			<tbody>
			</tbody>
		</table>
		</div>
	</div>
	<form action="pjt.do?cmd=pjt_update&pjtno=${reqPjt.pjtno}&pageNo=${pageNo}" method="post" name="frm">
	<input type="hidden" name="pjtno" id="pjtno" value="${reqPjt.pjtno}">
		<table class="list">
			<tr>
				<th>수정일</th>
				<td>
					<%-- <c:out value="${fn:substring(reqPjt.regdt,0,10)}"/> --%>
					<jsp:useBean id="now" class="java.util.Date"/>
					<fmt:formatDate value="${now}" pattern="yyyy-MM-dd" var="today"/>
					<c:out value="${today}"/>
				</td>
				<th>등록자</th>
				<td>${ssAdmnm}</td>
			</tr>
			<tr>
				<th>기 간</th>
				<td colspan="3">
					<input type="text" id="startdt" placeholder="From : ${fn:substring(reqPjt.startdt,0,10)}" class="text ui-widget-content ui-corner-all" style="width:45%; float:left;" required>
					<input type="text" id="enddt" placeholder="To : ${fn:substring(reqPjt.enddt,0,10)}" class="text ui-widget-content ui-corner-all" style="width:45%;float:right" required>
				</td>
			</tr>
			<tr>
				<th>프로젝트 명</th>
				<td colspan="3"><input type="text" size="111" name="pjtnm" value="${reqPjt.pjtnm}" required>* 필수</td>
			</tr>
			<tr>
				<th>상세내용</th>
				<%-- <td colspan="3"><textarea cols="72" rows="10" value="${reqPjt.pjtdtl}" readonly></textarea></td> --%>
				<td colspan="3"><textarea cols="118" rows="5" name="pjtdtl" required>${reqPjt.pjtdtl}</textarea></td>
			</tr>
			<tr>
				<th>사용스킬</th>
				<td>
					<fieldset class="skset">
					<legend><b>Platform Skill</b></legend>
					<c:forEach var="item" items="${reqPfList}">
						<span>${item.sk} </span>
					</c:forEach>
					</fieldset>
				</td>
				<td>
					<fieldset class="skset">
					<legend><b>Web Skill</b></legend>
					<c:forEach var="item" items="${reqWebList}">
						<span>${item.sk} &nbsp;</span>
					</c:forEach>
					</fieldset>
				</td>
				<td>
					<fieldset class="skset">
					<legend><b>Server Skill</b></legend>
					<c:forEach var="item" items="${reqSvrList}">
						<span>${item.sk} &nbsp;</span>
					</c:forEach>
					</fieldset>
				</td>
			</tr>
			<tr>
				<th colspan="4" class="ui-widget-header">Project Member</th>
			</tr>
			<tr>
				<td>이 름</td>
				<td>부 서</td>
				<td>직 급</td>
				<td>수행 역할</td>
				<!-- <td>삭 제</td> -->
			</tr>
			<c:forEach var="item" items="${reqPjtMemList}">
				<tr class="${item.empno}">
					<td>
						<input type="radio" name="memnm" id="memnm" value="${item.empno}">
						${item.memnm}
					</td>
					<td>${item.dpt}</td>
					<td>${item.tit}</td>
					<td>${item.role}
					<%-- ${item.role} --%>
					<!-- <select name="rolecd" id="rolebx"> 
						<c:forEach var="role" items="${reqRoleList}">
							<c:choose>
							<c:when test="${role.role == item.role}">
								<option value="${role.rolecd}" selected="selected" >${role.role}</option>
							</c:when>
							<c:otherwise>
								<option value="${role.rolecd}">${role.role}</option>
							</c:otherwise>
							</c:choose>
						</c:forEach>
					</select> -->
					</td>
					<%-- <td><a href="#" onClick="deleteItem('pjtmem','${item.empno}')">삭 제</a></td> --%>
				</tr>
			</c:forEach>
			<tbody id="newmember">
			</tbody>
			<tr>
				<td colspan="4">
				<input type="button" id="newmemschbtn" value="멤버 등록">
				<input type="button" id="memdelbtn" value="멤버 삭제" onclick="deleteMember()">
				</td>
			</tr>
			</tbody>
		</table>
		<br>
		<div style="padding-left:250px">
			<input type ="submit" value="수정 완료" style="float:left;">
			<input type ="reset" value="되돌리기"> 
			<input type ="button" value="돌아가기"	onclick="history.go(-1)">
		</div>
	</form>
	</div>
</div>
</body>
</html>