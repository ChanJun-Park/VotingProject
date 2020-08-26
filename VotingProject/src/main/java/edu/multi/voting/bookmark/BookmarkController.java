package edu.multi.voting.bookmark;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import edu.multi.voting.users.UsersDAO;

@Controller
public class BookmarkController {
	@Autowired
	BookmarkDAO bmdao;

	@RequestMapping(value= "/addbookmark",method=RequestMethod.POST)
	public @ResponseBody String addbookmark(@RequestParam("bookmarker_id") String bookmarker_id, @RequestParam("vote_id") int vote_id) {
		System.out.println(bookmarker_id);
		System.out.println(vote_id);
		
		BookmarkVO vo = new BookmarkVO();
		String status;
		vo.setVote_id(vote_id);
		vo.setBookmarker_id(bookmarker_id);
		
		System.out.println(vo.toString());
		//이미 있으면 삭제하고
		if(bmdao.findBookmark(vo).equals("marked_already")){
			bmdao.deleteBookmark(vo);
			//색깔NO
			status="NO";
		}
		else {//없으면 추가하고
			System.out.println("들어옴");
			bmdao.addBookmark(vo.getBookmarker_id(), vo.getVote_id());
			//색깔YES
			status = "YES";
		}
		return status;
	}

}