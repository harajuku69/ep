<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
<script>
$(function(){
	var formObj = $("form[role='form']");
	console.log(formObj);
	$(".btn-warning").on("click", function(){
		formObj.attr("method", "get");		
		formObj.attr("action", "/board/modifyPage");
		formObj.submit();
	});
	$(".btn-danger").on("click", function(){
		formObj.attr("action", "/board/removePage");
		formObj.submit();
	});
	$(".btn-primary").on("click", function(){
		formObj.attr("method", "get");
		formObj.attr("action", "/board/listPage");
		formObj.submit();
	});
});
</script>
<section class="content">
      <div class="row">
      	<div class="col-md-12">
        	<div class="box box-primary">
        		<div class="box-header">
          			<h3 class="box-title">글 상세보기</h3>
	 				<form role="form" action="modifyPage" method="post">
					    <input type='hidden' name='bno' value ="${boardDto.bno}">
					    <input type='hidden' name='page' value ="${cri.page}">
					    <input type='hidden' name='perPageNum' value ="${cri.perPageNum}">
					</form>
				</div>   
  				<div class="box-body">
				    <div class="form-group">
				      <label for="exampleInputEmail1">Title</label>
				      <input type="text" name='title' class="form-control" value="${boardDto.title}" readonly>
				    </div>
    				<div class="form-group">
				      <label for="exampleInputPassword1">Content</label>
				      <textarea class="form-control"  name="content" rows="3" readonly>${boardDto.content}</textarea>
				    </div>
				    <div class="form-group">
				      <label for="exampleInputEmail1" >Writer</label>
				      <input type="text" name="writer" class="form-control" value="${boardDto.writer}" readonly>
				    </div>
			   </div><!-- /.box-body -->
			   <div class="box-footer">
			      <button type="submit" class="btn btn-warning">수 정</button>
			      <button type="submit" class="btn btn-danger">삭 제</button>
			      <button type="submit" class="btn btn-primary">목록으로</button>
			   </div>
        </div><!-- /.box -->
      </div><!--/.col (left) -->
      </div>   <!-- /.row -->
    </section><!-- /.content -->
<%@include file="../include/footer.jsp" %>
 