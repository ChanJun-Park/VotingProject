package edu.multi.voting;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
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
	public String mainPage(VoteVO vo, HttpServletRequest req) throws IOException  {
		HttpSession session = req.getSession();
		String loginId = (String) session.getAttribute("loginId");
		vo.setPoster_id(loginId);
		System.out.println(vo);
		int voteid = dao.insertVote(vo);
		System.out.println("voteid 는 "+voteid);
		dao.insertPicks(vo, voteid);
		return "redirect:/home";
	}
	@RequestMapping(value="/create")
	public ModelAndView createPage(HttpServletRequest req) throws IOException {
		
		ModelAndView mv = new ModelAndView();
		HttpSession session = req.getSession();
		String loginId = (String) session.getAttribute("loginId");
		if(loginId==null) {
			mv.addObject("validcheck", "로그인을 먼저 해주세요.");
			mv.setViewName("Login");
		}else {
			mv.setViewName("CreatePage");
		}
		return mv;
	}
	@RequestMapping(value="/deleteMyvote",method=RequestMethod.POST)
	public String deletemyVote(VoteVO vo){
		dao.deleteVote(vo.getVote_id());
		dao.deletePicks(vo.getVote_id());
		return "redirect:/home";
	}
	@RequestMapping(value="/deleteFavorite",method=RequestMethod.POST)
	public String deletemyFavorite(VoteVO vo){
		dao.deleteFavortie(vo.getVote_id());
		return "redirect:/home";
	}
	
	@RequestMapping(value="/likevote", method=RequestMethod.POST)
	@ResponseBody
	public String likevote(String login_id, int vote_id) {
		StringBuilder sb = new StringBuilder();
		sb.append("{\"result\":");
		// 이미 좋아요 눌린적이 있다면
		if (dao.isExistVoteLike(login_id, vote_id)) {
			dao.decreaseVoteLike(vote_id);
			likeVoteDao.deleteVoteLike(login_id, vote_id);
			sb.append("\"unheart\"}");
		} else { // 좋아요 눌린적이 없다면
			dao.increaseVoteLike(vote_id);
			likeVoteDao.insertVoteLike(login_id, vote_id);
			sb.append("\"heart\"}");
		}
		return sb.toString();
	}
}
