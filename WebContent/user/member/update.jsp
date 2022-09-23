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
<script src="./js/daupdate.js"></script>
<script>

</script>

<style>
	.container{margin:50px auto;}
	.userinfo{margin:0px 30px 0px 0px;}
	.userPost{clear:both;float:left;width:390px;}
	.postbtn, .keybtn, .malebtn, .femalebtn{color:white;background-color:#1e90ff;width:235px;height:72px;font-size:30px;padding:10px;
		border-radius:0px;margin:0px 0px 0px -5px;vertical-align: middle;}
	.malebtn, .femalebtn{width:305px;background-color:white; color:#1e90ff;}
	.malebtn{margin:0px 5px 0px 0px;}
	.userAddress{font-size:25px;height:72px;}
	.userIntro{font-size:25px;height:160px;margin:0px 0px 50px 0px;}
	.secretinfo{font-size:35px; height:80px;}
	.radiobtn{width:30px;height:30px;}
</style>
<c:set var="member" value="${member}"/>
<script>
	$(document).ready(function(){
		var sendURL = "";
		if('${sessionScope.user}' == '봉사자'){
			sendURL = "vtUpdateView.net";
			$('form').attr('action', "vtUpdateProcess.net");
		} else {
			sendURL = "wrUpdateView.net";
			$('form').attr('action', "wrUpdateProcess.net");
		}
		if('${member.secret}' == '공개'){
			$('.pubcheck').attr("checked", "checked");
		} else if('${member.secret}' == '비공개'){
			$('.pricheck').attr("checked", "checked");
		}
		
		if('${member.gender}' == '남자'){
			maleBtn();
		} else if('${member.gender}' == '여자'){
			femaleBtn();
		}
		
		$('.malebtn').click(function(){
			maleBtn()
		});
		$('.femalebtn').click(function(){
			femaleBtn();
		})
		
		$('.keybtn').click(function(){
			$('.userPain').val('${sessionScope.uppain}');
			$('.userKey').val('${sessionScope.upkeyword}')
		})
	});
	
	function maleBtn(){
		$('.radioMale').attr("checked", "checked");
		$('.radioFemale').removeAttr("checked");
		$('.malebtn').css("background-color", "#3897EB").css("color", "white");
		$('.femalebtn').css("background-color", "white").css("color", "#3897EB");

	}
	
	function femaleBtn(){
		$('.radioFemale').attr("checked", "checked");
		$('.radioMale').removeAttr("checked");
		$('.femalebtn').css("background-color", "#3897EB").css("color", "white");
		$('.malebtn').css("background-color", "white").css("color", "#3897EB");
	}
	
</script>
</head>
<body>
	<%@ include file="../../header/Header.jsp" %>
	<form method="post" class="personinfoform">
		<div class="container user-container">
		<h4 class="chapter">User Update</h4>
			<h1 class="select-name">인적사항 수정 페이지</h1><br><br>
			<table class="personinfo detailtable">
				<tr>
					<td colspan="2" class="secretinfo">
						<input type="radio" name="userSecret" value="공개" class="radiobtn pubcheck">
						<span class="secrettext publictext">공개</span>&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" name="userSecret" value="비공개" class="radiobtn pricheck">
						<span class="secrettext privatetext">비공개</span></td>
				</tr>
				<tr>
					<td><span class="userinfo userinfo-id">아이디</span></td>
					<td><input type="text" name="userId"  class="usertext userId" value="${member.id}"maxlength="30" readonly></td>
				</tr>
				<tr>
					<td><span class="userinfo userinfo-pass">비밀번호</span></td>
					<td><input type="password" name="userPass"  class="usertext userPass" maxlength="30" value="${member.pass}"required></td>
				</tr>
				<tr>
					<td><span class="userinfo userinfo-name">이름</span></td>
					<td><input type="text" name="userName"  class="usertext userName" value="${member.name}" maxlength="30" readonly></td>
				</tr>
				<tr>
					<td><span class="userinfo userinfo-birth">생년월일</span></td>
					<td><input type="text" name="userBirth" class="usertext userBirth" value="${member.resid}" maxlength="30" required><br></td>
				</tr>
				<tr>
					<td><span class="userinfo userinfo-gender">성별</span></td>
					<td><input type="radio" name="userGender" class="radioMale" value="남자" maxlength="30" style="display:none;">
						<span class="w3-button malebtn">남자</span>
						<input type="radio" name="userGender" class="radioFemale" value="여자" maxlength="30" style="display:none;">
						<span class="w3-button femalebtn">여자</span><br></td>
				</tr>
				<tr>
					<td><span class="userinfo userinfo-job">직업</span></td>
					<td><input type="text" name="userJob" class="usertext userJob" value="${member.job}" maxlength="30" required><br></td>
				</tr>
				<tr>
					<td><span class="userinfo userinfo-phone">전화번호</span></td>
					<td><input type="text" name="userPhone" class="usertext userPhone" value="${member.phone}" maxlength="30" required><br></td>
				</tr>
				<tr>
					<td><span class="userinfo userinfo-email">이메일</span></td>
					<td><input type="email" name="userEmail" class="usertext userEmail" value="${member.email}" maxlength="50" required><br></td>
				</tr>
				<tr>
					<td><span class="userinfo userinfo-post">우편번호</span></td>
					<td><input type="text" name="userPost" class="usertext userPost" value="${member.post}" maxlength="30" readonly required>
						<input type="button" class="w3-button postbtn" onclick="execDaumPostcode()" value="우편번호 찾기"></td>
				</tr>
				<tr>
					<td><span class="userinfo userinfo-address">주소</span></td>
					<td><input type="hidden" name="addressLat" class="addressLat" value="${member.addrlat}">
						<input type="hidden" name="addressLng" class="addressLng" value="${member.addrlng}">
						<input type="text" name="userAddress" class="usertext userAddress" value="${member.address}" maxlength="50" required><br></td>
				</tr>
				<tr>
					<td><span class="userinfo userinfo-key">특이사항</span></td>
					<td><c:if test="${sessionScope.user=='복지자'}">
						<input type="hidden" name="userPain" class="usertext userPain" value="${member.pain}">
						</c:if>
						<input type="text" name="userKeyword" class="usertext userKeyword" value="${member.key}" maxlength="30" required>
				</tr>
				<tr>
					<td><span class="userinfo userinfo-intro">자기소개</span></td>
					<td><textarea rows="3" cols="25" name="userIntro" class="usertext userIntro">${member.intro}</textarea></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="정보수정" class="w3-button submitbtn">
					<input type="reset" value="다시입력" class="w3-button resetbtn"></td>
				</tr>
			</table>
			<div id="layer" style="display:none;position:fixed;overflow:hidden;z-index:1;-webkit-overflow-scrolling:touch;">
				<img src="//t1.daumcdn.net/localimg/localimages/07/postcode/320/close.png" id="btnCloseLayer" style="cursor:pointer;position:absolute;right:-3px;top:-3px;z-index:1" onclick="closeDaumPostcode()" alt="닫기 버튼">
			</div>	
		</div>
	</form>
	<br><br><br><br>
	<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=535f52b28d45aec31e6fcacb00c8d23f&libraries=services,clusterer,drawing"></script>
	<script src="./js/dapostcode.js"></script>
</body>
</html>