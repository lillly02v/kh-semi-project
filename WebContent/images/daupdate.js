$(document).ready(function(){
	$('.personinfoform').submit(function(){
		if($.trim($('.userPass').val()) == ""){
			alert("비밀번호를 입력하세요.");
			$('.userPass').focus();
			return false;
		} else if($.trim($('.userPass').val()).length < 4){
			alert("비밀번호를 4자 이상 입력하세요.");
			$('.userPass').focus();
			return false;
		} else if($.trim($('.userBirth').val()) == ""){
			alert("생년월일을 입력하세요.");
			$('.userBirth').focus();
			return false;
		} else if($.trim($('.userGender').val()) == ""){
			alert("성별을 선택하세요.");
			$('.userGender').focus();
			return false;
		} else if($.trim($('.userJob').val()) == ""){
			alert("직업을 입력하세요.");
			$('.userJob').focus();
			return false;
		} else if($.trim($('.userPhone').val()) == ""){
			alert("전화번호를 입력하세요.");
			$('.userPhone').focus();
			return false;
		} else if($.trim($('.userEmail').val()) == ""){
			alert("이메일을 입력하세요.");
			$('.userEmail').focus();
			return false;
		}  else if($.trim($('.userPost').val()) == ""){
			alert("우편번호를 입력하세요.");
			$('.userPost').focus();
			return false;
		} else if($.trim($('.userkeyword').val()) == ""){
			alert("특이사항을 입력하세요.");
			$('.userKeyword').focus();
			return false;
		}
	});
});