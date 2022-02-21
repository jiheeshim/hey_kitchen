// 배송지 주소 radio 버튼 이벤트
	
	
	var user = document.getElementsByName("user"); // user의 주소값들(hidden value)
	var addrText = document.querySelectorAll(".addr input[type='text']"); // 주소 값을 입력할 칸
	var addrRadios = document.getElementsByName("addrRadio"); // 라디오 버튼들
	
	// 라디오 버튼 클릭 시, 각 버튼에 따른 이벤트
	for(var i = 0; i < addrRadios.length; i++) {
		addrRadios[i].addEventListener("click", function() {
			if(this.id == "getAddr") { // 기존 배송지 선택을 누른 경우,
				for(var j = 0; j < user.length; j++) {
					if(user[j] != null) // user의 주소값들이 존재하면,
						addrText[j].value = user[j].value; // 입력
				}
			} else if(this.id == "newAddr") { // 새로운 배송지 선택 누른 경우,
				for(var j = 0; j < user.length; j++) //  주소 값 모두 비우기
					addrText[j].value = "";
			}
		});
	}
	
// select option 값에 따른 가격 표시
	
	var prices = document.getElementsByName("prices"); // DB의 price 값들
	var priceSpan = document.querySelectorAll(".priceSpan"); // 가격이 출력되는 부모 span 태그
	var priceFont = document.querySelectorAll(".priceSpan font:last-of-type"); // 가격 부분 font 태그(span의 자식)
	var servingSpan = document.querySelector(".guideTitle > span"); // '#인 기준'의 # 부분 불러오기
	var serving = document.querySelector("select[name='serving']"); // 인분 select 입력값 불러오기
	var servingCnt = document.querySelector("select[name='servingCnt']"); // 회수 select 입력값 불러오기
	
	// serving select option 변경 시, 가격 곱해주는 이벤트
	serving.addEventListener("change", function() {
		for(var i = 0; i < prices.length; i++) {
			servingSpan.innerText = serving.value;
			priceFont[i].innerText = (parseInt(prices[i].value) * parseInt(serving.value)).toLocaleString();
		}
	});
	
	// servingCnt select option 변경 시, opacity 바뀌는 이벤트
	servingCnt.addEventListener("change", function() {
		switch(this.value) {
		case "3":
			priceSpan[0].style.opacity = 1;
			priceSpan[1].style.opacity = 0.5;
			priceSpan[2].style.opacity = 0.5;
			break;
		case "4":
			priceSpan[0].style.opacity = 0.5;
			priceSpan[1].style.opacity = 1;
			priceSpan[2].style.opacity = 0.5;
			break;
		case "5":
			priceSpan[0].style.opacity = 0.5;
			priceSpan[1].style.opacity = 0.5;
			priceSpan[2].style.opacity = 1;
			break;
		}
	});
	

// 배송지 주소 입력칸 비어있는지 체크	
function emptyCheck() {
	
	for(var i = 0; i < addrText.length; i++) {
		if(i == 2)
			continue;
		if(addrText[i].value == "") {
			alert("정보를 입력해주세요.");
			addrText[i].focus();
			return false;
		}
	}
	return true;
}

