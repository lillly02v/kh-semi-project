<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	boolean isIDShow = false;
	String remId = "";
	Cookie[] cookies = request.getCookies();
	if(cookies != null){
		for(int i = 0; i < cookies.length; i++){
			if(cookies[i].getName().equals("rememberId")){
				isIDShow = true;
				remId = cookies[i].getValue();
			}
		}
	}
%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="icon" type="image/png" href="./images/icons/favicon.ico"/>
	<link rel="stylesheet" type="text/css" href="./vendor/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="./fonts/font-awesome-4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="./fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
	<link rel="stylesheet" type="text/css" href="./vendor/animate/animate.css">
	<link rel="stylesheet" type="text/css" href="./vendor/css-hamburgers/hamburgers.min.css">
	<link rel="stylesheet" type="text/css" href="./vendor/select2/select2.min.css">
	<link rel="stylesheet" type="text/css" href="./css/util.css">
	<link rel="stylesheet" type="text/css" href="./css/main.css">
	<script src="./js/jquery-3.3.1.js"></script>
	<style>	
		.login100-form-white{
			margin:-10px 0px 0px 0px;
			background: white;
			border: 1px solid #1e90ff;
			color: #1e90ff;
		}
		.login100-form-white:hover{
			color: white;
			border: 0px solid black;
		}
		.background, .limiter{position:absolute; z-index:100}

	</style>
	<script>
		$(document).ready(function(){
			var isIDShow = <%=isIDShow%>;
			if(isIDShow){
				$('.input-id').val('<%=remId%>');
				$('.input-checkbox100').attr('checked', 'checked');
			}
		});
	</script>
	
</head>

<body>
		<div class="background"></div>
		<%@ include file="./searchMap.jsp" %>
		<div class="limiter">
			<div class="container-login100">
				<div class="wrap-login100 p-l-50 p-r-50 p-t-77 p-b-30">
					<form class="login100-form validate-form" method="post">
						<span class="login100-form-title p-b-55">
							LOGIN
						</span>
						<div class=user-login100>
							<input type="radio" class="login100-radio user-welfare" name="user" value="복지자">
							<span class="welfare-text">복지자</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" class="login100-radio user-volunteer" name="user" value="봉사자">
							<span class="volunteer-text">봉사자</span>
						</div><br>
						<div class="wrap-input100 validate-input m-b-16" data-validate = "아이디를 입력하세요.">
							<input class="input100 input-id" type="text" name="id" placeholder="아이디">
							<span class="focus-input100"></span>
							<span class="symbol-input100">
								<span class="lnr lnr-envelope"></span>
							</span>
						</div>
	
						<div class="wrap-input100 validate-input m-b-16" data-validate = "비밀번호를 입력하세요.">
							<input class="input100 input-pass" type="password" name="pass" placeholder="비밀번호">
							<span class="focus-input100"></span>
							<span class="symbol-input100">
								<span class="lnr lnr-lock"></span>
							</span>
						</div>
	
						<div class="contact100-form-checkbox m-l-4">
							<input class="input-checkbox100" id="ckb1" type="checkbox" value="idStore" name="idStore">
							<label class="label-checkbox100" for="ckb1">
								아이디 기억하기
							</label>
						</div>
						<div class="contact100-form-checkbox m-l-4">
							<label class="pass-finder">
								<a href="finder.net">비밀번호 찾기</a>
							</label>
						</div>
						<div class="container-login100-form-btn p-t-25">
							<button class="login100-form-btn">
								로그인
							</button>
						</div>
						<div class="container-login100-form-btn p-t-25">
							<span class="login100-form-btn login100-form-white">
								회원가입
							</span>
						</div>
						
					</form>
				</div>
			</div>
		</div>
	
	<script src="./vendor/jquery/jquery-3.2.1.min.js"></script>
	<script src="./vendor/bootstrap/js/popper.js"></script>
	<script src="./vendor/bootstrap/js/bootstrap.min.js"></script>
	<script src="./vendor/select2/select2.min.js"></script>
	<script src="./js/dabonglogin.js"></script>

</body>
</html>