package org.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.entity.Myuser;
import org.util.DBUtil;

public class MyUserDao {
	//用户登录
	public boolean isEixtMyUser(String id, String pwd) {
		return pwd.equals(QueryMyUserById(id).getPsw())?true:false;
	}
	//判断该用户是否已存在
	public boolean isEixtMyUser(String id) {
		return QueryMyUserById(id)==null?false:true;
	}
	//查询用户信息
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
	//注册新用户
	public boolean AddMyUser(Myuser user) {
		String sql = "insert into myuser(id,name,psw,age,phone,address,city) values(?,?,?,?,?,?,?)";
		Object[] params = {user.getId(),user.getName(),user.getPsw(),user.getAge(),user.getPhone(),user.getAddress(),user.getCity()};
		return DBUtil.executeUpdate(sql,params);
	}
	//修改除ID外的信息
	public boolean UpdateMyUser(Myuser user) {
		String sql = "update myuser set name=?,psw=?,age=?,phone=?,address=?,city=? where id=?";
		Object[] params = {user.getName(),user.getPsw(),user.getAge(),user.getPhone(),user.getAddress(),user.getCity(),user.getId()};
		return DBUtil.executeUpdate(sql,params);
	}
}
