/**
 * 
 */
$(function() {
	//modal
	var dialog, form, radioval,
		newmemnm = $("#newmemnm"),
	
	tips = $(".validateTips");
	
	dialog = $("#newmem-dialog").dialog({
		autoOpen: false,
		width: 650,
		height: 500,
		modal: true,
		buttons: {
			"검 색": newmemsch,
			"닫 기": function() {
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
	
	$("#newMemRegBtn").button().on("click", function() {
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
									"<td>" + newmemInfo.empid + "@mars.com</td>" +
									"<td>" +
										"<select name='rolecd' class='rolecd'>" +
											"<option value='' >선택하세요</option>" +
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
										"<button class='regBtn'>등 록</button>" +
										"<input type='hidden' value='"+ newmemInfo.empno + "'>" +
									"</td>" +
								"</tr>" 
						);
						
					}
					$(".regBtn").on("click",function(){
						if($(this).parents("tr").find("option:selected").text() == "선택하세요" ){
							alert("수행 역할을 선택해주세요");
							$(this).parents("tr").find("select").focus();
						} else {
							regMember(
									$(this).next().val(), //empno
									$(this).parents("tr").find("td").eq(0).text(), //empnm
									$(this).parents("tr").find("td").eq(1).text(), //dpt
									$(this).parents("tr").find("td").eq(2).text(), //tit
									$(this).parents("tr").find("option:selected").val(), //rolecd
									$(this).parents("tr").find("option:selected").text() //role
							); 
						}
					});
				}
			});
		}
		return valid;
	}
	
	function regMember(newmemno, newmemnm, newmemdpt, newmemtit, newmemrolecd, newmemrole){
		var url = "pjt.do?cmd=insert_member";
		pjtno = $("#pjtno");
		$.ajax({
			url:url,
			data:{"pjtno":pjtno.val(),"empno":newmemno,"rolecd":newmemrolecd},
			type:"post",
			contentsType:"application/x-www-form-urlencoded; charset=UTF-8",
			success:function(result){
				if(result == '1'){
					msg = "등록되었습니다.";
					alert(msg);
					$("#newmember").append(
							"<tr class='" + newmemno + "'>" +
							"<td><input type='radio' name='memnm' id='memnm' value='" + newmemno +"'>" + " " + newmemnm + "</td>" +
							"<td>" + newmemdpt + "</td>" +
							"<td>" + newmemtit + "</td>" +
							"<td>" + newmemrole +"</td>" +
							"</tr>"
					);
				} else{
					msg = "동일한 인원은 중복 등록되지 않습니다.";
					alert(msg);
				}
			}
		});	
//		$("#newmem-dialog").dialog("close");
	};
	
	$("#memDelBtn").button().on("click",function(){
		radioval = $(".memnm:checked").val();
		deleteItem(radioval);
	});
	function deleteItem(item){
		var delno = "."+ item;//클래스로 선언된 tr만 지울라고 .을 추가하는 것임
		var url = "pjt.do?cmd=delete_member";
		$.ajax({
			url: url,
			data: {"empno":item},
			type: "post",
			contentsType: "application/x-www-form-urlencoded; charset=UTF-8",
			success:function(result){
				if(result == '1') {
					alert("삭제되었습니다.");
					$("tr").remove(delno);
				} else {
//					alert(result);
					alert("등록 후 바로 삭제되지 않았습니다. 새로 고침 후 지워주세요.");
				}
			}
		});
	}
});


function refresh(){
	$("#newMemSchRs tbody tr").remove();
};














