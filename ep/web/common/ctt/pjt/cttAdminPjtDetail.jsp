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
	<div id="list-contain" class="ui-widget">
		<table class="list">
			<tr>
				<th>등록일</th>
				<td class="tit">
					<c:out value="${fn:substring(reqPjt.regdt,0,10)}"/>
				</td>
				<th id="ctr">등록자</th><td class="tit">${ssAdmnm}</td>
			</tr>
			<tr>
				<th>기 간</th>
				<td colspan="3">
					<input type="text" id="startdt" value="From : ${fn:substring(reqPjt.startdt,0,10)}" class="text ui-widget-content ui-corner-all" style="width:45%; float:left;" readonly>
					<input type="text" id="enddt" value="To : ${fn:substring(reqPjt.enddt,0,10)}" class="text ui-widget-content ui-corner-all" style="width:45%;float:right" readonly>
				</td>
			</tr>
			<tr>
				<th>프로젝트 명</th>
				<td colspan="3">${reqPjt.pjtnm}</td>
			</tr>
			<tr>
				<th>상세내용</th>
				<%-- <td colspan="3"><textarea cols="72" rows="10" value="${reqPjt.pjtdtl}" readonly></textarea></td> --%>
				<td colspan="3" id="cttdtl"><pre>${reqPjt.pjtdtl}</pre></td>
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
		</table>
		<div id="memberList">
			<table class="list">
				<tr>
					<th colspan="4" class="ui-widget-header">Project Member</th>
				</tr>
				<tr>
					<th>수행 역할</th>
					<th>이 름</th>
					<th>부 서</th>
					<th>직 급</th>
				</tr>
				<tbody>
				<c:forEach var="item" items="${reqPjtMemList}">
					<tr class="${item.empno}">
						<td class="tit">${item.role}</td>
						<td class="tit">${item.memnm}</td>
						<td class="tit">${item.dpt}</td>
						<td class="tit">${item.tit}</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
		<div style="padding-left:400px">
			<input type ="button" value="수정하기" onclick="location.href='pjt.do?cmd=pjt_update_page&pjtno=${reqPjt.pjtno}&pageNo=${pageNo}'">
			<input type ="button" value="목록으로" onclick="location.href='pjt.do?cmd=admin_pjt_list'">
		</div>
	</div>
</div>
</body>
</html>