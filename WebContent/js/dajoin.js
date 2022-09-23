$(document).ready(function(){
	
	$('.userPWC').change(function(){
		if($(this).val() != $('.userPW').val()){
			$('.messagePWC').html("비밀번호가 일치하지 않습니다.");
			$(".messagePWC").css('color', 'red');
			$(this).val('');
			$(this).focus();
		} else if($(this).val() == $('.userPW').val()){
			$('.messagePWC').html("비밀번호가 일치합니다.");
			$(".messagePWC").css('color', 'blue');
		}
	});

	$('.personinfoform').submit(function(){
		if($.trim($('.userID').val()) == ""){
			alert("아이디를 입력하세요.");
			$('.userID').focus();
			return false;
		} else if($('.userID').val().indexOf("admin") != -1){
			alert("admin 단어를 포함할 수 없습니다.");
			$(".userID").focus();
			return false;
		} else if($.trim($('.userPW').val()) == ""){
			alert("비밀번호를 입력하세요.");
			$('.userPW').focus();
			return false;
		} else if($.trim($('.userPW').val()).length < 4){
			alert("비밀번호를 4자 이상 입력하세요.");
			$('.userPW').focus();
			return false;
		} else if($('.userPWC').val() != $('.userPW').val()){
			alert("비밀번호가 일치하지 않습니다.");
			$('.userPWC').val('');
			$('.userPWC').focus();
			return false;
		}
	});
	
	$('.persondetailform').submit(function(){
		if($.trim($('.userBirth').val()).length < 8){
			alert("생년월일을 제대로 입력하세요.");
			return false;
		}
	});
});