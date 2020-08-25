package edu.multi.voting.main;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.multi.voting.pick.PickVO;
import edu.multi.voting.vote.VoteDAO;
import edu.multi.voting.vote.VoteVO;

@Controller
public class MainPageController {
	
	@Autowired
	private VoteDAO voteDAO;
	
	@RequestMapping(value="/home")
	public ModelAndView mainPageLoading() {
		ModelAndView mv = new ModelAndView();
		System.out.println("test");
		// vote 리스트 불러오기
		ArrayList<VoteVO> votes = voteDAO.getEntireVoteList();
		// 각각의 vote에 해당하는 pick 리스트 불러오기
		for (VoteVO v : votes) {
			System.out.println(v);
			ArrayList<PickVO> picks = voteDAO.getPickList(v.getVote_id());
			v.setPickList(picks);
		}
		mv.addObject("votes", votes);
		mv.setViewName("MainPage");
		return mv;
	}
	
	@RequestMapping(value="/search")
	public ModelAndView searchResultLoading(@RequestParam(required = true) String searchTargetStr) {
		ModelAndView mv = new ModelAndView();
		System.out.println("'"+searchTargetStr+"'");
		// 검색된 정보에 대한 vote 리스트 불러오기
		ArrayList<VoteVO> votes = voteDAO.getSearchedVoteList(searchTargetStr);
		// 각각의 vote에 해당하는 pick 리스트 불러오기
		for (VoteVO v : votes) {
			System.out.println(v);
			ArrayList<PickVO> picks = voteDAO.getPickList(v.getVote_id());
			v.setPickList(picks);
		}
		mv.addObject("votes", votes);
		mv.setViewName("MainPage");
		return mv;
	}
}
