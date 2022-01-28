var right1 = document.getElementById("right1");

function askLogin(option) {
	if(right1.innerText.includes("로그아웃")) {
		if(option == 1) {
			location.href="header.kitchen?where=mealplanOrder";
		} else if(option == 2) {
			location.href="mealplanManage.sub";
		}
	} else {
		if(confirm("로그인이 필요한 서비스입니다. 로그인하시겠습니까?") == true)
			location.href="login.jsp";
		else
			return false;
	}
}