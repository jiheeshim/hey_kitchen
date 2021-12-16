
// function birthday(year, month, date) { // 생년월일 모두 입력되어 있어야 생년월일 value 리턴
// 	if((year == '') || (month == '') || (date == '')) {
// 		return "";
// 	} else {
// 		return year + "년 " + month + "월 " + date + "일";
// 	}
// }

var must_info = document.querySelectorAll(".label_must + td input"); // 필수항목 불러오기
var chkbox = document.querySelectorAll("input[type='checkbox']"); // 약관 체크박스 불러오기
var emailfront = document.querySelector("input[name='emailfront']"); // 이메일 아이디 불러오기
var emailback = document.querySelector(".emailstyle"); // 이메일 뒷주소 불러오기
var birthyear = document.querySelector("input[name='birthyear']"); // 생일연도 불러오기
var birthmonth = document.querySelector("select[name='birthmonth']"); // 생일월 불러오기
var birthdate = document.querySelector("select[name='birthdate']"); // 생일날짜 불러오기
function signup() {
	// 필수항목 공백없이 입력
	for(var i = 0; i < must_info.length; i++) {
		if(must_info[i].value == '' || must_info[i].value.includes(' ')) {
			alert("필수항목은 공백 없이 입력해주세요.");
			must_info[i].focus();
			return false;
		}
	}
	// 아이디, 비밀번호 6~20자리
	for(var i = 0; i < 2; i++) {
		if(must_info[i].value.length < 6) {
			alert("아이디와 비밀번호는 6~20자리만 입력 가능합니다.");
			must_info[i].focus();
			return false;
		}
	}
	// 비밀번호 & 비밀번호 확인
	if(must_info[1].value != must_info[2].value) {
		alert("비밀번호 확인을 위해 동일한 비밀번호를 입력해주세요.");
		must_info[2].focus();
		return false;
	}
	// 이메일 주소 선택 - 뒷주소 선택 필수
	else if(emailback.value == "none") {
		alert("이메일 주소를 선택해주세요.");
		emailback.focus();
		return false;
	}
	// 이메일 직접 입력 시 @ 와 . 이 들어간 이메일 주소가 입력되었는지 확인
	else if((emailback.value == "") && (!(emailfront.value.includes("@")) || !(emailfront.value.includes(".")))) {
		alert("이메일 주소를 바르게 입력해주세요.");
		emailfront.focus();
		return false;
	}
	// 생년월일이 부분적으로만 비어있으면 알림창 띄우기
	else if(!(birthyear.value == '' && birthmonth.value == '0' && birthdate.value == '0') && !(birthyear.value != '' && birthmonth.value != '0' && birthdate.value != '0')) {
		alert("생년월일이 올바르지 않습니다.");
		if(birthyear.value == '')
			birthyear.focus();
		else if(birthmonth.value == '')
			birthmonth.focus();
		else
			birthdate.focus();
		return false;
	}
	else if(birthyear.value.includes(' ')) {
		alert("생년월일이 올바르지 않습니다.");
		birthyear.focus();
		return false;
	}
	// 이용약관 동의
	else if(!chkbox[1].checked || !chkbox[2].checked) {
		alert("필수 약관에 동의하셔야 가입이 가능합니다.");
		return false;
	}
	// 모두 통과
	else {
		return true;
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