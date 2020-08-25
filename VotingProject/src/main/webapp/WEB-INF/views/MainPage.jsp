<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
.td2{width:72%; text-align: center;}
.td3{width:7%; text-align: right;}
.td4{width:7%; text-align: right;}
.td5{
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
    background-image: url('/VotingProject/resources/images/Search.png');
    background-position: 10px 3px; 
    background-repeat: no-repeat;
	background-size : 14px 14px;
	padding: 4px 5px 4px 30px;
}

/* 투표 레이어 */
.new_vote{
	border:solid;
	margin-left:90px;
	margin-right:90px;
	margin-top: 10px;
	margin-bottom: 20px;
	padding-bottom:40px;
}

/* 질문 */
.q{
	padding-left: 90px;
}
/* 좋아요, 댓글 이미지 */
.btn_good, .btn_comment, .btn_star{
	width: 25px;
	height:25px;
	cursor: pointer;
}
.box_ex{
	padding-top:13px;
	width:70%;
	margin:auto;
	text-align: left;
}

/* 댓글 창  */
.contentPOP {
    display: none; 
    position: fixed; 
    z-index: 1; 
    padding-top: 100px; 
    left: 0;
    top: 0;
    width: 100%; 
    height: 100%;
    overflow: auto; 
    background-color: rgb(0,0,0);
    background-color: rgba(0,0,0,0.4);
}
.comment-content {
position: relative;
    background-color: #fefefe;
    margin: auto;
    padding: 20px;
    border: 1px solid #888;
    width: 60%;
    height:80%;
 	box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2),0 6px 20px 0 rgba(0,0,0,0.19);
    -webkit-animation-name: animatetop;
    -webkit-animation-duration: 0.4s;
    animation-name: animatetop;
    animation-duration: 0.4s
}
@-webkit-keyframes animatetop {
    from {top:-300px; opacity:0} 
    to {top:0; opacity:1}
}

@keyframes animatetop {
    from {top:-300px; opacity:0}
    to {top:0; opacity:1}
}
/* 댓글 창 닫기  */
.close {
    color: #aaaaaa;
    float: right;
    font-size: 28px;
    font-weight: bold;
}

