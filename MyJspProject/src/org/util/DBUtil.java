package org.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	private static final String URL = "jdbc:mysql://localhost:3306/company?useSSL=false&serverTimezone=UTC";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "tiger";
	public static Connection connection = null;
	public static PreparedStatement psmt = null;
	public static ResultSet rs = null;
	//��Mysql���ݿ⽨������
	public static Connection GetConnection() throws ClassNotFoundException, SQLException {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(URL,USERNAME,PASSWORD);
	}
	//�ر�Oracle���ݿ�����
	public static void CloseAll(ResultSet rs,Statement smt,Connection connection) {
			try {
				if(rs!=null)rs.close();
				if(smt!=null)smt.close();
				if(connection!=null)connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	//��PreparedStatement����ֵ
	public static PreparedStatement CreatPreparedStatement(String sql,Object [] params) throws SQLException, ClassNotFoundException {
		psmt = GetConnection().prepareStatement(sql);
		if(params!=null) {
			for(int i=0;i<params.length;i++) {
				psmt.setObject(i+1, params[i]);
			}
		}
		return psmt;
	}
	//ͨ�õ���ɾ��
	public static boolean executeUpdate(String sql,Object[] params) {
		try {
			psmt = CreatPreparedStatement(sql,params);
			int count = psmt.executeUpdate();
			if(count>0)
				return true;
			else 
				return false;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		}catch ( SQLException e) {
			e.printStackTrace();
			return false;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			CloseAll(null,psmt,connection);
		}
	}
	//ͨ�õĲ�  :ͨ�� ��ʾ  �ʺ��� �κβ�ѯ
	public static ResultSet executeQuery( String sql ,Object[] params) {
		try {
			psmt = CreatPreparedStatement(sql,params);
			rs = psmt.executeQuery();
			return rs;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}catch ( SQLException e) {
			e.printStackTrace();
			return null;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	//ͨ�õģ���ѯ����
	public static int GetTotalCount(String sql) {
		int count = -1;
		try {
			psmt = CreatPreparedStatement(sql,null);
			rs = psmt.executeQuery(sql);
			if(rs.next()) {
				count = rs.getInt(1);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch ( SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			CloseAll(null,psmt,connection);
		}
		return count;
	}

}
