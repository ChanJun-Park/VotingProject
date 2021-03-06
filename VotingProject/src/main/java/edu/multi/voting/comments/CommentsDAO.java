package edu.multi.voting.comments;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.multi.voting.VotingConstant;

@Component
public class CommentsDAO {
	
	@Autowired
	SimpleDateFormat dateFormat;
	
	public ArrayList<CommentsVO> getCommentList(int vote_id) {
		ArrayList<CommentsVO> commentList = new ArrayList<CommentsVO>();
		String sql = "select comment_id, writer_id, contents, time from comments where vote_id =? order by time desc";
		System.out.println("commentList 호출됨");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			try (Connection con = DriverManager.getConnection(VotingConstant.JDBC_CONNECTION_STR, "vote",
					"vote"); PreparedStatement pt = con.prepareStatement(sql);) {
				pt.setInt(1, vote_id);
				ResultSet rs = pt.executeQuery();

				while (rs.next()) {
					CommentsVO vo = new CommentsVO();
					vo.setComment_id(rs.getInt("comment_id"));
					vo.setWriter_id(rs.getString("writer_id"));
					vo.setContents(rs.getString("contents"));
					vo.setTime(rs.getString("time"));
//					vo.setVote_id(vote_id);
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
	
	public CommentsVO getCommentWithId(int comment_id) {
		CommentsVO comment = null;
		String sql = "select comment_id, writer_id, contents, time from comments where comment_id =?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			try (Connection con = DriverManager.getConnection(VotingConstant.JDBC_CONNECTION_STR, "vote",
					"vote"); PreparedStatement pt = con.prepareStatement(sql);) {
				pt.setInt(1, comment_id);
				ResultSet rs = pt.executeQuery();

				if (rs.next()) {
					comment = new CommentsVO();
					comment.setComment_id(rs.getInt("comment_id"));
					comment.setWriter_id(rs.getString("writer_id"));
					comment.setContents(rs.getString("contents"));
					comment.setTime(rs.getString("time"));
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return comment;
	}

	public String insertComment(CommentsVO vo) {

		String sql = "insert into comments values(?,sysdate,?,?,0,(select nvl(max(comment_id),0) from comments)+1)";
		String sql2 = "update vote set comment_count = comment_count + 1 where vote_id = ?";
		Calendar time = Calendar.getInstance();
		String serverDate = dateFormat.format(time.getTime());
		String result = "";
		System.out.println(serverDate);
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection(VotingConstant.JDBC_CONNECTION_STR, "vote", "vote");
				PreparedStatement pt = con.prepareStatement(sql);
				PreparedStatement pt2 = con.prepareStatement(sql2);
				pt.setString(1, vo.getWriter_id());
				pt.setInt(2, vo.getVote_id());
				pt.setString(3, vo.getContents());
				
				int insertRow = pt.executeUpdate();
				if (insertRow == 1) {
					result = serverDate;
				} else {
					result ="오류";
				}
				pt.close();
				
				pt2.setInt(1, vo.vote_id);
				pt2.executeUpdate();
				pt2.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int deleteComment(CommentsVO vo) {
		String sql = "delete comments where comment_id = ?";
		String sql2 = "update vote set comment_count = comment_count - 1 where vote_id =?";
		int result = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection(VotingConstant.JDBC_CONNECTION_STR, "vote", "vote");
				PreparedStatement pt = con.prepareStatement(sql);
				PreparedStatement pt2 = con.prepareStatement(sql2);

				pt.setInt(1, vo.comment_id);
				result = pt.executeUpdate();
				pt.close();
				
				pt2.setInt(1, vo.vote_id);
				pt2.executeUpdate();
				pt2.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		return result;
	}

//	public CommentsVO selectComment(int comment_id) {
//		CommentsVO insertcomment = new CommentsVO();
//		String sql = "select comment_id, writer_id, contents, time from comments where comment_id =?";
//		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			try (
//				Connection con = DriverManager.getConnection(VotingConstant.JDBC_CONNECTION_STR, "vote", "vote");
//				PreparedStatement pt = con.prepareStatement(sql);
//			) {
//				pt.setInt(1, comment_id);
//				ResultSet rs = pt.executeQuery();
//				
//				while(rs.next()) {
//					insertcomment.setComment_id(rs.getInt("comment_id"));
//					insertcomment.setWriter_id(rs.getString("writer_id"));
//					insertcomment.setContents(rs.getString("contents"));
//					insertcomment.setTime(rs.getString("time"));
//				}
//				
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
//		
//		return insertcomment;
//	}
}
