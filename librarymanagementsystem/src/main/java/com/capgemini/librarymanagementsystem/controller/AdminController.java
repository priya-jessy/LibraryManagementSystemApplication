//package com.capgemini.librarymanagementsystem.controller;
//
//import java.time.LocalDate;
//import java.util.Scanner;
//
//import com.capgemini.librarymanagementsystem.dto.AdminBean;
//import com.capgemini.librarymanagementsystem.dto.BookBean;
//import com.capgemini.librarymanagementsystem.factory.AdminFactory;
//import com.capgemini.librarymanagementsystem.service.AdminServiceDAO;
//
//public class AdminController {
//	public static void main(String[] args) {
//		Scanner sc=new Scanner(System.in);
//		AdminServiceDAO service=AdminFactory.getAdminServiceDAO();
//		int choice;
//		do {
//			System.out.println("press 1 to Register");
//			System.out.println("press 2 to login");
//			System.out.println("press 3 to addbook");
//			System.out.println("press 4 to issuebook");
//			System.out.println("press 5 to removebook");
//			System.out.println("press 6 to updatebook");
//			System.out.println("press 7 to searchbook");
//			System.out.println("press 8 to returnedbook");
//			System.out.println("press 9 to add user");
//			choice=sc.nextInt();
//			switch(choice) {
//			//			case 1:
//			//				System.out.println("Enter Id");
//			//				int regid=sc.nextInt();
//			//				System.out.println("Entet name");
//			//				String regname=sc.next();
//			//				System.out.println("Enter email");
//			//				String regEmail=sc.next();
//			//				System.out.println("Enter password");
//			//				String regpassword=sc.next();
//			//
//			//				AdminBean admin=new AdminBean();
//			//				
//			//				admin.setAdminpassword(regpassword);
//			//				admin.setAdminemail(regEmail);
//			//
//			//				// check=service.register(admin);
//			//				if(check) 
//			//					System.out.println("Registration Successful");
//			//				else 
//			//					System.out.println("Email already exists");
//			//
//			//				break;
//			case 2:
//				System.out.println("Enter email");
//				String email=sc.next();
//				System.out.println("Enter password");
//				String password=sc.next();
//				try {
//					AdminBean adminInfo =service.login(email, password);
//					System.out.println("login successful");
//				}catch(Exception e) {
//					System.out.println("Invalid credentials");
//				}
//				break;
//			case 3:
//				System.out.println("Enter book id");
//				int bookid=sc.nextInt();
//				System.out.println("Enter Book name");
//				String bookname=sc.next();
//				System.out.println("Enter author name");
//				String authorname=sc.next();
//				System.out.println("Enter publishers name");
//				String bookPublisher=sc.next();
//
//				BookBean book=new BookBean();
//				book.setBookid(bookid);
//				book.setBookname(bookname);
//				book.setAuthorname(authorname);
//				book.setPublisher(bookPublisher);
//
//				boolean isAdded=service.addBook(book);
//				if(isAdded) {
//					System.out.println("Added successfully");
//				}else {
//					System.out.println("Not Added");
//				}
//				break;
//				//			case 4:
//				//				System.out.println("Enter id to be issued");
//				//				int issueId=sc.nextInt();
//				//				boolean isIssued=service.issueBook(issueId);
//				//				if(isIssued) {
//				//					LocalDate todayDate=LocalDate.now();
//				//					System.out.println("issued successfully on "+todayDate);
//				//				}else {
//				//					System.out.println("not issued");
//				//				}
//				//				break;
//			case 5:
//				System.out.println("Enter id to br removed");
//				int removeId=sc.nextInt();
//				boolean remove=service.removeBook(removeId);
//				if(remove) {
//					System.out.println("removed successfully");
//				}else{
//					System.out.println("not removed");
//				}
//
//				break;
//			case 6:
//				System.out.println("Enter id to be update");
//				int updateId=sc.nextInt();
//				boolean isUpdated=service.updateBook(updateId);
//				if(isUpdated) {
//					System.out.println("updated successfully");
//				}else {
//					System.out.println("not updated");
//				}
//				break;
//			case 7:
//				//				System.out.println("Enter id to be searched");
//				//				int searchId=sc.nextInt();
//				//				boolean isFinded=service.searchBook(searchId);
//				//				if(isFinded) {
//				//					System.out.println("book has searched successfully");
//				//				}else {
//				//					System.out.println("not such result found");
//				//				}
//				//				break;
//			case 8:
//				System.out.println("Enter id to be returned");
//				int returnedId=sc.nextInt();
//				boolean isReturned=service.returnedBook(returnedId);
//				if(isReturned) {
//					LocalDate todayDate=LocalDate.now();
//					LocalDate returnDate=todayDate.plusDays(15);
//					System.out.println("return date "+returnDate);
//				}else {
//					System.out.println("not returned");
//				}
//				break;
//				//			case 9:
//				//				System.out.println("Enter email");
//				//				String emailId=sc.next();
//				//				System.out.println("Enter password");
//				//				String pass=sc.next();
//				//				boolean added=service.addUser(emailId, pass);
//				//				if(added) {
//				//					System.out.println("user added successfully");
//				//				}else {
//				//					System.out.println("User not added");
//				//				}
//				//				break;
//
//			}
//
//		}while(choice!=0);
//	}
//
//}
