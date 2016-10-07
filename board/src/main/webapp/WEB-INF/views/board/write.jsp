<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="../include/header.jsp" %>
<script>
$(function(){
	var formObj = $("form[role='form']");
	$(".btn-warning").on("click", function(){
		formObj.attr("method", "get");
		formObj.attr("action", "/board/listPage");
		formObj.submit();
	});
});
</script>
<section class="content">
	<div class="row">
		<div class="col-md-12">
			<div class="box">
				<div class="box-header with-border">
					<h3 class="box-title">게시판 등록</h3>
				</div>
				<form role="form" method="post">
					<div class="box-body">
						<div class="form-group">
							<label for="exampleInputEmail1">제목</label>
							<input type="text" name="title" class="form-control" placeholder="제목을 입력하세요">
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">내용</label>
							<textarea class="form-control" name="content" row="3" placeholder="내용을 입력하세요"></textarea>
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">작성자</label>
							<input type="text" name="writer" class="form-control" placeholder="작성자를 입력하세요">
						</div>
					</div>
					<div class="box-footer">
						<button type="submit" class="btn btn-primary">작성 완료</button>
						<button type="submit" class="btn btn-warning">취 소</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</section>
<%@include file="../include/footer.jsp" %>
