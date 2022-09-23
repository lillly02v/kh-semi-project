<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8");
	String job = request.getParameter("job");
	session.setAttribute("job", job);
%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link href="../../css/dajoin.css" rel="stylesheet">
<script src="../../js/jquery-3.3.1.js"></script>
<style>
	.w3-button{
			border: 3px solid #013ADF;
			margin: 20px 20px;
			width: 120px;
			height: 120px;
			}
</style>
</head>
<body>
	<div class="container address1-container">
		<h4 class="chapter">Chapter 4 - 1.</h4>
		<h1 class="select-name">당신의 주소는?</h1>
		<a href="join5.jsp?address1=서울시" class="w3-button w3-light-grey">서울</a>
		<a href="join5.jsp?address1=경기도" class="w3-button w3-light-grey">경기</a>
		<a href="join5.jsp?address1=인천시" class="w3-button w3-light-grey">인천</a>
		<a href="join5.jsp?address1=부산시" class="w3-button w3-light-grey">부산</a><br>
		<a href="join5.jsp?address1=대구시" class="w3-button w3-light-grey">대구</a>
		<a href="join5.jsp?address1=광주시" class="w3-button w3-light-grey">광주</a>
		<a href="join5.jsp?address1=대전시" class="w3-button w3-light-grey">대전</a>
		<a href="join5.jsp?address1=세종시" class="w3-button w3-light-grey">세종</a><br>
		<a href="join5.jsp?address1=울산시" class="w3-button w3-light-grey">울산</a>
		<a href="join5.jsp?address1=충청북도" class="w3-button w3-light-grey">충복</a>
		<a href="join5.jsp?address1=충청남도" class="w3-button w3-light-grey">충남</a>
		<a href="join5.jsp?address1=경상북도" class="w3-button w3-light-grey">경북</a><br>
		<a href="join5.jsp?address1=경상남도" class="w3-button w3-light-grey">경남</a>
		<a href="join5.jsp?address1=전라북도" class="w3-button w3-light-grey">전북</a>
		<a href="join5.jsp?address1=전라남도" class="w3-button w3-light-grey">전남</a>
		<a href="join5.jsp?address1=강원도" class="w3-button w3-light-grey">강원</a>
		<a href="join5.jsp?address1=제주시" class="w3-button w3-light-grey">제주</a>		
	</div>
</body>
</html>