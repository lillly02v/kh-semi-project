$(document).ready(function(){
	
	$('form').submit(function(){
		if($('.user-volunteer').is(":checked")){
			$('form').attr('action', 'vtPassFinder.net');
		} else {
			$('form').attr('action', 'wrPassFinder.net');
		}
		
		if($.trim($('.userID').val()) == ''){
			alert('아이디를 입력하세요.');
			$(this).focus();
			return false;
		}
		
		if($.trim($('.userEmail').val()) == ''){
			alert('이메일을 입력하세요.');
			$(this).focus();
			return false;
		}
		
		if($.trim($('.userPhone').val()) == ''){
			alert('전화번호를 입력하세요.');
			$(this).focus();
			return false;
		}
		
		if($('.user-volunteer').is(":checked") == false && $('.user-welfare').is(":checked") == false){
			alert("봉사자 혹은 복지자를 선택해주세요.");
			return false;
		}
	});
	
	$('.resetbtn').click(function(){
		location.href="login.net";
	});
});