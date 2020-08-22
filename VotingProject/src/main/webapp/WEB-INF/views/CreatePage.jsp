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
 	margin : auto;
 	text-align: left;
	
}
td{
	height:25px;
	vertical-align: text-top;
}
input, textarea{
	box-sizing: border-box;
    border: 1px solid #ccc;
    border-radius: 4px;
    font-size: 14px;
	width: 200px;
}
.btn {
    border: none;
    color: white;
    padding: 10px 120px;
    font-size: 16px;
    cursor: pointer;
}
.log {background-color: #ff9800;}
.log:hover {background: #e68a00;}
</style>
<title>투표 만들기</title>
</head>
<body>
<h1><b>내 투표 만들기</b></h1>
<hr>
<br>
<table>
<tr>
<td><h4>Title :&nbsp;&nbsp;</h4></td><td><input type="text" name="title" style="height: 25px;" placeholder="투표 제목 입력" required/></td>
</tr>
<tr>
<td rowspan="2"><h4>Contents :&nbsp;&nbsp;</h4></td>
</tr>
<tr>
<td><textarea rows="6%" cols="30%" placeholder="투표 내용 입력"></textarea></td>
</tr>
<tr>
<td rowspan="4"><h4>Choices :&nbsp;&nbsp;</h4></td>
<td><input type="text" name="title" style="height: 25px;" placeholder=" 1. 첫 번째 답변 입력"/></td>
</tr><tr>
<td><input type="text" name="title" style="height: 25px;" placeholder=" 2. 두 번째 답변 입력"/></td>
</tr><tr>
<td><input type="text" name="title" style="height: 25px;" placeholder=" 3. 세 번째 답변 입력"/></td>
</tr><tr>
<td><input type="text" name="title" style="height: 25px;" placeholder=" 4. 네 번째 답변 입력"/></td>
</tr>
</table>
<br>
<br>
<button class="btn log" onclick="self.close()">추가하기</button>
</body>
</html>