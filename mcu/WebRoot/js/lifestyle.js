$(document).ready(function() {
	$("span.menu").click(function() {
		$(" ul.nav").slideToggle("slow", function() {
		});
	});

	$('#horizontalTab').easyResponsiveTabs({
		type : 'default', // Types: default, vertical, accordion
		width : 'auto', // auto or any width like 600px
		fit : true
	// 100% fit in a container
	});

	$(".scroll").click(function(event) {
		event.preventDefault();
		$('html,body').animate({
			scrollTop : $(this.hash).offset().top
		}, 1000);
	});

	$("#slider").responsiveSlides({
		auto : true,
		manualControls : '#slider3-pager',
	});
	
	addEventListener("load", function() {
		setTimeout(hideURLbar, 0);
	}, false);
});

function hideURLbar() {
	window.scrollTo(0, 1);
}