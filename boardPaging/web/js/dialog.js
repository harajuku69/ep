$(function(){
	$("#dialog").dialog();
	$( "#dialog-confirm" ).dialog({
		resizable: true,
		width:500,
		height:340,
		modal: true,
		buttons: {
			"삭제": function() {
				$( this ).dialog( "close" );
			},
			"취소": function() {
				$( this ).dialog( "close" );
			}
		}
	});
});

$(function() {
	var dialog, form,
	emailRegex = /^[가-힣a-zA-Z0-9.!#$%&'*+\/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$/,
	name = $( "#name" ),
	email = $( "#email" ),
	password = $( "#password" ),
	allFields = $( [] ).add( name ).add( email ).add( password ),
	tips = $( ".validateTips" );
	
	function updateTips( t ) {
		tips
			.text( t )
			.addClass( "ui-state-highlight" );//하일라이트 주는 것
		//위 구문은 tip.text(t).addClass("ui-state-highlight");와 동일한 구문임
		//ui-state-highlight는 내장되어 있는 클래스임. jquery-ui.min.css 요기에
		setTimeout(function() {
			tips.removeClass( "ui-state-highlight", 3000 );//하일라이트 없어지는 것
		}, 500 );
	}
	
	function checkLength( o, n, min, max ) {
		if ( o.val().length > max || o.val().length < min ) {
			o.addClass( "ui-state-error" );
			updateTips( n + "은(는) " + min + "에서 " + max + "까지 입력해주세요." );
			return false;
		} else {
			return true;
		}
	}
	
	function checkRegexp( o, regexp, n ) {
		if ( !( regexp.test( o.val() ) ) ) {
			o.addClass( "ui-state-error" );
			updateTips( n );
			return false;
		} else {
			return true;
		}
	}
	
	function addUser() {
		var valid = true;
		allFields.removeClass( "ui-state-error" );
		valid = valid && checkLength( name, "이름", 3, 16 );
		valid = valid && checkLength( email, "이메일", 6, 80 );
		valid = valid && checkLength( password, "비밀번호", 5, 16 );
		
		valid = valid && checkRegexp( name, /^[가-힣a-z]([가-힣0-9a-z_\s])+$/i, "이름은 3~16자 이내로 작성해주세요." );
		valid = valid && checkRegexp( email, emailRegex, "eg. ui@jquery.com" );
		valid = valid && checkRegexp( password, /^([0-9a-zA-Z])+$/, "Password는 영문자 소문자, 숫자 5~16 허용합니다.");
		if ( valid ) {
			$( "#users tbody" ).append( "<tr>" +
			"<td>" + name.val() + "</td>" +
			"<td>" + email.val() + "</td>" +
			"<td>" + password.val() + "</td>" +
			"</tr>" );
			dialog.dialog( "close" );
		}
		return valid;
	}
	
	dialog = $( "#dialog-form" ).dialog({
		autoOpen: false,
		height: 350,
		width: 350,
		modal: true,
		buttons: {
			"계정 등록": addUser,
			"취소": function() {
			dialog.dialog( "close" );
			}
		},
		close: function() {
			form[ 0 ].reset();
			allFields.removeClass( "ui-state-error" );
		}
	});
	
	form = dialog.find( "form" ).on( "submit", function( event ) {
		event.preventDefault();
		addUser();
	});
	$( "#create-user" ).button().on( "click", function() {
		dialog.dialog( "open" );
	});
});
