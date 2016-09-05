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
	<p style="display:inline;">Project</p>
	<c:if test="${ssAdmchk == 1}">
		<span>|</span>
		<p style="display:inline;"><a href="staff.do?cmd=admin_pjt_list"> Edit</a></p>
	</c:if>
	<hr/>
	<ul>
		<c:forEach var="item" items="${ssRecentPjtList}">
			<li><a href="pjt.do?cmd=staff_pjt_detail&pjtno=${item.pjtno}">${item.pjtnm}</a>
			<span>
				<c:set var = "regdt" value="${item.regdt}"/>
				<c:out value="${fn:substring(regdt, 0, 10)}"/>
			</span>
			</li>
		</c:forEach>
	</ul>
		<p><a href="pjt.do?cmd=staff_pjt_list">more</a></p>
</div>
</body>
</html>