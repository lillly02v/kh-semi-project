<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("UTF-8");
	String address1 = request.getParameter("address1");
	session.setAttribute("address1", address1);
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
		<h4 class="chapter">Chapter 4 - 2.</h4>
		<h1 class="select-name">당신의 주소는?</h1>
		<c:if test="${param.address1=='서울시'}">
			<a href="join6.jsp?address2=강남구" class="w3-button w3-light-grey">강남</a>
			<a href="join6.jsp?address2=강동구" class="w3-button w3-light-grey">강동</a>
			<a href="join6.jsp?address2=강북구" class="w3-button w3-light-grey">강북</a>
			<a href="join6.jsp?address2=강서구" class="w3-button w3-light-grey">강서</a>
			<a href="join6.jsp?address2=관악구" class="w3-button w3-light-grey">관악</a>
			<a href="join6.jsp?address2=광진구" class="w3-button w3-light-grey">광진</a><br>
			<a href="join6.jsp?address2=구로구" class="w3-button w3-light-grey">구로</a>
			<a href="join6.jsp?address2=금천구" class="w3-button w3-light-grey">금천</a>
			<a href="join6.jsp?address2=노원구" class="w3-button w3-light-grey">노원</a>
			<a href="join6.jsp?address2=도봉구" class="w3-button w3-light-grey">도봉</a>
			<a href="join6.jsp?address2=동대문구" class="w3-button w3-light-grey">동대문</a>
			<a href="join6.jsp?address2=동작구" class="w3-button w3-light-grey">동작</a><br>
			<a href="join6.jsp?address2=마포구" class="w3-button w3-light-grey">마포</a>
			<a href="join6.jsp?address2=서대문구" class="w3-button w3-light-grey">서대문</a>
			<a href="join6.jsp?address2=서초구" class="w3-button w3-light-grey">서초</a>
			<a href="join6.jsp?address2=성동구" class="w3-button w3-light-grey">성동</a>
			<a href="join6.jsp?address2=성북구" class="w3-button w3-light-grey">성북</a>
			<a href="join6.jsp?address2=송파구" class="w3-button w3-light-grey">송파</a><br>
			<a href="join6.jsp?address2=양천구" class="w3-button w3-light-grey">양천</a>
			<a href="join6.jsp?address2=영등포구" class="w3-button w3-light-grey">영등포</a>
			<a href="join6.jsp?address2=용산구" class="w3-button w3-light-grey">용산</a>
			<a href="join6.jsp?address2=은평구" class="w3-button w3-light-grey">은평</a>
			<a href="join6.jsp?address2=종로구" class="w3-button w3-light-grey">종로</a>
			<a href="join6.jsp?address2=중구" class="w3-button w3-light-grey">중구</a>
			<a href="join6.jsp?address2=중랑구" class="w3-button w3-light-grey">중랑</a>	
		</c:if>
		
		<c:if test="${param.address1=='인천시'}">
			<a href="join6.jsp?address2=중구" class="w3-button w3-light-grey">중구</a>
			<a href="join6.jsp?address2=동구" class="w3-button w3-light-grey">동구</a>
			<a href="join6.jsp?address2=남구" class="w3-button w3-light-grey">남구</a>
			<a href="join6.jsp?address2=연수구" class="w3-button w3-light-grey">연수구</a><br>
			<a href="join6.jsp?address2=남동구" class="w3-button w3-light-grey">남동구</a>
			<a href="join6.jsp?address2=부평구" class="w3-button w3-light-grey">부평구</a>
			<a href="join6.jsp?address2=계양구" class="w3-button w3-light-grey">계양구</a>
			<a href="join6.jsp?address2=서구" class="w3-button w3-light-grey">서구</a>
		</c:if> 
		
		<c:if test="${param.address1=='부산시'}">
			<a href="join6.jsp?address2=중구" class="w3-button w3-light-grey">중구</a>
			<a href="join6.jsp?address2=서구" class="w3-button w3-light-grey">서구</a>
			<a href="join6.jsp?address2=동구" class="w3-button w3-light-grey">동구</a>
			<a href="join6.jsp?address2=영도구" class="w3-button w3-light-grey">영도</a>
			<a href="join6.jsp?address2=부산진구" class="w3-button w3-light-grey">부산진</a><br>
			<a href="join6.jsp?address2=동래구" class="w3-button w3-light-grey">동래</a>
			<a href="join6.jsp?address2=남구" class="w3-button w3-light-grey">남구</a>
			<a href="join6.jsp?address2=북구" class="w3-button w3-light-grey">북구</a>
			<a href="join6.jsp?address2=강서구" class="w3-button w3-light-grey">강서</a>
			<a href="join6.jsp?address2=해운대구" class="w3-button w3-light-grey">해운대</a><br>
			<a href="join6.jsp?address2=사하구" class="w3-button w3-light-grey">사하</a>
			<a href="join6.jsp?address2=금정구" class="w3-button w3-light-grey">금정</a>
			<a href="join6.jsp?address2=연제구" class="w3-button w3-light-grey">연제</a>
			<a href="join6.jsp?address2=수영구" class="w3-button w3-light-grey">수영</a>
			<a href="join6.jsp?address2=사상구" class="w3-button w3-light-grey">사상</a>	
		</c:if>
		
		<c:if test="${param.address1=='대구시'}">
			<a href="join6.jsp?address2=중구" class="w3-button w3-light-grey">중구</a>
			<a href="join6.jsp?address2=동구" class="w3-button w3-light-grey">동구</a>
			<a href="join6.jsp?address2=서구" class="w3-button w3-light-grey">서구</a>
			<a href="join6.jsp?address2=남구" class="w3-button w3-light-grey">남구</a><br>
			<a href="join6.jsp?address2=북구" class="w3-button w3-light-grey">북구</a>
			<a href="join6.jsp?address2=수성구" class="w3-button w3-light-grey">수성</a>
			<a href="join6.jsp?address2=달서구" class="w3-button w3-light-grey">달서</a>
		</c:if>
	</div>
</body>
</html>