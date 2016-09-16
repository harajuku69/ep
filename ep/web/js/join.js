/**
 * 
 */
function chkJoin(){
//	if(($("#agree").val() != "1")){
//		alert("사용약관에 동의해야 가입이 가능합니다.");
//		$("#agree").focus();
//		return false;
//	}
	if(isNull($("#name").val().trim())){
		alert("이름을 입력해주세요.");
//		$("#notify").text("주민번호 앞자리를 입력해주세요.");
		$("#name").focus();
		return false;
	}
	if(isNull($("#juminf").val().trim())){
		alert("주민번호 앞자리를 입력해주세요.");
//		$("#notify").text("주민번호 앞자리를 입력해주세요.");
		$("#juminf").focus();
		return false;
	}
	if(isNaN($("#juminf").val())){
		alert("주민번호 앞자리는 숫자로 입력해야 합니다.");
		$("#juminf").val("");
		$("#juminf").focus();
		return false;
	} 
	if(($("#juminf").val().trim().length < 6)){
		alert("주민번호 앞자리는 6자리(yymmdd)로 입력해야 합니다.");
		$("#juminf").focus();
		return false;
	}
	if(isNull($("#juminb").val().trim())){
		alert("주민번호 뒷자리를 입력해주세요.");
		$("#juminb").focus();
		return false;
	}
	if(isNaN($("#juminb").val())){
		alert("주민번호 뒷자리는 숫자로 입력해야 합니다.");
		$("#juminb").val("");
		$("#juminb").focus();
		return false;
	} 
	if(($("#juminb").val().trim().length < 7)){
		alert("주민번호 뒷자리는 7자리로 입력해야 합니다.");
		$("#juminb").focus();
		return false;
	}
	if(isNull($("#pwd").val().trim())){
		alert("비밀번호를 입력해주세요.");
		$("#pwd").focus();
		return false;
	}
	if(isNull($("#pwd_re").val().trim())){
		alert("비밀번호(재입력)를 입력해주세요.");
		$("#pwd_re").focus();
		return false;
	}
	if(($("#pwd").val()) != ($("#pwd_re").val())){
		alert("비밀번호가 일치하지 않습니다! 다시 입력해주세요.");
		$("#pwd").val("");
		$("#pwd_re").val("");
		$("#pwd").focus();
		$("#same").text("");
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

$(function(){
	$("#name").focusout(function(){
		if(($("#name").val().trim().length == 0)){
			$("#alarm").css("color","red").css("font-weight","bold");
			$("#alarm").text("이름을 입력해주세요");
			$("#name").val("");
			$("#name").focus();
			return false;
		}
		if(!(/^[가-힣a-z]([가-힣a-z])*$/.test($("#name").val()))){
			$("#alarm").css("color","red").css("font-weight","bold");
			$("#alarm").text("한글/영문으로만 입력해주세요");
			$("#name").val("");
			$("#name").focus();
			return false;
		}
	});

	$("#name").focus(function(){
		setTimeout("$('#alarm').text('')",3500);	
	});
	
	$("#pwd_re").keydown(function(){
		$("#same").css("color","red").css("font-weight","bold").css("font-size","13px");;
		$("#same").text("비밀번호가 일치하지 않습니다!");
	});
	
	$("#pwd_re").keyup(function(){
		if(($("#pwd").val() > 0) && ($("#pwd").val()) == ($("#pwd_re").val())){
			$("#same").css("color","green").css("font-weight","bold").css("font-size","16px");
			$("#same").text("비밀번호가 일치합니다.");
		}
	});
});









