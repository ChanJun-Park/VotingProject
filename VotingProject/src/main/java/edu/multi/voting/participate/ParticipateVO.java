package edu.multi.voting.participate;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//이용자 투표 참여 이력 
@Component
@Scope("session") 		// 로그인 한 사람에 대해서만 공유해서 쓸려고 설정
public class ParticipateVO {
    // 투표 참여자 id 
    private String participant_id;

    // 투표 id 
    private int vote_id;

    // 투표 항목 번호 
    private int pick_no;

	public String getParticipant_id() {
		return participant_id;
	}

	public void setParticipant_id(String participant_id) {
		this.participant_id = participant_id;
	}

	public int getVote_id() {
		return vote_id;
	}

	public void setVote_id(int vote_id) {
		this.vote_id = vote_id;
	}

	public int getPick_no() {
		return pick_no;
	}

	public void setPick_no(int pick_no) {
		this.pick_no = pick_no;
	}

	@Override
	public String toString() {
		return "ParticipateVO [participant_id=" + participant_id + ", vote_id=" + vote_id + ", pick_no=" + pick_no
				+ "]";
	}
}
