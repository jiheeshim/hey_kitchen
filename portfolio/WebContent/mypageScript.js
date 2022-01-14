function mypageUpdateCheck() {
	var textInfo = document.querySelectorAll("td > input[type='text']");
	var birthmonth = document.querySelector("select[name='birthmonth']");
	var birthdate = document.querySelector("select[name='birthdate']");
	
	// 이름, 이메일, 휴대번호 입력 필수 + 공백 불가능
	for(var i = 0; i < 3; i++) {
		if(textInfo[i].value == "" || textInfo[i].value.includes(" ")) {
			alert("이름, 이메일, 휴대번호는 필수 입력사항입니다.");
			textInfo[i].focus();
			return false;
		}
	}
	
	// 이메일 주소 제대로 입력되었는지 확인
	if(!(textInfo[1].value.includes("@") && textInfo[1].value.includes("."))) {
		alert("이메일 주소를 확인해주세요.");
		textInfo[1].focus();
		return false;
	}
	
	// 생년월일은 모두 넣거나 모두 안 넣거나
	else if(!(textInfo[3].value == '' && birthmonth.value == '0' && birthdate.value == '0') && !(textInfo[3].value != '' && birthmonth.value != '0' && birthdate.value != '0')) {
		alert("생년월일이 올바르지 않습니다.");
		if(textInfo[3].value == '')
			textInfo[3].focus();
		else if(birthmonth.value == '0')
			birthmonth.focus();
		else
			birthdate.focus();
		return false;
	}
	
	// 생일연도에 잘못된 값이 입력된 경우 알림창
	else if(textInfo[3].value.includes(' ') || (textInfo[3].value != '') && (textInfo[3].value < (new Date().getFullYear() - 140) || textInfo[3].value > (new Date().getFullYear()))) {
		alert("생년월일이 올바르지 않습니다.");
		textInfo[3].focus();
		return false;
	} else
		return true;
}

function pwCheck() {
	// newPw newPw2 일치 확인
	var passwords = document.querySelectorAll("input[type='password']");
	
	for(var i = 0; i < passwords.length; i++) {
		if(passwords[i].value == "") {
			alert("비밀번호를 입력해주세요.");
			passwords[i].focus();
			return false;
		}
	}
	if(passwords[1].value != passwords[2].value) {
		alert("확인을 위해 동일한 비밀번호를 입력해주세요.");
		passwords[1].focus();
		return false;
	} else
		return true;
}