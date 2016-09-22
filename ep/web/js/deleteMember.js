/**
 * delete function
 */
function deleteItem(field, item){
	delno = "."+ item;//클래스로 선언된 tr만 지울라고 .을 추가하는 것임
	url = "staff.do?cmd=staff_delete&empno=" + item;
	if(field == "noti"){
		url = "noti.do?cmd=noti_delete&notino=" + item;
	} else if(field == "pjt"){
		url = "pjt.do?cmd=pjt_delete&pjtno=" + item;
	} else if(field == "cmt"){
		url = "noti.do?cmd=cmt_delete&cmtno=" + item;
	} else if(field == "edu"){
		url = "staff.do?cmd=edu_delete&eduno=" + item;
	} else if(field == "crr"){
		url = "staff.do?cmd=crr_delete&crrno=" + item;
	} else if(field == "crt"){
		url = "staff.do?cmd=crt_delete&crtno=" + item;	
	}
	$("tr").remove(delno);
	$.ajax({
		type:"get",
		url:url,
		success:function(msg){
			alert("정상 삭제되었습니다.");
			history.go(0);
		}
	});
};






