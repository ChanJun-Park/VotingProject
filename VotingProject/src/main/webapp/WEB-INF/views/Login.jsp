<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
}

/* 버튼 효과 */
.btn {
    border: none;
    color: white;
    padding: 10px 16px;
    font-size: 16px;
    cursor: pointer;
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
<table>
<tr>
<td><label for="id"><b>아이디 :&nbsp;&nbsp;</b></label></td>
<td><input id="id" type="text" name="user_id" placeholder="아이디 입력" required/></td>
</tr>
<tr>
<td><label for="pw"><b>비밀번호 :&nbsp;&nbsp;</b></label></td>
<td><input id="id" type="password" name="user_pass" placeholder="비밀번호 입력" required/></td>
</tr>
</table>
<br>
<button class="btn log" onclick="self.close()">회원가입</button>&nbsp;&nbsp;
<button class="btn log" onclick="location.href='/project/MainPage.jsp'">로그인</button>
</body>
</html>