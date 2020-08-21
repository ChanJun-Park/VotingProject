<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
h1, h4{
	align-content: center;
}
.btn {
    border: none;
    color: white;
    padding: 10px 16px;
    font-size: 16px;
    cursor: pointer;
}
.log {background-color: #ff9800;}
.log:hover {background: #e68a00;}
body{
text-align:center;
align-content: center;
}
</style>
<title>로그인</title>
</head>
<body>
<h1><b>Login</b></h1>
<hr>
<h4>아이디 : <input type="text" name="user_id"/></h4>
<h4>비밀번호 : <input type="password" name="user_pass"/></h4>
<button class="btn log" onclick="self.close()">회원가입</button>
<button class="btn log" onclick="self.close()">로그인</button>
</body>
</html>