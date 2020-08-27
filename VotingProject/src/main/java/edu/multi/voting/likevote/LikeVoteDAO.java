package edu.multi.voting.likevote;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

import edu.multi.voting.VotingConstant;

@Component("lvdao")
public class LikeVoteDAO {
	public String findVoteLike(String login_id, int vote_id) {
		String check="error";
		try {
			
			String sql = "select * from likevote where user_id=? and vote_id = ?";

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(
					VotingConstant.JDBC_CONNECTION_STR,"vote","vote");
	
			PreparedStatement pt = con.prepareStatement(sql);
	
			pt.setString(1, login_id);
			pt.setInt(2, vote_id);
			System.out.println("loginid="+login_id+" vote_id="+vote_id );
			ResultSet rs = pt.executeQuery();
			//이미 북마크 했다.
			if(rs.next()) {
				
				check="liked_already";
			}

			else {
				check = "not_marked";
			}

			pt.close();
			con.close();
			
			}catch(Exception e) {
				e.printStackTrace();
			}
		
		return check;
			
		}
		

	

	public int deleteVoteLike(String login_id, int vote_id) {
		String sql = "delete likevote where user_id=? and vote_id=?";
		String sql2 = "update vote set like_count = like_count-1 where vote_id =?";
		int result = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection(VotingConstant.JDBC_CONNECTION_STR, "vote", "vote");
				PreparedStatement pt = con.prepareStatement(sql);
				PreparedStatement pt2 = con.prepareStatement(sql2);

				System.out.println(vote_id);
				pt.setString(1, login_id);
				pt.setInt(2, vote_id);
				result = pt.executeUpdate();
				
				pt2.setInt(1, vote_id);
				pt2.executeUpdate();
			
				pt.close();
				pt2.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		
		return result;
	}

	public int insertVoteLike(String login_id, int vote_id) {
		String sql = "insert into likevote values(?, ?)";
//		String sql2 = "update vote set like_count = like_count +1 where vote_id =?";
		int result = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection(VotingConstant.JDBC_CONNECTION_STR, "vote", "vote");
				PreparedStatement pt = con.prepareStatement(sql);
			
				pt.setString(1, login_id);
				pt.setInt(2, vote_id);
				result = pt.executeUpdate();
				
//				PreparedStatement pt2 = con.prepareStatement(sql2);
//				pt2.setInt(1, vote_id);
//				pt2.executeUpdate();
				
				pt.close();
//				pt2.close();
				
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
		 catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		
		return result;
	}

	public boolean isExist(String loginId, int vote_id) {
		String sql = "select count(*) as \"count\" from likevote where user_id=? and vote_id=?";
		int result = 0;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			try (
				Connection con = DriverManager.getConnection(VotingConstant.JDBC_CONNECTION_STR, "vote", "vote");
				PreparedStatement pt = con.prepareStatement(sql);
			) {

				pt.setString(1, loginId);
				pt.setInt(2, vote_id);
				ResultSet rs =  pt.executeQuery();

				if (rs.next()) {
					result = rs.getInt("count");
				}		

				pt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result != 0;
	}

}
