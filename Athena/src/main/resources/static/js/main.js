$(document).ready(function() {
//	$(document).on("keypress", "form", function(event) { 
//	    return event.keyCode != 13;
//	});
//	$('input').tagsinput({
//		  cancelConfirmKeysOnEmpty: true
//	});


	$('form input').keydown(function(event) {
		if (event.keyCode == 13) {
			event.preventDefault();
			return false;
		}
	});
	
	runJSCommandsFromSpring();
	
	$( '#bt_add' ).click(function() {
		$form = $( '#form_add' );
		$form.find('.btn .btn-danger').hide();
		$form.find(':input').not(':button, :submit, :reset').val('').tagsinput('removeAll');
		
	});
	
});

function runJSCommandsFromSpring(){
	if(jsCommandList == null){
		return;
	}
	var commandArray = jsCommandList.split(";");
	$.each( commandArray, function( key, value ) {
		  switch(value){
		  	case 'show_addModal':
		  		$('#add-modal').modal('show');
			break;
		  }
	});
}
