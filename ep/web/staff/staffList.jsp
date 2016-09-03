<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Staff Login</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="css/jquery-ui.min.css">
<link rel="stylesheet" type="text/css" href="css/main.css">
<script src="js/jquery-1.10.2.min.js"></script>
<script src="js/jquery-ui.min.js"></script>
<script src="js/main.js"></script>
</head>
<body>
<div class="wrap">
	<jsp:include page="../common/header/headerAdmin.jsp"></jsp:include>
	<jsp:include page="../common/ctt/staff/cttStaffList.jsp"></jsp:include>
	<jsp:include page="../common/sub/subAdmin.jsp"></jsp:include>
	<jsp:include page="../common/footer/footer.jsp"></jsp:include>
</div>
</body>
</html>