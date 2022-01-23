var removeBtn = document.getElementById("removeBtn");
var qnaFile = document.getElementById("qnaFile");
var qnaRealFile = document.getElementById("qnaRealFile"); // hidden input으로 만들기
var fileTd = document.getElementById("fileTd");
	
removeBtn.addEventListener("click", function() {
	if(confirm("첨부파일을 삭제하시겠습니까?") == true) {
		fileTd.innerHTML = "<input type='file' name='qnaFile'>";
	} else {
		return false;
	}
});