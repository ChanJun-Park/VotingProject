<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
<!-- 	<meta name="viewport" content="width=device-width, initial-scale=1.0"> -->
	<link rel="stylesheet" type="text/css" href="/voting/resources/css/voting.css">
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
		<td class="td2"><h1><a href="/voting/home" class='no_a_deco'><b>VOTE;즐거운참견</b></a></h1></td>
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
				<span><a href="/voting/logout/" class="no_a_deco">로그아웃</a></span>
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
								<input class="btn log participate_btn" type=submit value="참여완료" disabled />
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
				<c:if test="${voteVO.userLikeStatus==true }">
			    <img class="btn_good" src="/voting/resources/images/Like.jpg">
			    </c:if>
			    <c:if test= "${voteVO.userLikeStatus==false }">
			    <img class ="btn_good" src = "/voting/resources/images/NoLike.png">
			    </c:if>
				<span >${voteVO.like_count }</span>
				<!-- 준희- 여기!@!@ -->
				<c:if test="${voteVO.userBookmarkStatus==true }">
			    <img class="btn_star" src="/voting/resources/images/Star.png">
			    </c:if>
			    <c:if test= "${voteVO.userBookmarkStatus==false }">
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
	<script src="/voting/resources/js/voting.js"></script>
</body>
</html>