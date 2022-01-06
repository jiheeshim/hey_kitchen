<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="model.UsersDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="headerFooter.css">
<link rel="stylesheet" type="text/css" href="mypageStyle.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript" src="menuslide.js"></script>
<title>마이페이지</title>
</head>
<body>
	<div>
		<jsp:include page="header.jsp" />
		<main>
			<div class="mainWrapper">
				<nav class="mypageNav">
					<ul>
						<li class="currentLi"><a href="mypage.jsp">회원정보 관리</a></li>
						<li><a href="mypagePwChange.jsp">비밀번호 변경</a></li>
						<li><a href="#">적립금 조회</a></li>
						<li><a href="#">밀플랜 구독관리</a></li>
						<li><a href="#">1:1 문의내역</a></li>
						<li><a href="mypageQuit.jsp">회원 탈퇴</a></li>
					</ul>
				</nav>
				<section>
					<div class="title">회원정보 관리</div>
					<form action="mypageUpdate.jsp" onsubmit="return mypageUpdateCheck();">
						<input type="hidden" name="id" value="${user.id}">
						<div class="titleLine"></div>
						<table class="userTable">
							<tr>
								<td>이름</td>
								<td><input type="text" name="name" id="name" size="44" value="${user.name}"></td>
							</tr>
							<tr>
								<td>이메일</td>
								<td><input type="text" name="email" size="44" value="${user.email}"></td>
							</tr>
							<tr>
								<td>휴대번호</td>
								<td><input type="text" name="tel" size="44" value="${user.tel}"></td>
							</tr>
							<tr>
								<td>생년월일</td>
								<td>
									<input type="text" name="birthyear" size="8" value="${fn:substring(user.birthday,0,4)}">&nbsp;년&nbsp;
									<c:set var="birthmonth" value="${fn:substring(user.birthday,5,7)}" />
									<select class="selectstyle" name="birthmonth">
										<option value="0" <c:if test="${birthmonth eq 0}">selected</c:if>></option>
										<option value="1" <c:if test="${birthmonth eq 1}">selected</c:if>>1</option>
										<option value="2" <c:if test="${birthmonth eq 2}">selected</c:if>>2</option>
										<option value="3" <c:if test="${birthmonth eq 3}">selected</c:if>>3</option>
										<option value="4" <c:if test="${birthmonth eq 4}">selected</c:if>>4</option>
										<option value="5" <c:if test="${birthmonth eq 5}">selected</c:if>>5</option>
										<option value="6" <c:if test="${birthmonth eq 6}">selected</c:if>>6</option>
										<option value="7" <c:if test="${birthmonth eq 7}">selected</c:if>>7</option>
										<option value="8" <c:if test="${birthmonth eq 8}">selected</c:if>>8</option>
										<option value="9" <c:if test="${birthmonth eq 9}">selected</c:if>>9</option>
										<option value="10" <c:if test="${birthmonth eq 10}">selected</c:if>>10</option>
										<option value="11" <c:if test="${birthmonth eq 11}">selected</c:if>>11</option>
										<option value="12" <c:if test="${birthmonth eq 12}">selected</c:if>>12</option>
									</select>&nbsp;월&nbsp;
									<c:set var="birthdate" value="${fn:substring(user.birthday,8,10)}" />
									<select class="selectstyle" name="birthdate">
										<option value="0" <c:if test="${birthdate eq 0}">selected</c:if>></option>
										<option value="1" <c:if test="${birthdate eq 1}">selected</c:if>>1</option>
										<option value="2" <c:if test="${birthdate eq 2}">selected</c:if>>2</option>
										<option value="3" <c:if test="${birthdate eq 3}">selected</c:if>>3</option>
										<option value="4" <c:if test="${birthdate eq 4}">selected</c:if>>4</option>
										<option value="5" <c:if test="${birthdate eq 5}">selected</c:if>>5</option>
										<option value="6" <c:if test="${birthdate eq 6}">selected</c:if>>6</option>
										<option value="7" <c:if test="${birthdate eq 7}">selected</c:if>>7</option>
										<option value="8" <c:if test="${birthdate eq 8}">selected</c:if>>8</option>
										<option value="9" <c:if test="${birthdate eq 9}">selected</c:if>>9</option>
										<option value="10" <c:if test="${birthdate eq 10}">selected</c:if>>10</option>
										<option value="11" <c:if test="${birthdate eq 11}">selected</c:if>>11</option>
										<option value="12" <c:if test="${birthdate eq 12}">selected</c:if>>12</option>
										<option value="13" <c:if test="${birthdate eq 13}">selected</c:if>>13</option>
										<option value="14" <c:if test="${birthdate eq 14}">selected</c:if>>14</option>
										<option value="15" <c:if test="${birthdate eq 15}">selected</c:if>>15</option>
										<option value="16" <c:if test="${birthdate eq 16}">selected</c:if>>16</option>
										<option value="17" <c:if test="${birthdate eq 17}">selected</c:if>>17</option>
										<option value="18" <c:if test="${birthdate eq 18}">selected</c:if>>18</option>
										<option value="19" <c:if test="${birthdate eq 19}">selected</c:if>>19</option>
										<option value="20" <c:if test="${birthdate eq 20}">selected</c:if>>20</option>
										<option value="21" <c:if test="${birthdate eq 21}">selected</c:if>>21</option>
										<option value="22" <c:if test="${birthdate eq 22}">selected</c:if>>22</option>
										<option value="23" <c:if test="${birthdate eq 23}">selected</c:if>>23</option>
										<option value="24" <c:if test="${birthdate eq 24}">selected</c:if>>24</option>
										<option value="25" <c:if test="${birthdate eq 25}">selected</c:if>>25</option>
										<option value="26" <c:if test="${birthdate eq 26}">selected</c:if>>26</option>
										<option value="27" <c:if test="${birthdate eq 27}">selected</c:if>>27</option>
										<option value="28" <c:if test="${birthdate eq 28}">selected</c:if>>28</option>
										<option value="29" <c:if test="${birthdate eq 29}">selected</c:if>>29</option>
										<option value="30" <c:if test="${birthdate eq 30}">selected</c:if>>30</option>
										<option value="31" <c:if test="${birthdate eq 31}">selected</c:if>>31</option>
									</select>&nbsp;일
								</td>
							</tr>
							<tr>
								<td>가구원 수</td>
								<td>
									<select name="familynum">
										<option value="0" <c:if test="${user.familynum eq 0}">selected</c:if>>선택</option>
										<option value="1" <c:if test="${user.familynum eq 1}">selected</c:if>>1</option>
										<option value="2" <c:if test="${user.familynum eq 2}">selected</c:if>>2</option>
										<option value="3" <c:if test="${user.familynum eq 3}">selected</c:if>>3</option>
										<option value="4" <c:if test="${user.familynum eq 4}">selected</c:if>>4</option>
										<option value="5" <c:if test="${user.familynum eq 5}">selected</c:if>>5</option>
										<option value="6" <c:if test="${user.familynum eq 6}">selected</c:if>>6+</option>
									</select>
								</td>
							</tr>
							<tr>
								<td>마케팅 수신동의</td>
								<td>
									<input type="radio" name="marketing" value="on" <c:if test="${user.marketing eq 'on'}">checked</c:if>>&nbsp;수신 동의
									<input type="radio" name="marketing" value="null" <c:if test="${user.marketing ne 'on'}">checked</c:if>>&nbsp;수신 동의하지 않음
								</td>
							</tr>
						</table>
						<div class="titleLine"></div>
						<div class="mypageBtns">
							<button type="submit">수정</button>&nbsp;
							<button type="reset">취소</button>
						</div>
					</form>
				</section>
			</div>
		</main>
		
		<jsp:include page="footer.jsp" />
	</div>
</body>
<script type="text/javascript" src="mypageScript.js?ver=2"></script>
</html>