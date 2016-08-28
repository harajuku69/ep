/*$(function(){
	$("#dialog").dialog();
	$( "#dialog-confirm" ).dialog({
		resizable: true,
		width:500,
		height:500,
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
});*/
//header accordion 설정 jq_ui
$(function() {
    $("#accordion").accordion({
      collapsible: true,
      /*disable:true,*/
      event:"mouseover"
    });
});

//datepicker 설정 jq_ui
$(function() {
    var dateFormat = "yy/mm/dd",
      from = $("#from, #startdt, #regdt" )
        .datepicker({
        	dateFormat:"yy/mm/dd",
        	defaultDate: "+1w",
        	changeMonth: true,
        	changeYear: true,
        	numberOfMonths: 1,
        	yearRange: '1980:2020'
        })
        .on("change", function() {
          to.datepicker( "option", "minDate", getDate( this ) );
        }),
      to = $("#to, #enddt, #expdt" ).datepicker({
    	  dateFormat:"yy/mm/dd",
    	  defaultDate: "+1w",
    	  changeMonth: true,
    	  changeYear: true,
    	  numberOfMonths: 1,
    	  yearRange: '1980:2020'
      })
      .on("change", function() {
        from.datepicker( "option", "maxDate", getDate( this ) );
      });
 
    function getDate( element ) {
      var date;
      try {
        date = $.datepicker.parseDate( dateFormat, element.value );
      } catch( error ) {
        date = null;
      }
 
      return date;
    }
  } );

