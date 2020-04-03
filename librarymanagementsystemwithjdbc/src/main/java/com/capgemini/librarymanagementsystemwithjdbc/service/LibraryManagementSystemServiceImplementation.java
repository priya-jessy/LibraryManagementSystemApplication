package com.capgemini.librarymanagementsystemwithjdbc.service;

import java.util.List;

import com.capgemini.librarymanagementsystemwithjdbc.dao.LibraryUserDAO;
import com.capgemini.librarymanagementsystemwithjdbc.dto.BookBean;
import com.capgemini.librarymanagementsystemwithjdbc.dto.LibraryUserBean;
import com.capgemini.librarymanagementsystemwithjdbc.dto.RequestInfo;
import com.capgemini.librarymanagementsystemwithjdbc.factory.LibraryManagementSystemFactory;

public class LibraryManagementSystemServiceImplementation implements LibraryManagementSystemService {
	
	private LibraryUserDAO dao=LibraryManagementSystemFactory.getLibraryUserDAO();

	@Override
	public boolean addUser(LibraryUserBean userBean) {
		
		return dao.addUser(userBean);
	}

	@Override
	public LibraryUserBean login(String emailId, String password) {
		
		return dao.login(emailId, password);
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
	public boolean updateBook(BookBean bookBean) {
		
		return dao.updateBook(bookBean);
	}

	@Override
	public BookBean searchBook(int bookId) {
		
		return dao.searchBook(bookId);
	}

	@Override
	public List<LibraryUserBean> showUsers() {
		
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
	public boolean bookIssue(LibraryUserBean user, BookBean book) {
		
		return dao.bookIssue(user, book);
	}

	@Override
	public boolean isBookReceived(LibraryUserBean user, BookBean book) {
		
		return dao.isBookReceived(user, book);
	}

	@Override
	public LibraryUserBean userlogin(String email, String password) {
		
		return dao.userlogin(email, password);
	}

	@Override
	public BookBean searchById(int id) {
		
		return dao.searchById(id);
	}

	@Override
	public RequestInfo bookRequest(LibraryUserBean userBean, BookBean bookBean) {
		
		return dao.bookRequest(userBean, bookBean);
	}

	@Override
	public RequestInfo bookReturn(LibraryUserBean userBean, BookBean bookBean) {
		
		return dao.bookReturn(userBean, bookBean);
	}

}
