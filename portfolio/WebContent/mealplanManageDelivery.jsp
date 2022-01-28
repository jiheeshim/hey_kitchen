<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="mealplanManageStyle.css">
<link rel="stylesheet" type="text/css" href="headerFooter.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript" src="menuslide.js"></script>
<title>밀플랜 구독 관리</title>
</head>
<body>
	<div>
		<jsp:include page="header.jsp" />
		
		<main>
			<div class="title">밀플랜 구독 관리</div>
			<div class="mainWrapper">
				<nav class="manageNav">
					<ul>
						<li id="currentLi"><a href="mealplanManage.sub">나의 구독 관리&nbsp;&gt;</a></li>
						<li><a href="mealplanHistoryForm.sub">구독 내역 조회&nbsp;&gt;</a></li>
						<li><a href="mealplanManageCancel.jsp">구독 취소&nbsp;&gt;</a></li>
						<li><a href="#">고객 지원&nbsp;&gt;</a></li>
					</ul>
				</nav>
				<section class="manageSec">
					<div class="secTitle">밀플랜 배송지 변경</div>
					<div class="mealplanWrapper">
						<form id="deliveryForm" action="deliveryModifyPro.sub">
						나의 배송지&nbsp;<button type="submit">변경 확인</button>
						<input type="hidden" name="deliveryNo" value="${delivery.deliveryNo}">
						<br>우편번호 : <input type="text" name="postcode" size="10" value="${delivery.postcode}" readonly>
						<button type="button" id="search" onclick="searchPostcode()">찾기</button>
						<br>주소 : <input type="text" name="addr1" size="30" value="${delivery.addr1}" readonly>
						<input type="text" name="extraAddr" size="25" value="${delivery.extraAddr}" readonly>
						<br>상세주소 : <input type="text" name="addr2" size="80" value="${delivery.addr2}" required>
						</form>
					</div>
				</section>
			</div>
		</main>
		
		<jsp:include page="footer.jsp" />
	</div>
</body>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript" src="postcode.js"></script>
</html>