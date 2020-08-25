package edu.multi.voting.vote;

public class BookmarkVO {
	int vote_id;
	String bookmarker_id;
	public int getVote_id() {
		return vote_id;
	}
	public void setVote_id(int vote_id) {
		this.vote_id = vote_id;
	}
	public String getBookmarker_id() {
		return bookmarker_id;
	}
	public void setBookmarker_id(String bookmarker_id) {
		this.bookmarker_id = bookmarker_id;
	}
	@Override
	public String toString() {
		return "BookmarkVO [vote_id=" + vote_id + ", bookmarker_id=" + bookmarker_id + "]";
	}
	
}
