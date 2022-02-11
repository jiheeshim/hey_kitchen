
// 리뷰 댓글 삭제 확인 함수
function askDelete(reviewNo, recipeNo) {
	if(confirm("정말로 삭제하시겠습니까?")) {
		location.href = "reviewDelete.rec?reviewNo=" + reviewNo + "&recipeNo=" + recipeNo;
	} else {
		return false;
	}
}

// 마우스 올리면 스크랩 아이콘 배경색 & 글씨 바뀌도록
var scraps = document.getElementById("scraps");
var scrapBtn = document.getElementById("scrapBtn");
var scrapA = document.querySelector("#scraps > a");

scraps.addEventListener("mouseover", function() {
	scrapA.style.fontWeight = "bold";
	scrapA.style.color = "#313131";
});
scraps.addEventListener("mouseout", function() {
	scrapA.style.fontWeight = "normal";
	scrapA.style.color = "#5a5a5a";
});

// 스크랩 div 클릭 시, 스크랩 기능으로 이동
var recipeNo = document.querySelector("input[name='recipeNo']");
var isScrapped = document.querySelector("input[name='isScrapped']");
var id = document.querySelector("input[name='id']");
var recipeId = document.querySelector("input[name='recipeId']");

scraps.addEventListener("click", function() {
	
	if(id.value == "") { // 로그인 안되어 있는 경우
		if(confirm("로그인 후 이용 가능한 서비스입니다. 로그인 하시겠습니까?")) {
			location.href = "login.jsp";
		} else {
			return false;
		}
	} else if(id.value == recipeId.value) { // 본인의 레시피 게시물인 경우
		alert("본인의 레시피는 스크랩할 수 없습니다.");
	} else { // 로그인 되어 있고 내 게시물 아닌 경우
		if(isScrapped.value == "true") { // 스크랩되어 있으면, 스크랩 지우는 기능
			location.href = "recipeScrapDelete.rec?recipeNo=" + recipeNo.value;
		} else { // 스크랩 안 되어 있으면, 스크랩하는 기능
			location.href = "recipeScrapPro.rec?recipeNo=" + recipeNo.value;
		}
	}
	
});

// 재료 배열 보내기 ajax
$(function () {
	$("#ingrBtn").click(function() {
		if(id.value == "") { // 로그인 안 되어 있는 경우
			if(confirm("로그인 후 이용 가능한 서비스입니다. 로그인 하시겠습니까?")) {
				location.href = "login.jsp";
			} else {
				return false;
			}
		} else {
			var ingr = []; // 재료 배열 선언 
			$("input[name='ingr']:checked").each(function(index) {
				ingr.push($(this).val()); // 체크되어 있는 재료들 배열에 담기
			});
			
			if(ingr.length == 0) { // 아무것도 체크 안 되어 있는 경우
				alert("담을 재료의 좌측 체크박스를 체크해주세요.");
			} else { // 체크한 재료 ajax로 insert
				$.ajax({
					url: "ingrScrapPro.rec",
					type: "post",
					traditional: true,
					data: {
						ingr: ingr
					},
					success: function(result) { // 성공한 경우
						if(result.includes("?")) { // insert 성공한 경우, 장보기 목록으로 갈지 질문
							if(confirm(result)) {
								location.href = ""; // 장보기 목록으로 이동
							} else {
								return false;
							}
						} else {
							alert(result);
						}
					},
					error: function() { // 실패한 경우
						alert("오류가 발생하였습니다.");
					}
				});
			}
		}
	});
});
