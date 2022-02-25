<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
if(session.getAttribute("id") == null) {
	response.sendRedirect("login.jsp");
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="headerFooter.css">
<link rel="stylesheet" type="text/css" href="mypageStyle.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript" src="menuslide.js"></script>
<title>마이페이지 회원 탈퇴</title>
</head>
<body>
	<div>
		<jsp:include page="header.jsp" />
		
		<main>
			<div class="mainWrapper">
				<nav class="mypageNav">
					<ul>
						<li><a href="mypage.jsp">회원정보 관리</a></li>
						<li><a href="mypagePwChange.jsp">비밀번호 변경</a></li>
						<li><a href="mealplanManage.sub">밀플랜 구독관리</a></li>
						<li><a href="qnaList.qna">1:1 문의하기</a></li>
						<li class="currentLi"><a href="mypageQuit.jsp">회원 탈퇴</a></li>
					</ul>
				</nav>
				<section class="pwCheck">
					
				</section>
			</div>
		</main>
		
		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>