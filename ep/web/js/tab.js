/**
 * Tab setting : tab + modal
 */
$(function() {
	//tabs
	var tabs = $( "#tabs" ).tabs();
	tabs.find( ".ui-tabs-nav" ).sortable({
		axis: "x",
		stop: function() {
			tabs.tabs( "refresh" );
		}
	});
	//modal
	var dialog, form,
	
	loc = $("#loc"),
	school = $("#school"),
	major = $("#major"),
	enterdt = $("#enterdt"),
	graddt = $("#graddt"),
	eduAllFields = $([]).add(loc).add(school).add(major).add(enterdt).add(graddt),
	
	comnm = $("#comnm"),
	dpt = $("#dpt"),
	tit = $("#tit"),
	empdt = $("#empdt"),
	outdt = $("#outdt"),
	crrAllFields = $([]).add(comnm).add(dpt).add(tit).add(empdt).add(outdt),
	
	certinm = $("#certinm"),
	rank = $("#rank"),
	publ = $("#publ"),
	regdt = $("#regdt"),
	expdt = $("#expdt"),
	certiAllFields = $([]).add(certinm).add(rank).add(publ).add(regdt).add(expdt),
	
	
	tips = $(".validateTips");
	
	function updateTips( t ) {
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
			updateTips( "최소 " + min + " ~ " + max + "자 까지 입력해주세요." );
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
		//학력 추가 처리
		eduAllFields.removeClass("ui-state-error");
		valid = checkLength(loc, 2, 30 );
		valid = valid && checkLength(loc, 2, 30 );
		valid = valid && checkLength( major, 2, 20 );
		
		valid = valid && checkRegexp( loc, /^[가-힣a-z]([가-힣0-9a-z_\s])+$/i, "한글/영문(대소)/숫자로만 입력하세요." );
		valid = valid && checkRegexp( school, /^[가-힣a-z]([가-힣0-9a-z_\s])+$/i, "한글/영문(대소)/숫자로만 입력하세요." );
		valid = valid && checkRegexp( major, /^[가-힣a-z]([가-힣0-9a-z_\s])+$/i, "한글/영문(대소)/숫자로만 입력하세요." );
		if ( valid ) {
			$("#edu tbody").append( "<tr>" +
			"<td>" + loc.val() + "</td>" +
			"<td>" + school.val() + "</td>" +
			"<td>" + major.val() + "</td>" +
			"<td>" + enterdt.val() + "</td>" +
			"<td>" + graddt.val() + "</td>" +
			"<td><a href='staff.do?cmd=edu_update&no=${edu.no}'>수 정</a></td>" +
			"<td><a href='staff.do?cmd=edu_delete&no=${edu.no}'>삭 제</a></td></td>" +
			"</tr>" );
			$("#edu-dialog").dialog("close");
		}
		//경력 추가 처리
		crrAllFields.removeClass("ui-state-error");
		valid = true;
		valid = checkLength(comnm, 2, 30 );
		valid = valid && checkLength(dpt, 2, 30 );
		valid = valid && checkLength(tit, 2, 20 );
		
		valid = valid && checkRegexp(comnm, /^[가-힣a-z]([가-힣0-9a-z_\s])+$/i, "한글/영문(대소)/숫자로만 입력하세요." );
		valid = valid && checkRegexp(dpt, /^[가-힣a-z]([가-힣0-9a-z_\s])+$/i, "한글/영문(대소)/숫자로만 입력하세요." );
		valid = valid && checkRegexp(tit, /^[가-힣a-z]([가-힣0-9a-z_\s])+$/i, "한글/영문(대소)/숫자로만 입력하세요." );
		if ( valid ) {
			$("#crr tbody").append( "<tr>" +
			"<td>" + comnm.val() + "</td>" +
			"<td>" + dpt.val() + "</td>" +
			"<td>" + tit.val() + "</td>" +
			"<td>" + empdt.val() + "</td>" +
			"<td>" + outdt.val() + "</td>" +
			"<td><a href='staff.do?cmd=edu_update&no=${edu.no}'>수 정</a></td>" +
			"<td><a href='staff.do?cmd=edu_delete&no=${edu.no}'>삭 제</a></td></td>" +
			"</tr>" );
			$("#crr-dialog").dialog("close");
		}
		//자격증 추가 처리
		certiAllFields.removeClass("ui-state-error");
		valid = true;
		valid = checkLength(certinm, 2, 30 );
		valid = valid && checkLength(rank, 2, 30 );
		valid = valid && checkLength(publ, 2, 20 );
		
		valid = valid && checkRegexp(certinm, /^[가-힣a-z]([가-힣0-9a-z_\s])+$/i, "한글/영문(대소)/숫자로만 입력하세요." );
		valid = valid && checkRegexp(rank, /^[가-힣a-z]([가-힣0-9a-z_\s])+$/i, "한글/영문(대소)/숫자로만 입력하세요." );
		valid = valid && checkRegexp(publ, /^[가-힣a-z]([가-힣0-9a-z_\s])+$/i, "한글/영문(대소)/숫자로만 입력하세요." );
		if ( valid ) {
			$("#certi tbody").append( "<tr>" +
			"<td>" + certinm.val() + "</td>" +
			"<td>" + rank.val() + "</td>" +
			"<td>" + publ.val() + "</td>" +
			"<td>" + regdt.val() + "</td>" +
			"<td>" + expdt.val() + "</td>" +
			"<td><a href='staff.do?cmd=edu_update&no=${edu.no}'>수 정</a></td>" +
			"<td><a href='staff.do?cmd=edu_delete&no=${edu.no}'>삭 제</a></td></td>" +
			"</tr>" );
			$("#certi-dialog").dialog("close");
		}
		return valid;
	}
	dialog = $("#edu-dialog,#crr-dialog,#certi-dialog").dialog({
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
			form[1].reset();
			form[2].reset();
			eduAllFields.removeClass("ui-state-error");
			crrAllFields.removeClass("ui-state-error");
			certiAllFields.removeClass("ui-state-error");
		}
	});
	
	form = dialog.find("form").on("submit", function(event) {
		event.preventDefault();
		addItem();
	});
	
	$("#add-edu").button().on("click", function() {
		$("#edu-dialog").dialog("open");
	});
	$("#add-crr").button().on("click", function() {
		$("#crr-dialog").dialog("open");
	});
	$("#add-certi").button().on("click", function() {
		$("#certi-dialog").dialog("open");
	});
	
});
