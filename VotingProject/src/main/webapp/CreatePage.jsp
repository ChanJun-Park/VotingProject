<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
header, section {
	text-align: center;
	align-content: center;
}
.btn {
    border: none;
    color: white;
    padding: 10px 16px;
    font-size: 16px;
    cursor: pointer;
}
.log {background-color: #ff9800;}
.log:hover {background: #e68a00;}
</style>
<title>Insert title here</title>
</head>
<body>
<header>
<h1><b>내 투표 만들기</b></h1>
<hr>
</header>
<section>
<h4>Title : </h4>
<input type="text" name="title"/>
<div><h4>Contents :</h4></div><div><textarea rows="10%" cols="30%"></textarea></div>
<h4>Choices :</h4>
1 . <input type="text" name="title" width="30px"/><br>
2 . <input type="text" name="title" width="30px"/><br>
3 . <input type="text" name="title" width="30px"/><br>
4 . <input type="text" name="title" width="30px"/><br>
</section>
<section>
<br>
<button class="btn log" onclick="self.close()">추가하기</button>
</section>
</body>
</html>