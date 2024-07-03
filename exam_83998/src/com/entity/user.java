package com.entity;

public class user{
	private int userid;
	private String email;
	private String password;
	
	
	public user() {}
	
	public user(int userid, String email, String password) {
		super();
		this.userid = userid;
		this.email = email;
		this.password = password;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "user [userid=" + userid + ", email=" + email + ", password=" + password + "]";
	}

	
	
	
	

}
