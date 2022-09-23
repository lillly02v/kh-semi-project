<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>봉사자 참여 내용 삭제하기</title>
<link type="text/css" rel="stylesheet" href="./css/Vboard_list.css" />
</head>
<body>
	<%@ include file="../../header/Header.jsp" %>
	<br>
	<img style="margin-left:10%; margin-top:3%;" src="images/home(dabong).png">&nbsp;>&nbsp;봉사자참여
	<p style="text-align:left;" id="qav_head" class="vbo_head"><br>
		<strong style="font-size:40px; margin-left:9%">봉사자 게시글 삭제 </strong>
	<br><br><br>
	<a style="margin-left:9%">삭제하시겠습니까?</a><br><br><br></p>
	<form name="deleteForm" action="./vboardDeleteAction.vb" method="post">
		<input type="hidden" name="num" value="${param.num}">
		<table border="0px" style="margin:auto;">
			<tr>
				<th>글 비밀번호</th>
				<td>
					<input  type="password" name="vpass" id="vpass">
				</td>
			</tr>
			<tr>
				<td colspan=2 class="h30 center lime" >
					<input style="background:#5D5D5D; color:white; border:1px; height:30px; line-height: 28px; width: 48%; border-radius: 8px;" type="submit" value="삭제">
					<input style="background:#5D5D5D; color:white; border:1px; height:30px; line-height: 28px; width: 50%; border-radius: 8px;" type="button" value="취소" onClick="history.go(-1)">
				</td>
			</tr>
		</table>
	</form>
		<%@ include file="../../footer/Footer.jsp" %>
</body>
</html>