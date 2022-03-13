<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="headerFooter.css">
<link rel="stylesheet" type="text/css" href="mapSearchStyle.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript" src="menuslide.js"></script>
<title>헤이키친: 오프라인 매장 찾기</title>
</head>
<body>
	<div>
		<jsp:include page="header.jsp" />
		
		<main>
			<div class="title">헤이키친 매장 찾기</div>
			<div class="subtitle">오프라인 매장에서 더 다양한 밀키트를 빠르게 만나보세요.</div>
			<div id="map_wrap">
				<div id="map"></div>
				
				<div id="search_wrap">
					<form onsubmit="mapSearch(); return false;">
						<input type="text" id="keyword" size="26" value="헤이키친" placeholder="지점명을 검색하세요(예시: 강남)">
						<button type="submit" id="mapSearchBtn">찾기</button>
					</form>
					
					<ul id="mapUl">
					</ul>
				</div>
			</div>
		</main>
		
		<jsp:include page="footer.jsp" />
	</div>
	
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=9dba1125139c9fc4d8f64e57190988a7"></script>
	<script>
	var mapContainer = document.getElementById('map'), // 지도를 표시할 div  
	    mapOption = { 
	        center: new kakao.maps.LatLng(37.548065, 126.814818), // 지도의 중심좌표
	        level: 9 // 지도의 확대 레벨
	    };
	
	var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
	
	var positions = [
	    {
	        title: '${mapList[0].title}', 
	        latlng: new kakao.maps.LatLng(${mapList[0].ma}, ${mapList[0].la}),
	        address: '${mapList[0].address}'
	    },
	    {
	    	title: '${mapList[1].title}', 
	        latlng: new kakao.maps.LatLng(${mapList[1].ma}, ${mapList[1].la}),
	        address: '${mapList[1].address}'
	    },
	    {
	    	title: '${mapList[2].title}', 
	        latlng: new kakao.maps.LatLng(${mapList[2].ma}, ${mapList[2].la}),
	        address: '${mapList[2].address}'
	    }, 
	    {
	    	title: '${mapList[3].title}', 
	        latlng: new kakao.maps.LatLng(${mapList[3].ma}, ${mapList[3].la}),
	        address: '${mapList[3].address}'
	    },
	    {
	    	title: '${mapList[4].title}', 
	        latlng: new kakao.maps.LatLng(${mapList[4].ma}, ${mapList[4].la}),
	        address: '${mapList[4].address}'
	    },
	    {
	    	title: '${mapList[5].title}', 
	        latlng: new kakao.maps.LatLng(${mapList[5].ma}, ${mapList[5].la}),
	        address: '${mapList[5].address}'
	    },
	    {
	    	title: '${mapList[6].title}', 
	        latlng: new kakao.maps.LatLng(${mapList[6].ma}, ${mapList[6].la}),
	        address: '${mapList[6].address}'
	    },
	    {
	    	title: '${mapList[7].title}', 
	        latlng: new kakao.maps.LatLng(${mapList[7].ma}, ${mapList[7].la}),
	        address: '${mapList[7].address}'
	    } 
	];
	
	var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png"; // 마커 이미지의 이미지 주소
	
	for (var i = 0; i < positions.length; i ++) {
	    
	    var imageSize = new kakao.maps.Size(24, 35); // 마커 이미지의 이미지 크기 
	    var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize); // 마커 이미지를 생성
	    
	    // 마커 생성
	    var marker = new kakao.maps.Marker({
	        map: map, // 마커를 표시할 지도
	        position: positions[i].latlng, // 마커를 표시할 위치
	        title : positions[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
	        image : markerImage // 마커 이미지 
	    });
	    
	    var markerLatlng = positions[i].latlng.Ma + "," + positions[i].latlng.La; // 위도와 경도 문자열
	    var iwContent = '<div style="padding:5px;">' + positions[i].title + ' <br><a href="https://map.kakao.com/link/map/'
	    + positions[i].title + ',' + markerLatlng + '" style="color:blue" target="_blank">큰지도보기</a></div>', // 인포윈도우 부분 코드
	    iwPosition = new kakao.maps.LatLng(markerLatlng); // 인포윈도우 표시 위치 = 마커를 표시할 위치

	    // 인포윈도우 생성
	    var infowindow = new kakao.maps.InfoWindow({
	    position : iwPosition, 
	    content : iwContent 
	    });

	    infowindow.open(map, marker);
	    
	}

	 

	mapSearch(); // 검색창의 키워드로 검색

	function mapSearch() {
		var mapUl = document.getElementById("mapUl"); // 검색 결과를 붙일 부모 태그(ul)
		var keyword = document.getElementById("keyword").value; // 검색창에 입력한 텍스트값
		
		while(mapUl.hasChildNodes()) { // 이전에 붙어 있는 자식태그들 삭제
			mapUl.removeChild(mapUl.firstChild);
		}
		
		for(var i = 0; i < positions.length; i++) {
			if(positions[i].title.includes(keyword)) { // 등록된 마커들의 타이틀에 텍스트값이 포함되어 있으면,
				var mapItem = document.createElement("li"); // 검색 결과로 나올 li 태그 추가
				// 검색 결과 클릭하면, panTo() 호출 -> 해당 위치로 확대 
				mapItem.innerHTML = '<a href="javascript:panTo(' + positions[i].latlng.Ma + ','
				+ positions[i].latlng.La + ')">' + positions[i].title + '</a>' + '<br>' + positions[i].address;
				mapUl.appendChild(mapItem); // ul 태그에 붙이기
			}
		}
	}

	function panTo(ma, la) { // 해당 위도&경도로 확대
		// 지도 확대
		map.setLevel(5); 

	    // 이동할 위도 경도 위치를 생성합니다 
	    var moveLatLon = new kakao.maps.LatLng(ma, la);
	    
	    // 지도 중심을 부드럽게 이동시킵니다
	    // 만약 이동할 거리가 지도 화면보다 크면 부드러운 효과 없이 이동합니다
	    map.panTo(moveLatLon); 

	}
	</script>
	
</body>
</html>