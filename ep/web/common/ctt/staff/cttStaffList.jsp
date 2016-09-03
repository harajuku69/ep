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
<div class="contents">
	<h1> Mars 사원 목록 </h1>
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
					<th>수 정</th>
					<th>삭 제</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="item" items="${staffList}">
				<tr class="${item.empid}">
					<td>
						<a href="staff.do?cmd=admin_detail_page&empid=${item.empid}">${item.empnm}</a>
					</td>
					<td>${item.dptcd}</td>
					<td>${item.titcd}</td>
					<td>${item.phone}</td>
					<td><a href="mailto:${item.empid}@mars.com">${item.empid}@mars.com</a></td>
					<td><a href="staff.do?cmd=admin_update_page&empid=${item.empid}">수정</a></td>
					<td><a href="#" onClick="deleteItem('staff','${item.empid}')">삭제</a></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		<div id="paging" style="text-align:center; font-size:20px; padding:1em">
			<!-- <li class="page-item">
				<a class="page-link" href="staff.do?cmd=staff_list&pageNo=">i</a>
      			<span class="sr-only">(current)</span></a>
    		</li> -->
    		<%-- ${pageNo}
    		${blockNo}
    		${totPage}
    		${totBlock}
    		${prevPageNo}
    		${nextPageNo} --%>
    		<span>
    			<c:if test="${blockNo > 1}">
    				<span><a href="staff.do?cmd=staff_list&pageNo=${prevPageNo}">&laquo;이전 페이지</a></span>
    			</c:if>
        		<%-- <c:forEach var="i" begin="${firstPageNoInBlock}" end="${lastPageNoInBlock}" step="1">
            		<c:choose>
                		<c:when test="${i eq pageNo}"><span>${i}</span></c:when>
                		<c:otherwise><a href="staff.do?cmd=staff_list&pageNo=${i}">${i}</a></c:otherwise>
            		</c:choose>
        		</c:forEach> --%>
        		<c:choose>
        		<c:when test="${blockNo < totBlock }">
	        		<c:forEach var="i" begin="${firstPageNoInBlock}" end="${lastPageNoInBlock}" step="1">
	            		<c:choose>
	                		<c:when test="${i eq pageNo}"><span>${i}</span></c:when>
	                		<c:otherwise><a href="staff.do?cmd=staff_list&pageNo=${i}">${i}</a></c:otherwise>
	            		</c:choose>
	        		</c:forEach>
	        	</c:when>
	        	<c:otherwise>
	        		<c:forEach var="i" begin="${firstPageNoInBlock}" end="${totPage}" step="1">
	            		<c:choose>
	                		<c:when test="${i eq pageNo}"><span>${i}</span></c:when>
	                		<c:otherwise><a href="staff.do?cmd=staff_list&pageNo=${i}">${i}</a></c:otherwise>
	            		</c:choose>
	        		</c:forEach>
	        	</c:otherwise>
        		</c:choose>
        		<c:if test="${blockNo < totBlock}">
    				<span><a href="staff.do?cmd=staff_list&pageNo=${nextPageNo}">다음 페이지&raquo;</a></span>
    			</c:if>
    		</span>
		</div>
	</div>
	<br/>
</div>
</body>
</html>