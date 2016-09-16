/**
 * 
 */

var tips;

function updateTips(t) {
	tips.text(t).addClass("ui-state-highlight");//하일라이트 주는 것
	setTimeout(function() {
		tips.removeClass("ui-state-highlight", 2500);//하일라이트 없어지는 것
	}, 500 );
}

function checkLength(o, min, max) {
	if (o.val().length > max || o.val().length < min) {
		o.addClass("ui-state-error");
		updateTips("최소 " + min + " ~ " + max + "자 까지 입력해주세요.");
		return false;
	} else {
		return true;
	}
}

function checkRegexp(o, regexp) {
	if (!(regexp.test(o.val()))) {
		o.addClass("ui-state-error");
		updateTips("영문(대소)/숫자로 공백없이 입력하세요.");
		return false;
	} else {
		return true;
	}
}
$(function() {
	//modal
	var dialog, 
		id = $("#idchk"),
		tips = $(".validateTips");
	
		dialog = $("#id-dialog").dialog({
			autoOpen: false,
			width: 350,
			height: 350,
			modal: true,
			buttons: {
				"검사": chkId,
				"확인": function(){
					setId(id.val());
					dialog.dialog("close");
				}
			},
			close: function() {
				refresh();
			}
		});
	
	$("#chkid").button().on("click", function() {
		$("#id-dialog").dialog("open");
	});
	
	function chkId() {
		var url = "staff.do?cmd=check_id";
		var valid = true;
		
		id.removeClass("ui-state-error");
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
				success:function(result){
					if(result == '1'){
						msg = "아이디가 사용 가능합니다.";
						$("#idChkRs").text(msg);
					} else{
						msg = "아이디가 이미 사용중입니다. 다시 입력해주세요."
						$("#idChkRs").text(msg);
					}
				}
			});
		}
		refresh();
		return valid;
	}
	
});

function refresh(){
	$("#id").val("");
	$("#idChkRs").text("");
};

function setId(id){
    $("#empid").val(id);
};
