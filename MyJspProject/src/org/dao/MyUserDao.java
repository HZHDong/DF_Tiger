package org.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.entity.Myuser;
import org.util.DBUtil;

public class MyUserDao {
	//�û���¼
	public boolean isEixtMyUser(String id, String pwd) {
		return pwd.equals(QueryMyUserById(id).getPsw())?true:false;
	}
	//�жϸ��û��Ƿ��Ѵ���
	public boolean isEixtMyUser(String id) {
		return QueryMyUserById(id)==null?false:true;
	}
	//��ѯ�û���Ϣ
	public Myuser QueryMyUserById(String id){
		String sql = "select * from myuser where id = ? ";
		Object[] params = {id};
		ResultSet rs = DBUtil.executeQuery(sql,params);
		try {
			if(rs.next()){
				Myuser myuser = new Myuser();
				myuser.setId(id);
				myuser.setName(rs.getString(2));
				myuser.setPsw(rs.getString(3));
				myuser.setAge(rs.getInt(4));
				myuser.setPhone(rs.getString(5));
				myuser.setAddress(rs.getString(6));
				myuser.setCity(rs.getString(7));
				return myuser;
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
	public boolean AddMyUser(Myuser user) {
		String sql = "insert into myuser(id,name,psw,age,phone,address,city) values(?,?,?,?,?,?,?)";
		Object[] params = {user.getId(),user.getName(),user.getPsw(),user.getAge(),user.getPhone(),user.getAddress(),user.getCity()};
		return DBUtil.executeUpdate(sql,params);
	}
	//�޸ĳ�ID�����Ϣ
	public boolean UpdateMyUser(Myuser user) {
		String sql = "update myuser set name=?,psw=?,age=?,phone=?,address=?,city=? where id=?";
		Object[] params = {user.getName(),user.getPsw(),user.getAge(),user.getPhone(),user.getAddress(),user.getCity(),user.getId()};
		return DBUtil.executeUpdate(sql,params);
	}
}
