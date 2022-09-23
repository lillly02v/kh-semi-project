<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="./css/w3schools.css">
<script src="./js/jquery-3.3.1.js"></script>
<link href="./css/dajoin.css" rel="stylesheet">
<style>
	.w3-button{
			margin: 100px 60px 0px;
			padding:70px 0px;
			width: 200px;
			height: 200px;
			}
	
	.delete-container{margin: 50px auto;}
	.delete-table{display:inline-block; margin: 50px auto;}
	.info-pass{font-size:28pt;vertical-align: middle;}
	.deletePass{
		width: 70%;
	}
</style>
<script>
	$(document).ready(function(){
		if('${sessionScope.user}' == '봉사자'){
			$('form').attr("action", "vtDeleteProcess.net");
		} else {
			$('form').attr("action", "wrDeleteProcess.net");
		}
		
		$(".canclebtn").click(function(){
			history.go(-1);
		});
	})
</script>
</head>
<body>
	<%@ include file="../../header/Header.jsp" %>
	<form method="post">
		<div class="container delete-container">
			<h4 class="chapter">${sessionScope.id}님</h4>
			<input type="hidden" name="userId" class="usertext deleteId" value="${sessionScope.id}">
			<h1 class="select-name">정말 계정을 삭제하시겠습니까?</h1><br><br>
			<table class="delete-table">
				<tr>
					<td colspan="2"><span class="info-pass">비밀번호</span>
						<input type="password" name="userPass"  class="usertext deletePass" placeholder="비밀번호를 입력하세요." maxlength="30" required></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" class="w3-button w3-light-grey deletebtn" value="삭제">
				<input type="reset" class="w3-button w3-light-grey canclebtn" value="취소"></td>
				</tr>
				
				
			</table>
		</div>
	</form>
	<%@ include file="../../footer/Footer.jsp" %>
</body>
</html>