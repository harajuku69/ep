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
	<p style="display:inline;">Notice Search</p>
	<%-- <c:if test="${ssAdmchk == 1}"> --%>
		<span>|</span>
		<p style="display:inline;"><a href="staff.do?cmd=admin_noti_list"> List</a></p>
	<%-- </c:if> --%>
	<hr/>
	<form action="noti.do?cmd=admin_noti_search" method="post" name="frm_noti_sch" class="searchform">
	<!-- <form name="frm" class="searchform"> -->
		<ul>
			<li> &nbsp;글 제목 <input type="text" name="tit" id="tit" class="searchtabnotinm"></li>
			<li> &nbsp;글 내용 <input type="text" name="ctt" id="ctt" class="searchtabnotinm"></li>
			<li>
				<table class="searchtabnoti">
					<tr>
						<td class="searchtabnotidt">등록일</td>
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
			<%-- <p><a href="noti.do?cmd=admin_noti_search&tit=${tit.value}">Search</a></p> --%>
			<p><input type="submit" value="Search" onclick="return chkdt()"></p>
	</form>
</div>
</body>
</html>