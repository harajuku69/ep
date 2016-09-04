/**
 * delete function
 */
function deleteItem(field, item){
	url = "staff.do?cmd=staff_delete&empno=" + item;
	del = "."+ item;//클래스로 선언된 tr만 지울라고 .을 추가하는 것임
	if(field == "noti"){
		url = "noti.do?cmd=noti_delete&notino=" + item;
		del = "."+ item;
	} else if(field == "pjt"){
		url = "pjt.do?cmd=pjt_delete&=pjtno=" + item;
		del = "."+ item;
	}
	$("tr").remove(del);
	$.ajax({
		type:"get",
		url:url,
		success:function(msg){
			alert("정상 삭제되었습니다.");
		}
	});
};