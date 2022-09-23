<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("UTF-8");
	String keyword = request.getParameter("keyword");
	session.setAttribute("keyword", keyword);
%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="./css/w3schools.css">
<link href="./css/dajoin.css" rel="stylesheet">
<script src="./js/jquery-3.3.1.js"></script>
<script src="./js/dajoin.js"></script>
<script>
$(document).ready(function(){
	var urlAddress = "";
	if('${sessionScope.user}' == '봉사자'){
		urlAddress = "vtIdCheck.net";
	} else {
		urlAddress = "wrIdCheck.net";
	}
	
	$('.userID').change(function(){
		if($.trim($(this).val()) == ''){
			alert('아이디를 입력하세요.');
			$(this).focus();
			return false;
		}
		
		sendId = $('.userID').serialize();
		$.ajax({
			type: "POST",
			data: sendId,
			url: urlAddress,
			success: function(response){
				if(response == 1){
					$('.messageID').html("사용 가능한 아이디 입니다.");
					$(".messageID").css('color', 'blue');
				} else if(response == 2){
					$('.messageID').html("admin 단어를 포함할 수 없습니다.");
					$(".messageID").css('color', 'red');
					$('.userID').val('');
					$('.userID').focus();
				} else {
					$('.messageID').html("중복된 아이디 입니다.");
					$(".messageID").css('color', 'red');
					$('.userID').val('');
					$('.userID').focus();
				}
			}
		});
	});
});

</script>
<style>
	.container{margin: 60px auto;}
</style>
</head>
<body>
	<%@ include file="../../header/Header.jsp" %>
	<form action="join7.net" method="post" class="personinfoform">
		<div class="container user-container">
			<h4 class="chapter">Chapter 5 - 1.</h4>
			<h1 class="select-name">당신의 인적사항은?</h1><br><br>
			<table class="personinfo">
				<tr>
					<td><span class="userinfo">아이디</span></td>
					<td><input type="text" name="userID"  class="usertext userID" placeholder="아이디를 입력하세요." maxlength="30" required></td>
				</tr>
				<tr>
					<td></td>
					<td class="msg messageID"></td>
				</tr>
				<tr>
					<td><span class="userinfo">비밀번호</span></td>
					<td><input type="password" name="userPW" class="usertext userPW" placeholder="비밀번호를 입력하세요." maxlength="30" required><br></td>
				</tr>
				<tr>
					<td></td>
					<td class="msg messagePW"></td>
				</tr>
				<tr>
					<td><span class="userinfo">비밀번호확인</span></td>
					<td><input type="password" name="userPWC" class="usertext userPWC" placeholder="비밀번호를 확인해주세요." maxlength="30" required><br></td>
				</tr>
				<tr>
					<td></td>
					<td class="msg messagePWC"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="넘어가기" class="w3-button submitbtn">
					<input type="reset" value="다시입력" class="w3-button resetbtn"></td>
				</tr>
			</table>
		</div>
	</form>
	<%@ include file="../../footer/Footer.jsp" %>
</body>
</html>