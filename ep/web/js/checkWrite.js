/**
 * 
 */

function checkWrite(){
	var j = 0, k = 0;
	for(var i=0;i < $(".webchkbx").length;i++){
		if($(".webchkbx").eq(i).is(":checked")){
			j++;
		}
		if($(".svrchkbx").eq(i).is(":checked")){
			k++;
		}
	}
//	alert("web sel : "+j);
//	alert("svr sel : "+k);
	if(j < 1){
//		alert("web");
		alert("Web 영역 스킬은 최소 1개 이상 선택해야 합니다.");
		$(".webchkbx").eq(0).focus();
		return false
	}
	if(k < 1){
//		alert("svr");
		alert("Server 영역 스킬은 최소 1개 이상 선택해야 합니다.");
		$(".svrchkbx").eq(0).focus();
		return false
	}
	if(isNull($("#plnm").val().trim())){
		alert("프로젝트 리더를 입력해주세요!");
		$("#plschbtn").focus();
		return false;
	}
	return true;
}

function isNull(obj){
	return (typeof obj != "undefined" && obj != null && obj.trim() != "") ? false : true;
}

String.prototype.trim = function() {
    return this.replace(/(^\s*)|(\s*$)/gi, "");
}	