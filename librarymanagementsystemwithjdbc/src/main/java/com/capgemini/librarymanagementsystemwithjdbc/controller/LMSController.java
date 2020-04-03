package com.capgemini.librarymanagementsystemwithjdbc.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.capgemini.librarymanagementsystemwithjdbc.dto.BookBean;
import com.capgemini.librarymanagementsystemwithjdbc.dto.LibraryUserBean;
import com.capgemini.librarymanagementsystemwithjdbc.dto.RequestInfo;
import com.capgemini.librarymanagementsystemwithjdbc.exception.LMSException;
import com.capgemini.librarymanagementsystemwithjdbc.factory.LibraryManagementSystemFactory;
import com.capgemini.librarymanagementsystemwithjdbc.service.LibraryManagementSystemService;
import com.capgemini.librarymanagementsystemwithjdbc.validation.LibraryManagementSystemValidation;

public class LMSController {
	
	public static void main(String[] args) {
		LibraryUserBean libraryUserBean=LibraryManagementSystemFactory.getLibraryUserBean();
		LibraryManagementSystemService lmsService=LibraryManagementSystemFactory.getLibraryManagementSystemService();
		BookBean bookBean=LibraryManagementSystemFactory.getBookBean();
		RequestInfo requestInfo=LibraryManagementSystemFactory.getRequestInfo();
		LibraryManagementSystemValidation lmsValidation=LibraryManagementSystemFactory.getLibraryManagementSystemValidation();
		Scanner scanner=new Scanner(System.in);
		int choice;
		int check;
		int userChoice;
		do {
			System.out.println("1.Amin Login");
			System.out.println("2. User Login");
			System.out.println("Enter your choice");
			choice = scanner.nextInt();
			switch(choice) {
			case 1:
				System.out.println("-----------------");
				System.out.println("Enter Admin Email id");
				String emailId = scanner.next();
				System.out.println("Enter Admin password");
				String password = scanner.next();
				try {
					LibraryUserBean bean=lmsService.login(emailId, password);
					if(bean!=null) {
					System.out.println("Admin Login Successfull");
					do {
						System.out.println("1. Register");
						System.out.println("2. Search");
						System.out.println("3. Add Book");
						System.out.println("4. Show All Books");
						System.out.println("5. Show Users");
						System.out.println("6. Remove Book");
						System.out.println("7. Show Requests");
						System.out.println("8. Book Issue");
						System.out.println("9. Receive Returned Book");
						System.out.println("0. Exit");

						System.out.println("Enter your choice");
						check = scanner.nextInt();
						switch(check) {
						case 1:
							System.out.println("Enter user id");
							int userId=scanner.nextInt();
							System.out.println("Enter username");
							String userName=scanner.next();
							System.out.println("Enter Firstname");
							String firstName=scanner.next();
							System.out.println("Enter Lastname");
							String lastName=scanner.next();
							System.out.println("Enter email id");
							String email=scanner.next();
							System.out.println("Enter password");
							String userPassword=scanner.next();
							System.out.println("Enter role");
							String role=scanner.next();
							LibraryUserBean user1=new LibraryUserBean();
							user1.setId(userId);
							user1.setUserName(userName);
							user1.setFirstName(firstName);
							user1.setLastName(lastName);
							user1.setEmailId(email);
							user1.setPassword(userPassword);
							user1.setRole(role);
							
							boolean res=lmsService.addUser(user1);
							
							if(res) {
								System.out.println("user registered succesfully");
							}else {
								System.out.println("not registered");
							}
							break;
						case 2:
							System.out.println("Search a Book");
							System.out.println("Enter book Id");
							int searchBookId = scanner.nextInt();
							try {
							BookBean bookInfo=lmsService.searchBook(searchBookId);
							if(bookInfo!=null) {
							System.out.println("Book is found");
							System.out.println(bookInfo.getBookId());
							System.out.println(bookInfo.getBookName());
							System.out.println(bookInfo.getAuthorName());
							
							}
							}catch(Exception e) {
								System.out.println("book not avaliable in library");
							}
							
							break;
						case 3:
							System.out.println("Enter book id");
							int bookid=scanner.nextInt();
							System.out.println("Enter Book name");
							String bookname=scanner.next();
							System.out.println("Enter author name");
							String authorname=scanner.next();
							System.out.println("Enter publishers name");
							String bookPublisher=scanner.next();
							System.out.println("Enter category");
							String category=scanner.next();
							
							
							
							
							BookBean bookBean1 = new BookBean();

							bookBean1.setBookId(bookid);
							bookBean1.setAuthorName(authorname);
							bookBean1.setBookName(bookname);
							bookBean1.setPublisher(bookPublisher);
							bookBean1.setCategory(category);
						
							boolean bookAdded = lmsService.addBook(bookBean1);
							System.out.println(bookAdded);

							if (bookAdded) {
								System.out.println("book is added");
							} else {
								System.out.println("book is not added");
							}

							break;
						case 4:
							
							try {
								System.out.println("Books present in library are :");
								System.out.println("-------------------------------");

								List<BookBean> allBooks = lmsService.showBooks();
								Iterator<BookBean> iterator=allBooks.iterator();
								while(iterator.hasNext()) {
									
									BookBean book=(BookBean)iterator.next();
								

									System.out.println("Book id ---------->" + book.getBookId());
									System.out.println("Book Name --------> " + book.getBookName());
									System.out.println("Book Authour------> " + book.getAuthorName());
									System.out.println("Book publisher------->"+book.getPublisher());
									System.out.println("Book Category-------->"+book.getCategory());
									System.out.println("-----------------------------------------------------");
								}
								
							} catch (Exception e) {
								System.out.println("no books present in library");
							}
							break;
						case 5:
							try {
								System.out.println("users in library are :");
								System.out.println("-------------------------------");

								List<LibraryUserBean> allBooks = lmsService.showUsers();
								Iterator<LibraryUserBean> iterator=allBooks.iterator();
								while(iterator.hasNext()) {
									
									LibraryUserBean user=(LibraryUserBean)iterator.next();
								

									System.out.println("user id ---------->" + user.getId());
									System.out.println("Username --------> " + user.getUserName());
									System.out.println("Firstname------> " + user.getFirstName());
									System.out.println("Lastname------->"+user.getLastName());
									System.out.println("Email Id-------->"+user.getEmailId());
									System.out.println("Role---------->"+user.getRole());
									System.out.println("-----------------------------------------------------");
								}
								
							} catch (Exception e) {
								System.out.println("no books present in library");
							}
							break;
						case 6:
							System.out.println("Enter the bookId to be removed:");
							int bookId=scanner.nextInt();
							boolean isDeleted=lmsService.removeBook(bookId);
							if(isDeleted) {
								System.out.println("Book removed from library");
							}else {
								System.out.println("Book cannot be removed");
							}
							break;
						case 7:
							
							try {
								System.out.println("Requests for Books are :");
								System.out.println("-------------------------------");

								List<RequestInfo> requestInfos = lmsService.showRequests();
								for (RequestInfo info : requestInfos) {
									
									
									

									System.out.println("Request Id------------>"+info.getRequestId());
									System.out.println("User id----------- " + info.getUserId());
									System.out.println("Book id ---------- " + info.getBookId());

//									System.out.println("Book Issued ------" + info.isIssued());
//									System.out.println("Book Returned------" + info.isReturned());
//									System.out.println("Book IssueDate------------" + info.getIssuedDate());
									System.out.println("-------------------------------");
								}
							} catch (Exception e) {
								System.out.println("No requests");
							}
							break;

		
							
						}

						
					}while(check!=0);
					}
				}catch(LMSException e) {
					System.out.println("Invalid Credentials");
				}
				break;
			case 2:
				System.out.println("-----------------");
				System.out.println("Enter User Email id");
				String userEmailId = scanner.next();
				System.out.println("Enter User password");
				String userPassword = scanner.next();

				try {
					LibraryUserBean userInfo = lmsService.login(userEmailId, userPassword);
					if(userInfo!=null) {
					System.out.println("User logged in");
					}else {
						System.out.println("Invalid Credentials");
					}
					do {
						System.out.println("1. Search a Book");
						System.out.println("2. Request a Book");
						System.out.println("3. Return Book");
						System.out.println("0. Exit");
						System.out.println("Enter your choice");
						userChoice = scanner.nextInt();
						switch (userChoice) {
						case 1:
							System.out.println("Search a Book");
							System.out.println("Enter book Id");
							int searchBookId = scanner.nextInt();
							try {
							BookBean bookInfo=lmsService.searchById(searchBookId);
							if(bookInfo!=null) {
							System.out.println("Book is found");
							System.out.println("Book Id---------->"+bookInfo.getBookId());
							System.out.println("Book name is---------->"+bookInfo.getBookName());
							System.out.println("Author name is---------->"+bookInfo.getAuthorName());
//							System.out.println("Book is found");
							}else {
								System.out.println("Book is not avaliable in library");
							}
							}catch(Exception e) {
								e.printStackTrace();
							}
							
							break;
						case 2:
							System.out.println("Enter user Id");
							int userId=scanner.nextInt();
							libraryUserBean.setId(userId);
							System.out.println("Enter book Id");
							int bookId=scanner.nextInt();
							bookBean.setBookId(bookId);
							try {
								
								RequestInfo request=lmsService.bookRequest(libraryUserBean, bookBean);
//								 request = userService.bookRequest(userBean, bookBean);
								System.out.println("Request placed to admin");
								System.out.println("User Id-----" + request.getUserBean().getId());
								System.out.println("Book Id-----" + request.getBookBean().getBookId());
								

							} catch (Exception e) {

								System.out.println("Enter valid data or Invalid Request");
							}
							break;		
						

							
						
						}
			
				
			}while(userChoice!=0);
					
				}catch(Exception e) {
					
				}
			}
		}while(true);
	



	}

}
