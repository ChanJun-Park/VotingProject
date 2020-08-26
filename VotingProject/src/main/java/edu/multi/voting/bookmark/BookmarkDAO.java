package edu.multi.voting.bookmark;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

@Component
public class BookmarkDAO {

	public boolean isExist(String loginId, int vote_id) {
		String sql = "select count(*) as \"count\" from bookmark where vote_id=? and bookmarker_id=?";
		int result = 0;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			try (
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@70.12.231.100:1521:xe", "vote", "vote");
				PreparedStatement pt = con.prepareStatement(sql);
			) {

				pt.setInt(1, vote_id);
				pt.setString(2, loginId);
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
