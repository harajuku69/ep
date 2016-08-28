/**
 * 
 */
$( "#target" ).submit(function( event ) {
  alert( "Handler for .submit() called." );
  event.preventDefault();
});
$( "#other" ).click(function() {
  $( "#target" ).submit();
});