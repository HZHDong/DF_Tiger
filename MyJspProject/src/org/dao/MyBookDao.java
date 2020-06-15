package org.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.entity.MyBook;
import org.util.DBUtil;

public class MyBookDao {
	
		//判断该图书是否已存在
		public boolean isEixtMyBook(String id) {
			return QueryMyBookById(id)==null?false:true;
		}
		//查询图书信息
		public MyBook QueryMyBookById(String id){
			String sql = "select * from mybook where id = ? ";
			Object[] params = {id};
			ResultSet rs = DBUtil.executeQuery(sql,params);
			try {
				if(rs.next()){
					MyBook mybook = new MyBook();
					mybook.setId(id);
					mybook.setName(rs.getString(2));
					mybook.setEditor(rs.getString(3));
					mybook.setNumber(rs.getInt(4));
					mybook.setPrice(rs.getInt(5));
					return mybook;
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}finally {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
			return null;
		}
		//查询全部图书
		public List<MyBook> QueryAllMyBooks() {
			PreparedStatement pstmt = null ;
			MyBook book = null;
			List<MyBook> books = new ArrayList<>();
			ResultSet rs = null ;
			try {
				String sql = "select * from mybook" ;
				 rs = DBUtil.executeQuery(sql, null) ;
				  while(rs.next()) {
					  String id =   rs.getString("id") ;
					  String name =   rs.getString("name") ;
					  String editor =   rs.getString("editor") ;
					  int number =   rs.getInt("number");
					  int price = rs.getInt("price") ;
					  book = new MyBook(id,name,editor,number,price);
					  books.add(book) ;
				  }
				  return books ;
			} catch (SQLException e) {
				e.printStackTrace();
				return null ; 
			}catch (Exception e) {
				e.printStackTrace();
				return null ; 
			}
			finally {
				DBUtil.CloseAll(rs, pstmt, DBUtil.connection);
			}
		}
		
		//添加图书
		public boolean AddMyBook(MyBook book) {
			String sql = "insert into mybook(id,name,editor,number,price) values(?,?,?,?,?)";
			Object[] params = {book.getId(),book.getName(),book.getEditor(),book.getNumber(),book.getPrice()};
			return DBUtil.executeUpdate(sql,params);
		}

		//删除图书
		public boolean DeleteMyBook(MyBook book) {
			return DeleteMyBook(book.getId());
		}
		public boolean DeleteMyBook(String id) {
			String sql = "delete from mybook where id=? ";
			Object[] params = {id};
			return DBUtil.executeUpdate(sql,params);
		}
		
		//修改除ID外的信息
		public boolean UpdateMyBook(MyBook book) {
			String sql = "update mybook set name=?,editor=?,number=?,price=? where id=?";
			Object[] params = {book.getName(),book.getEditor(),book.getNumber(),book.getPrice(),book.getId()};
			return DBUtil.executeUpdate(sql,params);
		}
		
		//修改图书的数量
		public boolean UpdateMyBookNumber(MyBook book) {
			String sql = "update mybook set number=? where id=?";
			Object[] params = {book.getNumber(),book.getId()};
			return DBUtil.executeUpdate(sql,params);
		}
		
		//修改图书的价格
		public boolean UpdateMyBookPrice(MyBook book) {
			String sql = "update mybook set price=? where id=?";
			Object[] params = {book.getPrice(),book.getId()};
			return DBUtil.executeUpdate(sql,params);
		}
}
