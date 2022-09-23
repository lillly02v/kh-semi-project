<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>봉사자 게시판</title>
<link type="text/css" rel="stylesheet" href="./css/Vboard_list.css" />
<link rel="stylesheet" href="./css/style(vboard).css">
<link rel="stylesheet" href="./css/normalize.css">
<script src="./js/jquery-3.3.1.js"></script>
<script>
	$(document).ready(function() {
		if('${sessionScope.id}' == ""){
			location.href="login.net";
		}
		
		$('.processState').trigger("click");
	
		$("#show").click(function() {
			$(".page").toggle();
		});
		$("#show1").click(function() {
			$(".page1").show();
			$(".page2").hide();
			$(".page3").hide();
			$(".page4").hide();
			$(".page5").hide();
			
		});
		$("#show2").click(function() {
			$(".page2").show();
			$(".page1").hide();
			$(".page3").hide();
			$(".page4").hide();
			$(".page5").hide();
			
		});
		$("#show3").click(function() {
			$(".page3").show();
			$(".page2").hide();
			$(".page1").hide();
			$(".page4").hide();
			$(".page5").hide();
			
		});
		$("#show4").click(function() {
			$(".page4").show();
			$(".page2").hide();
			$(".page3").hide();
			$(".page1").hide();
			$(".page5").hide();
			
		});
		$("#show5").click(function() {
			$(".page5").show();
			$(".page2").hide();
			$(".page3").hide();
			$(".page4").hide();
			$(".page1").hide();
			
		});
	});
	
	function processMethod(boardnum, responsemb){
		var sendData = 'boardNum=' + boardnum 
				+ "&" + 'responseMB=' + responsemb;
		var processState = '.probtn' + boardnum;
		$.ajax({
			type:"POST",
			data: sendData,
			url: 'vtProcessState.net',
			success: function(result){
				if(result == 1){
					$(processState).css('background-color', 'white');
					$(processState).css('color', 'black');
					$(processState).val('완료');
				}
				
			}
		})
	}
