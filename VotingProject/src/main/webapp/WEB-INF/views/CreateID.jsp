<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="/voting/resources/css/createid.css">	
	<title>회원가입</title>
</head>
<body>
<h1><b>회원가입</b></h1>
<hr>
<br>
<br>
<form action="/voting/signup" id = "signupform" method="POST" >
	<table>
	<tr>
		<td><label for="id"><b>아이디 :&nbsp;</b></label></td>
		<td><input id="user_id" type="text" name="user_id" placeholder="아이디 입력" style="width:130px;" required/>&nbsp;&nbsp;
		<button type = "button" id = "iddupcheckbtn" class="btn log" style ="width: 100px;height:40px; font-size: 16px;">중복확인</button></td>
	</tr>
	<tr>
		<td><label for="pw"><b>닉네임 :&nbsp;</b></label></td>
		<td><input id="nickname" type="text" name="nickname" placeholder="닉네임 입력" required/></td>
	</tr>
	<tr>
		<td><label for="pw"><b>이메일 :&nbsp;</b></label></td>
		<td><input id="email" type="email" name="email" placeholder="이메일 입력" required/>
		<button type = "button" id = "emaildupcheckbtn" class="btn log" style ="width: 100px;height:40px; font-size: 16px;">중복확인</button></td>
	</tr>
	<tr>
		<td><label for="pw"><b>비밀번호 :&nbsp;</b></label></td>
		<td><input id="password" type="password" name="password" placeholder="비밀번호" required/></td>
	</tr>
	</table>
	<br>
	<br>
	
	<button type="button" class="btn log" id = "signupbtn">완료</button>
</form>
<script src="/voting/resources/jquery-3.2.1.min.js"></script>
<script src="/voting/resources/js/createid.js"></script>
</body>
</html>