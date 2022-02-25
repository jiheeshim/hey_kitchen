
// 적립금 모두 사용 버튼 이벤트
var pointBtn = document.getElementById("pointBtn"); // 모두사용 버튼
var pointUsage = document.querySelector("input[name='pointUsage']"); // 사용할 적립금
var point = document.querySelector("input[name='point']"); // 현재 유저의 총 적립금
pointBtn.addEventListener("click", function() { // 버튼 클릭 이벤트
	pointUsage.value = point.value; // 사용할 적립금 칸에 총 적립금 입력
	calPrice(); // 총 가격 계산
});

// 총 가격 표시
var serving = document.querySelector("input[name='serving']");
var price = document.querySelector("input[name='price']");
var priceSpan = document.getElementById("priceSpan");
priceSpan.innerText = parseInt(price.value) * parseInt(serving.value);

// 적립금 입력 후, 총 가격 표시
pointUsage.addEventListener("focusout", function() {
	// 적립금 금액 유효성 검사
	if(parseInt(pointUsage.value) > parseInt(point.value)) { // 총 적립금보다 큰 금액 입력하면
		alert("적립금 금액을 바르게 입력해주세요.");
		pointUsage.value = 0;
		return false;
	} else { // 올바른 경우 총 금액에 적용
		calPrice(); // 총 가격 계산
	}
});

function calPrice() {
	priceSpan.innerText = parseInt(price.value) * parseInt(serving.value) - parseInt(pointUsage.value);
}

