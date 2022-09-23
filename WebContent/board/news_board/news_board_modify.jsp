<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>정보마당 글 수정</title>
<link href="./css/css_kh/modify.css" rel="stylesheet" type="text/css">
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
	$(document).ready(function(){
		$('#list1').on('click', function(){
			if("${sessionScope.load}" == 'album' || "${sessionScope.fload}" == 'album'){
				location.href="./news_board_album.news";
			} else if("${sessionScope.load}" == 'list' || "${sessionScope.fload}" == 'list'){
				location.href="./news_board_list.news";
			}
		});
	});
</script>
<%@ include file="../../header/Header.jsp" %>
</head>
<body>
	<!-- 게시판 수정 -->
	<form action="./NewsBoardModifyAction.news" method="post">
	<br><br>
		<input type="hidden" name="num" value="${param.num}">
	<h1>정보마당 글 수정</h1>
		<table border="1">
			<tr>
				<td>
					<div>게시자</div>
				</td>
				<td>
					<input name="aname" id="aname" readOnly
						type="text" size="6" maxlength="30" value="  admin">
				</td>
			</tr>
		<tr>
			<td>
				<div>제목</div>
			</td>
			<td>
				<input name=nesub id="nesub"
					type="text" size="80" maxlength="100" value="${boardData.nesub}">
			</td>
		</tr>
		<tr>
			<td>
				<div>내용</div>
			</td>
			<td>
				<textarea name="necont" id="necont" 
					cols="67" rows="22">${boardData.necont}</textarea>
			</td>
		</tr>
		<tr>
			<td>첨부 된 파일</td>
			<td>${boardData.nefiles}</td>
		</tr>
		<tr>
			<td>파일 첨부</td>
			<td><input type="file" id="nefiles" name="nefiles"></td>
			
		</tr>
	</table>
	<br>
		<div class="center">
				<button type=submit class="nbutton1">등록</button>&nbsp;
				<button type=reset class="nbutton1" onClick="history.go(-1);">취소</button>&nbsp;&nbsp;
				<button type=button class="nbutton2" id="list1">목록으로</button>
		</div>
	</form>
	<br><br><br><br><br><br><br><br>
</body>
<%@ include file="../../footer/Footer.jsp" %>
</html>
