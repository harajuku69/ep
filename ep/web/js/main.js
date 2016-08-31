/**
 * contents : datepicker
 */
$(function() {
	//datepicker 설정
	var dateFormat = "yy-mm-dd",
      from = $("#from, #startdt, #regdt").datepicker({
        	dateFormat:"yy-mm-dd",
        	defaultDate: "+1d",
        	changeMonth: true,
        	changeYear: true,
        	numberOfMonths: 1,
        	yearRange: '1980:2020'
        }).on("change", function() {
          to.datepicker("option", "minDate", getDate(this));
        }),
      to = $("#to, #enddt" ).datepicker({
    	  dateFormat:"yy-mm-dd",
    	  defaultDate: "+1d",
    	  changeMonth: true,
    	  changeYear: true,
    	  numberOfMonths: 1,
    	  yearRange: '1980:2020'
      }).on("change", function() {
        from.datepicker("option", "maxDate", getDate(this));
      });
 
    function getDate(element) {
      var date;
      try {
        date = $.datepicker.parseDate(dateFormat, element.value);
      } catch(error) {
        date = null;
      }
      return date;
    }
});
/*
function zipcdsch(){
	var url="staff.do?cmd=zipcdsch_page";
	window.open(url, "_black_1",
	"toolbar=no, menubar=no, scrollbars=yes, resizable=yes, width=350, height=350");
}*/