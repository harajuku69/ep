<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>
<%@include file="../include/header.jsp"%>
<script>
	var result = '${msg}';
	if (result == 'SUCCESS') {
		alert("처리가 완료되었습니다.");
	}
	$(".pagination li a").on("click", function(event){
		event.preventDefault(); 
		var targetPage = $(this).attr("href");
		var jobForm = $("#jobForm");
		jobForm.find("[name='page']").val(targetPage);
		jobForm.attr("action","/board/listPage").attr("method", "get");
		jobForm.submit();
	});
	/* $("#newBtn").on("click",function{
		location.href("/board/register");
	}) */
</script>
<section class="content">
	<div class="row">
		<div class="col-md-12">
			<div class='box'>
				<div class="box-header with-border">
					<h3 class="box-title">Board List</h3>
				</div>
				<div class='box-body'>
					<a href="/board/register"><button id='newBtn'>New Board</button></a>
				</div>
			</div>
			<div class="box">
				<div class="box-header with-border">
					<h3 class="box-title">글 목록 페이지</h3>
				</div>
				<div class="box-body">
					<table class="table table-bordered">
						<tr>
							<th style="width: 10px">No</th>
							<th>제목</th>
							<th>작성자</th>
							<th>작성일</th>
							<th style="width: 40px">ReadCount</th>
						</tr>
						<c:forEach var="board" items="${list}" >

							<tr>
								<td>${board.bno}</td>
								<td><a href='/board/detail${pm.makeQuery(pm.cri.page)}&bno=${board.bno}'>${board.title}</a></td>
								<td>${board.writer}</td>
								<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${board.regdate}" /></td>
								<td><span class="badge bg-red">${board.viewcnt }</span></td>
							</tr>
						</c:forEach>
					</table>
				</div>
				<div class="box-footer">
					<div class="text-center">
						<ul class="pagination">
							<c:if test="${pm.prev}">
								<li><a href="listPage${pm.makeQuery(pm.sttPage - 1) }">&laquo;</a></li>
							</c:if>
							<c:forEach var="idx" begin="${pm.sttPage }" end="${pm.endPage }">
								<li
									<c:out value="${pm.cri.page == idx?'class =active':''}"/>>
									<a href="listPage${pm.makeQuery(idx)}">${idx}</a>
								</li>
							</c:forEach>
							<c:if test="${pm.next && pm.endPage > 0}">
								<li><a href="listPage${pm.makeQuery(pm.endPage +1) }">&raquo;</a></li>
							</c:if>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<form id="jobForm">
  <input type='hidden' name="page" value="${pm.cri.recPerPage}">
  <input type='hidden' name="recPerPage" value="${pm.cri.recPerPage}">
</form>
<%@include file="../include/footer.jsp"%>
