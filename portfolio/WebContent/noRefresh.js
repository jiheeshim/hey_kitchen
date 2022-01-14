function noRefresh() {
	if (event.keyCode == 116) { // F5 
		alert("새로고침을 할 수 없습니다.");
		event.keyCode= 2;
		return false;
	} else if(event.ctrlKey && (event.keyCode==78 || event.keyCode == 82)) { // Ctrl + R / Ctrl + N (Mac의 커맨드는 잡히지 않는다는 문제..)
	  return false; 
	}
}

document.onkeydown = noRefresh;