/**
 * 
 */
$(function() {
	var dialog;
	
	dialog = $("#pl-info").dialog({
		autoOpen: false,
		width: 500,
		height: 270,
		modal: true,
		buttons: {
			"확인" : function(){
				refresh();
				$("#pl-info").dialog("close");
			}
		},
		close: function(){
			refresh();
		}
	});
	
	$(".plnm").click(function() {
		$("#pl-info").dialog("open");
		pldtl($(this).next());
	});
	
	function pldtl(plno) {
//		var plid = $(".plid"),
		url = "pjt.do?cmd=pl_detail&plno=" + plno.val();
		$.ajax({
			url: url,
			data: {"plno":plno.val()},
			dataType: "json",
			type: 'post',
			contentsType: "application/x-www-form-urlencoded; charset=UTF-8",
			success: function(json){
				$("#plSchRs tbody").append(
				"<tr>" +
					"<td>" + json.plnm + "</td>" +
					"<td>" + json.dpt + "</td>" +
					"<td>" + json.tit + "</td>" +
					"<td>" + json.phone + "</td>" +
					"<td>" + json.email + "@mars.com</td>" +
				"</tr>"
				)
			}
		});
	}
});

function refresh(){
	$("#plSchRs tbody tr").remove();
}