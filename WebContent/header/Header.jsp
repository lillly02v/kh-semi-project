<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body {
	margin: 0;
	font-family: Arial;
}

/*| ======================== |*/
/*| ======= Button1 ======== |*/
/*| ======= start   ======== |*/
/*| ======================== |*/

.button1 {
  display: inline-block;
  border-radius: 4px;
  background-color: #28A745;
  border: none;
  color: #FFFFFF;
  text-align: center;
  font-size: 28px;
  padding: 9px;
  width: 70px;
  height: 25px;
  transition: all 0.5s;
  cursor: pointer;
  margin: 6px;
}

.button1 span {
  cursor: pointer;
  display: inline-block;
  position: relative;
  top: -17px;
  transition: 0.5s;
}

.button1 span:after {
  content: '\00bb';
  position: absolute;
  opacity: 0;
  top: 0;
  right: -20px;
  transition: 0.5s;
}

.button1:hover span {
  padding-right: 25px;
}

.button1:hover span:after {
  opacity: 1;
  right: 0;
}

.button1_align {
  top: -20px;
}

/*| ======================= |*/
/*| ======= Button1 ======= |*/
/*| ======= end     ======= |*/
/*| ======================= |*/

/*| ======================== |*/
/*| ======= Button2 ======== |*/
/*| ======= start   ======== |*/
/*| ======================== |*/

.button2 {
  display: inline-block;
  border-radius: 4px;
  background-color: #f4511e;
  border: none;
  color: #FFFFFF;
  text-align: center;
  font-size: 28px;
  padding: 9px;
  width: 70px;
  height: 25px;
  transition: all 0.5s;
  cursor: pointer;
  margin: 1px;
}

.button2 span {
  cursor: pointer;
  display: inline-block;
  position: relative;
  top: -17px;
  transition: 0.5s;
}

.button2 span:after {
  content: '\00bb';
  position: absolute;
  opacity: 0;
  top: 0;
  right: -20px;
  transition: 0.5s;
}

.button2:hover span {
  padding-right: 25px;
}

.button2:hover span:after {
  opacity: 1;
  right: 0;
}

.button2_align {
  top: -20px;
}

/*| ======================= |*/
/*| ======= Button2 ======= |*/
/*| ======= end     ======= |*/
/*| ======================= |*/

/*| ======================== |*/
/*| ======= Button3 ======== |*/
/*| ======= start   ======== |*/
/*| ======================== |*/

.button3 {
  display: inline-block;
  border-radius: 4px;
  background-color: #1e90ff;
  border: none;
  color: #FFFFFF;
  text-align: center;
  font-size: 28px;
  padding: 9px;
  width: 70px;
  height: 25px;
  transition: all 0.5s;
  cursor: pointer;
  margin: 8px;
}

.button3 span {
  cursor: pointer;
  display: inline-block;
  position: relative;
  top: -17px;
  transition: 0.5s;
}

.button3 span:after {
  content: '\00bb';
  position: absolute;
  opacity: 0;
  top: 0;
  right: -20px;
  transition: 0.5s;
}

.button3:hover span {
  padding-right: 25px;
}

.button3:hover span:after {
  opacity: 1;
  right: 0;
}

.button3_align {
  top: -20px;
}

/*| ======================= |*/
/*| ======= Button3 ======= |*/
/*| ======= end     ======= |*/
/*| ======================= |*/

.header {
	z-index: 9999;
	height: 90px;
	overflow: hidden;
	background-color: dodgerblue;
	padding: 20px 10px;
	box-sizing: border-box;
	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0
		rgba(0, 0, 0, 0.19);
}

.header div {
	align: center;
}

/*| ============================ |*/
/*| ======= Mail / User ======== |*/
/*| =======    start    ======== |*/
/*| ============================ |*/

div.dropdown1 {
	position: absolute;
	left: 250px;
}

div.dropdown3 {
	position: absolute;
	left: 210px;
}

div.dropdown2 {
	position: absolute;
	left: 170px;
}

.dropdown1:hover .dropdown-content1 {
	display: block;
}

.dropdown2:hover .dropdown-content2 {
	display: block;
}

.dropdown3:hover .dropdown-content3 {
	display: block;
}

div.mail-contnet {
    height: 71px;
}

