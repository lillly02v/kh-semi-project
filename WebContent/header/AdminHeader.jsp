<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<script src="http://code.jquery.com/jquery-latest.js"></script>
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
  width: 20%;
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
  width: 20%;
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

.header {
	z-index: 9999;
	height: 90px;
	overflow: hidden;
	background-color: white;
	padding: 20px 10px;
	box-sizing: border-box;
	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0
		rgba(0, 0, 0, 0.19);
}

.header div {
	align: center;
}

/*| ============================ |*/
/*| ======= Mail / Admin ======= |*/
/*| =======    start     ======= |*/
/*| ============================ |*/

div.dropdown1 {
	position: absolute;
	left: 181px;
}

div.dropdown2 {
	position: absolute;
	left: 146px;
}

.dropdown1:hover .dropdown-content1 {
	display: block;
}

.dropdown2:hover .dropdown-content2 {
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

.drop-title {
	padding: 10px;
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
	color: dodgerblue;
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
	color: dodgerblue;
	transition: 0.3s;
}

.header-right {
    float: right;
}

div {
    display: block;
}

/*| ============================ |*/
/*| ======= Mail / Admin ======= |*/
/*| =======    end       ======= |*/
/*| ============================ |*/

/*| ====================== |*/
/*| ======= scroll ======= |*/
/*| ======= start  ======= |*/
/*| ====================== |*/

.scrollBlind {
    height: 200px;
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

/*| ====================== |*/
/*| ======= close  ======= |*/
/*| ======= button ======= |*/
/*| ======= end    ======= |*/
/*| ====================== |*/

.header a.logo {
	font-size: 25px;
	font-weight: bold;
	background-color: white;
	color: black;
}

.header a.logo:hover {
	color: black;
	border-bottom: 3px solid black;
	border-top: 3px solid black;
	border-radius: 4px;
	border-left: 0px;
}

.header a:hover {
	color: dodgerblue;
	transition-duration: 0.5s;
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
</style>
</head>
<body>
	<div class="header" id="myHeader">
		<a href="" class="logo" style="margin-top: 0px;">DABONG.</a>
		<div class="dropdown2" style="height: 15px;">
			<i class="fa fa-envelope"></i>
			<div class="dropdown-content2">
				<div class="drop-title"><strong>4</strong>개의 새로운 요청이 있습니다</div>
				<hr>
				<div class="scrollBlind">
				<div class="mail-contnet">
				    <a href="#" class="close-button"></a>
					<a href="#">
						<h5>Michael Qin</h5>
						<span class="mail-desc">매칭을 요청했습니다.</span> 
						<span class="time">9:30 AM</span>
					</a>
					<button class="button1" style="vertical-align:middle"><span class="hover">수락</span></button>
					<button class="button2" style="vertical-align:middle"><span class="hover">거절</span></button>
				</div>
				<div class="mail-contnet">
				    <a href="#" class="close-button"></a>
					<a href="#">
						<h5>Michael Qin</h5>
						<span class="mail-desc">매칭을 요청했습니다.</span> 
						<span class="time">9:30 AM</span>
					</a>
					<button class="button1" style="vertical-align:middle"><span class="hover">수락</span></button>
					<button class="button2" style="vertical-align:middle"><span class="hover">거절</span></button>
				</div>
				<div class="mail-contnet">
				    <a href="#" class="close-button"></a>
					<a href="#">
						<h5>Michael Qin</h5>
						<span class="mail-desc">매칭을 요청했습니다.</span> 
						<span class="time">9:30 AM</span>
					</a> 
					<button class="button1" style="vertical-align:middle"><span class="hover">수락</span></button>
					<button class="button2" style="vertical-align:middle"><span class="hover">거절</span></button>
				</div> 
				<div class="mail-contnet">
				    <a href="#" class="close-button"></a>
					<a href="#">
						<h5>Michael Qin</h5>
						<span class="mail-desc">매칭을 요청했습니다.</span> 
						<span class="time">9:30 AM</span>
					</a>
					<button class="button1" style="vertical-align:middle"><span class="hover">수락</span></button>
					<button class="button2" style="vertical-align:middle"><span class="hover">거절</span></button> 
				</div>
				</div>
				<hr>
				<div class="end-title">복지의 최고봉, <strong>DABONG.</strong></div>
			</div>
			<span class="pulse"></span>
		</div>
		<div class="dropdown1" style="height: 15px;">
			<i class="fa fa-user"></i> Admin
			<div class="dropdown-content1">
				<a href="#">프로필 보기</a>
				<a href="#">로그아웃</a>
				<a href="#">관리자 페이지</a>
			</div>
		</div>
		<div class="header-right">
<a style="font-weight: bold;">Welcome! Admin!</a>
</div>
	</div>
	<script> $(".close-button").click(function () { $(".mail-contnet").remove(); }); </script>
</body>
</html>

