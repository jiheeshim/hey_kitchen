<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="headerFooter.css">
<link rel="stylesheet" type="text/css" href="myRecipesStyle.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript" src="menuslide.js"></script>
<title>나의 레시피 피드</title>
</head>
<body>
	<div>
		<jsp:include page="header.jsp" />
		
		<main>
			<div class="title">나의 레시피 피드<font>&nbsp;_userName</font></div>
			<div class="topBtn"><button type="button">레시피 등록하기</button></div>
			<nav class="sectionNav">
				<ul>
					<li><a href="#">나의 레시피 피드</a></li>
					<li><a href="#">내가 쓴 레시피 리뷰</a></li>
				</ul>
			</nav>
			<section class="sectionWrapper">
				<div class="recipeWrapper">
					<div class="recipePic">썸네일</div>
					<div class="recipeTitle">썸네일 이름</div>
				</div>
				<div class="recipeWrapper">
					<div class="recipePic">썸네일</div>
					<div class="recipeTitle">썸네일 이름</div>
				</div>
				<div class="recipeWrapper">
					<div class="recipePic">썸네일</div>
					<div class="recipeTitle">썸네일 이름</div>
				</div>
				<div class="recipeWrapper">
					<div class="recipePic">썸네일</div>
					<div class="recipeTitle">썸네일 이름</div>
				</div>
			</section>
		</main>
		
		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>