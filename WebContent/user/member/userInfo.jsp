<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<script src="./js/jquery-3.3.1.js"></script>
<script src="./js/chatting.js"></script>
<link href="./css/chatting.css" rel="stylesheet">
</head>
<body>
	<c:if test="${sessionScope.user == '봉사자' }">
		<a href="./vtUpdateView.net">수정</a>
		<a href="./vtMessageView.net">메세지</a>
	</c:if>
	<c:if test="${sessionScope.user == '복지자' }">
		<a href="./wrUpdateView.net">수정</a>
		<a href="./wrMessageView.net">메세지</a>
	</c:if>
	<a href="./delete.net">삭제</a>
	
	<img src="./images/chatImage.png" class="chatImage" onClick="chattingWindow()">
</body>
</html>