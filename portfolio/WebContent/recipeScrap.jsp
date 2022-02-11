<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="headerFooter.css">
<link rel="stylesheet" type="text/css" href="recipeScrapStyle.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript" src="menuslide.js"></script>
<title>레시피 스크랩 갤러리</title>
</head>
<body>
	<div>
		<jsp:include page="header.jsp" />
		
		<main>
			<div class="title">
				<div class="mainTitle">📔🍽 레시피 스크랩 갤러리</div>
				<div class="subTitle">내가 스크랩한 레시피들을 모아 보세요.</div>
			</div>
			
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
						스크랩한 레시피가 없습니다.
						<br><a href="#">레시피 커뮤니티 바로가기</a>
						</p>
					</div>
				</c:if>
			</section>
		</main>
		
		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>