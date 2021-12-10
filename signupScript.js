function pointByRef(refcode) { // refcode가 있으면 적립금 5000원
	if(refcode == '') {
		return "";
	} else {
		return "5000원";
	}
}
function birthday(year, month, date) { // 생년월일 모두 입력되어 있어야 생년월일 value 리턴
	if((year == '') || (month == '') || (date == '')) {
		return "";
	} else {
		return year + "년 " + month + "월 " + date + "일";
	}
}

var must_info = document.querySelectorAll(".label_must + td input"); // 필수항목 불러오기
var chkbox = document.querySelectorAll("input[type='checkbox']"); // 약관 체크박스 불러오기
function signup(form) {
	// 필수항목 공백없이 입력
	for(var i = 0; i < must_info.length; i++) {
		if(must_info[i].value == '' || must_info[i].value.includes(' ')) {
			alert("필수항목은 공백 없이 입력해주세요.");
			must_info[i].focus();
			return;
		}
	}
	// 아이디, 비밀번호 6~20자리
	for(var i = 0; i < 2; i++) {
		if(must_info[i].value.length < 6) {
			alert("아이디와 비밀번호는 6~20자리만 입력 가능합니다.");
			must_info[i].focus();
			return;
		}
	}
	// 비밀번호 & 비밀번호 확인
	if(must_info[1].value != must_info[2].value) {
		alert("비밀번호 확인을 위해 동일한 비밀번호를 입력해주세요.");
		must_info[2].focus();
	}
	// 이메일 주소 선택
	else if(form.emailback.value == "") {
		alert("이메일 주소를 선택해주세요.");
		form.emailback.focus();
	}
	// 이용약관 동의
	else if(!chkbox[1].checked || !chkbox[2].checked) {
		alert("필수 약관에 동의하셔야 가입이 가능합니다.");
	}
	else {
		alert("회원가입이 완료되었습니다."
			+ "\n아이디 : " + must_info[0].value
			+ "\n비밀번호 : " + must_info[1].value
			+ "\n이름 : " + must_info[3].value
			+ "\n이메일 : " + must_info[4].value + form.emailback.value
			+ "\n휴대번호 : " + must_info[5].value
			+ "\n성별 : " + form.gender.value
			+ "\n생년월일 : " + birthday(form.birthyear.value, form.birthmonth.value, form.birthdate.value)
			+ "\n우편번호 : " + form.postcode.value
			+ "\n주소 : " + form.addr1.value + " " + form.addr2.value
			+ "\n가구원 수 : " + form.familynum.value
			+ "\n적립금 : " + pointByRef(form.refcode.value));
		}
}
function checkAll() { // 전체동의 체크박스 관련 제어
	if(chkbox[0].checked) {
		for(var i = 1; i < chkbox.length; i++) {
			chkbox[i].checked = true;
		}
	}
}
function checkTerms() { // 개별약관 체크박스 관련 제어
	var chked = true;
	for(var i = 1; i < chkbox.length; i++) {
		if(!chkbox[i].checked) {
			chkbox[0].checked = false;
			chked = false;
			break;
		}
	}
	if(chked) {
		chkbox[0].checked = true;
	}
}