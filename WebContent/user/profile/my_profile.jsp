<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!------ Include the above in your HEAD tag ---------->

<!---************* arrangement by john niro yumang b4.0 alpha project graduation ******************* -->

<!DOCTYPE html>
<html lang="utf-8">
	
	<title>본인 프로필</title>

		<!-- Required meta tags -->
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
	<!------------start head  scripts and link src------------>
	<head>
	<link href="./css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<style>
	body {

background-color:white;
background-repeat:no-repeat;
background-position:center;
height:1200px;
}
/*----------------Containers--------------------*/

#top-container-fluid-nav
{
background-color:inherit;	
background-attachment:scroll;
background-repeat:no-repeat;
background-position:center;
background-size:cover	;
}

#header-container-fluid
{
background-color:inherit;	
background-attachment:scroll;
background-repeat:no-repeat;
background-position:center;
background-size:cover;
padding-top:25px;	
}

#body-container-fluid
{
background-color:inherit;	
background-attachment:scroll;
background-repeat:no-repeat;
background-position:center;
background-size:cover;
margin-top:50px;		
}

#footer-container-fluid
{
background-color:inherit;	
background-attachment:scroll;
background-repeat:no-repeat;
background-position:center;
background-size:cover;
padding-bottom:25px;
padding-top:25px;	
}

.card 
{
padding:10px;
border:0px solid white;
box-shadow:0px 7px 16px 0px rgba(0, 0, 0, 0.09);
}
.card-title
{
color:;
font-size:35px;
text-align:center;
}
.card-text
{
color:#84919B;
font-size:14px;	
text-align:center;
margin-bottom: 2rem;

}

#courses  
{
text-align:center;
}

/**********************
		courses
**********************/

.list-inline{
	margin-top: 2rem;
	margin-bottom: 1rem;
}

.list-inline-item 
{
font-size:18px;
color:#84919B;
 }
 
 .pfile-list{
	height: 110px;
    overflow-y: scroll;
 }
/**********************
		courses
**********************/


.address .w3-ul li
 {
	border:0px solid white;
	line-height:1px;
}


/**********************
		abilities
**********************/
span 
{
font-size:10px;
float:right;
background-color:#F4F7F9;
border-radius:10px;
padding:3px 3px;
color:#84919B;
}
.lower-case
{
color:#84919B;
font-size:12px;
text-align:center;
}

/**********************
		abilities
**********************/


/**********************
		ratings
**********************/

.ratings .fa
{
color:indigo;
font-size:25px;
}
.ratings .fa:hover
{
color:yellow;
}
.ratings .list-inline
{
text-align:center;
}

/**********************
		ratings
**********************/


/**********************
		socials
**********************/
.socials {
text-align:center;transition:0.3s;
}
.list-inline:hover{
transition:0.3s;
} 

.memberName{color:black;}

