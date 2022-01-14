<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="mealplanStyle.css?ver=1">
<link rel="stylesheet" type="text/css" href="headerFooter.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript" src="menuslide.js"></script>
<title>밀플랜 구독 관리</title>
</head>
<body>
	<div>
		<jsp:include page="header.jsp" />
		
		<main>
			<section class="title">밀플랜 구독 관리</section>
			<section class="mealplanBox">
				<nav class="navBtns">
					<button id="currentBtn" type="button">나의 구독 설정 관리</button>
					<button type="button">다음 배송 정보 관리</button>
				</nav>
				<div>
					<br><br><br>구독 관련 정보 조회
					<br>구독 관련 정보 조회
					<br>구독 관련 정보 조회
					<br>구독 관련 정보 조회
					<br>구독 관련 정보 조회
				</div>
			</section>
		</main>
		
		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>