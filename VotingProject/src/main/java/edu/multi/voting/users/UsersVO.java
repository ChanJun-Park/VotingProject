package edu.multi.voting.users;

public class UsersVO {
	String user_id;
	String nickname;
	String password;
	String email;
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "UsersVO [user_id=" + user_id + ", nickname=" + nickname + ", password=" + password + ", email=" + email
				+ "]";
	}
	
	
	
}
