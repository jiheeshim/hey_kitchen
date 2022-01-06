var textInfo = document.querySelectorAll("td > input[type='text']");
var birthmonth = document.querySelector("select[name='birthmonth']");
var birthdate = document.querySelector("select[name='birthdate']");

function mypageUpdateCheck() {
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