.dropdown-content1 {
	display: none;
	position: absolute;
	background-color: #f1f1f1;
	min-width: 160px;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	z-index: 1;
}

span.hover {
    font-size: 10px;
}

.dropdown-content2 {
	display: none;
	position: absolute;
	background-color: #f1f1f1;
	min-width: 400px;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	z-index: 1;
}

.dropdown-content2 a:hover {
	border-left: 0;
}

.dropdown-content3 {
	display: none;
	position: absolute;
	background-color: #f1f1f1;
	min-width: 400px;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	z-index: 1;
}

.dropdown-content3 a:hover {
	border-left: 0;
}

.mail-contnet h5 {
	font-size: 15px;
	margin-top: 0px;
	margin-bottom: 10px;
	font-size: 15px;
	text-align: left;
}

.mail-contnet span {
	text-align: left;
}

.mail-contnet time {
	font-align: left;
}

.end-title {
    color: #f1f1f1;
}

hr {
	margin-top: 0px;
	border: 0;
	height: 1px;
	background-image: linear-gradient(to right, rgba(0, 0, 0, 0),
		rgba(0, 0, 0, 0.75), rgba(0, 0, 0, 0));
}

.header div.dropdown1 {
	float: left;
	color: black;
	text-align: center;
	padding: 10px;
	text-decoration: none;
	font-size: 15px;
	line-height: 20px;
	top: 20px;
	bottom: 20px;
}

.header div.dropdown1:hover {
	color: white;
	transition: 0.3s;
}

.header div.dropdown2 {
	float: left;
	color: black;
	text-align: center;
	padding: 10px;
	text-decoration: none;
	font-size: 15px;
	line-height: 20px;
	top: 20px;
	bottom: 20px;
}

.header div.dropdown2:hover {
	color: white;
	transition: 0.3s;
}

.header div.dropdown3 {
	float: left;
	color: black;
	text-align: center;
	padding: 10px;
	text-decoration: none;
	font-size: 15px;
	line-height: 20px;
	top: 20px;
	bottom: 20px;
}

.header div.dropdown3:hover {
	color: white;
	transition: 0.3s;
}

.header a.mail-text:hover {
    color: dodgerblue;
    border-top: 0;
    border-bottom: 0;
    transition: 0.3s;
}

.header a.profile:hover {
    color: dodgerblue;
    border-top: 0;
    border-bottom: 0;
    transition: 0.3s;
}

.header a.logout:hover {
    color: dodgerblue;
    border-top: 0;
    border-bottom: 0;
    transition: 0.3s;
}

.header a.right-menu {
   color: white;
}

/*| ============================ |*/
/*| ======= Mail / User ======== |*/
/*| =======    start    ======== |*/
/*| ============================ |*/

/*| ====================== |*/
/*| ======= scroll ======= |*/
/*| ======= start  ======= |*/
/*| ====================== |*/

.scrollBlind {
    height: 200px;
    overflow-y: scroll;
}

.alarmBlind {
    height: 150px;
    overflow-y: scroll;
}

/*| ====================== |*/
/*| ======= scroll ======= |*/
/*| ======= end    ======= |*/
/*| ====================== |*/

/*| ====================== |*/
/*| ======= close  ======= |*/
/*| ======= button ======= |*/
/*| ======= start  ======= |*/
/*| ====================== |*/

.close-button {
  height: 50px;
  width: 50px;
  position: relative;
  box-sizing: border-box;
  line-height: 50px;
  display: inline-block;
  magin-left: 13px;
}
.close-button:before, .close-button:after {
  transform: rotate(-45deg);
  content: '';
  position: absolute;
  top: 50%;
  left: 50%;
  margin-top: -2px;
  margin-left: -14px;
  display: block;
  height: 3px;
  width: 22px;
  background-color: black;
  transition: all 0.25s ease-out;
}
.close-button:after {
  transform: rotate(-135deg);
}
.close-button:hover:before, .close-button:hover:after {
  transform: rotate(0deg);
}

.header a.close-button:hover {
  border-top: 0;
  border-bottom: 0;
}

/*| ====================== |*/
/*| ======= close  ======= |*/
/*| ======= button ======= |*/
/*| ======= end    ======= |*/
/*| ====================== |*/

span.hover {
    font-size: 10px;
}

