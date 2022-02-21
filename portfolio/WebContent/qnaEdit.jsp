<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
			<section class="title">문의하기</section>
			<section>
				<form action="qnaEditPro.qna" name="qnaEditForm">
					<input type="hidden" name="qnaNo" value="${qna.qnaNo}">
					<input type="hidden" name="page" value="${page}">
					<table class="qnaDetailTable">
						<tr>
							<td>문의 분류</td>
							<td>
								<select name="qnaCategory">
									<option value="구독 문의" <c:if test="${qna.qnaCategory eq '구독 문의'}">selected</c:if> >구독 문의</option>
									<option value="배송 문의" <c:if test="${qna.qnaCategory eq '배송 문의'}">selected</c:if> >배송 문의</option>
									<option value="레시피 피드 문의" <c:if test="${qna.qnaCategory eq '레시피 피드 문의'}">selected</c:if> >레시피 피드 문의</option>
									<option value="기타 문의" <c:if test="${qna.qnaCategory eq '기타 문의'}">selected</c:if> >기타 문의</option>
								</select>
							</td>
						</tr>
						<tr>
							<td>제목</td>
							<td><input type="text" name="title" maxlength="50" value="${qna.title}"></td>
						</tr>
						<tr>
							<td>비밀글 설정</td>
							<td>
								<input type="radio" name="secret" value="open" <c:if test="${qna.secret eq 'open'}"> checked </c:if> >&nbsp;공개글
								<input type="radio" name="secret" value="secret" <c:if test="${qna.secret eq 'secret'}"> checked </c:if> >&nbsp;비밀글
							</td>
						</tr>
						<tr>
							<td>비밀번호</td>
							<td><input type="password" name="qnaPw" required></td>
						</tr>
						<tr>
							<td colspan="2"><textarea name="content">${qna.content}</textarea></td>
						</tr>
					</table>
					<div class="detailBtns">
						<button type="submit">등록하기</button>
						<button type="button" onclick="location.href='qnaView.qna?qnaNo=${qna.qnaNo}&page=${page}'">돌아가기</button>
					</div>
				</form>
			</section>
		</main>

		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>