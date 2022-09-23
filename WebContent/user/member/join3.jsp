<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8");
	String gender = request.getParameter("gender");
	session.setAttribute("gender", gender);
%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="./css/w3schools.css">
<link href="./css/dajoin.css" rel="stylesheet">
<script src="./js/jquery-3.3.1.js"></script>
<style>
	.w3-button{
			margin: 50px 30px;
			padding:55px 0px;
			width: 180px;
			height: 180px;
			}
</style>
</head>
<body>
	<%@ include file="../../header/Header.jsp" %>
	<div class="container user-container">
		<h4 class="chapter">Chapter 3.</h4>
		<h1 class="select-name">당신의 직업군은?</h1><br><br>
		<a href="join4.net?job=학생" class="w3-button w3-light-grey student">학생</a>
		<a href="join4.net?job=직장인" class="w3-button w3-light-grey salary">직장인</a>
		<a href="join4.net?job=일반인" class="w3-button w3-light-grey normal">일반인</a>
		<a href="join4.net?job=기타" class="w3-button w3-light-grey etc">기타</a>
	</div>
	<%@ include file="../../footer/Footer.jsp" %>
</body>
</html>