<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.security.SecureRandom" %>
<%@ page import="java.math.BigInteger" %>

<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<meta name ="google-signin-client_id" content="1025170897501-7oju1jf9shohj3bshq686ag1b9l03j3s.apps.googleusercontent.com">
	
	<link rel="stylesheet" type="text/css" href="headerFooter.css">
	<link rel="stylesheet" type="text/css" href="loginStyle.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
	<script type="text/javascript" src="menuslide.js"></script>
	<title>헤이키친 로그인</title>
</head>
<body>
	
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
					<div id="naver_id_login" style="display: none;"></div>
					<a id="nLogin" href="javascript:clickNaverLogin()"><img src="image/navericon.png" width="48px" height="48px" /></a>
					<a href="javascript:kakaoLogin()"><img src="image/kakaoicon.png" width="48px" height="48px" /></a>
					<a id="gLogin" href="javascript:void(0)"><img src="image/googleicon.png" width="48px" height="48px" /></a>
				</div>
			</div>
		</main>

		<script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js" charset="utf-8"></script>
		<script type="text/javascript">
			function clickNaverLogin() {
				var naverLoginDiv = document.getElementById("naver_id_login").firstChild;
				naverLoginDiv.click();
			}
		
			// 네이버 로그인 
		  	var naver_id_login = new naver_id_login("naverapikey", "http://localhost:8080/portfolio/loginNaver.jsp");
		  	var state = naver_id_login.getUniqState();
		  	naver_id_login.setDomain("http://localhost:8080");
		  	naver_id_login.setState(state);
		  	naver_id_login.setPopup(false);
		  	naver_id_login.init_naver_id_login();
		</script>

		<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
		<script type="text/javascript" src="loginScript.js"></script>
		
		<script src="https://apis.google.com/js/platform.js?onload=init" async defer></script>
		<script>
		// 구글 로그인
		function init() { // 구글 자바스크립트 API 초기화 + 클릭 이벤트 핸들러 실행
			gapi.load('auth2', function() {
				gapi.auth2.init();
				options = new gapi.auth2.SigninOptionsBuilder();
				options.setPrompt('select_account');
		        // 추가는 Oauth 승인 권한 추가 후 띄어쓰기 기준으로 추가
				options.setScope('email profile openid https://www.googleapis.com/auth/user.birthday.read');
		        // clickHandler를 적용할 요소의 ID, 위에 설정한 options와 아래 성공,실패시 실행하는 함수들
				gapi.auth2.getAuthInstance().attachClickHandler('gLogin', options, onSignIn, onSignInFailure);
			})
		}

		function onSignIn(googleUser) {
			var access_token = googleUser.getAuthResponse().access_token
			$.ajax({
		    	// people api를 이용하여 프로필 및 생년월일에 대한 선택동의후 가져온다
				url: 'https://people.googleapis.com/v1/people/me'
		        // key : 자신의 API 키
				, data: {personFields:'birthdays', key:'googleapikey', 'access_token': access_token}
				, method:'GET'
			})
			.done(function(e){
		        //프로필을 가져온다.
				var profile = googleUser.getBasicProfile();
				location.href="loginKakaoGoogle.jsp?socialId=" + profile.SW;
			})
			.fail(function(error){
				console.log(error);
			})
		}
		function onSignInFailure(error){		
			console.log(error);
		}
		</script>

		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>