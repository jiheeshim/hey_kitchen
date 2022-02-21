
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
var imgTd = document.getElementById("imgTd"); // 레시피 작성 테이블의 td
var imgAddBtn = document.getElementById("imgAddBtn"); // 추가 버튼(처음부터 문서에 만들어져 있는)
var removeBtn = document.getElementsByName("removeBtn"); // 삭제 버튼

imgAddBtn.addEventListener("click", function() { // 추가 버튼 클릭 이벤트
	if(removeBtn.length < 4) { 
		var imgDiv = document.createElement("div"); // 레시피 단계 form 요소가 담길 div 태그
		var index = removeBtn.length + 1; // 첨부파일명 구별용 숫자
		imgDiv.innerHTML = '<button type="button" name="removeBtn" onclick="remove(this)">-해당단계 삭제</button>'
				+ '&nbsp;<input type="file" name="imgName' + index + '" accept="image/*" required><br>'
				+ '<textarea name="imgDesc" placeholder="이미지와 관련된 요리 단계를 설명해주세요." required></textarea>';
		imgTd.appendChild(imgDiv); // 생성한 div태그를 td 끝단에 추가
	} else {
		alert("요리 단계는 5개까지 작성 가능합니다.");
	}
});

function remove(btn) { // 삭제버튼에 onclick으로 실행될 함수
	var imgDiv = btn.parentNode; // 해당 버튼의 부모 div태그 찾기
	imgTd.removeChild(imgDiv); // 해당 div태그 삭제
}

// insert 전에, textarea의 줄바꿈 <br>로 변경해서 DB저장
//function saveLines() {
//	var textareas = document.querySelectorAll("textarea");
//	// 동적으로 생기는 textarea 요소들이 있으므로, 함수 실행 시 요소들을 잡도록 만든다
//	for(var i = 0; i < textareas.length; i++) {
//		textareas[i].value = textareas[i].value.replace(/\r\n|\n/, "<br>");
//	}
//	return true;
//}

