<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<div class="mini">
	<p style="display:inline;">Project</p>
	<c:if test="${ssAdmchk == 1}">
		<span>|</span>
		<p style="display:inline;"><a href="staff.do?cmd=admin_pjt_list"> Edit</a></p>
	</c:if>
	<hr/>
	<ul>
		<li><a href="#">롯데홈쇼핑 프로젝트</a><span>2016-08-15</span></li>
		<li><a href="#">카카오 드라이버 프로젝트</a><span>2016-08-15</span></li>
		<li><a href="#">K-start up 1등</a><span>2016-08-15</span></li>
		<li><a href="#">4번째 프로젝트</a><span>2016-08-15</span></li>
	</ul>
		<p><a href="pjt.do?cmd=admin_pjt_list">more</a></p>
</div>
</body>
</html>