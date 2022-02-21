//var removeBtn = document.getElementById("removeBtn");
//var qnaFile = document.getElementById("qnaFile");
//var qnaRealFile = document.getElementById("qnaRealFile"); // hidden input으로 만들기
//var fileTd = document.getElementById("fileTd");
//	
//removeBtn.addEventListener("click", function() {
//	if(confirm("첨부파일을 삭제하시겠습니까?") == true) {
//		fileTd.innerHTML = "<input type='file' name='qnaFile'>";
//	} else {
//		return false;
//	}
//});

function idCheck(num) {
	var sessionId = document.querySelector("input[name='sessionId']");
	var qnaId = document.querySelector("input[name='qnaId']");
	
	if(sessionId == qnaId) {
		if(num == 0) { // edit으로 이동
			location.href = 'qnaEditForm.qna?qnaNo=${qna.qnaNo}&page=${page}';
		} else { // delete로 이동
			location.href = 'qnaDeleteForm.qna?qnaNo=${qna.qnaNo}&page=${page}';
		}
	}
}
