<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Slider</title>
<!-- Fonts -->
<link href="https://fonts.googleapis.com/css?family=Montserrat"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Oswald"
	rel="stylesheet">
<link href="./css/SlideStyle.css" rel="stylesheet">
<link href="./css/Loading.css" rel="stylesheet">
<link href="./css/FadeIn.css" rel="stylesheet">
<meta name="robots" content="noindex,follow" />
</head>
<body style="margin: 0;" onload="myFunction()">
	<div class="load" id="load">
		<div class="dot"></div>
		<div class="outline">
			<span></span>
		</div>
	</div>
	<div class="se-pre-con"></div>
	<!-- Slider Wrapper -->
	<div class="css-slider-wrapper" id="myDiv" style="display: none;">
		<input type="radio" name="slider" class="slide-radio1" checked
			id="slider_1"> <input type="radio" name="slider"
			class="slide-radio2" id="slider_2"> <input type="radio"
			name="slider" class="slide-radio3" id="slider_3"> <input
			type="radio" name="slider" class="slide-radio4" id="slider_4">

		<!-- Slider Pagination -->
		<div class="slider-pagination">
			<label for="slider_1" class="page1"></label> <label for="slider_2"
				class="page2"></label> <label for="slider_3" class="page3"></label>
			<label for="slider_4" class="page4"></label>
			<h6>넘어가려면 여기를 클릭해주세요</h6>
		</div>

		<!-- Slider #1 -->
		<div class="slider slide-1">
			<span class="overlay-container1"></span> <img
				src="images/model_1.png" alt="">
			<div class="slider-content">
				<h4>다봉안내 1</h4>
				<br>
				<h2
					style="letter-spacing: -5px; word-spacing: 10px; line-height: 90px">
					<span style="color: dodgerblue; font-weight: bold;">다봉(DABONG)</span>은<br>복지서비스를
					지원<br>받길 원하는 사람과,<br>
				</h2>
				<br>
				<button type="button" class="buy-now-btn" name="button"
					onclick="location.href='login.net'">시작하기</button>
			</div>
			<div class="number-pagination">
				<span>1</span>
			</div>
		</div>

		<!-- Slider #2 -->
		<div class="slider slide-2">
			<span class="overlay-container2"></span>
			<div class="slider-content">
				<h4>다봉안내 2</h4>
				<br>
				<h2
					style="letter-spacing: -5px; word-spacing: 10px; line-height: 90px">
					도움을 주고자 하는 <br>사람을 매칭시켜주는 서비스입니다.<br>
				</h2>
				<br>
				<button type="button" class="buy-now-btn" name="button"
					onclick="location.href='login.net'">시작하기</button>
			</div>
			<div class="number-pagination">
				<span>2</span>
			</div>
		</div>

		<!-- Slider #3 -->
		<div class="slider slide-3">
			<span class="overlay-container3"></span>
			<div class="slider-content">
				<h4>다봉안내 3</h4>
				<br>
				<h2
					style="letter-spacing: -5px; word-spacing: 10px; line-height: 90px">
					<span style="color: dodgerblue; font-weight: bold;">다봉</span>만의 간편한
					<br>지역기반 매칭으로<br>
				</h2>
				<br>
				<button type="button" class="buy-now-btn" name="button"
					onclick="location.href='login.net'">시작하기</button>
			</div>
			<div class="number-pagination">
				<span>3</span>
			</div>
		</div>

		<!-- Slider #4 -->
		<div class="slider slide-4">
			<span class="overlay-container4"></span>
			<div class="slider-content">
				<h4>다봉안내 4</h4>
				<br>
				<h2
					style="letter-spacing: -5px; word-spacing: 10px; line-height: 90px">
					모두가 Win-Win할 수 있는 복지문화를 <br>만들어가겠습니다.<br>
				</h2>
				<br>
				<button type="button" class="buy-now-btn" name="button"
					onclick="location.href='login.net'">시작하기</button>
			</div>
			<div class="number-pagination">
				<span>4</span>
			</div>
		</div>
	</div>

	<!-- Scripts -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"
		charset="utf-8"></script>
	<script src="./js/slideTime.js" charset="utf-8"></script>
	<script src="./js/fadeTime.js" charset="utf-8"></script>
</body>
</html>
