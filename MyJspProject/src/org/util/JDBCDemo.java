package org.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCDemo {
	public static void main(String[] args)  {
		String URL = "jdbc:mysql://localhost:3306/company?useSSL=false&serverTimezone=UTC";
		String USERNAME = "root";
		String PASSWORD = "tiger";
		Connection connection = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "select * from myuser where id = 001 ";
			psmt = connection.prepareStatement(sql);
			rs = psmt.executeQuery();
			if(rs.next())
				System.out.println("³É¹¦");
			else
				System.out.println("Ê§°Ü");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
				try {
					if(rs!=null)rs.close();
					if(psmt!=null)psmt.close();
					if(connection!=null)connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}
	
}
