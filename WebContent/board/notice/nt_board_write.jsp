<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="../../header/Header.jsp" %>
   <link href="./css/form.css" rel="stylesheet">
	<br>
		<br>
		<br>
<form style="" action="./NTBoardAddAction.nt" method="post"
	enctype="multipart/form-data" name="boardform">
	<table id="table" >
		<tr class="center">
			<th class="title"colspan="2"><h3 style="color:white;">공지 게시판</h3></th>
		</tr>
		<tr>
			<td><div id="center">글쓴이</div></td>
			<td>
				<input name="ANAME" id="aname" readOnly
					type="text" size="100%" maxlength="30" value="admin">
			</td>
		</tr>
		<tr>
			<td><div id="center">제목</div></td>
			<td><input name="NTSUB" id="ntsub"
					type="text" size="100%" maxlength="100" value="">
		</tr>
		<tr>
			<td><div id="center">내용</div></td>
			<td><textarea name="NTCONT" id="ntcont" 
						cols="67" rows="15"></textarea>
			</td>
		</tr>
		<tr>
			<td><div id="center">파일 첨부</div></td>
			<td><input type="file" id="upfile1" name="NTFILES"></td>
		</tr>
		</table>
		<br>
		
		<table style="margin:auto;">
			<tr>
			<th>
			<input style="background:#5D5D5D; color:white; border:0; height:30px; line-height: 28px; width: 100px; border-radius:3px;"type=submit value="등록">
			<input style="background:#5D5D5D; color:white; border:0; height:30px; line-height: 28px; width: 100px; border-radius:3px;"type=reset value="취소" onClick="history.go(-1)">
			</th>
			</tr>
	</table>
</form>
<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
<%@ include file="../../footer/Footer.jsp" %>