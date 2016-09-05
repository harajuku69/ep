/**
 * ajax 
 */
$(function() {
	//modal
	var url = "noti.do?cmd=admin_cmt_write",
		d = $("#frm").serialize();
	
	regnm = $("#regnm"),
	ctt = $("#ctt"),
	regdt = $("#regdt"),
	pwd = $("#pwd"),
	AllFields = $([]).add(name).add(ctt).add(regdt).add(enterdt).add(graddt);

	function addCmt() {
		$.ajax({
			url: url,
			data: d,
			dataType:"json",
			type:'post',
			contentsType: "application/x-www-form-urlencoded; charset=UTF-8",
			success:function(json){
				data = JSON.parse(json);
				$("#cmttab tbody").append( "<tr>" +
						"<td>" + regnm.val() + "</td>" +
						"<td>" + ctt.val() + "</td>" +
						"<td>" + regdt.val() + "</td>" +
						"<td><a href='noti.do?cmd=edu_update&no=${edu.no}'>수 정</a></td>" +
						"<td><a href='noti.do?cmd=edu_delete&no=${edu.no}'>삭 제</a></td></td>" +
				"</tr>" );
			}
		});
	}
});