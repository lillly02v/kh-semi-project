<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("UTF-8");
	String pain = request.getParameter("pain");
	session.setAttribute("pain", pain);
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
<style>
	.w3-button{
			margin: 30px 30px;
			padding:30px 0px;
			width: 300px;
			height: 120px;
			}
	.container{margin: 30px auto;}
</style>
</head>
<body>
	<%@ include file="../../header/Header.jsp" %>
	<form action="join6.net" method="post">
		<div class="container user-container">
			<c:if test="${sessionScope.user=='복지자'}">
				<h4 class="chapter">Chapter 4 - 2.</h4>
				<c:if test="${param.pain=='불편'}">
					<h1 class="select-name">당신의 불편 특이사항?</h1><br><br>
					<button class="w3-button w3-light-grey" name="keyword" value="시력이 안좋아요">시력이 안좋아요</button>
					<button class="w3-button w3-light-grey" name="keyword" value="잘 잊어버려요">잘 잊어버려요</button>
					<button class="w3-button w3-light-grey" name="keyword" value="많이 외로워요">많이 외로워요</button><br>
					<button class="w3-button w3-light-grey" name="keyword" value="멘토를 구해요">멘토를 구해요</button>
					<button class="w3-button w3-light-grey" name="keyword" value="거동이 불편해요">거동이 불편해요</button>
					<button class="w3-button w3-light-grey" name="keyword" value="여가생활 같이해요">여가생활 같이해요</button><br>
					<button class="w3-button w3-light-grey" name="keyword" value="상담이 필요해요">상담이 필요해요</button>
					<input type="text"  class="etc-text" name="keyword" placeholder="기타사항">
					<input type="submit" class="w3-submit" value="다음">
				</c:if>
				
				<c:if test="${param.pain=='장애'}">
					<h1 class="select-name">당신의 장애 특이사항?</h1><br><br>
					<button class="w3-button w3-light-grey" name="keyword" value="언어장애">언어장애</button>
					<button class="w3-button w3-light-grey" name="keyword" value="청각장애">청각장애</button>
					<button class="w3-button w3-light-grey" name="keyword" value="시각장애">시각장애</button><br>
					<button class="w3-button w3-light-grey" name="keyword" value="지체장애">지체장애</button>
					<button class="w3-button w3-light-grey" name="keyword" value="안면장애">안면장애</button>
					<button class="w3-button w3-light-grey" name="keyword" value="내장장애">내장장애</button><br>
					<button class="w3-button w3-light-grey" name="keyword" value="정서장애">정서장애</button>
					<input type="text" class="etc-text" name="keyword" placeholder="기타사항">
					<input type="submit" class="w3-submit" value="다음">
				</c:if>
			</c:if>
				
			<c:if test="${sessionScope.user=='봉사자'}">
				<h4 class="chapter">Chapter 4.</h4>
				<h1 class="select-name">당신의 봉사 특이사항?</h1><br><br>
				<button class="w3-button w3-light-grey" name="keyword" value="언변이 좋아요">언변이 좋아요</button>
				<button class="w3-button w3-light-grey" name="keyword" value="경청을 잘해요">경청을 잘해요</button>
				<button class="w3-button w3-light-grey" name="keyword" value="활동적이에요">활동적이에요</button><br>
				<button class="w3-button w3-light-grey" name="keyword" value="힘든 일 잘해요">힘든 일 잘해요</button>
				<button class="w3-button w3-light-grey" name="keyword" value="꼼꼼하게 잘해요">꼼꼼하게 잘해요</button>
				<button class="w3-button w3-light-grey" name="keyword" value="간호를 잘해요">간호를 잘해요</button><br>
				<button class="w3-button w3-light-grey" name="keyword" value="헌혈 가능해요">헌혈 가능해요</button>
				<input type="text" class="etc-text" name="keyword" placeholder="기타사항">
				<input type="submit" class="w3-submit" value="다음">
			</c:if>
		</div>
	</form>
	<%@ include file="../../footer/Footer.jsp" %>
</body>
</html>