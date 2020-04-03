package com.capgemini.librarymanagementsystemwithjdbc.service;

import com.capgemini.librarymanagementsystemwithjdbc.dao.UserDAO;
import com.capgemini.librarymanagementsystemwithjdbc.dto.BookBean;
import com.capgemini.librarymanagementsystemwithjdbc.dto.LibraryUserBean;
import com.capgemini.librarymanagementsystemwithjdbc.dto.RequestInfo;
import com.capgemini.librarymanagementsystemwithjdbc.factory.LibraryManagementSystemFactory;

public class UserServiceImplemenatation implements UserService {

	private UserDAO dao = LibraryManagementSystemFactory.getUserDAO();

	@Override
	public LibraryUserBean login(String email, String password) {

		return dao.login(email, password);
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

	// @Override
	// public RequestInfo bookRequest(int userId, int bookId) {
	//
	// return dao.bookRequest(userId, bookId);
	// }

}
