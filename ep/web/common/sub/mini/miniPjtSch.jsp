<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<div class="mini">
	<p>Project Search</p>
	<hr/>
	<form action="href='URL'" method="post" name="frm" class="searchform">
		<ul>
			<li>프로젝트명 <input type="text" class="searchtabpjtnm"></li>
			<li>참여멤버명 <input type="text" class="searchtabpjtnm"></li>
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
			<p><a href="pjt.do?cmd=find&${'#frm'}">search</a></p>
		</ul>
	</form>
</div>
</body>
</html>