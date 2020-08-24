package edu.multi.voting.vote;

public class PickVO {
    // 투표 id 
    private int voteId;

    // 투표 항목 번호 
    private int pickNo;

    // 투표 항목 이름 
    private String pickName;

    // 투표 득표수 
    private int score;

    public int getVoteId() {
        return voteId;
    }

    public void setVoteId(int voteId) {
        this.voteId = voteId;
    }

    public int getPickNo() {
        return pickNo;
    }

    public void setPickNo(int pickNo) {
        this.pickNo = pickNo;
    }

    public String getPickName() {
        return pickName;
    }

    public void setPickName(String pickName) {
        this.pickName = pickName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

   @Override
   public String toString() {
      return "PickVO [voteId=" + voteId + ", pickNo=" + pickNo + ", pickName=" + pickName + ", score=" + score + "]";
   }
    
}