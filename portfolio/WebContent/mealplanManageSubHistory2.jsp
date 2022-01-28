<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="mealplanManageStyle.css">
<link rel="stylesheet" type="text/css" href="mealplanManageHistoryStyle.css">
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
						<li id="currentLi"><a href="mealplanHistoryForm.sub">구독 내역 조회&nbsp;&gt;</a></li>
						<li><a href="mealplanManageCancel.jsp">구독 취소&nbsp;&gt;</a></li>
						<li><a href="#">고객 지원&nbsp;&gt;</a></li>
					</ul>
				</nav>
				<section class="manageSec">
					<div class="secTitle">구독 내역 조회</div>
					<form id="subDateForm" action="mealplanHistoryPro.sub" method="post" onsubmit="return checkDates();">
						<input type="hidden" name="today" value="${today}">
						<input type="hidden" name="month1" value="${month1}">
						<input type="hidden" name="month3" value="${month3}">
						<input type="hidden" name="month6" value="${month6}">
						<button type="button" id="today" onclick="javascript:setDates(this);">오늘</button>
						<button type="button" id="month1" onclick="javascript:setDates(this);">1개월</button>
						<button type="button" id="month3" onclick="javascript:setDates(this);">3개월</button>
						<button type="button" id="month6" onclick="javascript:setDates(this);">6개월</button>
						<br><input type="date" name="startDate" value="${startDate}">&nbsp; ~ &nbsp;
						<input type="date" name="endDate" value="${endDate}">
						<input type="submit" value="조회">
					</form>
					
					<table class="historyTable">
						<tr>
							<th>구독번호</th>
							<th>인원</th>
							<th>개수</th>
							<th>가격</th>
							<th>구독날짜</th>
							<th>구독현황</th>
						</tr>
						
						<c:if test="${mealplanList[0] != null}">
							<c:forEach var="mealplan" items="${mealplanList}">
								<tr>
									<td>${mealplan.mealplanNo}</td>
									<td>${mealplan.serving} 인분</td>
									<td>주 ${mealplan.servingCnt} 회</td>
									<td><fmt:formatNumber value="${mealplan.subPrice}" groupingUsed="true" /> 원</td>
									<td>${mealplan.subDate}</td>
									<td>
										<c:if test="${mealplan.cancelDate == null}">
											구독중
										</c:if>
										<c:if test="${mealplan.cancelDate != null}">
											${mealplan.cancelDate}<br>구독 만료
										</c:if>
									</td>
								</tr>
							</c:forEach>
						</c:if>
						
						<c:if test="${mealplanList[0] == null}">
							<tr>
								<td> - </td>
								<td> - </td>
								<td> - </td>
								<td> - </td>
								<td> - </td>
								<td> - </td>
							</tr>
						</c:if>
					</table>
				</section>
			</div>
		</main>
		
		<jsp:include page="footer.jsp" />
	</div>
</body>
<script type="text/javascript" src="mealplanManageHistoryScript.js"></script>
</html>