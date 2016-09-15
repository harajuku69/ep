/**
 *  check date blank
 */

function chkdt(){
//	alert("chkdt에 들어옴");
	if(!(isNull($("#from").val())) && isNull($("#to").val()) && isNull($("#tit").val()) && isNull($("#ctt").val())){
		alert("등록일 범위는 from 입력 시 to까지 입력해야 합니다!");
		$("#to").focus();
		return false;
	}
	if( isNull($("#tit").val()) && isNull($("#ctt").val()) && isNull($("#from").val()) && isNull($("#to").val()) ){
		alert("검색어는 하나 이상 입력해야 합니다!");
		$("#tit").focus();
		return false;
	}
}

function isNull(obj){
	return (typeof obj != "undefined" && obj != null && obj.trim() != "") ? false : true;
}

String.prototype.trim = function() {
    return this.replace(/(^\s*)|(\s*$)/gi, "");
}