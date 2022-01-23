<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="headerFooter.css">
<link rel="stylesheet" type="text/css" href="noticeStyle.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript" src="menuslide.js"></script>
<title>이벤트 및 공지사항</title>
</head>
<body>
	<c:set var="auth" value="<%= session.getAttribute(\"auth9999\") %>" />
	<div>
		<jsp:include page="header.jsp" />
		
		<main>
			<div class="title">이벤트 및 공지사항</div>
			<section>
				<table id="noticeTable">
					<tr>
						<th width="10%">글번호</th>
						<th width="10%">글분류</th>
						<th width="50%">제목</th>
						<th width="10%">작성자</th>
						<th width="20%">작성/수정 날짜</th>
					</tr>
					<c:forEach var="notice" items="${noticeList}">
						<c:if test="${notice.impo eq '1'}"><tr class="impoColor"></c:if>
						<c:if test="${notice.impo ne '1'}"><tr></c:if>
							<td>${notice.noticeNo}</td>
							<td>${notice.category}</td>
							<td><a href="noticeSelect.jsp?noticeNo=${notice.noticeNo}&purpose=view">${notice.title}</a></td>
							<td>${notice.adminName}</td>
							<c:choose>
								<c:when test="${notice.editDate == null}">
									<td>${notice.regDate}</td>
								</c:when>
								<c:otherwise>
									<td>${notice.editDate}</td>
								</c:otherwise>
							</c:choose>
						</tr>
					</c:forEach>
				</table>
			</section>
			
			<c:set var="field" value='<%= request.getParameter("field") %>' />
			<c:set var="words" value='<%= request.getParameter("words") %>' />
			<div class="pages">
				<c:if test="${pageInfo.page <= 1}">
					<button>&lt;</button>
				</c:if>
				<c:if test="${pageInfo.page > 1}">
					<button onclick="location.href='noticeSearch.jsp?page=${pageInfo.page - 1}&field=${field}&words=${words}'">&lt;</button>
				</c:if>
				
				<c:forEach var="p" begin="${pageInfo.startPage}" end="${pageInfo.endPage}">
					<c:if test="${p == pageInfo.page}">
						<b>${p}</b>&nbsp;
					</c:if>
					<c:if test="${p != pageInfo.page}">
						<a href="noticeSearch.jsp?page=${p}&field=${field}&words=${words}">${p}</a>&nbsp;
					</c:if>
				</c:forEach>
				
				<c:if test="${pageInfo.page >= pageInfo.maxPage}">
					<button>&gt;</button>
				</c:if>
				<c:if test="${pageInfo.page < pageInfo.maxPage}">
					<button onclick="location.href='noticeSearch.jsp?page=${pageInfo.page + 1}&field=${field}&words=${words}'">&gt;</button>
				</c:if>
			</div>
			
			<div class="noticeSearch">
				<form action="noticeSearch.jsp" onsubmit="return noticeSearchCheck();">
					<select name="field">
						<option value="title" <c:if test="${field eq 'title'}"> selected </c:if> >제목</option>
						<option value="category" <c:if test="${field eq 'category'}"> selected </c:if> >글분류</option>
						<option value="content" <c:if test="${field eq 'content'}"> selected </c:if> >글내용</option>
						<option value="both" <c:if test="${field eq 'both'}"> selected </c:if> >제목 + 글내용</option>
					</select>
					<input type="text" id="noticeWords" name="words" value="${words}" size="15" />
					<button type="submit">찾기</button>
					<c:if test="${auth eq 'admin9999'}">
						<button type="button" onclick="location.href='noticeWrite.jsp'">글쓰기</button>
					</c:if>
				</form>
			</div>
		</main>
		
		<jsp:include page="footer.jsp" />
	</div>
</body>
<script type="text/javascript" src="noticeScript.js"></script>
</html>