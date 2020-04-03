package com.capgemini.librarymanagementsystemwithjdbc.dto;

import com.capgemini.librarymanagementsystemwithjdbc.dto.BookBean;
import com.capgemini.librarymanagementsystemwithjdbc.dto.LibraryUserBean;

public class RequestInfo {
	private int requestId;
	private int bookId;
	private int userId;
	private int bookName;
	private BookBean bookBean;
	private LibraryUserBean userBean;

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getBookName() {
		return bookName;
	}

	public void setBookName(int bookName) {
		this.bookName = bookName;
	}

	public BookBean getBookBean() {
		return bookBean;
	}

	public void setBookBean(BookBean bookBean) {
		this.bookBean = bookBean;
	}

	public LibraryUserBean getUserBean() {
		return userBean;
	}

	public void setUserBean(LibraryUserBean userBean) {
		this.userBean = userBean;
	}

	public boolean isIssued() {
		return isIssued;
	}

	public void setIssued(boolean isIssued) {
		this.isIssued = isIssued;
	}

	public boolean isReturned() {
		return isReturned;
	}

	public void setReturned(boolean isReturned) {
		this.isReturned = isReturned;
	}

	private boolean isIssued;
	private boolean isReturned;

}
