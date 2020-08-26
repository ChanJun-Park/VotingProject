package edu.multi.voting.participate;

import org.springframework.stereotype.Component;

import edu.multi.voting.vote.VoteVO;

@Component
public class ParticipateResultVO {
	String result;
	String errorMsg;
	
	VoteVO vote;
	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
	public VoteVO getVote() {
		return vote;
	}
	public void setVote(VoteVO vote) {
		this.vote = vote;
	}
	@Override
	public String toString() {
		return "ParticipateResultVO [result=" + result + ", errorMsg=" + errorMsg + "]";
	}
}