.close:hover,
.close:focus {
    color: #000;
    text-decoration: none;
    cursor: pointer;
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
	border-width:3px;
    color: white;
    padding:8px 20px 15px 20px;
    font-size: 16px;
    font-weight: 290;
}
.log {
background-color: #ff9800;
width:35%;
height:45px;
}
.log:hover {background: #e68a00;}

.participate {
	background-color: #b5b5b5;
	width:35%;
	height:45px;
}
.participate:hover {background: #858585;}

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

/* a 태그 텍스트 데코 없애기 */
.no_a_deco {
	text-decoration: none;
	color:black;
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
		<td class="td1"><input id="votesearch" type="text" name="search" placeholder="Search.."></td>
		<td class="td2"><h1><a href="/voting/home" class='no_a_deco'><b>VOTE</b></a></h1></td>
		<td class="td3">
			<form action="/voting/addvote"><input type=image src="/voting/resources/images/Create.png" name="Submit" value="Submit" width="33" height="33" style="padding-top:1px;"/></form>&nbsp;
			<form action="/voting/mypage" method="post"><input type=image src="/voting/resources/images/Mypage.png" name="Submit" value="Submit" width="30" height="30" style=" padding-bottom:2px;"/></form>
			<c:if test="${empty sessionScope.loginId}">
				<span><a href="/voting/login/" class="no_a_deco">로그인</a></span>
			</c:if>
			<c:if test="${not empty sessionScope.loginId}">
				<span id="loginId">${sessionScope.loginId}</span>
				<span><a href="/voting/loout/" class="no_a_deco">로그아웃</a></span>
			</c:if>
		</td>
	</tr>
	<tr>
		<td colspan="3" class="td4"><h4>당신의 선택은?? 투표를 해주세요 :) </h4></td>
	</tr>
	</table>
</header>
<section class="menu1">
<br>
<br>
<br>
<div class="slideshow-container">
  <div class="mySlides fade">
  
    <div class="numbertext">1 / 3</div>

	<c:forEach var="voteVO" items="${votes }">
	    <article class="new_vote" id="vote${voteVO.vote_id }">
		    <br>
		    <h2 class="q">${voteVO.title }</h2>
		    <p class="q">${voteVO.contents }</p>
		    <c:forEach var="pickVO" items="${voteVO.pickList }">
		    	<div class="box">
		    		<input id="picklist" class="btn log" type=button value="${pickVO.pickName }" />
		    	</div>	
		    </c:forEach>
		    
		    <div class="box">
		    	<input class="btn participate" type=button value="참여하기" />
		    </div>
		    
		    <div class="box_ex">
    		    <input type="hidden" name="vote_id" value="${voteVO.vote_id }"/>
			    <img class="btn_good" src="/voting/resources/images/Like.jpg">${voteVO.like_count }
			    <img class="btn_star" src="/voting/resources/images/Star.png">
			    <img class="btn_comment" src="/voting/resources/images/Comment.png">${voteVO.comment_count }
		    </div>
		    
		    <!-- 댓글 창 -->
		    <div class="comment contentPOP">
			    <div class="comment-content">
			    	<span class="close">&times;</span>
			    	<input type="text" placeholder=" 댓글을 입력해주세요" style="width:75%;height:30px;">&nbsp;&nbsp;
			    	<input class="btn log" type=button value="추가" style="background-color:gray;width:15%;" />
			    	<br>
			    	<br>
			    	<div id="comment-list">
			    		<hr>
				    	<p><span style="font-size:16px;font-weight: bold;padding-bottom: 10px;">홍길동</span><br>
				    	배고푸다;<br>
				    	<span style="color:gray;font-size:10px;">2020.08.22</span></p>
				    	<hr>
				    	<p><span style="font-size:16px;font-weight: bold;padding-bottom:10px;">김길동</span><br>
				    	짜장면 시키신 분~<br>
				    	<span style="color:gray;font-size:10px;">2020.08.22</span></p>
				    	<hr>
			    	</div>
			    </div>
		    </div>
	    </article>
	</c:forEach>
  
  <div class="mySlides fade">
    <div class="numbertext">2 / 3</div>
    <article class="new_vote">
    <br>
    <h2 class="q">오늘 야식 투표해주세요..</h2>
    <div class="box"><input class="btn log" type=button value="치킨" /><input class="btn log" type=button value="보쌈"/></div>
    <div class="box"><input class="btn log" type=button value="피자" /><input class="btn log" type=button value="라면"/></div>
    <div class="box_ex">
    <img class="btn_good" src="/VotingProject/resources/images/Like.jpg">
    <img class="btn_star" src="/VotingProject/resources/images/Star.png">
    <img class="btn_comment" src="/VotingProject/resources/images/Comment.png" id="btn_comment" >
    </div>
    </article>
  </div>
   
   
  <div class="mySlides fade">
    <div class="numbertext">3 / 3</div>
    <article class="new_vote">
    <br>
    <h2 class="q">오늘의 치킨 무엇</h2>
    <div class="box"><input class="btn log" type=button value="후라이드" /><input class="btn log" type=button value="양념"/></div>
    <div class="box"><input class="btn log" type=button value="간장" /><input class="btn log" type=button value="뿌링클"/></div>
    <div class="box_ex">
    <img class="btn_good" src="/VotingProject/resources/images/Like.jpg">
    <img class="btn_star" src="/VotingProject/resources/images/Star.png">
    <img class="btn_comment" src="/VotingProject/resources/images/Comment.png" id="btn_comment" >
    </div>
    </article>
  </div>
</div>
<br>
<br>
<div style="text-align:center">
 	<span class="dot" onclick="currentSlide(1)"></span> 
 	<span class="dot" onclick="currentSlide(2)"></span> 
	<span class="dot" onclick="currentSlide(3)"></span> 
</div>
</div>
<br>
<br>
<br>
</section>
<!-- jQuery 인클루드 -->
<script src="/voting/resources/jquery-3.2.1.min.js"></script>
<!-- 페이지 넘기기 -->
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
<!-- 댓글창 띄우기 -->
<script>
var com = document.getElementById("comment");
var btn = document.getElementById("btn_comment");
var x_btn = document.getElementsByClassName("close")[0];

$(".btn_comment").on("click", function() {
	$(this).parent().next().css({"display":"block"});
	
	var vote_id = $(this).prev().prev().prev().val();
	// 투표와 관련된 댓글 리스트 불러오기dd
});

$(".comment").on("click", ".close", function() {
	$(this).parent().parent().css({"display":"none"});
});

$(".btn_good").on("click", function() {
	console.log("좋아요 버튼 클릭됨");
	// 로그인이 되어 있는지 확인
	var loginObject = $("#loginId");
	if (loginObject.length == 0) {
		console.log("로그인 되어 있지 않음");
		alert("로그인이 필요한 기능입니다.");
		return;
	}
	
	var login_id = loginObject.text();
	var vote_id = $(this).prev().val();
	// 투표 좋아요 카운트 증가
	// 투표에 좋아요 증가
	$.ajax({
		url : '/voting/likevote',
		data : {'login_id':login_id, 'vote_id': vote_id},
		type : 'post',
		dataType : 'json',
		success : function(serverdata) {
			
		},
		error : function() {
				
		}, 
		complete : function() {
				
		}
	});// ajax end
});

// x_btn.onclick = function(){
// 	com.style.display="none";
// }
// window.onclick = function(event) {
//     if (event.target == com) {
//         com.style.display = "none";
//     }
// }

// 투표 검색 리스트 보여주기
$("#votesearch").on("keydown", function(e) {
	// 엔터키가 눌린건지 체크
	if (e.keyCode == 13) {
		// 검색 창에 입력된 문자열 가져오기
		var searchTargetStr = $(this).val();
		console.log(searchTargetStr);
		location.href="/voting/search?searchTargetStr=" + searchTargetStr; 
	}
	
});
</script>

</body>
</html>