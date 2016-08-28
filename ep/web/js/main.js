/**
 * contents : datepicker
 */
$(function() {
	//datepicker 설정
	var dateFormat = "yy/mm/dd",
      from = $("#from, #startdt, #regdt").datepicker({
        	dateFormat:"yy/mm/dd",
        	defaultDate: "+1w",
        	changeMonth: true,
        	changeYear: true,
        	numberOfMonths: 1,
        	yearRange: '1980:2020'
        }).on("change", function() {
          to.datepicker("option", "minDate", getDate(this));
        }),
      to = $("#to, #enddt, #expdt" ).datepicker({
    	  dateFormat:"yy/mm/dd",
    	  defaultDate: "+1w",
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
