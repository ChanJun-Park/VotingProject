package edu.multi.voting.pick;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PickController {
	@Autowired
	private PickDAO dao;
	
	@RequestMapping(value="/pick",method=RequestMethod.POST)
	public String pick(PickVO vo){
		System.out.println(vo.getPickNo()+" "+vo.getVoteId());
		dao.countPick(vo);
		return "redirect:/home";
	}
}