</script>
</head>
<body>
	
	<%@ include file="../../header/Header.jsp" %>
	<img style="margin-left:10%; margin-top:3%;" src="./images/home(dabong).png">&nbsp;>&nbsp;봉사자 참여
	<p style="text-align:left;" id="qav_head" class="vbo_head"><br><br>
		<strong style="font-size:40px; margin-left:9%">봉사자 참여 </strong>
	<br><br><br>
	<a style="margin-left:9%">봉사자가 직접 등록한 복지서비스 게시판 입니다.</a><br><br><br></p>
		<div id="searchForm" style="text-align: center">
		<form action="vboardList.vb" method="get">
			<table class="vboard-table" style="width:100%; text-align:center;">
				<tr>
					<th colspan="4"><select name="opt" size="1" style="height:36px; width:3; font-size:12px; vertical-align: middle;" >

							<option value="0">제목</option>
							<option value="1">내용</option>
							<option value="2">제목+내용</option>
							<option value="3">글쓴이</option>

					</select>&nbsp;<input class="search__input" name="condition" type="text" placeholder="검색어를 입력하세요..">
					<input style="background:#5D5D5D; color:white; border:1; height:38px; line-height: 28px; vertical-align:middle;" 	type="submit" value="검색"/></th>

				</tr>


			</table>

		</form>
	<br>
		<button id="show" style="background:#5D5D5D; color:white; border:0; height:45px; line-height: 28px; width: 200px; border-radius: 8px; font-size: 15px">상세검색</button>
		<br>
		<br>

		<form  action="vboardList.vb" method="get" class="page" style="display: none">
			<table class="vboard-table" style="height:100px; width:100%;" id="qav_head1" class="vbo_head1">

					<tr class="inputGroup">
					<th><input type="radio" id="show1"name="opt" value="4"><label for="show1">근무요일</label></th>
					<th><input type="radio" id="show2" name="opt" value="5"><label for="show2">근무시간</label></th>
					<th><input type="radio" id="show3" name="opt" value="6"><label for="show3">지역</label></th>
					<th><input type="radio" id="show4" name="opt" value="7"><label for="show4">종교</label></th>
				</tr>
				<tr class="page1" style="display: none">
					<th colspan="5">
    				<label for="rdo-1" class="btn-radio">
					<input type="radio" id="rdo-1" name="condition" value="월요일">
					<svg width="20px" height="20px" viewBox="0 0 20 20">
        			<circle cx="10" cy="10" r="9"></circle>
        			<path d="M10,7 C8.34314575,7 7,8.34314575 7,10 C7,11.6568542 8.34314575,13 10,13 C11.6568542,13 13,11.6568542 13,10 C13,8.34314575 11.6568542,7 10,7 Z" class="inner"></path>
        			<path d="M10,1 L10,1 L10,1 C14.9705627,1 19,5.02943725 19,10 L19,10 L19,10 C19,14.9705627 14.9705627,19 10,19 L10,19 L10,19 C5.02943725,19 1,14.9705627 1,10 L1,10 L1,10 C1,5.02943725 5.02943725,1 10,1 L10,1 Z" class="outer"></path>
      				</svg>
					<span>월요일</span>
					</label>
					<label for="rdo-2" class="btn-radio">
					<input type="radio"  id="rdo-2" name="condition" value="화요일">
					<svg width="20px" height="20px" viewBox="0 0 20 20">
        			<circle cx="10" cy="10" r="9"></circle>
        			<path d="M10,7 C8.34314575,7 7,8.34314575 7,10 C7,11.6568542 8.34314575,13 10,13 C11.6568542,13 13,11.6568542 13,10 C13,8.34314575 11.6568542,7 10,7 Z" class="inner"></path>
        			<path d="M10,1 L10,1 L10,1 C14.9705627,1 19,5.02943725 19,10 L19,10 L19,10 C19,14.9705627 14.9705627,19 10,19 L10,19 L10,19 C5.02943725,19 1,14.9705627 1,10 L1,10 L1,10 C1,5.02943725 5.02943725,1 10,1 L10,1 Z" class="outer"></path>
      				</svg>
						<span>화요일</span>
					</label>
					<label for="rdo-3" class="btn-radio">
					<input type="radio" id="rdo-3" name="condition" value="수요일">
					<svg width="20px" height="20px" viewBox="0 0 20 20">
        			<circle cx="10" cy="10" r="9"></circle>
        			<path d="M10,7 C8.34314575,7 7,8.34314575 7,10 C7,11.6568542 8.34314575,13 10,13 C11.6568542,13 13,11.6568542 13,10 C13,8.34314575 11.6568542,7 10,7 Z" class="inner"></path>
        			<path d="M10,1 L10,1 L10,1 C14.9705627,1 19,5.02943725 19,10 L19,10 L19,10 C19,14.9705627 14.9705627,19 10,19 L10,19 L10,19 C5.02943725,19 1,14.9705627 1,10 L1,10 L1,10 C1,5.02943725 5.02943725,1 10,1 L10,1 Z" class="outer"></path>
      				</svg>
					<span>수요일</span>
					</label>
					<label for="rdo-4" class="btn-radio">
					<input type="radio" id="rdo-4" name="condition" value="목요일">
					<svg width="20px" height="20px" viewBox="0 0 20 20">
        			<circle cx="10" cy="10" r="9"></circle>
        			<path d="M10,7 C8.34314575,7 7,8.34314575 7,10 C7,11.6568542 8.34314575,13 10,13 C11.6568542,13 13,11.6568542 13,10 C13,8.34314575 11.6568542,7 10,7 Z" class="inner"></path>
        			<path d="M10,1 L10,1 L10,1 C14.9705627,1 19,5.02943725 19,10 L19,10 L19,10 C19,14.9705627 14.9705627,19 10,19 L10,19 L10,19 C5.02943725,19 1,14.9705627 1,10 L1,10 L1,10 C1,5.02943725 5.02943725,1 10,1 L10,1 Z" class="outer"></path>
      				</svg>
					<span>목요일</span>
					</label>
					<label for="rdo-5" class="btn-radio">
					<input type="radio" id="rdo-5" name="condition" value="금요일">
					<svg width="20px" height="20px" viewBox="0 0 20 20">
        			<circle cx="10" cy="10" r="9"></circle>
        			<path d="M10,7 C8.34314575,7 7,8.34314575 7,10 C7,11.6568542 8.34314575,13 10,13 C11.6568542,13 13,11.6568542 13,10 C13,8.34314575 11.6568542,7 10,7 Z" class="inner"></path>
        			<path d="M10,1 L10,1 L10,1 C14.9705627,1 19,5.02943725 19,10 L19,10 L19,10 C19,14.9705627 14.9705627,19 10,19 L10,19 L10,19 C5.02943725,19 1,14.9705627 1,10 L1,10 L1,10 C1,5.02943725 5.02943725,1 10,1 L10,1 Z" class="outer"></path>
      				</svg>
					<span>금요일</span>
					</label>
					<label for="rdo-6" class="btn-radio">
					<input type="radio" id="rdo-6" name="condition" value="토요일">
					<svg width="20px" height="20px" viewBox="0 0 20 20">
        			<circle cx="10" cy="10" r="9"></circle>
        			<path d="M10,7 C8.34314575,7 7,8.34314575 7,10 C7,11.6568542 8.34314575,13 10,13 C11.6568542,13 13,11.6568542 13,10 C13,8.34314575 11.6568542,7 10,7 Z" class="inner"></path>
        			<path d="M10,1 L10,1 L10,1 C14.9705627,1 19,5.02943725 19,10 L19,10 L19,10 C19,14.9705627 14.9705627,19 10,19 L10,19 L10,19 C5.02943725,19 1,14.9705627 1,10 L1,10 L1,10 C1,5.02943725 5.02943725,1 10,1 L10,1 Z" class="outer"></path>
      				</svg>
					<span>토요일</span>
					</label>
					<label for="rdo-7" class="btn-radio">
					<input type="radio" id="rdo-7" name="condition" value="일요일">
					<svg width="20px" height="20px" viewBox="0 0 20 20">
        			<circle cx="10" cy="10" r="9"></circle>
        			<path d="M10,7 C8.34314575,7 7,8.34314575 7,10 C7,11.6568542 8.34314575,13 10,13 C11.6568542,13 13,11.6568542 13,10 C13,8.34314575 11.6568542,7 10,7 Z" class="inner"></path>
        			<path d="M10,1 L10,1 L10,1 C14.9705627,1 19,5.02943725 19,10 L19,10 L19,10 C19,14.9705627 14.9705627,19 10,19 L10,19 L10,19 C5.02943725,19 1,14.9705627 1,10 L1,10 L1,10 C1,5.02943725 5.02943725,1 10,1 L10,1 Z" class="outer"></path>
      				</svg>
					<span>일요일</span>
					</label>
					</th>
				</tr>

				<tr class="page2" style="display: none">
					<th colspan="5">
					<label for="rdo-8" class="btn-radio">
					<input type="radio" id="rdo-8" name="condition"  value="오전">
					<svg width="20px" height="20px" viewBox="0 0 20 20">
        			<circle cx="10" cy="10" r="9"></circle>
        			<path d="M10,7 C8.34314575,7 7,8.34314575 7,10 C7,11.6568542 8.34314575,13 10,13 C11.6568542,13 13,11.6568542 13,10 C13,8.34314575 11.6568542,7 10,7 Z" class="inner"></path>
        			<path d="M10,1 L10,1 L10,1 C14.9705627,1 19,5.02943725 19,10 L19,10 L19,10 C19,14.9705627 14.9705627,19 10,19 L10,19 L10,19 C5.02943725,19 1,14.9705627 1,10 L1,10 L1,10 C1,5.02943725 5.02943725,1 10,1 L10,1 Z" class="outer"></path>
      				</svg>
					<span>오전</span>
					</label>
					<label for="rdo-9" class="btn-radio">
					<input type="radio" id="rdo-9" name="condition"  value="오후">
					<svg width="20px" height="20px" viewBox="0 0 20 20">
        			<circle cx="10" cy="10" r="9"></circle>
        			<path d="M10,7 C8.34314575,7 7,8.34314575 7,10 C7,11.6568542 8.34314575,13 10,13 C11.6568542,13 13,11.6568542 13,10 C13,8.34314575 11.6568542,7 10,7 Z" class="inner"></path>
        			<path d="M10,1 L10,1 L10,1 C14.9705627,1 19,5.02943725 19,10 L19,10 L19,10 C19,14.9705627 14.9705627,19 10,19 L10,19 L10,19 C5.02943725,19 1,14.9705627 1,10 L1,10 L1,10 C1,5.02943725 5.02943725,1 10,1 L10,1 Z" class="outer"></path>
      				</svg>
					<span>오후</span>
					</label>
					<label for="rdo-10" class="btn-radio">
					<input type="radio" id="rdo-10" name="condition"  value="종일">
					<svg width="20px" height="20px" viewBox="0 0 20 20">
        			<circle cx="10" cy="10" r="9"></circle>
        			<path d="M10,7 C8.34314575,7 7,8.34314575 7,10 C7,11.6568542 8.34314575,13 10,13 C11.6568542,13 13,11.6568542 13,10 C13,8.34314575 11.6568542,7 10,7 Z" class="inner"></path>
        			<path d="M10,1 L10,1 L10,1 C14.9705627,1 19,5.02943725 19,10 L19,10 L19,10 C19,14.9705627 14.9705627,19 10,19 L10,19 L10,19 C5.02943725,19 1,14.9705627 1,10 L1,10 L1,10 C1,5.02943725 5.02943725,1 10,1 L10,1 Z" class="outer"></path>
      				</svg>
					<span>종일</span>
					</label>
					<label for="rdo-11" class="btn-radio">
					<input type="radio" id="rdo-11" name="condition"  value="시간협의">
					<svg width="20px" height="20px" viewBox="0 0 20 20">
        			<circle cx="10" cy="10" r="9"></circle>
        			<path d="M10,7 C8.34314575,7 7,8.34314575 7,10 C7,11.6568542 8.34314575,13 10,13 C11.6568542,13 13,11.6568542 13,10 C13,8.34314575 11.6568542,7 10,7 Z" class="inner"></path>
        			<path d="M10,1 L10,1 L10,1 C14.9705627,1 19,5.02943725 19,10 L19,10 L19,10 C19,14.9705627 14.9705627,19 10,19 L10,19 L10,19 C5.02943725,19 1,14.9705627 1,10 L1,10 L1,10 C1,5.02943725 5.02943725,1 10,1 L10,1 Z" class="outer"></path>
      				</svg>
					<span>시간협의</span>
					</label>
					</th>
				</tr>

				<tr class="page3" style="display: none">
					<th colspan="5">
					<label for="rdo-12" class="btn-radio">
					<input type="radio" id="rdo-12" name="condition"  value="서울">
					<svg width="20px" height="20px" viewBox="0 0 20 20">
        			<circle cx="10" cy="10" r="9"></circle>
        			<path d="M10,7 C8.34314575,7 7,8.34314575 7,10 C7,11.6568542 8.34314575,13 10,13 C11.6568542,13 13,11.6568542 13,10 C13,8.34314575 11.6568542,7 10,7 Z" class="inner"></path>
        			<path d="M10,1 L10,1 L10,1 C14.9705627,1 19,5.02943725 19,10 L19,10 L19,10 C19,14.9705627 14.9705627,19 10,19 L10,19 L10,19 C5.02943725,19 1,14.9705627 1,10 L1,10 L1,10 C1,5.02943725 5.02943725,1 10,1 L10,1 Z" class="outer"></path>
      				</svg>
					<span>서울</span>
					</label>
					<label for="rdo-13" class="btn-radio">
					<input type="radio" id="rdo-13" name="condition"  value="부산">
					<svg width="20px" height="20px" viewBox="0 0 20 20">
        			<circle cx="10" cy="10" r="9"></circle>
        			<path d="M10,7 C8.34314575,7 7,8.34314575 7,10 C7,11.6568542 8.34314575,13 10,13 C11.6568542,13 13,11.6568542 13,10 C13,8.34314575 11.6568542,7 10,7 Z" class="inner"></path>
        			<path d="M10,1 L10,1 L10,1 C14.9705627,1 19,5.02943725 19,10 L19,10 L19,10 C19,14.9705627 14.9705627,19 10,19 L10,19 L10,19 C5.02943725,19 1,14.9705627 1,10 L1,10 L1,10 C1,5.02943725 5.02943725,1 10,1 L10,1 Z" class="outer"></path>
      				</svg>
					<span>부산</span>
					</label>
					<label for="rdo-14" class="btn-radio">
					<input type="radio" id="rdo-14" name="condition"  value="대구">
					<svg width="20px" height="20px" viewBox="0 0 20 20">
        			<circle cx="10" cy="10" r="9"></circle>
        			<path d="M10,7 C8.34314575,7 7,8.34314575 7,10 C7,11.6568542 8.34314575,13 10,13 C11.6568542,13 13,11.6568542 13,10 C13,8.34314575 11.6568542,7 10,7 Z" class="inner"></path>
        			<path d="M10,1 L10,1 L10,1 C14.9705627,1 19,5.02943725 19,10 L19,10 L19,10 C19,14.9705627 14.9705627,19 10,19 L10,19 L10,19 C5.02943725,19 1,14.9705627 1,10 L1,10 L1,10 C1,5.02943725 5.02943725,1 10,1 L10,1 Z" class="outer"></path>
      				</svg>
					<span>대구</span>
					</label>
					<label for="rdo-15" class="btn-radio">
					<input type="radio" id="rdo-15" name="condition"  value="인천">
					<svg width="20px" height="20px" viewBox="0 0 20 20">
        			<circle cx="10" cy="10" r="9"></circle>
        			<path d="M10,7 C8.34314575,7 7,8.34314575 7,10 C7,11.6568542 8.34314575,13 10,13 C11.6568542,13 13,11.6568542 13,10 C13,8.34314575 11.6568542,7 10,7 Z" class="inner"></path>
        			<path d="M10,1 L10,1 L10,1 C14.9705627,1 19,5.02943725 19,10 L19,10 L19,10 C19,14.9705627 14.9705627,19 10,19 L10,19 L10,19 C5.02943725,19 1,14.9705627 1,10 L1,10 L1,10 C1,5.02943725 5.02943725,1 10,1 L10,1 Z" class="outer"></path>
      				</svg>
					<span>인천</span>
					</label>
					<label for="rdo-16" class="btn-radio">
					<input type="radio" id="rdo-16" name="condition"  value="광주">
					<svg width="20px" height="20px" viewBox="0 0 20 20">
        			<circle cx="10" cy="10" r="9"></circle>
        			<path d="M10,7 C8.34314575,7 7,8.34314575 7,10 C7,11.6568542 8.34314575,13 10,13 C11.6568542,13 13,11.6568542 13,10 C13,8.34314575 11.6568542,7 10,7 Z" class="inner"></path>
        			<path d="M10,1 L10,1 L10,1 C14.9705627,1 19,5.02943725 19,10 L19,10 L19,10 C19,14.9705627 14.9705627,19 10,19 L10,19 L10,19 C5.02943725,19 1,14.9705627 1,10 L1,10 L1,10 C1,5.02943725 5.02943725,1 10,1 L10,1 Z" class="outer"></path>
      				</svg>
					<span>광주</span>
					</label>
					<label for="rdo-17" class="btn-radio">
					<input type="radio" id="rdo-17" name="condition"  value="광주">
					<svg width="20px" height="20px" viewBox="0 0 20 20">
        			<circle cx="10" cy="10" r="9"></circle>
        			<path d="M10,7 C8.34314575,7 7,8.34314575 7,10 C7,11.6568542 8.34314575,13 10,13 C11.6568542,13 13,11.6568542 13,10 C13,8.34314575 11.6568542,7 10,7 Z" class="inner"></path>
        			<path d="M10,1 L10,1 L10,1 C14.9705627,1 19,5.02943725 19,10 L19,10 L19,10 C19,14.9705627 14.9705627,19 10,19 L10,19 L10,19 C5.02943725,19 1,14.9705627 1,10 L1,10 L1,10 C1,5.02943725 5.02943725,1 10,1 L10,1 Z" class="outer"></path>
      				</svg>
					<span>대전</span>
					</label>
					<label for="rdo-18" class="btn-radio">
					<input type="radio" id="rdo-18" name="condition"  value="울산">
					<svg width="20px" height="20px" viewBox="0 0 20 20">
        			<circle cx="10" cy="10" r="9"></circle>
        			<path d="M10,7 C8.34314575,7 7,8.34314575 7,10 C7,11.6568542 8.34314575,13 10,13 C11.6568542,13 13,11.6568542 13,10 C13,8.34314575 11.6568542,7 10,7 Z" class="inner"></path>
        			<path d="M10,1 L10,1 L10,1 C14.9705627,1 19,5.02943725 19,10 L19,10 L19,10 C19,14.9705627 14.9705627,19 10,19 L10,19 L10,19 C5.02943725,19 1,14.9705627 1,10 L1,10 L1,10 C1,5.02943725 5.02943725,1 10,1 L10,1 Z" class="outer"></path>
      				</svg>
					<span>울산</span>
					</label>
					<label for="rdo-19" class="btn-radio">
					<input type="radio" id="rdo-19" name="condition"  value="세종">
					<svg width="20px" height="20px" viewBox="0 0 20 20">
        			<circle cx="10" cy="10" r="9"></circle>
        			<path d="M10,7 C8.34314575,7 7,8.34314575 7,10 C7,11.6568542 8.34314575,13 10,13 C11.6568542,13 13,11.6568542 13,10 C13,8.34314575 11.6568542,7 10,7 Z" class="inner"></path>
        			<path d="M10,1 L10,1 L10,1 C14.9705627,1 19,5.02943725 19,10 L19,10 L19,10 C19,14.9705627 14.9705627,19 10,19 L10,19 L10,19 C5.02943725,19 1,14.9705627 1,10 L1,10 L1,10 C1,5.02943725 5.02943725,1 10,1 L10,1 Z" class="outer"></path>
      				</svg>
					<span>세종</span>
					</label>
					<label for="rdo-20" class="btn-radio">
					<input type="radio" id="rdo-20" name="condition"  value="경기">
					<svg width="20px" height="20px" viewBox="0 0 20 20">
        			<circle cx="10" cy="10" r="9"></circle>
        			<path d="M10,7 C8.34314575,7 7,8.34314575 7,10 C7,11.6568542 8.34314575,13 10,13 C11.6568542,13 13,11.6568542 13,10 C13,8.34314575 11.6568542,7 10,7 Z" class="inner"></path>
        			<path d="M10,1 L10,1 L10,1 C14.9705627,1 19,5.02943725 19,10 L19,10 L19,10 C19,14.9705627 14.9705627,19 10,19 L10,19 L10,19 C5.02943725,19 1,14.9705627 1,10 L1,10 L1,10 C1,5.02943725 5.02943725,1 10,1 L10,1 Z" class="outer"></path>
      				</svg>
					<span>경기</span>
					</label>
					<label for="rdo-21" class="btn-radio">
					<input type="radio" id="rdo-21" name="condition"  value="강원">
					<svg width="20px" height="20px" viewBox="0 0 20 20">
        			<circle cx="10" cy="10" r="9"></circle>
        			<path d="M10,7 C8.34314575,7 7,8.34314575 7,10 C7,11.6568542 8.34314575,13 10,13 C11.6568542,13 13,11.6568542 13,10 C13,8.34314575 11.6568542,7 10,7 Z" class="inner"></path>
        			<path d="M10,1 L10,1 L10,1 C14.9705627,1 19,5.02943725 19,10 L19,10 L19,10 C19,14.9705627 14.9705627,19 10,19 L10,19 L10,19 C5.02943725,19 1,14.9705627 1,10 L1,10 L1,10 C1,5.02943725 5.02943725,1 10,1 L10,1 Z" class="outer"></path>
      				</svg>
					<span>강원</span>
					</label>
					<label for="rdo-22" class="btn-radio">
					<input type="radio" id="rdo-22" name="condition"  value="충북">
					<svg width="20px" height="20px" viewBox="0 0 20 20">
        			<circle cx="10" cy="10" r="9"></circle>
        			<path d="M10,7 C8.34314575,7 7,8.34314575 7,10 C7,11.6568542 8.34314575,13 10,13 C11.6568542,13 13,11.6568542 13,10 C13,8.34314575 11.6568542,7 10,7 Z" class="inner"></path>
        			<path d="M10,1 L10,1 L10,1 C14.9705627,1 19,5.02943725 19,10 L19,10 L19,10 C19,14.9705627 14.9705627,19 10,19 L10,19 L10,19 C5.02943725,19 1,14.9705627 1,10 L1,10 L1,10 C1,5.02943725 5.02943725,1 10,1 L10,1 Z" class="outer"></path>
      				</svg>
					<span>충북</span>
					</label>
					<label for="rdo-23" class="btn-radio">
					<input type="radio" id="rdo-23" name="condition"  value="충남">
					<svg width="20px" height="20px" viewBox="0 0 20 20">
        			<circle cx="10" cy="10" r="9"></circle>
        			<path d="M10,7 C8.34314575,7 7,8.34314575 7,10 C7,11.6568542 8.34314575,13 10,13 C11.6568542,13 13,11.6568542 13,10 C13,8.34314575 11.6568542,7 10,7 Z" class="inner"></path>
        			<path d="M10,1 L10,1 L10,1 C14.9705627,1 19,5.02943725 19,10 L19,10 L19,10 C19,14.9705627 14.9705627,19 10,19 L10,19 L10,19 C5.02943725,19 1,14.9705627 1,10 L1,10 L1,10 C1,5.02943725 5.02943725,1 10,1 L10,1 Z" class="outer"></path>
      				</svg>
					<span>충남</span>
          </label>
          <label for="rdo-24" class="btn-radio">
          <input type="radio" id="rdo-24" name="condition"  value="전북">
          <svg width="20px" height="20px" viewBox="0 0 20 20">
              <circle cx="10" cy="10" r="9"></circle>
              <path d="M10,7 C8.34314575,7 7,8.34314575 7,10 C7,11.6568542 8.34314575,13 10,13 C11.6568542,13 13,11.6568542 13,10 C13,8.34314575 11.6568542,7 10,7 Z" class="inner"></path>
              <path d="M10,1 L10,1 L10,1 C14.9705627,1 19,5.02943725 19,10 L19,10 L19,10 C19,14.9705627 14.9705627,19 10,19 L10,19 L10,19 C5.02943725,19 1,14.9705627 1,10 L1,10 L1,10 C1,5.02943725 5.02943725,1 10,1 L10,1 Z" class="outer"></path>
              </svg>
          <span>전북</span>
          </label>
          <label for="rdo-25" class="btn-radio">
          <input type="radio" id="rdo-25" name="condition"  value="전남">
          <svg width="20px" height="20px" viewBox="0 0 20 20">
              <circle cx="10" cy="10" r="9"></circle>
              <path d="M10,7 C8.34314575,7 7,8.34314575 7,10 C7,11.6568542 8.34314575,13 10,13 C11.6568542,13 13,11.6568542 13,10 C13,8.34314575 11.6568542,7 10,7 Z" class="inner"></path>
              <path d="M10,1 L10,1 L10,1 C14.9705627,1 19,5.02943725 19,10 L19,10 L19,10 C19,14.9705627 14.9705627,19 10,19 L10,19 L10,19 C5.02943725,19 1,14.9705627 1,10 L1,10 L1,10 C1,5.02943725 5.02943725,1 10,1 L10,1 Z" class="outer"></path>
              </svg>
          <span>전남</span>
          </label>
          <label for="rdo-26" class="btn-radio">
          <input type="radio" id="rdo-26" name="condition"  value="경북">
          <svg width="20px" height="20px" viewBox="0 0 20 20">
              <circle cx="10" cy="10" r="9"></circle>
              <path d="M10,7 C8.34314575,7 7,8.34314575 7,10 C7,11.6568542 8.34314575,13 10,13 C11.6568542,13 13,11.6568542 13,10 C13,8.34314575 11.6568542,7 10,7 Z" class="inner"></path>
              <path d="M10,1 L10,1 L10,1 C14.9705627,1 19,5.02943725 19,10 L19,10 L19,10 C19,14.9705627 14.9705627,19 10,19 L10,19 L10,19 C5.02943725,19 1,14.9705627 1,10 L1,10 L1,10 C1,5.02943725 5.02943725,1 10,1 L10,1 Z" class="outer"></path>
              </svg>
          <span>경북</span>
          </label>
          <label for="rdo-27" class="btn-radio">
          <input type="radio" id="rdo-27" name="condition"  value="경남">
          <svg width="20px" height="20px" viewBox="0 0 20 20">
              <circle cx="10" cy="10" r="9"></circle>
              <path d="M10,7 C8.34314575,7 7,8.34314575 7,10 C7,11.6568542 8.34314575,13 10,13 C11.6568542,13 13,11.6568542 13,10 C13,8.34314575 11.6568542,7 10,7 Z" class="inner"></path>
              <path d="M10,1 L10,1 L10,1 C14.9705627,1 19,5.02943725 19,10 L19,10 L19,10 C19,14.9705627 14.9705627,19 10,19 L10,19 L10,19 C5.02943725,19 1,14.9705627 1,10 L1,10 L1,10 C1,5.02943725 5.02943725,1 10,1 L10,1 Z" class="outer"></path>
              </svg>
          <span>경남</span>
          </label>
          <label for="rdo-28" class="btn-radio">
          <input type="radio" id="rdo-28" name="condition"  value="제주">
          <svg width="20px" height="20px" viewBox="0 0 20 20">
              <circle cx="10" cy="10" r="9"></circle>
              <path d="M10,7 C8.34314575,7 7,8.34314575 7,10 C7,11.6568542 8.34314575,13 10,13 C11.6568542,13 13,11.6568542 13,10 C13,8.34314575 11.6568542,7 10,7 Z" class="inner"></path>
              <path d="M10,1 L10,1 L10,1 C14.9705627,1 19,5.02943725 19,10 L19,10 L19,10 C19,14.9705627 14.9705627,19 10,19 L10,19 L10,19 C5.02943725,19 1,14.9705627 1,10 L1,10 L1,10 C1,5.02943725 5.02943725,1 10,1 L10,1 Z" class="outer"></path>
              </svg>
          <span>제주</span>
          </label>
             </th>
        </tr>




        <tr class="page4" style="display: none">
          <th colspan="5">
          <label for="rdo-29" class="btn-radio">
          <input type="radio" id="rdo-29" name="condition"  value="기독교">
          <svg width="20px" height="20px" viewBox="0 0 20 20">
              <circle cx="10" cy="10" r="9"></circle>
        			<path d="M10,7 C8.34314575,7 7,8.34314575 7,10 C7,11.6568542 8.34314575,13 10,13 C11.6568542,13 13,11.6568542 13,10 C13,8.34314575 11.6568542,7 10,7 Z" class="inner"></path>
              <path d="M10,1 L10,1 L10,1 C14.9705627,1 19,5.02943725 19,10 L19,10 L19,10 C19,14.9705627 14.9705627,19 10,19 L10,19 L10,19 C5.02943725,19 1,14.9705627 1,10 L1,10 L1,10 C1,5.02943725 5.02943725,1 10,1 L10,1 Z" class="outer"></path>
              </svg>
          <span>기독교</span>
          </label>
          <label for="rdo-30" class="btn-radio">
          <input type="radio" id="rdo-30" name="condition"  value="이슬람교">
          <svg width="20px" height="20px" viewBox="0 0 20 20">
              <circle cx="10" cy="10" r="9"></circle>
              <path d="M10,7 C8.34314575,7 7,8.34314575 7,10 C7,11.6568542 8.34314575,13 10,13 C11.6568542,13 13,11.6568542 13,10 C13,8.34314575 11.6568542,7 10,7 Z" class="inner"></path>
              <path d="M10,1 L10,1 L10,1 C14.9705627,1 19,5.02943725 19,10 L19,10 L19,10 C19,14.9705627 14.9705627,19 10,19 L10,19 L10,19 C5.02943725,19 1,14.9705627 1,10 L1,10 L1,10 C1,5.02943725 5.02943725,1 10,1 L10,1 Z" class="outer"></path>
              </svg>
          <span>이슬람교</span>
          </label>
          <label for="rdo-31" class="btn-radio">
          <input type="radio" id="rdo-31" name="condition"  value="유대교">
          <svg width="20px" height="20px" viewBox="0 0 20 20">
              <circle cx="10" cy="10" r="9"></circle>
              <path d="M10,7 C8.34314575,7 7,8.34314575 7,10 C7,11.6568542 8.34314575,13 10,13 C11.6568542,13 13,11.6568542 13,10 C13,8.34314575 11.6568542,7 10,7 Z" class="inner"></path>
              <path d="M10,1 L10,1 L10,1 C14.9705627,1 19,5.02943725 19,10 L19,10 L19,10 C19,14.9705627 14.9705627,19 10,19 L10,19 L10,19 C5.02943725,19 1,14.9705627 1,10 L1,10 L1,10 C1,5.02943725 5.02943725,1 10,1 L10,1 Z" class="outer"></path>
              </svg>
          <span>유대교</span>
          </label>
          <label for="rdo-32" class="btn-radio">
          <input type="radio" id="rdo-32" name="condition"  value="불교">
          <svg width="20px" height="20px" viewBox="0 0 20 20">
              <circle cx="10" cy="10" r="9"></circle>
              <path d="M10,7 C8.34314575,7 7,8.34314575 7,10 C7,11.6568542 8.34314575,13 10,13 C11.6568542,13 13,11.6568542 13,10 C13,8.34314575 11.6568542,7 10,7 Z" class="inner"></path>
              <path d="M10,1 L10,1 L10,1 C14.9705627,1 19,5.02943725 19,10 L19,10 L19,10 C19,14.9705627 14.9705627,19 10,19 L10,19 L10,19 C5.02943725,19 1,14.9705627 1,10 L1,10 L1,10 C1,5.02943725 5.02943725,1 10,1 L10,1 Z" class="outer"></path>
              </svg>
          <span>불교</span>
          </label>
          <label for="rdo-33" class="btn-radio">
          <input type="radio" id="rdo-33" name="condition"  value="무교">
          <svg width="20px" height="20px" viewBox="0 0 20 20">
              <circle cx="10" cy="10" r="9"></circle>
              <path d="M10,7 C8.34314575,7 7,8.34314575 7,10 C7,11.6568542 8.34314575,13 10,13 C11.6568542,13 13,11.6568542 13,10 C13,8.34314575 11.6568542,7 10,7 Z" class="inner"></path>
              <path d="M10,1 L10,1 L10,1 C14.9705627,1 19,5.02943725 19,10 L19,10 L19,10 C19,14.9705627 14.9705627,19 10,19 L10,19 L10,19 C5.02943725,19 1,14.9705627 1,10 L1,10 L1,10 C1,5.02943725 5.02943725,1 10,1 L10,1 Z" class="outer"></path>
              </svg>
          <span>무교</span>
          </label>
          </th>
        </tr>

    </table>
			<br>
			<input style="background:#5D5D5D; color:white; border:1px; height:28px; line-height: 28px; width: 100px; border-radius: 8px;"  type="submit" value="검색">
			<input style="background:#5D5D5D; color:white; border:1px; height:28px; line-height: 28px; width: 100px; border-radius: 8px;" type="reset" value="초기화">
		</form>

	</div>
	<br>
	<table class="vboard-table" id="list">

		<tr>
			<th width="6%"><div>번호</div></th>
			<th width="40%"><div>제목</div></th>
			<th width="15%"><div>작성자</div></th>
			<th width="25%"><div>날짜</div></th>
			<th width="6%"><div>조회수</div></th>
			<th width="8%"><div>상태</div></th>
		</tr>
		<c:set var="num" value="${listcount-(spage-1) * 10}" />
		<c:forEach var="b" items="${boardlist}">
			<tr>
				<td><c:out value="${num}" /> <%-- num 출력 --%> <c:set var="num"
						value="${num-1}" /> <%-- num = num - 1 --%></td>
				<td>
					<div>

						<a href="./vboardDetailAction.vb?num=${b.vbnum}"> ${b.vbsub} </a>
					</div>
				</td>
				<td>
					<div>${b.vname}</div>
				</td>
				<td>
					<div>${b.vbdate}</div>
				</td>
				<td>
					<div>${b.vbreadcount}</div>
				</td>

				<td style="text-align:center">
					<input type="submit" class="processState probtn${b.vbnum}" value="진행" style="background:#5D5D5D; board-radius:10px; color:white; border:1; height:29px; line-height: 28px; width:54px;" onclick="processMethod('${b.vbnum}', '${b.vid}');">
				</td>
			</tr>
		</c:forEach>
		</table>
		<form action="vboardWrite.vb" method="get" style="height:28px;">
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
<c:if test="${sessionScope.user == '봉사자' || sessionScope.id == 'admin'}">
    <center><input id="button" type="submit" value="봉사자 등록하기" style="border: 1px; border-radius: 8px; width: 200px;"/></center>
    </c:if>


