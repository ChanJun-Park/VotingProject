<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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


.MyVote{
	margin:auto;
	width:60%;
	
}
.MyFavorite{
	margin:auto;
	width:60%;
	display:none;

}
#del, #chk {
    width:160px;
    margin-top:10px;
}



</style>

<title>내 투표함</title>
</head>

<body>
<h1><b>My Voting</b></h1>
<hr>
<br>
<button class="btn log" onclick="loadingMyVote()">내 투표</button>&nbsp;&nbsp;
<button class="btn log" onclick="loadingMyFavorite()">즐겨찾기</button>
<br>
<br>


<div class="MyVote">
<hr>
<c:forEach var="voteVO" items="${myvotes }">
		<table>
		<tr>
		<td>${voteVO.title }</td>
		<td style="align-content:  center;">
		<form action="/voting/deletevote" method="get">
		<input type=hidden name="vote_id" value="${voteVO.vote_id }"/>
		<input type=submit id="del" class="btn log" value="삭제"/>
		</form>
		</td>
		</tr>
		</table>
		<br>
		<hr>
</c:forEach>
</div>
<div class="MyFavorite">
<hr>
<c:forEach var="voteVO" items="${myfavorites }">
		<table>
		<tr>
		<td>${voteVO.title }</td>
		<td style="align-content:  center;">
		<form action="/voting/deletevote" method="get">
		<input type=hidden name="vote_id" value="${voteVO.vote_id }"/> <!-- 이거 맞나; 이부분 수정 필요 !  -->
		<input type=submit id="chk" class="btn log" value="확인하러가기"/>
		</form>
		</td>
		</tr>
		</table>
		<br>
		<hr>
</c:forEach>
</div>


<br>
<br>

<br>
<br>
<button class="btn log" onclick="location.href='/VotingProject/CreatePage.jsp'">투표 만들기</button>&nbsp;&nbsp;
<button class="btn log" onclick="location.href='/VotingProject/MainPage.jsp'">메인 화면으로 이동</button>

<script>
var vote = document.getElementsByClassName("MyVote")[0];
var favorite = document.getElementsByClassName("MyFavorite")[0];
function loadingMyVote(){
	favorite.style.display="none";
	vote.style.display="table";
}
function loadingMyFavorite(){
	favorite.style.display="table";
	vote.style.display="none";
}
</script>

</body>
</html>