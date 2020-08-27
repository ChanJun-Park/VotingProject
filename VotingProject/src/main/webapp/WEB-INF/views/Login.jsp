<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="/voting/resources/css/login.css">
	<title>로그인</title>
</head>
<body>
<h1><b>Login</b></h1>
<hr>
<br>

<form action="/voting/login" id = "loginform" method="POST" >
	<table>
		<tr>
			<td><label for="id"><b>아이디 :&nbsp;&nbsp;</b></label></td>
			<td><input id="id" type="text" name="user_id" placeholder="아이디 입력" required/></td>
		</tr>
		<tr>
			<td><label for="pw"><b>비밀번호 :&nbsp;&nbsp;</b></label></td>
			<td><input id="pw" type="password" name="password" placeholder="비밀번호 입력" required/></td>
		</tr>
	</table>
	<br>
	<h2 id = "validcheck">${validcheck}</h2>
	<br>
	<button class="btn log" id ="loginbtn" >로그인</button><br>
	<!-- onclick="document.getElementById('loginform').submit;" -->
</form>
<br>
<form action = "/voting/signup" id = "signupform" method="GET">
	<button class="btn log" id = "signupbtn">회원가입</button>
</form>

<script src="/voting/resources/jquery-3.2.1.min.js"></script>
<script src="/voting/resources/js/login.js"></script>
</body>
</html>