<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="recipeViewStyle.css">
<link rel="stylesheet" type="text/css" href="headerFooter.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript" src="menuslide.js"></script>
<title>헤이키친 : 레시피</title>
</head>
<body>
	<div>
		<jsp:include page="header.jsp" />
		
		<main>
			<section>
				<article class="intro">
					<div class="introImg"><img width="350px" height="350px" src="recipeUpload/${recipe.thumbnailServer}"></div>
					<div class="introDesc">
						<div>
							<div class="title">${recipe.recipeName}</div>
							<div class="writer">by ${recipe.id}</div>
							<div class="details">
								조회수 : ${recipe.readCount}<br>
								스크랩 수 : ${recipe.scrapCount}<br>
								작성일 : ${recipe.regDate}
								<c:if test="${recipe.editDate != null}">
									&nbsp;수정일 : ${recipe.editDate}
								</c:if>
							</div>
							<div id="scraps">
								<input type="hidden" name="id" value="${id}">
								<input type="hidden" name="recipeId" value="${recipe.id}">
								<input type="hidden" name="isScrapped" value="${isScrapped}">
								<c:if test="${isScrapped == true}">
									<button id="scrapBtn" class="isScrapped" type="button"></button>
								</c:if>
								<c:if test="${isScrapped == false}">
									<button id="scrapBtn" class="isNotScrapped" type="button"></button>
								</c:if>
								<a href="">&nbsp;스크랩&nbsp;</a>
							</div>
						</div>
						<div class="desc">${recipe.recipeDesc}</div>
					</div>
				</article>
			</section>
			
			<nav id="recipeNav">
				<a href="#reviewSec">후기 보기 (${reviewList.size()}개)</a>
			</nav>
			
			<section id="recipeSec">
				<article>
					<form>
						<span class="subTitle">재료</span>
						<button type="button" id="ingrBtn">+ 장보기 목록에 재료 추가</button>
						<ul class="ingrList">
							<c:forEach var="ingredients" items="${ingredientsArr}">
								<li><input type="checkbox" name="ingr" value="${ingredients}">&nbsp;&nbsp;${ingredients}</li>
							</c:forEach>
						</ul>
					</form>
				</article>
				<article>
					<span class="subTitle">요리 방법</span>
					<c:if test="${recipeImgList[0] != null}">
						<c:forEach var="i" begin="0" end="${recipeImgList.size()-1}">
							<div class="step">
								<img width="240px" height="240px" src="recipeUpload/${recipeImgList[i].imgServerName}">
								<div>
									<div class="stepNum">&nbsp;${i+1}단계&nbsp;</div>
									<div class="stepDesc">${recipeImgList[i].imgDesc}</div>
								</div>
							</div>
						</c:forEach>
					</c:if>
				</article>
			</section>
			
			<section id="reviewSec">
				<span class="subTitle">레시피 후기 (${reviewList.size()}개)</span>
				
				<c:if test="${id != null}">
					<form action="reviewReplyPro.rec" method="post" enctype="multipart/form-data">
						<input type="hidden" name="recipeNo" value="${recipe.recipeNo}">
						<div class="myId">${id}</div>
						<div class="writeBox">
							<div>
								<textarea name="content" placeholder="레시피에 대한 후기를 알려주세요 :)" required></textarea>
							</div>
							<div class="writeInnerBox">
								<input type="file" name="imgName" accept="image/*">
								<button type="submit">후기 올리기</button>
							</div>
						</div>
					</form>
				</c:if>
					
				<c:if test="${reviewList[0] != null}">
					<c:forEach var="review" items="${reviewList}">
						
						<div class="reviewBox">
							<div class="reviewId">${review.id}</div>
							<c:if test="${review.imgServerName != null}">
								<div class="contentWithImg">
									<c:set var="point" value="10" />
									<img width="100px" height="100px" src="recipeUpload/${review.imgServerName}">
									<div>${review.content}</div>
								</div>
							</c:if>
							<c:if test="${review.imgServerName == null}">
								<div class="contentOnly">
									<c:set var="point" value="5" />
									<div>${review.content}</div>
								</div>
							</c:if>
							<div class="reviewDetails">
								<span>
									<c:if test="${review.id eq id}">
										<button type="button">수정하기</button>&nbsp;
										<button type="button" onclick="askDelete(${review.reviewNo}, ${recipe.recipeNo}, ${point})">삭제하기</button>
									</c:if>
								</span>
								<span class="reviewDates">
									작성일 : ${review.regDate}
									<c:if test="${review.editDate != null}">
										&nbsp;| 수정일 : ${review.editDate}
									</c:if>
								</span>
							</div>
						</div>
						
					</c:forEach>
				</c:if>
			</section>
		</main>
		
		<jsp:include page="footer.jsp" />
	</div>
	<script type="text/javascript" src="recipeViewScript.js"></script>
</body>
</html>