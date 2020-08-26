package edu.multi.voting.participate;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.multi.voting.pick.PickDAO;
import edu.multi.voting.pick.PickVO;
import edu.multi.voting.vote.VoteDAO;
import edu.multi.voting.vote.VoteVO;

@Controller
public class ParticipateController {
	private static final String STATUS_FAIL = "fail";
	private static final String STATUS_SUCCESS = "success";
	private static final String EXIST_ERROR_MSG = "already participated";
	private static final String DB_ERROR_MSG = "sever error(db)";
	
	@Autowired
	PickDAO pickDAO;
	
	@Autowired
	ParticipateDAO participateDAO;
	
	@Autowired
	ParticipateResultVO resultVO;
	
	@Autowired
	VoteDAO voteDAO;
	
	@RequestMapping(value="/participate", method=RequestMethod.POST)
	@ResponseBody
	public ParticipateResultVO participate(ParticipateVO pvo) {
		
		System.out.println(pvo);
		
		// 이미 참여한 적이 있는지 체크
		if (participateDAO.isExist(pvo.getParticipant_id(), pvo.getVote_id())) {
			resultVO.setResult(STATUS_FAIL);
			resultVO.setErrorMsg(EXIST_ERROR_MSG);
		} 
		else {	// 참여한 적이 없다면
			pickDAO.countPick(pvo.getVote_id(), pvo.getPick_no());
			participateDAO.insertParticipate(pvo);
			
			VoteVO voteVO = voteDAO.getVoteWithId(pvo.getVote_id());
			System.out.println(voteVO);
			ArrayList<PickVO> picks = voteDAO.getPickList(voteVO.getVote_id());
			voteVO.setPickList(picks);
			
			resultVO.setVote(voteVO);
			resultVO.setResult(STATUS_SUCCESS);
		}	
		
		return resultVO;
	}
	@RequestMapping(value="/check_participation")
	@ResponseBody
	public ParticipateResultVO check_participation(String user_id, ParticipateVO pvo) {
		
		// 이미 참여한 적이 있는지 체크
//		if (participateDAO.isExist(pvo)) {
//			resultVO.setResult(STATUS_FAIL);
//			resultVO.setErrorMsg(EXIST_ERROR_MSG);
//		} 
//		else {	// 참여한 적이 없다면
//			pickDAO.increasePickScore(pvo.getVote_id(), pvo.getPick_no());
//			participateDAO.insertParticipate(pvo.getParticipant_id(), pvo.getVote_id(), pvo.getPick_no());
//			
//			resultVO.setResult(STATUS_SUCCESS);
//		}
		
		// test
		resultVO.setResult(STATUS_SUCCESS);
		
		return resultVO;
	}
	
}
