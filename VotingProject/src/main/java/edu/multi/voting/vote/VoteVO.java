package edu.multi.voting.vote;

import java.sql.Date;
import java.util.ArrayList;

import edu.multi.voting.pick.PickVO;

public class VoteVO {
	int vote_id;
	String poster_id;
	String title;
	String contents;
	Date time;
	int like_count;
	int comment_count;

	ArrayList<PickVO> pickList;

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

	public ArrayList<PickVO> getPickList() {
		return pickList;
	}

	public void setPickList(ArrayList<PickVO> pickList) {
		this.pickList = pickList;
	}

	@Override
	public String toString() {
		return "VoteVO [vote_id=" + vote_id + ", poster_id=" + poster_id + ", title=" + title + ", contents=" + contents
				+ ", time=" + time + ", like_count=" + like_count + ", comment_count=" + comment_count + "]";
	}

}