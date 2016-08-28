<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/subtab.js"></script>
</head>
<body>
<div class="sub">
	<div id="tabs">
		<ul>
			<li><a href="#tabedu">학력</a></li>
			<li><a href="#tabcrr">경력</a></li>
			<li><a href="#tabcerti">자격증</a></li>
		</ul>
		<div id="tabedu">
			<div class="contain" class="ui-widget">
				<table id="edu">
					<thead>
						<tr>
							<td class="addbtn" colspan="7" style="text-align:right; border:none;"><button id="add-edu">추가 등록</button></td>
						</tr>
						<tr class="ui-widget-header">
							<th>지 역</th><th>학 교</th><th>전 공</th><th>입 학</th><th>졸 업</th><th>수 정</th><th>삭 제</th>
						</tr>
					</thead>
					<tbody>
						<tr></tr>
					</tbody>
				</table>
			</div>
			<div id="dialog-form" title="학력 추가">
				<p class="validateTips">모든 필드가 입력되어야 합니다.</p>
				<form>
					<fieldset>
						<label for="location">지 역</label><br>
						<input type="text" name="location" id="location" placeholder="인천" class="text ui-widget-content ui-corner-all"><br>
						<label for="school">학 교</label><br>
						<input type="text" name="school" id="school" placeholder="부평고등교" class="text ui-widget-content ui-corner-all"><br>
						<label for="major">전 공</label><br>
						<input type="text" name="major" id="major" placeholder="이과" class="text ui-widget-content ui-corner-all"><br>
						<label for="enterdt">입 학</label><br>
						<input type="text" name="startdt" id="startdt" class="text ui-widget-content ui-corner-all"><br>
						<label for="graddt">졸 업</label><br>
						<input type="text" name="enddt" id="enddt" class="text ui-widget-content ui-corner-all"><br>
						<input type="submit" tabindex="-1" style="position:absolute; left:-1000px">
					</fieldset>
				</form>
			</div> 
		</div>
		<div id="tabcrr">
		<!--	<div class="contain" class="ui-widget">
				<table id="career">
					<thead>
						<tr>
							<td class="addbtn" colspan="7" style="text-align:right; border:none;"><button id="add-career">추가 등록</button></td>
						</tr>
						<tr class="ui-widget-header">
							<th>회사명</th><th>근무부서</th><th>근무직급</th><th>입사일</th><th>퇴사일</th><th>수 정</th><th>삭 제</th>
						</tr>
					</thead>
					<tbody>
						<tr></tr>
					</tbody>
				</table>
			</div>
			<div id="career-dialog-form" title="경력 추가">
				<p class="validateTips">모든 필드가 입력되어야 합니다.</p>
				<form>
					<fieldset>
						<label for="comnm">회사명</label><br>
						<input type="text" name="comnm" id="comnm" placeholder="LG전자" class="text ui-widget-content ui-corner-all"><br>
						<label for="dpt">근무부서</label><br>
						<input type="text" name="dpt" id="dpt" placeholder="MC사업부" class="text ui-widget-content ui-corner-all"><br>
						<label for="tit">근무직급</label><br>
						<input type="text" name="tit" id="tit" placeholder="대리" class="text ui-widget-content ui-corner-all"><br>
						<label for="empdt">입사일</label><br>
						<input type="text" name="empdt" id="empdt" class="text ui-widget-content ui-corner-all"><br>
						<label for="transdt">퇴사일</label><br>
						<input type="text" name="transdt" id="transdt" class="text ui-widget-content ui-corner-all"><br>
						<input type="submit" tabindex="-1" style="position:absolute; left:-1000px">
					</fieldset>
				</form>
			</div>--> 
		</div>
		<div id="tabcerti">
		<!-- 	<div class="contain" class="ui-widget">
				<table id="certi">
					<thead>
						<tr>
							<td class="addbtn" colspan="7" style="text-align:right; border:none;"><button id="add-certi">추가 등록</button></td>
						</tr>
						<tr class="ui-widget-header">
							<th>자격(증)명</th><th>성적(등급)</th><th>발행기관</th><th>취득일</th><th>만료일</th><th>수 정</th><th>삭 제</th>
						</tr>
					</thead>
					<tbody>
						<tr></tr>
					</tbody>
				</table>
			</div>
			<div id="certi-dialog-form" title="자격(증) 추가">
				<p class="validateTips">모든 필드가 입력되어야 합니다.</p>
				<form>
					<fieldset>
						<label for="certinm">자격(증)명</label><br>
						<input type="text" name="certinm" id="certinm" placeholder="정보처리/TOEIC" class="text ui-widget-content ui-corner-all"><br>
						<label for="rank">성적(등급)</label><br>
						<input type="text" name="rank" id="rank" placeholder="산업기사/990" class="text ui-widget-content ui-corner-all"><br>
						<label for="publ">발행기관</label><br>
						<input type="text" name="publ" id="publ" placeholder="한국산업인력공단/ETS" class="text ui-widget-content ui-corner-all"><br>
						<label for="regdt">취득일</label><br>
						<input type="text" name="regdt" id="regdt" class="text ui-widget-content ui-corner-all"><br>
						<label for="expdt">만료일</label><br>
						<input type="text" name="expdt" id="expdt" class="text ui-widget-content ui-corner-all"><br>
						<input type="submit" tabindex="-1" style="position:absolute; left:-1000px">
					</fieldset>
				</form>
			</div>--> 
		</div>
	</div>
</div>
</body>
</html>