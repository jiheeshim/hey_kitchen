
var helpIcon = document.getElementById("helpIcon");
var subTitle = document.querySelector(".subTitle");
helpIcon.addEventListener("mouseover", function() {
	subTitle.style.display = "inline-block";
});
helpIcon.addEventListener("mouseout", function() {
	subTitle.style.display = "none";
});
