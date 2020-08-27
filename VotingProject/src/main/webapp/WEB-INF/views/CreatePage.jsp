<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="/voting/resources/css/createpage.css"> 
	<title>투표 만들기</title>
</head>
<body>
<h1><b>내 투표 만들기</b></h1>
<hr>
<br>
<form action="/voting/addvote" method="post">
	<table>
	<tr>
		<td><h4>Title :&nbsp;&nbsp;</h4></td><td><input type="text" name="title" style="height: 25px;" placeholder="투표 제목 입력" required/></td>
	</tr>
	<tr>
		<td rowspan="2"><h4>Contents :&nbsp;&nbsp;</h4></td>
	</tr>
	<tr>
		<td><textarea name="contents" rows="6%" cols="30%" placeholder="투표 내용 입력"></textarea></td>
	</tr>
	<tr>
		<td rowspan="4"><h4>Choices :&nbsp;&nbsp;</h4></td>
		<td><input name="content1" type="text" style="height: 25px;" placeholder=" 1. 첫 번째 답변 입력" required/></td>
	</tr>
	<tr>
		<td><input name="content2" type="text" style="height: 25px;" placeholder=" 2. 두 번째 답변 입력"/></td>
	</tr>
	<tr>
		<td><input name="content3" type="text" style="height: 25px;" placeholder=" 3. 세 번째 답변 입력"/></td>
	</tr>
	<tr>
		<td><input name="content4" type="text"  style="height: 25px;" placeholder=" 4. 네 번째 답변 입력"/></td>
	</tr>
	</table>
<br>
<br>
<input type=submit class="btn log" value="투표 추가하기"/>
</form>
</body>
</html>