
function matchingbtn(sendUrl){
	
	var sendData = 'boardNum=' + $('.boardNum').val() 
			+ "&" + 'requestMB=' + $('.requestMB').val() 
			+ "&" + 'responseMB=' + $('.responseMB').val(); 
		
	$.ajax({
		type: "POST",
		data: sendData,
		url: sendUrl,
		success: function(text){
		if(text == '매칭중'){
				$('.matchbtn').css('background-color', '#ccc');
				$('.matchbtn').val('매칭중');
				$('.match-form').submit(function(){
					return false;
				});
			}else if(text == '매칭완료'){
				$('.matchbtn').css('background-color', '#ccc');
				$('.matchbtn').val('매칭완료');
				$('.match-form').submit(function(){
					return false;
				});
			}
		} 
	});
	
}

function messageBtn(btn, messageData, messageUrl){
	$.ajax({
		type: "POST",
		data: messageData,
		url: messageUrl,
		success: function(result){
			if(result.trim() == 'approve'){
				alert('매칭이 승인되었습니다.');
				history.go(0);
			} else if(result.trim() == 'reject'){
				alert("매칭을 거절하였습니다.")
				history.go(0);
			} else if(result.trim() == 'cancle'){
				alert('매칭을 취소하였습니다.');
				history.go(0);
			} else if(result.trim() == 'confirm'){
				alert('확인 되셨습니다.');
				history.go(0);
			}
			
		}
	});
}


