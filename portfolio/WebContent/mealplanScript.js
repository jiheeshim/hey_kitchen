// 배송지 주소 radio 버튼 이벤트
	
	//user의 주소 값 불러오기
	var user = document.getElementsByName("user");	
	//값 입력할 칸들 불러오기
	var addrText = document.querySelectorAll(".addr input[type='text']");
	//라디오 불러오기
	var addrRadios = document.getElementsByName("addrRadio");
	
	// 라디오 버튼 클릭 시, 각 버튼에 따른 이벤트
	for(var i = 0; i < addrRadios.length; i++) {
		addrRadios[i].addEventListener("click", function() {
			if(this.id == "getAddr") { // 기존 배송지 선택을 누른 경우, 주소 값이 비어있지 않으면 입력되도록
				for(var j = 0; j < user.length; j++) {
					if(user[j] != null)
						addrText[j].value = user[j].value;
				}
			} else if(this.id == "newAddr") { // 새로운 배송지 선택 누른 경우, 주소 값 모두 비우기
				for(var j = 0; j < user.length; j++)
					addrText[j].value = "";
			}
		});
	}
	
// select option 값에 따른 가격 표시
	
	// 실제 price 값들 불러오기
	var prices = document.getElementsByName("prices");
	// priceSpan 칸 불러오기
	var priceSpan = document.querySelectorAll(".priceSpan");
	// 가격이 뜨는 font 칸 불러오기
	var priceFont = document.querySelectorAll(".priceSpan font:last-of-type");
	// guideTitle의 '#인 기준'의 # 칸 불러오기
	var servingSpan = document.querySelector(".guideTitle > span");
	// select input 칸들 불러오기
	var serving = document.querySelector("select[name='serving']");
	var servingCnt = document.querySelector("select[name='servingCnt']");
	
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

