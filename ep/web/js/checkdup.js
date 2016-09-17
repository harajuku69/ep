/**
 * 
 */
//var tips;

$(function(){
	tips = $(".validateTips");
});

function updateTips(t) {
	tips.text(t).addClass("ui-state-highlight");//하일라이트 주는 것
	setTimeout(function() {
		tips.removeClass("ui-state-highlight", 2500);//하일라이트 없어지는 것
	}, 500 );
}

function checkLength(o, min, max) {
	if (o.val().length > max || o.val().length < min) {
		o.addClass("ui-state-error");
		updateTips("최소 " + min + " ~ " + max + "자 까지 입력하세요.");
		return false;
	} 
	return true;
}
function checkJmLength(o, fit) {
	if (o.val().length < fit) {
		o.addClass("ui-state-error");
		updateTips(fit + "자리로 입력하세요.");
		return false;
	}
	return true;
}

function checkRegexp(o, regexp) {
	if (!(regexp.test(o.val()))) {
		o.addClass("ui-state-error");
		updateTips("영문(대소)/숫자로 공백없이 입력하세요.");
		return false;
	}
	return true;
}
function checkJmRegexp(o, regexp) {
	if (!(regexp.test(o.val()))) {
		o.addClass("ui-state-error");
		updateTips("숫자만 공백없이 입력하세요.");
		return false;
	}
	return true;
}

$(function() {
	var dialog, form;
	
		dialog = $("#jm-dialog").dialog({
			autoOpen: false,
			width: 350,
			height: 400,
			modal: true,
			buttons: {
				"검사": chkJm,
				"확인": function(){
					if(isNaN($("#jmChkRs").text())){
						$("#juminf").val($("#jmfchk").val());
						$("#juminb").val($("#jmbchk").val());
					}
					dialog.dialog("close");
				}
			},
			close: function() {
				form[0].reset();
				jmFields.removeClass("ui-state-error");
			}
		});
		
	form = dialog.find("form").on("submit", function(event) {
		event.preventDefault();
		chkJm();
		return false;
	});
	
	$("#chkjmbtn").button().on("click", function() {
//		refresh();
		$("#juminf, #juminb").val("");
		$("#jmfchk, #jmbchk").val("");
		$("#jmChkRs").text("");
		jmFields.removeClass("ui-state-error");
		tips.removeClass("ui-state-highlight", 0);
		tips.text("회원가입 중복 검사가 필요합니다.");
		$("#jm-dialog").dialog("open");
	});
	
	var jmf = $("#jmfchk"),
		jmb = $("#jmbchk"),
		
	jmFields = $([]).add(jmf).add(jmb);
	
	function chkJm() {
		var	valid = true,
			url = "staff.do?cmd=check_jumin";
		
		jmFields.removeClass("ui-state-error");
		
		valid = checkJmRegexp(jmf, /^[0-9]*$/ );
		valid = valid && checkJmLength(jmf, 6);
		
		valid = valid && checkJmRegexp(jmb, /^[0-9]*$/ );
		valid = valid && checkJmLength(jmb, 7);
		if ( valid ) {
			$.ajax({
				url:url,
//				data: "pwd="+pwd.val(), <= 아래와 동일한 구문임.
				data: {"jmf":jmf.val(), "jmb":jmb.val()},
				dataType:"json",
				type:'post',
				contentsType: "application/x-www-form-urlencoded; charset=UTF-8",
				success:function(json){
					if(json.result == '0'){
						msg = "회원가입이 가능합니다.";
						$("#jmfchk").val(json.jmf);
						$("#jmbchk").val(json.jmb);
						$("#jmChkRs").text(msg);
					} else {
						msg = "이미 등록되어 있는 회원입니다. 다시 입력해주세요."
						$("#jmfchk").val("");
						$("#jmbchk").val("");
						$("#jmChkRs").text(msg);
					}
				}
			});
		}
	}
	
});

$(function() {
	var dialog, form;
	
	dialog = $("#id-dialog").dialog({
		autoOpen: false,
		width: 350,
		height: 320,
		modal: true,
		buttons: {
			"검사": chkId,
			"확인": function(){
				if(isNaN($("#idChkRs").text())){
					$("#empid").val($("#idchk").val());
				}
				dialog.dialog("close");
//				refresh();
			}
		},
		close: function() {
			form[0].reset();
			idField.removeClass("ui-state-error");
//			refresh();
		}
	});

	form = dialog.find("form").on("submit", function(event) {
		event.preventDefault();
		chkId();
		return false;
	});
	
	$("#chkid").button().on("click", function() {
//		refresh();
		$("#empid").val("");
		$("#idchk").val("");
		$("#idChkRs").text("");
		idField.removeClass("ui-state-error");
		tips.removeClass("ui-state-highlight", 0);
		tips.text("아이디 중복 검사가 필요합니다.");
		$("#id-dialog").dialog("open");
	});
	
	var id = $("#idchk"),
	
	idField = $([]).add(id);
	
	function chkId() {
		var url = "staff.do?cmd=check_id";
		var valid = true;
		
		idField.removeClass("ui-state-error");
		valid = checkLength(id, 2, 30 );
		valid = valid && checkRegexp(id, /^[가-힣a-z0-9]([가-힣a-z0-9])*$/ );
		if ( valid ) {
			$.ajax({
				url:url,
//				data: "pwd="+pwd.val(), <= 아래와 동일한 구문임.
				data: {"id":id.val()},
				dataType:"json",
				type:'post',
				contentsType: "application/x-www-form-urlencoded; charset=UTF-8",
				success:function(json){
					if(json.result == '0'){
						msg = "은/는 사용 가능합니다.";
						$("#idchk").val(json.empid);
						$("#idChkRs").text(json.empid + msg);
					} else {
						msg = "은/는 이미 사용중입니다. 다시 입력해주세요."
						$("#idchk").val("");
						$("#idChkRs").text(json.empid + msg);
					}
				}
			});
		}
//		refresh();
//		return valid;
	}
	
});