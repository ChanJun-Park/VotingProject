package edu.multi.voting.bookmark;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

import edu.multi.voting.users.UsersVO;
import edu.multi.voting.vote.VoteVO;

@Component("bmdao")
public class BookmarkDAO {
	public  ArrayList<BookmarkVO> getBookmark() {
		ArrayList<BookmarkVO> bookmarks = new ArrayList<BookmarkVO>();
		try {
			
			String sql = "select bookmarker_id, vote_id from bookmark";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@70.12.231.100:1521:xe","vote","vote");
			PreparedStatement pt = con.prepareStatement(sql);
			ResultSet rs = pt.executeQuery();

			//북마크 안했다.
			while(rs.next()) {
				BookmarkVO vo = new BookmarkVO();
				vo.setBookmarker_id(rs.getString("bookmarker_id"));
				vo.setVote_id(rs.getInt("vote_id"));
				bookmarks.add(vo);
				
			}

			pt.close();
			con.close();
			
			}catch(Exception e) {
				e.printStackTrace();
			}
		
		return bookmarks;
			
		}
		
		
		
	
	public void addBookmark(String bookmarker_id, int vote_id) {
		try {

			String sql = "insert into bookmark values(?,?)"; 
			//prepared statement

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@70.12.231.100:1521:xe","vote","vote");
			PreparedStatement pt = con.prepareStatement(sql);
			pt.setInt(1, vote_id);
			pt.setString(2, bookmarker_id);

			System.out.println("bookamerkm"+bookmarker_id);
			System.out.println("vote"+vote_id);
			pt.executeUpdate();


			pt.close();
			con.close();
			
			}catch(Exception e) {
				e.printStackTrace();
			}
	}
	
	public String findBookmark(BookmarkVO vo) {
		String check="error";
		try {
			String sql = "select * from bookmark where bookmarker_id=? and vote_id = ?";

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@70.12.231.100:1521:xe","vote","vote");
			PreparedStatement pt = con.prepareStatement(sql);
			pt.setString(1, vo.getBookmarker_id());
			pt.setInt(2, vo.getVote_id());
			ResultSet rs = pt.executeQuery();
			//이미 북마크 했다.
			if(rs.next()) {
				check="marked_already";
			}
			//북마크 안했다.
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
		
		
	
	public void deleteBookmark(BookmarkVO vo) {
		try {

				String sql = "delete from bookmark where vote_id = ? and bookmarker_id = ?"; 
				//prepared statement

				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection(
						"jdbc:oracle:thin:@70.12.231.100:1521:xe","vote","vote");
				PreparedStatement pt = con.prepareStatement(sql);

				pt.setInt(1, vo.getVote_id());
				pt.setString(2, vo.getBookmarker_id());
				pt.executeUpdate();


				pt.close();
				con.close();
				
				}catch(Exception e) {
					e.printStackTrace();
				}

		
	}
	
}
