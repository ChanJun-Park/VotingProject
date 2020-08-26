package edu.multi.voting.vote;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

import edu.multi.voting.pick.PickVO;

@Component("dao")
public class VoteDAO {
	public int insertVote(VoteVO vo) {
		int result = 0;
		try {
			String sql = "insert into vote values((select nvl(max(vote_id), 0) + 1 from vote), ? , ?, ?, sysdate,0, 0)";
			String sql2 = "select max(vote_id) as voteid from vote";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@70.12.231.100:1521:xe", "vote", "vote");
			PreparedStatement pt = con.prepareStatement(sql);
			PreparedStatement pt2 = con.prepareStatement(sql2);
			
			pt.setString(1, vo.getPoster_id());
			pt.setString(2, vo.getTitle());
			pt.setString(3, vo.getContents());
			
			pt.executeUpdate();
			pt.close();
			
			ResultSet rs = pt2.executeQuery();
			while(rs.next()) {
				result= rs.getInt("voteid");
			}		
			pt2.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public void insertPicks(VoteVO vo, int voteid) {
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
			
			pt1.setInt(1,voteid);
			if(vo.getContent1()!=null) {				
				pt1.setString(2, vo.getContent1());
			}else {
				pt1.setString(2, "null");
			}
			pt2.setInt(1,voteid);
			if(vo.getContent2()!=null) {				
				pt2.setString(2, vo.getContent2());
			}else {
				pt2.setString(2, "null");
			}
			pt3.setInt(1,voteid);
			if(vo.getContent3()!=null) {				
				pt3.setString(2, vo.getContent3());
			}else {
				pt3.setString(2, "null");
			}
			pt4.setInt(1,voteid);
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
	public void deleteVote(int vote_id) {
		try {
			String sql = "delete from vote where vote_id = ?";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@70.12.231.100:1521:xe", "vote", "vote");
			PreparedStatement pt = con.prepareStatement(sql);
			pt.setInt(1, vote_id);
			
			pt.executeUpdate();
			pt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return;
	}
	public void deletePicks(int vote_id) {
		try {
			String sql = "delete from pick where vote_id = ?";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@70.12.231.100:1521:xe", "vote", "vote");
			PreparedStatement pt = con.prepareStatement(sql);
			pt.setInt(1, vote_id);
			
			pt.executeUpdate();
			pt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return;
		
	}
	public void deleteFavortie(int vote_id) {
		try {
			String sql = "delete from bookmark where vote_id = ?";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@70.12.231.100:1521:xe", "vote", "vote");
			PreparedStatement pt = con.prepareStatement(sql);
			pt.setInt(1, vote_id);
			
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

	public ArrayList<VoteVO> getEntireVoteList(int pageNo) {
	      String sql = "SELECT * FROM (" + 
	              "    SELECT a.*, rownum r" + 
	              "    FROM " + 
	              "    (" + 
	              "        select ROWNUM as \"seq\", vote_id, poster_id, title, contents, time, like_count, comment_count " + 
	              "        from vote " + 
	              "        order by time desc " + 
	              "    ) a " + 
	              "    WHERE rownum <= ? " + 
	              " ) " + 
	              " WHERE r >= ? ";

	      ArrayList<VoteVO> votes = new ArrayList<VoteVO>();
	      try {
	         Class.forName("oracle.jdbc.driver.OracleDriver");
	         try (
	            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@70.12.231.100:1521:xe", "vote", "vote");
	            PreparedStatement pt = con.prepareStatement(sql);
	         ) {

	            int start = (pageNo - 1) * 5 + 1;
	            int end = start + 4;
	            
	            pt.setInt(1, end);
	            pt.setInt(2, start);
	            
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
	public ArrayList<VoteVO> getMyVoteList(String poster_id) {
		String sql = "select vote_id,poster_id,title, time, contents from vote where poster_id = ? order by time desc";
		ArrayList<VoteVO> picks = new ArrayList<VoteVO>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@70.12.231.100:1521:xe", "vote", "vote");
			PreparedStatement pt = con.prepareStatement(sql);
				
			pt.setString(1, poster_id);	
			ResultSet rs = pt.executeQuery();
			while(rs.next()) {
					VoteVO vo = new VoteVO();
					vo.setVote_id(rs.getInt("vote_id"));
					vo.setPoster_id(rs.getString("poster_id"));
					vo.setTitle(rs.getString("title"));
					vo.setContents(rs.getString("contents"));
					vo.setTime(rs.getDate("time"));
					picks.add(vo);
			}
			pt.close();
			rs.close();
			con.close();
		} catch (SQLException e) {
				e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return picks;
	}
	public ArrayList<VoteVO> getMyFavoriteList(String user_id) {
		String sql = "select v.vote_id, v.poster_id, v.title, v.contents, v.time from bookmark b, vote v where b.bookmarker_id = ? and b.vote_id = v.vote_id order by time desc";
		ArrayList<VoteVO> picks = new ArrayList<VoteVO>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@70.12.231.100:1521:xe", "vote", "vote");
			PreparedStatement pt = con.prepareStatement(sql);
			
			pt.setString(1, user_id);	
			ResultSet rs = pt.executeQuery();
			while(rs.next()) {
				VoteVO vo = new VoteVO();
				vo.setVote_id(rs.getInt("vote_id"));
				vo.setPoster_id(rs.getString("poster_id"));
				vo.setTitle(rs.getString("title"));
				vo.setContents(rs.getString("contents"));
				vo.setTime(rs.getDate("time"));
				picks.add(vo);
			}
			pt.close();
			rs.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}  catch (Exception e) {
			e.printStackTrace();
		}
		
		return picks;
	}
	public ArrayList<VoteVO> getSearchedVoteList(String searchTargetStr) {
		String sql = "select * from vote where title like ? or contents like ? order by time desc";
		ArrayList<VoteVO> votes = new ArrayList<VoteVO>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			try (
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@70.12.231.100:1521:xe", "vote", "vote");
				PreparedStatement pt = con.prepareStatement(sql);
			) {

				System.out.println(searchTargetStr);
				pt.setString(1, "%" + searchTargetStr + "%");
				pt.setString(2, "%" + searchTargetStr + "%");
				
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
	public boolean isExistVoteLike(String login_id, int vote_id) {
		String sql = "select count(*) as \"count\" from likevote where user_id=? and vote_id=?";
		int result = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			try (
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@70.12.231.100:1521:xe", "vote", "vote");
				PreparedStatement pt = con.prepareStatement(sql);
			) {

				System.out.println(login_id);
				System.out.println(vote_id);
				pt.setString(1, login_id);
				pt.setInt(2, vote_id);
				
				ResultSet rs = pt.executeQuery();
				
				if(rs.next()) {
					result = rs.getInt("count");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		
		return result == 1;
	}
	public VoteVO getVoteWithId(int vote_id) {
		String sql = "select * from vote where vote_id=?";
		VoteVO vo = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			try (
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@70.12.231.100:1521:xe", "vote", "vote");
				PreparedStatement pt = con.prepareStatement(sql);
			) {

				System.out.println(vote_id);
				pt.setInt(1, vote_id);
				
				ResultSet rs = pt.executeQuery();
				
				if (rs.next()) {
					vo = new VoteVO();
					vo.setVote_id(rs.getInt("vote_id"));
					vo.setPoster_id(rs.getString("poster_id"));
					vo.setTitle(rs.getString("title"));
					vo.setContents(rs.getString("contents"));
					vo.setTime(rs.getDate("time"));
					vo.setLike_count(rs.getInt("like_count"));
					vo.setComment_count(rs.getInt("comment_count"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 

		return vo;
	}
	public int decreaseVoteLike(int vote_id) {
		String sql = "update vote set like_count = like_count - 1 where vote_id=?";
		int result = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			try (
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@70.12.231.100:1521:xe", "vote", "vote");
				PreparedStatement pt = con.prepareStatement(sql);
			) {

				System.out.println(vote_id);
				pt.setInt(1, vote_id);
				result = pt.executeUpdate();
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		
		return result;
	}
	public int increaseVoteLike(int vote_id) {
		String sql = "update vote set like_count = like_count + 1 where vote_id=?";
		int result = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			try (
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@70.12.231.100:1521:xe", "vote", "vote");
				PreparedStatement pt = con.prepareStatement(sql);
			) {

				System.out.println(vote_id);
				pt.setInt(1, vote_id);
				result = pt.executeUpdate();
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		
		return result;
	}
	public int getTotalVoteCount() {
		String sql = "select count(*) as \"count\" from vote";
		int result = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			try (
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@70.12.231.100:1521:xe", "vote", "vote");
				PreparedStatement pt = con.prepareStatement(sql);
			) {
				ResultSet rs = pt.executeQuery();
				
				if (rs.next()) {
					result = rs.getInt("count");
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