/**********************
		socials
**********************/


 /**********************
		footer
**********************/
.learn {font-size:12px;color:gray;text-align:center;transition:0.3s;}
.learn a:hover {text-decoration:none;transition:0.3s;}
/**********************
		footer
**********************/
 
 
	</style>
	
		<link rel="stylesheet" href="./css/w3.css">
		<!--- This is the local w3css extended --->
		
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css">
		<!-------    font awesome online plug --------------->
		<script src="./js/jquery-3.3.1.js"></script>
 	<script>
 		$(document).ready(function(){
 			
 			var userUrl = "";
 			var boardUrl = "";
 			var updateUrl = "";
 			var userData = "userId=" + '${sessionScope.id}';
 			
 			if('${sessionScope.user}' == '봉사자'){
 				userUrl = 'vtProfileProcess.net';
 				boardUrl = 'vboardDetailAction.vb';
 				updateUrl = './vtUpdateView.net'
 				updateDeleteMethod(updateUrl);
 				
 			} else if('${sessionScope.user}' == '복지자'){
 				userUrl = 'wrProfileProcess.net';
 				boardUrl = 'wboardDetailAction.wb';
 				updateUrl = './wrUpdateView.net';
 				updateDeleteMethod(updateUrl);
 			}
 			
 			function updateDeleteMethod(updateUrl){
 	 			$('.updatebtn').click(function(){
 						location.href= updateUrl
 					});
 					
 					$('.deletebtn').click(function(){
 						location.href="./delete.net";
 					})
 	 		}
 			
 			$.getJSON(userUrl, userData, function(list){
 				$(list).each(function(index, item){
 					var output = "";
 					output += '<li><a href="./'+ boardUrl +'?num=' + item.boardNum + '">' + item.pfile + ' </a></li>'
 					$('.pfile-list').append(output);
 				});
 			});
 		});
 		
 		
 	</script>

	</head>
	<!-------------end head scripts and link src ------------->
	<!------------start content ------------>
	<body>
		<jsp:include page="../../header/Header.jsp" />
		<div class="wrapper">
			<div class="container-fluid" id="top-container-fluid-nav">
				<div class="container">	
					<!---- for nav container ----->	
				</div>
			</div> 
			
					
			<div class="container-fluid" id="body-container-fluid">
				<div class="container">
					<!---- for body container ---->
					<div class="row">
						 <!-------mother container middle class------------------->
						<div class="col-lg-12">
						<div class="card" style="width:100%">
							<div class="card-img-top" style="width:100%; color:dodgerblue">
							<div class="card-body">
							  <h4 class="card-title">${member.name}</h4>
							  	<ul class="list-inline" id="courses">
									<li class="list-inline-item">
										<i class="fa fa-folder-open-o"></i> ${member.id}
									</li>
									
								</ul>
								<c:if test="${sessionScope.secret == '공개'}">
								 <p class="card-text">${member.key}</p>

								<div class="address">								
								<ul class="w3-ul w3-medium">
									<li> <i class="fa fa-calendar-o" aria-hidden="true"></i>  <b class="memberName">${member.address}</b></li>
									<li><i class="fa fa-calendar-o" aria-hidden="true"></i>  <b class="memberName">${member.email}</b></li>
									<li><i class="fa fa-calendar-o" aria-hidden="true"></i>  <b class="memberName">${member.gender}</b></li>
									<li><i class="fa fa-calendar-o" aria-hidden="true"></i>  <b class="memberName">${userAge}대</b></li>
									<li><i class="fa fa-calendar-o" aria-hidden="true"></i>  <b class="memberName">${member.date}</b></li>
								</ul>
								</div>
								</c:if>
								
								<c:if test="${sessionScope.secret == '비공개'}">
								 <p class="card-text">공개를 원치 않습니다.</p>

								<div class="address">								
								<ul class="w3-ul w3-medium">
									<li> <i class="fa fa-calendar-o" aria-hidden="true"></i>  <b class="memberName">공개를 원치 않습니다.</b></li>
									<li><i class="fa fa-calendar-o" aria-hidden="true"></i>  <b class="memberName">공개를 원치 않습니다.</b></li>
									<li><i class="fa fa-calendar-o" aria-hidden="true"></i>  <b class="memberName">공개를 원치 않습니다.</b></li>
									<li><i class="fa fa-calendar-o" aria-hidden="true"></i>  <b class="memberName">공개를 원치 않습니다.</b></li>
									<li><i class="fa fa-calendar-o" aria-hidden="true"></i>  <b class="memberName">공개를 원치 않습니다.</b></li>
								</ul>
								</div>
								</c:if>
							 <p><button class="w3-button w3-block w3-indigo updatebtn" data-toggle="tooltip" data-placement="top" title="Free to message and hire us"> <i class="fa fa-comment-o fa-lg"></i> 수정하기 </button></p>
							 <p><button class="w3-button w3-block w3-red deletebtn" data-toggle="tooltip" data-placement="top" title="Free to message and hire us"> <i class="fa fa-comment-o fa-lg"></i> 탈퇴하기 </button></p>
							</div>
							
								<ul class="w3-ul w3-small pfile-list">
								</ul>
							 
							<hr>
							
							<div class="socials">
							<ul class="list-inline">
								<button class="w3-button w3-indigo"><i class="fa fa-facebook"></i></button>
								<button class="w3-button w3-blue"><i class="fa fa-twitter"></i></button>
								<button class="w3-button w3-blue-grey"><i class="fa fa-instagram"></i></button>
 							</ul>
 							</div>
							
							<p class="learn"><a href=""> Learn more </a> | <a href=""> Adveratise </a> |  <a href=""> Cookies </a> | <a href=""> Terms & Policy </a> </p>
							
							<hr>
							
						</div>
  
						</div>		
					</div>
				</div>
			</div>
			<div class="container-fluid" id="footer-container-fluid">
				<div class="container">
					<!---- for footer container ---->
 				</div>
			</div>
		</div>
 	</body>
	<!-------------end content-------------->
	
	<!------------in-line script purpose ------------>
	<!------------in-line style purpose ------------>
