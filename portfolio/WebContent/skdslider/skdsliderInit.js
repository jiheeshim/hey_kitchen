// 이미지슬라이더 옵션값 설정
$(document).ready(function() {
	$('#demo1').skdslider({
		slideSelector: '.slide',
		delay:5000,
		animationSpeed: 700,
		showNextPrev:true,
		showPlayButton:false,
		autoSlide:true,
		animationType:'fading',
	});
});