<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ page session="false" %>
<%@include file="../include/header.jsp" %>
<script>
	var result = '${msg}';
	if(result == 'SUCCESS'){
		alert("처리가 완료되었습니다.");
	}
</script>
<section class="content">
	<div class="row">
		<div class="col-md-12">
			<div class="box">
				<div class="box-header with-border">
					<h3 class="box-title">게시판 목록</h3>
				</div>
				<div class="box-body">
					<table class="table table-bordered">
						<tr>
							<th style="width: 10px">BNO</th>
							<th>TITLE</th>
							<th>WRITER</th>
							<th>REGDATE</th>
							<th style="width:40px">VIEWCNT</th>
						</tr>
						<c:forEach var="boardDto" items="${list}">
						<tr>
							<td>${boardDto.bno}</td>
							<td><a href='/board/read?bno=${boardDto.bno}' >${boardDto.title}</a></td>
							<td>${boardDto.writer}</td>
							<td><fmt:formatDate pattern="yyyy--MM-dd HH:mm" value="${boardDto.regdate}"/></td>
							<td><span class="badge bg-red">${boardDto.viewcnt}</span></td>
						</tr>
						</c:forEach>
					</table>
				</div>
				<div class="box-footer">
					Footer
				</div>
			</div>
		</div>
	</div>
</section>
<%@include file="../include/footer.jsp" %>
