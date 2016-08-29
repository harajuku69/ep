/**
 * ajax select box setting
 */

$(function() {
	$.ajax({
		url : "<c:url value='/getDpt.do'/>",
		success :function(data) {
			loadCombo($("#dptbx"), data.dpt);
		$("dptbx").val("");
		}
	});
	
	$("#dptbx").change(function() {
		alert("Selected : " + $("#dptbx option:selected").val());
	});
});
	
function loadCombo(target, data) {
	var dataArr = [];
	var inx =0;
	target.empty();
	
	$(data).each(function() {
		dataArr[inx++] = "<option value=" + this.dptcd + ">" + this.dpt + "</option> ";
	});
	target.append(dataArr);
}