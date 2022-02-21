var loginTxt = document.querySelectorAll(".loginTxt");

function loginCheck() {
	// 아이디와 비밀번호 모두 입력했는지
	for(var i = 0; i < loginTxt.length; i++) {
		if(loginTxt[i].value == "") {
			alert("아이디와 비밀번호를 모두 입력해주세요.");
			loginTxt[i].focus();
			return false;
		}
	}
}

// 카카오 소셜 로그인
Kakao.init('9dba1125139c9fc4d8f64e57190988a7'); // 발급받은 키 중 javascript키

function loginWithKakao() {
    Kakao.Auth.authorize({
      redirectUri: 'http://localhost:3306/portfolio/index.jsp'
    })
  }
