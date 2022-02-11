
var ingrTd = document.getElementById("ingrTd");
var ingrAddBtn = document.getElementById("ingrAddBtn");
var minusBtn = document.getElementsByName("minusBtn")

// 재료 추가 버튼 누르면, 총 10개까지 재료 입력칸 생성
ingrAddBtn.addEventListener("click", function() {
	if(minusBtn.length < 9) {
		var ingrDiv = document.createElement("div");
		ingrDiv.innerHTML = '<input type="text" name="ingrName" maxlength="10" placeholder="재료명" required>'
				+ '&nbsp;<input type="text" name="ingrAmount" maxlength="10" placeholder="재료양" required>'
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
	if(removeBtn.length < 4) {
		var imgDiv = document.createElement("div");
		var index = removeBtn.length + 1;
		imgDiv.innerHTML = '<button type="button" name="removeBtn" onclick="remove(this)">-해당단계 삭제</button>'
				+ '&nbsp;<input type="file" name="imgName' + index + '" accept="image/*" required><br>'
				+ '<textarea name="imgDesc" placeholder="이미지와 관련된 요리 단계를 설명해주세요." required></textarea>';
		imgTd.appendChild(imgDiv);
	} else {
		alert("요리 단계는 5개까지 작성 가능합니다.");
	}
});

function remove(btn) {
	var imgDiv = btn.parentNode;
	imgTd.removeChild(imgDiv);
}

// insert 전에, textarea의 줄바꿈 <br>로 변경해서 DB저장
function saveLines() {
	var textareas = document.querySelectorAll("textarea");
	// 동적으로 생기는 textarea 요소들이 있으므로, 함수 실행 시 요소들을 잡도록 만든다
	for(var i = 0; i < textareas.length; i++) {
		textareas[i].value = textareas[i].value.replace(/\r\n|\n/, "<br>");
	}
	return true;
}

