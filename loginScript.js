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