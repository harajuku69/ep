/**
 *  check validation of phone/salary
 */

function chkPhone(){
	if(isNaN($("#phone").val())){
		alert("연락처는 숫자만 입력해야 합니다.");
		$("#phone").val("");
		$("#phone").focus();
		return false;
	}
	if($("#phone").val().trim().length  < 10){
//		console.log($("#phone").val().trim().length);
		alert("연락처는 10~11자리 숫자로 입력해야 합니다.");
		$("#phone").focus();
		return false;
	}
	return true;
}

function chkSal(){
	if(isNaN($("#sal").val())){
		alert("급여는 숫자만 입력해야 합니다.");
		$("#sal").val("");
		$("#sal").focus();
		return false;
	}
	return true;
}

String.prototype.trim = function() {
  return this.replace(/(^\s*)|(\s*$)/gi, "");
}
