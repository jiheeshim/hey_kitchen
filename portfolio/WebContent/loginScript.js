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

//카카오로그인
function kakaoLogin() {
    Kakao.Auth.login({
      success: function (response) {
        Kakao.API.request({
          url: '/v2/user/me',
          success: function (response) {
        	  location.href = "loginKakaoGoogle.jsp?id=" + response.id;
          },
          fail: function (error) {
            console.log(error);
          },
        })
      },
      fail: function (error) {
        console.log(error);
      },
    })
  }
