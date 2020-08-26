<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
/* header */
table {
	margin: auto;
	table-layout: fixed;
	width:75%;
	}
.td1{text-align: left;}
.td2{width:56%; text-align: center;}
.td3{width:7%; text-align: right;}
.td4{width:7%; text-align: center;}
.td5{width:8%; text-align: right;}
.td6{
	text-align: center;
	padding-left:130px;
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
	background-image: url('/voting/resources/images/Search.png');
	background-position: 10px 3px;
	background-repeat: no-repeat;
	background-size: 14px 14px;
	padding: 4px 5px 4px 30px;
}

/* 투표 레이어 */
.new_vote {
	border: solid;
	margin-left: 90px;
	margin-right: 90px;
	margin-top: 10px;
	margin-bottom: 20px;
	padding-bottom: 40px;
}

/* 질문 */
.q {
	padding-left: 90px;
}
/* 좋아요, 댓글 이미지 */
.btn_good, .btn_comment, .btn_star {
	width: 25px;
	height: 25px;
	cursor: pointer;
}

.box_ex {
	padding-top: 13px;
	width: 70%;
	margin: auto;
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
	background-color: rgb(0, 0, 0);
	background-color: rgba(0, 0, 0, 0.4);
}

.comment-content {
	position: relative;
	background-color: #fefefe;
	margin: auto;
	padding: 20px;
	border: 1px solid #888;
	width: 60%;
	height: 80%;
	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0
		rgba(0, 0, 0, 0.19);
	-webkit-animation-name: animatetop;
	-webkit-animation-duration: 0.4s;
	animation-name: animatetop;
	animation-duration: 0.4s
}

@-webkit-keyframes animatetop {
	from {top: -300px;
	opacity: 0
}

to {
	top: 0;
	opacity: 1
}

}
@keyframes animatetop {
	from {top: -300px;
	opacity: 0
}

to {
	top: 0;
	opacity: 1
}

}
/* 댓글 창 닫기  */
.close {
	color: #aaaaaa;
	float: right;
	font-size: 28px;
	font-weight: bold;
}

.close:hover, .close:focus {
	color: #000;
	text-decoration: none;
	cursor: pointer;
}

/* 페이지(슬라이드), 버튼  */
* {
	box-sizing: border-box
}

body {
	font-family: Verdana, sans-serif;
	margin: 0
}

.mySlides {
	display: none
}

.slideshow-container {
	max-width: 800px;
	position: relative;
	margin: auto;
}

.btn {
	width: 100%;
	text-align: center;
	cursor: pointer;
	border: solid;
	border-color: white;
	border-width: 3px;
	color: white;
	padding: 8px 20px 15px 20px;
	font-size: 16px;
	font-weight: 290;
	outline:0;
}

.log {
	background-color: #ff9800;
	width: 35%;
	height: 45px;
}

.selected-btn {
	background: #e68a00;
}

.participate {
	background-color: #b5b5b5;
	width: 35%;
	height: 45px;
}

.participate:hover {
	background: #858585;
}

.box {
	text-align: center;
}
/*  참여하기 버튼 */
.participate_btn{
	background-color: gray;
}
.participate_btn:hover{
	background-color: #d3d3d3;
}


/* 페이지 번호*/
.numbertext {
	color: gray;
	font-size: 12px;
	padding: 8px 12px;
	position: absolute;
	top: 0;
}
/* 페이지 넘기기 */
.dot {
	cursor: pointer;
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

to {
	opacity: 1
}
}
@keyframes fade {
	from {opacity: .4}

to {
	opacity: 1
}
}
/* a 태그 텍스트 데코 없애기 */
.no_a_deco {
	text-decoration: none;
	color:black;
}
.container {
    width: 880px;
    height: 400px;
    overflow: auto;
  }
  
 .container::-webkit-scrollbar {
    width: 10px;
    background-color: black;
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
			<form action="/voting/addvote"><input type=image src="/voting/resources/images/Create.png" name="Submit" value="Submit" width="33" height="33" style="padding-top:1px;"/></form>
		</td>			
		<td class="td4">
			<form action="/voting/mypage" method="post"><input type=image src="/voting/resources/images/Mypage.png" name="Submit" value="Submit" width="30" height="30" style=" padding-bottom:2px;"/></form>
		</td>
		<td class="td5">
			<c:if test="${empty sessionScope.loginId}">
				<span><a href="/voting/login/" class="no_a_deco">로그인</a></span>
			</c:if>
			<c:if test="${not empty sessionScope.loginId}">
				<span id="loginId">${sessionScope.loginId}</span><br>
				<span><a href="/voting/loout/" class="no_a_deco">로그아웃</a></span>
			</c:if>
		</td>
	</tr>
	<tr>
		<td colspan="3" class="td6"><h4>당신의 선택은?? 투표를 해주세요 :) </h4></td>
	</tr>
	</table>
