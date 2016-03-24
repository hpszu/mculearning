function LoadBlogParts() {
	var swfUrl = "http://chabudai.sakura.ne.jp/blogparts/honehoneclock/honehone_clock_tr.swf";
	var swfTitle = "honehoneclock";
	var sUrl = swfUrl;
	var sHtml = "";
	sHtml += '<object classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000" codebase="http://fpdownload.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=8,0,0,0" width="160" height="70" id="'
			+ swfTitle + '" align="middle">';
	sHtml += '<param name="allowScriptAccess" value="always" />';
	sHtml += '<param name="movie" value="' + sUrl + '" />';
	sHtml += '<param name="quality" value="high" />';
	sHtml += '<param name="bgcolor" value="#ffffff" />';
	sHtml += '<param name="wmode" value="transparent" />';
	sHtml += '<embed wmode="transparent" src="'
			+ sUrl
			+ '" quality="high" bgcolor="#ffffff" width="160" height="80" name="'
			+ swfTitle
			+ '" align="middle" allowScriptAccess="always" type="application/x-shockwave-flash" pluginspage="http://www.macromedia.com/go/getflashplayer" />';
	sHtml += '</object>';
	$("#timeArea").html(sHtml);
}

function snow() {
	if (1 == 1) {
		$("body")
				.append(
						'<canvas id="christmasCanvas" style="top: 0px; left: 0px; z-index: 5000; position: fixed; pointer-events: none;"></canvas>');
		var b = document.getElementById("christmasCanvas"), a = b
				.getContext("2d"), d = window.innerWidth, c = window.innerHeight;
		b.width = d;
		b.height = c;
		for (var e = [], b = 0; b < 70; b++) {
			e.push({
				x : Math.random() * d,
				y : Math.random() * c,
				r : Math.random() * 4 + 1,
				d : Math.random() * 70
			})
		}
		var h = 0;
		window.intervral4Christmas = setInterval(function() {
			a.clearRect(0, 0, d, c);
			a.fillStyle = "rgba(255, 255, 255, 0.6)";
			a.shadowBlur = 5;
			a.shadowColor = "rgba(255, 255, 255, 0.9)";
			a.beginPath();
			for (var b = 0; b < 70; b++) {
				var f = e[b];
				a.moveTo(f.x, f.y);
				a.arc(f.x, f.y, f.r, 0, Math.PI * 2, !0)
			}
			a.fill();
			h += 0.01;
			for (b = 0; b < 70; b++) {
				if (f = e[b], f.y += Math.cos(h + f.d) + 1 + f.r / 2,
						f.x += Math.sin(h) * 2, f.x > d + 5 || f.x < -5
								|| f.y > c) {
					e[b] = b % 3 > 0 ? {
						x : Math.random() * d,
						y : -10,
						r : f.r,
						d : f.d
					} : Math.sin(h) > 0 ? {
						x : -5,
						y : Math.random() * c,
						r : f.r,
						d : f.d
					} : {
						x : d + 5,
						y : Math.random() * c,
						r : f.r,
						d : f.d
					}
				}
			}
		}, 70)
	}
}

function getLoginData() {
	var remember = 0;
	// alert($("#remember").attr('checked'));
	if ($("#remember").prop("checked")) {
		remember = 1;
	}
	var userType = 0;
	if ($("#user_type").val() == "teacher") {
		userType = 1;
	}
	var data = {
		userName : $("#user_name").val(),
		userPassword : $("#user_password").val(),
		userRemember : remember,
		userType : userType,
	}

	return data;
}

function getRegisterData() {
	var type = 0;
	var data = {};
	if ($("register_gender").val() == "male") {
		data["gender"] = 0;
	} else {
		data["gender"] = 1;
	}
	if ($("#register_type").val() == "teacher") {
		type = 1;
		data["type"] = type;
		data["teacherAccount"] = $("#teacher_account").val();
		data["teacherName"] = $("#teacher_name").val();
		data["password"] = $("#teacher_password").val();
		data["repeatPassword"] = $("#teacher_finalPWD").val();
	} else {
		data["type"] = type;
		data["studentNumber"] = $("#student_number").val();
		data["studentName"] = $("#student_name").val();
		data["password"] = $("#student_password").val();
		data["repeatPassword"] = $("#student_finalPWD").val();
	}
	return data;
}

function handleRegister(data, status) {
	if (status == "success") {
		if (data["status"] == 1) {
			window.location.href = "index.jsp";
		} else {
			alert("failure");
		}
	} else {
		alert("error");
	}
}

function changeType(flag) {
	var selectElementId = "#" + flag + "_type";
	if ($(selectElementId).val() == "teacher") {
		$("#teacher_" + flag).show();
		$("#student_" + flag).hide();
	} else {
		$("#teacher_" + flag).hide();
		$("#student_" + flag).show();
	}
}

function handleLogin(data, status) {
	if (status == "success") {
		if (data["status"] == 1) {
			window.location.href = "index.jsp"
		}
		// ;
	} else {
		$("#userPassword").val("");
	}
}

function ajaxPost(url, func, getData) {
	$.post(url, getData(), function(data, status) {
		func(data, status);
	}, 'json');
}

jQuery(document).ready(function() {
	snow();

	LoadBlogParts();

	$("#register_type").change(function() {
		changeType("register");
	});

	$("#login_type").change(function() {
		changeType("login");
	});

	$(".btn").click(function() {
		var left = ($(window).width() * (1 - 0.35)) / 2;// box弹出框距离左边的额距离
		var height = ($(window).height() * (1 - 0.5)) / 2;

		$(".box").addClass("animated bounceIn").show().css({
			left : left,
			top : top
		});
		$(".opacity_bg").css("opacity", "0.3").show();
	});

	$("#submit").click(function() {
		ajaxPost("ajaxLogin.action", handleLogin, getLoginData);
	});

	$("#btn_register").click(function() {
		ajaxPost("ajaxRegister.action", handleRegister, getRegisterData);
	});

	$(".colse").click(function() {
		var left = ($(window).width() * (1 - 0.35)) / 2;
		var top = ($(window).height() * (1 - 0.5)) / 2;
		$(".box").show().animate({
			width : "-$(window).width()*0.35",
			height : "-$(window).height()*0.5",
			left : "-" + left + "px",
			top : "-" + top + "px"
		}, 1000, function() {
			var width1 = $(window).width() * 0.35;
			var height1 = $(window).height() * 0.5;
			console.log(width1);
			$(this).css({
				width : width1,
				height : height1
			}).hide();
		});
	});
});
/** ********HTML初始化后为其按钮绑定函数********* */

