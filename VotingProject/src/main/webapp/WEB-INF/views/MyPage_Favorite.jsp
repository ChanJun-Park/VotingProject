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
}

/* 버튼 효과 */
.btn {
    border: none;
    color: white;
    padding: 10px 16px;
    font-size: 16px;
    cursor: pointer;
}
#chk {
    width:160px;
    margin-top:10px;
}
.log {background-color: #ff9800;}
.log:hover {background: #e68a00;}

</style>
<title>즐겨찾기</title>
</head>
<body>


<hr>
<table>
<tr>
<td>오늘 야식 무엇
</td>
<td>
<button id="chk" class="btn log" onclick="">확인하러가기</button>
</td>
</tr>
</table>
<br>
<hr>


</body>
</html>