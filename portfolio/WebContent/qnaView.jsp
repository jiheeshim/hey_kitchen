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
			<section class="title">문의 게시판</section>
			<section>
				<table class="qnaDetailTable">
					<tr>
						<td>문의 분류</td>
						<td>${qna.qnaCategory}</td>
					</tr>
					<tr>
						<td>제목</td>
						<td>${qna.title}</td>
					</tr>
					<c:if test="${qna.qnaFile != null}">
						<tr>
							<td>첨부파일</td>
							<td><a href="qnaFileDown.qna?fileName=${qna.qnaFile}">${qna.qnaFile}</a></td>
						</tr>
					</c:if>
					<tr>
						<td colspan="2">
							<div class="rightReadCount">조회수 : ${qna.readCount}</div>
							<div class="contentBox">${qna.content}</div>
						</td>
					</tr>
				</table>
				<div class="viewBtns">
					<span>
						<c:set var="id" value="<%= session.getAttribute(\"id\") %>" />
						<c:if test="${id != null}">
							<button type="button" onclick="location.href='qnaReplyForm.qna?qnaNo=${qna.qnaNo}&page=${page}'">답변하기</button>
						</c:if>
						<button type="button" onclick="location.href='qnaList.qna?page=${page}'">목록보기</button>
					</span>
					<span>
						<button type="button" onclick="location.href='qnaEditForm.qna?qnaNo=${qna.qnaNo}&page=${page}'">수정하기</button>
						<button type="button" onclick="location.href='qnaDeleteForm.qna?qnaNo=${qna.qnaNo}&page=${page}'">삭제하기</button>
					</span>
				</div>
			</section>
		</main>
		
		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>