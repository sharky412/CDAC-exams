package test;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.dao.userDao;
import com.entity.*;

public class tester {
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		int choice = 0;
		
		do {
			System.out.println("\n Menu");
			System.out.println("0. Exit");
			System.out.println("1. Add new user");
			System.out.println("2. Add accounts");
			System.out.println("3. Display my Account");
			System.out.println("4. Delete Account");
			System.out.println("5. Search Account");
			System.out.println("enter you choice");
			
			
			if (sc.hasNextInt()) {
                choice = sc.nextInt();
//                scanner.nextLine(); // Consume newline character

                switch (choice) {
				case 1:
					try(userDao userdao = new userDao()){
						user user = new user();
						System.out.println("Enter email");
						user.setEmail(sc.next());
						System.out.println("Enter password");
						user.setPassword(sc.next());
						
						userdao.addUser(user);
						System.out.println("user added successfully");
						
						}catch (Exception e) {
							e.printStackTrace();
					}
					break;
					
				case 2:
					try(userDao userdao = new userDao()){
						account account = new account();
						System.out.println("Enter name");
						account.setName(sc.next());
						System.out.println("Enter phone");
						account.setPhone(sc.nextInt());
						System.out.println("Enter balance");
						account.setBalance(sc.nextInt());
						System.out.println("Enter user id");
						account.setUser_id(sc.nextInt());
						 
						userdao.addAccount(account);
						System.out.println("Account added successfully");
						
						
						
					}catch (Exception e) {
						e.printStackTrace();
					}
					break;
					
					
				case 3:
					try(userDao userdao = new userDao()){
						System.out.println("Enter user id");
						List<account> modules = userdao.displayAccount(sc.nextInt());
						for (account account : modules) {
							System.out.println(account);
						}	
					}catch (Exception e) {
						e.printStackTrace();
					}
					break;

					
				case 4:
					try(userDao userdao = new userDao()){
						System.out.println("Enter id");
						userdao.deleteUser(sc.nextInt());
                         
					}catch (Exception e) {
						e.printStackTrace();
					}
					break;
					
				case 5:
					try(userDao userdao = new userDao()){
						System.out.println("Enter name");
						List<account> modules = userdao.searchAccount(sc.next());
						for (account account : modules) {
							System.out.println(account);
						}
                         
					}catch (Exception e) {
						e.printStackTrace();
					}
					break;
					
				default:
					System.out.println("Invalid choice. Please try again.");
					break;
				}
			}
		
		}while(choice!=0);}}
	


