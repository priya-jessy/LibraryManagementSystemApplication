package com.capgemini.librarymanagementsystemwithjdbc.service;

import java.util.List;

import com.capgemini.librarymanagementsystemwithjdbc.dto.BookBean;
import com.capgemini.librarymanagementsystemwithjdbc.dto.LibraryUserBean;
import com.capgemini.librarymanagementsystemwithjdbc.dto.RequestInfo;

public interface LibraryManagementSystemService {
	boolean addUser(LibraryUserBean userBean);

	LibraryUserBean login(String emailId, String password);

	boolean addBook(BookBean info);

	boolean removeBook(int bookId);

	boolean updateBook(BookBean bookBean);

	BookBean searchBook(int bookId);

	List<LibraryUserBean> showUsers();

	List<BookBean> showBooks();

	List<RequestInfo> showRequests();

	boolean bookIssue(LibraryUserBean user, BookBean book);

	boolean isBookReceived(LibraryUserBean user, BookBean book);

	LibraryUserBean userlogin(String email, String password);

	BookBean searchById(int id);

	RequestInfo bookRequest(LibraryUserBean userBean, BookBean bookBean);

	RequestInfo bookReturn(LibraryUserBean userBean, BookBean bookBean);

}
