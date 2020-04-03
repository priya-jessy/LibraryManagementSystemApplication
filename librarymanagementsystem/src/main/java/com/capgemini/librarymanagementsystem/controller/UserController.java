//package com.capgemini.librarymanagementsystem.controller;
//
//import java.util.Date;
//import java.util.Scanner;
//
//import com.capgemini.librarymanagementsystem.dto.BookBean;
//import com.capgemini.librarymanagementsystem.dto.UserBean;
////import com.capgemini.librarymanagementsystem.factory.UserFactory;
//import com.capgemini.librarymanagementsystem.service.UserServiceDAO;
//
//public class UserController {
//	public static void main(String[] args) {
//		Scanner scanner=new Scanner(System.in);
//		//UserServiceDAO service=UserFactory.getUserService();
//		int choice;
//		do {
//			System.out.println("Press 1 to register");
//			System.out.println("Press 2 to login");
//			System.out.println("Press 3 to search for book");
//			System.out.println("Press 4 to borrow book");
//			System.out.println("Press 5 to return book");
//			choice=scanner.nextInt();
//			switch(choice) {
//			case 1:
//				System.out.println("Enter Id");
//				int regId=scanner.nextInt();
//				System.out.println("Enter Username");
//				String regusername=scanner.next();
//				System.out.println("Enter Password");
//				String regpassword=scanner.next();
//				System.out.println("Enter Firstname");
//				String regfirstname=scanner.next();
//				System.out.println("Enter Lastname");
//				String regLastname=scanner.next();
//				System.out.println("Enter Department");
//				String regdepartment=scanner.next();
//				System.out.println("Enter Email");
//				String regemail=scanner.next();
//				UserBean information=new UserBean();
//				information.setUserid(regId);
//				information.setUsername(regusername);
//				information.setPassword(regpassword);
//				information.setFirstname(regfirstname);
//				information.setLastname(regLastname);
//				information.setDepartment(regdepartment);
//				information.setEmail(regemail);
////				//boolean check=service.register(information,count);
////				if(check) {
////					System.out.println("registered");
////				}else {
////					System.out.println("Email already exists");
////				}
////				break;
//			case 2:
//				System.out.println("Enter Email");
//				String email=scanner.next();
//				System.out.println("Enter Password");
//				String password=scanner.next();
//				try {
//					UserBean userinfo=service.login(email, password);
//					System.out.println("Login Successful");
//				}catch(Exception e) {
//					System.out.println("Invalid Credentials");
//				}
//				break;
//			case 3:
////				BookBean info=new BookBean();
////				System.out.println("Enter book name");
////				String name=scanner.next();
////				info.setBookname(name);
////				boolean result=service.searchByTitle(name);
////				if(result) {
////					System.out.println("Book is present");
////				}else {
////					System.out.println("Book is not present");
////				}
////				break;
////			case 4:
////				BookBean info1=new BookBean();
////				System.out.println("Enter book id");
////				int id=scanner.nextInt();
////				info1.setBookid(id);
////				boolean res=service.bookBorrow(id);
////				if(res) {
////					System.out.println("Book is borrowed");
////				}else {
////					System.out.println("Book is not borrowed");
////				}
////				break;
//
////			case 5:
////				BookBean info2=new BookBean();
////				System.out.println("Enter return date");
////				int bookid=scanner.nextInt();
////				info2.setBookid(bookid);
////				boolean res1=service.bookReturn(bookid);
////				if(res1) {
////					System.out.println("Book is borrowed");
////				}else {
////					System.out.println("Book is not borrowed");
////				}
////				break;
//
//
//			default:
//				break;
//			}
//		}while(choice!=0);
//
//	}
//
//}