.dropdown-content2 {
	display: none;
	position: absolute;
	background-color: #f1f1f1;
	min-width: 400px;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	z-index: 1;
}

.dropdown-content2 a:hover {
	border-left: 0;
}

.dropdown-content3 {
	display: none;
	position: absolute;
	background-color: #f1f1f1;
	min-width: 400px;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	z-index: 1;
}

.dropdown-content3 a:hover {
	border-left: 0;
}

.mail-contnet h5 {
	font-size: 15px;
	margin-top: 0px;
	margin-bottom: 10px;
	font-size: 15px;
	text-align: left;
}

.mail-contnet span {
	text-align: left;
}

.mail-contnet time {
	font-align: left;
	float: right;
}

.drop-title {
    color: dodgerblue;
	padding: 10px;
}

hr {
	margin-top: 0px;
	border: 0;
	height: 1px;
	background-image: linear-gradient(to right, rgba(0, 0, 0, 0),
		rgba(0, 0, 0, 0.75), rgba(0, 0, 0, 0));
}

.header a {
	float: left;
	color: black;
	text-align: center;
	padding: 10px;
	text-decoration: none;
	font-size: 15px;
	line-height: 20px;
	transition: 0.5s;
	top: 10px;
	bottom: 20px;
}

.header div.dropdown1 {
	float: left;
	color: black;
	text-align: center;
	padding: 10px;
	text-decoration: none;
	font-size: 15px;
	line-height: 20px;
	top: 20px;
	bottom: 20px;
}

.header div.dropdown1:hover {
	color: white;
	transition: 0.3s;
}

.header div.dropdown2 {
	float: left;
	color: black;
	text-align: center;
	padding: 10px;
	text-decoration: none;
	font-size: 15px;
	line-height: 20px;
	top: 20px;
	bottom: 20px;
}

.header div.dropdown2:hover {
	color: white;
	transition: 0.3s;
}

.header div.dropdown3 {
	float: left;
	color: black;
	text-align: center;
	padding: 10px;
	text-decoration: none;
	font-size: 15px;
	line-height: 20px;
	top: 20px;
	bottom: 20px;
}

.header div.dropdown3:hover {
	color: white;
	transition: 0.3s;
}

.header a.logo {
	font-size: 25px;
	font-weight: bold;
	background-color: dodgerblue;
	color: white;
}

.header a.logo:hover {
	color: white;
	border-bottom: none;
	border-top: none;
	border-left: 0px;
}

.header a:hover {
	color: white;
	transition-duration: 0.5s;
	border-top: 3px solid white;
	border-bottom: 3px solid white;
	border-radius: 4px;
	text-decoration: none;
	margin: 20px, 0px;
}

/*| ====================== |*/
/*| ======= mail  ======== |*/
/*| ======= pulse ======== |*/
/*| ======= action ======= |*/
/*| ====================== |*/

.pulse {
  position: absolute;
  display: block;
  top: 5px;
  right: -4px;
  left: 25px;
  width: 10px;
  height: 10px;
  background: #ef5350;
  z-index: 10;
  box-shadow: 0 0 0 rgba(239,83,80, 0.4);;
  border-radius: 70px;
  cursor: pointer;
  animation: pulse 2s infinite;
}

@-webkit-keyframes pulse {
  0% {
    -webkit-box-shadow: 0 0 0 0 rgba(239,83,80, 0.4);
  }
  70% {
      -webkit-box-shadow: 0 0 0 10px rgba(239,83,80, 0);
  }
  100% {
      -webkit-box-shadow: 0 0 0 0 rgba(239,83,80, 0);
  }
}
@keyframes pulse {
  0% {
    -moz-box-shadow: 0 0 0 0 rgba(239,83,80, 0.4);
    box-shadow: 0 0 0 0 rgba(239,83,80, 0.4);
  }
  70% {
      -moz-box-shadow: 0 0 0 10px rgba(239,83,80, 0);
      box-shadow: 0 0 0 10px rgba(239,83,80, 0);
  }
  100% {
      -moz-box-shadow: 0 0 0 0 rgba(239,83,80, 0);
      box-box-shadow: 0 0 0 0 rgba(239,83,80, 0);
  }
}

/*| ====================== |*/
/*| ======= pulse ======== |*/
/*| ======= action ======= |*/
/*| ======= end   ======== |*/
/*| ====================== |*/

