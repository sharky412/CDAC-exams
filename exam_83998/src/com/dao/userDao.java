package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.account;
import com.entity.user;
import com.util.Db;

import interfaces.Operations;



public class userDao implements AutoCloseable, Operations {

	private Connection connection;
	
	
	public userDao() throws SQLException {
		connection = Db.getConnection();
	}

	public void addUser(user user) {
		String sql = "Insert into user ( email, password) values (?,?)";
		try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
			preparedStatement.setString(1, user.getEmail());
			preparedStatement.setString(2, user.getPassword());
			
			preparedStatement.executeUpdate();
			
		}catch (SQLException e) {
			System.out.println("adding user failed");
			e.printStackTrace();
		}
		
	}
	
	public void addAccount(account account) {
		String sql = "Insert into account (name, phone, balance, user_id) values (?,?,?,?)";
		try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
			preparedStatement.setString(1, account.getName());
			preparedStatement.setInt(2, account.getPhone());
			preparedStatement.setInt(3, account.getBalance());
			preparedStatement.setInt(4, account.getUser_id());
			
			preparedStatement.executeUpdate();
			
			
		}catch (SQLException e) {
			System.out.println("adding account failed");
			e.printStackTrace();
		}
		
	}


	public List<account> displayAccount(int user_id) throws SQLException {
		List<account> accountlist = new ArrayList<>();
		String sql = "select * from account where user_id = ?";
		try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
			preparedStatement.setInt(1, user_id);
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				account account = new account();
				account.setAccno(rs.getInt(1));
				account.setName(rs.getString(2));
				account.setPhone(rs.getInt(3));
				account.setBalance(rs.getInt(4));
				account.setAccno(rs.getInt(5));
				
				accountlist.add(account);
			}
		}catch (SQLException e) {
			System.out.println("no account found");
			e.printStackTrace();
		}
		
		
		return accountlist;
		
	}

	
	public void deleteUser(int user_id) {
		String sql = "Delete from user where userid = ?";
		try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
			preparedStatement.setInt(1, user_id);
			preparedStatement.executeUpdate();
			
		
		}catch (SQLException e) {
			System.out.println("deleting user failed");
			e.printStackTrace();
		}
	}
	
	
	public List<account> searchAccount(String name) {
		List<account> accountlist = new ArrayList<>();
		String  sql = "select * from Account where name = ?";
		try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
			preparedStatement.setString(1, name);
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				account account = new account();
				account.setAccno(rs.getInt(1));
				account.setName(rs.getString(2));
				account.setPhone(rs.getInt(3));
				account.setBalance(rs.getInt(4));
				account.setAccno(rs.getInt(5));
				
				accountlist.add(account);
			}
			
		}catch (SQLException e) {
			System.out.println("cannot find account");
			e.printStackTrace();
		}
		return accountlist;
		
	}


	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	

}