//Tab영역 설정 jq_ui
$(function() {
	var tabs = $("#tabs").tabs();
    tabs.find(".ui-tabs-nav").sortable({
    	axis: "x",
    	stop: function(){
    		tabs.tabs("refresh");
    	}
    });
});
//Tab영역 modal 처리 jq_ui
$(function() {
	var dialog, form,
	location = $("#location"),
	school = $("#school"),
	major = $("#major"),
	startdt = $("#startdt"),
	enddt = $("#enddt"),
	/*comnm = $("#comnm"),
	dpt = $("#dpt"),
	tit = $("#tit"),
	empdt = $("#empdt"),
	transdt = $("#transdt"),
	certinm = $("#certinm"),
	rank = $("#rank"),
	publ = $("#publ"),
	regdt = $("#regdt"),
	expdt = $("#expdt"),*/
	
	eduAllFields = $([]).add(location).add(school).add(major).add(startdt).add(enddt),
//	careerAllFields = $([]).add(comnm).add(dpt).add(tit).add(empdt).add(transdt),
//	certiAllFields = $([]).add(certinm).add(rank).add(publ).add(regdt).add(expdt),
	tips = $(".validateTips");
	
	function updateTips( t ) {
		tips
			.text( t )
			.addClass( "ui-state-highlight" );//하일라이트 주는 것
		//위 구문은 tip.text(t).addClass("ui-state-highlight");와 동일한 구문임
		//ui-state-highlight는 내장되어 있는 클래스임. jquery-ui.min.css 요기에
		setTimeout(function() {
			tips.removeClass("ui-state-highlight", 2500);//하일라이트 없어지는 것
		}, 500 );
	}
	
	function checkLength( o, n, min, max ) {
		if ( o.val().length > max || o.val().length < min ) {
			o.addClass( "ui-state-error" );
			updateTips( n + "은(는) " + min + " ~ " + max + "자리로 입력해주세요." );
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
	
	function addEdu() {
		var valid = true;
		eduAllFields.removeClass( "ui-state-error" );
		valid = checkLength( location, "지역", 2, 20 );
		valid = valid && checkLength( school, "학교 이름", 2, 30 );
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
			"<td><a href='Servlet.do?code=${edu.num}'>수 정</a></td>" +
			"<td><a href='Servlet.do?code=${edu.num}'>삭 제</a></td>" +
			"</tr>" );
			dialog.dialog("close");
		}
		return valid;
	}
//	function addCareer() {
//		var valid = true;
//		careerAllFields.removeClass( "ui-state-error" );
//		valid = checkLength(comnm, "회사명", 2, 20 );
//		valid = valid && checkLength(dpt, "근무 부서", 2, 30 );
//		valid = valid && checkLength(tit, "직급", 2, 20 );
//		
//		valid = valid && checkRegexp(comnm, /^[가-힣a-z]([가-힣0-9a-z_\s])+$/i, "회사명은 2~16자 이내로 작성해주세요." );
//		valid = valid && checkRegexp(dpt, /^[가-힣a-z]([가-힣0-9a-z_\s])+$/i, "근무부서 2~15자 이내로 작성해주세요." );
//		valid = valid && checkRegexp(tit, /^[가-힣a-z]([가-힣0-9a-z_\s])+$/i, "직급은 2~10자 이내로 작성해주세요." );
//		if ( valid ) {
//			$( "#career tbody" ).append( "<tr>" +
//			"<td>" + comnm.val() + "</td>" +
//			"<td>" + dpt.val() + "</td>" +
//			"<td>" + tit.val() + "</td>" +
//			"<td>" + empdt.val() + "</td>" +
//			"<td>" + transdt.val() + "</td>" +
//			"<td><a href='Servlet.do?code=${career.num}'>수 정</a></td>" +
//			"<td><a href='Servlet.do?code=${career.num}'>삭 제</a></td></td>" +
//			"</tr>" );
//			careerdialog.careerdialog( "close" );
//		}
//		return valid;
//	}
//	function addCerti() {
//		var valid = true;
//		certiAllFields.removeClass("ui-state-error" );
//		valid = checkLength(certinm, "자격(증)명", 2, 20 );
//		valid = valid && checkLength(rank, "성적(등급)", 2, 30 );
//		valid = valid && checkLength(publ, "발행기관", 2, 20 );
//		
//		valid = valid && checkRegexp(certinm, /^[가-힣a-z]([가-힣0-9a-z_\s])+$/i, "자격(증)명은 2~16자 이내로 작성해주세요." );
//		valid = valid && checkRegexp(rank, /^[가-힣a-z]([가-힣0-9a-z_\s])+$/i, "성적(등급)은 2~15자 이내로 작성해주세요." );
//		valid = valid && checkRegexp(publ, /^[가-힣a-z]([가-힣0-9a-z_\s])+$/i, "발행기관은 2~10자 이내로 작성해주세요." );
//		if ( valid ) {
//			$("#certi tbody" ).append( "<tr>" +
//			"<td>" + certinm.val() + "</td>" +
//			"<td>" + rank.val() + "</td>" +
//			"<td>" + publ.val() + "</td>" +
//			"<td>" + regdt.val() + "</td>" +
//			"<td>" + expdt.val() + "</td>" +
//			"<td><a href='Servlet.do?code=${certi.num}'>수 정</a></td>" +
//			"<td><a href='Servlet.do?code=${certi.num}'>삭 제</a></td></td>" +
//			"</tr>" );
//			certidialog.certidialog( "close" );
//		}
//		return valid;
//	}
	
	dialog = $("#dialog-form").dialog({
		autoOpen: false,
		height: 900,
		width: 400,
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
//	careerdialog = $("#career-dialog-form").careerdialog({
//		autoOpen: false,
//		height: 900,
//		width: 400,
//		modal: true,
//		buttons: {
//			"추가": addCareer,
//			"취소": function() {
//			careerdialog.careerdialog("close");
//			}
//		},
//		close: function() {
//			form[0].reset();
//			careerAllFields.removeClass("ui-state-error");
//		}
//	});
//	certidialog = $("#certi-dialog-form").certidialog({
//		autoOpen: false,
//		height: 900,
//		width: 400,
//		modal: true,
//		buttons: {
//			"추가": addCerti,
//			"취소": function() {
//				certidialog.certidialog("close");
//			}
//		},
//		close: function() {
//			form[0].reset();
//			certiAllFields.removeClass("ui-state-error");
//		}
//	});
	
	form = dialog.find("form").on("submit", function(event) {
//		event.preventDefault();
//		addEdu();
	});
//	form = careerdialog.find("form").on("submit", function(event) {
//		event.preventDefault();
//		addCareer();
//	});
//	form = certidialog.find("form").on("submit", function(event) {
//		event.preventDefault();
//		addCerti();
//	});
	
	$("#add-edu").button().on("click", function() {
		dialog.dialog("open");
	});
//	$("#add-career").button().on("click", function() {
//		careerdialog.careerdialog("open");
//	});
//	$("#add-certi").button().on("click", function() {
//		certidialog.certidialog("open");
//	});
});