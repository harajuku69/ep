/**
 * 
 */
$(function() {
	//modal
	var dialog, 
		rolebx = $("#rolebx"),
		pjtno = $("#pjtno").val(),
		empno = $("#empno").val(),
		rolecd,
	
	
	dialog = $("#join-dialog").dialog({
		autoOpen: false,
		width: 170,
		height: 365,
		modal: true,
		buttons: {
			"Join": pjtjoin,
			"닫 기": function() {
				$("select").find("option:first").attr("selected","selected");
				dialog.dialog("close");
			}
		},
		close: function() {
			$("select").find("option:first").attr("selected","selected");
		}
	});
	
	$("#joinBtn").button().on("click", function() {
		dialog.dialog("open");
	});
	
	$("#rolebx").change(function() {
		rolecd = $(this).val();
	});
	
	function pjtjoin() {
		if($("#rolebx").find("option:selected").text() == "선택하세요"){
			alert("수행 역할을 선택해주세요");
			$("#rolebx").focus();
			return false;
		}
//		alert(pjtno);
		var url = "pjt.do?cmd=join_member";
		$.ajax({
			url:url,
			data: {"pjtno": pjtno,"empno":empno,"rolecd":rolecd},
//				dataType:"json",
			type:"post",
			contentsType: "apjoinication/x-www-form-urlencoded; charset=UTF-8",
			success:function(result){
				if(result == '0'){
					msg = "Project에 참여하였습니다.";
					alert(msg);
					history.go(0);
				} else {
					msg = "이미 참여한 Project입니다. 중복으로 등록할 수 없습니다.";
					alert(msg);
				}
				
			}
		});
		dialog.dialog("close");
	}
})
	