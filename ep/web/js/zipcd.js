/**
 * 
 */
$(function() {
	//modal
	var dialog, form,
		kwd = $("#kwd"),
	
	tips = $(".validateTips");
	
	function updateTips(t) {
		tips.text(t).addClass("ui-state-highlight");//하일라이트 주는 것
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
		refresh();
		var url = "staff.do?cmd=zipcd_search";
		var valid = true,
			d = $("#frm").serialize();
		
		kwd.removeClass("ui-state-error");
		
		valid = checkLength(kwd, 2, 10 );
		valid = valid && checkRegexp(kwd, /^[가-힣0-9]([가-힣0-9])*$/, "동(읍/면) 이름은 한글과 숫자로 공백없이 입력해주세요.");
		
		if ( valid ) {
			$.ajax({
				url:url,
//				data:'kwd' + kwd.val(),
				data: d,
				dataType:"json",
//				alert(data.kwd);
				type:'post',
				contentsType: "application/x-www-form-urlencoded; charset=UTF-8",
				success:function(jsonArray){
					for(var index = 0; index < jsonArray.length; index++){
						var jsonObject = JSON.stringify(jsonArray[index]);
						var zipcdInfo = JSON.parse(jsonObject);
//						console.log(zipcdInfo.sido);
						$("#ZipcdSearchResult tbody").append(
							"<tr class='" + zipcdInfo.no + "'>" +
							"<td id='zipcdInfo'>" + zipcdInfo.zipcd + "</td>" +
							"<td id='sidoInfo'>" + zipcdInfo.sido + "</td>" +
							"<td id='gugunInfo'>" + zipcdInfo.gugun + "</td>" +
							"<td id='dongInfo'>" + zipcdInfo.dong + "</td>" +
							"<td id='bunjiInfo'>" + zipcdInfo.bunji + "</td>" +
							"<td width='50px'>" +
							"<button id='getzipcd' " +
							"onclick='setZipcd(" + "\"" + zipcdInfo.zipcd + "\"" 
												 + ", " + "\"" + zipcdInfo.sido + "\""
												 + ", " + "\"" + zipcdInfo.gugun + "\""
												 + ", " + "\"" + zipcdInfo.dong + "\""
												 + ");'>선 택</button></td></tr>" 
						);
					}
				}
			});
		}
		return valid;
	}
	
	dialog = $("#zip-dialog").dialog({
		autoOpen: false,
		width: 500,
		height: 500,
		modal: true,
		buttons: {
			"검 색": zipcdsch,
//			zipcdsch()함수가 실행될 떄 기존에 있떤 내역들을 삭제하는, 
//			즉 초기화하는 기능을 넣어야 함.그래야 검색할 때마다새로운 정보만 나열함.
			"취 소": function() {
				dialog.dialog("close");
			}
		},
		close: function() {
			refresh();
			form[0].reset();
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

function setZipcd(zipcd, sido, gugun, dong){
    $("#zipcd").val(zipcd);
    $("#addr").val(sido + " " + gugun + " " + dong);
	$("#zip-dialog").dialog("close");
};

function refresh(){
	$("#ZipcdSearchResult tbody tr").remove();
};














