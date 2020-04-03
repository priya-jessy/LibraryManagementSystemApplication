package com.capgemini.librarymanagementsystem.dao;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.capgemini.librarymanagementsystem.database.LibraryManagementSystemDataBase;
import com.capgemini.librarymanagementsystem.dto.BookBean;
import com.capgemini.librarymanagementsystem.dto.RequestInfo;
import com.capgemini.librarymanagementsystem.dto.UserBean;
import com.capgemini.librarymanagementsystem.exception.LibraryManagementSystemException;


public class UserDAOImplementation implements UserDAO {

	
	
	Date returnedDate = new Date();
	

	@Override
	public UserBean login(String email, String password) {
		for (UserBean userBean : LibraryManagementSystemDataBase.users)
			if (userBean.getEmail().equals(email) && userBean.getPassword().equals(password)) {
				return userBean;

			}
		throw new LibraryManagementSystemException("Invalid user credentials");
	}

	@Override
	public BookBean searchById(int id) {
		for (BookBean bookBean : LibraryManagementSystemDataBase.book) {
			if (bookBean.getBookId() == id) {
				return bookBean;
			}
		}
		throw new LibraryManagementSystemException("Invalid search");
	}

	@Override
	public RequestInfo bookRequest(UserBean userBean, BookBean bookBean) {
		boolean flag = false, isRequestExists = false;
		RequestInfo requestInfo = new RequestInfo();
		UserBean userBean1 = new UserBean();
		BookBean bookBean1 = new BookBean();

		for (RequestInfo requestInfo2 : LibraryManagementSystemDataBase.request) {
			if (bookBean.getBookId() == requestInfo2.getBookBean().getBookId()) {
				isRequestExists = true;

			}

		}

		if (!isRequestExists) {
			for (UserBean user : LibraryManagementSystemDataBase.users) {
				if (userBean.getUserid() == user.getUserid()) {
					for (BookBean book : LibraryManagementSystemDataBase.book) {
						if (book.getBookId() == bookBean.getBookId()) {
							userBean1 = user;
							bookBean1 = book;
							flag = true;
						}
					}
				}
			}
			if (flag == true) {
				requestInfo.setBookBean(bookBean1);
				requestInfo.setUserBean(userBean1);
				LibraryManagementSystemDataBase.request.add(requestInfo);
				return requestInfo;
			}

		}

		throw new LibraryManagementSystemException("Invalid request or you cannot request that book");
	}

	@Override
	public RequestInfo bookReturn(UserBean userBean, BookBean bookBean) {
		for (RequestInfo requestInfo : LibraryManagementSystemDataBase.request) {

			if (requestInfo.getBookBean().getBookId() == bookBean.getBookId()
					&& requestInfo.getUserBean().getUserid() == userBean.getUserid()
					&& requestInfo.isIssued() == true) {

				System.out.println("Returning Issued book only");
				requestInfo.setReturned(true);
				requestInfo.setReturnedDate(returnedDate);

				return requestInfo;
			}

		}

		throw new LibraryManagementSystemException("Invalid return ");
	}

	//// @Override
	//// public boolean register(UserBean info,int count) {
	//// boolean isAccepted=false;
	//// isAccepted=AdminDAOImplementation.acceptRequest(info, count);
	//// if(isAccepted) {
	//// isAccepted=true;
	//// } else {
	//// throw new LibraryManagementSystemException("Email already exists");
	//// }
	//// return isAccepted;
	//// }
	//
	// @Override
	// public UserBean login(String email, String password) {
	// for(UserBean userinfo:LibraryManagementSystemDataBase.users) {
	// if(userinfo.getEmail().equals(email) &&
	//// userinfo.getPassword().equals(password)) {
	// return userinfo;
	// }
	// }
	// //throw new UserValidationException("Invalid Credentials");
	// throw new LibraryManagementSystemException("Invalid Credentials");
	// }
	//
	//
	// @Override
	// public BookBean searchById(int id) {
	// for(BookBean bookBeans:LibraryManagementSystemDataBase.book) {
	// if(bookBeans.getBookId()==id) {
	// return bookBeans;
	// }
	// }
	//
	// //throw new LibraryManagementSystemException("Book not Found");
	// //System.err.println("Book not found");
	// return null;
	// }
	//
	// @Override
	// public RequestInfo bookRequest(UserBean userBean, BookBean bookBean) {
	// // TODO Auto-generated method stub
	// return null;
	// }
	//
	// @Override
	// public RequestInfo bookReturn(UserBean userBean, BookBean bookBean) {
	// // TODO Auto-generated method stub
	// return null;
	// }
	//
	//
	//
	// @Override
	// public boolean bookBorrow(int bookId, int userId) {
	//
	// for (UserBean user : LibraryManagementSystemDataBase.users) {
	// if (user.getUserid()==userId) {
	// for (BookBean bookDto : LibraryManagementSystemDataBase.book) {
	// if (bookDto.getBookId()==bookId)
	// if (user.getNumberOfBooks() >= 0 && user.getNumberOfBooks() < 3) {
	// user.setNumberOfBooks(user.getNumberOfBooks() + 1);
	// return true;
	// }
	// }
	// }
	// }
	// throw new LibraryManagementSystemException("This book is not available in
	//// library");
	// }
	// @Override
	// public boolean bookReturn(int bookId,int userId) {
	//
	// for (BookBean books : LibraryManagementSystemDataBase.book) {
	// if (books.getBookId()==bookId) {
	// for (UserBean userInfo : LibraryManagementSystemDataBase.users) {
	// if (userInfo.getUserid()==userId) {
	// if (userInfo.getNumberOfBooks() >= 0 && userInfo.getNumberOfBooks() < 3) {
	// userInfo.setNumberOfBooks(userInfo.getNumberOfBooks() + 1);
	// return true;
	// }
	// }
	// }
	// }
	// }
	// throw new LibraryManagementSystemException("Book is not present");
	//
	//
	// }
}
