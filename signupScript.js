
var must_info = document.querySelectorAll(".label_must + td input"); // 필수항목
var idResult = document.getElementById("idResult"); // 아이디 중복확인 결과 출력 칸
var chkbox = document.querySelectorAll("input[type='checkbox']"); // 약관 체크박스
var emailfront = document.querySelector("input[name='emailfront']"); // 이메일 아이디
var emailback = document.querySelector(".emailstyle"); // 이메일 뒷주소
var birthyear = document.querySelector("input[name='birthyear']"); // 생일연도
var birthmonth = document.querySelector("select[name='birthmonth']"); // 생일월
var birthdate = document.querySelector("select[name='birthdate']"); // 생일날짜
var joincode = document.querySelector("input[name='joincode']"); // 추천인코드 텍스트칸
var refResult = document.getElementById("refResult"); // 추천인코드 확인 결과 출력 칸
function signupCheck() {
	// 아이디 중복확인
	if(!(idResult.innerText.includes("사용"))) { //'<br>사용가능한 아이디입니다'
		alert(nowyear);
		alert("아이디 중복확인을 해주세요.");
		must_info[0].focus();
		return false;
	}
	// 필수항목 공백없이 입력
	for(var i = 0; i < must_info.length; i++) {
		if(must_info[i].value == "" || must_info[i].value.includes(" ")) {
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
	// 이메일 "직접 입력" 선택한 경우, @ 와 . 이 들어간 이메일 주소가 입력되었는지 확인
	else if((emailback.value == "") && (!(emailfront.value.includes("@")) || !(emailfront.value.includes(".")))) {
		alert("이메일 주소를 바르게 입력해주세요.");
		emailfront.focus();
		return false;
	}
	// 이메일 뒷주소를 선택한 경우, 앞에 @ 와 . 이 들어갔는지 확인
	else if((emailback.value != "") && ((emailfront.value.includes("@")) || (emailfront.value.includes(".")))) {
		alert("이메일 주소를 바르게 선택해주세요.");
		emailback.focus();
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
	// 생일연도에 잘못된 값이 입력된 경우 알림창
	else if(birthyear.value.includes(' ') || (birthyear.value != '') && (birthyear.value < (new Date().getFullYear() - 140) || birthyear.value > (new Date().getFullYear()))) {
		alert("생년월일이 올바르지 않습니다.");
		birthyear.focus();
		return false;
	}
	// 추천인 코드 확인이 false 상황인 경우(즉, 확인되지 않은 코드인 경우 or 추천인코드가 써져있는데 확인을 안 한 경우)
	else if(refResult.innerText.includes("않은") || (joincode.value != "") && (refResult.innerText == "")) {
		alert("추천인 코드를 확인해주세요.");
		joincode.focus();
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

// 전체동의 체크박스 관련 제어
function checkAll() { 
	if(chkbox[0].checked) {
		for(var i = 1; i < chkbox.length; i++) {
			chkbox[i].checked = true;
		}
	}
}
// 개별약관 체크박스 관련 제어
function checkTerms() { 
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

// 아이디 중복확인 결과에 따른 안내글 ajax로 가져오기
$(function () {
	$("#idcheck").click(function() { // 중복확인 버튼 클릭 시 아래 함수 실행
		idCheck(must_info[0]);
	});

	function idCheck(id) {
		if(id.value == "") { // 아이디 칸에 텍스트가 입력되어 있는지 확인
			alert("아이디를 먼저 입력해주세요.");
			id.focus();
		} else if(id.value.includes(" ") || id.value.length < 6) { // 아이디 제약 조건 확인
			alert("아이디는 공백 없이 6 ~ 20자리만 가능합니다.");
			id.focus();
		} else { // 아이디가 잘 입력되어 있으면 idCheck.jsp에서 결과값 반환
			$.ajax({
				url: "signupIdCheck.jsp?id=" + id.value,
				type: "post",
				dataType: "html",
				success: function(result) {
					if(result == 0) { // 중복되는 경우(false = 0) 아이디칸 아래에 안내글
						$("#idResult").html("<br>이미 중복되는 아이디가 존재합니다.");
						$("#idResult_blank").html("<br>&nbsp;"); // 줄맞추기용
						id.focus(); // 아이디 칸에 focus
					} else { // 중복되지 않는 경우 안내글
						$("#idResult").html("<br>사용 가능한 아이디입니다.");
						$("#idResult_blank").html("<br>&nbsp;");
						must_info[1].focus(); // 비밀번호 칸에 focus
					}
				},
				error: function(result) {
					alert("error");
				}
			});
		}
	}
});

// 아이디 텍스트칸에 입력값이 바뀔 때는 idResult 칸들이 항상 비어있도록
function idResultTxt() {
	if(idResult.innerText != "") { // 바뀔때마다 innerHTML을 새로 설정하면 비효율적이니까, 이미 무언가 있을 경우에만 innerHTML 비워내도록
		var idResult_blank = document.getElementById("idResult_blank");
		idResult.innerHTML = "";
		idResult_blank.innerHTML = "";
	}
}

// 추천인코드 확인 결과에 따른 안내글 ajax로 가져오기
$(function() {
	$("#refcheck").click(function() {
		refCheck(joincode);
	});

	function refCheck(joincode) {
		if(joincode.value == "") { // joincode가 비어 있는 경우 알림창
			alert("추천인 코드를 먼저 입력해주세요.");
			joincode.focus();
		} else { // joincode가 입력되어 있는 경우, refCheck.jsp의 out.println() 부분 가져와서 안내글 출력
			$.ajax({
				url: "signupRefCheck.jsp?joincode=" + joincode.value,
				type: "post",
				dataType: "html",
				success: function(result) {
					if(result == 1) { // 추천인 코드 확인되면 readonly로 수정 불가능하게끔
						$("#refResult").html("<br>추천인 코드가 확인되었습니다.");
						$("#refResult_blank").html("<br>&nbsp;");
						$(joincode).attr("readonly", true);	
						$(joincode).css("background-color", "#ebe8e8");
					} else {
					 	$("#refResult").html("<br>확인되지 않은 코드입니다.");
					 	$("#refResult_blank").html("<br>&nbsp;");
					 	$(joincode).focus();
					}
				},
				error: function(result) {
					alert("error");
				}
			});
		}
	}
});

// 추천인코드 텍스트칸이 빈칸이 되면, 아래 안내글도 사라지도록
// (추천인코드 사용 가능하다고 확인된 경우, readonly로 바뀌기 때문에, 빈칸 이외에는 '확인되지 않은 코드입니다' 안내글이 계속 떠 있어도 괜찮음)
function refResultTxt(joincode) {
	if(joincode.value == "") {
		var refResult_blank = document.getElementById("refResult_blank");
		refResult.innerHTML = "";
		refResult_blank.innerHTML = "";
	}
}


