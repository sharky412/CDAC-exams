package com.entity;


public class account{
	
	private int accno;
	private String name;
	private String email;
	private int phone;
	private int balance;
	private int user_id;
	
	public account() {}
	
	public account(int accno, String name, String email, int phone, int balance, int user_id) {
		super();
		this.accno = accno;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.balance = balance;
		this.user_id = user_id;
	}

	public int getAccno() {
		return accno;
	}

	public void setAccno(int accno) {
		this.accno = accno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getUser_id() {
		return user_id;
	}

	@Override
	public String toString() {
		return "account [accno=" + accno + ", name=" + name + ", email=" + email + ", phone=" + phone + ", balance="
				+ balance + ", user_id=" + user_id + "]";
	}

	

//	public void setUser_id(int user_id) {
//		this.user_id = user_id;
//	}
	
	
	

}
