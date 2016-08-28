<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>jQuery UI Tabs -Default functionality</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/redmond/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<link rel="stylesheet" href="/resources/demos/style.css">
<script>
$(function() {
	$( "#tabs" ).tabs({
		event:"mouseover"
	});
});
</script>
</head>
<body>
<div id="tabs">
	<ul>
		<li><a href="#tabs-1">학력</a></li>
		<li><a href="#tabs-2">경력</a></li>
		<li><a href="#tabs-3">자격증</a></li>
	</ul>
	<div id="tabs-1">
		<p>학력사항이 출력되는 영역입니다.</p>
	</div>
	<div id="tabs-2">
		<p>경력사항이 출력되는 영역입니다.</p>
	</div>
	<div id="tabs-3">
		<p>자격증사항이 출력되는 영역입니다.</p>
	</div>
</div>
</body>
</html>
