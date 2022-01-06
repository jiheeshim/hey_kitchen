<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>헤이키친 회원가입</title>
	<link rel="stylesheet" type="text/css" href="headerFooter.css">
	<link rel="stylesheet" type="text/css" href="signupSuccessStyle.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
	<script type="text/javascript" src="menuslide.js"></script>
</head>
<body>
	<div>
		<jsp:include page="header.jsp" />

		<main>
			<div class="successbox">
				<div class="title">회원가입이 완료되었습니다.</div>
				<p>헤이키친의 회원이 되신 걸 환영합니다!<br>맛있고 건강하고 편리한 끼니를 책임지겠습니다.</p>
				<div>
					<button onclick="location.href='index.jsp'">홈으로</button>
					<button onclick="location.href='login.jsp'">로그인</button>
				</div>
			</div>
		</main>

		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>