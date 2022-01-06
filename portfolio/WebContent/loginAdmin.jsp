<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="loginAdminStyle.css">
<title>관리자 로그인</title>
</head>
<body>
	<div class="wrapper">
		<div class="content">
			<header>
				<img src="image/logodraft.png" />
			</header>
			<section>
				관리자만 로그인 가능합니다.
				<form name="loginForm" action="loginSelectAdmin.jsp">
					<input type="text" name="adminId" size="40" placeholder="관리자 아이디" />
					<input type="password" name="adminPw" size="40" placeholder="관리자 비밀번호" />
					<button type="submit">로그인</button>
				</form>
			</section>
		</div>
	</div>
</body>
</html>