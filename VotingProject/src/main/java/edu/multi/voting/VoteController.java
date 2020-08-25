package edu.multi.voting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.multi.voting.likevote.LikeVoteDAO;
import edu.multi.voting.vote.VoteDAO;
import edu.multi.voting.vote.VoteVO;

@Controller
public class VoteController {
	@Autowired
	VoteDAO dao;
	
	@Autowired
	LikeVoteDAO likeVoteDao;
	
	@RequestMapping(value="/addvote",method=RequestMethod.GET)
	public String createPage(){
		return "CreatePage";
	}
	@RequestMapping(value="/addvote", method=RequestMethod.POST)
	public String mainPage(VoteVO vo) {
		dao.insertVote(vo);
		dao.insertPicks(vo);
		return "MainPage";
	}
	@RequestMapping(value="/deletevote",method=RequestMethod.POST)
	public String deletemyPage(VoteVO vo){
		dao.deleteVote(vo);
		return "Mypage";
	}
	
//	@RequestMapping(value="/likevote", method=RequestMethod.POST)
//	@ResponseBody
//	public String likevote(String login_id, int vote_id) {
//		// 이미 좋아요 눌린적이 있다면
//		if (dao.checkVoteLike(login_id, vote_id)) {
//			dao.decreaseVoteLike(vote_id);
//			likeVoteDao.deleteVoteLike(login_id, vote_id);
//		} else { // 좋아요 눌린적이 없다면
//			dao.increaseVoteLike(vote_id);
//			likeVoteDao.insertVoteLike(login_id, vote_id);
//		}
//	}
}
