package com.capgemini.librarymanagementsystemwithjdbc.service;

import com.capgemini.librarymanagementsystemwithjdbc.dto.BookBean;
import com.capgemini.librarymanagementsystemwithjdbc.dto.LibraryUserBean;
import com.capgemini.librarymanagementsystemwithjdbc.dto.RequestInfo;


public interface UserService {
	
	LibraryUserBean login(String email,String password);
	BookBean searchById(int id);
//	RequestInfo bookRequest(int userId,int bookId);
	RequestInfo bookRequest(LibraryUserBean userBean, BookBean bookBean);
	RequestInfo bookReturn(LibraryUserBean userBean, BookBean bookBean);
	
	
}
