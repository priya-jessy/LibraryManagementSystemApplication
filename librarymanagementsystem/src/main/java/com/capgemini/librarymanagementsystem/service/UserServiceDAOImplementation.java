package com.capgemini.librarymanagementsystem.service;

import com.capgemini.librarymanagementsystem.dao.UserDAO;
import com.capgemini.librarymanagementsystem.database.LibraryManagementSystemDataBase;
import com.capgemini.librarymanagementsystem.dto.BookBean;
import com.capgemini.librarymanagementsystem.dto.RequestInfo;
import com.capgemini.librarymanagementsystem.dto.UserBean;
import com.capgemini.librarymanagementsystem.factory.LibraryManagementSystemFactory;

public class UserServiceDAOImplementation implements UserServiceDAO {

	private UserDAO dao = LibraryManagementSystemFactory.getUserDao();

	// @Override
	// public boolean register(UserBean info,int count) {
	// // TODO Auto-generated method stub
	// return dao.register(info, count);
	// }

	@Override
	public UserBean login(String email, String password) {
		// TODO Auto-generated method stub
		return dao.login(email, password);
	}

	@Override
	public BookBean searchById(int id) {
		// TODO Auto-generated method stub
		return dao.searchById(id);
	}

	@Override
	public RequestInfo bookRequest(UserBean userBean, BookBean bookBean) {
		// TODO Auto-generated method stub
		return dao.bookRequest(userBean, bookBean);
	}

	@Override
	public RequestInfo bookReturn(UserBean userBean, BookBean bookBean) {
		// TODO Auto-generated method stub
		return dao.bookReturn(userBean, bookBean);
	}

}
