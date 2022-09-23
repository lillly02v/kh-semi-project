<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<title>정보마당 글쓰기</title>
<link href="./css/css_kh/write.css" rel="stylesheet" type="text/css">
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>

</script>

<%@ include file="../../header/Header.jsp" %>
</head>
<body>

<form action="NewsBoardAddAction.news" method="post" 
		enctype="multipart/form-data" name="boardform">
		<br><br>
	<h1>정보마당 - write 페이지</h1>
	<table>
		<tr>
			<td><div>게시자</div></td>
			<td>
				<input name="aname" id="aname" readOnly
						type="text" size="6" maxlength="30" value="admin" style="text-align:center">
			</td>
		</tr>
		<tr>
			<td>	<div>제목</div></td>
			<td><input name=nesub id="nesub"
					type="text" size="80" maxlength="100" value="">
		</tr>
		<tr>
			<td><div>내용</div></td>
			<td><pre id="preview"><textarea name="necont" id="necont"  cols="67" rows="22"></textarea></pre>
			</td>
		</tr>
		<tr>
			<td>
				<div>파일 첨부</div>
			</td>
			<td>
				<input type="file" id="nefiles" name="nefiles" >
			</td>
		</tr>
	</table>
		<br><br>
		<div class="center" style="text-align:center">
				<button type=submit class="nbutton1">등록</button>
				<button type=reset class="nbutton1" onClick="history.go(-1);">취소</button>
		</div>

</form>
<br><br><br><br><br><br><br><br>
</body>
<%@ include file="../../footer/Footer.jsp" %>
</html>
