<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="js/tab.js"></script>
<script src="js/delete.js"></script>
</head>
<body>
	<div id="tabs">
		<ul>
			<li><a href="#tabedu">학력</a></li>
			<li><a href="#tabcrr">경력</a></li>
			<li><a href="#tabcerti">자격증</a></li>
		</ul>
		<div id="tabedu">
			<div id="edu-dialog" title="학력 추가">
				<p class="validateTips">모든 필드가 입력되어야 합니다.</p>
				<form id="frm_edu">
					<fieldset>
						<label for="loc">지 역</label><br>
						<input type="text" name="loc" id="loc" placeholder="인천" class="text ui-widget-content ui-corner-all"  ><br>
						<label for="school">학 교</label><br>
						<input type="text" name="school" id="school" placeholder="부평고등학교" class="text ui-widget-content ui-corner-all"  ><br>
						<label for="major">전 공</label><br>
						<input type="text" name="major" id="major" placeholder="이과" class="text ui-widget-content ui-corner-all"  ><br>
						<label for="enterdt">입 학</label><br>
						<input type="text" name="enterdt" id="enterdt" class="text ui-widget-content ui-corner-all" required><br>
						<label for="graddt">졸 업</label><br>
						<input type="text" name="graddt" id="graddt" class="text ui-widget-content ui-corner-all" required><br>
						<input type="submit" tabindex="-1" style="position:absolute; left:-1000px">
					</fieldset>
				</form>
			</div> 
			<div class="contain" class="ui-widget">
				<table id="edu" class="ui-widget ui-widget-content">
					<thead>
						<tr>
							<td class="addbtn" colspan="7" style="text-align:right; border:none;"><button id="add-edu">추가 등록</button></td>
						</tr>
						<tr class="ui-widget-header">
							<th>지 역</th>
							<th>학 교</th>
							<th>전 공</th>
							<th>입 학</th>
							<th>졸 업</th>
							<!-- <th>수 정</th> -->
							<th>삭 제</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="edu" items="${reqEduList}">
						<tr class="${edu.eduno}" class="ui-widget-header">
							<td>${edu.loc}</td>
							<td>${edu.school}</td>
							<td>${edu.major}</td>
							<td>
								<c:set var="enterdt" value="${edu.enterdt}"/>
								<c:out value="${fn:substring(enterdt,0,10)}"/>
							</td>
							<td>
								<c:set var="graddt" value="${edu.graddt}" />
								<c:out value="${fn:substring(graddt,0,10) }" />
							</td>
							<td>
								<!-- <input type="button" id="del_edu" value="삭제"> -->
								<a href="#" onClick="deleteItem('edu', '${edu.eduno}')">삭 제</a>
							</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<div id="tabcrr">
			<div id="crr-dialog" title="경력 추가">
				<p class="validateTips">모든 필드가 입력되어야 합니다.</p>
				<form id="frm_crr">
					<fieldset>
						<label for="comnm">회사명</label><br>
						<input type="text" name="comnm" id="comnm" placeholder="LG전자" class="text ui-widget-content ui-corner-all"  ><br>
						<label for="dpt">근무부서</label><br>
						<input type="text" name="dpt" id="dpt" placeholder="MC사업부" class="text ui-widget-content ui-corner-all"  ><br>
						<label for="tit">근무직급</label><br>
						<input type="text" name="tit" id="tit" placeholder="대리" class="text ui-widget-content ui-corner-all"  ><br>
						<label for="empdt">입사일</label><br>
						<input type="text" name="empdt" id="empdt" class="text ui-widget-content ui-corner-all" required ><br>
						<label for="outdt">퇴사일</label><br>
						<input type="text" name="outdt" id="outdt" class="text ui-widget-content ui-corner-all" required ><br>
						<input type="submit" tabindex="-1" style="position:absolute; left:-1000px">
					</fieldset>
				</form>
			</div>
			<div class="contain" class="ui-widget">
				<table id="crr" class="ui-widget ui-widget-content">
					<thead>
						<tr>
							<td class="addbtn" colspan="7" style="text-align:right; border:none;"><button id="add-crr">추가 등록</button></td>
						</tr>
						<tr class="ui-widget-header">
							<th>회사명</th>
							<th>근무부서</th>
							<th>근무직급</th>
							<th>입사일</th>
							<th>퇴사일</th>
							<!-- <th>수 정</th> -->
							<th>삭 제</th>
						</tr>
					</thead>
					<tbody>
						<tr></tr>
					</tbody>
				</table>
			</div>
		</div>
		<div id="tabcerti">
			<div id="certi-dialog" title="자격(증) 추가">
				<p class="validateTips">모든 필드가 입력되어야 합니다.</p>
				<form id="frm_certi">
					<fieldset>
						<label for="certinm">자격(증)명</label><br>
						<input type="text" name="certinm" id="certinm" placeholder="정보처리/TOEIC" class="text ui-widget-content ui-corner-all"  ><br>
						<label for="rank">성적(등급)</label><br>
						<input type="text" name="rank" id="rank" placeholder="산업기사/990" class="text ui-widget-content ui-corner-all"  ><br>
						<label for="publ">발행기관</label><br>
						<input type="text" name="publ" id="publ" placeholder="한국산업인력공단/ETS" class="text ui-widget-content ui-corner-all"  ><br>
						<label for="regdt">취득일</label><br>
						<input type="text" name="regdt" id="regdt" class="text ui-widget-content ui-corner-all" required ><br>
						<label for="expdt">만료일</label><br>
						<input type="text" name="expdt" id="expdt" class="text ui-widget-content ui-corner-all" required ><br>
						<input type="submit" tabindex="-1" style="position:absolute; left:-1000px">
					</fieldset>
				</form>
			</div> 
		 	<div class="contain" class="ui-widget">
				<table id="certi" class="ui-widget ui-widget-content">
					<thead>
						<tr>
							<td class="addbtn" colspan="7" style="text-align:right; border:none;"><button id="add-certi">추가 등록</button></td>
						</tr>
						<tr class="ui-widget-header">
							<th>자격(증)명</th>
							<th>성적(등급)</th>
							<th>발행기관</th>
							<th>취득일</th>
							<th>만료일</th>
							<!-- <th>수 정</th> -->
							<th>삭 제</th>
						</tr>
					</thead>
					<tbody>
						<tr></tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>