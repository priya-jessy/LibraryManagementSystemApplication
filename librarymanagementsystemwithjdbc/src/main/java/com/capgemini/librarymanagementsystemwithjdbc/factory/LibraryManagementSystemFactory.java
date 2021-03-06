package com.capgemini.librarymanagementsystemwithjdbc.factory;

import com.capgemini.librarymanagementsystemwithjdbc.dao.AdminDAO;
import com.capgemini.librarymanagementsystemwithjdbc.dao.AdminDAOImplementation;
import com.capgemini.librarymanagementsystemwithjdbc.dao.LibraryUserDAO;
import com.capgemini.librarymanagementsystemwithjdbc.dao.LibraryUserDaoImplemention;
import com.capgemini.librarymanagementsystemwithjdbc.dao.UserDAO;
import com.capgemini.librarymanagementsystemwithjdbc.dao.UserDAOImplementation;
import com.capgemini.librarymanagementsystemwithjdbc.dto.BookBean;
import com.capgemini.librarymanagementsystemwithjdbc.dto.LibraryUserBean;
import com.capgemini.librarymanagementsystemwithjdbc.dto.RequestInfo;
import com.capgemini.librarymanagementsystemwithjdbc.service.AdminService;
import com.capgemini.librarymanagementsystemwithjdbc.service.AdminServiceImplementation;
import com.capgemini.librarymanagementsystemwithjdbc.service.LibraryManagementSystemService;
import com.capgemini.librarymanagementsystemwithjdbc.service.LibraryManagementSystemServiceImplementation;
import com.capgemini.librarymanagementsystemwithjdbc.service.UserService;
import com.capgemini.librarymanagementsystemwithjdbc.service.UserServiceImplemenatation;
import com.capgemini.librarymanagementsystemwithjdbc.validation.LibraryManagementSystemValidation;

public class LibraryManagementSystemFactory {

	private LibraryManagementSystemFactory() {

	}
	
	public static BookBean getBookBean() {
		
		return new BookBean();
	}
	public static RequestInfo getRequestInfo() {
		
		return new RequestInfo();
	}

	public static UserDAO getUserDAO() {

		return new UserDAOImplementation();
	}
	public static AdminDAO getAdminDAO() {

		return new AdminDAOImplementation();
	}
	public static AdminService getAdminService() {
		
		return new AdminServiceImplementation();
	}
	public static UserService getUserService() {
		
		return new UserServiceImplemenatation();
	}    
	public static LibraryManagementSystemValidation getLibraryManagementSystemValidation() {
		
		return new LibraryManagementSystemValidation();
	}
	public static LibraryUserBean getLibraryUserBean() {
		
		return new LibraryUserBean();
	}
	
	public static LibraryManagementSystemService getLibraryManagementSystemService() {
		
		
		return new LibraryManagementSystemServiceImplementation();
	}
	public static LibraryUserDAO getLibraryUserDAO() {
		return new LibraryUserDaoImplemention();
	}


}
