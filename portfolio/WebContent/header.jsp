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
						<li><a href="mapSearch.jsp">오프라인 매장 찾기</a></li>
						<li><a href="noticeListSelect.jsp">이벤트/공지사항</a></li>
						<li><a href="qnaList.qna">문의사항</a></li>
					</div>
				</ul>
			</li>
			<li class="level1">
				<a href="#">밀플랜 정기구독</a>
				<ul class="level2">
					<div class="level2_wrapper">
						<li><a href="javascript:askLogin(1);">구독하기</a></li>
						<li><a href="#">밀플랜 레시피</a></li>
						<li><a href="javascript:askLogin(2);">밀플랜 구독 관리</a></li>
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
								<li><a href="recipeList.rec?group=삼시네끼&categ=아침">아침</a></li>
								<li>|</li>
								<li><a href="recipeList.rec?group=삼시네끼&categ=점심">점심</a></li>
								<li>|</li>
								<li><a href="recipeList.rec?group=삼시네끼&categ=저녁">저녁</a></li>
								<li>|</li>
								<li><a href="recipeList.rec?group=삼시네끼&categ=간식">간식</a></li>
							</ul>
						</li>
						<li>
							<a href="#">디쉬</a>
							<ul class="level3">
								<li>></li>
								<li><a href="recipeList.rec?group=디쉬&categ=애피타이저">애피타이저</a></li>
								<li>|</li>
								<li><a href="recipeList.rec?group=디쉬&categ=메인">메인</a></li>
								<li>|</li>
								<li><a href="recipeList.rec?group=디쉬&categ=반찬">반찬</a></li>
								<li>|</li>
								<li><a href="recipeList.rec?group=디쉬&categ=후식">후식</a></li>
							</ul>
						</li>
						<li>
							<a href="#">전세계</a>
							<ul class="level3">
								<li>></li>
								<li><a href="recipeList.rec?group=전세계&categ=한식">한식</a></li>
								<li>|</li>
								<li><a href="recipeList.rec?group=전세계&categ=양식">양식</a></li>
								<li>|</li>
								<li><a href="recipeList.rec?group=전세계&categ=중식">중식</a></li>
								<li>|</li>
								<li><a href="recipeList.rec?group=전세계&categ=일식">일식</a></li>
								<li>|</li>
								<li><a href="recipeList.rec?group=전세계&categ=퓨전">퓨전</a></li>
								<li>|</li>
								<li><a href="recipeList.rec?group=전세계&categ=동남아">동남아</a></li>
							</ul>
						</li>
						<li>
							<a href="#">메인 재료</a>
							<ul class="level3">
								<li>></li>
								<li><a href="recipeList.rec?group=메인재료&categ=밥">밥</a></li>
								<li>|</li>
								<li><a href="recipeList.rec?group=메인재료&categ=육류">육류</a></li>
								<li>|</li>
								<li><a href="recipeList.rec?group=메인재료&categ=해산물">해산물</a></li>
								<li>|</li>
								<li><a href="recipeList.rec?group=메인재료&categ=채소">채소</a></li>
								<li>|</li>
								<li><a href="recipeList.rec?group=메인재료&categ=면요리">면요리</a></li>
								<li>|</li>
								<li><a href="recipeList.rec?group=메인재료&categ=비건">비건</a></li>
							</ul>
						</li>
						<li>
							<a href="#">특별한 날</a>
							<ul class="level3">
								<li>></li>
								<li><a href="recipeList.rec?group=특별한날&categ=단체식사">단체 식사</a></li>
								<li>|</li>
								<li><a href="recipeList.rec?group=특별한날&categ=명절">명절</a></li>
								<li>|</li>
								<li><a href="recipeList.rec?group=특별한날&categ=크리스마스">크리스마스</a></li>
							</ul>
						</li>
						<li>
							<a href="#">베이킹</a>
							<ul class="level3">
								<li>></li>
								<li><a href="recipeList.rec?group=베이킹&categ=쿠키">쿠키</a></li>
								<li>|</li>
								<li><a href="recipeList.rec?group=베이킹&categ=케이크">케이크</a></li>
								<li>|</li>
								<li><a href="recipeList.rec?group=베이킹&categ=타르트">타르트</a></li>
								<li>|</li>
								<li><a href="recipeList.rec?group=베이킹&categ=빵">빵</a></li>
								<li>|</li>
								<li><a href="recipeList.rec?group=베이킹&categ=기타">기타</a></li>
							</ul>
						</li>
						<li>
							<a href="#">음료</a>
							<ul class="level3">
								<li>></li>
								<li><a href="recipeList.rec?group=음료&categ=스무디">스무디</a></li>
								<li>|</li>
								<li><a href="recipeList.rec?group=음료&categ=칵테일">칵테일</a></li>
								<li>|</li>
								<li><a href="recipeList.rec?group=음료&categ=기타">기타</a></li>
							</ul>
						</li>
					</div>
				</ul>
			</li>
			<li class="level1">
				<a href="#">마이 키친</a>
				<ul class="level2">
					<div class="level2_wrapper">
						<li><a href="recipeScrapView.rec">레시피 스크랩 갤러리</a></li>
						<li><a href="recipeMyFeedView.rec">나의 레시피 피드</a></li>
						<li><a href="ingrScrapView.rec">나의 장보기 목록</a></li>
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

