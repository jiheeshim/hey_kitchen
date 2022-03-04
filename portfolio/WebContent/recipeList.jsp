<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="recipeListStyle.css">
<link rel="stylesheet" type="text/css" href="headerFooter.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript" src="menuslide.js"></script>
<title>헤이키친 : 레시피 커뮤니티</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	
	<main>
		<div class="subtitleWrap"><span class="subtitle1">레시피 커뮤니티</span></div>
		<div class="title">${category[0]} > ${category[1]}</div>
		
		<section>
			<c:forEach var="recipe" items="${recipeList}">
				<div class="recipeWrapper">
					<div class="recipePic">
						<a href="recipeView.rec?recipeNo=${recipe.recipeNo}"><img width="240px" height="240px" src="recipeUpload/${recipe.thumbnailServer}"></a>
					</div>
					<div class="recipeTitle">
						<a href="recipeView.rec?recipeNo=${recipe.recipeNo}">${recipe.recipeName}</a>
						<div class="details">by ${recipe.id}</div>
						<div class="details">조회수 : ${recipe.readCount}</div>
						<div class="details">작성일자 : ${recipe.regDate}</div>
					</div>
				</div>
			</c:forEach>
		</section>
			
		<div class="pages">
			<button type="button" <c:if test="${pageInfo.page > 1}"> onclick="location.href='recipeList.rec?page=${pageInfo.page - 1}'" </c:if> >&lt;</button>
			
			<c:forEach var="p" begin="${pageInfo.startPage}" end="${pageInfo.endPage}">
				<c:if test="${p == pageInfo.page}">
					<b>${p}</b>&nbsp;
				</c:if>
				<c:if test="${p != pageInfo.page}">
					<a href="recipeList.rec?page=${p}&group=${category[0]}&categ=${category[1]}">${p}</a>&nbsp;
				</c:if>
			</c:forEach>
			
			<button type="button" <c:if test="${pageInfo.page < pageInfo.maxPage}"> onclick="location.href='recipeList.rec?page=${pageInfo.page + 1}&group=${category[0]}&categ=${category[1]}'" </c:if> >&gt;</button>
		</div>
	</main>
	
	<jsp:include page="footer.jsp" />
</body>
</html>