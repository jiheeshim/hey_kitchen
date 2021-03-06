<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>헤이키친</title>
	<link rel="stylesheet" type="text/css" href="headerFooter.css?ver=1">
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
				<a href="header.kitchen?where=mealplanOrder"><div class="menubox"><div id="nav1"></div></div></a>
				<div class="vline"></div>
				<a href="#"><div class="menubox"><div id="nav2"></div></div></a>
				<div class="vline"></div>
				<a href="recipeMyFeedView.rec"><div class="menubox"><div id="nav3"></div></div></a>
			</section>

			<section class="maintitle">
				<div class="title_font">이번주 밀플랜 메뉴 미리보기</div>
			</section>

			<div class="mealplan_menu">
				<div class="lazy">
					<div>
						<div class="lazyimg"><a href="#"><img data-lazy="image/mealkit01.png" /></a></div>
					</div>
					<div>
						<div class="lazyimg"><a href="#"><img data-lazy="image/mealkit02.png" /></a></div>
					</div>
					<div>
						<div class="lazyimg"><a href="#"><img data-lazy="image/mealkit03.png" /></a></div>
					</div>
					<div>
						<div class="lazyimg"><a href="#"><img data-lazy="image/mealkit04.png" /></a></div>
					</div>
					<div>
						<div class="lazyimg"><a href="#"><img data-lazy="image/mealkit05.png" /></a></div>
					</div>
					<div>
						<div class="lazyimg"><a href="#"><img data-lazy="image/mealkit06.png" /></a></div>
					</div>
				</div>
			</div>

			<div class="backgroundbox">
				<section class="maintitle">
					<div class="title_font">이런 레시피는 어떤가요?</div>
				</section>
				<section class="maincontent">
					<!-- 가구원수 기준 레시피 추천 바로가기 -->
					<c:if test="${familyRecipe != null}">
						<div class="recipes_pic">
							<a href="recipeView.rec?recipeNo=${familyRecipe.recipeNo}">
								<img width="250px" height="250px" src="recipeUpload/${familyRecipe.thumbnailServer}" /> 
								<div class="details">
									<p>${familyRecipe.recipeName}</p>
									<p>by ${familyRecipe.id}</p>
								</div>
							</a>
						</div>
					</c:if>
					<!-- 조회수 기준 레시피 추천 바로가기 -->
					<c:if test="${readCountRecipe != null}">
						<div class="recipes_pic">
							<a href="recipeView.rec?recipeNo=${readCountRecipe.recipeNo}">
								<img width="250px" height="250px" src="recipeUpload/${readCountRecipe.thumbnailServer}" /> 
								<div class="details">
									<p>${readCountRecipe.recipeName}</p>
									<p>by ${readCountRecipe.id}</p>
								</div>
							</a>
						</div>
					</c:if>
					<!-- 후기수 기준 레시피 추천 바로가기 -->
					<c:if test="${reviewCountRecipe != null}">
						<div class="recipes_pic">
							<a href="recipeView.rec?recipeNo=${reviewCountRecipe.recipeNo}">
								<img width="250px" height="250px" src="recipeUpload/${reviewCountRecipe.thumbnailServer}" /> 
								<div class="details">
									<p>${reviewCountRecipe.recipeName}</p>
									<p>by ${reviewCountRecipe.id}</p>
								</div>
							</a>
						</div>
					</c:if>
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
					<p><a href="noticeListSelect.jsp">이벤트 & 공지사항</a></p>
					<div class="banners">
						<img src="image/banner1.png" />
						<img src="image/banner2.png" />
					</div>
					<div class="notices">
						<ul>
							<c:forEach var="notice" items="${noticeList}">
								<li>
									<div class="noticeT">
										<a href="noticeSelect.jsp?noticeNo=${notice.noticeNo}&purpose=view">${notice.title}</a>
									</div>
									<span class="noticeD">${notice.regDate}</span>
								</li>
							</c:forEach>
						</ul>
					</div>
				</div>
				<div class="boardbox">
					<p><a href="#">고객센터</a></p>
					<div class="help">
						<img src="image/csicon.png" />
						<b>온라인 문의</b>
						<p><a href="qnaList.qna">문의게시판 바로가기 ></a><br><br>
						<a href="#">1:1 실시간 채팅 ></a></p>
					</div>
				</div>				
			</section>
		</main>

		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>