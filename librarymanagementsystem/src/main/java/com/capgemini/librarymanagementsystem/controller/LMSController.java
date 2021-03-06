package com.capgemini.librarymanagementsystem.controller;

import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.capgemini.librarymanagementsystem.dto.AdminBean;
import com.capgemini.librarymanagementsystem.dto.BookBean;
import com.capgemini.librarymanagementsystem.dto.RequestInfo;
import com.capgemini.librarymanagementsystem.dto.UserBean;
import com.capgemini.librarymanagementsystem.exception.LibraryManagementSystemException;
import com.capgemini.librarymanagementsystem.factory.LibraryManagementSystemFactory;
import com.capgemini.librarymanagementsystem.service.AdminServiceDAO;
import com.capgemini.librarymanagementsystem.service.UserServiceDAO;
import com.capgemini.librarymanagementsystem.validation.LibraryManagementSystemValidation;

public class LMSController {

	public static void main(String[] args) {
		LMSController controller = new LMSController();
		try {
			controller.lmsController();
		} catch (InputMismatchException e) {
			System.err.println("Enter valid data");
		} finally {
			try {
				controller.lmsController();
			} catch (InputMismatchException e) {
				System.err.println("Enter valid data");
			} finally {
				controller.lmsController();
			}
		}
	}