</header>
<section class="menu1">
<br>
<br>
<br>
<input id = "total_vote" type =hidden value="${count }"/>
<input id = "slide_idx" type =hidden value="${pageNo }"/>
<div class="slideshow-container">
  <div class="mySlides fade" style="display:block;">
 
    <div class="numbertext">1 / 3</div>
	<c:forEach var="voteVO" items="${votes }">
 		<input type=hidden value="${voteVO.vote_id }" class="miffy"/>
		<article class="new_vote" id="miffy">
			<br>
			<h2 class="q">${voteVO.title }</h2>
			<p class="q">${voteVO.contents }</p>

			<div class="box">
				<div class="box pick_list_wrapper">
			         <c:forEach var="pickVO" items="${voteVO.pickList }">
			  			<c:choose>
			  				<c:when test="${voteVO.userParticipated == true }">
			  					<div class="box">
					               <input class="btn log pick_btn" type=button value="${pickVO.pickName } - ${pickVO.score} 표" />               
					            </div>
			  				</c:when>
			  				<c:otherwise>
			  					<div class="box">
					               <input type=hidden name="pickNo" value="${pickVO.pickNo }"/>
					               <input class="btn log pick_btn" type=button value="${pickVO.pickName }" />               
					            </div>
			  				</c:otherwise>
			  			</c:choose>
			            
			         </c:forEach>
				</div>
					
				<form action="/voting/pick" method="post">
					 <div class="submit_pick_wrapper">
					 	
					 </div>
			         <div class="box">
						<c:choose>
							<c:when test="${voteVO.userParticipated == true }">
								<input class="btn participate_btn" type=submit value="참여완료" disabled />
							</c:when>
							<c:otherwise>
								<input type=hidden name="voteid" value="${voteVO.vote_id }"/>
								<input class="btn log participate_btn" type=submit value="참여하기" />
							</c:otherwise>
						</c:choose>
			         </div>
		        </form>
			</div>

			<div class="box_ex">
				<input type="hidden" name="vote_id" value="${voteVO.vote_id }" />
				<img class="btn_good" src="/voting/resources/images/Like.jpg">
				<span>${voteVO.like_count }</span>
				<!-- 준희- 여기!@!@ -->
				<c:if test="${voteVO.userBookmarkStatus==true }">
			    <img class="btn_star" src="/voting/resources/images/Star.png">
			    </c:if>
			    <c:if test="${voteVO.userBookmarkStatus==false }">
			    <img class ="btn_star" src = "/voting/resources/images/EmpStar.png">
			    </c:if>
			    <!-- 준희 - 여기까지!@@ -->
				<img class="btn_comment"
					src="/voting/resources/images/Comment.png"><span>${voteVO.comment_count }</span>
			</div>

			<!-- 댓글 창 -->
				<div id="${voteVO.vote_id}" class="contentPOP">
					<div class="comment-content">
						<span class="close">&times;</span>
						<form id="add" action="/voting/commentwrite" method="post">
							<input type="hidden" id="writer_id" name="writer_id"value="${sessionScope.loginId }" /> 
							<input type="hidden" id="vote_id" name="vote_id" value="${voteVO.vote_id }" />
							<input id="contents" name="contents" type="text" placeholder=" 댓글을 입력해주세요" style="width: 75%; height: 30px;">&nbsp;&nbsp;
							<input class="btn log add_btn" type=submit value="추가" style="background-color: gray; width: 15%;" />
						</form>
						<br> <br>
						<hr>
						<div id="result${voteVO.vote_id }" class="container" name="result">
						</div>
					</div>
				</div>
		</article>
	</c:forEach>
