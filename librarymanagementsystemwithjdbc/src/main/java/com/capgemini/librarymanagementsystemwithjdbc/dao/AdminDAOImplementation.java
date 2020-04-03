package com.capgemini.librarymanagementsystemwithjdbc.dao;

import java.io.FileInputStream;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;



import com.capgemini.librarymanagementsystemwithjdbc.dto.BookBean;
import com.capgemini.librarymanagementsystemwithjdbc.dto.LibraryUserBean;
import com.capgemini.librarymanagementsystemwithjdbc.dto.RequestInfo;

import com.capgemini.librarymanagementsystemwithjdbc.exception.LMSException;


public class AdminDAOImplementation implements AdminDAO {
	
	
	

	@Override
	public boolean addUser(LibraryUserBean userBean) {

		try(FileInputStream fis=new FileInputStream("LibraryManagementSystemDataBase.properties")){
			Properties properties=new Properties();
			properties.load(fis);
			Class.forName(properties.getProperty("path")).newInstance();
			String dburl=properties.getProperty("dburl");
			try(Connection connection=DriverManager.getConnection(dburl)){
				String query=properties.getProperty("addUser");
				try(PreparedStatement pstmt=connection.prepareStatement(query)){
					pstmt.setInt(1,userBean.getId());
					pstmt.setString(2, userBean.getUserName());
					pstmt.setString(3, userBean.getFirstName());
					pstmt.setString(4, userBean.getLastName());
					pstmt.setString(5, userBean.getEmailId());
					pstmt.setString(6,userBean.getPassword());
					pstmt.setString(7,userBean.getRole());
					
					int isRegistered=pstmt.executeUpdate();
					if(isRegistered!=0) {
						return true;
					}else {
						throw new LMSException("User not registered");
					}
					
				}
			}catch(LMSException e) {
				System.err.println("Book is already existing");
			}	
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public LibraryUserBean login(String emailId, String password) {		
		LibraryUserBean adminBean = new LibraryUserBean();
		try(FileInputStream fis = new FileInputStream("LibraryManagementSystemDataBase.properties")){
			Properties properties = new Properties();
			properties.load(fis);
			Class.forName(properties.getProperty("path")).newInstance();
			
			String dburl=properties.getProperty("dburl");
			
			try(Connection conn = DriverManager.getConnection(dburl)){
				String query =properties.getProperty("login") ;
				try(PreparedStatement pstmt = conn.prepareStatement(query)){
					pstmt.setString(1, emailId);
					pstmt.setString(2, password); 
					ResultSet rs = pstmt.executeQuery();
					if(rs.next()) {
					adminBean.setEmailId(rs.getString("emailid"));
					adminBean.setPassword(rs.getString("password"));
							return adminBean;
						}else {
							System.out.println();
							return null;
					}
					}	
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		 
	return null;
	}

	@Override
	public boolean addBook(BookBean info) {
		
		try(FileInputStream fis=new FileInputStream("LibraryManagementSystemDataBase.properties")){
			Properties properties=new Properties();
			properties.load(fis);
			Class.forName(properties.getProperty("path")).newInstance();
			String dburl=properties.getProperty("dburl");
			try(Connection connection=DriverManager.getConnection(dburl)){
				String query=properties.getProperty("addBook");
				try(PreparedStatement pstmt=connection.prepareStatement(query)){
					pstmt.setInt(1,info.getBookId());
					pstmt.setString(2, info.getBookName());
					pstmt.setString(3, info.getAuthorName());
					pstmt.setString(4, info.getPublisher());
					pstmt.setString(5, info.getCategory());
					
					int isAdded=pstmt.executeUpdate();
					if(isAdded!=0) {
						return true;
					}else {
						throw new LMSException("Book is not added");
					}
					
				}
			}catch(LMSException e) {
				System.err.println("Book is already existing");
			}	
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

//	@Override
//	public boolean returnedBook(int bookId) {
//		// TODO Auto-generated method stub
//		return false;
//	}

	@Override
	public boolean removeBook(int bookId) {
		
		try(FileInputStream fis=new FileInputStream("LibraryManagementSystemDataBase.properties")){
			Properties properties=new Properties();
			properties.load(fis);
			Class.forName(properties.getProperty("path")).newInstance();
			String dburl=properties.getProperty("dburl");
			try(Connection connection=DriverManager.getConnection(dburl)){
				String query=properties.getProperty("removeBook");
				try(PreparedStatement pstmt=connection.prepareStatement(query)){
					pstmt.setInt(1,bookId );
					int res=pstmt.executeUpdate();
					if(res!=0) {
						return true;
					}
				}catch(LMSException lmse) {
					System.err.println("book cannot be removed");
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateBook(BookBean bookBean) {
		try(FileInputStream fis=new FileInputStream("LibraryManagementSystemDataBase.properties")){
			Properties properties=new Properties();
			properties.load(fis);
			Class.forName(properties.getProperty("path")).newInstance();
			String dburl=properties.getProperty("dburl");
			try(Connection connection=DriverManager.getConnection(dburl)){
				String query=properties.getProperty("updateBook");
				try(PreparedStatement pstmt=connection.prepareStatement(query)){
					pstmt.setInt(1, bookBean.getBookId());
					pstmt.setString(2, bookBean.getBookName());
					int res=pstmt.executeUpdate();
					if(res!=0) {
						return true;
					}
				}catch(LMSException lmse) {
					System.err.println("book is not able to update");
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		

		return false;
	}

	@Override
	public BookBean searchBook(int bookId) {
		BookBean bookBean=new BookBean();
		try(FileInputStream fis=new FileInputStream("LibraryManagementSystemDataBase.properties")){
			Properties properties=new Properties();
			properties.load(fis);
			Class.forName(properties.getProperty("path")).newInstance();
			String dburl=properties.getProperty("dburl");
			try(Connection connection=DriverManager.getConnection(dburl)){
				String query=properties.getProperty("searchBook");
				try(PreparedStatement pstmt=connection.prepareStatement(query)){
					pstmt.setInt(1, bookId);
					ResultSet rs=pstmt.executeQuery();
					if(rs.next()) {
						bookBean.setBookId(rs.getInt("bookId"));
						bookBean.setBookName(rs.getString("bookName"));
						bookBean.setAuthorName(rs.getString("authorName"));
						return bookBean;
					}
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<LibraryUserBean> showUsers() {
		try(FileInputStream fis = new FileInputStream("LibraryManagementSystemDataBase.properties")){
			Properties properties = new Properties();
			properties.load(fis);
			Class.forName(properties.getProperty("path")).newInstance();
			
			String dburl=properties.getProperty("dburl");
			
			try(Connection conn = DriverManager.getConnection(dburl)){
				String query =properties.getProperty("getAllUsers") ;
				try(Statement pstmt = conn.createStatement()){
					
					ResultSet rs = pstmt.executeQuery(query);
					List<LibraryUserBean> beans=new LinkedList<LibraryUserBean>();
					while(rs.next()) {
						LibraryUserBean userBean=new LibraryUserBean();
						
						userBean.setId(rs.getInt("id"));
						userBean.setUserName(rs.getString("username"));
						userBean.setFirstName(rs.getString("firstname"));
						userBean.setLastName(rs.getString("lastname"));
						userBean.setEmailId(rs.getString("emailid"));
						userBean.setPassword(rs.getString("password"));
						userBean.setRole(rs.getString("role"));
						beans.add(userBean);
						
					
						}
					return beans;
					}	
				}
			}catch (Exception e) {
				e.printStackTrace();
			}

		return null;
	}

	@Override
	public List<BookBean> showBooks() {
		try(FileInputStream fis = new FileInputStream("LibraryManagementSystemDataBase.properties")){
			Properties properties = new Properties();
			properties.load(fis);
			Class.forName(properties.getProperty("path")).newInstance();
			
			String dburl=properties.getProperty("dburl");
			
			try(Connection conn = DriverManager.getConnection(dburl)){
				String query =properties.getProperty("getAllBookInfo") ;
				try(Statement pstmt = conn.createStatement()){
					
					ResultSet rs = pstmt.executeQuery(query);
					List<BookBean> beans=new ArrayList<BookBean>();
					while(rs.next()) {
						BookBean bookBean=new BookBean();
						bookBean.setBookId(rs.getInt("bookId"));
						bookBean.setBookName(rs.getString("bookName"));
						bookBean.setAuthorName(rs.getString("authorName"));
						bookBean.setPublisher(rs.getString("publisher"));
						bookBean.setCategory(rs.getString("category"));
						beans.add(bookBean);
						
					
						}
					return beans;
					}
						
				}
			}catch (Exception e) {
				e.printStackTrace();
			}




		return null;
	}

	@Override
	public List<RequestInfo> showRequests() {
		try(FileInputStream fis = new FileInputStream("LibraryManagementSystemDataBase.properties")){
			Properties properties = new Properties();
			properties.load(fis);
			Class.forName(properties.getProperty("path")).newInstance();
			
			String dburl=properties.getProperty("dburl");
			
			try(Connection conn = DriverManager.getConnection(dburl)){
				String query =properties.getProperty("showRequest") ;
				try(Statement pstmt = conn.createStatement()){
					
					ResultSet rs = pstmt.executeQuery(query);
					List<RequestInfo> beans=new ArrayList<RequestInfo>();
					while(rs.next()) {
						RequestInfo requestInfo=new RequestInfo();
						requestInfo.setRequestId(rs.getInt("requestid"));
						requestInfo.setUserId(rs.getInt("userid"));
						requestInfo.setBookId(rs.getInt("bookid"));
						beans.add(requestInfo);
						
					
						}
					return beans;
					}
						
				}
			}catch (Exception e) {
				e.printStackTrace();
			}

		
		return null;
	}

	@Override
	public boolean bookIssue(LibraryUserBean user, BookBean book) {
		try(FileInputStream fis=new FileInputStream("LibraryManagementSystemDataBase.properties")){
			Properties properties=new Properties();
			properties.load(fis);
			Class.forName(properties.getProperty("path")).newInstance();
			String dburl=properties.getProperty("dburl");
			try(Connection connection=DriverManager.getConnection(dburl)){
				String query=properties.getProperty("issueBook");
				try(PreparedStatement pstmt=connection.prepareStatement(query)){
					pstmt.setInt(1, book.getSlno());
					pstmt.setInt(2, user.getId());
					pstmt.setInt(3, book.getBookId());
					pstmt.setString(4, book.getBookName());
					pstmt.setDate(5, book.getIssueDate());
					pstmt.setDate(6, book.getReturnDate());
					pstmt.setInt(7, book.getFine());
					int isIssued=pstmt.executeUpdate();
					if(isIssued!=0) {
						
						return true;
					}
					
				
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean isBookReceived(LibraryUserBean user, BookBean book) {
		
		return false;
	}

	
	

}
