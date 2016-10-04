<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false" %>
<%@include file="../include/header.jsp" %>
<script>
$(function(){
	var formObj = $("form[role='form']");
	console.log(formObj);
	$(".btn-primary").on("click", function(){
		formObj.submit();
	});
	$(".btn-warning").on("click", function(){
		self.location = "/board/listPage";
	});
});
</script>
<section class="content">
	<div class="row">
		<div class="col-md-12">
			<div class="box">
				<div class="box-header with-border">
					<h3 class="box-title">글 수정</h3>
				</div>
				<form action="" role="form" method="post">
				<div class="box-body">
					<div class="form-group">
						<label for="exampleInputEmail1">BNO</label>
						<input type="text" name="bno" class="form-control" value="${boardDto.bno}" readonly>
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Title</label>
						<input type="text" name="title" class="form-control" value="${boardDto.title}" >
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">Content</label>
						<textarea class="form-control" name="content" rows="3" >${boardDto.content}</textarea>
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Writer</label>
						<input type="text" name="writer" class="form-control" value="${boardDto.writer}" >
					</div>
				</div>
				</form>
				<div class="box-footer">
					<button type="submit" class="btn btn-primary">수정 완료</button>
					<button type="submit" class="btn btn-warning">취 소</button>
				</div>
			</div>
		</div>
	</div>
</section>
<%@include file="../include/footer.jsp" %>
