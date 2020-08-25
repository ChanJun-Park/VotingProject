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



<script src="/voting/resources/jquery-3.2.1.min.js"></script>
<script>
$(document).ready(function(){
	var idcheck=false;
	var emailcheck = false;
	$("#iddupcheckbtn").on('click',function(){
		$.ajax({
			url:"dupcheck",
			method:'post',
			data:{"idoremail":$('#user_id').val(),
				"idemail":"user_id"},
			success: function(data){
				if(data=="NO"){
					//중복이면 false
					alert("중복된 아이디입니다.");
					idcheck = false;
				}
				else if(data=="YES"){
					alert("사용가능한 아이디입니다.");
					idcheck = true;
				}
				else{
					alert("오류입니다.");
					idcheck = false;
				}
			}
		
		});
	$("#emaildupcheckbtn").on('click',function(){
		$.ajax({
			url:"dupcheck",
			method:"post",
			data:{"idoremail":$("#email").val(),
				"idemail":"email"},
			success:function(data){
				if(data=="NO"){
					//중복이면 false
					alert("중복된 이메일입니다.");
					emailcheck = false;
				}
				else if(data=="YES"){
					alert("사용가능한 이메일입니다.");
					emailcheck = true;
				}
				else{
					alert("오류입니다.");
					emailcheck = false;
				}
		}});
		}); 
	//완료버튼
 	$("#signupbtn").on('click',function(){
		if(idcheck==true&&emailcheck==true){
			 $('#signupform').submit(); 
		}
		else if(emailcheck==true && idcheck==false){
			alert("아이디 중복확인이 필요합니다.");

		}
		else if(idcheck==true && emailcheck==false){
			alert("이메일 중복확인이 필요합니다.");
			
		} 
		else {
			alert("아이디와 이메일 중복확인이 필요합니다.");
		}
	
		
	});
	
	
	
	}); });
		
	
	
</script>
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
</body>
</html>