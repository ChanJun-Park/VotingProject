package edu.multi.voting.vote;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

import edu.multi.voting.pick.PickVO;

@Component("voteDAO")
public class VoteDAO {

	public ArrayList<VoteVO> getEntireVoteList() {
		String sql = "select * from vote";
		ArrayList<VoteVO> votes = new ArrayList<VoteVO>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			try (
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@70.12.231.100:1521:xe", "vote", "vote");
				PreparedStatement pt = con.prepareStatement(sql);
			) {

				ResultSet rs = pt.executeQuery();
				while(rs.next()) {
					VoteVO vo = new VoteVO();
					vo.setVote_id(rs.getInt("vote_id"));
					vo.setPoster_id(rs.getString("poster_id"));
					vo.setTitle(rs.getString("title"));
					vo.setContents(rs.getString("contents"));
					vo.setTime(rs.getDate("time"));
					vo.setLike_count(rs.getInt("like_count"));
					vo.setComment_count(rs.getInt("comment_count"));
					votes.add(vo);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 

		return votes;
	}

	public ArrayList<PickVO> getPickList(int vote_id) {
		String sql = "select * from pick where vote_id = ?";
		ArrayList<PickVO> picks = new ArrayList<PickVO>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			try (
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@70.12.231.100:1521:xe", "vote", "vote");
				PreparedStatement pt = con.prepareStatement(sql);
			) {

				pt.setInt(1, vote_id);	
				ResultSet rs = pt.executeQuery();
				while(rs.next()) {
					PickVO vo = new PickVO();
					vo.setVoteId(rs.getInt("vote_id"));
					vo.setPickNo(rs.getInt("pick_no"));
					vo.setPickName(rs.getString("pick_name"));
					vo.setScore(rs.getInt("score"));
					picks.add(vo);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 

		return picks;
	}
	
}
