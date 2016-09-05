$(function() {
	var dialog, form,
	emailRegex = /^[가-힣a-zA-Z0-9.!#$%&'*+\/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$/,
	name = $("#memnm"),
	email = $("#mememail"),
	password = $("#mempwd"),
	allFields = $([]).add(name).add(email).add(password),
	tips = $(".validateTips");
	
	function updateTips(t) {
		tips
			.text(t)
			.addClass("ui-state-highlight");//하일라이트 주는 것
		//위 구문은 tip.text(t).addClass("ui-state-highlight");와 동일한 구문임
		//ui-state-highlight는 내장되어 있는 클래스임. jquery-ui.min.css 요기에
		setTimeout(function() {
			tips.removeClass("ui-state-highlight", 1500 );//하일라이트 없어지는 것
		}, 500 );
	}
	
	function checkLength(o, n, min, max) {
		if (o.val().length > max || o.val().length < min ) {
			o.addClass("ui-state-error");
			updateTips(n + "은(는) " + min + "에서 " + max + "까지 입력해주세요.");
			return false;
		} else {
			return true;
		}
	}
	
	function checkRegexp(o, regexp, n) {
		if (!(regexp.test(o.val()))) {
			o.addClass("ui-state-error");
			updateTips(n);
			return false;
		} else {
			return true;
		}
	}
	
	function addUser() {
		var url = "MemberServlet?command=member_insert";
		var valid = true;
		allFields.removeClass("ui-state-error");
		valid = checkLength(name, "이름", 2, 16 );
		valid = valid && checkLength(email, "이메일", 2, 80 );
		valid = valid && checkLength(password, "비밀번호", 2, 16 );
		
		valid = valid && checkRegexp(name, /^[가-힣a-z]([가-힣0-9a-z_\s])+$/i, "이름은 3~16자 이내로 작성해주세요." );
		valid = valid && checkRegexp(email, emailRegex, "eg.ui@jquery.com" );
		valid = valid && checkRegexp(password, /^([0-9a-zA-Z])+$/, "Password는 영문자 소문자, 숫자 5~16 허용합니다.");
		
		if (valid) {
			/*$("#frm").submit();
			form[0].submit();
			요것도 동일한 기능을 함.*/
			/*var d = $("#frm").serialize();*/
			$.ajax({
				url:url,
				data:'memnm='+name.val()+'&mememail='+email.val()+'&mempwd='+password.val(),
				/*data:d,*/
//				dataType:"json",
				type:'post',
				contentType: "application/x-www-form-urlencoded; charset=UTF-8",
				success:function(json){
					data = JSON.parse(json);
					$( "#users tbody" ).append(
					"<tr class='" + data.no + "'>" +
					"<td>" + data.no + "</td>" +
					"<td>" + data.memnm + "</td>" +
					"<td>" + data.mememail + "</td>" +
					"<td>" + data.mempwd + "</td>" +
					"<td width='50px'><button id='delete-user' onclick='deleteUser(" +
					data.no
					+ ");'>삭제</button></td>" +
					"</tr>" );
				}
			});
			dialog.dialog("close");
		}
		return valid;
	}
	
	dialog = $("#dialog-form").dialog({
		autoOpen: false,
		height: 350,
		width: 350,
		modal: true,
		buttons: {
			"계정 등록": addUser,
			"취소": function() {
			dialog.dialog("close");
			}
		},
		close: function() {
			form[0].reset();
			allFields.removeClass("ui-state-error");
		}
	});
	
	form = dialog.find("form").on("submit", function(event) {
		/*event.preventDefault();*/
		addUser();
		return false;
	});

	$("#create-user").button().on("click", function() {
		dialog.dialog("open");
	});
	
	
});
function deleteUser(no){
	url = "MemberServlet?command=member_delete&no=" + no;
	delno = "."+ no;//클래스로 선언된 tr만 지울라고 .을 추가하는 것임
	$("tr").remove(delno);
	$.ajax({
		url:url,
		type:"get",
		success:function(msg){
			alert("정상삭제되었습니다.");
		}
	});
};

