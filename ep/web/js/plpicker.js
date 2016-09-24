/**
 * 
 */
$(function() {
	//modal
	var dialog, form,
		plnm = $("#plnm"),
	
	tips = $(".validateTips");
	
	dialog = $("#pl-dialog").dialog({
		autoOpen: false,
		width: 650,
		height: 500,
		modal: true,
		buttons: {
			"검 색": plsch,
			"취 소": function() {
				dialog.dialog("close");
			}
		},
		close: function() {
			refresh();
			form[0].reset();
		}
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
			updateTips("이름은 최소 " + min + " ~ " + max + "자 까지 입력해주세요." );
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
	
	form = dialog.find("form").on("submit", function(event) {
		event.preventDefault();
		plsch();
	});
	
	$("#plschbtn").button().on("click", function() {
		$("#plnm").val("");
		dialog.dialog("open");
	});
	
	function plsch() {
		refresh();
		var url = "pjt.do?cmd=select_member";
		var valid = true;
		
		plnm.removeClass("ui-state-error");
		
		valid = checkLength(plnm, 2, 10 );
		valid = valid && checkRegexp(plnm, /^[가-힣a-zA-Z]([가-힣a-zA-Z])*$/, "이름은 한글/영어(대소)로 공백없이 입력해주세요.");
		
		if ( valid ) {
			$.ajax({
				url:url,
				data: {"schnm":plnm.val()},
				dataType:"json",
				type:"post",
				contentsType: "application/x-www-form-urlencoded; charset=UTF-8",
				success:function(jsonArray){
					for(var index = 0; index < jsonArray.length; index++){
						var json = JSON.stringify(jsonArray[index]);
						var plInfo = JSON.parse(json);
						$("#plSchRs tbody").append(
							"<tr class='" + plInfo.empno + "'>" +
							"<td id='nmInfo'>" + plInfo.empnm + "</td>" +
							"<td id='dptInfo'>" + plInfo.dptcd + "</td>" +
							"<td id='titInfo'>" + plInfo.titcd + "</td>" +
							"<td id='phoneInfo'>" + plInfo.phone + "</td>" +
							"<td id='emailInfo'>" + plInfo.empid + "@mars.com</td>" +
							"<td width='50px'>" +
							"<button id='getPl' " +
							"onclick='setPl(" + "\"" + plInfo.empnm + "\"" 
												 + ", " + "\"" + plInfo.empno + "\""
												 + ")'>선 택</button></td></tr>" 
						);
					}
				}
			});
		}
		return valid;
	}
});

function setPl(plnm, plno){
    $("#plnm").val(plnm);
    $("#plno").val(plno);
	$("#pl-dialog").dialog("close");
};

function refresh(){
	$("#plSchRs tbody tr").remove();
};














