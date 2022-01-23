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

// 첨부파일&이미지 파일명 출력하기

var file = document.getElementById("file");
var fileLabel = document.getElementById("fileLabel");
var fileText = document.getElementById("fileText");
file.addEventListener("change", function() {
	if(window.FileReader){
      var fileName = this.files[0].name;
    } else {
      var fileName = (this).value.split("/").pop().split("\\").pop();
    }
	fileText.value = fileName;
});

var image = document.getElementById("image");
var imageLabel = document.getElementById("imageLabel");
var imageText = document.getElementById("imageText");
image.addEventListener("change", function() {
	if(window.FileReader) {
		var fileName = this.files[0].name;
	} else {
		var fileName = (this).value.split("/").pop().split("\\").pop();
	}
	imageText.value = fileName;
});

