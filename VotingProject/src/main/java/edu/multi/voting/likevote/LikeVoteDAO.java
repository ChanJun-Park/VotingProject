package edu.multi.voting.likevote;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

@Component
public class LikeVoteDAO {

	public int deleteVoteLike(String login_id, int vote_id) {
		String sql = "delete likevote where user_id=? and vote_id=?";
		int result = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			try (
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@70.12.231.100:1521:xe", "vote", "vote");
				PreparedStatement pt = con.prepareStatement(sql);
			) {

				System.out.println(vote_id);
				pt.setString(1, login_id);
				pt.setInt(2, vote_id);
				result = pt.executeUpdate();
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		
		return result;
	}

	public int insertVoteLike(String login_id, int vote_id) {
		String sql = "insert into likevote values(?, ?)";
		int result = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			try (
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@70.12.231.100:1521:xe", "vote", "vote");
				PreparedStatement pt = con.prepareStatement(sql);
			) {

				System.out.println(vote_id);
				pt.setString(1, login_id);
				pt.setInt(2, vote_id);
				result = pt.executeUpdate();
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		
		return result;
	}

}
