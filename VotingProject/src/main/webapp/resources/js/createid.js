// 회원 가입 자바스크립트

var idcheck=false;
var emailcheck = false;
$("#iddupcheckbtn").on('click',function() {
	$.ajax({
		url:"dupcheck",
		method:'post',
		data:{"idoremail" : $('#user_id').val(), "idemail" : "user_id"},
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
});

$("#emaildupcheckbtn").on('click',function(){
	$.ajax({
		url:"dupcheck",
		method:"post",
		data:{"idoremail" : $("#email").val(), "idemail" : "email"},
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
		}
	});
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
