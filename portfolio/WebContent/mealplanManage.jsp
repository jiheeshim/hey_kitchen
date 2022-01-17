<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="mealplanManageStyle.css">
<link rel="stylesheet" type="text/css" href="headerFooter.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript" src="menuslide.js"></script>
<title>밀플랜 구독 관리</title>
</head>
<body>
	<div>
		<jsp:include page="header.jsp" />
		
		<main>
			<div class="title">밀플랜 구독 관리</div>
			<div class="mainWrapper">
				<nav class="manageNav">
					<ul>
						<li id="currentLi"><a href="#">나의 구독 관리&nbsp;&gt;</a></li>
						<li><a href="#">구독 내역 조회&nbsp;&gt;</a></li>
						<li><a href="#">배송 내역 조회&nbsp;&gt;</a></li>
						<li><a href="#">고객 지원&nbsp;&gt;</a></li>
					</ul>
				</nav>
				<section class="manageSec">
					<div class="secTitle">나의 밀플랜 현황</div>
					<div class="mealplanWrapper">
						<ul>
							<li>나의 구독번호 : <font>${mealplan.mealplanNo}</font></li>
							<li>구독 신청 날짜 : <font>${mealplan.subDate}</font></li>
							<li>주 <font>${mealplan.servingCnt}</font> 회 <font>${mealplan.serving}</font> 인분</li>
							<li>가격 : <font>${mealplan.subPrice} 원</font></li>
						</ul>
					</div>
					<div class="secTitle">다음 밀플랜 배송 관리<button>배송 변경</button></div>
					<div class="mealplanWrapper">
						<ul>
							<li>나의 배송번호 : <font>deliveryNo</font></li>
							<li>다음 배송일 : <font>deliverDate - select</font></li>
							<li>
								다음 밀플랜 메뉴
								<br><font>mealkitName - select</font>
							</li>
							<li>
								나의 배송지
								<br><font>postcode - text</font>
								<br><font>addr1 extraAddr</font>
								<br><font>addr2</font>
							</li>
						</ul>
					</div>
				</section>
			</div>
		</main>
		
		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>