</form>
		<br>
		<table class="vboard-table">
		<tr  class="h30 lime center btn" style="color:#6799FF;">
		<c:if test="${null eq opt}">
		
			<td colspan=5><c:if test="${spage <= 1}">
					이전&nbsp;
				</c:if> <c:if test="${spage > 1}">
					<a href="./vboardList.vb?page=${spage-1}">이전</a>｜
				</c:if> <c:forEach var="a" begin="${startpage}" end="${endpage}">
					<c:if test="${a == spage}">
						${a}
					</c:if>
					<c:if test="${a != spage}">
						<a href="./vboardList.vb?page=${a}">${a}</a>
					</c:if>
				</c:forEach> <c:if test="${spage >= maxpage}">
					다음
				</c:if> <c:if test="${spage < maxpage}">｜
					<a href="./vboardList.vb?page=${spage + 1}">다음</a>
				</c:if></td>
				</c:if>
		<c:if test="${null ne opt}">
		
			<td colspan=5><c:if test="${spage <= 1}">
					이전&nbsp;
				</c:if> <c:if test="${spage > 1}">
					<a href="./vboardList.vb?page=${spage-1}&opt=${opt}&condition=${condition}">이전</a>｜
				</c:if> <c:forEach var="a" begin="${startpage}" end="${endpage}">
					<c:if test="${a == spage}">
						${a}
					</c:if>
					<c:if test="${a != spage}">
						<a href="./vboardList.vb?page=${a}&opt=${opt}&condition=${condition}">${a}</a>
					</c:if>
				</c:forEach> <c:if test="${spage >= maxpage}">
					다음
				</c:if> <c:if test="${spage < maxpage}">｜
					<a href="./vboardList.vb?page=${spage + 1}&opt=${opt}&condition=${condition}">&nbsp;다음</a>
				</c:if></td>
				</c:if>
				
				
				
		</tr>
		<!-- 레코드가 없으면 -->
		<c:if test="${listcount == 0}">
			<tr>
				<td style="text-align: right"><font size=2>등록된 글이 없습니다.
				</font></td>
			</tr>
		</c:if>
		
		
	</table>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<%@ include file="../../footer/Footer.jsp" %>
</body>
</html>