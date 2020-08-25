package edu.multi.voting;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
	public String mainPage(VoteVO vo, HttpServletRequest req) throws IOException  {
		HttpSession session = req.getSession();
		String loginId = (String) session.getAttribute("loginId");
		vo.setPoster_id(loginId);
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
}
