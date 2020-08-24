package edu.multi.voting.vote;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import org.springframework.stereotype.Component;

@Component("dao")
public class VoteDAO {
	public void insertVote(VoteVO vo) {
		try {
			String sql = "insert into vote values((select nvl(max(vote_id), 0) + 1 from vote), ? , ?, ?, sysdate,0, 0)";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@70.12.231.100:1521:xe", "vote", "vote");
			PreparedStatement pt = con.prepareStatement(sql);
			
			pt.setString(1, vo.getPoster_id());
			pt.setString(2, vo.getTitle());
			pt.setString(3, vo.getContents());
			
			pt.executeUpdate();
			pt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return;
	}
	public void insertPicks(VoteVO vo) {
		try {
			String sql1 = "insert into pick values(?, 1, ?, 0)";
			String sql2 = "insert into pick values(?, 2, ?, 0)";
			String sql3 = "insert into pick values(?, 3, ?, 0)";
			String sql4 = "insert into pick values(?, 4, ?, 0)";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@70.12.231.100:1521:xe", "vote", "vote");
			PreparedStatement pt1 = con.prepareStatement(sql1);
			PreparedStatement pt2 = con.prepareStatement(sql2);
			PreparedStatement pt3 = con.prepareStatement(sql3);
			PreparedStatement pt4 = con.prepareStatement(sql4);
			
			pt1.setInt(1,vo.getVote_id());
			if(vo.getContent1()!=null) {				
				pt1.setString(2, vo.getContent1());
			}else {
				pt1.setString(2, "null");
			}
			pt2.setInt(1,vo.getVote_id());
			if(vo.getContent2()!=null) {				
				pt2.setString(2, vo.getContent2());
			}else {
				pt2.setString(2, "null");
			}
			pt3.setInt(1,vo.getVote_id());
			if(vo.getContent3()!=null) {				
				pt3.setString(2, vo.getContent3());
			}else {
				pt3.setString(2, "null");
			}
			pt4.setInt(1,vo.getVote_id());
			if(vo.getContent4()!=null) {				
				pt4.setString(2, vo.getContent4());
			}else {
				pt4.setString(2, "null");
			}
			pt1.executeUpdate();
			pt2.executeUpdate();
			pt3.executeUpdate();
			pt4.executeUpdate();
			pt1.close();
			pt2.close();
			pt3.close();
			pt4.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return;
	}
	public void deleteVote(VoteVO vo) {
		try {
			String sql = "delete from vote where vote_id = ?";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@70.12.231.100:1521:xe", "vote", "vote");
			PreparedStatement pt = con.prepareStatement(sql);
			pt.setInt(1, vo.getVote_id());
			
			pt.executeUpdate();
			pt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return;
	}
	public void likeVote(VoteVO vo) {
		try {
			String sql = "update vote set like_count = like_count + 1 where vote_id = ?";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@70.12.231.100:1521:xe", "vote", "vote");
			PreparedStatement pt = con.prepareStatement(sql);
			pt.setInt(1, vo.getVote_id());
			
			pt.executeUpdate();
			pt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return;
	}

	
}
