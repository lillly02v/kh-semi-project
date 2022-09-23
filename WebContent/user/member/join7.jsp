<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
	.container{margin: 30px auto;}
	.detailtable{display:inline-block;width:1400px;margin:50px 0px 0px 0px;}
	.detailbody{width:850px; float:left;}
	.detailfoot{width:500px; float:right; margin:80px 0px 0px 0px;}
	.userinfo{margin:0px 30px 0px 0px;}
	.userPost{clear:both;float:left;width:350px;}
	.postbtn{color:white;background-color:#1e90ff;width:250px;height:72px;font-size:30px;padding:0px;
		border-radius:0px;margin:0px 0px 0px -10px;vertical-align: middle}
	.userAddress{font-size:25px;height:72px;}
	.userIntro{font-size:25px;height:160px;}
	.secretinfo{font-size:35px; height:200px;}
	.radiobtn{width:30px;height:30px;}
</style>
<script>
	$(document).ready(function(){
		var insertLoc = "";
		if('${sessionScope.user}' == '봉사자'){
			$('form').attr('action', "vtJoinProcess.net");
		} else {
			$('form').attr('action', "wrJoinProcess.net");
		}
	});

</script>
</head>
<body>
	<%@ include file="../../header/Header.jsp" %>
	<form method="post" class="persondetailform">
	<input type="hidden" name="userId" class="usertext userId" value="${param.userID}">
	<input type="hidden" name="userPw" class="usertext userPw" value="${param.userPW}">
		<div class="container user-container">
			<table class="personinfo detailtable">
				
				<tbody class="detailbody">
					<tr>
						<td><span class="userinfo">이름</span></td>
						<td>
							<input type="text" name="userName"  class="usertext userName" maxlength="30" placeholder="홍길동" required></td>
					</tr>
					<tr>
						<td><span class="userinfo">생년월일</span></td>
						<td><input type="text" name="userBirth" class="usertext userBirth" maxlength="8" placeholder="19900101" required><br></td>
					</tr>
					<tr>
						<td><span class="userinfo">전화번호</span></td>
						<td><input type="text" name="userPhone" class="usertext userPhone" maxlength="30" placeholder="010-1111-2222" required><br></td>
					</tr>
					<tr>
						<td><span class="userinfo">이메일</span></td>
						<td><input type="email" name="userEmail" class="usertext userEmail" maxlength="50" placeholder="example@gmail.com" required><br></td>
					</tr>
					<tr>
						<td><span class="userinfo">우편번호</span></td>
						<td><input type="text" name="userPost" class="usertext userPost" maxlength="30" placeholder="우편번호" readonly required>
							<input type="button" class="w3-button postbtn" onclick="execDaumPostcode()" value="우편번호 찾기"></td>
					</tr>
					<tr>
						<td><span class="userinfo">주소</span></td>
						<td><input type="hidden" name="addressLat" class="addressLat">
							<input type="hidden" name="addressLng" class="addressLng">
							<input type="text" name="userAddress" class="usertext userAddress" maxlength="50" required><br></td>
					</tr>
					<tr>
						<td><span class="userinfo">자기소개</span></td>
						<td><textarea rows="3" cols="25" name="userIntro" class="usertext userIntro"></textarea></td>
					</tr>
				</tbody>
				<tfoot class="detailfoot">
					<tr>
						<td colspan="2">
							<h4 class="chapter">Chapter 5 - 2.</h4>
							<h1 class="select-name">당신의 인적사항은?</h1><br><br></td>
					</tr>
					<tr>
						<td colspan="2" class="secretinfo">
							<input type="radio" name="userSecret" value="공개" class="radiobtn pubcheck" checked>
							<span class="secrettext publictext">공개</span>&nbsp;&nbsp;&nbsp;
							<input type="radio" name="userSecret" value="비공개" class="radiobtn pricheck">
							<span class="secrettext privatetext">비공개</span></td>
					</tr>
				
					<tr>
						<td colspan="2"><input type="submit" value="정보전송" class="w3-button submitbtn">
						<input type="reset" value="다시입력" class="w3-button resetbtn"></td>
					</tr>
				</tfoot>
			</table>
			<div id="layer" style="display:none;position:fixed;overflow:hidden;z-index:1;-webkit-overflow-scrolling:touch;">
				<img src="//t1.daumcdn.net/localimg/localimages/07/postcode/320/close.png" id="btnCloseLayer" style="cursor:pointer;position:absolute;right:-3px;top:-3px;z-index:1" onclick="closeDaumPostcode()" alt="닫기 버튼">
			</div>	
		</div>
	</form>
	<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=535f52b28d45aec31e6fcacb00c8d23f&libraries=services,clusterer,drawing"></script>
	<script src="./js/dapostcode.js"></script>
	<%@ include file="../../footer/Footer.jsp" %>
</body>
</html>