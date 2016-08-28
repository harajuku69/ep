/**
 * subTab setting : tab
 */
$(function() {
	//Tab 설정 
	var tabs = $("#tabs").tabs();
	    tabs.find(".ui-tabs-nav").sortable({
	   	axis: "x",
	   	stop: function(){
	   		tabs.tabs("refresh");
	   	}
	});
});