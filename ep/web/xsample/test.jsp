<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
int[] skl = {11,12,13};
int[] sel = {12,13};
int cnt = 0;
%>
<%-- <c:set var="cnt" value="${0}"/>
<c:out value="${cnt+1}"/> --%>
<c:forEach var="skl" items="${skl}">
	<c:out value="${skl}"/>
</c:forEach>

</body>
</html>