// 상단메뉴 슬라이드 효과 & 글자 색 강조 효과
$(document).ready(function() {
	$(".level1").hover(function() {
		$(this).children("a").css("color", "#FF5D49");
		$(this).children("a").css("border-bottom", "2px solid #FF5D49");
		$(this).find(".level2_wrapper, .level2_wrapperL").slideDown("fast");
	}, function() {
		$(this).children("a").css("color", "black");
		$(this).children("a").css("border-bottom", "2px solid white");
		$(this).find(".level2_wrapper, .level2_wrapperL").hide();
	});
	$(".level2 a").hover(function() {
		$(this).css("color", "#FF5D49");
	}, function() {
		$(this).css("color", "black")
	});
});
