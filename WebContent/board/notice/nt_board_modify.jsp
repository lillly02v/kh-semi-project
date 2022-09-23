<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<link href="./css/form.css" rel="stylesheet">
<script>
	$(document).ready(function(){
		
	})
	
</script>
<body>
<jsp:include page="../../header/Header.jsp" />
<br>
		<br>
		<br>
	<form action="./NTBoardModifyAction.nt" method="post" name="boardform">
	<input type="hidden" name="num" value="${param.num}">
		<table id="table" >
			<tr class="center">
				<th class="title" colspan="2"><h3 style="color:white;">공지 게시판 수정</h3></th>
			</tr>
			<tr>
				<td><div id="center">글쓴이</div></td>
				<td>
					<input type="text" name="ANAME" id="aname" value="admin" readOnly>
				</td>
			</tr>
			<tr>
				<td><div id="center">제목</div></td>
				<td><input name="ntsub" id="ntsub"
					type="text" maxlength="100" value="${boardData.ntsub}">
			</tr>
			<tr>
				<td><div id="center">내용</div></td>
				<td><textarea name="ntcont" id="ntcont" 
						cols="67" rows="15">${boardData.ntcont}</textarea>
				</td>
			</tr>
			<tr>
				<td><div id="center">기존 파일</div></td>
					<td>
					<input type="hidden" id="ntfiles" name="ntfiles" value="${boardData.ntfiles}">${boardData.ntfiles}
					</td>
			</tr>
			<tr>
				<td><div id="center">수정 파일</div></td>
					<td>
					<input type="file" id="ntfiles" name="ntfiles1">
					</td>
			</tr>
			</table>
			<br>
			
		
		<table style="margin:auto;">
			<tr>
			<th>
			<input style="background:#5D5D5D; color:white; border:0; height:28px; line-height: 28px; border-radius:3px;"type=submit value="등록">
			<input style="background:#5D5D5D; color:white; border:0; height:28px; line-height: 28px; border-radius:3px;"type=reset value="취소" onClick="history.go(-1)">
			</th>
			</tr>
	</table>
			<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
	</form>
<jsp:include page="../../footer/Footer.jsp" />
</body>
</html>