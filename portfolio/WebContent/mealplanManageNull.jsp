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
						구독 중인 밀플랜이 없습니다.
						<br><br><a class="transfer" href="header.kitchen?where=mealplanOrder">밀플랜 구독하러 가기 &gt;&gt;</a>
					</div>
				</section>
			</div>
		</main>
		
		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>