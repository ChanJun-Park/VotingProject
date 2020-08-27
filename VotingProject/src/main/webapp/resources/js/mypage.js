// 마이 페이지 처리
var vote = document.getElementsByClassName("MyVote")[0];
var favorite = document.getElementsByClassName("MyFavorite")[0];
function loadingMyVote(){
	favorite.style.display="none";
	vote.style.display="table";
}
function loadingMyFavorite(){
	favorite.style.display="table";
	vote.style.display="none";
}