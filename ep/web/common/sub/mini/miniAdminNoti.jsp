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
	<p style="display:inline;">Notice</p>
	<%-- <c:if test="${ssAdmchk == 1}"> --%>
		<span>|</span>
		<p style="display:inline;"><a href="staff.do?cmd=admin_noti_list"> Search</a></p>
	<%-- </c:if> --%>
	<hr/>
	<ul>
		<c:forEach var="item" items="${ssRecentNotiList}">
			<li><a href="noti.do?cmd=admin_noti_detail_page&notino=${item.notino}&pageNo=1">${item.tit}</a>
			<span>
				<c:set var = "regdt" value="${item.regdt}"/>
				<c:out value="${fn:substring(regdt, 0, 10)}"/>
			</span>
			</li>
		</c:forEach>
	</ul>
		<p><a href="noti.do?cmd=admin_noti_list">more</a></p>
</div>
</body>
</html>