	public void lmsController() {

		AdminServiceDAO service = LibraryManagementSystemFactory.getAdminServiceDAO();
		UserServiceDAO userService = LibraryManagementSystemFactory.getUserService();
		Scanner scanner = new Scanner(System.in);
		UserBean userBean = new UserBean();
		BookBean bookBean = new BookBean();
		AdminBean adminBean = new AdminBean();
		LibraryManagementSystemValidation validation = LibraryManagementSystemFactory.getValidation();

		int choice, check, userChoice;
		do {

			System.out.println("1.Amin Login");
			System.out.println("2. User Login");
			System.out.println("Enter your choice");
			choice = scanner.nextInt();
			switch (choice) {

			case 1:
				System.out.println("-----------------");
				System.out.println("Enter Admin Email id");
				String adminEmailId = scanner.next();
				System.out.println("Enter Admin password");
				String adminPassword = scanner.next();

				try {
					AdminBean adminBean1 = service.login(adminEmailId, adminPassword);
					System.out.println("Admin logged in");
					do {
						System.out.println("1. Register");
						System.out.println("2. Search");
						System.out.println("3. Add Book");
						System.out.println("4. Remove Book");
						System.out.println("5. Show All Books");
						System.out.println("6. Book Issue");
						System.out.println("7. Show Users");
						System.out.println("8. Show Requests");
						System.out.println("9. Receive Returned Book");
						System.out.println("0. Exit");

						System.out.println("Enter your choice");
						check = scanner.nextInt();

						switch (check) {
						case 1:
							System.out.println("Enter your Registration Details");
							System.out.println("Enter user id");
							String regId = scanner.next();
							boolean validateUserId = validation.ValidateByUserId(regId);
							while (!validateUserId) {
								try {
									throw new LibraryManagementSystemException("please enter valid data");
								} catch (LibraryManagementSystemException lmse) {
									System.err.println("Please enter valid id number");
									regId = scanner.next();
									if (validation.ValidateByUserId(regId)) {
										break;
									}
								}
							}
							System.out.println("Enter user name");
							String regName = scanner.next();
							boolean ValidateByName = validation.validateByName(regName);
							while (!ValidateByName) {
								try {
									throw new LibraryManagementSystemException("Please enter valid data");
								} catch (LibraryManagementSystemException lmse) {
									System.err.println("Please enter proper name");
									regName = scanner.next();
									if (validation.validateByName(regName)) {
										break;
									}
								}
							}
							System.out.println("Enter Email Id");
							String regEmailId = scanner.next();
							boolean validateByEmail = validation.validateByEmail(regEmailId);
							while (!validateByEmail) {
								try {
									throw new LibraryManagementSystemException("Please enter valid Email Id");
								} catch (LibraryManagementSystemException lmse) {
									System.err.println("Please valid Email");
									regEmailId = scanner.next();
									if (validation.validateByEmail(regEmailId)) {
										break;
									}
								}
							}
							System.out.println("Enter password");
							System.out.println("Password shoud contain 8-15 characters,atleast one uppercase,lowercase and atleast one special charater");
							String regPassword = scanner.next();
							boolean validateByPassword = validation.passwordValidation(regPassword);
							while (!validateByPassword) {
								try {
									throw new LibraryManagementSystemException("Please enter valid password");
								} catch (LibraryManagementSystemException lmse) {
									System.err.println("Please enter valid password");
									regPassword = scanner.next();
									if (validation.passwordValidation(regPassword)) {
										break;
									}
								}
							}

							// UserBean userBean1 = new UserBean();
							userBean.setUserid(Integer.parseInt(regId));
							userBean.setUsername(regName);
							userBean.setEmail(regEmailId);
							userBean.setPassword(regPassword);
							boolean result = service.addUser(userBean);

							if (result) {
								System.out.println("user Registered");
							} else {
								System.out.println("user already Exsits");
							}
							break;

						case 2:
							System.out.println("Search a Book");
							System.out.println("Enter book Id");
							String searchBookId = scanner.next();
							boolean validateByBookId = validation.idValidation(searchBookId);
							while (!validateByBookId) {
								try {
									throw new LibraryManagementSystemException("Please enter valid data");
								} catch (LibraryManagementSystemException lmse) {
									System.err.println("Please enter proper book id");
									searchBookId = scanner.next();
									if (validation.idValidation(searchBookId)) {
										break;
									}
								}
							}
							try {
								BookBean bookSearch = service.searchBook(Integer.parseInt(searchBookId));
								System.out.println("Book found");
								System.out.println("Book Id ------------->" + bookSearch.getBookId());
								System.out.println("Book name-------------->" + bookSearch.getBookName());
								System.out.println("Author name---------->" + bookSearch.getAuthorName());

							} catch (Exception e) {
								System.out.println("Book not found");

							}
							break;

						case 3:
							System.out.println("Add Book Details");
							System.out.println("Enter Book id");
							String bookId = scanner.next();
							boolean validateBookId = validation.idValidation(bookId);
							while (!validateBookId) {
								try {
									throw new LibraryManagementSystemException("Please enter valid data");
								} catch (LibraryManagementSystemException lmse) {
									System.err.println("Please enter proper book id");
									bookId = scanner.next();
									if (validation.idValidation(bookId)) {
										break;
									}
								}
							}
							System.out.println("Enter Author name");
							String authourName = scanner.next();
							boolean ValidateByAuthorName = validation.validateByName(authourName);
							while (!ValidateByAuthorName) {
								try {
									throw new LibraryManagementSystemException("Please enter valid data");
								} catch (LibraryManagementSystemException lmse) {
									System.err.println("Please enter proper name");
									authourName = scanner.next();
									if (validation.validateByName(authourName)) {
										break;
									}
								}
							}
							System.out.println("Enter Book Title");
							String bookTitle = scanner.next();
							boolean ValidateByBookName = validation.validateByName(bookTitle);
							while (!ValidateByBookName) {
								try {
									throw new LibraryManagementSystemException("Please enter valid data");
								} catch (LibraryManagementSystemException lmse) {
									System.err.println("Please enter proper name");
									bookTitle = scanner.next();
									if (validation.validateByName(bookTitle)) {
										break;
									}
								}
							}
							BookBean bookBean1 = new BookBean();

							bookBean1.setBookId(Integer.parseInt(bookId));
							bookBean1.setAuthorName(authourName);
							bookBean1.setBookName(bookTitle);

							boolean bookAdded = service.addBook(bookBean1);
							System.out.println(bookAdded);

							if (bookAdded) {
								System.out.println("book is added");
							} else {
								System.out.println("This is an existing book");
							}

							break;
						case 4:
							System.out.println("Enter book id to remove ");
							String removeBookId = scanner.next();
							boolean validateByBookId1 = validation.idValidation(removeBookId);
							while (!validateByBookId1) {
								try {
									throw new LibraryManagementSystemException("Please enter valid data");
								} catch (LibraryManagementSystemException lmse) {
									System.err.println("Please enter proper book id");
									removeBookId = scanner.next();
									if (validation.idValidation(removeBookId)) {
										break;
									}
								}
							}
							bookBean.setBookId(Integer.parseInt(removeBookId));
							boolean bookRemoved = service.removeBook(Integer.parseInt(removeBookId));
							if (bookRemoved) {
								System.out.println("Book Removed");
							} else {
								System.out.println("Invalid book to remove");
							}
							break;

						case 5:

							try {
								System.out.println("Books present in library are :");
								System.out.println("-------------------------------");

								List<BookBean> allBooks = service.showBooks();
								for (BookBean book : allBooks) {

									System.out.println("Book id ----------> " + book.getBookId());
									System.out.println("Book Name -------- >" + book.getBookName());
									System.out.println("Book Authour------ >" + book.getAuthorName());
									System.out.println("-----------------------------------------------------------");
								}
							} catch (Exception e) {
								System.out.println("no books present in library");
							}
							break;

						case 6:
							UserBean userBean2 = new UserBean();
							BookBean bookBean2 = new BookBean();
							System.out.println("enter Book Id");
							String bId = scanner.next();
							boolean validateByBid1 = validation.idValidation(bId);
							while (!validateByBid1) {
								try {
									throw new LibraryManagementSystemException("Please enter valid data");
								} catch (LibraryManagementSystemException lmse) {
									System.err.println("Please enter proper book id");
									bId = scanner.next();
									if (validation.idValidation(bId)) {
										break;
									}
								}
							}
							System.out.println("enter User Id");
							String uId = scanner.next();
							boolean validateByUserId = validation.ValidateByUserId(uId);
							while (!validateByUserId) {
								try {
									throw new LibraryManagementSystemException("pleas enter valid data");
								} catch (LibraryManagementSystemException lmse) {
									System.err.println("Please enter valid id number");
									uId = scanner.next();
									if (validation.ValidateByUserId(uId)) {
										break;
									}
								}
							}

							bookBean2.setBookId(Integer.parseInt(bId));
							userBean2.setUserid(Integer.parseInt(uId));
							try {
								boolean isIssued = service.bookIssue(userBean2, bookBean2);
								if (isIssued) {
									System.out.println("Book Issued");
								} else {
									System.out.println("Book cannot be issued");
								}

							} catch (Exception e) {
								System.out.println("Invalid data request book cannot be issued");
							}
							break;

						case 7:
							try {
								System.out.println("Users of Library are :");
								System.out.println("-------------------------------");

								List<UserBean> userInfos = service.showUsers();
								for (UserBean info : userInfos) {

									System.out.println("User id ---------- " + info.getUserid());
									System.out.println("User Name -------- " + info.getUsername());
									System.out.println("User Email------ " + info.getEmail());
									System.out.println("User No Of Books Borrowed ------- " + info.getNumberOfBooks());
									System.out.println("-------------------------------");
								}
							} catch (Exception e) {
								System.out.println("no books present in library");
							}
							break;
						case 8:
							try {
								System.out.println("Requests for Books are :");
								System.out.println("-------------------------------");

								List<RequestInfo> requestInfos = service.showRequests();
								for (RequestInfo info : requestInfos) {

									System.out.println("Book id ---------- " + info.getBookBean().getBookId());
									System.out.println("Book Name -------- " + info.getBookBean().getBookName());
									System.out.println("User id----------- " + info.getUserBean().getUserid());
									System.out.println("User Name -------- " + info.getUserBean().getUsername());
									System.out.println("Book Issued ------" + info.isIssued());
									System.out.println("Book Returned------" + info.isReturned());
									System.out.println("Book IssueDate------------" + info.getIssuedDate());
									System.out.println("book should bo returned on----------->" + info.getReturnedDate());
									System.out.println("-------------------------------");
								}
							} catch (Exception e) {
								System.out.println("no books present in library");
							}
							break;
						case 9:
							System.out.println("Receive Returned Book");
							System.out.println("-----------------------");
							System.out.println("Enter User Id");
							String user1 = scanner.next();
							boolean validateByUserId1 = validation.ValidateByUserId(user1);
							while (!validateByUserId1) {
								try {
									throw new LibraryManagementSystemException("pleas enter valid data");
								} catch (LibraryManagementSystemException lmse) {
									System.err.println("Please enter valid id number");
									user1 = scanner.next();
									if (validation.ValidateByUserId(user1)) {
										break;
									}
								}
							}
							System.out.println("Enter Book Id");
							String book1 = scanner.next();
							boolean validateByBid = validation.idValidation(book1);
							while (!validateByBid) {
								try {
									throw new LibraryManagementSystemException("Please enter valid data");
								} catch (LibraryManagementSystemException lmse) {
									System.err.println("Please enter proper book id");
									book1 = scanner.next();
									if (validation.idValidation(book1)) {
										break;
									}
								}
							}

							bookBean.setBookId(Integer.parseInt(book1));
							userBean.setUserid(Integer.parseInt(user1));
							// boolean isReceived = service.isBookReceived(userBean, bookBean);
							try {
								boolean isReceived = service.isBookReceived(userBean, bookBean);
								if (isReceived) {
									System.out.println(" Received Returned book");
								}
							} catch (LibraryManagementSystemException e) {
								System.err.println(e.getMessage());
							}
							// if (isReceived) {
							// System.out.println(" Received Returned book");
							// } else {
							// System.out.println("Invalid returning Admin unable to receive");
							// }

						}

					} while (check != 0);

				} catch (Exception e) {
					System.out.println("Invalid credentials");
				}
				break;
			case 2:
				System.out.println("-----------------");
				System.out.println("Enter User Email id");
				String userEmailId1 = scanner.next();
				System.out.println("Enter User password");
				String userPassword1 = scanner.next();

				try {
					UserBean userInfo = userService.login(userEmailId1, userPassword1);
					System.out.println("User logged in");
					do {
						System.out.println("1. Books in Library");
						System.out.println("2. Search a Book");
						System.out.println("3. Request a Book");
						System.out.println("4. Return Book");
						System.out.println("0. Exit");
						System.out.println("Enter your choice");
						userChoice = scanner.nextInt();
						switch (userChoice) {
						case 1:
							try {
								System.out.println("Books present in library are :");
								System.out.println("-------------------------------");

								List<BookBean> allBooks = service.showBooks();
								for (BookBean book : allBooks) {

									System.out.println("Book Id----------->" + book.getBookId());
									System.out.println("Book Name-------------->" + book.getBookName());
									System.out.println("Author name-------->" + book.getAuthorName());
									System.out.println("---------------------------");
								}
							} catch (Exception e) {
								System.out.println("no books present in library");
							}
							break;
						case 2:
							System.out.println("Search a Book");
							System.out.println("Enter book Id");
							String searchBookId = scanner.next();
							boolean validateByBookId = validation.idValidation(searchBookId);
							while (!validateByBookId) {
								try {
									throw new LibraryManagementSystemException("Please enter valid data");
								} catch (LibraryManagementSystemException lmse) {
									System.err.println("Please enter proper book id");
									searchBookId = scanner.next();
									if (validation.idValidation(searchBookId)) {
										break;
									}
								}
							}
							try {
								BookBean bookSearch = service.searchBook(Integer.parseInt(searchBookId));
								System.out.println("Book found");
								System.out.println("Book Id---------->" + bookSearch.getBookId());
								System.out.println("Book Name-------->" + bookSearch.getBookName());
								System.out.println("Author name--------->" + bookSearch.getAuthorName());

							} catch (Exception e) {
								System.out.println("Book not found");

							}
							break;

						case 3:
							System.out.println("Enter book id");
							String bookId = scanner.next();
							boolean validateByBookId1 = validation.idValidation(bookId);
							while (!validateByBookId1) {
								try {
									throw new LibraryManagementSystemException("Please enter valid data");
								} catch (LibraryManagementSystemException lmse) {
									System.err.println("Please enter proper book id");
									bookId = scanner.next();
									if (validation.idValidation(bookId)) {
										break;
									}
								}
							}
							bookBean.setBookId(Integer.parseInt(bookId));

							System.out.println("Enter user id");
							String userId = scanner.next();
							boolean validateByUserId1 = validation.ValidateByUserId(userId);
							while (!validateByUserId1) {
								try {
									throw new LibraryManagementSystemException("pleas enter valid data");
								} catch (LibraryManagementSystemException lmse) {
									System.err.println("Please enter valid id number");
									userId = scanner.next();
									if (validation.ValidateByUserId(userId)) {
										break;
									}
								}
							}
							userBean.setUserid(Integer.parseInt(userId));

							try {
								RequestInfo request = userService.bookRequest(userBean, bookBean);
								System.out.println("Request placed to admin");
								System.out.println("User Id-----" + request.getUserBean().getUserid());
								System.out.println("User name---" + request.getUserBean().getUsername());
								System.out.println("Book Id-----" + request.getBookBean().getBookId());
								System.out.println("Book Name---" + request.getBookBean().getBookName());

							} catch (Exception e) {

								System.out.println("Enter valid data or Invalid Request");
							}
							break;
						case 4:
							System.out.println("Returning a book:");
							System.out.println("------------------");
							System.out.println("Enter User Id");
							String user = scanner.next();
							boolean validateByUser = validation.ValidateByUserId(user);
							while (!validateByUser) {
								try {
									throw new LibraryManagementSystemException("pleas enter valid data");
								} catch (LibraryManagementSystemException lmse) {
									System.err.println("Please enter valid id number");
									user = scanner.next();
									if (validation.ValidateByUserId(user)) {
										break;
									}
								}
							}
							System.out.println("Enter Book Id");
							int book = scanner.nextInt();
							userBean.setUserid(Integer.parseInt(user));
							bookBean.setBookId(book);

							try {
								RequestInfo requestInfo = userService.bookReturn(userBean, bookBean);
								System.out.println("Book is Returning to Admin");
								System.out.println("User Id ------>" + requestInfo.getUserBean().getUserid());
								System.out.println("Book Id ------>" + requestInfo.getBookBean().getBookId());
								System.out.println("Is Returning ----->" + requestInfo.isReturned());

							} catch (Exception e) {
								System.out.println("Invalid Return");
							}
							break;

						default:
							System.out.println("Invalid option");
							break;
						}
					} while (userChoice != 0);

				} catch (Exception e) {
					System.out.println("User cannot log in");
				}

			}

		} while (true);
	}

}
