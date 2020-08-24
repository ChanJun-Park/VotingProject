package edu.multi.voting.comments;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CommentsDAO {
	public ArrayList<CommentsVO> getCommentList() {
		ArrayList<CommentsVO> commentList = new ArrayList<CommentsVO>();
		String sql = "select writer_id, contents, time from comment";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			try (
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@70.12.231.100:1521:xe", "vote", "vote");
				PreparedStatement pt = con.prepareStatement(sql);
			) {
				ResultSet rs = pt.executeQuery();
				
				while(rs.next()) {
					CommentsVO vo = new CommentsVO();
					vo.setWriter_id(rs.getString("writer_id"));
					vo.setContents(rs.getString("contents"));
					vo.setTime(rs.getString("time"));
					commentList.add(vo);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return commentList;
	}
	
	String insertComment(CommentsVO vo) {
		
		System.out.println(vo);
		String sql = "insert into comment values(?,sysdate,?,?)";
		String result = "";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			try (
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@70.12.231.100:1521:xe", "vote", "vote");
				PreparedStatement pt = con.prepareStatement(sql);
			) {
				pt.setString(1, vo.getWriter_id());
				pt.setInt(2, vo.getVote_id());
				pt.setString(3, vo.getContents());
				
				int insertRow = pt.executeUpdate();
				if (insertRow == 1) {
					result ="성공";
				} else {
					result ="오류";
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return result; 
		
	}
}
