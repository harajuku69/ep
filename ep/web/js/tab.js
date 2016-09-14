/**
 * Tab setting : tab + modal
 */
$(function() {
	//tabs
	tips = $(".validateTips");
	var tabs = $( "#tabs" ).tabs();
	tabs.find( ".ui-tabs-nav" ).sortable({
		axis: "x",
		stop: function() {
			tabs.tabs( "refresh" );
		}
	});
});

var tips;

function updateTips(t) {
//	alert(t);
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
		updateTips("한글/영문(대소)/숫자로 공백없이 입력하세요.");
		return false;
	} else {
		return true;
	}
}

$(function() {
	//modal
	var dialog, form;
	
	dialog = $("#edu-dialog").dialog({
		autoOpen: false,
		width: 400,
		height: 750,
		modal: true,
		buttons: {
			"추가": addEdu,
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
		addEdu();
		return false;
	});
	
	$("#add-edu").button().on("click", function() {
		$("#edu-dialog").dialog("open");
	});
	
	var loc = $("#loc"),
		school = $("#school"),
		major = $("#major"),
		enterdt = $("#enterdt"),
		graddt = $("#graddt"),
	
	eduAllFields = $([]).add(loc).add(school).add(major).add(enterdt).add(graddt);
		
	function addEdu() {
		var valid = true;
			d = $("#frm_edu").serialize(),
			url = "staff.do?cmd=edu_add";
		//학력 추가 처리
		eduAllFields.removeClass("ui-state-error");
		valid = checkLength(loc, 2, 30 );
		valid = valid && checkRegexp( loc, /^[가-힣a-z0-9]([가-힣a-z0-9])*$/ );
		
		valid = valid && checkLength( school, 2, 30 );
		valid = valid && checkRegexp( school, /^[가-힣a-z0-9]([가-힣a-z0-9])*$/ );
		
		valid = valid && checkLength( major, 2, 20 );
		valid = valid && checkRegexp( major, /^[가-힣a-z0-9]([가-힣a-z0-9])*$/ );
		if ( valid ) {
			$.ajax({
				url:url,
				data:d,
//				dataType:"json",
				type:'post',
				contentsType: "application/x-www-form-urlencoded; charset=UTF-8",
				success:function(result){
					data = JSON.parse(result);
					$("#edu tbody").prepend( 
						"<tr class='" + data.eduno + "'>" +
						"<td>" + data.loc + "</td>" +
						"<td>" + data.school + "</td>" +
						"<td>" + data.major + "</td>" +
						"<td>" + data.enterdt +
//							 " <c:set var='enterdt' value='" + data.enterdt + "'/>" +
//							 " <c:out value='${fn:substring(enterdt, 0, 10)}'/>" +
						"</td>" +
						"<td>" + data.graddt +
//							 "<c:set var='graddt' value='" + data.graddt + "'/>" +
//							 "<c:out value='${fn:substring(graddt, 0, 10)}'/>" +		
						"</td>" +
//						"<td>" + data.graddt + "</td>" +
//						"<td><a href='staff.do?cmd=edu_update&no=${edu.no}'>수 정</a></td>" +
						"<td><a href='staff.do?cmd=edu_delete&no=${edu.no}'>삭 제</a></td>" +
						"</tr>" );
//					alert("정상 등록되었습니다.");
					$("#edu-dialog").dialog("close");
				}
			});
		}
		return valid;
	}
	
});


$(function() {
	//modal
	var dialog, form;
	
	dialog = $("#crr-dialog").dialog({
		autoOpen: false,
		width: 400,
		height: 750,
		modal: true,
		buttons: {
			"추가": addCrr,
			"취소": function() {
				dialog.dialog("close");
			}
		},
		close: function() {
			form[0].reset();
			crrAllFields.removeClass("ui-state-error");
		}
	});
	
	form = dialog.find("form").on("submit", function(event) {
		event.preventDefault();
		addCrr();
		return false;
	});
	
	$("#add-crr").button().on("click", function() {
		$("#crr-dialog").dialog("open");
	});
	
	var comnm = $("#comnm"),
		dpt = $("#dpt"),
		tit = $("#tit"),
		empdt = $("#empdt"),
		outdt = $("#outdt"),
		crrAllFields = $([]).add(comnm).add(dpt).add(tit).add(empdt).add(outdt);
		
	function addCrr() {
		var valid = true;
		//경력 추가 처리
		crrAllFields.removeClass("ui-state-error");
		valid = checkLength(comnm, 2, 30 );
		valid = valid && checkRegexp(comnm, /^[가-힣a-z0-9]([가-힣a-z0-9])*$/ );
		
		valid = valid && checkLength(dpt, 2, 30 );
		valid = valid && checkRegexp(dpt, /^[가-힣a-z0-9]([가-힣a-z0-9])*$/ );
		
		valid = valid && checkLength(tit, 2, 20 );
		valid = valid && checkRegexp(tit, /^[가-힣a-z0-9]([가-힣a-z0-9])*$/ );
		
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
		return valid;
	}
	
});

$(function() {
	//modal
	var dialog, form;
	
	dialog = $("#certi-dialog").dialog({
		autoOpen: false,
		width: 400,
		height: 750,
		modal: true,
		buttons: {
			"추가": addCerti,
			"취소": function() {
				dialog.dialog("close");
			}
		},
		close: function() {
			form[0].reset();
			certiAllFields.removeClass("ui-state-error");
		}
	});
	
	form = dialog.find("form").on("submit", function(event) {
		event.preventDefault();
		addCerti();
		return false;
	});
	
	$("#add-certi").button().on("click", function() {
		$("#certi-dialog").dialog("open");
	});
	
	var certinm = $("#certinm"),
		rank = $("#rank"),
		publ = $("#publ"),
		regdt = $("#regdt"),
		expdt = $("#expdt"),
		certiAllFields = $([]).add(certinm).add(rank).add(publ).add(regdt).add(expdt);
	function addCerti() {
		var valid = true;
		//자격증 추가 처리
		certiAllFields.removeClass("ui-state-error");
		valid = checkLength(certinm, 2, 30 );
		valid = valid && checkRegexp(certinm, /^[가-힣a-z0-9]([가-힣a-z0-9])*$/ );
		
		valid = valid && checkLength(rank, 2, 30 );
		valid = valid && checkRegexp(rank, /^[가-힣a-z0-9]([가-힣a-z0-9])*$/ );
		
		valid = valid && checkLength(publ, 2, 20 );
		valid = valid && checkRegexp(publ, /^[가-힣a-z0-9]([가-힣a-z0-9])*$/ );
		
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
	
});