</div>
</div>
	<div id="dots" style="text-align: center">
	</div>
	<br> <br> <br>
	
	<!-- 	이미지 미리 다운로드 해놓기 -->
	<img class="btn_star" src="/voting/resources/images/Star.png" style="display:none;">
	<img class ="btn_star" src = "/voting/resources/images/EmpStar.png" style="display:none;">
	</section>
	<!-- jQuery 인클루드 -->
	<script src="/voting/resources/jquery-3.2.1.min.js"></script>
	<script>
	// dot 생성
	var vote_id = $("#miffy").prev().val();
	var count_vote = $("#total_vote").val();
		
	var slide_idx = $("#slide_idx").val();
	
	var count_dot= Math.ceil(count_vote/5);
	
	for (var i = 0; i < count_dot; i++) {
		$("#dots").append("<span class=\"dot\" onclick=\"showSlides("+(i+1)+")\"></span>");
	}
	
	
		/* 목록 넣기 */
		var slideIndex = slide_idx;
	
		var dots = document.getElementsByClassName("dot");
		for (i = 0; i < dots.length; i++) {
				dots[i].className = dots[i].className.replace("active", "");
		}
		dots[slideIndex-1].className += " active"; 
		
		function showSlides(n) {
			location.href="/voting/home?pageNo="+n;
			
		}
	
	
	</script>	
	<!-- 댓글창 띄우기 -->
	<script>
	
		var com = document.getElementById('${voteVO.vote_id }');
		var btn = document.getElementById("btn_comment");

		$(".add_btn").on('click',function(e) {
						e.preventDefault();
						var contents = $(this).prev().val();
						var writer_id = $(this).prev().prev().prev().val();
						var vote_id = $(this).prev().prev().val();
						var targetDivID = "#result" + vote_id;
						$.ajax({
								url : '/voting/commentwrite',
								data : {
									'writer_id' : writer_id,
									'vote_id' : vote_id,
									'contents' : contents
								},
								type : 'post',
								dataType : 'json',
								success : function(serverdata) {
						 		console.log(serverdata);
								$(targetDivID).prepend(
								"<p><span style=\"font-size:16px;font-weight: bold;padding-bottom: 10px;\">"
								+ serverdata.writer_id + "</span><br>"+ serverdata.contents
								+ "<br><span style=\"color:gray;font-size:10px;\">"
								+ serverdata.time + "</span><input class=\"del_btn\" type=button value=삭제></p><hr>");
									} 
									//$(".btn_comment").trigger("click");
									
								});//ajax end
						})
						
		$(".btn_comment").on("click",function() {
							$(this).parent().next().css({"display" : "block"});

							var vote_id = $(this).prev().prev().prev().val();
							var targetDivID = "#result" + vote_id;
							// 투표와 관련된 댓글 리스트 불러오기dd
// 							this.자바스크립트 
// 							$(this).jquery 함수 -
			/* 				var x_btn = document.getElementsByClassName("close")[0];
							x_btn.onclick = function(){
								com.style.display="none";
							} */

							$.ajax({
								url : "/voting/commentlist",
								data : {'vote_id' : vote_id	},
								type : "post",
								dataType : "json",
								success : function(serverdata) {	
									$(targetDivID).html("");
										if ($("#loginId").length !=0 ) {
											var loginID = $("#loginId").text();
											
											for (var i = 0; i < serverdata.length; i++) {
												
												if(serverdata[i].writer_id == loginID){
												$(targetDivID).append("<p><span style=\"font-size:16px;font-weight: bold;padding-bottom: 10px;\">"
															+ serverdata[i].writer_id + "</span><br>" + serverdata[i].contents
															+ "<br><span style=\"color:gray;font-size:10px;\">"
															+ serverdata[i].time + "</span>" 
															+ "<input type=hidden value=" + serverdata[i].comment_id + ">"
															+ "<input class=\"del_btn\" type=button value=삭제></p><hr>");
												}else{
												$(targetDivID).append("<p><span style=\"font-size:16px;font-weight: bold;padding-bottom: 10px;\">"
															+ serverdata[i].writer_id + "</span><br>" + serverdata[i].contents
															+ "<br><span style=\"color:gray;font-size:10px;\">"
															+ serverdata[i].time + "</span></p><hr>");
												}
															
													}//for end
											}// if end
											else {
												for (var i = 0; i < serverdata.length; i++) {
													
													$(targetDivID).append("<p><span style=\"font-size:16px;font-weight: bold;padding-bottom: 10px;\">"
																+ serverdata[i].writer_id + "</span><br>" + serverdata[i].contents
																+ "<br><span style=\"color:gray;font-size:10px;\">"
																+ serverdata[i].time + "</span></p><hr>");
						
																
												}//for end
											}
										}
									})
						});
		
		
		$(".comment-content").on('click',".del_btn",function(){
// 			console.log("삭제 버튼 눌림");
			var comment_id = $(this).prev().val();
			var deleteTarget = $(this).parent();
			var deleteTarget2 = $(this).parent().next();
			var vote_id = $(this).parent().parent().prev().prev().prev().prev().children().next().val();
			console.log(comment_id);
			$.ajax({
				url : "/voting/commentdelete",
				data : {'comment_id' : comment_id, 'vote_id' : vote_id},
				type : "post",
				dataType : "json",
				success : function(serverdata){
					console.log(serverdata);
					if (serverdata.result == "ok"){
						deleteTarget.remove();
						deleteTarget2.remove();
					}
						
						
				}
					
			})
		});
		
		$(".close").on("click",function() {	
			$(this).parent().parent().css({"display" : "none"});
			window.setTimeout(function(){
				window.location.reload()
			}, 1);
		});
		$(".comment").on("click", ".close", function() {
			$(this).parent().parent().css({
				"display" : "none"
			});
		});

		// 투표 좋아요 기능
		$(".btn_good").on("click", function() {
			// 로그인이 되어 있는지 체크
			if ($("#loginId").length == 0) {
				alert("로그인이 필요한 기능입니다");
				return;
			}
			var login_id = $("#loginId").text();
			var vote_id = $(this).prev().val();
			var like_count_target = $(this).next();
			var like_button = $(this);
			
			// 투표 좋아요 카운트 증가
			// 투표에 좋아요 증가
			$.ajax({
				url : '/voting/likevote',
				data : {'login_id':login_id, 'vote_id': vote_id},
				type : 'post',
				dataType : 'json',
				success : function(serverdata) {
					console.log(serverdata);
					var count = parseInt(like_count_target.text());
					
					if (serverdata.result == "heart") {
						count += 1;
						like_count_target.text(count);
					} else if (serverdata.result == "unheart") {
						count -= 1;
						like_count_target.text(count);
					}
				},
				error : function(e) {
					console.log(e);
				}, 
				complete : function() {

				}
			});// ajax end
		});

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
		
		// 투표 항목 선택시 서버에 전송할 준비하기
		$(".pick_btn").on("click", function() {
			var selected_pick_input = $(this).prev().clone();
			var pick_list_wrapper = $(this).closest(".pick_list_wrapper");
			var submit_pick_wrapper = pick_list_wrapper.next().children(".submit_pick_wrapper");
			
			console.log(pick_list_wrapper);
			
			// 기존에 있던 input pick 지우기
			submit_pick_wrapper.html("");
			
			// 지금 선택된 요소 넣기
			submit_pick_wrapper.append(selected_pick_input);
			
			// 선택된 요소 버튼 색깔 바꾸고, 나머지는 선택 안됨 색깔로 바꾸기
			toggleButtonStatus(pick_list_wrapper, $(this));
		});
		
		function toggleButtonStatus(pick_list_wrapper, selected_btn) {
			
			pick_list_wrapper.children().each(function(index, item){
				console.log($(item).children(".pick_btn"));
				$(item).children(".pick_btn").removeClass("selected-btn");
			});
			
			selected_btn.addClass("selected-btn");
		}
		
		// 투표 참여하기
		$(".participate_btn").on("click", function(e) {
			// 로그인 했고, 참여한적이 없으며, 선택한 내용이 있어야 투표를 참여할 수 있도록 하기
			e.preventDefault();
			
			// 로그인이 되어 있는지 체크
			if ($("#loginId").length == 0) {
				alert("로그인이 필요한 기능입니다");
				return;
			}
			var submit_pick_wrapper = $(this).parent().prev();
			var participate_btn = $(this);
			var pick_list_wrapper = $(this).parent().parent().prev();
			

			// submit_pick_wrapper에 선택된 내용이 추가되어 있는지 체크
			var picked_input = submit_pick_wrapper.children();
			if (picked_input.length == 0) {
				alert("투표하실 항목을 선택해주세요!");
				return;
			}
			
			var login_id = $("#loginId").text();
			var vote_id = $(this).prev().val();
			var pick_no = picked_input.val();
			
			console.log(login_id);
			console.log(vote_id);
			console.log(pick_no);
			
						
			$.ajax({
				url : "/voting/participate",
				data : {'participant_id' : login_id, 
						'vote_id' : vote_id,
						'pick_no' : pick_no},
				type : "post",
				dataType : "json",
				success : function(serverdata) {
					if (serverdata.result == "fail") {
						console.log(serverdata.errorMsg);
						return;
					}
					
					console.log(serverdata);
					
					var vote = serverdata.vote;
					var pickList = vote.pickList;
					
					pick_list_wrapper.children(".box").each(function(index, elem){
						var pickName = pickList[index].pickName;
						var score = pickList[index].score;
						$(elem).children(".pick_btn").val(pickName + " - " + score + "표");
					});
					
					participate_btn.attr({"disabled":"disabled"});
					participate_btn.val("참여 완료");
				},
				error : function(e) {
					console.log(e);
				}, 
				complete : function() {

				}
			});
			
		});
	</script>

</body>
</html>