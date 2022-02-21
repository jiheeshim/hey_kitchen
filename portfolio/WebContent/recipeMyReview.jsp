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
				<ul>
					<c:forEach var="myReview" items="${myReviewList}">
						<li>
							<a href="recipeView.rec?recipeNo=${myReview.recipeNo}">${myReview.recipeName}</a>		
							<div class="content">${myReview.content}</div>
							<div class="dates">작성일자 : ${myReview.regDate} <c:if test="${myReview.editDate != null}">수정일자 : ${myReview.editDate}</c:if> </div>
						</li>
					</c:forEach>
				</ul>
			</section>
		</main>
		
		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>