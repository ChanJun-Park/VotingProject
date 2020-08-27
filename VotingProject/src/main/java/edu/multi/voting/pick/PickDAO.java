package edu.multi.voting.pick;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

import edu.multi.voting.VotingConstant;

@Component
public class PickDAO {
   public int countPick(int vote_id, int pick_no) {
      String sql = "update pick set score = score + 1 where vote_id = ? and pick_no = ?";
      int result = 0;
      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");
         Connection con = DriverManager.getConnection(VotingConstant.JDBC_CONNECTION_STR, "vote", "vote");
         PreparedStatement pt = con.prepareStatement(sql);
         pt.setInt(1, vote_id);
         pt.setInt(2, pick_no);
         result = pt.executeUpdate();
         pt.close();

		} catch (SQLException e) {
			e.printStackTrace();

      } catch (ClassNotFoundException e) {
         e.printStackTrace();
      }
      return result;	
   }
}
