package com.capgemini.librarymanagementsystem.dao;

import java.util.List;

import com.capgemini.librarymanagementsystem.dto.AdminBean;
import com.capgemini.librarymanagementsystem.dto.BookBean;
import com.capgemini.librarymanagementsystem.dto.RequestInfo;
import com.capgemini.librarymanagementsystem.dto.UserBean;

public interface AdminDAO {

	boolean addUser(UserBean userBean);

	AdminBean login(String adminEmail, String adminPassword);

	boolean addBook(BookBean info);

	boolean returnedBook(int bookId);

	boolean removeBook(int bookId);

	boolean updateBook(int bookId);

	BookBean searchBook(int bookId);

	List<UserBean> showUsers();

	List<BookBean> showBooks();

	List<RequestInfo> showRequests();

	boolean bookIssue(UserBean user, BookBean book);

	boolean isBookReceived(UserBean user, BookBean book);

}
