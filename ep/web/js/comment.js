/**
 * ajax 
 */

function addCmt() {
	if(isNull($("#ctt").val().trim())){
		alert("댓글을 입력해주세요");
		$("#ctt").val("");
//		$("#pwd").focus();
		return false
	}
	if(isNull($("#pwd").val().trim())){
		alert("비밀번호를 입력해주세요");
		$("#pwd").val("");
//		$("#pwd").focus();
		return false
	}
	if(isNaN($("#pwd").val())){
		alert("비밀번호는 숫자로 입력해주세요");
		$("#pwd").val("");
		return false
	}
	var	notino = $("#notino").val(),
	 	ctt = $("#ctt").val(),
	 	pwd = $("#pwd").val();
		url = "noti.do?cmd=cmt_write"; 
	$.ajax({
		url: url,
		data: 'notino=' + notino + '&ctt=' + ctt + '&pwd='+ pwd,
		type:'post',
		contentsType: "application/x-www-form-urlencoded; charset=UTF-8",
		success:function(){
//			data = JSON.parse(result);
//			$("#cmttab tbody").prepend(
//					"<tr class='" + data.cmtno + "'>" +
//					"<td>" + data.cmtno + "</td>" +
//					"<td>" + data.admnm + "</td>" +
//					"<td>" + data.ctt + "</td>" +
//					"<td>" + data.regdt + "</td>" +
//					/*"<td><a href='noti.do?cmd=edu_delete&no=${edu.no}'>삭 제</a></td>" +*/
//					"<td><a href='#'>삭 제</a></td>" +
//					"</tr>" );
			alert("댓글이 등록되었습니다.");
			history.go(0);
		}
	});
}

function isNull(obj){
	return (typeof obj != "undefined" && obj != null && obj.trim() != "") ? false : true;
}

String.prototype.trim = function() {
    return this.replace(/(^\s*)|(\s*$)/gi, "");
}
