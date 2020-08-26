package edu.multi.voting.vote;

import java.sql.Date;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import edu.multi.voting.pick.PickVO;

@Repository("vo")
public class VoteVO {
	int vote_id;
	String poster_id;
	String title;
	String contents;
	String content1;
	String content2;
	String content3;
	String content4;
	Date time;
	int like_count;
	int comment_count;
	
	boolean userLikeStatus;
	boolean userBookmarkStatus;
	boolean userParticipated;
	
	public boolean isUserParticipated() {
		return userParticipated;
	}
	public void setUserParticipated(boolean userParticipated) {
		this.userParticipated = userParticipated;
	}
	
	ArrayList<PickVO> pickList;
	
	public ArrayList<PickVO> getPickList() {
		return pickList;
	}
	public void setPickList(ArrayList<PickVO> pickList) {
		this.pickList = pickList;
	}
	public int getVote_id() {
		return vote_id;
	}
	public void setVote_id(int vote_id) {
		this.vote_id = vote_id;
	}
	public String getPoster_id() {
		return poster_id;
	}
	public void setPoster_id(String poster_id) {
		this.poster_id = poster_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getContent1() {
		return content1;
	}
	public void setContent1(String content1) {
		this.content1 = content1;
	}
	public String getContent2() {
		return content2;
	}
	public void setContent2(String content2) {
		this.content2 = content2;
	}
	public String getContent3() {
		return content3;
	}
	public void setContent3(String content3) {
		this.content3 = content3;
	}
	public String getContent4() {
		return content4;
	}
	public void setContent4(String content4) {
		this.content4 = content4;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public int getLike_count() {
		return like_count;
	}
	public void setLike_count(int like_count) {
		this.like_count = like_count;
	}
	public int getComment_count() {
		return comment_count;
	}
	public void setComment_count(int comment_count) {
		this.comment_count = comment_count;
	}
	
	
	public boolean isUserLikeStatus() {
		return userLikeStatus;
	}
	public void setUserLikeStatus(boolean userLikeStatus) {
		this.userLikeStatus = userLikeStatus;
	}
	public boolean isUserBookmarkStatus() {
		return userBookmarkStatus;
	}
	public void setUserBookmarkStatus(boolean userBookmarkStatus) {
		this.userBookmarkStatus = userBookmarkStatus;
	}
	@Override
	public String toString() {
		return "VoteVO [vote_id=" + vote_id + ", poster_id=" + poster_id + ", title=" + title + ", content1=" + content1
				+ ", content2=" + content2 + ", content3=" + content3 + ", content4=" + content4 + ", time=" + time
				+ ", like_count=" + like_count + ", comment_count=" + comment_count + "]";
	}

	
	
}
