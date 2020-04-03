//package com.capgemini.librarymanagementsystem.controller;
//
//import java.util.InputMismatchException;
//import java.util.List;
//import java.util.Scanner;
//
//import com.capgemini.librarymanagementsystem.dto.AdminBean;
//import com.capgemini.librarymanagementsystem.dto.BookBean;
//import com.capgemini.librarymanagementsystem.dto.UserBean;
//import com.capgemini.librarymanagementsystem.exception.LibraryManagementSystemException;
//import com.capgemini.librarymanagementsystem.factory.LibraryManagementSystemFactory;
//import com.capgemini.librarymanagementsystem.service.AdminServiceDAO;
//import com.capgemini.librarymanagementsystem.service.UserServiceDAO;
//import com.capgemini.librarymanagementsystem.validation.Validations;
//
//public class LibraryManagementSystemController {
//	static int count=0;
//	static int count1=0;
//	public static void main(String[] args) {
//		doRegistration();
//	}
//		
//		public static void doRegistration() {
//			BookBean bookBean=LibraryManagementSystemFactory.getBookBean();
//			Validations validations=LibraryManagementSystemFactory.getValidation();
//			UserBean userBean= LibraryManagementSystemFactory.getUserBean();
//			AdminServiceDAO adminService=LibraryManagementSystemFactory.getAdminServiceDAO();
//			AdminBean adminBean=
//		try(Scanner scanner=new Scanner(System.in);) {
//			
//			int choice;
//			int choice1;
//			int userChoice;
//			do {
//				System.out.println("press 1 to Admin login");
//				System.out.println("press 2 to User login");
//				System.out.println("Enter your choice");
//				choice=scanner.nextInt();
//				switch(choice) {
//				case 1:
//					System.out.println("Enter Admin Email id");
//					String adminEmailId=scanner.next();
//					System.out.println("Enter Admin password");
//					String adminPassword=scanner.next();
//					
//					
//					do {
//						
//						System.out.println("press 1 to addbook");
//						System.out.println("press 2 to issuebook");
//						System.out.println("press 3 to removebook");
//						System.out.println("press 4 to updatebook");
//						System.out.println("press 5 to searchbook");
//						System.out.println("press 6 to returnedbook");
//						System.out.println("press 7 to add user");
//						System.out.println("Press 8 to show users");
//						choice1=scanner.nextInt();
//						switch(choice1) {
//						
//						case 1:
//							BookBean book=new BookBean();
//							System.out.println("Enter book id");
//							String bookid=scanner.next();
//							boolean isValid=validations.idValidation(bookid);
//							while(!isValid) {
//								try {
//									throw new LibraryManagementSystemException("pleas enter valid data");
//								} catch(LibraryManagementSystemException lmse) {
//									System.err.println("Please enter valid id number");
//									bookid=scanner.next();
//									if(validations.idValidation(bookid)) {
//										break;
//									}
//								}
//							}
//							book.setBookId(Integer.parseInt(bookid));
//							
//							System.out.println("Enter Book name");
//							String bookname=scanner.next();
//							boolean validName=validations.validateByName(bookname);
//							while(!validName) {
//								try {
//									throw new LibraryManagementSystemException("Please enter vaild data");
//								}catch(InputMismatchException ime) {
//									System.err.println("Please enter proper book name");
//									bookname=scanner.next();
//									if(validations.validateByName(bookname)) {
//										break;
//									}
//								}catch(LibraryManagementSystemException lms) {
//									System.err.println("Please enter proper book name");
//									bookname=scanner.next();
//									if(validations.validateByName(bookname)) {
//										break;
//									}
//								}
//							}
//							book.setBookName(bookname);
//							
//							System.out.println("Enter author name");
//							String authorname=scanner.next();
//							boolean vaildAuthorName=validations.validateByName(authorname);
//							while(!vaildAuthorName) {
//								try {
//									throw new LibraryManagementSystemException("Please enter valid data");
//								}catch(LibraryManagementSystemException l) {
//									System.err.println("Please enter proper author name");
//									authorname=scanner.next();
//									if(validations.validateByName(authorname)) {
//										break;
//									}
//									
//								}
//							}
//							book.setAuthorName(authorname);
//							
//							System.out.println("Enter publishers name");
//							String bookPublisher=scanner.next();
//							boolean vaildPublisherName=validations.validateByName(bookPublisher);
//							while(!vaildPublisherName) {
//								try {
//									throw new LibraryManagementSystemException("Please enter valid data");
//								}catch(LibraryManagementSystemException e) {
//									System.err.println("Please enter proper publisher name");
//									bookPublisher=scanner.next();
//									if(validations.validateByName(bookPublisher)) {
//									break;
//								}
//								}
//							}
//							book.setPublisher(bookPublisher);
//
//							boolean isAdded=adminService.addBook(book);
//							if(isAdded) {
//								System.out.println("Added successfully");
//							}else {
//								System.err.println("Book is already Added");
//							}
//							break;
//						case 2:
//							
//							System.out.println("Enter 3 digit User Id To Isssue Book");
//							String userId = scanner.next();
//							boolean validIssueUserId=validations.ValidateByUserId(userId);
//							while(!validIssueUserId) {
//								try {
//									throw new LibraryManagementSystemException("Please enter valid data");
//								}catch(LibraryManagementSystemException lm) {
//									System.err.println("Please enter proper user id");
//									userId=scanner.next();
//									if(validations.idValidation(userId)) {
//										break;
//									}
//								}
//							}
//							System.out.println("Enter The Book Id To Issue Book");
//							String issueBookById = scanner.next();
//							boolean ValidateByBooKId=validations.idValidation(issueBookById);
//							while(!ValidateByBooKId) {
//								try {
//									throw new LibraryManagementSystemException("Please enter valid data");
//								}catch(LibraryManagementSystemException lm) {
//									System.err.println("Please enter proper book id");
//									issueBookById=scanner.next();
//									if(validations.idValidation(issueBookById)) {
//										break;
//									}
//								}
//							}
//							try {
//								boolean isIssued = adminService.bookIssue(userBean2, bookBean2);
//								if (isIssued) {
//									System.out.println("Book Issued");
//								} else {
//									System.out.println("Book cannot be issued");
//								}
//
//							} catch (Exception e) {
//								System.out.println("Invalid data request book cannot be issued");
//							}
//							break;
//							
//						case 3:
//							System.out.println("Enter id to be removed");
//							String removeId=scanner.next();
//							boolean validRemoveId=validations.idValidation(removeId);
//							while(!validRemoveId) {
//								try {
//									throw new LibraryManagementSystemException("Please enter valid data");
//								}catch(LibraryManagementSystemException se) {
//									System.err.println("Please enter proper book id");
//									removeId=scanner.next();
//									if(validations.idValidation(removeId)) {
//										break;
//									}
//								}
//							}
//							boolean remove=adminService.removeBook(Integer.parseInt(removeId));
//							if(remove) {
//								System.out.println("removed successfully");
//							}else{
//								System.out.println("Invalid book to remove");
//							}
//
//							break;
//						case 4:
//							System.out.println("Enter id to be update");
//							String updateId=scanner.next();
//							boolean validUpdateId=validations.idValidation(updateId);
//							while(!validUpdateId) {
//								try {
//									throw new LibraryManagementSystemException("Please enter valid data");
//								}catch(LibraryManagementSystemException lmse) {
//									System.err.println("Please enter proper book id");
//									updateId=scanner.next();
//									if(validations.idValidation(updateId)) {
//										break;
//									}
//								}
//							}
//							boolean isUpdated=adminService.updateBook(Integer.parseInt(updateId));
//							if(isUpdated) {
//								System.out.println("press 1 to update book name");
//								System.out.println("press 2 to update author name");
//								System.out.println("press 3 to update publisher");
//								int updateBookDetails=scanner.nextInt();
//								switch(updateBookDetails) {
//								
//								case 1:
//									System.out.println("Enter book name");
//									String bookName=scanner.next();
//									boolean isVaildName=validations.validateByName(bookName);
//									while(!isVaildName) {
//										try {
//											throw new LibraryManagementSystemException("Please enter valid name");
//										}catch(LibraryManagementSystemException p) {
//											System.err.println("Please enter name once again");
//											bookName=scanner.next();
//											if(validations.validateByName(bookName)) {
//												break;
//											}
//										}
//									}
//								
//								bookBean.setBookname(bookName);
//								break;
//								
//								case 2:
//									System.out.println("Enter author name");
//									String authorName=scanner.next();
//									boolean isVaildAuthorName=validations.validateByName(authorName);
//									while(!isVaildAuthorName) {
//										try {
//											throw new LibraryManagementSystemException("Please enter valid author name");
//										}catch(LibraryManagementSystemException p) {
//											System.err.println("Please enter name once again");
//											authorName=scanner.next();
//											if(validations.validateByName(authorName)) {
//												break;
//											}
//										}
//									}
//								
//								bookBean.setAuthorName(authorName);
//								break;
//								case 3:
//									System.out.println("Enter publisher name");
//									String publisherName=scanner.next();
//									boolean isVaildPublisherName=validations.validateByName(publisherName);
//									while(!isVaildPublisherName) {
//										try {
//											throw new LibraryManagementSystemException("Please enter valid author name");
//										}catch(LibraryManagementSystemException p) {
//											System.err.println("Please enter name once again");
//											publisherName=scanner.next();
//											if(validations.validateByName(publisherName)) {
//												break;
//											}
//										}
//									}
//								
//								bookBean.setPublisher(publisherName);
//								break;
//								}
//								System.out.println("updated successfully");
//							}else {
//								System.out.println("Book is not existing");
//							}
//							break;
//						case 5:
//							System.out.println("Enter id to be searched");
//							String searchById=scanner.next();
//							boolean searchBook=validations.idValidation(searchById);
//							while(!searchBook) {
//								try {
//									throw new LibraryManagementSystemException("Please enter valid data");
//								}catch(LibraryManagementSystemException a) {
//									System.err.println("Please enter proper book id");
//									searchById=scanner.next();
//									if(validations.idValidation(searchById)) {
//										
//										break;
//									}
//								}
//							}
//							try {
//							BookBean search=adminService.searchBook(Integer.parseInt(searchById));
//							
//								System.out.println("book has founded");
//								System.out.println("Book id------->"+search.getBookId());
//								System.out.println("Book name------->"+search.getBookName());
//								System.out.println("Book Author-------->"+search.getAuthorName());
//								System.out.println("Book publisher------->"+search.getPublisher());
//								
//							}catch(Exception e) {
//								System.out.println("Book not found");
//							}
//							break;
//						case 6:
//							System.out.println("Enter id to be returned");
//							String returnedId=scanner.next();
//							boolean returnBook=validations.idValidation(returnedId);
//							while(!returnBook) {
//								try {
//									throw new LibraryManagementSystemException("Please enter valid data");
//								}catch(LibraryManagementSystemException s) {
//									System.err.println("Please enter proper Id");
//									returnedId=scanner.next();
//									if(validations.idValidation(returnedId)) {
//										break;
//									}
//								}
//							}
//							boolean isReturned=adminService.returnedBook(Integer.parseInt(returnedId));
//							if(isReturned) {
//								System.out.println("returned successfully");
//							}else {
//								System.out.println("not returned");
//							}
//							break;
//						case 7:
//							
//							
//							//UserBean bean=new UserBean();
//							System.out.println("Enter user Id");
//							String id=scanner.next();
//							boolean idValidation=validations.ValidateByUserId(id);
//							while(!idValidation) {
//								try {
//									throw new LibraryManagementSystemException("Please enter valid data");
//								}catch(LibraryManagementSystemException v) {
//									System.err.println("Please enter proper userId");
//									id=scanner.next();
//									if(validations.ValidateByUserId(id)) {
//
//										break;
//									}
//								}
//							}
//							userBean.setUserid(Integer.parseInt(id));
//							System.out.println("Enter Firstname");
//							String regFirstName=scanner.next();
//							boolean nameValidation=validations.validateByName(regFirstName);
//							while(!nameValidation) {
//								try {
//									throw new LibraryManagementSystemException("Please enter proper data");
//								}catch(LibraryManagementSystemException x) {
//									System.err.println("Please enter proper FirstName");
//									regFirstName=scanner.next();
//									if(validations.validateByName(regFirstName)) {
//										break;
//									}
//								}
//							}
//							userBean.setFirstname(regFirstName);
//							
//							System.out.println("Enter Lastname");
//							String regLastName=scanner.next();
//							boolean lastNameValidation=validations.validateByName(regLastName);
//							while(!lastNameValidation) {
//								try {
//									throw new LibraryManagementSystemException("Please enter proper data");
//								}catch(LibraryManagementSystemException x) {
//									System.err.println("Please enter proper Lastname");
//									regLastName=scanner.next();
//									if(validations.validateByName(regLastName)) {
//										break;
//									}
//								}
//							}
//							userBean.setLastname(regLastName);
//
//							System.out.println("Enter department");
//							String department=scanner.next();
//							boolean departmentValidation=validations.validateByName(department);
//							while(!departmentValidation) {
//								try {
//									throw new LibraryManagementSystemException("Please enter proper data");
//								}catch(LibraryManagementSystemException x) {
//									System.err.println("Please enter proper Department name");
//									department=scanner.next();
//									if(validations.validateByName(department)) {
//										break;
//									}
//								}
//							}
//							userBean.setDepartment(department);
//							
//							
//							
//							
//							System.out.println("Enter email");
//							String emailId=scanner.next();
//							boolean vaildEmail=validations.validateByEmail(emailId);
//							while(!vaildEmail) {
//								try {
//									throw new LibraryManagementSystemException("Please enter proper data");
//								}catch(LibraryManagementSystemException m) {
//									System.err.println("Please enter proper name");
//									emailId=scanner.next();
//									if(validations.validateByEmail(emailId)) {
//										break;
//									}
//								}
//							}
//							userBean.setEmail(emailId);
//							
//							System.out.println("Enter password");
//							String pass=scanner.next();
//							boolean ValidPassword=validations.passwordValidation(pass);
//							while(!ValidPassword) {
//								try {
//									throw new LibraryManagementSystemException("Please enter proper data");
//								}catch(LibraryManagementSystemException k) {
//									System.err.println("Please enter vaild password");
//									pass=scanner.next();
//									if(validations.passwordValidation(pass)) {
//										break;
//									}
//								}
//							}
//							userBean.setPassword(pass);
//							try {
//							 
//							boolean adminBean=adminService.addUser(userBean);
//							if(adminBean) {
//								System.out.println("user registration successfully");
//								
//							}else {
//								System.out.println("User already exists");
//							}
//							}catch(Exception e){
//								System.err.println(e.getMessage());
//							}
//							break;
//								
//					case 8:
//						try {
//							System.out.println("Users of Library are :");
//
//							List<UserBean> userInfos = adminService.showUsers();
//							for (UserBean info : userInfos) {
//
//								System.out.println("User id ---------- " + info.getUserid());
//								System.out.println("User Name -------- " + info.getUsername());
//								System.out.println("User Email------ " + info.getEmail());
//								System.out.println(
//										"User No Of Books Borrowed ------- " + info.getNumberOfBooks());
//								
//							}
//						} catch (Exception e) {
//							System.out.println("no books present in library");
//						}
//						break;
//						break;
//						
//						
//
//					}while(choice1!=0);
//
//					
//				case 2:
//					UserServiceDAO userService=LibraryManagementSystemFactory.getUserService();
//					int choice2;
//					do {
//						System.out.println("Press 1 to register");
//						System.out.println("Press 2 to login");
//						System.out.println("Press 3 to search for book");
//						System.out.println("Press 4 to borrow book");
//						System.out.println("Press 5 to return book");
//						choice2=scanner.nextInt();
//						switch(choice2) {
//						case 1:
//							try {
//							System.out.println("Enter Id");
//							int regId=scanner.nextInt();
//							System.out.println("Enter Username");
//							String regusername=scanner.next();
//							System.out.println("Enter Password");
//							String regpassword=scanner.next();
//							System.out.println("Enter Firstname");
//							String regfirstname=scanner.next();
//							System.out.println("Enter Lastname");
//							String regLastname=scanner.next();
//							System.out.println("Enter Department");
//							String regdepartment=scanner.next();
//							System.out.println("Enter Email");
//							String regemail=scanner.next();
//							UserBean information=new UserBean();
//							information.setUserid(regId);
//							information.setUsername(regusername);
//							information.setPassword(regpassword);
//							information.setFirstname(regfirstname);
//							information.setLastname(regLastname);
//							information.setDepartment(regdepartment);
//							information.setEmail(regemail);
//							boolean check=userService.register(information,count1);
//							if(check) {
//								System.out.println("registered");
//								count++;
//							}
//							}catch(LibraryManagementSystemException e) {
//								System.err.println(e.getMessage());
//							}
//							break;
//						case 2:
//							System.out.println("Enter Email");
//							String email=scanner.next();
//							boolean vaildByEmail=validations.validateByEmail(email);
//							while(!vaildByEmail) {
//								try {
//									throw new LibraryManagementSystemException("Please enter proper data");
//								}catch(LibraryManagementSystemException m) {
//									System.err.println("Please enter proper name");
//									email=scanner.next();
//									if(validations.validateByEmail(email)) {
//										break;
//									}
//								}
//							}
//							
//		
//							System.out.println("Enter Password");
//							String password=scanner.next();
//							boolean ValidByPassword=validations.passwordValidation(password);
//							while(!ValidByPassword) {
//								try {
//									throw new LibraryManagementSystemException("Please enter proper data");
//								}catch(LibraryManagementSystemException k) {
//									System.err.println("Please enter vaild password");
//									password=scanner.next();
//									if(validations.passwordValidation(password)) {
//										break;
//									}
//								}
//							}
//							
//							try {
//								UserBean userinfo=userService.login(email, password);
//								System.out.println("Login Successful");
//							}catch(Exception e) {
//								System.err.println(e.getMessage());
//							}
//							break;
//						case 3:
//							System.out.println("Enter id to be searched");
//							String searchById=scanner.next();
//							boolean searchBook=validations.idValidation(searchById);
//							while(!searchBook) {
//								try {
//									throw new LibraryManagementSystemException("Please enter valid data");
//								}catch(LibraryManagementSystemException a) {
//									System.err.println("Please enter proper book id");
//									searchById=scanner.next();
//									if(validations.idValidation(searchById)) {
//										searchBook=true;
//										break;
//									}
//								}
//							}
//							BookBean search=adminService.searchBook(Integer.parseInt(searchById));
//							if(search!=null) {
//								System.out.println("book has founded");
//								System.out.println("Book id------->"+search.getBookId());
//								System.out.println("Book name------->"+search.getBookName());
//								System.out.println("Book Author-------->"+search.getAuthorName());
//								System.out.println("Book publisher------->"+search.getPublisher());
//								
//							}else {
//								System.out.println("No such Book found");
//							}
//							break;
//							
//						case 4:
//
//							System.out.println("Enter book id");
//							String bookId = scanner.next();
//							boolean validateByBookId=validations.idValidation(bookId);
//							while(!validateByBookId) {
//								try {
//									throw new LibraryManagementSystemException("Please enter valid data");
//								}catch(LibraryManagementSystemException a) {
//									System.err.println("Please enter proper book id");
//									bookId=scanner.next();
//									if(validations.idValidation(bookId)) {
//										break;
//									}
//								}
//							}
//							System.out.println("Enter User id");
//							String userId = scanner.next();
//							boolean validateByUserId=validations.ValidateByUserId(userId);
//							while(!validateByUserId) {
//								try {
//									throw new LibraryManagementSystemException("Please enter valid data");
//								}catch(LibraryManagementSystemException v) {
//									System.err.println("Please enter proper userId");
//									userId=scanner.next();
//									if(validations.ValidateByUserId(userId)) {
//
//										break;
//									}
//								}
//							}
//
//							try {
//								boolean res = userService.bookBorrow(Integer.parseInt(bookId), Integer.parseInt(userId));
//								if (res) {
//									System.out.println("Book is borrowed");
//								}
//							} catch (Exception e) {
//								System.err.println(e.getMessage());
//							}
//							break;
//
//						case 5:
//							
//							System.out.println("Enter book id to return book");
//							String returnBookId = scanner.next();
//							boolean validateById=validations.idValidation(returnBookId);
//							while(!validateById) {
//								try {
//									throw new LibraryManagementSystemException("Please enter valid data");
//								}catch(LibraryManagementSystemException a) {
//									System.err.println("Please enter proper book id");
//									returnBookId=scanner.next();
//									if(validations.idValidation(returnBookId)) {
//										break;
//									}
//								}
//							}
//							
//							System.out.println("Enter user id to return book");
//							String returnUserId = scanner.next();
//							boolean validateByUser=validations.ValidateByUserId(returnUserId);
//							while(!validateByUser) {
//								try {
//									throw new LibraryManagementSystemException("Please enter valid data");
//								}catch(LibraryManagementSystemException v) {
//									System.err.println("Please enter proper userId");
//									returnUserId=scanner.next();
//									if(validations.ValidateByUserId(returnUserId)) {
//
//										break;
//									}
//								}
//							}
//							
//
//							try {
//								boolean res1 = userService.bookReturn(Integer.parseInt(returnBookId),Integer.parseInt(returnUserId));
//								if (res1) {
//									System.out.println("Book is returned");
//								}
//							} catch (Exception e) {
//								System.err.println(e.getMessage());
//							}
//							break;
//
//							
//							
//
//						default:
//							break;
//						}break;
//					}while(choice2!=0);
//
//					break;
//
//				default:
//					break;
//				}
//			}while(choice!=0);
//		
//		}catch(InputMismatchException e) {
//			System.err.println("Enter proper data");
//		}
//
//	}
//}