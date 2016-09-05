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
<div class="mini">
	<p style="display:inline;">Notice Search</p>
	<c:if test="${ssAdmchk == 1}">
		<span>|</span>
		<p style="display:inline;"><a href="staff.do?cmd=admin_noti_list"> List</a></p>
	</c:if>
	<hr/>
	<form action="href=''" method="post" name="frm" class="searchform">
		<ul>
			<li> &nbsp;글 제목 <input type="text" class="searchtabnotinm"></li>
			<li> &nbsp;글 내용 <input type="text" class="searchtabnotinm"></li>
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
			<p><a href="''">search</a></p>
	</form>
</div>
</body>
</html>