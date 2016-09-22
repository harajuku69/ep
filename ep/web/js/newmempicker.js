/**
 * 
 */
$(function() {
	//modal
	var dialog, form,
		newmemnm = $("#newmemnm"),
	
	tips = $(".validateTips");
	
	dialog = $("#newmem-dialog").dialog({
		autoOpen: false,
		width: 650,
		height: 500,
		modal: true,
		buttons: {
			"검 색": newmemsch,
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
		newmemsch();
	});
	
	$("#newmemschbtn").button().on("click", function() {
		$("#newmemnm").val("");
		dialog.dialog("open");
	});
	
	function newmemsch() {
		refresh();
		var url = "pjt.do?cmd=select_member";
		var valid = true;
		
		newmemnm.removeClass("ui-state-error");
		
		valid = checkLength(newmemnm, 2, 10 );
		valid = valid && checkRegexp(newmemnm, /^[가-힣a-zA-Z]([가-힣a-zA-Z])*$/, "이름은 한글/영어(대소)로 공백없이 입력해주세요.");
		
		if ( valid ) {
			$.ajax({
				url:url,
				data: {"schnm":newmemnm.val()},
				dataType:"json",
				type:'post',
				contentsType: "apnewmemication/x-www-form-urlencoded; charset=UTF-8",
				success:function(jsonArray){
					for(var index = 0; index < jsonArray.length; index++){
						var json = JSON.stringify(jsonArray[index]);
						var newmemInfo = JSON.parse(json);
						$("#newMemSchRs tbody").append(
							"<tr class='" + newmemInfo.empno + "'>" +
								"<td>" + newmemInfo.empnm + "</td>" +
								"<td>" + newmemInfo.dptcd + "</td>" +
								"<td>" + newmemInfo.titcd + "</td>" +
								/*"<td>" + newmemInfo.phone + "</td>" +*/
								"<td>" + newmemInfo.empid + "@mars.com</td>" +
								"<td>" +
								"<select name='rolecd' id='rolecd'>" +
									"<option value='99' selected='selected'>선택하세요</option>" +
									"<option value='00'>Project Leader</option>" +
									"<option value='01'>Project Manager</option>" +
									"<option value='02'>Model Leader</option>" +
									"<option value='03'>Model Manager</option>" +
									"<option value='04'>Publisher</option>" +
									"<option value='05'>Designer</option>" +
									"<option value='06'>Developer</option>" +
									"<option value='07'>Coder</option>" +
									"<option value='08'>Staff</option>" +
								"</select>" +
								"</td>" +
								"<td width='50px'>" +
								"<button " +
								"onclick='setMember(" + "\"" + newmemInfo.empno + "\"" 
													 + ", " + "\"" + newmemInfo.empnm + "\""
													 + ", " + "\"" + newmemInfo.dptcd + "\""
													 + ", " + "\"" + newmemInfo.titcd + "\""
													 + ", " + "\"" + $('#rolecd').val() + "\""                       
													 + ")'>등 록</button>" +
								"</td>" +
							"</tr>" 
						);
					}
				}
			});
		}
		return valid;
	}
});

function setMember(newmemno, newmemnm, newmemdpt, newmemtit, newmemrole){
	var url = "pjt.do?cmd=insert_member";
		pjtno = $("#pjtno");
	$.ajax({
		url:url,
		data:{"pjtno":pjtno.val(),"empno":newmemno,"rolecd":newmemrole},
		type:'post',
		contentsType:"application/x-www-form-urlencoded; charset=UTF-8",
		success:function(result){
			if(result == '1'){
				msg = "정상 등록되었습니다.";
				alert(msg);
			} else{
				msg = "등록되지 않았습니다. 다시 등록해주세요."
				alert(msg);
			}
		}
	});	
	$("#newmem-dialog").dialog("close");
    $("#newmember").append(
    	"<tr class='" + newmemno + "'>" +
			"<td><input type='radio' name='memnm' id='memnm' value='" + newmemno +"'>" + newmemnm + "</td>" +
			"<td>" + newmemdpt + "</td>" +
			"<td>" + newmemtit + "</td>" +
			"<td>" + newmemrole +"</td>" +
		"</tr>"
    );
};

function refresh(){
	$("#newMemSchRs tbody tr").remove();
};














