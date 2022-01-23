<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="qnaStyle.css">
<link rel="stylesheet" type="text/css" href="headerFooter.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript" src="menuslide.js"></script>
<title>헤이키친 : 문의사항</title>
</head>
<body>
	<div>
		<jsp:include page="header.jsp" />
		
		<main>
			<section class="pwTitle">비밀번호 확인</section>
			<section class="pwCheck">
				<form action="qnaViewPw.qna">
					<input type="hidden" name="page" value='<%= request.getParameter("page") %>'>
					<input type="hidden" name="qnaNo" value='<%= request.getParameter("qnaNo") %>'>
					비밀번호 입력
					<input type="password" name="qnaPw">
					<button type="submit">확인</button>
				</form>
			</section>
		</main>
		
		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>