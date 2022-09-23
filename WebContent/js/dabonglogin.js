
(function ($) {
    "use strict";

    
    /*==================================================================
    [ Validate ]*/
    var input = $('.validate-input .input100');

    $('.validate-form').on('submit',function(){
    	if(!($('.user-welfare').is(':checked')) && !($('.user-volunteer').is(':checked'))){
    		alert("복지자 혹은 봉사자를 선택하세요.");
    		return false;
    	}
    	
    	if($('.user-welfare').is(":checked")){
    		$(this).attr("action", "wrLoginProcess.net");
    	} else if($('.user-volunteer').is(":checked")){
    		$(this).attr("action", "vtLoginProcess.net");
    	}
    	
    	var check = true;

        for(var i=0; i<input.length; i++) {
            if(validate(input[i]) == false){
                showValidate(input[i]);
                check=false;
            }
        }

        return check;
    });
    
    $('.login100-form-white').click(function(event){
    	location.href="./join.net";
    })


    $('.validate-form .input100').each(function(){
        $(this).focus(function(){
           hideValidate(this);
        });
    });
    
    function insertAddressJson(addrPath){
    	$.ajax({
    		type:"POST",
    		dataType:"JSON",
    		data: $(".validate-form").serialize(),
    		url: addrPath,
    		success: success
    	});
    }

    function validate (input) {
        if($(input).attr('type') == 'email' || $(input).attr('name') == 'email') {
            if($(input).val().trim().match(/^([a-zA-Z0-9_\-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\-]+\.)+))([a-zA-Z]{1,5}|[0-9]{1,3})(\]?)$/) == null) {
                return false;
            }
        }
        else {
            if($(input).val().trim() == ''){
                return false;
            }
        }
    }

    function showValidate(input) {
        var thisAlert = $(input).parent();

        $(thisAlert).addClass('alert-validate');
    }

    function hideValidate(input) {
        var thisAlert = $(input).parent();

        $(thisAlert).removeClass('alert-validate');
    }
    
    

})(jQuery);