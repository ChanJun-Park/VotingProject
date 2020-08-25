package edu.multi.voting.users;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Component;

@Component("user_dao")
public class UsersDAO {
	
	public void createUser(UsersVO vo) {
		try {
			
			String sql = "insert into users values(?,?,?,?)"; 
			//prepared statement

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@70.12.231.100:1521:xe","vote","vote");
			PreparedStatement pt = con.prepareStatement(sql);
			pt.setString(1, vo.getUser_id());
			pt.setString(2, vo.getNickname());
			pt.setString(3, vo.getPassword());
			pt.setString(4, vo.getEmail());
			
			
			int insertRow = pt.executeUpdate();
			
		
			pt.close();
			con.close();
			
			}catch(Exception e) {
				e.printStackTrace();
			}
	}
	
	//delete by userVO
	public void deleteUser(UsersVO user) {
		try {

				String sql = "delete from users where user_id=?"; 
				//prepared statement

				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection(
						"jdbc:oracle:thin:@70.12.231.100:1521:xe","vote","vote");
				PreparedStatement pt = con.prepareStatement(sql);
				pt.setString(1, user.getUser_id());
				pt.executeUpdate();


				pt.close();
				con.close();
				
				}catch(Exception e) {
					e.printStackTrace();
				}

		
	}
	
	//id pw��ġüũ
	public UsersVO validcheck(String user_id,String password) {
		UsersVO vo=new UsersVO();
	try {
			
			String sql = "select user_id, password from users where user_id = ?"; 
			//prepared statement

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@70.12.231.100:1521:xe","vote","vote");
			PreparedStatement pt = con.prepareStatement(sql);
			pt.setString(1, user_id);
			ResultSet rs = pt.executeQuery();
			while(rs.next()) {
				vo.setUser_id(rs.getString("user_id"));
				vo.setPassword(rs.getString("password"));
			}

			pt.close();
			con.close();
			
			}catch(Exception e) {
				e.printStackTrace();
			}
		
		return vo;
		
	
		
		
	}

	
	//�ߺ�üũ
	public String dupcheck(String user_id) {
		String check ="";
		try {
			
			String sql = "select user_id from users where user_id = ?"; 
			//prepared statement

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@70.12.231.100:1521:xe","vote","vote");
			PreparedStatement pt = con.prepareStatement(sql);
			pt.setString(1, user_id);
			ResultSet rs = pt.executeQuery();
	
				
				if(rs.next()==true) {
					check = "NO";
				}
				else {
					check = "YES";
				}
				System.out.println("�ߺ�üũ: "+check);
			

			pt.close();
			con.close();
			
			}catch(Exception e) {
				e.printStackTrace();
			}
		//�˻��ؼ� ������ = �ߺ��Ȱ� ������ false
		System.out.println("return + "+check);
		return check;
		
	}
	
	
}
