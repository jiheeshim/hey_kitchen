function askLogout() {
	if(confirm("로그아웃 하시겠습니까?") == true) {
		location.href = "logout.jsp";
	} else {
		return false;
	}
}