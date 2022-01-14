<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="mealplanStyle.css?ver=2">
<link rel="stylesheet" type="text/css" href="headerFooter.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript" src="menuslide.js"></script>
<link rel="stylesheet" type="text/css" href="slick/slick.css"/>
<link rel="stylesheet" type="text/css" href="slick/slick-theme.css"/>
<script type="text/javascript" src="slick/slick.min.js"></script>
<script type="text/javascript" src="slick/slickInitSmall.js"></script>
<title>밀플랜 구독하기</title>
</head>
<body>
	<div>
		<jsp:include page="header.jsp" />
		
		<main>
			<section class="title">나만의 밀플랜 구독하기</section>
			<section class="steps">
				<div class="step"><span>1</span><span>구독 옵션</span></div>
				<div class="dashed"></div>
				<div class="step"><span>2</span><span>메뉴 선택</span></div>
				<div class="dashed"></div>
				<div class="step"><span>3</span>구독 완료</div>
			</section>
			
			<section class="mealplanBox">
				<div class="detailBox2">
					<div class="title">구독 신청이 완료되었습니다!</div>
				</div>
				<div class="txtCenter">
					<div class="subTitle">고객님의 구독번호 : ${mealplanNo}</div>
					<br>신청해주셔서 감사합니다.
					<br>고객님의 하루하루가 맛있고 건강한 끼니들로 채워지는 그 날까지!
					<br><br>메뉴 또는 배송지 변경 등은 <b>[밀플랜 정기구독 - 밀플랜 구독 관리]</b>에서 가능합니다.
					<br><br>
				</div>
				<div class="orderBtn"><button type="button" onclick="mealplanManage.jsp">밀플랜 구독 관리</button></div>
				<br><br>
			</section>
		</main>
		
		<jsp:include page="footer.jsp" />
	</div>
</body>
<script type="text/javascript" src="noRefresh.js"></script>
</html>