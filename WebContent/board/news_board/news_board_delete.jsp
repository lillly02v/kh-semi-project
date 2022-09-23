<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<title>정보마당 글 삭제</title>
<link href="./css/css_kh/modify.css" rel="stylesheet" type="text/css">
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>

<%@ include file="../../header/Header.jsp" %>
</head>
<body>
	<!-- 글 삭제 -->
	<form action="./NewsBoardDeleteAction.news" method="get" name="deleteform">
	<br>
		<input type="hidden" name="num" value="${param.num}">
		<table border="1">
		<h1>정보마당</h1>
		<tr>
			<td><h1>삭제 하시겠습니까?</h1></td>
		</tr>
		<tr>
			<td colspan=2 class="h30 center lime">
				<button type=submit class="nbutton1">삭제</button>
				<button type=button class="nbutton1" onClick="history.go(-1)">취소</button>
			</td>
		</tr>
		</table>
	</form>
		<br><br><br><br><br><br><br><br>
</body>
<%@ include file="../../footer/Footer.jsp" %>