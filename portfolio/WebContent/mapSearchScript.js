//var mapContainer = document.getElementById('map'), // 지도를 표시할 div  
//    mapOption = { 
//        center: new kakao.maps.LatLng(37.548065, 126.814818), // 지도의 중심좌표
//        level: 9 // 지도의 확대 레벨
//    };
//
//var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
// 
//// 마커를 표시할 위치와 title 객체 배열입니다 
//var positions = [
//    {
//        title: '헤이키친 연희점', 
//        latlng: new kakao.maps.LatLng(37.572944, 126.935171),
//        address: '서울특별시 서대문구 연희동 78-43'
//    },
//    {
//        title: '헤이키친 도화점', 
//        latlng: new kakao.maps.LatLng(37.542959, 126.949774),
//        address: '서울특별시 마포구 도화동 17-3'
//    },
//    {
//        title: '헤이키친 아현점', 
//        latlng: new kakao.maps.LatLng(37.555536, 126.955538),
//        address: '서울특별시 마포구 아현동 291-8'
//    },
//    {
//        title: '헤이키친 동대문점',
//        latlng: new kakao.maps.LatLng(37.574668, 127.038741),
//        address: '서울특별시 동대문구 용두동 33-1'
//    },
//    {
//        title: '헤이키친 회기점',
//        latlng: new kakao.maps.LatLng(37.590745, 127.054903),
//        address: '서울특별시 동대문구 회기동 회기로25길 4'
//    },
//    {
//        title: '헤이키친 석관점',
//        latlng: new kakao.maps.LatLng(37.608491, 127.054488),
//        address: '서울특별시 성북구 석관동 338-363'
//    },
//    {
//        title: '헤이키친 강남점',
//        latlng: new kakao.maps.LatLng(37.500399, 127.027994),
//        address: '서울특별시 강남구 강남대로98길 12-5'
//    },
//    {
//        title: '헤이키친 부천점',
//        latlng: new kakao.maps.LatLng(37.502625, 126.772029),
//        address: '경기도 부천시 중동로262번길 54'
//    }
//];
//
//var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png"; // 마커 이미지의 이미지 주소 
    
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

