package org.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.entity.User;
import org.util.DBUtil;

public class UserDao {

	//�û���¼
		public boolean LoginUser(String id, String pwd) {
			return pwd.equals(QueryUserById(id).getPWD())?true:false;
		}
		//�жϸ��û��Ƿ��Ѵ���
		public boolean isEixtUser(String id) {
			return QueryUserById(id)==null?false:true;
		}
		//��ѯ�û���Ϣ
		public User QueryUserById(String id){
			String sql = "select * from user where id = ? ";
			Object[] params = {id};
			ResultSet rs = DBUtil.executeQuery(sql,params);
			try {
				if(rs.next()){
					User user = new User();
					user.setID(id);
					user.setPWD(rs.getString(2));
					user.setName_First(rs.getString(3));
					user.setName_Second(rs.getString(4));
					user.setEmail(rs.getString(5));
					return user;
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
		//ע�����û�
		public boolean AddUser(User user) {
			String sql = "insert into user(id,pwd,name_first,name_second,email) values(?,?,?,?,?)";
			Object[] params = {user.getID(),user.getPWD(),user.getName_First(),user.getName_Second(),user.getEmail()};
			return DBUtil.executeUpdate(sql,params);
		}
		//�޸ĳ�ID�����Ϣ
		public boolean UpdateUser(User user) {
			String sql = "update user set pwd=?,name_first=?,name_second=?,email=? where id=?";
			Object[] params = {user.getPWD(),user.getName_First(),user.getName_Second(),user.getEmail(),user.getID()};
			return DBUtil.executeUpdate(sql,params);
		}
}
