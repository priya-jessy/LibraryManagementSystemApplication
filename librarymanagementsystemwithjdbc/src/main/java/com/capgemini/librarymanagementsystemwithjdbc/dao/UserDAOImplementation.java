package com.capgemini.librarymanagementsystemwithjdbc.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import com.capgemini.librarymanagementsystemwithjdbc.dto.BookBean;
import com.capgemini.librarymanagementsystemwithjdbc.dto.LibraryUserBean;
import com.capgemini.librarymanagementsystemwithjdbc.dto.RequestInfo;


public class UserDAOImplementation implements UserDAO{

	@Override
	public LibraryUserBean login(String email, String password) {
		
		LibraryUserBean adminBean = new LibraryUserBean();
		try(FileInputStream fis = new FileInputStream("LibraryManagementSystemDataBase.properties")){
			Properties properties = new Properties();
			properties.load(fis);
			Class.forName(properties.getProperty("path")).newInstance();
			
			String dburl=properties.getProperty("dburl");
			
			try(Connection conn = DriverManager.getConnection(dburl)){
				String query =properties.getProperty("login") ;
				try(PreparedStatement pstmt = conn.prepareStatement(query)){
					pstmt.setString(1, email);
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
	public BookBean searchById(int id) {
		BookBean bookBean=new BookBean();
		try(FileInputStream fis=new FileInputStream("LibraryManagementSystemDataBase.properties")){
			Properties properties=new Properties();
			properties.load(fis);
			Class.forName(properties.getProperty("path")).newInstance();
			String dburl=properties.getProperty("dburl");
			try(Connection connection=DriverManager.getConnection(dburl)){
				String query=properties.getProperty("searchBook");
				try(PreparedStatement pstmt=connection.prepareStatement(query)){
					pstmt.setInt(1, id);
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
	
//	@Override
//	public RequestInfo bookRequest(int userId, int bookId) {
//		try(FileInputStream fis=new FileInputStream("LibraryManagementSystemDataBase.properties")){
//			Properties properties=new Properties();
//			properties.load(fis);
//			Class.forName(properties.getProperty("path")).newInstance();
//			String dburl=properties.getProperty("dburl");
//			try(Connection connection=DriverManager.getConnection(dburl)){
//				String query=properties.getProperty("bookRequest");
//				try(PreparedStatement pstmt=connection.prepareStatement(query)){
//					
//					pstmt.setInt(1 ,userId);
//					pstmt.setInt(2 ,bookId);
//					
//					int result=pstmt.executeUpdate();
//					
//					if(result!=0) {
//						
//						RequestInfo requestInfo=new RequestInfo();
//						
//						requestInfo.setUserId(userId);
//						requestInfo.setBookId(bookId);
//						
//						return requestInfo;
//						
//						
//					}else {
//						return null;
//					}
//					
//					
//				}
//			}
//			
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}


	@Override
	public RequestInfo bookRequest(LibraryUserBean userBean, BookBean bookBean) {
		RequestInfo requestInfo=new RequestInfo();
		try(FileInputStream fis=new FileInputStream("LibraryManagementSystemDataBase.properties")){
			Properties properties=new Properties();
			properties.load(fis);
			Class.forName(properties.getProperty("path")).newInstance();
			String dburl=properties.getProperty("dburl");
			try(Connection connection=DriverManager.getConnection(dburl)){
				String query=properties.getProperty("bookRequest");
				try(PreparedStatement pstmt=connection.prepareStatement(query)){
//					RequestInfo requestInfo=new RequestInfo();
					pstmt.setInt(1 ,userBean.getId());
					pstmt.setInt(2 ,bookBean.getBookId());
					
					int result=pstmt.executeUpdate();
					
					if(result!=0) {
						
						return requestInfo;
						
						
					}else {
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
	public RequestInfo bookReturn(LibraryUserBean userBean, BookBean bookBean) {
		
		return null;
	}

	
}
