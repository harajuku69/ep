/**
 * 
 */
$(function() {
	//modal
	var dialog, 
		pwd = $("#pwd"),
		tips = $(".validateTips");
	
		dialog = $("#pwd-dialog").dialog({
			autoOpen: false,
			width: 400,
			height: 330,
			modal: true,
			buttons: {
				"확인": chkPwd,
			},
			close: function() {
				refresh();
			}
		});
	
	$("#chk_pwd").button().on("click", function() {
		$("#pwd-dialog").dialog("open");
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
	
	function chkPwd() {
		var url = "staff.do?cmd=check_staff_pwd";
		var valid = true;
//			d = $("#pwd").serialize();
		
		pwd.removeClass("ui-state-error");
		valid = checkLength(pwd, 2, 30 );
		valid = valid && checkRegexp(pwd, /^[가-힣a-z0-9]([가-힣a-z0-9])*$/ );
		if ( valid ) {
			$.ajax({
				url:url,
//				data: "pwd="+pwd.val(), <= 아래와 동일한 구문임.
				data: {"pwd":pwd.val()},
//				data:d,
				dataType:"json",
				type:'post',
				contentsType: "application/x-www-form-urlencoded; charset=UTF-8",
				success:function(result){
//					data = JSON.parse(result);
					msg = "비밀번호가 일치합니다. 3초후 자동으로 이동합니다.";
//					var i = 5;
//					var t = setInterval(i--,1000);
//					move = "초후 자동으로 이동합니다.";
					if(result == '1'){
						$("#pwdChkRs").text(msg);
//						for(i=5;i>=0;i--){
//							setTimeout($("#pwdChkRs").text(msg+i+move),1000);
//						}
//						setTimeout($("#pwdChkRs").text(msg+'3'+move),1000);
//						setTimeout($("#pwdChkRs").text(msg+'2'+move),1000);
//						setTimeout($("#pwdChkRs").text(msg+'1'+move),1000);
						setTimeout("location.href='staff.do?cmd=staff_update_page'",3000);
					} else{
						msg = "비밀번호가 일치하지 않습니다. 다시 입력해주세요."
						$("#pwdChkRs").text(msg);
					}
				}
			});
		}
		refresh();
		return valid;
	}
	
});

function refresh(){
	$("#pwd").val("");
	$("#pwdChkRs").text("");
};







