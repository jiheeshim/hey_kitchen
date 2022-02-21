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
					
					<ul id="mapList">
					</ul>
				</div>
			</div>
			
			<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=9dba1125139c9fc4d8f64e57190988a7"></script>
			<script type="text/javascript" src="mapSearchScript.js"></script>
		</main>
		
		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>