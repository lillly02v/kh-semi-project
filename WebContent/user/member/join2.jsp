<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8");
	String user = request.getParameter("user");
	session.setAttribute("user", user);
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
			margin: 50px 60px;
			padding:70px 0px;
			width: 200px;
			height: 200px;
			}
</style>
</head>
<body>
	<%@ include file="../../header/Header.jsp" %>
	<div class="container user-container">
		<h4 class="chapter">Chapter 2.</h4>
		<h1 class="select-name">당신의 성별은?</h1><br><br>
		<a href="join3.net?gender=남자" class="w3-button w3-light-grey male">남자</a>
		<a href="join3.net?gender=여자" class="w3-button w3-light-grey female">여자</a>
		
	</div>
	
	<%@ include file="../../footer/Footer.jsp" %>
</body>
</html>