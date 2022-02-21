<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="recipeRegisterStyle.css">
<link rel="stylesheet" type="text/css" href="headerFooter.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript" src="menuslide.js"></script>
<title>헤이키친: 새로운 레시피 등록</title>
</head>
<body>
	<div>
		<jsp:include page="header.jsp" />

		<main>
			<section class="title">레시피 등록하기</section>
			<form id="registerForm" action="recipeRegisterPro.rec" method="post" enctype="multipart/form-data" onsubmit="return saveLines();">
				<table>
					<tr>
						<td><span>음식명<font>&nbsp;*</font></span></td>
						<td><input type="text" name="recipeName" maxlength="50" placeholder="음식명을 입력해주세요." required></td>
					</tr>
					<tr>
						<td><span>대표 사진<font>&nbsp;*</font></span></td>
						<td><input type="file" name="thumbnail" accept="image/*" required></td>
					</tr>
					<tr>
						<td><span>카테고리<font>&nbsp;*</font></span></td>
						<td class="categoryTd">
							<input type="checkbox" name="category" id="breakf" value="아침">
							<label for="breakf">아침</label>
							<input type="checkbox" name="category" id="lunch" value="점심">
							<label for="lunch">점심</label>
							<input type="checkbox" name="category" id="dinner" value="저녁">
							<label for="dinner">저녁</label>
							<input type="checkbox" name="category" id="snack" value="간식">
							<label for="snack">간식</label><br>
							
							<input type="checkbox" name="category" id="appetizer" value="애피타이저">
							<label for="appetizer">애피타이저</label>
							<input type="checkbox" name="category" id="main" value="메인">
							<label for="main">메인</label>
							<input type="checkbox" name="category" id="side" value="반찬">
							<label for="side">반찬</label>
							<input type="checkbox" name="category" id="dessert" value="후식">
							<label for="dessert">후식</label><br>
							
							<input type="checkbox" name="category" id="kor" value="한식">
							<label for="kor">한식</label>
							<input type="checkbox" name="category" id="west" value="양식">
							<label for="west">양식</label>
							<input type="checkbox" name="category" id="ch" value="중식">
							<label for="ch">중식</label>
							<input type="checkbox" name="category" id="jpn" value="일식">
							<label for="jpn">일식</label>
							<input type="checkbox" name="category" id="fusion" value="퓨전">
							<label for="fusion">퓨전</label>
							<input type="checkbox" name="category" id="asia" value="동남아">
							<label for="asia">동남아</label><br>
							
							<input type="checkbox" name="category" id="rice" value="밥">
							<label for="rice">밥</label>
							<input type="checkbox" name="category" id="meat" value="육류">
							<label for="meat">육류</label>
							<input type="checkbox" name="category" id="seafood" value="해산물">
							<label for="seafood">해산물</label>
							<input type="checkbox" name="category" id="veg" value="채소">
							<label for="veg">채소</label>
							<input type="checkbox" name="category" id="noodles" value="면요리">
							<label for="noodles">면요리</label>
							<input type="checkbox" name="category" id="vegan" value="비건">
							<label for="vegan">비건</label><br>
							
							<input type="checkbox" name="category" id="group" value="단체 식사">
							<label for="group">단체 식사</label>
							<input type="checkbox" name="category" id="holiday" value="명절">
							<label for="holiday">명절</label>
							<input type="checkbox" name="category" id="xmas" value="크리스마스">
							<label for="xmas">크리스마스</label><br>
							
							<input type="checkbox" name="category" id="cookie" value="쿠키">
							<label for="cookie">쿠키</label>
							<input type="checkbox" name="category" id="cake" value="케이크">
							<label for="cake">케이크</label>
							<input type="checkbox" name="category" id="tart" value="타르트">
							<label for="tart">타르트</label>
							<input type="checkbox" name="category" id="bread" value="빵">
							<label for="bread">빵</label>
							<input type="checkbox" name="category" id="etc" value="기타">
							<label for="etc">기타</label><br>
							
							<input type="checkbox" name="category" id="smoothie" value="스무디">
							<label for="smoothie">스무디</label>
							<input type="checkbox" name="category" id="cocktail" value="칵테일">
							<label for="cocktail">칵테일</label>
							<input type="checkbox" name="category" id="other" value="기타">
							<label for="other">기타</label>
						</td>
					</tr>
					<tr>
						<td><span>음식 소개</span></td>
						<td><textarea name="recipeDesc" placeholder="음식에 대해 소개해주세요."></textarea></td>
					</tr>
					<tr>
						<td><span>재료<font>&nbsp;*</font></span></td>
						<td id="ingrTd">
							<div>
								<input type="text" name="ingrName" maxlength="15" placeholder="재료명 (예시 : 다진 마늘)" required>
								<input type="text" name="ingrAmount" maxlength="15" placeholder="재료양 (예시 : 100g)" required>
								<button type="button" id="ingrAddBtn">추가</button>
							</div>
						</td>
					</tr>
					<tr>
						<td><span>요리 방법<font>&nbsp;*</font></span></td>
						<td id="imgTd">
							<div>
								<button type="button" id="imgAddBtn">+단계 추가하기</button>
								<input type="file" name="imgName0" accept="image/*" required><br>
								<textarea name="imgDesc" placeholder="이미지와 관련된 요리 단계를 설명해주세요. (총 5개까지 추가 가능합니다.)" required></textarea>
							</div>
						</td>
					</tr>
				</table>
				<div class="btnCenter"><button type="submit">등록</button></div>
			</form>
		</main>

		<jsp:include page="footer.jsp" />	
	</div>
</body>
<script type="text/javascript" src="recipeRegisterScript.js"></script>
</html>