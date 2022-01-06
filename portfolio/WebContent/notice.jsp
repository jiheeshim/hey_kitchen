<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
			
			<div class="pages">1</div>
			<div class="noticeSearch">
				<form action="noticeSearch.jsp" onsubmit="return noticeSearchCheck();">
					<select name="category">
						<option value="title">제목</option>
						<option value="category">글분류</option>
						<option value="content">글내용</option>
						<option value="both">제목 + 글내용</option>
					</select>
					<input type="text" id="noticeWords" name="words" size="15" />
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