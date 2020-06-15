package org.util;

import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcDemo2 {

	public static void main(String[] args) throws SQLException {
		String sql = "select * from myuser where id = ?";
		Object [] params = {"001"};
		ResultSet result = DBUtil.executeQuery(sql, params);
		if(result.next())
			System.out.println("³É¹¦");
		else
			System.out.println("Ê§°Ü");
	}

}
