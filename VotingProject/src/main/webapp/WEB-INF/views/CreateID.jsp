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
	width:400px;
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
    width:250px;
}

/* 버튼 효과 */
.btn {
    border: none;
    color: white;
    padding: 10px 16px;
    font-size: 16px;
    cursor: pointer;
}
.log {
background-color: #ff9800;
width:300px;
}
.log:hover {background: #e68a00;}


</style>
<title>회원가입</title>
</head>
<body>
<h1><b>회원가입</b></h1>
<hr>
<br>
<br>
<table>
<tr>
<td><label for="id"><b>아이디 :&nbsp;</b></label></td>
<td><input id="user_id" type="text" name="user_id" placeholder="아이디 입력" style="width:130px;" required/>&nbsp;&nbsp;
<button class="btn log" style ="width: 100px;height:40px; font-size: 16px;">중복확인</button></td>
</tr>
<tr>
<td><label for="pw"><b>이메일 :&nbsp;</b></label></td>
<td><input id="id" type="email" name="user_pass" placeholder="이메일 입력" required/></td>
</tr>
<tr>
<td><label for="pw"><b>비밀번호 :&nbsp;</b></label></td>
<td><input id="id" type="password" name="user_pass" placeholder="비밀번호 입력" required/></td>
</tr>
<tr>
<td><label for="pw"><b>비밀번호 확인 :&nbsp;</b></label></td>
<td><input id="id" type="password" name="user_pass" placeholder="비밀번호 확인" required/></td>
</tr>
</table>
<br>
<br>
<button class="btn log" onclick="location.href='/VotingProject/MainPage.jsp'">완료</button>
</body>
</html>