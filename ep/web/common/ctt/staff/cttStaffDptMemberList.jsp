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
<script src="js/delete.js"></script>
</head>
<body>
<div class="contents">
	<h1> ${reqDpt} 인원 검색 결과   </h1>
	<div id="list_contain" class="ui-widget">
	<!-- <div class="contain" class="ui-widget"> -->
		<table class="list" class="ui-widget ui-widget-content">
			<thead>
				<tr>
					<!-- <td class="addbtn" colspan="7" style="text-align:right; border:none;"><a href="#" onClick="history.go(-1)"><button id="back">돌아가기</button></a></td> -->
					<td class="addbtn" colspan="7" style="text-align:right; border:none;"><a href="#" onClick="history.go(-1)"><button id="back">돌아가기</button></a></td>
				</tr>
				<tr class="ui-widget-header">
					<th>이 름</th>
					<th>부 서</th>
					<th>직 급</th>
					<th>연락처</th>
					<th>이메일</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="item" items="${reqStaffList}">
				<tr class="${item.empno}">
					<td>
						<a href="staff.do?cmd=admin_detail_page&empid=${item.empid}">${item.empnm}</a>
					</td>
					<td>${item.dptcd}</td>
					<td>${item.titcd}</td>
					<td>
						<c:set var="phone" value="${item.phone}"/>
						<c:set var="dash" value="${'-'}"/>
						<c:out value="${fn:substring(phone,0,3)}${dash}${fn:substring(phone,3,7)}${dash}${fn:substring(phone,7,11)}"/>
					</td>
					<td><a href="mailto:${item.empid}@mars.com">${item.empid}@mars.com</a></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
	<br/>
</div>
</body>
</html>












