
// info 아이콘 안내창 띄우기
var helpIcon = document.getElementById("helpIcon");
var subTitle = document.querySelector(".subTitle");
helpIcon.addEventListener("mouseover", function() {
	subTitle.style.display = "inline-block";
});
helpIcon.addEventListener("mouseout", function() {
	subTitle.style.display = "none";
});


// 삭제 버튼 기능
var ul = document.querySelector(".ingrBox > ul");
function removeIngr(btn) {
	ul.removeChild(btn.parentNode);
}

// 추가 버튼 기능
function addIngr(btn) {
	var li = document.createElement("li"); // 추가할 버튼 노드 생성
	li.innerHTML = '<div class="plusdiv"><button type="button" name="plus" onclick="addIngr(this)">+</button></div>&nbsp;'
		+ '<input type="checkbox" name="checked" value="">&nbsp;&nbsp;'
		+ '<input type="text" name="ingr" value="" size="30" placeholder="재료를 입력하세요.">&nbsp;'
		+ '<button type="button" name="x" onclick="removeIngr(this)">x</button>';
	
	if(btn != 0) { // 재료 목록 밖의 추가 버튼의 경우 btn = 0
		var nextLi = btn.parentNode.parentNode.nextSibling; // 현재 버튼의 sibling 찾기 
	}
	
	if(nextLi != null) { // 다음 sibling이 있는 경우
		ul.insertBefore(li, nextLi);
	} else { // 다음 sibling이 없는 경우
		ul.appendChild(li);
	}
}

// submit 시, 체크박스의 value를 text의 값으로 바꿔주기
function changeValue() {
	var checkbox = document.querySelectorAll("input[name='checked']");
	var text = document.querySelectorAll("input[name='ingr']");
	
	for(var i = 0; i < checkbox.length; i++) {
		checkbox[i].value = text[i].value;
	}
	return true;
}

