<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
						<td><b>문의 분류</b></td>
						<td>${qna.qnaCategory}</td>
					</tr>
					<tr>
						<td><b>제목</b></td>
						<td>${qna.title}</td>
					</tr>
					<tr>
						<td colspan="2">
							<div class="rightReadCount">
								<b>조회수</b> : ${qna.readCount}&nbsp;&nbsp;|&nbsp;
								<fmt:parseDate var="regDate" pattern="yyyy-MM-dd HH:mm:ss.SSS" value="${qna.regDate}" />
								<fmt:parseDate var="editDate" pattern="yyyy-MM-dd HH:mm:ss.SSS" value="${qna.regDate}" />
								<b>작성날짜</b> : <fmt:formatDate value="${regDate}" pattern="yyyy-MM-dd HH:mm:ss" />
								<c:if test="${qna.editDate != null}">
									<fmt:parseDate var="editDate" pattern="yyyy-MM-dd HH:mm:ss.SSS" value="${qna.editDate}" />
									&nbsp;&nbsp;|&nbsp; <b>수정날짜</b> : <fmt:formatDate value="${editDate}" pattern="yyyy-MM-dd HH:mm:ss" />
								</c:if>
							</div>
							<div class="contentBox">${qna.content}</div>
						</td>
					</tr>
				</table>
				<div class="viewBtns">
					<span>
						<c:set var="id" value='<%= session.getAttribute("id") %>' />
						<input type="hidden" name="sessionId" value='<c:out value="${id}" />'>
						<input type="hidden" name="qnaId" value="${qna.id}"> 
						<input type="hidden" name="adminName" value="<%= (String)session.getAttribute("adminName") %>">
						<c:if test="${id != null}">
							<button type="button" onclick="location.href='qnaReplyForm.qna?qnaNo=${qna.qnaNo}&page=${page}'">답변하기</button>
						</c:if>
						<button type="button" onclick="location.href='qnaList.qna?page=${page}'">목록보기</button>
					</span>
					<span>
						<button type="button" onclick="javascript:idCheck(0);">수정하기</button>
						<button type="button" onclick="javascript:idCheck(1);">삭제하기</button>
					</span>
				</div>
			</section>
		</main>
		
		<jsp:include page="footer.jsp" />
		<script>
			function idCheck(num, id, qnaId) {
				var sessionId = document.querySelector("input[name='sessionId']");
				var qnaId = document.querySelector("input[name='qnaId']");
				var adminName = document.querySelector("input[name='adminName']");
				
				if(sessionId.value == qnaId.value || adminName.value == qnaId.value) {
					if(num == 0) { // edit로 이동
						location.href = 'qnaEditForm.qna?qnaNo=${qna.qnaNo}&page=${page}';
					} else { // delete로 이동
						location.href = 'qnaDeleteForm.qna?qnaNo=${qna.qnaNo}&page=${page}';
					}
				} else {
					alert("본인의 게시물이 아닙니다.");
					return false;
				}
			}
		</script>
	</div>
</body>
</html>