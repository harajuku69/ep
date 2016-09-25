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
			<li><a href="#tabcrt">자격증</a></li>
			<!-- <li><a href="#tabsk">보유 스킬</a></li> -->
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
							<td class="addbtn" colspan="7" style="text-align:right; border:none;"><button id="add-edu">등록</button></td>
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
							<td class="addbtn" colspan="7" style="text-align:right; border:none;"><button id="add-crr">등록</button></td>
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
						<c:forEach var="crr" items="${reqCrrList}">
							<tr class="${crr.crrno}">
								<td>${crr.comnm}</td>
								<td>${crr.dpt}</td>
								<td>${crr.tit}</td>
								<td>
									<c:set var="empdt" value="${crr.empdt}"/>
									<c:out value="${fn:substring(empdt, 0, 10)}"/>
								</td>
								<td>
									<c:set var="outdt" value="${crr.outdt}"/>
									<c:out value="${fn:substring(outdt, 0, 10)}"/>
								</td>
								<td>
									<a href="#" onClick="deleteItem('crr', '${crr.crrno}')">삭 제</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<div id="tabcrt">
			<div id="crt-dialog" title="자격(증) 추가">
				<p class="validateTips">모든 필드가 입력되어야 합니다.</p>
				<form id="frm_crt">
					<fieldset>
						<label for="crtnm">자격(증)명</label><br>
						<input type="text" name="crtnm" id="crtnm" placeholder="정보처리/TOEIC" class="text ui-widget-content ui-corner-all"  ><br>
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
				<table id="crt" class="ui-widget ui-widget-content">
					<thead>
						<tr>
							<td class="addbtn" colspan="7" style="text-align:right; border:none;"><button id="add-crt">등록</button></td>
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
						<c:forEach var="crt" items="${reqCrtList}">
							<tr class="${crt.crtno}">
								<td>${crt.crtnm}</td>
								<td>${crt.rank}</td>
								<td>${crt.publ}</td>
								<td>
									<c:set var="regdt" value="${crt.regdt}"/>
									<c:out value="${fn:substring(regdt, 0, 10)}"/>
								</td>
								<td>
									<c:set var="expdt" value="${crt.expdt}"/>
									<c:out value="${fn:substring(expdt, 0, 10)}"/>
								</td>
								<td>
									<a href="#" onClick="deleteItem('crt', '${crt.crtno}')">삭 제</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<!-- <div id="tabsk">
			<div id="sk-dialog" title="보유 스킬 추가">
				<p class="validateTips"></p>
				<form id="frm_sk">
				<table>
					<tr>
						<th class="ui-widget-header">스킬 종류</th>
						<td>
							<fieldset class="skset">
								<legend><b>Platform Skill</b></legend>
								<table>
									<tr>
										<td class="skbx">
											<label for="Java">Java</label>
										</td>
										<td class="chkbx">
											<input type="checkbox" name="platform" id="Java" value="01" >
										</td>
									</tr>
									<tr>
										<td class="skbx">
											<label for="Object C">Object C</label>
										</td>
										<td class="chkbx">
											<input type="checkbox" name="platform" id="Object C" value="02" >
										</td>
									</tr>
									<tr>
										<td class="skbx">
											<label for=".NET">.NET</label>
										</td>
										<td class="chkbx">
											<input type="checkbox" name="platform" id=".NET" value="03" >
										</td>
									</tr>
								</table>
							</fieldset>
						</td>
						<td>
							<fieldset class="skset">
								<legend><b>Web Skill</b></legend>
								<table>
									<tr>
										<td class="skbx">
											<label for="HTML">HTML</label>
										</td>
										<td class="chkbx">
											<input type="checkbox" name="web" id="HTML" value="11" >
										</td>
									</tr>
									<tr>
										<td class="skbx">
											<label for="CSS">CSS</label>
										</td>
										<td class="chkbx">
											<input type="checkbox" name="web" id="CSS" value="12" >
										</td>
									</tr>
									<tr>
										<td class="skbx">
											<label for="Javascript">Javascript</label>
										</td>
										<td class="chkbx">
											<input type="checkbox" name="web" id="Javascript" >
										</td>
									</tr>
								</table>
							</fieldset>
						</td>
						<td>
							<fieldset class="skset">
								<legend><b>Server Skill</b></legend>
								<table>
									<tr>
										<td class="skbx">
											<label for="JSP">JSP</label>
										</td>
										<td class="chkbx">
											<input type="checkbox" name="svr" id="JSP" value="21">
										</td>
									</tr>
									<tr>
										<td class="skbx">
											<label for="ASP">ASP</label>
										</td>
										<td class="chkbx">
											<input type="checkbox" name="svr" id="ASP" value="22">
										</td>
									</tr>
									<tr>
										<td class="skbx">
											<label for="PHP">PHP</label>
										</td>
										<td class="chkbx">
											<input type="checkbox" name="svr" id="PHP" value="23">
										</td>
									</tr>
								</table>
							</fieldset>
						</td>
					</tr>
				</table>
				</form>
			</div> 
		 	<div class="contain" class="ui-widget">
				<table id="sk" class="ui-widget ui-widget-content">
					<tbody>
						<tr>
							<td class="addbtn" colspan="7" style="text-align:right; border:none;"><button id="add-sk">등록</button></td>
						</tr>
						<tr>
							<th class="ui-widget-header">Platform Skill</th>
							<td>java
							</td>
						</tr>
						<tr>
							<th class="ui-widget-header">Web Skill</th>
							<td>html
							</td>
						</tr>
						<tr>
							<th class="ui-widget-header">Server Skill</th>
							<td>jsp
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div> -->
	</div>
</body>
</html>