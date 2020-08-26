package edu.multi.voting.pick;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PickDAO {
	public void countPick(PickVO vo) {
		String sql = "update pick set score = score + 1 where vote_id = ? and pick_no = ? ";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@70.12.231.100:1521:xe", "vote", "vote");
			PreparedStatement pt = con.prepareStatement(sql);
			pt.setInt(1, vo.getVoteId());
			pt.setInt(2, vo.getPickNo());
			pt.executeUpdate();
			pt.close();

		} catch (SQLException e) {
			e.printStackTrace();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return;
	}
}
