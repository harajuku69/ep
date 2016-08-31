/**
 * 
 */
$(function() {
	//modal
	var dialog, form,
	kwd = $("#kwd"),
	
	kwdField = $([]).add(kwd),
	tips = $(".validateTips");
	
	function updateTips(t) {
		tips.text(t).addClass("ui-state-highlight");//하일라이트 주는 것
		//위 구문은 tip.text(t).addClass("ui-state-highlight");와 동일한 구문임
		//ui-state-highlight는 내장되어 있는 클래스임. jquery-ui.min.css 요기에
		setTimeout(function() {
			tips.removeClass("ui-state-highlight", 2500);//하일라이트 없어지는 것
		}, 500 );
	}
	
	function checkLength(o, min, max) {
		if (o.val().length > max || o.val().length < min) {
			o.addClass("ui-state-error");
			updateTips("동(읍/면) 이름은 최소 " + min + " ~ " + max + "자 까지 입력해주세요." );
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
	
	function zipcdsch() {
		var valid = true;
		kwdField.removeClass( "ui-state-error" );
		
		valid = checkLength(kwd, 2, 10 );
		valid = valid && checkRegexp(kwd, /^[가-힣]([가-힣0-9])*$/, "동(읍/면) 이름은 한글과 숫자로 공백없이 입력해주세요.");
		if ( valid ) {
			$("#zipcdschRs tbody" ).append( "<tr>" +
			"<td>" + zipcd.val() + "</td>" +
			"<td>" + sido.val() + "</td>" +
			"<td>" + gugun.val() + "</td>" +
			"<td>" + dong.val() + "</td>" +
			"<td>" + ri.val() + "</td>" +
			"<td>" + bldg.val() + "</td>" +
			"<td>" + bunji.val() + "</td>" +
			"<td><a href='staff.do?cmd=get_zipcd&no=${edu.no}'>선 택</a></td>" +
			"</tr>" );
			dialog.dialog("close");
		}
		return valid;
	}
	
	dialog = $("#zip-dialog").dialog({
		autoOpen: false,
		width: 950,
		height: 500,
		modal: true,
		buttons: {
			"검 색": zipcdsch,
			"취 소": function() {
				dialog.dialog("close");
			}
		},
		close: function() {
			form[0].reset();
			kwdField.removeClass("ui-state-error");
		}
	});
	
	form = dialog.find("form").on("submit", function(event) {
		event.preventDefault();
		zipcdsch();
	});
	
	$("#zipcdschbtn").button().on("click", function() {
		dialog.dialog("open");
	});
	
});

function use(){
	frm.zipcd.value = zipcd.val();
}