<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
/* header */
table {
	margin:auto;
	table-layout: fixed;
	width:75%;
	}
.td1{text-align: left;}
.td2{text-align: center;}
.td3{text-align: right;}
.td4{
	text-align: center;
	color: gray;
}

/* Search */
input[name=search] {
	width: 170px;
    box-sizing: border-box;
    border: 1px solid #ccc;
    border-radius: 4px;
    font-size: 12px;
    background-color: white;
    background-image: url('/project/resources/images/Search.png');
    background-position: 10px 3px; 
    background-repeat: no-repeat;
	background-size : 14px 14px;
	padding: 4px 5px 4px 30px;
}

/* 질문 */
.q{
	padding-left: 130px;
}

/* 페이지(슬라이드), 버튼  */
* {box-sizing:border-box}
body {font-family: Verdana,sans-serif;margin:0}
.mySlides {display:none}
.slideshow-container {
  max-width:800px;
  position: relative;
  margin: auto;
}
.btn{
	width: 100%;
	text-align: center;
	cursor: pointer;
	border: solid;
	border-color:white;
	border-width:1px;
    color: white;
    padding: 10px 16px;
    font-size: 16px;
}
.log {
background-color: #ff9800;
width:35%;
height:45px;
}
.log:hover {background: #e68a00;}
.box{
	text-align:center;
}

/* 페이지 번호*/
.numbertext {
  color:gray;
  font-size: 12px;
  padding: 8px 12px;
  position: absolute;
  top: 0;
}
/* 페이지 넘기기 */
.dot {
  cursor:pointer;
  height: 13px;
  width: 13px;
  margin: 0 2px;
  background-color: #bbb;
  border-radius: 50%;
  display: inline-block;
  transition: background-color 0.6s ease;
}
.active, .dot:hover {
  background-color: #717171;
}
.fade {
  -webkit-animation-name: fade;
  -webkit-animation-duration: 1.5s;
  animation-name: fade;
  animation-duration: 1.5s;
}
@-webkit-keyframes fade {
  from {opacity: .4} 
  to {opacity: 1}
}
@keyframes fade {
  from {opacity: .4} 
  to {opacity: 1}
}


</style>
<title>메인 페이지</title>
</head>
<body>

<header>
<br>
<br>
<br>
<table>
<tr>
<td class="td1"><input type="text" name="search" placeholder="Search.."></td>
<td class="td2"><h1><b>VOTE</b></h1></td>
<td class="td3"><a href="/project/CreatePage.jsp"><img src="/project/resources/images/Create.png" width="33" height="33" style="padding-top:1px;"></a>&nbsp;
<a href="/project/Mypage.jsp"><img src="/project/resources/images/Mypage.png" width="30" height="30" style=" padding-bottom:2px;"></a></td></tr>
<tr><td colspan="3" class="td4"><h4>당신의 선택은?? 투표를 해주세요 :) </h4></td></tr>
</table>
</header>
<section class="menu1">
<br>
<br>
<br>
<div class="slideshow-container">
  <div class="mySlides fade">
    <div class="numbertext">1 / 3</div>
    <br>
    <h2 class="q">오늘 점심 투표해주세요..</h2>
    <div class="box"><input class="btn log" type=button value="짜장면" /><input class="btn log" type=button value="짬뽕"/></div>
    <div class="box"><input class="btn log" type=button value="마라탕" /><input class="btn log" type=button value="볶음밥"/></div>
    <br>
    <h2 class="q">오늘 점심 투표해주세요..</h2>
    <div class="box"><input class="btn log" type=button value="짜장면" /><input class="btn log" type=button value="짬뽕"/></div>
    <div class="box"><input class="btn log" type=button value="마라탕" /><input class="btn log" type=button value="볶음밥"/></div>
    <br>
    <h2 class="q">오늘 점심 투표해주세요..</h2>
    <div class="box"><input class="btn log" type=button value="짜장면" /><input class="btn log" type=button value="짬뽕"/></div>
    <div class="box"><input class="btn log" type=button value="마라탕" /><input class="btn log" type=button value="볶음밥"/></div>
  </div>
  <div class="mySlides fade">
    <div class="numbertext">2 / 3</div>
    <h2 class="q">오늘 치킨은?</h2>
    <div class="box"><input class="btn log" type=button value="후라이드"/>&nbsp;&nbsp;&nbsp;vs&nbsp;&nbsp;&nbsp;<input class="btn log" type=button value="양념"/></div>
    <br>
  </div>
	<div class="mySlides fade">
    <div class="numbertext">3 / 3</div>
    <h2 class="q">오늘 점심은?</h2>
    <div class="box"><input class="btn log" type=button value="순두부찌개"/>&nbsp;&nbsp;&nbsp;vs&nbsp;&nbsp;&nbsp;<input class="btn log" type=button value="김치찌개"/></div>
    <br>
	</div>
</div>
<br>
<br>
<div style="text-align:center">
 	<span class="dot" onclick="currentSlide(1)"></span> 
 	<span class="dot" onclick="currentSlide(2)"></span> 
	<span class="dot" onclick="currentSlide(3)"></span> 
</div>
<br>
<br>
<br>

<script>
var slideIndex = 1;
showSlides(slideIndex);
function currentSlide(n) {
	  showSlides(slideIndex = n);
}
function showSlides(n) {
	  var i;
	  var slides = document.getElementsByClassName("mySlides");
	  var dots = document.getElementsByClassName("dot");
	  if (n > slides.length) {slideIndex = 1} 
	  if (n < 1) {slideIndex = slides.length}
	  for (i = 0; i < slides.length; i++) {
	      slides[i].style.display = "none"; 
	  }
	  for (i = 0; i < dots.length; i++) {
	      dots[i].className = dots[i].className.replace(" active", "");
	  }
	  slides[slideIndex-1].style.display = "block"; 
	  dots[slideIndex-1].className += " active";
}
</script>


</section>
</body>
</html>