<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
						<li><a href="mealplanManage.sub">나의 구독 관리&nbsp;&gt;</a></li>
						<li><a href="mealplanHistoryForm.sub">구독 내역 조회&nbsp;&gt;</a></li>
						<li id="currentLi"><a href="mealplanManageCancel.jsp">구독 취소&nbsp;&gt;</a></li>
						<li><a href="#">고객 지원&nbsp;&gt;</a></li>
					</ul>
				</nav>
				<section class="manageSec">
					<div class="secTitle">밀플랜 취소하기</div>
					<div class="mealplanWrapper">
						<div class="cancelDesc">
							아래 버튼을 통해, 간단한 설문조사 후 구독을 <b>취소</b>하실 수 있습니다.
							<br>- <b>구독 취소</b> 후에는 되돌릴 수 없습니다.
							<br>- <b>구독 취소</b> 후 구독하기 메뉴를 통해 재구독이 가능합니다.
						</div>
						<br><button id="cancelBtn" onclick="location.href='mealplanCancel.sub'">구독 취소하기</button>
						<%-- 구독 취소 누르면 - 아래 form slide => 구독 취소 사유 DB테이블에 따로 저장하기 
						<div>
							<form id="cancelForm">
								구독 취소의 이유를 알려주세요.<br>
								<select name="reason">
									<option value="">가격이 비싸서</option>
									<option value="">메뉴가 마음에 들지 않아서</option>
									<option value="">메뉴의 다양성이 떨어져서</option>
									<option value="">음식이 맛있지 않아서</option>
									<option value="">배송이 불만족스러워서</option>
									<option value="">기타</option>
								</select>
								<br><button type="submit">구독을 취소합니다.</button>
							</form>
						</div> --%>
					</div>
				</section>
			</div>
		</main>
		
		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>