<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<header>
	<div class="lang">한국어 | English</div>
	<div class="logo"><a href="index.jsp"><img src="image/logodraft.png" /></a></div>
</header>

<div class="nav_box">
	<nav class="nav_main">
		<ul class="left_ul">
			<li class="level1"> 
				<a href="#">정보 소개</a>
				<ul class="level2">
					<div class="level2_wrapper">
						<li><a href="#">기획 의도</a></li>
						<li><a href="#">웹사이트 소개</a></li>
						<li><a href="noticeListSelect.jsp">이벤트/공지사항</a></li>
						<li><a href="qnaList.qna">문의사항</a></li>
					</div>
				</ul>
			</li>
			<li class="level1">
				<a href="#">밀플랜 정기구독</a>
				<ul class="level2">
					<div class="level2_wrapper">
						<li><a href="javascript:askLogin();">구독하기</a></li>
						<li><a href="#">메뉴 선택</a></li>
						<li><a href="#">밀플랜 레시피</a></li>
						<li><a href="mealplanManage.sub">밀플랜 구독 관리</a></li>
					</div>
				</ul>
			</li>
			<li class="level1">
				<a href="#">레시피 커뮤니티</a>
				<ul class="level2">
					<div class="level2_wrapperL">
						<li>
							<a href="#">삼시네끼</a>
							<ul class="level3">
								<li>></li>
								<li><a href="#">아침</a></li>
								<li>|</li>
								<li><a href="#">점심</a></li>
								<li>|</li>
								<li><a href="#">저녁</a></li>
								<li>|</li>
								<li><a href="#">간식</a></li>
							</ul>
						</li>
						<li>
							<a href="#">디쉬</a>
							<ul class="level3">
								<li>></li>
								<li><a href="#">애피타이저</a></li>
								<li>|</li>
								<li><a href="#">메인</a></li>
								<li>|</li>
								<li><a href="#">반찬</a></li>
								<li>|</li>
								<li><a href="#">후식</a></li>
							</ul>
						</li>
						<li>
							<a href="#">전세계</a>
							<ul class="level3">
								<li>></li>
								<li><a href="#">한식</a></li>
								<li>|</li>
								<li><a href="#">양식</a></li>
								<li>|</li>
								<li><a href="#">중식</a></li>
								<li>|</li>
								<li><a href="#">일식</a></li>
								<li>|</li>
								<li><a href="#">유럽</a></li>
								<li>|</li>
								<li><a href="#">동남아</a></li>
							</ul>
						</li>
						<li>
							<a href="#">다이어트</a>
							<ul class="level3">
								<li>></li>
								<li><a href="#">비건</a></li>
								<li>|</li>
								<li><a href="#">베지테리언</a></li>
								<li>|</li>
								<li><a href="#">로칼로리</a></li>
							</ul>
						</li>
						<li>
							<a href="#">특별한 날</a>
							<ul class="level3">
								<li>></li>
								<li><a href="#">단체 식사</a></li>
								<li>|</li>
								<li><a href="#">명절</a></li>
								<li>|</li>
								<li><a href="#">크리스마스</a></li>
								<li>|</li>
								<li><a href="#">할로윈</a></li>
							</ul>
						</li>
						<li>
							<a href="#">베이킹</a>
							<ul class="level3">
								<li>></li>
								<li><a href="#">쿠키</a></li>
								<li>|</li>
								<li><a href="#">케이크</a></li>
								<li>|</li>
								<li><a href="#">타르트</a></li>
								<li>|</li>
								<li><a href="#">빵</a></li>
								<li>|</li>
								<li><a href="#">디저트</a></li>
							</ul>
						</li>
						<li>
							<a href="#">음료</a>
							<ul class="level3">
								<li>></li>
								<li><a href="#">스무디</a></li>
								<li>|</li>
								<li><a href="#">칵테일</a></li>
								<li>|</li>
								<li><a href="#">기타</a></li>
							</ul>
						</li>
					</div>
				</ul>
			</li>
			<li class="level1">
				<a href="#">마이 키친</a>
				<ul class="level2">
					<div class="level2_wrapper">
						<li><a href="#">레시피 스크랩 갤러리</a></li>
						<li><a href="myRecipes.jsp">나의 레시피 피드</a></li>
						<li><a href="#">나의 재료 쇼핑리스트</a></li>
						<li><a href="#">마이 키친 관리</a></li>
					</div>
				</ul>
			</li>
		</ul>
		<ul class="right_ul">
			<li id="right1"><a href="signup.jsp">회원가입</a></li>
			<li id="right2"><a href="login.jsp">로그인</a></li>
			<li>
				<form id="searchbox">
					<input type="text" id="searchtxt" placeholder="레시피 검색">
					<button type="submit" id="searchbtn"><img src="image/searchicon.png" /></button>
				</form>
			</li>
		</ul>
	</nav>
</div>

<script>
	var right1 = document.getElementById("right1");
	var right2 = document.getElementById("right2");
</script>
<%
String id = (String)session.getAttribute("id");
if(id != null) {
%>
<script>
	right1.innerHTML = "<a href='javascript:askLogout()'>로그아웃</a>";
	right2.innerHTML = "<a href='mypage.jsp'>마이페이지</a>";
</script>
<%
}
%>

<script type="text/javascript" src="logoutScript.js"></script>
<script type="text/javascript" src="headerScript.js"></script>

