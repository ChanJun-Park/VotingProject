package edu.multi.voting;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.multi.voting.users.UsersVO;
import edu.multi.voting.vote.VoteDAO;
import edu.multi.voting.vote.VoteVO;

@Controller
public class MyPageController {
	@Autowired
	private VoteDAO voteDAO;
	
	@RequestMapping(value="/mypage", method=RequestMethod.POST)
	public ModelAndView myVoteLoading(UsersVO vo, HttpServletRequest req) {
		
		ModelAndView mv = new ModelAndView();
	    HttpSession session = req.getSession();
	    String loginId = (String) session.getAttribute("loginId");
	    
	    
		//내 투표 리스트 로딩
		ArrayList<VoteVO> votes = voteDAO.getMyVoteList(vo.getUser_id());
		//즐겨찾기 로스트 로딩
		ArrayList<VoteVO> favorites = voteDAO.getMyFavoriteList(vo.getUser_id());
		mv.addObject("myvotes", votes);
		mv.addObject("myfavorites",favorites);
		mv.setViewName("Mypage");
		return mv;
	}
}
