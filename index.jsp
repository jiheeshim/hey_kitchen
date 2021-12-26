<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>헤이키친</title>
	<link rel="stylesheet" type="text/css" href="headerFooter.css">
	<link rel="stylesheet" type="text/css" href="indexStyle.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
    <script type="text/javascript" src="menuslide.js"></script>
    <script type="text/javascript" src="skdslider/skdslider.min.js"></script>
    <link rel="stylesheet" type="text/css" href="skdslider/skdslider.css">
    <script type="text/javascript" src="skdslider/skdsliderInit.js"></script>
    <link rel="stylesheet" type="text/css" href="slick/slick.css"/>
    <link rel="stylesheet" type="text/css" href="slick/slick-theme.css"/>
    <script type="text/javascript" src="slick/slick.min.js"></script>
    <script type="text/javascript" src="slick/slickInit.js"></script>
</head>

<body>
	<div>
		<jsp:include page="header.jsp" />

		<main>
			<div id="imageslider">
				<div id="demo1">
					<div class="slide">
						<img src="image/firstImgSlider.png" />
					</div>
					<div class="slide">
						<img src="image/secondImgSlider.png" />
					</div>
					<div class="slide">
						<img src="image/thirdImgSlider.png" />
					</div>
				</div>
			</div>

			<section class="main_menu">
				<a href="#"><div class="menubox"><div id="nav1"></div></div></a>
				<div class="vline"></div>
				<a href="#"><div class="menubox"><div id="nav2"></div></div></a>
				<div class="vline"></div>
				<a href="#"><div class="menubox"><div id="nav3"></div></div></a>
			</section>

			<section class="maintitle">
				<div class="title_font">이번주 밀플랜 메뉴 미리보기</div>
			</section>

			<div class="mealplan_menu">
				<div class="lazy">
					<div>
						<div class="lazyimg"><a href="#"><img data-lazy="image/mealkit1.png" /></a></div>
					</div>
					<div>
						<div class="lazyimg"><a href="#"><img data-lazy="image/mealkit2.png" /></a></div>
					</div>
					<div>
						<div class="lazyimg"><a href="#"><img data-lazy="image/mealkit3.png" /></a></div>
					</div>
					<div>
						<div class="lazyimg"><a href="#"><img data-lazy="image/mealkit4.png" /></a></div>
					</div>
					<div>
						<div class="lazyimg"><a href="#"><img data-lazy="image/mealkit5.png" /></a></div>
					</div>
					<div>
						<div class="lazyimg"><a href="#"><img data-lazy="image/mealkit6.png" /></a></div>
					</div>
				</div>
			</div>

			<div class="backgroundbox">
				<section class="maintitle">
					<div class="title_font">이런 레시피는 어떤가요?</div>
				</section>
				<section class="maincontent">
					<div class="recipes_pic">
						<a href="#"><img src="image/recipe1.png" /> <!-- 가구원수 기준 레시피 추천 바로가기 -->
						<div class="details">
							<p>녹차 팬케이크</p>
							<p>by ghdrlfehd1</p>
						</div></a>
					</div>
					<div class="recipes_pic">
						<a href="#"><img src="image/duckplate.png" /> <!-- 조회수 기준 레시피 추천 바로가기 -->
						<div class="details">
							<p>오리고기 스테이크</p>
							<p>by wjsdncl</p>
						</div></a>
					</div>
					<div class="recipes_pic">
						<a href="#"><img src="image/duruchigi.png" /> <!-- 후기수 기준 레시피 추천 바로가기 -->
						<div class="details">
							<p>매콤 두루치기</p>
							<p>by back7979</p>
						</div></a>
					</div>
				</section>
			</div>

			<section class="main_menu">
				<div class="boardbox">
					<p>소통해요!</p>
					<div class="contact">
						<b>SNS</b>
						<div>
							<img src="image/snsyt.png" />
							<img src="image/snsig.png" />
							<img src="image/snspin.png" />
						</div>
						<b>피드백 / 소통</b>
						<p>웹사이트 서비스 관련 :<br>
						jiheeshim1@gmail.com</p>
					</div>
				</div>
				<div class="boardboxL">
					<p><a href="#">이벤트 & 공지사항</a></p>
					<div class="banners">
						<img src="image/banner1.png" />
						<img src="image/banner2.png" />
					</div>
					<div class="notice">
						<ul>
							<li>
								<div class="noticeT"><a href="#">안녕하세요 굉장히상당히매우매우 긴 공지사항 제목입니다.</a></div>
								<span class="noticeD">2021.12.10</span>
							</li>
							<li>
								<div class="noticeT"><a href="#">안녕하세요 이벤트 제목입니다.</a></div>
								<span class="noticeD">2021.12.10</span>
							</li>
							<li>
								<div class="noticeT"><a href="#">안녕하세요 공지사항 제목입니다.</a></div>
								<span class="noticeD">2021.12.10</span>
							</li>
						</ul>
					</div>
				</div>
				<div class="boardbox">
					<p><a href="#">고객센터</a></p>
					<div class="help">
						<img src="image/csicon.png" />
						<b>온라인 문의</b>
						<p><a href="#">1:1 문의하기 ></a><br><br>
						<a href="#">F & Q 바로가기 ></a></p>
					</div>
				</div>				
			</section>
		</main>

		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>