<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.security.SecureRandom" %>
<%@ page import="java.math.BigInteger" %>

<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css" href="headerFooter.css">
	<link rel="stylesheet" type="text/css" href="loginStyle.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
	<script type="text/javascript" src="menuslide.js"></script>
	<title>헤이키친 로그인</title>
</head>
<body>
	<%
		// 네이버 소셜 로그인
		String clientId = "ZKuwqzVwlCAldtVAiRPW"; //애플리케이션 클라이언트 아이디값
	    String redirectURI = URLEncoder.encode("http://localhost:8080/portfolio/socialLogin.jsp", "UTF-8");
	    SecureRandom random = new SecureRandom();
	    String state = new BigInteger(130, random).toString();
	    String apiURL = "https://nid.naver.com/oauth2.0/authorize?response_type=code";
	    apiURL += "&client_id=" + clientId;
	    apiURL += "&redirect_uri=" + redirectURI;
	    apiURL += "&state=" + state;
	    session.setAttribute("state", state);
	%>
	
	<div>
		<jsp:include page="header.jsp" />

		<main>
			<div class="loginbox">
				<p>로그인</p>
				<form name="loginForm" action="loginSelect.jsp" method="post" onsubmit="return loginCheck();">
					<input type="hidden" name="purpose" value="login">
					<input class="loginTxt" type="text" name="id" size="40" placeholder="아이디 입력">
					<input class="loginTxt" type="password" name="pw" size="40" placeholder="비밀번호 입력">
					<button type="submit">로그인</button>
				</form>
				<ul class="findIdPw">
					<li><a href="#">아이디 찾기</a>&nbsp;&nbsp;|</li>
					<li>&nbsp;<a href="#">비밀번호 찾기</a>&nbsp;&nbsp;|</li>
					<li>&nbsp;<a href="signup.jsp">회원가입</a></li>
				</ul>

				<div class="snsLogin">
					<p>SNS 계정으로 로그인하기</p>
					<a href="<%=apiURL%>"><img src="image/navericon.png" width="48px" height="48px" /></a>
					<a href="javascript:loginWithKakao()"><img src="image/kakaoicon.png" width="48px" height="48px" /></a>
					<img src="image/googleicon.png" width="48px" height="48px" />
				</div>
			</div>
		</main>

		<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
		<script type="text/javascript" src="loginScript.js"></script>

		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>