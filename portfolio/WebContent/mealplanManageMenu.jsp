<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="mealplanStyle.css">
<link rel="stylesheet" type="text/css" href="headerFooter.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript" src="menuslide.js"></script>
<link rel="stylesheet" type="text/css" href="slick/slick.css"/>
<link rel="stylesheet" type="text/css" href="slick/slick-theme.css"/>
<script type="text/javascript" src="slick/slick.min.js"></script>
<script type="text/javascript" src="slick/slickInitSmall.js"></script>
<title>밀플랜 구독 관리</title>
</head>
<body>
	<div>
		<jsp:include page="header.jsp" />
		
		<main>
			<div class="title">밀플랜 메뉴 변경</div>
			<section class="mealplanBox">
				<form action="menuModifyPro.sub">
					<div class="detailBox2">
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
							<c:forEach var="i" begin="1" end="${menuList.size()}">
								<div class="mealkitSelect">
									<div>${i}번째 메뉴</div>
									<input type="hidden" name="menuNo" value="${menuList[i-1].menuNo}">
									<select name="mealkitNo">
										<c:forEach var="mealkit" items="${mealkitList}">
											<option value="${mealkit.mealkitNo}" <c:if test="${menuList[i-1].mealkitNo eq mealkit.mealkitNo}"> selected </c:if> >${mealkit.mealkitName}</option>
										</c:forEach>
									</select>
								</div>
							</c:forEach>
						</div>
						<div class="orderBtn"><button type="submit">메뉴 변경</button></div>
					
					</div>
				</form>
			</section>
		</main>
		
		<jsp:include page="footer.jsp" />
	</div>
</body>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript" src="postcode.js"></script>
</html>