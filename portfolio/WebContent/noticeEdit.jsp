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
<title>이벤트 및 공지사항 작성</title>
</head>
<body>
	<div>
		<jsp:include page="header.jsp" />
		
		<main>
			<div class="title">이벤트 및 공지사항 작성</div>
			<form id="noticeForm" action="noticeUpdate.jsp">
				<table>
					<tr>
						<td>
							<input type="hidden" name="noticeNo" value="${notice.noticeNo}">
							<select name="category">
								<option value="공지사항" <c:if test="${notice.category eq '공지사항'}">selected</c:if>>공지사항</option>
								<option value="이벤트" <c:if test="${notice.category eq '이벤트'}">selected</c:if>>이벤트</option>
							</select>
							<input type="text" name="title" value="${notice.title}">
						</td>
					<tr>
						<td>
							<input type="button" value="첨부파일 추가하기">
							<input type="text" name="fileName" readonly>
						</td>
					</tr>
					<tr>
						<td>
							<input type="button" value="이미지 추가하기">
							<input type="text" name="imgName" readonly>
						</td>
					</tr>
					<tr>
						<td>
							<div class="tdHead">중요도 여부</div>
							<input type="radio" name="impo" value="1" <c:if test="${notice.impo eq '1'}">checked</c:if>>중요
							<input type="radio" name="impo" value="0" <c:if test="${notice.impo eq '0'}">checked</c:if>>일반
						</td>
					</tr>
					<tr>
						<td>
							<textarea name="content">${notice.content}</textarea>
						</td>
					</tr>
				</table>
				<div class="noticebtns">
					<button type="submit">등록</button>
					<button type="button" onclick="returnToNotice()">취소</button>
				</div>
			</form>
		</main>
		
		<jsp:include page="footer.jsp" />
	</div>
</body>
<script type="text/javascript" src="noticeScript.js"></script>
</html>