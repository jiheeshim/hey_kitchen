function noticeSearchCheck() {
	var words = document.getElementById("noticeWords");
	if(words.value == "") {
		words.focus();
		return false;
	} else
		return true;
}

function returnToNotice() {
	if(confirm("작성한 내용은 저장되지 않습니다.\n정말 취소하시겠습니까?") == true) {
		location.href = "noticeListSelect.jsp";
	} else {
		return false;
	}
}

function deleteNotice(noticeNo) {
	if(confirm("정말 삭제하시겠습니까?") == true) {
		location.href = "noticeDelete.jsp?noticeNo=" + noticeNo;
	} else {
		return false;
	}
}

// 첨부파일 수정버튼(label) 클릭 -> 
var fileLabel = document.getElementById("fileLabel");
var fileInput = document.getElementById("fileInput");
var file_name = document.getElementById("file_name");
var fileEdit = document.querySelector("input[name='fileEdit']");
var imgLabel = document.getElementById("imgLabel");
var imgInput = document.getElementById("imgInput");
var img_name = document.getElementById("img_name");
var imgEdit = document.querySelector("input[name='imgEdit']");

function showFileInput() { // 첨부파일용 함수
	file_name.style.display = "none";
	fileInput.style.display = "inline";
	fileInput.value = "";
	fileEdit.value = "true";
}

function showImgInput() { // 이미지파일용 함수
	img_name.style.display = "none";
	imgInput.style.display = "inline";
	imgInput.value = "";
	imgEdit.value = "true";
}

function confirmDelete(input) { // 삭제 버튼 클릭 시
	if(input == 0) { // 첨부파일용
		if(confirm("첨부파일을 정말 삭제하시겠습니까?")) {
			showFileInput();
		} else {
			return false;
		}
	} else { // 이미지파일용
		if(confirm("이미지파일을 정말 삭제하시겠습니까?")) {
			showImgInput();
		} else {
			return false;
		}
	}
}


