package com.capgemini.librarymanagementsystem.service;

import java.util.List;

import com.capgemini.librarymanagementsystem.dao.AdminDAO;
import com.capgemini.librarymanagementsystem.dto.AdminBean;
import com.capgemini.librarymanagementsystem.dto.BookBean;
import com.capgemini.librarymanagementsystem.dto.RequestInfo;
import com.capgemini.librarymanagementsystem.dto.UserBean;
import com.capgemini.librarymanagementsystem.factory.LibraryManagementSystemFactory;

public class AdminServiceDAOImplementation implements AdminServiceDAO {
	private AdminDAO dao = LibraryManagementSystemFactory.getAdminDAO();

	@Override
	public AdminBean login(String adminEmail, String adminPassword) {

		return dao.login(adminEmail, adminPassword);
	}

	@Override
	public boolean addBook(BookBean info) {

		return dao.addBook(info);
	}

	@Override
	public boolean removeBook(int bookId) {

		return dao.removeBook(bookId);
	}

	@Override
	public boolean updateBook(int bookId) {

		return dao.updateBook(bookId);
	}

	@Override
	public boolean returnedBook(int bookId) {
		// TODO Auto-generated method stub
		return dao.returnedBook(bookId);
	}

	@Override
	public boolean addUser(UserBean userBean) {

		return dao.addUser(userBean);
	}

	@Override
	public BookBean searchBook(int bookId) {

		return dao.searchBook(bookId);
	}

	@Override
	public List<UserBean> showUsers() {

		return dao.showUsers();
	}

	@Override
	public List<BookBean> showBooks() {

		return dao.showBooks();
	}

	@Override
	public List<RequestInfo> showRequests() {

		return dao.showRequests();
	}

	@Override
	public boolean isBookReceived(UserBean user, BookBean book) {
		// TODO Auto-generated method stub
		return dao.isBookReceived(user, book);
	}

	@Override
	public boolean bookIssue(UserBean user, BookBean book) {
		// TODO Auto-generated method stub
		return dao.bookIssue(user, book);
	}

}
