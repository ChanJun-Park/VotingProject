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
	text-align: right;
	width:600px;
	height:70%;
	
}
tr td:first-child{
	text-align: left;
	font-weight: bold;
	width:70%;
}

/* 버튼 효과 */
.btn {
    border: none;
    color: white;
    padding: 10px 16px;
    font-size: 16px;
    cursor: pointer;
}
#upd,#del{
    width:70px;
    margin-top:10px;
}
.log {background-color: #ff9800;}
.log:hover {background: #e68a00;}

</style>
<title>내 투표</title>
</head>
<body>


<hr>
<table>
<tr>
<td>오늘 점심투표해주세요..
</td>
<td style="align-content:  center;">
<form action="/voting/deletevote" method="get">
<input type=button id="del" class="btn log" value="삭제"/>
</form>
</td>
</tr>
</table>
<br>
<hr>


<table>
<tr>
<td>오늘 점심투표해주세요..
</td>
<td>
<button id="del" class="btn log" onclick="">삭제</button>
</td>
</tr>
</table>
<br>
<hr>


</body>
</html>