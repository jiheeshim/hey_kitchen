<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="qnaStyle.css?ver=1">
<link rel="stylesheet" type="text/css" href="headerFooter.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript" src="menuslide.js"></script>
<title>헤이키친 : 문의글 작성</title>
</head>
<body>
	<div>
		<jsp:include page="header.jsp" />
		
		<main>
			<section class="title">문의하기</section>
			<section>
				<form action="qnaWritePro.qna" method="post" enctype="multipart/form-data" name="qnaForm">
					<table class="qnaDetailTable">
						<tr>
							<td>문의 분류</td>
							<td>
								<select name="qnaCategory">
									<option value="구독 문의">구독 문의</option>
									<option value="배송 문의">배송 문의</option>
									<option value="레시피 피드 문의">레시피 피드 문의</option>
									<option value="기타 문의">기타 문의</option>
								</select>
							</td>
						</tr>
						<tr>
							<td>제목</td>
							<td><input type="text" name="title" maxlength="50" required></td>
						</tr>
						<tr>
							<td>비밀글 설정</td>
							<td>
								<input type="radio" name="secret" value="open" checked>&nbsp;공개글
								<input type="radio" name="secret" value="secret">&nbsp;비밀글
							</td>
						</tr>
						<tr>
							<td>비밀번호</td>
							<td><input type="password" name="qnaPw" required></td>
						</tr>
						<tr>
							<td>첨부파일</td>
							<td><input type="file" name="qnaFile"></td>
						</tr>
						<tr>
							<td colspan="2"><textarea name="content"></textarea></td>
						</tr>
					</table>
					<div class="detailBtns">
						<button type="submit">등록하기</button>
						<button type="button" onclick="location.href='qnaList.qna'">돌아가기</button>
					</div>
				</form>
			</section>
		</main>
		
		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>