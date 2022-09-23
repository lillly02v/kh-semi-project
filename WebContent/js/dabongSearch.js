  

    var filepath = '';
    
    function searchAddress(address){
    	//주소-좌표 변환 객체를 생성합니다.
    	var geocoder = new daum.maps.services.Geocoder();
		//주소로 좌표를 검색합니다.
		geocoder.addressSearch(address, function(result, status){
			
			//정상적으로 검색이 완료됐으면
			if(status === daum.maps.services.Status.OK){
				var coords = new daum.maps.LatLng(result[0].y, result[0].x);
				
				map.setCenter(coords);
			}
		});
	}
    
    function loadFiles(filepath, profilepath){
    	
    		// 데이터를 가져오기 위해 jQuery를 사용합니다
	    // 데이터를 가져와 마커를 생성하고 클러스터러 객체에 넘겨줍니다
	    $.get(filepath, function(data) {
	    	clusterer.clear();
	        var imageSrc = './files/markerCircle.png';
	    		var imageSize = new daum.maps.Size(46, 46);	//마커이미지의 크기입니다.
	    		//마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.    		
	    		var imageOption = {offset: new daum.maps.Point(23, 46)};
	    		
	    		//마커의 이미지 정보를 가지고 있는 마커이미지를 생성합니다.
	    		var markerImage = new daum.maps.MarkerImage(imageSrc, imageSize, imageOption);
	    		
	    		// 데이터에서 좌표 값을 가지고 마커를 표시합니다
	        // 마커 클러스터러로 관리할 마커 객체는 생성할 때 지도 객체를 설정하지 않습니다
	        var markers = $(data.positions).map(function(i, position) {
            var maks = new daum.maps.Marker({
                map: map,
                image: markerImage,	//마커 이미지를 설
                position : new daum.maps.LatLng(position.lat, position.lng)
           		});
            
//            	daum.maps.event.addListener(maks, 'click', makeOverListener(map, maks, infowindow));
            	daum.maps.event.addListener(maks, 'click', makeOverListener(profilepath, position.id));
            	daum.maps.event.addListener(maks, 'mouseout', makeOutListener());
            return maks;

	        });
		
	        // 클러스터러에 마커들을 추가합니다
	        clusterer.addMarkers(markers);
	    });
    }
    
    
 // 인포윈도우를 표시하는 클로저를 만드는 함수입니다 
    function makeOverListener(pfilepath, uid) {
        return function() {
        	path = pfilepath + "?id=" + uid + '&type=other';
        	window.open(path, '_new', 'width=500, height=720, top=100, left=250 scrollbars=yes')
        };
    }

    // 인포윈도우를 닫는 클로저를 만드는 함수입니다 
    function makeOutListener() {
        return function() {
            window.close();
        };
    }

	// 지도 확대, 축소 컨트롤에서 확대 버튼을 누르면 호출되어 지도를 확대하는 함수입니다
	function zoomIn() {
	    map.setLevel(map.getLevel() - 1);
	}
	
	// 지도 확대, 축소 컨트롤에서 축소 버튼을 누르면 호출되어 지도를 확대하는 함수입니다
	function zoomOut() {
	    map.setLevel(map.getLevel() + 1);
	}
    