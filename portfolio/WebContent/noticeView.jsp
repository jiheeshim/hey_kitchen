<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="headerFooter.css">
<link rel="stylesheet" type="text/css" href="noticeIndivStyle.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript" src="menuslide.js"></script>
<title>이벤트 및 공지사항</title>
</head>
<body>
	<c:set var="auth" value="<%= (String)session.getAttribute(\"auth9999\") %>" />
	<div>
		<jsp:include page="header.jsp" />
		
		<main>
			<div class="title">이벤트 및 공지사항</div>
			<table id="noticeTable">
				<tr>
					<td>[${notice.category}]${notice.title}</td>
				</tr>
				<tr>
					<td>첨부파일 : <a href="noticeUpload/${notice.fileName}" download>${notice.fileName}</a></td>
				</tr>
				<tr>
					<td>
						<div class="row2">
							<span>${notice.adminName}</span>
							<span class="noticeDates">
								작성날짜 : ${notice.regDate}
								<c:if test="${notice.editDate != null}">
									&nbsp;수정날짜 : ${notice.editDate}
								</c:if>
							</span>
						</div>
					</td>
				</tr>
				<tr>
					<td>
						<%-- fileName & imgName --%>
						<div class="content">${notice.content}</div>
					</td>
				</tr>
			</table>
			<div class="noticebtns">
				<c:if test="${auth eq 'admin9999'}">
					<button type="button" onclick="location.href='noticeSelect.jsp?noticeNo=${notice.noticeNo}&purpose=edit'">수정</button>
				</c:if>
				<button type="button" class="widebtns" onclick="location.href='noticeListSelect.jsp'">목록보기</button>
				<c:if test="${auth eq 'admin9999'}">
					<button type="button" onclick="deleteNotice(${notice.noticeNo})">삭제</button>
				</c:if>
			</div>
		</main>
		
		<jsp:include page="footer.jsp" />
	</div>
</body>
<script type="text/javascript" src="noticeScript.js"></script>
</html>