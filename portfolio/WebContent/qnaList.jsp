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
				<table class="qnaListTable">
					<tr>
						<th width="8%">글번호</th>
						<th width="20%">문의분류</th>
						<th width="40%">제목</th>
						<th width="8%">조회수</th>
						<th width="12%">작성자</th>
						<th width="12%">작성날짜</th>
					</tr>
					<c:forEach var="qna" items="${qnaList}">
						<tr>
							<td class="centerAlign">${qna.qnaNo}</td>
							<td class="centerAlign">${qna.qnaCategory}</td>
							<td class="leftAlign">
								<c:if test="${qna.qnaLev != 0}">
									<c:forEach var="i" begin="1" end="${qna.qnaLev}">
										&nbsp;&nbsp;
									</c:forEach>
									↳
								</c:if>
								<c:if test="${qna.secret eq 'open'}">
									<a href="qnaView.qna?qnaNo=${qna.qnaNo}&page=${pageInfo.page}">${qna.title}</a>
								</c:if>
								<c:if test="${qna.secret eq 'secret'}">
									<a href="qnaSecretRead.jsp?qnaNo=${qna.qnaNo}&page=${pageInfo.page}">${qna.title}</a>&nbsp;🔒
								</c:if>
							</td>
							<td class="centerAlign">${qna.readCount}</td>
							<td class="centerAlign">${qna.id}</td>
							<td class="centerAlign">
								<fmt:parseDate var="regDate" value="${qna.regDate}" pattern="yyyy-MM-dd hh:mm:ss" />
								<fmt:formatDate pattern="yyyy-MM-dd" value="${regDate}" />
							</td>
						</tr>
					</c:forEach>
				</table>
			</section>
			<section class="pages">
				<c:if test="${pageInfo.page <= 1}">
					<button>&lt;</button>
				</c:if>
				<c:if test="${pageInfo.page > 1}">
					<button onclick="location.href='qnaList.qna?page=${pageInfo.page - 1}'">&lt;</button>
				</c:if>
				
				<c:forEach var="p" begin="${pageInfo.startPage}" end="${pageInfo.endPage}">
					<c:if test="${p == pageInfo.page}">
						<b>${p}</b>&nbsp;
					</c:if>
					<c:if test="${p != pageInfo.page}">
						<a href="qnaList.qna?page=${p}">${p}</a>&nbsp;
					</c:if>
				</c:forEach>
				
				<c:if test="${pageInfo.page >= pageInfo.maxPage}">
					<button>&gt;</button>
				</c:if>
				<c:if test="${pageInfo.page < pageInfo.maxPage}">
					<button onclick="location.href='qnaList.qna?page=${pageInfo.page + 1}'">&gt;</button>
				</c:if>
			</section>
			<section class="qnaSearch">
				<form action="qnaSearch.qna">
					<select name="field">
						<option value="title">제목</option>
						<option value="qnaCategory">문의분류</option>
						<option value="id">작성자</option>
						<option value="content">글내용</option>
						<option value="both">제목 + 글내용</option>
					</select>
					<input type="text" name="qnaSearchTxt" size="15">
					<button type="submit">검색</button>
					<c:set var="id" value="<%= session.getAttribute(\"id\") %>" />
					<c:if test="${id != null}">
						<button type="button" onclick="location.href='qnaWriteForm.qna'">글쓰기</button>
					</c:if>
				</form>
			</section>
		</main>
		
		<jsp:include page="footer.jsp" />
	</div>

</body>
</html>