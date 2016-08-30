/**
 * Tab setting : tab + modal
 */
$(function() {
	//modal
	var dialog, form,
	location = $("#location"),
	school = $("#school"),
	major = $("#major"),
	startdt = $("#startdt"),
	enddt = $("#enddt"),
	//추후 프로젝트 등록에 관한
	
	eduAllFields = $([]).add(location).add(school).add(major).add(startdt).add(enddt),
	tips = $(".validateTips");
	
	function updateTips( t ) {
		tips.text(t).addClass("ui-state-highlight");//하일라이트 주는 것
		//위 구문은 tip.text(t).addClass("ui-state-highlight");와 동일한 구문임
		//ui-state-highlight는 내장되어 있는 클래스임. jquery-ui.min.css 요기에
		setTimeout(function() {
			tips.removeClass("ui-state-highlight", 2500);//하일라이트 없어지는 것
		}, 500 );
	}
	
	function checkLength(o, n, min, max) {
		if (o.val().length > max || o.val().length < min) {
			o.addClass("ui-state-error");
			updateTips( n + "은(는) " + min + " ~ " + max + "자 까지 입력해주세요." );
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
	
	function addItem() {
		var valid = true;
		eduAllFields.removeClass( "ui-state-error" );
		valid = checkLength(location, "지역", 2, 30 );
		valid = valid && checkLength(school, "학교 이름", 2, 30 );
		valid = valid && checkLength( major, "전공", 2, 20 );
		
		valid = valid && checkRegexp( location, /^[가-힣a-z]([가-힣0-9a-z_\s])+$/i, "지역은 2~16자 이내로 작성해주세요." );
		valid = valid && checkRegexp( school, /^[가-힣a-z]([가-힣0-9a-z_\s])+$/i, "학교 이름은 2~15자 이내로 작성해주세요." );
		valid = valid && checkRegexp( major, /^[가-힣a-z]([가-힣0-9a-z_\s])+$/i, "전공(고등학교:문과/이과)은 2~10자 이내로 작성해주세요." );
		if ( valid ) {
			$("#edu tbody" ).append( "<tr>" +
			"<td>" + location.val() + "</td>" +
			"<td>" + school.val() + "</td>" +
			"<td>" + major.val() + "</td>" +
			"<td>" + startdt.val() + "</td>" +
			"<td>" + enddt.val() + "</td>" +
			"<td><a href='Servlet.do?code=${edu.no}'>수 정</a></td>" +
			"<td><a href='Servlet.do?code=${edu.no}'>삭 제</a></td></td>" +
			"</tr>" );
			dialog.dialog("close");
		}
		return valid;
	}
	
	dialog = $("#edu-dialog, #crr-dialog, #certi-dialog").dialog({
		autoOpen: false,
		height: 900,
		width: 400,
		modal: true,
		buttons: {
			"추가": addItem,
			"취소": function() {
				dialog.dialog("close");
			}
		},
		close: function() {
			form[0].reset();
			eduAllFields.removeClass("ui-state-error");
		}
	});
	
	form = dialog.find("form").on("submit", function(event) {
		event.preventDefault();
		addItem();
	});
	
	$("#add-edu,#add-crr,#add-certi").button().on("click", function() {
		dialog.dialog("open");
	});
	
	$( "#tabs" ).tabs();
});
