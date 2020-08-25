package edu.multi.voting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.multi.voting.vote.VoteDAO;
import edu.multi.voting.vote.VoteVO;

@Controller
public class VoteController {
	@Autowired
	VoteDAO dao;
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
}
