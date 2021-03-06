package com.capgemini.librarymanagementsystem.service;

import java.util.Date;
import java.util.List;

import com.capgemini.librarymanagementsystem.dto.BookBean;
import com.capgemini.librarymanagementsystem.dto.RequestInfo;
import com.capgemini.librarymanagementsystem.dto.UserBean;

public interface UserServiceDAO {
	// boolean register(UserBean info,int count);
	UserBean login(String email, String password);

	BookBean searchById(int id);

	RequestInfo bookRequest(UserBean userBean, BookBean bookBean);

	RequestInfo bookReturn(UserBean userBean, BookBean bookBean);

}
