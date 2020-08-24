package edu.multi.voting.comments;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CommentsController {

	@Autowired
	CommentsDAO dao;
	
//	@RequestMapping(value="/commentwrite", method=RequestMethod.GET)
//	public String commentform() {
//		System.out.println("댓글창 실행중");
//		return "";
//	}
	
	@RequestMapping(value="/commentwrite", method=RequestMethod.POST)
	public ModelAndView commentprocess(@ModelAttribute("vo") CommentsVO vo) {
		System.out.println(vo);
		
		String result = dao.insertComment(vo);
		ModelAndView mv = new ModelAndView();
		if (result.indexOf("성공")<0) {
			mv.addObject("result", result);
		}
		
		mv.setViewName("redirect:/commentlist");
		return mv;
	}
	
	@RequestMapping("/commentlist")
	public ModelAndView getCommentList() {
		ArrayList<CommentsVO> commentlist = dao.getCommentList();
		ModelAndView mv = new ModelAndView();
		mv.addObject("commentlist",commentlist);
		
		return mv;
	}
	
}