.header-right {
	float: right;
}

@media screen and (max-width: 500px) {
	.header a {
		float: none;
		display: block;
		text-align: left;
		text-size: 10px;
	}
	.header-right {
		float: none;
	}
}

.button1, .button2{vertical-align:middle}

</style>
<script src="./js/jquery-3.3.1.js"></script>
<script src="./js/match.js"></script>
<script>
	$(document).ready(function(){
		var boardnum;
		var boardaddress = "";
		var alarmaddress = "";
		var stateUrl = "";
		var listUrl = "";
		var alarmUrl = "";
		var messageUrl = "";
		var messageData = "";
		var sendData = "id=" + '${sessionScope.id}';
		
		if('${sessionScope.user}' == '봉사자'){
			stateUrl = "vtSendMatch.net";
			listUrl = "vtMessageView.net";
			alarmUrl = "vtAlarmView.net";
			messageUrl = "vtMatchProcess.net";
			boardaddress = "./vboardDetailAction.vb?num=";
			alarmaddress = "./wboardDetailAction.wb?num=";
		} else {
			stateUrl = "wrSendMatch.net";
			listUrl = "wrMessageView.net";
			alarmUrl = "wrAlarmView.net";
			messageUrl = "wrMatchProcess.net";
			boardaddress = "./wboardDetailAction.wb?num=";
			alarmaddress = "./vboardDetailAction.vb?num=";
		}
		
		$.getJSON(listUrl, sendData, function(pulse){
			if(pulse != ""){
				$('.pulse-content2').css('display', "block");
			}
		});
		
		$.getJSON(alarmUrl, sendData, function(pulse){
			if(pulse != ""){
				$('.pulse-content3').css('display', "block");
			}
		});
		
		$('.dropdown2').hover(function(){
			$('.total-count').empty();
			$('.scrollBlind').empty();
			var count = 0;
			
			$.getJSON(listUrl, sendData, function(list){
				$(list).each(function(index, item){
					var output = '';
					
					output += '<div class="mail-contnet">';
					output += '<a href="' + boardaddress + item.boardNum + '" class="mail-text">';
					output += '<table>';
					output += '<a href="#" class="close-button"></a>';
					output += '<tr><td><h5>' + item.requestMb + '&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp';
					output += '<span class="time">' + item.matchDate + '</span></h5></td>';
					if(item.matching == '매칭완료'){
						output += '<td><button class="button1 approvedbtn approve-color"' 
							+ 'value="mNum=' + item.mNum + '&boardNum=' + item.boardNum + '&requestMB=' + item.requestMb 
							+ '&responseMB=' + '${sessionScope.id}' + '&state=success"><span class="hover">완료</span></button></td></tr>';
						output += '<tr><td><span class="mail-desc">' + item.boardNum + '번 글의 매칭을 요청했습니다.</span></td>';
						output += '<td><button class="button2 canclebtn cancle-color"' 
							+ 'value="mNum=' + item.mNum + '&boardNum=' + item.boardNum + '&requestMB=' + item.requestMb 
							+ '&responseMB=' + '${sessionScope.id}' + '&state=cancle"><span class="hover">취소</span></button></td></tr>';
					} else {
						output += '<td><button class="button1 approvebtn approve-color"' 
							+ 'value="mNum=' + item.mNum + '&boardNum=' + item.boardNum + '&requestMB=' + item.requestMb 
							+ '&responseMB=' + '${sessionScope.id}' + '&state=approve"><span class="hover">수락</span></button></td></tr>';
							output += '<tr><td><span class="mail-desc">' + item.boardNum + '번 글의 매칭을 요청했습니다.</span></td>';
						output += '<td><button class="button2 rejectbtn cancle-color"' 
							+ 'value="mNum=' + item.mNum + '&boardNum=' + item.boardNum + '&requestMB=' + item.requestMb 
							+ '&responseMB=' + '${sessionScope.id}' + '&state=reject"><span class="hover">거절</span></button></td></tr>';
					}
					output += '</div>';
					boardnum = item.boardNum;
					$('.scrollBlind').append(output);
					count = count + 1;
				});
				$(".total-count").append(count);
			});
		});
		
		$('.dropdown3').hover(function(){
			$('.total-count2').empty();
			$('.alarmBlind').empty();
			var count = 0;
			$.getJSON(alarmUrl, sendData, function(alarm){
				$(alarm).each(function(index, item){
					var output = '';
					
					output += '<div class="mail-contnet">';
					output += '<a href="' + alarmaddress + item.boardNum + '" class="mail-text">';
					output += '<table>';
					output += '<tr><td><h5>' + item.responseName + '(' + item.responseMb + ')님이 수락하셨습니다.</h5></td>';
					output += '<td rowspan="2">' + '<button class="button3 confirmbtn"' 
						+ 'value="mNum=' + item.mNum + '&boardNum=' + item.boardNum + '&requestMB=' + '${sessionScope.id}'
						+ '&responseMB=' + item.responseMb + '&state=confirm"><span class="hover">확인</span></button></td></tr>';
					output += '<tr><td><span class="mail-desc">연락처는 ' + item.responsePhone + '입니다.</span></td></tr>';
					output += '</div>';
					$('.alarmBlind').append(output);
					count = count + 1;
				});
				$(".total-count2").append(count);
			});
		});
		
		
		$('.scrollBlind').on('click', '.approvebtn', function(){
			messageData = $(this).val();
			messageBtn(this, messageData, messageUrl);
		});
		
		$('.scrollBlind').on('click', '.approvedbtn', function(){
			return false;
		});
		
		$('.scrollBlind').on('click', '.rejectbtn', function(){
			messageData = $(this).val();
			messageBtn(this, messageData, messageUrl);
		});
		
		$('.scrollBlind').on('click', '.canclebtn', function(){
			messageData = $(this).val();
			messageBtn(this, messageData, messageUrl);
		})
		
		$('.alarmBlind').on('click', '.confirmbtn', function(){
			messageData = $(this).val();
			messageBtn(this, messageData, messageUrl);
		});
	
	});
