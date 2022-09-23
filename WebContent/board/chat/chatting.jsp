<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="./css/bootstrap.css">
	<link rel="stylesheet" href="./css/custom2.css">
	<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
	<title>JSP AJAX 실시간 익명 채팅 사이트</title>
	<style>
		body{
			display:inline-block;
			margin:0 auto;
		}
	</style>
	<script src="./js/jquery-3.3.1.js"></script>
	<script src="./js/bootstrap.js"></script>
	<script type="text/javascript">
	var lastId = 0;
	function submitFunction(){
		var chatName = $('#chatName').val();
		var chatContent = $('#chatContent').val();
		$.ajax({
			type: "POST",
			url: "./ChatSubmitServlet",
			data: {
				chatName: encodeURIComponent(chatName),
				chatContent: encodeURIComponent(chatContent)
			}
		});
		$('#chatContent').val('');
	}
	
	function autoClosingAlert(selector, delay){
		var alert = $(selector).alert();
		alert.show();
		window.setTimeout(function(){
			alert.hide()
		}, delay);
	}
	
	function chatListFunction(type){
		$.ajax({
			type: "POST",
			url: "./ChatListServlet",
			data: {
				listType: type
			},
			success: function(data){
				if(data == "") return;
				var parsed = JSON.parse(data);
				var result = parsed.result;
				for(var i = 0; i < result.length; i++){
					addChat(result[i][0].value, result[i][1].value, result[i][2].value);
				}
				lastId = Number(parsed.last);
			}
		});
	}
		
		function addChat(chatName, chatContent, chatTime){
			if(chatName == 'admin'){
				$('#chatList').append('<div class="direct-chat-msg">'
						+ '<div class="direct-chat-info clearfix">'
						+ '<span class="direct-chat-name pull-left">' + chatName + '</span>'
						+ '<span class="direct-chat-timestamp pull-right">' + chatTime + '</span>'
						+ '</div>'
						+ '<img class="direct-chat-img" src="https://bootdey.com/img/Content/user_1.jpg" alt="Message User Image">'
						+ '<div class="direct-chat-text">' + chatContent + "</div></div>");
			} else {
				$('#chatList').append('<div class="direct-chat-msg right">'
						+ '<div class="direct-chat-info clearfix">'
						+ '<span class="direct-chat-name pull-right">' + chatName + '</span>'
						+ '<span class="direct-chat-timestamp pull-left">' + chatTime + '</span>'
						+ '</div>'
						+ '<img class="direct-chat-img" src="https://bootdey.com/img/Content/user_2.jpg" alt="Message User Image">'
						+ '<div class="direct-chat-text">' + chatContent + "</div></div>");
			}
			
			$('#chatList').scrollTop($('#chatList')[0].scrollHeight);
		}
		
		function getInfiniteChat(){
			setInterval(function(){
				chatListFunction(lastId);
			}, 1000);
		}

	</script>
</head>
<body>

<div class="row bootstrap snippets">
    <div class="col-md-3">
      <!-- DIRECT CHAT PRIMARY -->
      <div class="box box-primary direct-chat direct-chat-primary">
        <div class="box-header with-border">
          <h3 class="box-title">Direct Chat</h3>
    
          <div class="box-tools pull-right">
          	<button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
            </button>
            <button type="button" class="btn btn-box-tool" data-toggle="tooltip" title="Contacts" data-widget="chat-pane-toggle">
              <i class="fa fa-comments"></i></button>
            <button type="button" class="btn btn-box-tool" data-widget="remove" onClick="window.close();"><i class="fa fa-times"></i></button>
          </div>
        </div>
        <!-- /.box-header -->
        <div class="box-body">
          <!-- Conversations are loaded here -->
          <div class="direct-chat-messages" id="chatList">
          </div>
          <!--/.direct-chat-messages-->
        </div>
        <!-- /.box-body -->
        <div class="box-footer">
          <form action="#" method="post">
          <input type="hidden" name="message" id="chatName" class="form-control" value="${sessionScope.id}" readonly>
            <div class="input-group">
              <input type="text" name="message" placeholder="Type Message ..." id="chatContent" class="form-control">
                  <span class="input-group-btn">
                    <button type="submit" class="btn btn-primary btn-flat" onClick="submitFunction();">Send</button>
                  </span>
            </div>
            <div class="clearfix"></div>
          </form>
        </div>
        <!-- /.box-footer-->
      </div>
      <!--/.direct-chat -->
    </div>
</div>
	<script type="text/javascript">
		$(document).ready(function(){
			chatListFunction('ten');
			getInfiniteChat();
		});
	</script>
</body>
</html>