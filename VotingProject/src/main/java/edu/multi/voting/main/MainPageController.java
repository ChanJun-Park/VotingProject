package edu.multi.voting.main;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import edu.multi.voting.bookmark.BookmarkDAO;
import edu.multi.voting.likevote.LikeVoteDAO;
import edu.multi.voting.participate.ParticipateDAO;
import edu.multi.voting.participate.ParticipateVO;
import edu.multi.voting.bookmark.BookmarkVO;
import edu.multi.voting.pick.PickVO;
import edu.multi.voting.vote.VoteDAO;
import edu.multi.voting.vote.VoteVO;

@Controller
public class MainPageController {
	
	@Autowired
	private VoteDAO voteDAO;
	
	@Autowired
	private ParticipateDAO participateDAO;
	
	@Autowired
	private LikeVoteDAO likeVoteDAO;
	
	@Autowired
	private BookmarkDAO bookmarkDAO;
	
	@RequestMapping(value="/home")
	public ModelAndView mainPageLoading(HttpServletRequest req, @RequestParam(value = "pageNo", required = true, defaultValue = "1") int pageNo) {
		ModelAndView mv = new ModelAndView();
		
		HttpSession session = req.getSession();
		String loginId = (String) session.getAttribute("loginId");
		
		// 로그인 확인
		if (loginId == null) {
			mv.setViewName("redirect:/login");
			return mv;
		}
		
		// 전체 투표 개수 계산
		int count = voteDAO.getTotalVoteCount();
		
		// vote 리스트 불러오기
		ArrayList<VoteVO> votes = voteDAO.getEntireVoteList(pageNo);
		
		// 각각의 vote에 해당하는 pick 리스트 불러오기
		for (VoteVO v : votes) {
			if (participateDAO.isExist(loginId, v.getVote_id())) {
				v.setUserParticipated(true);
			}
			if (likeVoteDAO.isExist(loginId, v.getVote_id())) {
				v.setUserLikeStatus(true);
			}
			if (bookmarkDAO.isExist(loginId, v.getVote_id())) {
				v.setUserBookmarkStatus(true);
			}
			
			ArrayList<PickVO> picks = voteDAO.getPickList(v.getVote_id());
			v.setPickList(picks);
		}

		mv.addObject("votes", votes);
		mv.addObject("count", count);
		mv.addObject("pageNo", pageNo);
		mv.setViewName("MainPage");
		return mv;
	}
	
	
	@RequestMapping(value="/search")
	public ModelAndView searchResultLoading(HttpServletRequest req, @RequestParam(required = true) String searchTargetStr) {
		ModelAndView mv = new ModelAndView();
		System.out.println("'"+searchTargetStr+"'");
		
		HttpSession session = req.getSession();
		String loginId = (String) session.getAttribute("loginId");
		
		// 로그인 확인
		if (loginId == null) {
			mv.setViewName("redirect:/login");
			return mv;
		}
		
		
		// 검색된 정보에 대한 vote 리스트 불러오기
		ArrayList<VoteVO> votes = voteDAO.getSearchedVoteList(searchTargetStr);
		
		// 검색된 투표 개수 계산
		int count = 0;
		if (votes != null) {
			count = votes.size(); 			
		}
		// 각각의 vote에 해당하는 pick 리스트 불러오기
		for (VoteVO v : votes) {
			if (participateDAO.isExist(loginId, v.getVote_id())) {
				v.setUserParticipated(true);
			}
			if (likeVoteDAO.isExist(loginId, v.getVote_id())) {
				v.setUserLikeStatus(true);
			}
			if (bookmarkDAO.isExist(loginId, v.getVote_id())) {
				v.setUserBookmarkStatus(true);
			}
			
			ArrayList<PickVO> picks = voteDAO.getPickList(v.getVote_id());
			v.setPickList(picks);
		}
		mv.addObject("votes", votes);
		mv.addObject("count", count);
		mv.addObject("pageNo", 1);
		mv.setViewName("MainPage");
		return mv;
	}
	
	
	// /participating
	@RequestMapping(value="/search_vote_with_id")
	public ModelAndView myVoteLoding(HttpServletRequest req, @RequestParam(required = true) int vote_id) {
		ModelAndView mv = new ModelAndView();
		System.out.println(vote_id);
		
		HttpSession session = req.getSession();
		String loginId = (String) session.getAttribute("loginId");
		
		// 로그인 확인
		if (loginId == null) {
			mv.setViewName("redirect:/login");
			return mv;
		}
		
		// 보고 싶은 투표 가져오기
		VoteVO v = voteDAO.getVoteWithId(vote_id);
		if (participateDAO.isExist(loginId, v.getVote_id())) {
			v.setUserParticipated(true);
		}
		if (likeVoteDAO.isExist(loginId, v.getVote_id())) {
			v.setUserLikeStatus(true);
		}
		if (bookmarkDAO.isExist(loginId, v.getVote_id())) {
			v.setUserBookmarkStatus(true);
		}
		// vote에 해당하는 pick 리스트 불러오기
	
		System.out.println(v);
		ArrayList<PickVO> picks = voteDAO.getPickList(v.getVote_id());
		v.setPickList(picks);
		
		ArrayList<VoteVO> votes = new ArrayList<VoteVO>();
		votes.add(v);
		mv.addObject("votes", votes);
		mv.addObject("count", 1);
		mv.addObject("pageNo", 1);
		mv.setViewName("MainPage");
		return mv;
	}
}
