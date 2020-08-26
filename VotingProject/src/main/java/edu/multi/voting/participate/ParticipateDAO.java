package edu.multi.voting.participate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

@Component
public class ParticipateDAO {

	public boolean isExist(String participantId, int voteId) {
		String sql = "select count(*) as \"count\" from participate where participant_id=? and vote_id=?";
		int result = 0;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			try (
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@70.12.231.100:1521:xe", "vote", "vote");
				PreparedStatement pt = con.prepareStatement(sql);
			) {

				pt.setString(1, participantId);
				pt.setInt(2, voteId);
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

	public boolean insertParticipate(ParticipateVO pvo) {
		String sql = "insert into participate values(?, ?, ?)";
		int result = 0;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			try (
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@70.12.231.100:1521:xe", "vote", "vote");
				PreparedStatement pt = con.prepareStatement(sql);
			) {

				pt.setString(1, pvo.getParticipant_id());
				pt.setInt(2, pvo.getVote_id());
				pt.setInt(3, pvo.getPick_no());
				result = pt.executeUpdate();

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
