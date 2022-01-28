<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="mealplanStyle.css?ver=1">
<link rel="stylesheet" type="text/css" href="headerFooter.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript" src="menuslide.js"></script>
<link rel="stylesheet" type="text/css" href="slick/slick.css"/>
<link rel="stylesheet" type="text/css" href="slick/slick-theme.css"/>
<script type="text/javascript" src="slick/slick.min.js"></script>
<script type="text/javascript" src="slick/slickInitSmall.js"></script>
<title>밀플랜 구독하기</title>
</head>
<body>
	<div>
		<jsp:include page="header.jsp" />
		
			<main>
				<section class="title">나만의 밀플랜 구독하기</section>
				<section class="steps">
					<div class="step"><span>1</span><span>구독 옵션</span></div>
					<div class="dashed"></div>
					<div class="step"><span>2</span>메뉴 선택</div>
					<div class="dashed"></div>
					<div class="step"><span>3</span><span>구독 완료</span></div>
				</section>
			
				<section class="mealplanBox">
					<form action="mealplanMenu.kitchen">
						<input type="hidden" name="where" value="mealplanInsert">
						
						<input type="hidden" name="mealplanNo" value="${mealplan.mealplanNo}">
						<input type="hidden" name="serving" value="${mealplan.serving}">
						<input type="hidden" name="servingCnt" value="${mealplan.servingCnt}">
						<input type="hidden" name="deliveryNo" value="${mealplanDelivery.deliveryNo}">
						<input type="hidden" name="postcode" value="${mealplanDelivery.postcode}">
						<input type="hidden" name="addr1" value="${mealplanDelivery.addr1}">
						<input type="hidden" name="extraAddr" value="${mealplanDelivery.extraAddr}">
						<input type="hidden" name="addr2" value="${mealplanDelivery.addr2}">
						<input type="hidden" name="deliverDate" value="${mealplanDelivery.deliverDate}">
						
						<div class="detailBox2">
							<span class="detailTitle">3. 원하는 밀키트 메뉴를 선택해주세요.</span>
							
							<div class="mealkitPic">
								<div class="lazy">
									<c:forEach var="mealkit" items="${mealkitList}">
										<div>
											<div class="lazyimg"><img data-lazy="${mealkit.mealkitImg}" /></div>
										</div>
									</c:forEach>
								</div>
							</div>
							
							<div>
								<c:forEach var="i" begin="1" end="${mealplan.servingCnt}">
									<div class="mealkitSelect">
										<div>${i}번째 메뉴</div>
										<select name="mealkitNo">
											<c:forEach var="mealkit" items="${mealkitList}">
												<option value="${mealkit.mealkitNo}">${mealkit.mealkitName}</option>
											</c:forEach>
										</select>
									</div>
								</c:forEach>
							</div>
							<div class="orderBtn"><button type="submit">구독하기</button></div>
						</div>
					</form>
				</section>
			</main>

		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>