<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="js/dtpicker.js"></script>
<script src="js/plpicker.js"></script>
</head>
<body>
<div class="contents">
	<div id="pl-dialog" title="Project Leader 검색">
		<h2>PL 검색</h2>
		<p class="validateTips"></p>
		<form>
			<input type="text" name="plnm" id="plnm" class="text ui-widget-content ui-corner-all" placeholder="이름을 입력하세요"><br>
		</form>
		<p> &nbsp;&nbsp;검색 결과</p>
		<div class="containzip" class="ui-widget">
		<table id="plSchRs" class="ui-widget ui-widget-content">
			<thead>
				<tr class="ui-widget-header">
					<th>이 름</th>
					<th>부 서</th>
					<th>직 급</th>
					<th>연락처</th>
					<th>이메일</th>
					<th>선택</th>
				</tr>
			</thead>
			<tbody>
			</tbody>
		</table>
		</div>
	</div>
	<form action="noti.do?cmd=pjt_write" method="post" name="frm">
	<table>
		<tr>
			<th>작성일</th>
			<td>
				<jsp:useBean id="now" class="java.util.Date"/>
				<fmt:formatDate value="${now}" pattern="yyyy-MM-dd" var="today"/>
				<c:out value="${today}"/>
			</td>
			<th>작성자</th>
			<td><input type="text" size="12" name="admnm" value="${ssAdmnm}" required></td>
		</tr>
		<tr>
			<th>프로젝트 명</th>
			<td colspan="3"><input type="text" size="70" name="pjtnm" required></td>
		</tr>
		<tr>
			<th>기 간</th>
			<td colspan="3">
				<!-- <label for="startdt">시작일</label><br> -->
				<input type="text" name="startdt" id="startdt" placeholder="시작일" class="text ui-widget-content ui-corner-all" style="width:45%; float:left;"required >
				<!-- <label for="enddt">종료일</label><br> -->
				<input type="text" name="enddt" id="enddt" placeholder="종료일" class="text ui-widget-content ui-corner-all" style="width:45%;float:right" required >
			</td>
		</tr>
		<tr>
			<th>사용스킬</th>
			<td>
				<fieldset class="skset">
					<legend><b>Platform Skill</b></legend>
					<label for="Java">Java</label>
					<input type="checkbox" name="Platform" id="Java" value="01" ><br/>
					<label for="Object C">Object C</label>
					<input type="checkbox" name="Platform" id="Object C" value="02"><br/>
					<label for=".NET"></label>
					<input type="checkbox" name="Platform" id=".NET" value="03">
				</fieldset>
			</td>
			<td>
				<fieldset class="skset">
					<legend><b>Web Skill</b></legend>
					<label for="HTML">HTML</label>
					<input type="checkbox" name="web" id="HTML" value="11"><br/>
					<label for="CSS">CSS</label>
					<input type="checkbox" name="web" id="CSS" value="12"><br/>
					<label for="Javascript">Javascript</label>
					<input type="checkbox" name="web" id="Javascript" value="13"><br/>
				</fieldset>
			</td>
			<td>
				<fieldset class="skset">
					<legend><b>Server Skill</b></legend>
					<label for="JSP">JSP</label>
					<input type="checkbox" name="Server" id="JSP" value="21"><br/>
					<label for="ASP">Servlet</label>
					<input type="checkbox" name="Server" id="ASP" value="22">
					<label for="PHP">Publisher</label>
					<input type="checkbox" name="Server" id="PHP" value="23">
				</fieldset>
			</td>
		</tr>
		<tr>
			<th>상세내용</th>
			<td colspan="3"><textarea cols="72" rows="10" name="pjtdtl" required></textarea></td>
		</tr>
		<tr>
			<th>프로젝트 리더</th>
			<td colspan="2">
				<input type="text" name="plnm" id="plnm" readonly required>
				<input type="hidden" name="plid" id="plid">
			</td>
			<td><input type="button" name="plschbtn" id="plschbtn" value="검 색"></td>
		</tr>
	</table>
	<br>
	<div style="padding-left:250px">
		<input type ="submit" value="작성 완료" style="float:left;">
		<input type="reset" value="다시 작성" style="float:left;">
		<input type ="button" value="목록으로" 
			onclick="location.href='noti.do?cmd=admin_pjt_list'"">
	</div>
	</form>
</div>
</body>
</html>