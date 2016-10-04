<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ page session="false" %>
<%@include file="../include/header.jsp" %>
<script>
$(function(){
	var formObj = $("form[role='form']");
	console.log(formObj);
	$(".btn-warning").on("click", function(){
		formObj.attr("action", "/board/update");
		formObj.attr("method", "get");
		formObj.submit();
	});
	$(".btn-danger").on("click", function(){
		formObj.attr("action", "/board/delete");
		formObj.submit();
	});
	$(".btn-primary").on("click", function(){
		self.location = "/board/listPage";
	});
});
</script>
<section class="content">
	<div class="row">
		<div class="col-md-12">
			<div class="box">
				<div class="box-header with-border">
					<h3 class="box-title">글 보기</h3>
				</div>
				<form action="" role="form" method="post">
					<input type="hidden" name="bno" value="${boardDto.bno}">
				</form>
				<div class="box-body">
					<div class="form-group">
						<label for="exampleInputEmail1">Title</label>
						<input type="text" name="title" class="form-control" value="${boardDto.title}" readonly>
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">Content</label>
						<textarea class="form-control" name="content" rows="3" readonly>${boardDto.content}</textarea>
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Writer</label>
						<input type="text" name="writer" class="form-control" value="${boardDto.writer}" readonly>
					</div>
				</div>
				<div class="box-footer">
					<button type="submit" class="btn btn-warning">수 정</button>
					<button type="submit" class="btn btn-danger">삭 제</button>
					<button type="submit" class="btn btn-primary">목록으로</button>
				</div>
			</div>
		</div>
	</div>
</section>
<%@include file="../include/footer.jsp" %>
