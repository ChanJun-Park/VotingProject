<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="/voting/resources/css/mypage.css">
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
<c:if test = "${empty myvotes }">
	<h3> 투표함이 비어있어요ㅜ_ㅜ <br> 투표를 만들어주세요!</h3>
</c:if>
<c:if test = "${!empty myvotes }">
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
</c:if>
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
<table style="width:450px;">
	<tr>
		<td><form action="/voting/create"><input type=submit class="btn log" value="투표 만들기"/></form></td>
		<td><form action="/voting/home"><input type=submit class="btn log" value="메인 화면으로 이동"/></form></td>
	</tr>
</table>


<!-- jQuery 인클루드 -->
<script src="/voting/resources/jquery-3.2.1.min.js"></script>
<script src="/voting/resources/js/mypage.js"></script>
</body>
</html>