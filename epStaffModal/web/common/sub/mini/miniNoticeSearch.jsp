<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="../../../css/jquery-ui.min.css">
<link rel="stylesheet" type="text/css" href="../../../css/main.css">
<script src="../../../js/jquery-1.10.2.min.js"></script>
<script src="../../../js/jquery-ui.min.js"></script>
<script src="../../../js/form.js"></script>
</head>
<body>
<div class="mini">
	<p>Notice Search</p>
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
			<p><a href="''">search</a></p>
		</ul>
	</form>
</div>
</body>
</html>