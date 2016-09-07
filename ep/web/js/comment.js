/**
 * ajax 
 */
//$(function() {
//$(function(){
//	$("#admfrm").on("submit",function(e){
//		e.preventDefault();
//	});
//});
	function addCmt() {
		var	notino = $("#notino").val(),
		 	ctt = $("#ctt").val(),
		 	pwd = $("#pwd").val();
//		 alert(notino+ctt+pwd);
		url = "noti.do?cmd=admin_cmt_write"; 
//		console.log(url);
		$.ajax({
			url: url,
			data: 'notino=' + notino + '&ctt=' + ctt + '&pwd='+ pwd,
			type:'post',
			contentsType: "application/x-www-form-urlencoded; charset=UTF-8",
			success:function(result){
				data = JSON.parse(result);
				$("#cmttab tbody").prepend(
						"<tr class='" + data.cmtno + "'>" +
						"<td>" + data.cmtno + "</td>" +
						"<td>" + data.admnm + "</td>" +
						"<td>" + data.ctt + "</td>" +
						"<td>" + data.regdt + "</td>" +
						"<td><a href='noti.do?cmd=edu_delete&no=${edu.no}'>삭 제</a></td></td>" +
						"</tr>" );
				alert("댓글이 등록되었습니다.");
				history.go(0);
			}
		});
	}
//});

/*$(function() {
	$("#admfrm").on("submit",function(){
//		notino = no;
//		ctt = $("#ctt");
//		pwd = $("#pwd");
		var d = $(this).serialize();
		$.ajax({
			url: "noti.do?cmd=admin_cmt_write",
			data: d,
//			dataType:"json",
			type:'post',
			contentsType: "application/x-www-form-urlencoded; charset=UTF-8",
			success:function(json){
				data = JSON.parse(json);
//				console.log(data.cmtno);
				$("#cmttab tbody").append(
						"<tr class='" + data.cmtno + "'>" +
						"<td>" + data.admnm + "</td>" +
						"<td>" + data.ctt + "</td>" +
						"<td>" + data.regdt + "</td>" +
						"<td><a href='noti.do?cmd=edu_update&no=${edu.no}'>수 정</a></td>" +
						"<td><a href='noti.do?cmd=edu_delete&no=${edu.no}'>삭 제</a></td></td>" +
				"</tr>" ),
				alert("댓글이 등록되었습니다.");
			}
		});
	});
});*/