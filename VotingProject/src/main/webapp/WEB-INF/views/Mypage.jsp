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

table{
	margin: auto;
	table-layout: fixed;
	width:100%;
	text-align: right;
	
}
tr td:first-child{
	text-align: left;
	font-weight: bold;
}

/* 버튼 효과 */
.btn {
    border: none;
    color: white;
    padding: 10px 16px;
    font-size: 16px;
    cursor: pointer;
    width:300px;
}
.log {background-color: #ff9800;}
.log:hover {background: #e68a00;}


#result{
	margin:auto;
	width:60%;
}
</style>

<title>내 투표함</title>

<script src="/VotingProject/resources/jquery-3.2.1.min.js"></script>
<script>
$(document).ready(function(){
	$.ajax({
		type : "GET",
		url : "/VotingProject/MyPage_MyVote.jsp",
		dataType:"text",
		success : function(serverdata){
			$("#result").html(serverdata);	
			alert(serveradata);
		}		
	});
});
</script>

</head>

<body>
<h1><b>My Voting</b></h1>
<hr>
<br>
<button class="btn log" onclick="requestAjax1()">내 투표</button>&nbsp;&nbsp;
<button class="btn log" onclick="requestAjax2()">즐겨찾기</button>
<br>
<br>

<div id="result"></div>

<br>
<br>

<br>
<br>
<button class="btn log" onclick="location.href='/VotingProject/CreatePage.jsp'">투표 만들기</button>&nbsp;&nbsp;
<button class="btn log" onclick="location.href='/VotingProject/MainPage.jsp'">메인 화면으로 이동</button>

<script>
function requestAjax1(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		var result = document.getElementById("result");
		if(xhr.status==200&&xhr.readyState == XMLHttpRequest.DONE)
			result.innerHTML = xhr.responseText;
	};
	xhr.open("GET","/VotingProject/MyPage_MyVote.jsp",true);
	xhr.send();
}
function requestAjax2(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		var result = document.getElementById("result");
		if(xhr.status==200&&xhr.readyState == XMLHttpRequest.DONE)
			result.innerHTML = xhr.responseText;
	};
	xhr.open("GET","/VotingProject/MyPage_Favorite.jsp",true);
	xhr.send();
}
</script>

</body>
</html>