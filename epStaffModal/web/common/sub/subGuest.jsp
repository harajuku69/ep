<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="../../css/main.css">
</head>
<body>
<div class="sub">
	<jsp:include page="mini/miniGuest.jsp"></jsp:include>
	<jsp:include page="mini/miniNotice.jsp"></jsp:include>
	<jsp:include page="mini/miniProject.jsp"></jsp:include>
</div>
</body>
</html>