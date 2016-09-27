<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="js/dtpicker.js"></script>
<script src="js/checkdt.js"></script>
</head>
<body>
<div class="mini">
	<p style="display:inline;">Project Search</p>
	<%-- <c:if test="${ssAdmchk == 1}"> --%> 
		<span>|</span>
		<p style="display:inline;"><a href="staff.do?cmd=admin_pjt_list"> List</a></p>
	<%-- </c:if> --%>
	<hr/>
	<form action="pjt.do?cmd=admin_pjt_search" method="post" name="frm" class="searchform">
		<ul>
			<li>프로젝트명 <input type="text" type="text" name="pjtnm" id="pjtnm" class="searchtabpjtnm"></li>
			<li>참여멤버명 <input type="text" type="text" name="memnm" id="memnm" class="searchtabpjtnm"></li>
			<li>
				<table class="searchtabpjt">
					<tr>
						<td class="searchtabpjtdt">등록일</td>
						<td>
							<label for="from"></label>
							<input type="text" id="from" name="from" placeholder="From">
							<label for="to"></label>
							<input type="text" id="to" name="to" placeholder="To">
						</td>
					</tr>
				</table>
			</li>
		</ul>
			<%-- <p><a href="pjt.do?cmd=find&${'#frm'}">search</a></p> --%>
			<p><input type="submit" value="Search" onclick="return chkfd()"></p>
	</form>
</div>
</body>
</html>