<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
header {
	text-align:center;
}
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
article{
	border:solid;
	width: 40%;
}
.q{
	padding-left: 130px;
}
/* 슬라이드 */
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
	border: none;
    color: white;
    padding: 10px 16px;
    font-size: 16px;
}
.log {background-color: #ff9800;}
.log:hover {background: #e68a00;}
.box{
	text-align:center;
}

.numbertext {
  color:BLACK;
  font-size: 12px;
  padding: 8px 12px;
  position: absolute;
  top: 0;
}
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
<input type="text" name="search" placeholder="Search..">
<b style="font-size: 35px;">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
VOTE
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b>
<img src="/project/resources/images/Create.png" width="33" height="33" style="padding-top:1px;">&nbsp;
<img src="/project/resources/images/Mypage.png" width="30" height="30" style=" padding-bottom:2px;">
</header>
<section class="menu1">
<br>
<br>
<br>
<div class="slideshow-container">
  <div class="mySlides fade">
    <div class="numbertext">1 / 3</div>
    
    <br>
    <h2 class="q">오늘 점심은?</h2>
    <div class="box"><input class="btn log" type=button value="짜장면" style="width:30%;"/>&nbsp;&nbsp;&nbsp;vs&nbsp;&nbsp;&nbsp;<input class="btn log" type=button value="짬뽕" style="width:30%;"/></div>
    <br>
    <h2 class="q">오늘 점심은?</h2>
    <div class="box"><input class="btn log" type=button value="짜장면" style="width:30%;"/>&nbsp;&nbsp;&nbsp;vs&nbsp;&nbsp;&nbsp;<input class="btn log" type=button value="짬뽕" style="width:30%;"/></div>
    <br>
    <h2 class="q">오늘 점심은?</h2>
    <div class="box"><input class="btn log" type=button value="짜장면" style="width:30%;"/>&nbsp;&nbsp;&nbsp;vs&nbsp;&nbsp;&nbsp;<input class="btn log" type=button value="짬뽕" style="width:30%;"/></div>
    <br>
    <h2 class="q">오늘 점심은?</h2>
    <div class="box"><input class="btn log" type=button value="짜장면" style="width:30%;"/>&nbsp;&nbsp;&nbsp;vs&nbsp;&nbsp;&nbsp;<input class="btn log" type=button value="짬뽕" style="width:30%;"/></div>
    <br>
  </div>
  <div class="mySlides fade">
    <div class="numbertext">2 / 3</div>
    <h2 class="q">오늘 치킨은?</h2>
    <div class="box"><input class="btn log" type=button value="후라이드" style="width:30%;"/>&nbsp;&nbsp;&nbsp;vs&nbsp;&nbsp;&nbsp;<input class="btn log" type=button value="양념" style="width:30%;"/></div>
    <br>
  </div>
	<div class="mySlides fade">
    <div class="numbertext">3 / 3</div>
    <h2 class="q">오늘 점심은?</h2>
    <div class="box"><input class="btn log" type=button value="순두부찌개" style="width:30%;"/>&nbsp;&nbsp;&nbsp;vs&nbsp;&nbsp;&nbsp;<input class="btn log" type=button value="김치찌개" style="width:30%;"/></div>
    <br>
	</div>
</div>
<br>

<div style="text-align:center">
 	<span class="dot" onclick="currentSlide(1)"></span> 
 	<span class="dot" onclick="currentSlide(2)"></span> 
	<span class="dot" onclick="currentSlide(3)"></span> 
</div>

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