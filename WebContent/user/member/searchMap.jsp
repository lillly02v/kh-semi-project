<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
    <title>지도 검색</title>
    <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="./css/dabongSearch.css" rel="stylesheet">
    <link href="./css/chatting.css" rel="stylesheet">
    <script src="./js/jquery-3.3.1.js"></script>
    <script src="./js/chatting.js"></script>
	<script>
	 $(document).ready(function(){
		 
		 if("${sessionScope.user}" == '봉사자'){
			 loadFiles("./json/welfareMap.json", "./wrMyProfile.net");
		 } else if("${sessionScope.user}" == '복지자'){
			 loadFiles("./json/volunteerMap.json", "./vtMyProfile.net");
		 }
		 
		
		$(".searchForm-btn").click(function(){
			var address = $(".searchForm-input").val();
			searchAddress(address);
		});
	});
	</script>
</head>
<body>
	<%@ include file="../../header/Header.jsp" %>
	<div class="search-box">
		<div class="container-4">
			<input type="search" class="searchForm-input" id="search" placeholder="Search..." />
			<button class="searchForm-btn icon"><i class="fa fa-search"></i></button>
		</div>
	</div>
	<div class="map_wrap">
	    <div id="map" style="width:100%;height:90%;position:relative;overflow:hidden;float:right;"></div> 
	    <!-- 지도 확대, 축소 컨트롤 div 입니다 -->
	    <div class="custom_zoomcontrol radius_border"> 
	        <span onclick="zoomIn()"><img src="http://t1.daumcdn.net/localimg/localimages/07/mapapidoc/ico_plus.png" alt="확대"></span>  
	        <span onclick="zoomOut()"><img src="http://t1.daumcdn.net/localimg/localimages/07/mapapidoc/ico_minus.png" alt="축소"></span>
	    </div>
	</div>
	<img src="./images/chatImage.png" class="chatImage" onClick="chattingWindow()">
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=535f52b28d45aec31e6fcacb00c8d23f&libraries=services,clusterer,drawing"></script>
<script src="./js/dabongSearch.js"></script>

<script>
	var userId = '${sessionScope.id}';
	var latloc = 37.56794036086287;
	var lngloc = 126.98313435363377
	
	if(userId != ""){
		latloc = '${sessionScope.addressLat}';
		lngloc = '${sessionScope.addressLng}';
	}

	
	var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
	mapOption = { 
	      center: new daum.maps.LatLng(latloc, lngloc), // 지도의 중심좌표
	      level: 4 // 지도의 확대 레벨
	  };
	
	//지도를 생성합니다.
	var map = new daum.maps.Map(mapContainer, mapOption);

	// 마커 클러스터러를 생성합니다
	// 마커 클러스터러를 생성할 때 disableClickZoom 값을 true로 지정하지 않은 경우
	// 클러스터 마커를 클릭했을 때 클러스터 객체가 포함하는 마커들이 모두 잘 보이도록 지도의 레벨과 영역을 변경합니다
	// 이 예제에서는 disableClickZoom 값을 true로 설정하여 기본 클릭 동작을 막고
	// 클러스터 마커를 클릭했을 때 클릭된 클러스터 마커의 위치를 기준으로 지도를 1레벨씩 확대합니다
	var clusterer = new daum.maps.MarkerClusterer({
	    map: map, // 마커들을 클러스터로 관리하고 표시할 지도 객체
	    averageCenter: true, // 클러스터에 포함된 마커들의 평균 위치를 클러스터 마커 위치로 설정
	    minLevel: 1, // 클러스터 할 최소 지도 레벨
	});
	
</script>
<%@ include file="../../footer/Footer.jsp" %>
</body>
</html>