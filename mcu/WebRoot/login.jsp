<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page contentType="text/html;charset=utf-8" pageEncoding="UTF-8"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>登录界面</title>

<link rel="stylesheet" type="text/css" href="css/login.css" />
<link rel="stylesheet" type="text/css" href="css/animate.css" />

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/login.js"></script>
</head>

<body>

	<canvas id="christmasCanvas"
		style="top: 0px; left: 0px; z-index: 5000; position: fixed; pointer-events: none;"
		width="1285" height="100%"></canvas>

	<h2 align="center">用户登录</h2>

	<div class="login_frame"></div>

	<div class="LoginWindow">
		<div class="login">
			<!-- <form action="userlogin.action" method="post"> -->
			<div id="student_login">
				<p>
					<input type="text" name="userName" id="user_name" placeholder="学号"
						value="">
				</p>
				<p>
					<input type="password" name="userPassword" id="user_password"
						placeholder="密码" value="">
				</p>
			</div>
			<div style="display:none" id="teacher_login">
				<p>
					<input type="text" name="teacherName" id="teacher_name" placeholder="用户名"
						value="">
				</p>
				<p>
					<input type="password" name="teacherPassword" id="teacher_password"
						placeholder="密码" value="">
				</p>
			</div>
				<p class="login-submit">
					<button type="submit" class="login-button" id="submit">登录</button>
				</p>

				<p>
					<input type="checkbox" name="userRemember" id="remember" /> <span
						class="checkbox_remember">记住密码</span> <select name="userType"
						id="login_type">
						<option value="student">学生</option>
						<option value="teacher">教师</option>
					</select>

				</p>
				<p>
					<a id="register" class="registration  btn">快速注册</a> <a
						class="forget_paw">忘记密码</a>
				</p>
			</div>
			<!-- </form> -->
		</div>
	</div>

	<div class="box">
		<p>
		您的身份是
			<select name="type"	id="register_type">
				<option value="student">学生</option>
				<option value="teacher">教师</option>
			</select>
		您的性别是
			<select name="gender" id="register_gender">
				<option value="male">男</option>
				<option value="female">女</option>
			</select>
		</p>
		<div class="regiest" id="teacher_register" style="display:none">
			<p>
				<input type="text" id="teacher_account" placeholder="用户名" />
			</p>
			<p>
				<input type="text" id="teacher_name" placeholder="真实姓名" />
			</p>
			<p>
				<input type="password" id="teacher_password" placeholder="密码" />
			</p>
			<p>
				<input type="password" id="teacher_finalPWD" placeholder="确认密码" />
			</p>
			<div id="btn2">
				<ul>
					<li><input type="button" value="关闭" class="colse" /></li>
					<li><input type="button" value="提交" class="sumbmit" /></li>
				</ul>
			</div>
		</div>

		<div class="regiest" id="student_register" >

			<p>
				<input type="text" id="student_number" placeholder="学号" />
			</p>
			<p>
				<input type="text" id="student_name" placeholder="真实姓名" />
			</p>
			<p>
				<input type="password" id="student_password" placeholder="密码" />
			</p>
			<p>
				<input type="password" id="student_finalPWD" placeholder="确认密码" />
			</p>
			<div id="btn2">
				<ul>
					<li><input type="button" value="关闭" class="colse" /></li>
					<li><input type="button" value="提交" class="sumbmit" id="btn_register"/></li>
				</ul>
			</div>
		</div>
		
		<div>
			
		</div>
	</div>

	<div id="timeArea"></div>

</body>
</html>