</script>
</head>
<body>
<div class="header" id="myHeader">
<a class="logo">DABONG.</a>
<div>
  <div class="header-right">
    
    <c:if test="${sessionScope.id == null }">
    	<a href="./login.net" class="right-menu">HOME</a>
    </c:if>
    <c:if test="${sessionScope.id != null }">
    	<a href="./boardMap.net" class="right-menu">HOME</a>
    </c:if>
    <a href="./NTBoardList.nt" class="right-menu">공지사항</a>
    <a href="./wboardList.wb" class="right-menu">복지자참여</a>
    <a href="./vboardList.vb" class="right-menu">봉사자참여</a>
    <a href="./news_board_album.news" class="right-menu">정보마당</a>
  </div>
  <c:if test="${sessionScope.id != null}">
  		<div class="dropdown3" style="height: 15px;">
			<i class="fa fa-bell"></i>
			<div class="dropdown-content3">
				<div class="drop-title"><strong class="total-count2"></strong>개의 알림이 있습니다.</div>
				<hr>
				<div class="alarmBlind">
				</div>
				<div class="end-title">복지의 최고봉, <strong>DABONG.</strong></div>
			</div>
			
			<span class="pulse pulse-content3" style="display:none;"></span>
		</div>
  <div class="dropdown2" style="height: 15px;">
			<i class="fa fa-envelope"></i>
			<div class="dropdown-content2">
				<div class="drop-title"><strong class="total-count"></strong>개의 메세지가 있습니다.</div>
				<hr>
				<div class="scrollBlind">
				</div>
				<hr>
				<div class="end-title">복지의 최고봉, <strong>DABONG.</strong></div>
			</div>
			
			<span class="pulse pulse-content2" style="display:none;"></span>
		</div>
<div class="dropdown1" style="height: 15px;">
<i class="fa fa-user"></i> ${sessionScope.id}
  <div class="dropdown-content1">
  	<c:if test="${sessionScope.user == '복지자' }">
    	<a href="./wrMyProfile.net" class="profile">프로필 보기</a>
    </c:if>
    <c:if test="${sessionScope.user == '봉사자' }">
    	<a href="./vtMyProfile.net" class="profile">프로필 보기</a>
    </c:if>
    <a href="logout.net" class="logout">로그아웃</a>
    <c:if test="${sessionScope.id == 'admin'}">
    	<a href="./admin.net">관리자 페이지</a>
    </c:if>
  </div>
</div>
</c:if>
</div>
</div>

</body>
</html>
