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

