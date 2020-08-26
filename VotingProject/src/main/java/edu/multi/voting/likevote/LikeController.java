package edu.multi.voting.likevote;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import edu.multi.voting.users.UsersDAO;

@Controller
public class LikeController {
	@Autowired
	LikeVoteDAO lvdao;

	@RequestMapping(value= "/addlike",method=RequestMethod.POST)
	public @ResponseBody String addlike(@RequestParam("login_id") String login_id, @RequestParam("vote_id") int vote_id) {
		String status;
		System.out.println("LIKE로 들어옴");
		if(lvdao.findVoteLike(login_id, vote_id).equals("liked_already")) {
			System.out.println("liked_already");
			lvdao.deleteVoteLike(login_id, vote_id);
			status="NO";
		}
		else {
			System.out.println("not..");
			lvdao.insertVoteLike(login_id, vote_id);
			status="YES";
		}
		return status;
	
	}
}
