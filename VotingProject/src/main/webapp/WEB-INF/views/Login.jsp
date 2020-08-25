<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<script src="/voting/resources/jquery-3.2.1.min.js"></script>

<script>
$(document).ready(function(){

	$("#signupbtn").on('click',function(){
		$('signupform').submit();
	})

	$("#loginbtn").on('click',function(){
		document.getElementById('loginform').submit;
		//alert("${validcheck}");
	})
	
	
});


</script>




<style>
body {
	text-align:center;
	align-content: center;
}
table {
	margin:auto;
	text-align:left;
}
td {
	height: 40px;
}
input {
	box-sizing: border-box;
    border: 1px solid #ccc;
    border-radius: 4px;
    font-size: 14px;
    height:25px;
}
#validcheck{
	font-size: 13px;
	color:red;
}

/* 버튼 효과 */
.btn {
    border: none;
    color: white;
    padding: 10px 16px;
    font-size: 16px;
    cursor: pointer;
    width:30%;
}
.log {background-color: #ff9800;}
.log:hover {background: #e68a00;}

</style>
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
<h3 id = "validcheck">${validcheck}</h3>
<button class="btn log" id ="loginbtn" >로그인</button><br>
<!-- onclick="document.getElementById('loginform').submit;" -->
</form>
<br>
<form action = "/voting/signup" id = "signupform" method="GET">
<button class="btn log" id = "signupbtn">회원가입</button>&nbsp;&nbsp;
</form>

</body>
</html>