<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="./css/w3schools.css">
<link href="./css/dajoin.css" rel="stylesheet">
<style>
	.login100-user{font-size: 30px;}
	.login100-radio{width: 20px; height: 20px;}
</style>
<script src="./js/jquery-3.3.1.js"></script>
<script src="./js/dapassfind.js"></script>
</head>
<body>
	<form method="post" class="personinfoform">
		<div class="container user-container">
			<h1 class="select-name">비밀번호가 기억나지 않으신가요?</h1><br><br>
			<table class="personinfo">
				<tr class="login100-user">
					<td colspan="2"><input type="radio" class="login100-radio user-welfare" name="user" value="복지자">
					<span class="welfare-text">복지자</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" class="login100-radio user-volunteer" name="user" value="봉사자">
					<span class="volunteer-text">봉사자</span><br><br></td>
				</tr>
				<tr>
					<td><span class="userinfo">아이디</span></td>
					<td><input type="text" name="userID"  class="usertext userID" placeholder="아이디를 입력하세요." maxlength="30" required></td>
				</tr>
				<tr>
					<td></td>
					<td class="msg messageID"></td>
				</tr>
				<tr>
					<td><span class="userinfo">이메일</span></td>
					<td><input type="email" name="userEmail" class="usertext userEmail" placeholder="example@gmail.com" maxlength="30" required><br></td>
				</tr>
				<tr>
					<td></td>
					<td class="msg messageEmail"></td>
				</tr>
				<tr>
				<tr>
					<td><span class="userinfo">전화번호</span></td>
					<td><input type="text" name="userPhone" class="usertext userPhone" placeholder="010-1111-2222" maxlength="30" required><br></td>
				</tr>
				<tr>
					<td></td>
					<td class="msg messagePhone"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="비밀번호 찾기" class="w3-button submitbtn">
					<input type="reset" value="로그인으로 이동" class="w3-button resetbtn"></td>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>