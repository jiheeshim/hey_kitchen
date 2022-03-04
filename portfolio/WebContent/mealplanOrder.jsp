<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="mealplanStyle.css">
<link rel="stylesheet" type="text/css" href="headerFooter.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript" src="menuslide.js"></script>
<title>밀플랜 구독하기</title>
</head>
<body>
	<div>
		<jsp:include page="header.jsp" />
		
		<main>
			<section class="title">나만의 밀플랜 구독하기</section>
			<section class="steps">
				<div class="step"><span>1</span>구독 옵션</div>
				<div class="dashed"></div>
				<div class="step"><span>2</span><span>메뉴 선택</span></div>
				<div class="dashed"></div>
				<div class="step"><span>3</span><span>구독 완료</span></div>
			</section>
			
			<section class="mealplanBox">
				<div class="guideBox">
					<div class="guideTitle">&lt;<span>1</span>인 기준 밀플랜 구독 가격&gt;</div>
					<div class="guide">
						<div>
							<c:forEach var="price" items="${priceList}">
								<input type="hidden" name="prices" value="${price.price}">
								<span class="priceSpan">
									주 <font>${price.servingCnt}</font> 회 밀플랜 - 
									<font><fmt:formatNumber value="${price.price}" groupingUsed="true" /></font>  원
								</span> 
							</c:forEach>
						</div>
					</div>
				</div>
				
				<form action="mealplanOrder.kitchen" onsubmit="return emptyCheck();">
					<input type="hidden" name="where" value="mealplanMenu">
					<div class="detailBox1">
						<span class="detailTitle">1. 몇 명을 위한 밀플랜인가요?</span>
						<span>
							<select name="serving">
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
							</select>
							<span class="subTitle">&nbsp;명</span>
						</span>
					</div>
					<div>각 밀플랜 메뉴는 선택하신 인원에 맞춘 양으로 배달됩니다.</div>
					<div class="dotted"></div>
					
					<div class="detailBox1">
						<span class="detailTitle">2. 주 몇 회의 식사를 신청하시겠습니까?</span>
						<span>
							<span class="subTitle">주&nbsp;</span>
							<select name="servingCnt">
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
							</select>
							<span class="subTitle">&nbsp;회</span>
						</span>
					</div>
					<div class="dotted"></div>

					<div class="detailBox2">
						<span class="detailTitle">3. 원하는 배송일과 배송지를 선택해주세요.</span>
						<div>
							<span class="subTitle">배송일</span>
							<select name="deliverDate">
								<c:forEach var="date" items="${dateList}">
									<option value="${date}">${date}</option>
								</c:forEach>
							</select>
							<br>* 배송 준비 시간을 위해, 신청 날짜로부터 3일 이후만 설정 가능합니다.
							<br>* 다음 배송일은 자동으로 선택한 배송일의 7일 후로 지정되며, 구독관리에서 변경 가능합니다.
						</div>
						<div>
							<div class="subTitle">배송지</div>
							<div class="addrRadios">
								<input type="radio" name="addrRadio" id="getAddr">기존 배송지 선택
								<input type="radio" name="addrRadio" id="newAddr" checked>새로운 배송지 입력
							</div>
							<div class="addr">
								<input type="hidden" name="user" id="userPostcode" value="${user.postcode}">
								<input type="hidden" name="user" id="userAddr1" value="${user.addr1}">
								<input type="hidden" name="user" id="userExtraAddr" value="${user.extraAddr}">
								<input type="hidden" name="user" id="userAddr2" value="${user.addr2}">
								<input type="text" name="postcode" size="10" placeholder="우편번호" readonly>
								<button type="button" id="search" onclick="searchPostcode()">찾기</button><br>
								<input type="text" name="addr1" size="30" placeholder="주소" readonly>
								<input type="text" name="extraAddr" size="25" placeholder="참고항목" readonly><br>
								<input type="text" name="addr2" size="80" placeholder="상세주소" required>
							</div>
						</div>
					</div>
					
					<div class="orderBtn"><button id="nextBtn" type="submit">다음 단계</button></div>
				</form>
			</section>
		</main>
		
		<jsp:include page="footer.jsp" />
	</div>

</body>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript" src="postcode.js"></script>
<script type="text/javascript" src="mealplanScript.js"></script>
</html>