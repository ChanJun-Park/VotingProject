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
    width:200px;
}
.log {background-color: #ff9800;}
.log:hover {background: #e68a00;}


/* vote, favorite display  */
.MyVote{
	margin:auto;
	width:450px;
	display:table;
	
}
.MyFavorite{
	margin:auto;
	width:450px;
	display:none;

}
#del {
    width:160px;
    margin-top:10px;
}

/* 항목 버튼  */
.list_check{
	width:200px;
	font-size:20px;
	background: none;
	cursor:pointer;
	border:0;
	outline:0;
	text-align: left;
	font-weight: bold;
}

</style>

<title>내 투표함</title>
</head>

<body>
<h1><b>My Voting</b></h1>
<hr>
<br>
<br>
<button class="btn log" onclick="loadingMyVote()">내 투표</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<button class="btn log" onclick="loadingMyFavorite()">즐겨찾기</button>
<br>
<br>
<br>


<div class="MyVote">
<hr>
<c:forEach var="voteVO" items="${myvotes }">
		<table>
		<tr>
		<td>
		<form action="/voting/search_vote_with_id" method="post">
		<input type=hidden name="vote_id" value="${voteVO.vote_id }"/>
		<input class="list_check" type = submit value="${voteVO.title }"/>
		</form>
		</td>
		<td style="align-content:  center;">
		<form action="/voting/deleteMyvote" method="post">
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
		<td>
		<form action="/voting/search_vote_with_id" method="post">
		<input type=hidden name="vote_id" value="${voteVO.vote_id }"/>
		<input class="list_check" type = submit value="${voteVO.title }"/>
		</form>
		</td>
		<td style="align-content:  center;">
		<form action="/voting/deleteFavorite" method="post">
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


<br>
<br>

<br>
<br>
<table style="width:450px;"><tr>
<td><form action="/voting/create"><input type=submit class="btn log" value="투표 만들기"/></form></td>
<td><form action="/voting/home"><input type=submit class="btn log" value="메인 화면으로 이동"/></form></td>
</tr></table>

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