
var ingrTd = document.getElementById("ingrTd");
var ingrAddBtn = document.getElementById("ingrAddBtn");
var minusBtn = document.getElementsByName("minusBtn")

// 재료 추가 버튼 누르면, 총 10개까지 재료 입력칸 생성
ingrAddBtn.addEventListener("click", function() {
	if(minusBtn.length < 9) {
		var ingrDiv = document.createElement("div");
		ingrDiv.innerHTML = '<input type="text" name="ingrName" placeholder="재료명">'
				+ '&nbsp;<input type="text" name="ingrAmount" placeholder="재료양">'
				+ '&nbsp;<button type="button" name="minusBtn" onclick="minus(this)">삭제</button>';
		ingrTd.appendChild(ingrDiv);
	} else {
		alert("재료는 10개까지 작성 가능합니다.");
	}
});

// 재료 삭제 버튼 누르면, 해당 줄의 재료 입력칸 삭제
function minus(btn) {
	var ingrDiv = btn.parentNode;
	ingrTd.removeChild(ingrDiv);
}

// 레시피 단계 추가 & 삭제 버튼 함수
var imgTd = document.getElementById("imgTd");
var imgAddBtn = document.getElementById("imgAddBtn");
var removeBtn = document.getElementsByName("removeBtn");

imgAddBtn.addEventListener("click", function() {
	if(removeBtn.length < 5) {
		var imgDiv = document.createElement("div");
		imgDiv.innerHTML = '<button type="button" name="removeBtn" onclick="remove(this)">-해당단계 삭제</button>'
				+ '&nbsp;<input type="file" name="imgName"><br>'
				+ '<textarea name="imgDesc" placeholder="이미지와 관련된 요리 단계를 설명해주세요."></textarea>';
		imgTd.appendChild(imgDiv);
	} else {
		alert("요리 단계는 5개까지 작성 가능합니다.");
	}
});

function remove(btn) {
	var imgDiv = btn.parentNode;
	imgTd.removeChild(imgDiv);
}


