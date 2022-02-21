<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="headerFooter.css">
<link rel="stylesheet" type="text/css" href="recipeMyFeedStyle.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript" src="menuslide.js"></script>
<title>나의 레시피 피드</title>
</head>
<body>
	<div>
		<jsp:include page="header.jsp" />
		
		<main>
			<div class="title">나의 레시피 피드<font>&nbsp;_${id}</font></div>
			<div class="topBtn"><button type="button" onclick="location.href='recipeRegisterForm.rec'">레시피 등록하기</button></div>
			<nav class="sectionNav">
				<ul>
					<li><a href="recipeMyFeedView.rec">나의 레시피 피드</a></li>
					<li><a href="myReviewView.rec">내가 쓴 레시피 리뷰</a></li>
				</ul>
			</nav>
			<section class="sectionWrapper">
				<c:forEach var="recipe" items="${recipeList}">
					<div class="recipeWrapper">
						<div class="recipePic">
							<a href="recipeView.rec?recipeNo=${recipe.recipeNo}"><img width="240px" height="240px" src="recipeUpload/${recipe.thumbnailServer}"></a>
						</div>
						<div class="recipeTitle">
							<a href="recipeView.rec?recipeNo=${recipe.recipeNo}">${recipe.recipeName}</a>
							<div class="details">조회수 : ${recipe.readCount}</div>
							<div class="details">${recipe.regDate}</div>
						</div>
					</div>
				</c:forEach>
				<c:if test="${recipeList[0] == null}">
					<div class="recipeNull">
						<p>
							아직 등록하신 레시피가 없습니다 ㅠㅠ
							<br>나만의 레시피를 등록해 보세요!
						</p>
					</div>
				</c:if>
			</section>
		</main>
		
		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>