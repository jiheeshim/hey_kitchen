<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			<form id="noticeForm" action="noticeInsert.jsp" method="post" enctype="multipart/form-data">
				<table>
					<tr>
						<td>
							<select name="category">
								<option value="공지사항">공지사항</option>
								<option value="이벤트">이벤트</option>
							</select>
							<input type="text" name="title" placeholder="제목">
						</td>
					<tr>
						<td>
							<label id="fileLabel" for="file">첨부파일 추가</label>
							<input type="text" id="fileText" name="fileName" readonly>
							<input type="file" id="file" name="noticeFile">
						</td>
					</tr>
					<tr>
						<td>
							<label id="imageLabel" for="image">이미지 올리기</label>
							<input type="text" id="imageText" name="imageName" readonly>
							<input type="file" id="image" name="noticeImage">
						</td>
					</tr>
					<tr>
						<td>
							<div class="tdHead">중요도 여부</div>
							<input type="radio" name="impo" value="1">중요
							<input type="radio" name="impo" value="0" checked>일반
						</td>
					</tr>
					<tr>
						<td>
							<textarea name="content"></textarea>
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