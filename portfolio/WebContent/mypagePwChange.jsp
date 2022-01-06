<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
						<li><a href="mypage.jsp">회원정보 관리</a></li>
						<li class="currentLi"><a href="mypagePwChange.jsp">비밀번호 변경</a></li>
						<li><a href="#">적립금 조회</a></li>
						<li><a href="#">밀플랜 구독관리</a></li>
						<li><a href="#">1:1 문의내역</a></li>
						<li><a href="mypageQuit.jsp">회원 탈퇴</a></li>
					</ul>
				</nav>
				<section>
					<div class="title">비밀번호 변경</div>
					<div class="titleLine"></div>
					<form>
						<table class="pwTable">
							<tr>
								<td>현재 비밀번호</td>
								<td><input type="password" name="pw"></td>
							</tr>
							<tr>
								<td>새 비밀번호</td>
								<td><input type="password" name="newPw"></td>
							</tr>
							<tr>
								<td>새 비밀번호 확인&nbsp;</td>
								<td><input type="password" name="newPw2"></td>
							</tr>
						</table>
						<div class="titleLine"></div>
						<div class="mypageBtns">
							<button type="submit">확인</button>&nbsp;
							<button type="reset">취소</button>
						</div>
					</form>
				</section>
			</div>
		</main>
		
		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>