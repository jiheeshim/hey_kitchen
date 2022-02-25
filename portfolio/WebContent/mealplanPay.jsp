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
				<div class="step"><span>1</span><span>구독 옵션</span></div>
				<div class="dashed"></div>
				<div class="step"><span>2</span><span>메뉴 선택</span></div>
				<div class="dashed"></div>
				<div class="step"><span>3</span>결제하기</div>
			</section>
			
			<section class="mealplanBox">
				<form id="payForm" action="mealplan.kitchen">
					<input type="hidden" name="where" value="mealplanInsert">
					
					<input type="hidden" name="mealplanNo" value="${mealplan.mealplanNo}">
					<input type="hidden" name="deliveryNo" value="${mealplanDelivery.deliveryNo}">
					<c:forEach var="mealkitNoArr" items="${mealkitNoArr}">
						<input type="hidden" name="mealkitNo" value="${mealkitNoArr}">
					</c:forEach>
					
					<input type="hidden" name="addr1" value="${mealplanDelivery.addr1}">
					<input type="hidden" name="extraAddr" value="${mealplanDelivery.extraAddr}">
					<input type="hidden" name="addr2" value="${mealplanDelivery.addr2}">
					
					<input type="hidden" name="point" value="${user.point}">
					<input type="hidden" name="price" value="${price}">
				
					<br><br><div class="detailTitle"> &lt; 구독 정보 확인 &gt;</div>
					<div class="detailBox1">
						<div class="innerBox">
							<div class="subTitle2"> &lt; 구독 메뉴 확인 &gt;</div>
							<b>주 <input class="num" type="text" name="servingCnt" value="${mealplan.servingCnt}" readonly="readonly"> 회
							&nbsp;&nbsp;<input class="num" type="text" name="serving" value="${mealplan.serving}" readonly="readonly"> 인분씩 구독합니다.</b>
							<ul class="menus">
								<c:forEach var="mealkit" items="${mealkitNameList}">
									<li>- <b>${mealkit.mealkitName}</b></li>
								</c:forEach>
							</ul>
						</div>
						<div class="innerBox">
							<div class="subTitle2"> &lt; 배송 정보 확인 &gt;</div>
							<ul class="address">
								<li>- <b>우편번호</b> : <input type="text" name="postcode" value="${mealplanDelivery.postcode}" readonly="readonly"></li>
								<li>
									- <b>주소</b> :
									<br>&nbsp;&nbsp;${mealplanDelivery.addr1} ${mealplanDelivery.extraAddr}
									<br>&nbsp;&nbsp;${mealplanDelivery.addr2}
								</li>
								<li>- <b>배송일</b> : <input type="text" name="deliverDate" value="${mealplanDelivery.deliverDate}" readonly="readonly"></li>
							</ul>
						</div>
					</div>
					<div class="dotted"></div>
					<div class="detailBox2">
						<span class="detailTitle"> &lt; 결제 정보 &gt;</span>
						<table>
							<tr>
								<td>적립금 사용</td>
								<td>
									<input type="text" name="pointUsage" value="0" size="8" onKeyup="this.value=this.value.replace(/[^0-9]/g, '')" required>원
									<button type="button" id="pointBtn">모두 사용</button>
								</td>
							</tr>
							<tr>
								<td>&nbsp;</td>
								<td class="pointTd">(가용 적립금 : ${user.point}원)</td>
							</tr>
							<tr>
								<td>결제 수단</td>
								<td>
									<input type="radio" checked> 신용카드 &nbsp;
									<input type="radio"> 카카오페이 &nbsp;
									<input type="radio"> 네이버페이 &nbsp;
									<input type="radio"> 계좌이체 &nbsp;
								</td>
							</tr>
						</table>
						<div class="totalPrice">총 가격 :&nbsp; <span id="priceSpan"></span>&nbsp;원&nbsp;&nbsp;&nbsp;</div>
					</div>
				
					<div class="orderBtn"><button type="submit">결제하기</button></div>
				</form>
			</section>
		</main>
		
		<jsp:include page="footer.jsp" />
	</div>
	<script type="text/javascript" src="mealplanPayScript.js"></script>

</body>
</html>