package edu.multi.voting.comments;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
	@ResponseBody
	public CommentsVO commentprocess(CommentsVO vo) {
		System.out.println(vo);
		
		String result = dao.insertComment(vo);
		
//		vo = dao.selectComment(vo.comment_id);
		if (result.indexOf("성공")<0) {
		}
		return vo;
	}
	
	@RequestMapping("/commentlist")
	@ResponseBody
	public ArrayList<CommentsVO> getCommentList(int vote_id) {
		System.out.println(vote_id);
		ArrayList<CommentsVO> commentlist = dao.getCommentList(vote_id);
		System.out.println(commentlist.size());
		return commentlist;
	}
	
	@RequestMapping("/commentdelete")
	@ResponseBody
	public String commentDelete(int comment_id) {
		StringBuilder sb = new StringBuilder();
		sb.append("{\"result\":");
		int result = dao.deleteComment(comment_id);
		if (result == 1) {
			sb.append("\"ok\", \"deletedCommentId\":").append(comment_id).append("}");
		} else {
			sb.append("\"fail\", \"deletedCommentId\":").append(comment_id).append("}");			
		}
		
		return sb.toString();
	}
}
