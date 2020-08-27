
// dot 생성, 페이징 처리
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


	
// 담아놓기
$(".btn_star").on('click',function(){
	var loginObject = $("#loginId");
	if (loginObject.length == 0) {
		console.log("로그인 되어 있지 않음");
		alert("로그인이 필요한 기능입니다.");
	}
	var login_id = loginObject.text();
	var vote_id = $(this).prev().prev().prev().val();
	var starbtn = $(this);
	$.ajax({
		url:"addbookmark",
		method:"post",
		data:{"bookmarker_id" : login_id, "vote_id" : vote_id},
		success:function(color){		
				if(color=="YES"){
					starbtn.attr("src","/voting/resources/images/Star.png");
				}
				else if(color=="NO"){
					starbtn.attr("src","/voting/resources/images/EmpStar.png");
				}
				else{
					alert("오류입니다.");
				}
			}
			
		}
	)
}
);

var com = document.getElementById('${voteVO.vote_id }');
var btn = document.getElementById("btn_comment");

$(".add_btn").on('click',function(e) {
	e.preventDefault();
	var contents = $(this).prev().val();
	var writer_id = $(this).prev().prev().prev().val();
	var vote_id = $(this).prev().prev().val();
	var targetDivID = "#result" + vote_id;
	var com_cnt = parseInt($(this).parent().parent().parent().prev().children('.btn_comment').next().text());
	var targetCnt = $(this).parent().parent().parent().prev().children('.btn_comment').next();
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
					+ serverdata.time + "</span><input class=\"btn log del_btn\" type=button value=삭제></p><hr>"
				);
				targetCnt.text(com_cnt+1);
			}	
	});//ajax end
})						

// 댓글창 띄우기
$(".btn_comment").on("click",function() {
	$(this).parent().next().css({"display" : "block"});

	var vote_id = $(this).prev().prev().prev().prev().val();
	var targetDivID = "#result" + vote_id;
	
	console.log(vote_id);
	
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
									+ "<input class=\"btn log del_btn\" type=button value=삭제></p><hr>");
					} else {
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
		
// 댓글 삭제
$(".comment-content").on('click',".del_btn",function(){

	var comment_id = $(this).prev().val();
	var deleteTarget = $(this).parent();
	var deleteTarget2 = $(this).parent().next();
	var vote_id = $(this).parent().parent().prev().prev().prev().prev().children().next().val();
	
	var com_cnt = parseInt($(this).parent().parent().parent().parent().prev().children('.btn_comment').next().text());
	var targetCnt = $(this).parent().parent().parent().parent().prev().children('.btn_comment').next();
	
	
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
			
			targetCnt.text(com_cnt-1);
				
		}
			
	})
});

// 댓글창 닫기
$(".close").on("click",function() {	
	$(this).parent().parent().css({"display" : "none"});
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
				like_button.attr("src","/voting/resources/images/Like.jpg");
				count += 1;
				like_count_target.text(count);
			} else if (serverdata.result == "unheart") {
				like_button.attr("src","/voting/resources/images/NoLike.png");
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