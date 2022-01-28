var startDate = document.querySelector("input[name='startDate']");
var endDate = document.querySelector("input[name='endDate']");
var dates = document.querySelectorAll("#subDateForm input[type='hidden']");

function setDates(btn) {

	switch(btn.id) {
	case "today":
		startDate.value = dates[0].value;
		endDate.value = dates[0].value;
		break;
	case "month1":
		startDate.value = dates[1].value;
		endDate.value = dates[0].value;
		break;
	case "month3":
		startDate.value = dates[2].value;
		endDate.value = dates[0].value;
		break;
	case "month6":
		startDate.value = dates[3].value;
		endDate.value = dates[0].value;
		break;
	default:
		console.log("btn id error");
	}
}

function checkDates() {
	if(startDate.value > endDate.value) {
		alert("기간의 시작날짜와 종료날짜 설정을 바르게 해주세요.");
		return false;
	} else {
		return true;
	}
}