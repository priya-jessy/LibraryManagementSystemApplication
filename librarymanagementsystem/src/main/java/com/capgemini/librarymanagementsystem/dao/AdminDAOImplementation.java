package com.capgemini.librarymanagementsystem.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.capgemini.librarymanagementsystem.database.LibraryManagementSystemDataBase;
import com.capgemini.librarymanagementsystem.dto.AdminBean;
import com.capgemini.librarymanagementsystem.dto.BookBean;
import com.capgemini.librarymanagementsystem.dto.RequestInfo;
import com.capgemini.librarymanagementsystem.dto.UserBean;
import com.capgemini.librarymanagementsystem.exception.LibraryManagementSystemException;

public class AdminDAOImplementation implements AdminDAO {
	Date date = new Date();
	Date expectedReturnedDate = new Date();
	Date returnedDate = new Date();
	Calendar calendar = Calendar.getInstance();

	@Override
	public AdminBean login(String adminEmail, String adminPassword) {
		AdminBean adminBean = new AdminBean();
		if (adminBean.getAdminEmail().equals(adminEmail) && adminBean.getAdminPassword().equals(adminPassword)) {
			return adminBean;
		}

		throw new LibraryManagementSystemException("Invalid credentials");
	}

	@Override
	public boolean addBook(BookBean info) {
		for (BookBean bookBean : LibraryManagementSystemDataBase.book) {
			if (bookBean.getBookId() == info.getBookId()) {
				return false;
			}
		}
		LibraryManagementSystemDataBase.book.add(info);
		return true;
	}

	@Override
	public boolean removeBook(int bookId) {

		for (BookBean bookin : LibraryManagementSystemDataBase.book) {
			if (bookin.getBookId() == bookId) {
				LibraryManagementSystemDataBase.book.remove(bookin);
				return true;
			}
		}

		throw new LibraryManagementSystemException("Book cannot be removed");
	}

	@Override
	public boolean updateBook(int bookId) {
		for (BookBean bookinfo : LibraryManagementSystemDataBase.book) {
			if (bookinfo.getBookId() == bookId) {
				return true;
			}
			LibraryManagementSystemDataBase.book.add(bookinfo);
			System.err.println("Updating  Book");
			break;
		}
		throw new LibraryManagementSystemException("Book cannot be updated");
	}

	@Override
	public boolean returnedBook(int bookId) {
		for (BookBean books : LibraryManagementSystemDataBase.book) {
			if (books.getBookId() == bookId) {
				return true;
			}
		}
		throw new LibraryManagementSystemException("Book cannot be updated");
	}

	@Override
	public boolean addUser(UserBean userBean) {
		for (UserBean userInfo : LibraryManagementSystemDataBase.users) {
			if ((userInfo.getUserid() == userBean.getUserid())) {
				return false;
			}

		}
		LibraryManagementSystemDataBase.users.add(userBean);

		return true;
	}

	@Override
	public BookBean searchBook(int bookId) {
		for (BookBean bookBeans : LibraryManagementSystemDataBase.book) {
			if (bookBeans.getBookId() == bookId) {
				return bookBeans;
			}
		}
		throw new LibraryManagementSystemException("Book not found");
	}

	@Override
	public List<UserBean> showUsers() {
		List<UserBean> infos = new LinkedList<UserBean>();

		for (UserBean userInfo : LibraryManagementSystemDataBase.users) {
			userInfo.getUserid();
			userInfo.getUsername();
			userInfo.getEmail();
			userInfo.getNumberOfBooks();
			infos.add(userInfo);
		}
		return infos;
	}

	@Override
	public List<BookBean> showBooks() {
		List<BookBean> booksList = new LinkedList<BookBean>();
		for (BookBean book : LibraryManagementSystemDataBase.book) {

			book.getBookId();
			book.getBookName();
			book.getAuthorName();
			booksList.add(book);

		}
		return booksList;
	}

	@Override
	public List<RequestInfo> showRequests() {
		List<RequestInfo> reqInfo = new LinkedList<RequestInfo>();
		for (RequestInfo requestInfo : LibraryManagementSystemDataBase.request) {
			requestInfo.getBookBean();
			requestInfo.getUserBean();
			requestInfo.isIssued();
			requestInfo.isReturned();
			requestInfo.getIssuedDate();
			requestInfo.getReturnedDate();
			reqInfo.add(requestInfo);
		}
		return reqInfo;
	}

	@Override
	public boolean isBookReceived(UserBean user, BookBean book) {
		boolean isValid = false;
		RequestInfo requestInfo1 = new RequestInfo();
		for (RequestInfo requestInfo : LibraryManagementSystemDataBase.request) {

			if (requestInfo.getBookBean().getBookId() == book.getBookId()
					&& requestInfo.getUserBean().getUserid() == user.getUserid() && requestInfo.isReturned() == true) {
				isValid = true;
				requestInfo1 = requestInfo;

			}
		}
		if (isValid) {

			book.setAuthorName(requestInfo1.getBookBean().getAuthorName());
			book.setBookName(requestInfo1.getBookBean().getBookName());
			LibraryManagementSystemDataBase.book.add(book);
			LibraryManagementSystemDataBase.request.remove(requestInfo1);

			for (UserBean userInfo2 : LibraryManagementSystemDataBase.users) {
				if (userInfo2.getUserid() == user.getUserid()) {
					user = userInfo2;
				}

			}

			int noOfBooksBorrowed = user.getNumberOfBooks();
			noOfBooksBorrowed--;
			user.setNumberOfBooks(noOfBooksBorrowed);
			return true;

		}

		throw new LibraryManagementSystemException("Book not received");
	}
	

	@Override
	public boolean bookIssue(UserBean user, BookBean book) {
		boolean isValid = false;
		calendar.add(Calendar.DATE, 15);
		expectedReturnedDate = calendar.getTime();
		RequestInfo requestInfo = new RequestInfo();

		int noOfBooksBorrowed = user.getNumberOfBooks();
		for (RequestInfo info : LibraryManagementSystemDataBase.request) {
			if (info.getUserBean().getUserid() == user.getUserid()) {
				if (info.getBookBean().getBookId() == book.getBookId()) {
					requestInfo = info;

					isValid = true;

				}
			}
		}

		if (isValid)

		{
			System.out.println("I am entreing into is valid");

			for (BookBean info2 : LibraryManagementSystemDataBase.book) {
				if (info2.getBookId() == book.getBookId()) {
					book = info2;
				}

			}

			for (UserBean userInfo2 : LibraryManagementSystemDataBase.users) {
				if (userInfo2.getUserid() == user.getUserid()) {
					user = userInfo2;
					noOfBooksBorrowed = user.getNumberOfBooks();

				}

			}

			if (noOfBooksBorrowed < 3) {
				// System.out.println("entered into no of books borrowed");
				boolean isRemoved = LibraryManagementSystemDataBase.book.remove(book);
				if (isRemoved) {
					// System.out.println("book removed from db");
					// System.out.println("enter into removed");
					noOfBooksBorrowed++;
					System.out.println(noOfBooksBorrowed);
					user.setNumberOfBooks(noOfBooksBorrowed);
					requestInfo.setIssued(true);
					requestInfo.setIssuedDate(date);
					requestInfo.setReturnedDate(expectedReturnedDate);
					return true;
				} else {
					throw new LibraryManagementSystemException("Book can't be borrowed");
				}

			} else {
				throw new LibraryManagementSystemException("Student Exceeds maximum limit");
			}

		} else {
			throw new LibraryManagementSystemException("Book data or User data is incorrect");

		}

	}

}
