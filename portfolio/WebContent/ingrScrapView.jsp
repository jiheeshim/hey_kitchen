<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="headerFooter.css">
<link rel="stylesheet" type="text/css" href="ingrScrapStyle.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript" src="menuslide.js"></script>
<title>나의 장보기 목록</title>
</head>
<body>
	<div>
		<jsp:include page="header.jsp" />
	
		<main>
			<div class="title"><img id="helpIcon" src="image/circleHelp.png">id의 장보기 목록</div>
			<div class="subTitle">
				레시피에서 필요한 재료를 담아 나의 장보기 목록을 이용해 보세요.
				<br>이외에 필요한 재료들을 추가/수정하여 직접 편집 가능합니다.
			</div>
			
			<div class="hline"></div>
			<div class="ingrMain">
				<section id="notepad">
					<form>
						<button type="submit">저장하기</button><br>
						<c:forEach var="ingrScrap" items="${ingrScrapList}">
							<input type="checkbox" name="checked" value="${ingrScrap.ingrNo}">&nbsp;&nbsp;
							<input type="text" name="ingr" value="${ingrScrap.ingr}"><br>
						</c:forEach>
					</form>
				</section>
			</div>
			<div class="hline"></div>
		</main>
		
		<jsp:include page="footer.jsp" />
	</div>
	<script type="text/javascript" src="ingrScrapScript.js"></script>
</body>
</html>